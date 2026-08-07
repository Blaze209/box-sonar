package io.reactivex.rxjava3.internal.operators.observable;

import android.R;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

    public ObservableSwitchMap(ObservableSource<T> source, Function<? super T, ? extends ObservableSource<? extends R>> mapper, int bufferSize, boolean delayErrors) {
        super(source);
        this.mapper = mapper;
        this.bufferSize = bufferSize;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> t) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, t, this.mapper)) {
            return;
        }
        this.source.subscribe(new SwitchMapObserver(t, this.mapper, this.bufferSize, this.delayErrors));
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        volatile long unique;
        Disposable upstream;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        SwitchMapObserver(Observer<? super R> actual, Function<? super T, ? extends ObservableSource<? extends R>> mapper, int bufferSize, boolean delayErrors) {
            this.downstream = actual;
            this.mapper = mapper;
            this.bufferSize = bufferSize;
            this.delayErrors = delayErrors;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                ObservableSource observableSource = (ObservableSource) Objects.requireNonNull(this.mapper.apply(t), "The ObservableSource returned is null");
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.active, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (!this.done && this.errors.tryAddThrowable(t)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void disposeInner() {
            SwitchMapInnerObserver<T, R> andSet = this.active.getAndSet((SwitchMapInnerObserver<T, R>) CANCELLED);
            if (andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARN: Code duplicated, block: B:76:0x00bc A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:79:0x0010 A[SYNTHETIC] */
        void drain() {
            SimpleQueue<R> simpleQueue;
            R.anim animVarPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.downstream;
            AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.active;
            boolean z = this.delayErrors;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.done) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        if (z2) {
                            Throwable th = this.errors.get();
                            if (th != null) {
                                observer.onError(th);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        this.errors.tryTerminateConsumer(observer);
                        return;
                    } else if (z2) {
                        observer.onComplete();
                        return;
                    }
                }
                SwitchMapInnerObserver<T, R> switchMapInnerObserver = atomicReference.get();
                if (switchMapInnerObserver != null && (simpleQueue = switchMapInnerObserver.queue) != null) {
                    boolean z3 = false;
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == atomicReference.get()) {
                            if (!z && this.errors.get() != null) {
                                this.errors.tryTerminateConsumer(observer);
                                return;
                            }
                            boolean z4 = switchMapInnerObserver.done;
                            try {
                                animVarPoll = simpleQueue.poll();
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.errors.tryAddThrowableOrReport(th2);
                                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, switchMapInnerObserver, null);
                                if (!z) {
                                    disposeInner();
                                    this.upstream.dispose();
                                    this.done = true;
                                } else {
                                    switchMapInnerObserver.cancel();
                                }
                                z3 = true;
                                animVarPoll = null;
                            }
                            boolean z5 = animVarPoll == null;
                            if (z4 && z5) {
                                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, switchMapInnerObserver, null);
                            } else if (!z5) {
                                observer.onNext(animVarPoll);
                            }
                            if (z3) {
                                continue;
                            }
                        }
                        z3 = true;
                        if (z3) {
                            continue;
                        }
                    }
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void innerError(SwitchMapInnerObserver<T, R> inner, Throwable ex) {
            if (inner.index == this.unique && this.errors.tryAddThrowable(ex)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.done = true;
                }
                inner.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(ex);
        }
    }

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> parent, long index, int bufferSize) {
            this.parent = parent;
            this.index = index;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d)) {
                if (d instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) d;
                    int iRequestFusion = queueDisposable.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (iRequestFusion == 2) {
                        this.queue = queueDisposable;
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(R t) {
            SimpleQueue<R> simpleQueue = this.queue;
            if (this.index != this.parent.unique || simpleQueue == null) {
                return;
            }
            if (t != null) {
                simpleQueue.offer(t);
            }
            this.parent.drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.parent.innerError(this, t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }
    }
}
