package kotlinx.coroutines.rx3;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: RxChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\n\u0012\u0006\u0012\u0004\b\u0002H\u00010\u00032\n\u0012\u0006\u0012\u0004\b\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/rx3/SubscriptionChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BufferedChannel;", "Lio/reactivex/rxjava3/core/Observer;", "Lio/reactivex/rxjava3/core/MaybeObserver;", "<init>", "()V", "_subscription", "Lkotlinx/atomicfu/AtomicRef;", "Lio/reactivex/rxjava3/disposables/Disposable;", "onClosedIdempotent", "", "onSubscribe", "sub", "onSuccess", "t", "(Ljava/lang/Object;)V", "onNext", "onComplete", "onError", "e", "", "kotlinx-coroutines-rx3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SubscriptionChannel<T> extends BufferedChannel<T> implements Observer<T>, MaybeObserver<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription$volatile");
    private volatile /* synthetic */ Object _subscription$volatile;

    private final /* synthetic */ Object get_subscription$volatile() {
        return this._subscription$volatile;
    }

    private final /* synthetic */ void set_subscription$volatile(Object obj) {
        this._subscription$volatile = obj;
    }

    public SubscriptionChannel() {
        super(Integer.MAX_VALUE, null, 2, null);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void onClosedIdempotent() {
        Disposable disposable = (Disposable) _subscription$volatile$FU.getAndSet(this, null);
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable sub) {
        _subscription$volatile$FU.set(this, sub);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(T t) {
        mo11206trySendJP2dKIU(t);
        close(null);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        mo11206trySendJP2dKIU(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        close(null);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable e) {
        close(e);
    }
}
