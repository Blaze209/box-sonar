package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferedChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BufferedChannel;", "Lorg/reactivestreams/Subscriber;", "request", "", "<init>", "(I)V", "_subscription", "Lkotlinx/atomicfu/AtomicRef;", "Lorg/reactivestreams/Subscription;", "_requested", "Lkotlinx/atomicfu/AtomicInt;", "onReceiveEnqueued", "", "onReceiveDequeued", "onClosedIdempotent", "onSubscribe", "s", "onNext", "t", "(Ljava/lang/Object;)V", "onComplete", "onError", "e", "", "kotlinx-coroutines-reactive"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SubscriptionChannel<T> extends BufferedChannel<T> implements Subscriber<T> {
    private volatile /* synthetic */ int _requested$volatile;
    private volatile /* synthetic */ Object _subscription$volatile;
    private final int request;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _requested$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested$volatile");

    private final /* synthetic */ int get_requested$volatile() {
        return this._requested$volatile;
    }

    private final /* synthetic */ Object get_subscription$volatile() {
        return this._subscription$volatile;
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Object obj, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void set_requested$volatile(int i) {
        this._requested$volatile = i;
    }

    private final /* synthetic */ void set_subscription$volatile(Object obj) {
        this._subscription$volatile = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionChannel(int i) {
        super(Integer.MAX_VALUE, null, 2, 0 == true ? 1 : 0);
        this.request = i;
        if (i < 0) {
            throw new IllegalArgumentException(("Invalid request size: " + i).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void onReceiveEnqueued() {
        Subscription subscription;
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _requested$volatile$FU;
        while (true) {
            int i2 = atomicIntegerFieldUpdater.get(this);
            subscription = (Subscription) _subscription$volatile$FU.get(this);
            i = i2 - 1;
            if (subscription != null && i < 0) {
                if (i2 == this.request || _requested$volatile$FU.compareAndSet(this, i2, this.request)) {
                    break;
                }
            } else if (_requested$volatile$FU.compareAndSet(this, i2, i)) {
                return;
            }
        }
        subscription.request(this.request - i);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void onReceiveDequeued() {
        _requested$volatile$FU.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void onClosedIdempotent() {
        Subscription subscription = (Subscription) _subscription$volatile$FU.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        _subscription$volatile$FU.set(this, s);
        while (!isClosedForSend()) {
            int i = _requested$volatile$FU.get(this);
            if (i >= this.request) {
                return;
            }
            if (_requested$volatile$FU.compareAndSet(this, i, this.request)) {
                s.request(this.request - i);
                return;
            }
        }
        s.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        _requested$volatile$FU.decrementAndGet(this);
        mo11206trySendJP2dKIU(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        close(null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable e) {
        close(e);
    }
}
