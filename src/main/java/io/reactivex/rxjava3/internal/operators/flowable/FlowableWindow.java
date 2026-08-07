package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long size;
    final long skip;

    public FlowableWindow(Flowable<T> source, long size, long skip, int bufferSize) {
        super(source);
        this.size = size;
        this.skip = skip;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> s) {
        long j = this.skip;
        long j2 = this.size;
        if (j == j2) {
            this.source.subscribe((FlowableSubscriber) new WindowExactSubscriber(s, this.size, this.bufferSize));
        } else if (j > j2) {
            this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(s, this.size, this.skip, this.bufferSize));
        } else {
            this.source.subscribe((FlowableSubscriber) new WindowOverlapSubscriber(s, this.size, this.skip, this.bufferSize));
        }
    }

    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final int bufferSize;
        final Subscriber<? super Flowable<T>> downstream;
        long index;
        final AtomicBoolean once;
        final long size;
        Subscription upstream;
        UnicastProcessor<T> window;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> actual, long size, int bufferSize) {
            super(1);
            this.downstream = actual;
            this.size = size;
            this.once = new AtomicBoolean();
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j = this.index;
            UnicastProcessor<T> unicastProcessorCreate = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessorCreate = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessorCreate;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessorCreate);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j2 = j + 1;
            unicastProcessorCreate.onNext(t);
            if (j2 == this.size) {
                this.index = 0L;
                this.window = null;
                unicastProcessorCreate.onComplete();
            } else {
                this.index = j2;
            }
            if (flowableWindowSubscribeIntercept == null || !flowableWindowSubscribeIntercept.tryAbandon()) {
                return;
            }
            flowableWindowSubscribeIntercept.window.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                this.upstream.request(BackpressureHelper.multiplyCap(this.size, n));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final int bufferSize;
        final Subscriber<? super Flowable<T>> downstream;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        final long size;
        final long skip;
        Subscription upstream;
        UnicastProcessor<T> window;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> actual, long size, long skip, int bufferSize) {
            super(1);
            this.downstream = actual;
            this.size = size;
            this.skip = skip;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j = this.index;
            UnicastProcessor<T> unicastProcessorCreate = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessorCreate = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessorCreate;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessorCreate);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j2 = j + 1;
            if (unicastProcessorCreate != null) {
                unicastProcessorCreate.onNext(t);
            }
            if (j2 == this.size) {
                this.window = null;
                unicastProcessorCreate.onComplete();
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
            if (flowableWindowSubscribeIntercept == null || !flowableWindowSubscribeIntercept.tryAbandon()) {
                return;
            }
            flowableWindowSubscribeIntercept.window.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.size, n), BackpressureHelper.multiplyCap(this.skip - this.size, n - 1)));
                } else {
                    this.upstream.request(BackpressureHelper.multiplyCap(this.skip, n));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
        final AtomicLong requested;
        final long size;
        final long skip;
        Subscription upstream;
        final ArrayDeque<UnicastProcessor<T>> windows;
        final AtomicInteger wip;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> actual, long size, long skip, int bufferSize) {
            super(1);
            this.downstream = actual;
            this.size = size;
            this.skip = skip;
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            UnicastProcessor<T> unicastProcessorCreate;
            long j = this.index;
            if (j != 0 || this.cancelled) {
                unicastProcessorCreate = null;
            } else {
                getAndIncrement();
                unicastProcessorCreate = UnicastProcessor.create(this.bufferSize, this);
                this.windows.offer(unicastProcessorCreate);
            }
            long j2 = j + 1;
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (unicastProcessorCreate != null) {
                this.queue.offer(unicastProcessorCreate);
                drain();
            }
            long j3 = this.produced + 1;
            if (j3 == this.size) {
                this.produced = j3 - this.skip;
                UnicastProcessor<T> unicastProcessorPoll = this.windows.poll();
                if (unicastProcessorPoll != null) {
                    unicastProcessorPoll.onComplete();
                }
            } else {
                this.produced = j3;
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(t);
            }
            this.windows.clear();
            this.error = t;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Flowable<T>> subscriber = this.downstream;
            SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.queue;
            int iAddAndGet = 1;
            while (true) {
                if (this.cancelled) {
                    while (true) {
                        UnicastProcessor<T> unicastProcessorPoll = spscLinkedArrayQueue.poll();
                        if (unicastProcessorPoll == null) {
                            break;
                        } else {
                            unicastProcessorPoll.onComplete();
                        }
                    }
                } else {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            boolean z = this.done;
                            UnicastProcessor<T> unicastProcessorPoll2 = spscLinkedArrayQueue.poll();
                            boolean z2 = unicastProcessorPoll2 == null;
                            if (this.cancelled) {
                                continue;
                            } else {
                                if (checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                                    return;
                                }
                                if (!z2) {
                                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessorPoll2);
                                    subscriber.onNext(flowableWindowSubscribeIntercept);
                                    if (flowableWindowSubscribeIntercept.tryAbandon()) {
                                        unicastProcessorPoll2.onComplete();
                                    }
                                    j2++;
                                }
                            }
                        }
                        if (j2 == j) {
                            if (this.cancelled) {
                                continue;
                            } else if (checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                                return;
                            }
                        }
                        if (j2 != 0 && j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                    }
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<?> a, SpscLinkedArrayQueue<?> q) {
            if (!d) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                q.clear();
                a.onError(th);
                return true;
            }
            if (!empty) {
                return false;
            }
            a.onComplete();
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, n - 1)));
                } else {
                    this.upstream.request(BackpressureHelper.multiplyCap(this.skip, n));
                }
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
            drain();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }
}
