package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableConcatMapMaybe(Flowable<T> source, Function<? super T, ? extends MaybeSource<? extends R>> mapper, ErrorMode errorMode, int prefetch) {
        this.source = source;
        this.mapper = mapper;
        this.errorMode = errorMode;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapMaybeSubscriber(s, this.mapper, this.prefetch, this.errorMode));
    }

    static final class ConcatMapMaybeSubscriber<T, R> extends ConcatMapXMainSubscriber<T> implements Subscription {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        int consumed;
        final Subscriber<? super R> downstream;
        long emitted;
        final ConcatMapMaybeObserver<R> inner;
        R item;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final AtomicLong requested;
        volatile int state;

        ConcatMapMaybeSubscriber(Subscriber<? super R> downstream, Function<? super T, ? extends MaybeSource<? extends R>> mapper, int prefetch, ErrorMode errorMode) {
            super(prefetch, errorMode);
            this.downstream = downstream;
            this.mapper = mapper;
            this.requested = new AtomicLong();
            this.inner = new ConcatMapMaybeObserver<>(this);
        }

        @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
        void onSubscribeDownstream() {
            this.downstream.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            BackpressureHelper.add(this.requested, n);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            stop();
        }

        void innerSuccess(R item) {
            this.item = item;
            this.state = 2;
            drain();
        }

        void innerComplete() {
            this.state = 0;
            drain();
        }

        void innerError(Throwable ex) {
            if (this.errors.tryAddThrowableOrReport(ex)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                this.state = 0;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
        void clearValue() {
            this.item = null;
        }

        @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
        void disposeInner() {
            this.inner.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode = this.errorMode;
            SimpleQueue<T> simpleQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicLong atomicLong = this.requested;
            int i = this.prefetch - (this.prefetch >> 1);
            boolean z = this.syncFused;
            int iAddAndGet = 1;
            while (true) {
                if (this.cancelled) {
                    simpleQueue.clear();
                    this.item = null;
                } else {
                    int i2 = this.state;
                    if (atomicThrowable.get() != null && (errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i2 == 0))) {
                        break;
                    }
                    if (i2 == 0) {
                        boolean z2 = this.done;
                        try {
                            T tPoll = simpleQueue.poll();
                            boolean z3 = tPoll == null;
                            if (z2 && z3) {
                                atomicThrowable.tryTerminateConsumer(subscriber);
                                return;
                            }
                            if (!z3) {
                                if (!z) {
                                    int i3 = this.consumed + 1;
                                    if (i3 == i) {
                                        this.consumed = 0;
                                        this.upstream.request(i);
                                    } else {
                                        this.consumed = i3;
                                    }
                                }
                                try {
                                    MaybeSource maybeSource = (MaybeSource) Objects.requireNonNull(this.mapper.apply(tPoll), "The mapper returned a null MaybeSource");
                                    this.state = 1;
                                    maybeSource.subscribe(this.inner);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.upstream.cancel();
                                    simpleQueue.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th);
                                    atomicThrowable.tryTerminateConsumer(subscriber);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.upstream.cancel();
                            atomicThrowable.tryAddThrowableOrReport(th2);
                            atomicThrowable.tryTerminateConsumer(subscriber);
                            return;
                        }
                    } else if (i2 == 2) {
                        long j = this.emitted;
                        if (j != atomicLong.get()) {
                            R r = this.item;
                            this.item = null;
                            subscriber.onNext(r);
                            this.emitted = j + 1;
                            this.state = 0;
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            simpleQueue.clear();
            this.item = null;
            atomicThrowable.tryTerminateConsumer(subscriber);
        }

        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapMaybeSubscriber<?, R> parent;

            ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.replace(this, d);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver
            public void onSuccess(R t) {
                this.parent.innerSuccess(t);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver
            public void onError(Throwable e) {
                this.parent.innerError(e);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
