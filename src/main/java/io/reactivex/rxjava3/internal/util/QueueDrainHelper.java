package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> q, Subscriber<? super U> a, boolean delayError, Disposable dispose, QueueDrain<T, U> qd) {
        int iLeave = 1;
        while (true) {
            boolean zDone = qd.done();
            T tPoll = q.poll();
            boolean z = tPoll == null;
            SimplePlainQueue<T> simplePlainQueue = q;
            Subscriber<? super U> subscriber = a;
            boolean z2 = delayError;
            QueueDrain<T, U> queueDrain = qd;
            if (checkTerminated(zDone, z, subscriber, z2, simplePlainQueue, queueDrain)) {
                if (dispose != null) {
                    dispose.dispose();
                    return;
                }
                return;
            }
            if (!z) {
                long jRequested = queueDrain.requested();
                if (jRequested != 0) {
                    if (queueDrain.accept(subscriber, tPoll) && jRequested != Long.MAX_VALUE) {
                        queueDrain.produced(1L);
                    }
                } else {
                    simplePlainQueue.clear();
                    if (dispose != null) {
                        dispose.dispose();
                    }
                    subscriber.onError(MissingBackpressureException.createDefault());
                    return;
                }
            } else {
                iLeave = queueDrain.leave(-iLeave);
                if (iLeave == 0) {
                    return;
                }
            }
            a = subscriber;
            delayError = z2;
            q = simplePlainQueue;
            qd = queueDrain;
        }
    }

    public static <T, U> boolean checkTerminated(boolean d, boolean empty, Subscriber<?> s, boolean delayError, SimpleQueue<?> q, QueueDrain<T, U> qd) {
        if (qd.cancelled()) {
            q.clear();
            return true;
        }
        if (!d) {
            return false;
        }
        if (delayError) {
            if (!empty) {
                return false;
            }
            Throwable thError = qd.error();
            if (thError != null) {
                s.onError(thError);
            } else {
                s.onComplete();
            }
            return true;
        }
        Throwable thError2 = qd.error();
        if (thError2 != null) {
            q.clear();
            s.onError(thError2);
            return true;
        }
        if (!empty) {
            return false;
        }
        s.onComplete();
        return true;
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> q, Observer<? super U> a, boolean delayError, Disposable dispose, ObservableQueueDrain<T, U> qd) {
        int iLeave = 1;
        while (true) {
            SimplePlainQueue<T> simplePlainQueue = q;
            Observer<? super U> observer = a;
            boolean z = delayError;
            Disposable disposable = dispose;
            ObservableQueueDrain<T, U> observableQueueDrain = qd;
            if (checkTerminated(qd.done(), q.isEmpty(), observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                return;
            }
            while (true) {
                boolean zDone = observableQueueDrain.done();
                T tPoll = simplePlainQueue.poll();
                boolean z2 = tPoll == null;
                boolean z3 = z2;
                if (checkTerminated(zDone, z2, observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                    return;
                }
                if (z3) {
                    break;
                } else {
                    observableQueueDrain.accept(observer, tPoll);
                }
            }
            iLeave = observableQueueDrain.leave(-iLeave);
            if (iLeave == 0) {
                return;
            }
            a = observer;
            delayError = z;
            q = simplePlainQueue;
            dispose = disposable;
            qd = observableQueueDrain;
        }
    }

    public static <T, U> boolean checkTerminated(boolean d, boolean empty, Observer<?> observer, boolean delayError, SimpleQueue<?> q, Disposable disposable, ObservableQueueDrain<T, U> qd) {
        if (qd.cancelled()) {
            q.clear();
            disposable.dispose();
            return true;
        }
        if (!d) {
            return false;
        }
        if (delayError) {
            if (!empty) {
                return false;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            Throwable thError = qd.error();
            if (thError != null) {
                observer.onError(thError);
            } else {
                observer.onComplete();
            }
            return true;
        }
        Throwable thError2 = qd.error();
        if (thError2 != null) {
            q.clear();
            if (disposable != null) {
                disposable.dispose();
            }
            observer.onError(thError2);
            return true;
        }
        if (!empty) {
            return false;
        }
        if (disposable != null) {
            disposable.dispose();
        }
        observer.onComplete();
        return true;
    }

    public static <T> SimpleQueue<T> createQueue(int capacityHint) {
        if (capacityHint < 0) {
            return new SpscLinkedArrayQueue(-capacityHint);
        }
        return new SpscArrayQueue(capacityHint);
    }

    public static void request(Subscription s, int prefetch) {
        s.request(prefetch < 0 ? Long.MAX_VALUE : prefetch);
    }

    public static <T> boolean postCompleteRequest(long n, Subscriber<? super T> actual, Queue<T> queue, AtomicLong state, BooleanSupplier isCancelled) {
        long j;
        do {
            j = state.get();
        } while (!state.compareAndSet(j, BackpressureHelper.addCap(Long.MAX_VALUE & j, n) | (j & Long.MIN_VALUE)));
        if (j != Long.MIN_VALUE) {
            return false;
        }
        postCompleteDrain(n | Long.MIN_VALUE, actual, queue, state, isCancelled);
        return true;
    }

    static boolean isCancelled(BooleanSupplier cancelled) {
        try {
            return cancelled.getAsBoolean();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return true;
        }
    }

    static <T> boolean postCompleteDrain(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(tPoll);
                j2++;
            } else {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long jAddAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j2 = jAddAndGet & Long.MIN_VALUE;
                    j = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void postComplete(Subscriber<? super T> actual, Queue<T> queue, AtomicLong state, BooleanSupplier isCancelled) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            actual.onComplete();
            return;
        }
        if (postCompleteDrain(state.get(), actual, queue, state, isCancelled)) {
            return;
        }
        do {
            j = state.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j2 = j | Long.MIN_VALUE;
            }
        } while (!state.compareAndSet(j, j2));
        if (j != 0) {
            postCompleteDrain(j2, actual, queue, state, isCancelled);
        }
    }
}
