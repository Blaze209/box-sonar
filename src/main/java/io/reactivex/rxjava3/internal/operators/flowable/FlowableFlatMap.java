package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.QueueOverflowException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;

    public FlowableFlatMap(Flowable<T> source, Function<? super T, ? extends Publisher<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayErrors;
        this.maxConcurrency = maxConcurrency;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super U> s) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, s, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) subscribe(s, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> s, Function<? super T, ? extends Publisher<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        return new MergeSubscriber(s, mapper, delayErrors, maxConcurrency, bufferSize);
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends Publisher<? extends U>> mapper;
        final int maxConcurrency;
        volatile SimplePlainQueue<U> queue;
        final AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        Subscription upstream;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];

        MergeSubscriber(Subscriber<? super U> actual, Function<? super T, ? extends Publisher<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new AtomicLong();
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
            this.bufferSize = bufferSize;
            this.scalarLimit = Math.max(1, maxConcurrency >> 1);
            atomicReference.lazySet(EMPTY);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    s.request(Long.MAX_VALUE);
                } else {
                    s.request(i);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                Publisher publisher = (Publisher) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (publisher instanceof Supplier) {
                    try {
                        Object obj = ((Supplier) publisher).get();
                        if (obj != null) {
                            tryEmitScalar(obj);
                            return;
                        }
                        if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                            return;
                        }
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.errors.tryAddThrowableOrReport(th);
                        drain();
                        return;
                    }
                }
                int i3 = this.bufferSize;
                long j = this.uniqueId;
                this.uniqueId = 1 + j;
                InnerSubscriber innerSubscriber = new InnerSubscriber(this, i3, j);
                if (addInner(innerSubscriber)) {
                    publisher.subscribe(innerSubscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        boolean addInner(InnerSubscriber<T, U> inner) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    inner.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = inner;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerSubscriber<T, U> inner) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriberArr[i] == inner) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        SimpleQueue<U> getMainQueue() {
            SimplePlainQueue<U> spscArrayQueue = this.queue;
            if (spscArrayQueue == null) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    spscArrayQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
                } else {
                    spscArrayQueue = new SpscArrayQueue<>(this.maxConcurrency);
                }
                this.queue = spscArrayQueue;
            }
            return spscArrayQueue;
        }

        void tryEmitScalar(U value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                SimpleQueue<U> mainQueue = this.queue;
                if (j != 0 && (mainQueue == null || mainQueue.isEmpty())) {
                    this.downstream.onNext(value);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                        }
                    }
                } else {
                    if (mainQueue == null) {
                        mainQueue = getMainQueue();
                    }
                    if (!mainQueue.offer(value)) {
                        onError(new QueueOverflowException());
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(value)) {
                onError(new QueueOverflowException());
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        void tryEmit(U value, InnerSubscriber<T, U> inner) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                SimpleQueue spscArrayQueue = inner.queue;
                if (j != 0 && (spscArrayQueue == null || spscArrayQueue.isEmpty())) {
                    this.downstream.onNext(value);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.requestMore(1L);
                } else {
                    if (spscArrayQueue == null) {
                        spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                        inner.queue = spscArrayQueue;
                    }
                    if (!spscArrayQueue.offer(value)) {
                        onError(new QueueOverflowException());
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue spscArrayQueue2 = inner.queue;
                if (spscArrayQueue2 == null) {
                    spscArrayQueue2 = new SpscArrayQueue(this.bufferSize);
                    inner.queue = spscArrayQueue2;
                }
                if (!spscArrayQueue2.offer(value)) {
                    onError(new QueueOverflowException());
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                if (!this.delayErrors) {
                    for (InnerSubscriber<?, ?> innerSubscriber : this.subscribers.getAndSet(CANCELLED)) {
                        innerSubscriber.dispose();
                    }
                }
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
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
            SimplePlainQueue<U> simplePlainQueue;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.queue) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code duplicated, block: B:102:0x015d  */
        /* JADX WARN: Code duplicated, block: B:106:0x0166  */
        /* JADX WARN: Code duplicated, block: B:108:0x016c  */
        /* JADX WARN: Code duplicated, block: B:123:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:128:0x01a3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:129:0x01a3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:131:0x01a3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:140:0x0174 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:141:0x0177 A[EDGE_INSN: B:141:0x0177->B:111:0x0177 BREAK  A[LOOP:2: B:56:0x00b9->B:109:0x016d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:144:0x016d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:147:0x00ca A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:149:0x0117 A[EDGE_INSN: B:149:0x0117->B:82:0x0117 BREAK  A[LOOP:4: B:65:0x00d5->B:73:0x00e8], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:60:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:64:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:67:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:73:0x00e8 A[LOOP:4: B:65:0x00d5->B:73:0x00e8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:84:0x011b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:85:0x011d  */
        /* JADX WARN: Code duplicated, block: B:86:0x0128  */
        /* JADX WARN: Code duplicated, block: B:88:0x0135  */
        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            boolean z;
            long j;
            int i;
            long j2;
            boolean z2;
            long j3;
            int i2;
            int i3;
            boolean z3;
            InnerSubscriber<T, U> innerSubscriber;
            U uPoll;
            SimpleQueue<U> simpleQueue;
            int i4;
            boolean z4;
            long j4;
            long jAddAndGet;
            Subscriber<? super U> subscriber = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminate()) {
                SimplePlainQueue<U> simplePlainQueue = this.queue;
                long jAddAndGet2 = this.requested.get();
                boolean z5 = jAddAndGet2 == Long.MAX_VALUE;
                if (simplePlainQueue != null) {
                    long j5 = 0;
                    j = 0;
                    while (true) {
                        if (jAddAndGet2 == 0) {
                            z = true;
                            break;
                        }
                        z = true;
                        U uPoll2 = simplePlainQueue.poll();
                        if (checkTerminate()) {
                            return;
                        }
                        if (uPoll2 == null) {
                            break;
                        }
                        subscriber.onNext(uPoll2);
                        j++;
                        j5++;
                        jAddAndGet2--;
                    }
                    if (j5 != 0) {
                        jAddAndGet2 = z5 ? Long.MAX_VALUE : this.requested.addAndGet(-j5);
                    }
                } else {
                    z = true;
                    j = 0;
                }
                boolean z6 = this.done;
                SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (z6 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                    this.errors.tryTerminateConsumer(this.downstream);
                    return;
                }
                if (length != 0) {
                    long j6 = this.lastId;
                    int i5 = this.lastIndex;
                    if (length > i5) {
                        j2 = 0;
                        if (innerSubscriberArr[i5].id != j6) {
                        }
                        j3 = jAddAndGet2;
                        i2 = 0;
                        i3 = i5;
                        z3 = false;
                        while (true) {
                            if (i2 < length) {
                                i = iAddAndGet;
                                innerSubscriberArr = innerSubscriberArr;
                                break;
                            }
                            if (checkTerminate()) {
                                return;
                            }
                            innerSubscriber = innerSubscriberArr[i3];
                            uPoll = null;
                            while (true) {
                                simpleQueue = innerSubscriber.queue;
                                if (simpleQueue != null) {
                                    i = iAddAndGet;
                                    i2 = i2;
                                    innerSubscriberArr = innerSubscriberArr;
                                    break;
                                }
                                i = iAddAndGet;
                                j4 = j2;
                                while (j3 != j2) {
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    try {
                                        uPoll = simpleQueue.poll();
                                        if (uPoll == null) {
                                            break;
                                        }
                                        subscriber.onNext(uPoll);
                                        j3--;
                                        j4++;
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        innerSubscriber.dispose();
                                        this.errors.tryAddThrowableOrReport(th);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerSubscriber);
                                        i4 = i2 + 1;
                                        innerSubscriberArr = innerSubscriberArr;
                                        z3 = z;
                                    }
                                }
                                if (j4 != j2) {
                                    if (z5) {
                                        jAddAndGet = Long.MAX_VALUE;
                                    } else {
                                        jAddAndGet = this.requested.addAndGet(-j4);
                                    }
                                    innerSubscriber.requestMore(j4);
                                    j3 = jAddAndGet;
                                } else {
                                    i2 = i2;
                                    innerSubscriberArr = innerSubscriberArr;
                                }
                                if (j3 == j2 || uPoll == null) {
                                    break;
                                }
                                innerSubscriberArr = innerSubscriberArr;
                                iAddAndGet = i;
                                i2 = i2;
                            }
                            z4 = innerSubscriber.done;
                            SimpleQueue<U> simpleQueue2 = innerSubscriber.queue;
                            if (z4 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                removeInner(innerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                j++;
                                z3 = z;
                            }
                            if (j3 == j2) {
                                break;
                            }
                            i3++;
                            i4 = i2;
                            if (i3 == length) {
                                i3 = 0;
                            }
                            i2 = i4 + 1;
                            innerSubscriberArr = innerSubscriberArr;
                            iAddAndGet = i;
                        }
                        z2 = z3;
                        this.lastIndex = i3;
                        this.lastId = innerSubscriberArr[i3].id;
                    } else {
                        j2 = 0;
                    }
                    if (length <= i5) {
                        i5 = 0;
                    }
                    for (int i6 = 0; i6 < length && innerSubscriberArr[i5].id != j6; i6++) {
                        i5++;
                        if (i5 == length) {
                            i5 = 0;
                        }
                    }
                    this.lastIndex = i5;
                    this.lastId = innerSubscriberArr[i5].id;
                    j3 = jAddAndGet2;
                    i2 = 0;
                    i3 = i5;
                    z3 = false;
                    while (true) {
                        if (i2 < length) {
                            i = iAddAndGet;
                            innerSubscriberArr = innerSubscriberArr;
                            break;
                        }
                        if (checkTerminate()) {
                            return;
                        }
                        innerSubscriber = innerSubscriberArr[i3];
                        uPoll = null;
                        while (true) {
                            simpleQueue = innerSubscriber.queue;
                            if (simpleQueue != null) {
                                i = iAddAndGet;
                                j4 = j2;
                                while (j3 != j2) {
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    uPoll = simpleQueue.poll();
                                    if (uPoll == null) {
                                        break;
                                        break;
                                    } else {
                                        subscriber.onNext(uPoll);
                                        j3--;
                                        j4++;
                                    }
                                }
                                if (j4 != j2) {
                                    if (z5) {
                                        jAddAndGet = this.requested.addAndGet(-j4);
                                    } else {
                                        jAddAndGet = Long.MAX_VALUE;
                                    }
                                    innerSubscriber.requestMore(j4);
                                    j3 = jAddAndGet;
                                } else {
                                    i2 = i2;
                                    innerSubscriberArr = innerSubscriberArr;
                                }
                                if (j3 == j2) {
                                    break;
                                }
                                break;
                                break;
                            }
                            i = iAddAndGet;
                            i2 = i2;
                            innerSubscriberArr = innerSubscriberArr;
                            break;
                            innerSubscriberArr = innerSubscriberArr;
                            iAddAndGet = i;
                            i2 = i2;
                        }
                        z4 = innerSubscriber.done;
                        SimpleQueue<U> simpleQueue3 = innerSubscriber.queue;
                        if (z4) {
                            removeInner(innerSubscriber);
                            if (checkTerminate()) {
                                return;
                            }
                            j++;
                            z3 = z;
                        }
                        if (j3 == j2) {
                            break;
                            break;
                        }
                        i3++;
                        i4 = i2;
                        if (i3 == length) {
                            i3 = 0;
                        }
                        i2 = i4 + 1;
                        innerSubscriberArr = innerSubscriberArr;
                        iAddAndGet = i;
                    }
                    z2 = z3;
                    this.lastIndex = i3;
                    this.lastId = innerSubscriberArr[i3].id;
                } else {
                    i = iAddAndGet;
                    j2 = 0;
                    z2 = false;
                }
                long j7 = j;
                if (j7 != j2 && !this.cancelled) {
                    this.upstream.request(j7);
                }
                if (z2) {
                    iAddAndGet = i;
                } else {
                    iAddAndGet = addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            }
            if (this.delayErrors || this.errors.get() == null) {
                return false;
            }
            clearScalarQueue();
            this.errors.tryTerminateConsumer(this.downstream);
            return true;
        }

        void clearScalarQueue() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        void disposeAll() {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = this.subscribers;
            InnerSubscriber<?, ?>[] innerSubscriberArr = CANCELLED;
            InnerSubscriber<?, ?>[] andSet = atomicReference.getAndSet(innerSubscriberArr);
            if (andSet != innerSubscriberArr) {
                for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                    innerSubscriber.dispose();
                }
                this.errors.tryTerminateAndReport();
            }
        }

        void innerError(InnerSubscriber<T, U> inner, Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                inner.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber<?, ?> innerSubscriber : this.subscribers.getAndSet(CANCELLED)) {
                        innerSubscriber.dispose();
                    }
                }
                drain();
            }
        }
    }

    static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile SimpleQueue<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> parent, int bufferSize, long id) {
            this.id = id;
            this.parent = parent;
            this.bufferSize = bufferSize;
            this.limit = bufferSize >> 2;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) s;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = queueSubscription;
                    }
                }
                s.request(this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U t) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(t, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        void requestMore(long n) {
            if (this.fusionMode != 1) {
                long j = this.produced + n;
                if (j >= this.limit) {
                    this.produced = 0L;
                    get().request(j);
                } else {
                    this.produced = j;
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
