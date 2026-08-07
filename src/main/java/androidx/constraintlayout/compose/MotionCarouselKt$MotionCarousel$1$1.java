package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$1$1", f = "MotionCarousel.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
final class MotionCarouselKt$MotionCarousel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ androidx.compose.runtime.State<MotionItemsProvider> $provider;
    final /* synthetic */ MutableState<CarouselState> $state$delegate;
    final /* synthetic */ String $swipeStateStart;
    final /* synthetic */ CarouselSwipeableState<String> $swipeableState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MotionCarouselKt$MotionCarousel$1$1(androidx.compose.runtime.State<? extends MotionItemsProvider> state, CarouselSwipeableState<String> carouselSwipeableState, String str, MutableState<CarouselState> mutableState, Continuation<? super MotionCarouselKt$MotionCarousel$1$1> continuation) {
        super(2, continuation);
        this.$provider = state;
        this.$swipeableState = carouselSwipeableState;
        this.$swipeStateStart = str;
        this.$state$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MotionCarouselKt$MotionCarousel$1$1(this.$provider, this.$swipeableState, this.$swipeStateStart, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MotionCarouselKt$MotionCarousel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (MotionCarouselKt.MotionCarousel$lambda$4(this.$state$delegate).getIndex() + 1 < this.$provider.getValue().getItemsCount()) {
                CarouselState carouselStateMotionCarousel$lambda$4 = MotionCarouselKt.MotionCarousel$lambda$4(this.$state$delegate);
                carouselStateMotionCarousel$lambda$4.setIndex(carouselStateMotionCarousel$lambda$4.getIndex() + 1);
                this.label = 1;
                if (this.$swipeableState.snapTo(this.$swipeStateStart, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MotionCarouselKt.MotionCarousel$lambda$4(this.$state$delegate).setDirection(MotionCarouselDirection.FORWARD);
        return Unit.INSTANCE;
    }
}
