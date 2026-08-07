package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.QueueOverflowException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public ParallelJoin(ParallelFlowable<? extends T> source, int prefetch, boolean delayErrors) {
        this.source = source;
        this.prefetch = prefetch;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        JoinSubscriptionBase joinSubscription;
        if (this.delayErrors) {
            joinSubscription = new JoinSubscriptionDelayError(s, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscription = new JoinSubscription(s, this.source.parallelism(), this.prefetch);
        }
        s.onSubscribe(joinSubscription);
        this.source.subscribe(joinSubscription.subscribers);
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        final JoinInnerSubscriber<T>[] subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable e);

        abstract void onNext(JoinInnerSubscriber<T> inner, T value);

        JoinSubscriptionBase(Subscriber<? super T> actual, int n, int prefetch) {
            this.downstream = actual;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                joinInnerSubscriberArr[i] = new JoinInnerSubscriber<>(this, prefetch);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(n);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        void cancelAll() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.cancel();
            }
        }

        void cleanup() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> actual, int n, int prefetch) {
            super(actual, n, prefetch);
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> inner, T value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(value);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.request(1L);
                } else if (!inner.getQueue().offer(value)) {
                    cancelAll();
                    QueueOverflowException queueOverflowException = new QueueOverflowException();
                    if (this.errors.compareAndSet(null, queueOverflowException)) {
                        this.downstream.onError(queueOverflowException);
                        return;
                    } else {
                        RxJavaPlugins.onError(queueOverflowException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!inner.getQueue().offer(value)) {
                cancelAll();
                onError(new QueueOverflowException());
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable e) {
            if (this.errors.compareAndSet(null, e)) {
                cancelAll();
                drain();
            } else if (e != this.errors.get()) {
                RxJavaPlugins.onError(e);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        void drainLoop() {
            boolean z;
            long j;
            boolean z2;
            T tPoll;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.downstream;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                do {
                    z = false;
                    if (j3 == j2) {
                        j = 0;
                        break;
                    }
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th = this.errors.get();
                    if (th != null) {
                        cleanup();
                        subscriber.onError(th);
                        return;
                    }
                    boolean z3 = this.done.get() == 0;
                    z2 = true;
                    for (JoinInnerSubscriber<T> joinInnerSubscriber : joinInnerSubscriberArr) {
                        j = 0;
                        SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null && (tPoll = simplePlainQueue.poll()) != null) {
                            subscriber.onNext(tPoll);
                            joinInnerSubscriber.requestOne();
                            j3++;
                            if (j3 == j2) {
                                break;
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    j = 0;
                    if (z3 && z2) {
                        subscriber.onComplete();
                        return;
                    }
                } while (!z2);
                if (j3 == j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = this.errors.get();
                    if (th2 != null) {
                        cleanup();
                        subscriber.onError(th2);
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = true;
                            break;
                        }
                        SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i].queue;
                        if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z4 && z) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j3 != j) {
                    BackpressureHelper.produced(this.requested, j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> actual, int n, int prefetch) {
            super(actual, n, prefetch);
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onNext(JoinInnerSubscriber<T> inner, T value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(value);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.request(1L);
                } else if (!inner.getQueue().offer(value)) {
                    inner.cancel();
                    this.errors.tryAddThrowableOrReport(new QueueOverflowException());
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!inner.getQueue().offer(value)) {
                    inner.cancel();
                    this.errors.tryAddThrowableOrReport(new QueueOverflowException());
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.done.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        void drainLoop() {
            boolean z;
            long j;
            boolean z2;
            T tPoll;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.downstream;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                do {
                    z = false;
                    if (j3 == j2) {
                        j = 0;
                        break;
                    }
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z3 = this.done.get() == 0;
                    z2 = true;
                    for (JoinInnerSubscriber<T> joinInnerSubscriber : joinInnerSubscriberArr) {
                        j = 0;
                        SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null && (tPoll = simplePlainQueue.poll()) != null) {
                            subscriber.onNext(tPoll);
                            joinInnerSubscriber.requestOne();
                            j3++;
                            if (j3 == j2) {
                                break;
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    j = 0;
                    if (z3 && z2) {
                        this.errors.tryTerminateConsumer(subscriber);
                        return;
                    }
                } while (!z2);
                if (j3 == j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = true;
                            break;
                        }
                        SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i].queue;
                        if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z4 && z) {
                        this.errors.tryTerminateConsumer(subscriber);
                        return;
                    }
                }
                if (j3 != j) {
                    BackpressureHelper.produced(this.requested, j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> parent, int prefetch) {
            this.parent = parent;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, this.prefetch);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.parent.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
        }

        public void request(long n) {
            long j = this.produced + n;
            if (j >= this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }
    }
}
