package io.reactivex.rxjava3.processors;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
    static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicInteger wip = new AtomicInteger();
    final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean refCount) {
        return new MulticastProcessor<>(bufferSize(), refCount);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize) {
        ObjectHelper.verifyPositive(bufferSize, "bufferSize");
        return new MulticastProcessor<>(bufferSize, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize, boolean refCount) {
        ObjectHelper.verifyPositive(bufferSize, "bufferSize");
        return new MulticastProcessor<>(bufferSize, refCount);
    }

    MulticastProcessor(int bufferSize, boolean refCount) {
        this.bufferSize = bufferSize;
        this.limit = bufferSize - (bufferSize >> 2);
        this.refcount = refCount;
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscArrayQueue(this.bufferSize);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.setOnce(this.upstream, s)) {
            if (s instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) s;
                int iRequestFusion = queueSubscription.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = queueSubscription;
                    s.request(this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            s.request(this.bufferSize);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
            ExceptionHelper.nullCheck(t, "onNext called with a null value.");
            if (!this.queue.offer(t)) {
                SubscriptionHelper.cancel(this.upstream);
                onError(MissingBackpressureException.createDefault());
                return;
            }
        }
        drain();
    }

    @CheckReturnValue
    public boolean offer(T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        if (this.done) {
            return false;
        }
        if (this.fusionMode == 0) {
            if (!this.queue.offer(t)) {
                return false;
            }
            drain();
            return true;
        }
        throw new IllegalStateException("offer() should not be called in fusion mode!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (!this.done) {
            this.error = t;
            this.done = true;
            drain();
            return;
        }
        RxJavaPlugins.onError(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        Throwable th;
        MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(s, this);
        s.onSubscribe(multicastSubscription);
        if (add(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                remove(multicastSubscription);
                return;
            } else {
                drain();
                return;
            }
        }
        if (this.done && (th = this.error) != null) {
            s.onError(th);
        } else {
            s.onComplete();
        }
    }

    boolean add(MulticastSubscription<T> inner) {
        MulticastSubscription<T>[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.subscribers.get();
            if (multicastSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = inner;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    void remove(MulticastSubscription<T> inner) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = this.subscribers.get();
            int length = multicastSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (multicastSubscriptionArr[i] == inner) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                if (this.refcount) {
                    if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, multicastSubscriptionArr, TERMINATED)) {
                        SubscriptionHelper.cancel(this.upstream);
                        this.done = true;
                        return;
                    }
                } else if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, multicastSubscriptionArr, EMPTY)) {
                    return;
                }
            } else {
                MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            }
        }
    }

    void drain() {
        T tPoll;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<MulticastSubscription<T>[]> atomicReference = this.subscribers;
        int i = this.consumed;
        int i2 = this.limit;
        int i3 = this.fusionMode;
        int iAddAndGet = 1;
        while (true) {
            SimpleQueue<T> simpleQueue = this.queue;
            if (simpleQueue != null) {
                MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int i4 = 0;
                    long jMin = -1;
                    for (MulticastSubscription<T> multicastSubscription : multicastSubscriptionArr) {
                        long j = multicastSubscription.get();
                        if (j >= 0) {
                            if (jMin == -1) {
                                jMin = j - multicastSubscription.emitted;
                            } else {
                                jMin = Math.min(jMin, j - multicastSubscription.emitted);
                            }
                        }
                    }
                    int i5 = i;
                    while (true) {
                        if (jMin > 0) {
                            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (multicastSubscriptionArr2 == TERMINATED) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr2) {
                                boolean z = this.done;
                                try {
                                    tPoll = simpleQueue.poll();
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    SubscriptionHelper.cancel(this.upstream);
                                    this.error = th;
                                    this.done = true;
                                    tPoll = null;
                                    z = true;
                                }
                                boolean z2 = tPoll == null;
                                if (z && z2) {
                                    Throwable th2 = this.error;
                                    if (th2 != null) {
                                        MulticastSubscription<T>[] andSet = atomicReference.getAndSet(TERMINATED);
                                        int length = andSet.length;
                                        while (i4 < length) {
                                            andSet[i4].onError(th2);
                                            i4++;
                                        }
                                        return;
                                    }
                                    MulticastSubscription<T>[] andSet2 = atomicReference.getAndSet(TERMINATED);
                                    int length2 = andSet2.length;
                                    while (i4 < length2) {
                                        andSet2[i4].onComplete();
                                        i4++;
                                    }
                                    return;
                                }
                                if (!z2) {
                                    for (MulticastSubscription<T> multicastSubscription2 : multicastSubscriptionArr) {
                                        multicastSubscription2.onNext(tPoll);
                                    }
                                    jMin--;
                                    if (i3 != 1 && (i5 = i5 + 1) == i2) {
                                        this.upstream.get().request(i2);
                                        i5 = 0;
                                    }
                                }
                            }
                            i = i5;
                        }
                        if (jMin == 0) {
                            MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                            MulticastSubscription<T>[] multicastSubscriptionArr4 = TERMINATED;
                            if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                                i = i5;
                            } else if (this.done && simpleQueue.isEmpty()) {
                                Throwable th3 = this.error;
                                if (th3 != null) {
                                    MulticastSubscription<T>[] andSet3 = atomicReference.getAndSet(multicastSubscriptionArr4);
                                    int length3 = andSet3.length;
                                    while (i4 < length3) {
                                        andSet3[i4].onError(th3);
                                        i4++;
                                    }
                                    return;
                                }
                                MulticastSubscription<T>[] andSet4 = atomicReference.getAndSet(multicastSubscriptionArr4);
                                int length4 = andSet4.length;
                                while (i4 < length4) {
                                    andSet4[i4].onComplete();
                                    i4++;
                                }
                                return;
                            }
                        }
                        i = i5;
                    }
                }
            }
            this.consumed = i;
            iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> actual, MulticastProcessor<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                long jAddCancel = BackpressureHelper.addCancel(this, n);
                if (jAddCancel == Long.MIN_VALUE || jAddCancel == Long.MAX_VALUE) {
                    return;
                }
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        void onError(Throwable t) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(t);
            }
        }

        void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
