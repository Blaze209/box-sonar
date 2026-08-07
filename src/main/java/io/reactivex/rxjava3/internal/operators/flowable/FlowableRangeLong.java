package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRangeLong extends Flowable<Long> {
    final long end;
    final long start;

    public FlowableRangeLong(long start, long count) {
        this.start = start;
        this.end = start + count;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> s) {
        if (s instanceof ConditionalSubscriber) {
            s.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) s, this.start, this.end));
        } else {
            s.onSubscribe(new RangeSubscription(s, this.start, this.end));
        }
    }

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        abstract void fastPath();

        @Override // io.reactivex.rxjava3.operators.QueueFuseable
        public final int requestFusion(int mode) {
            return mode & 1;
        }

        abstract void slowPath(long r);

        BaseRangeSubscription(long index, long end) {
            this.index = index;
            this.end = end;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public final Long poll() {
            long j = this.index;
            if (j == this.end) {
                return null;
            }
            this.index = 1 + j;
            return Long.valueOf(j);
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public final void clear() {
            this.index = this.end;
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

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Long> downstream;

        RangeSubscription(Subscriber<? super Long> actual, long index, long end) {
            super(index, end);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long j = this.end;
            Subscriber<? super Long> subscriber = this.downstream;
            for (long j2 = this.index; j2 != j; j2++) {
                if (this.cancelled) {
                    return;
                }
                subscriber.onNext(Long.valueOf(j2));
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r) {
            long j = this.end;
            long j2 = this.index;
            Subscriber<? super Long> subscriber = this.downstream;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == r || j2 == j) {
                        if (j2 == j) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        } else {
                            r = get();
                            if (j3 == r) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        subscriber.onNext(Long.valueOf(j2));
                        j3++;
                        j2++;
                    }
                }
                this.index = j2;
                r = addAndGet(-j3);
            } while (r != 0);
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> downstream;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> actual, long index, long end) {
            super(index, end);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long j = this.end;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
            for (long j2 = this.index; j2 != j; j2++) {
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Long.valueOf(j2));
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r) {
            long j = this.end;
            long j2 = this.index;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == r || j2 == j) {
                        if (j2 == j) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            r = get();
                            if (j3 == r) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j2))) {
                            j3++;
                        }
                        j2++;
                    }
                }
                this.index = j2;
                r = addAndGet(-j3);
            } while (r != 0);
        }
    }
}
