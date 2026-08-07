package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] array;

    public FlowableFromArray(T[] array) {
        this.array = array;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        if (s instanceof ConditionalSubscriber) {
            s.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) s, this.array));
        } else {
            s.onSubscribe(new ArraySubscription(s, this.array));
        }
    }

    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        abstract void fastPath();

        @Override // io.reactivex.rxjava3.operators.QueueFuseable
        public final int requestFusion(int mode) {
            return mode & 1;
        }

        abstract void slowPath(long r);

        BaseArraySubscription(T[] array) {
            this.array = array;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public final T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            this.index = i + 1;
            return (T) Objects.requireNonNull(tArr[i], "array element is null");
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.add(this, n) == 0) {
                if (n == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(n);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> downstream;

        ArraySubscription(Subscriber<? super T> actual, T[] array) {
            super(array);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.downstream;
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    subscriber.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                subscriber.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long r) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            Subscriber<? super T> subscriber = this.downstream;
            do {
                long j = 0;
                while (true) {
                    if (j == r || i == length) {
                        if (i == length) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        } else {
                            r = get();
                            if (j == r) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        T t = tArr[i];
                        if (t == null) {
                            subscriber.onError(new NullPointerException("The element at index " + i + " is null"));
                            return;
                        } else {
                            subscriber.onNext(t);
                            j++;
                            i++;
                        }
                    }
                }
                this.index = i;
                r = addAndGet(-j);
            } while (r != 0);
        }
    }

    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> downstream;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> actual, T[] array) {
            super(array);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    conditionalSubscriber.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                conditionalSubscriber.tryOnNext(t);
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long r) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            do {
                long j = 0;
                while (true) {
                    if (j == r || i == length) {
                        if (i == length) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            r = get();
                            if (j == r) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        T t = tArr[i];
                        if (t == null) {
                            conditionalSubscriber.onError(new NullPointerException("The element at index " + i + " is null"));
                            return;
                        } else {
                            if (conditionalSubscriber.tryOnNext(t)) {
                                j++;
                            }
                            i++;
                        }
                    }
                }
                this.index = i;
                r = addAndGet(-j);
            } while (r != 0);
        }
    }
}
