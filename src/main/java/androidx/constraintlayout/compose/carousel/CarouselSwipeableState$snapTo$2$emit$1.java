package androidx.constraintlayout.compose.carousel;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CarouselSwipeable.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2", f = "CarouselSwipeable.kt", i = {0}, l = {299}, m = "emit", n = {"this"}, s = {"L$0"})
final class CarouselSwipeableState$snapTo$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CarouselSwipeableState.C07912<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CarouselSwipeableState$snapTo$2$emit$1(CarouselSwipeableState.C07912<? super T> c07912, Continuation<? super CarouselSwipeableState$snapTo$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = c07912;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Map) null, (Continuation<? super Unit>) this);
    }
}
