package kotlinx.coroutines.rx3;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.reactive.PublishKt;

/* JADX INFO: compiled from: RxFlowable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001aV\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052/\b\u0001\u0010\u0006\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\f\" \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"rxFlowable", "Lio/reactivex/rxjava3/core/Flowable;", ExifInterface.GPS_DIRECTION_TRUE, "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Flowable;", "RX_HANDLER", "", "kotlinx-coroutines-rx3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RxFlowableKt {
    private static final Function2<Throwable, CoroutineContext, Unit> RX_HANDLER = RxFlowableKt$RX_HANDLER$1.INSTANCE;

    public static /* synthetic */ Flowable rxFlowable$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return rxFlowable(coroutineContext, function2);
    }

    public static final <T> Flowable<T> rxFlowable(CoroutineContext coroutineContext, Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (coroutineContext.get(Job.INSTANCE) != null) {
            throw new IllegalArgumentException(("Flowable context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + coroutineContext).toString());
        }
        return Flowable.fromPublisher(PublishKt.publishInternal(GlobalScope.INSTANCE, coroutineContext, RX_HANDLER, function2));
    }
}
