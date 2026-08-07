package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.WavyProgressIndicatorKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.internal.DeterminateCircularWavyProgressNode$cacheDrawNode$1$2", f = "CircularWavyProgressModifiers.kt", i = {}, l = {589}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DeterminateCircularWavyProgressNode$cacheDrawNode$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $targetAmplitude;
    int label;
    final /* synthetic */ DeterminateCircularWavyProgressNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeterminateCircularWavyProgressNode$cacheDrawNode$1$2(DeterminateCircularWavyProgressNode determinateCircularWavyProgressNode, float f, Continuation<? super DeterminateCircularWavyProgressNode$cacheDrawNode$1$2> continuation) {
        super(2, continuation);
        this.this$0 = determinateCircularWavyProgressNode;
        this.$targetAmplitude = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeterminateCircularWavyProgressNode$cacheDrawNode$1$2(this.this$0, this.$targetAmplitude, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeterminateCircularWavyProgressNode$cacheDrawNode$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AnimationSpec<Float> decreasingAmplitudeAnimationSpec;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable animatable = this.this$0.amplitudeAnimatable;
            if (animatable == null) {
                return Unit.INSTANCE;
            }
            Float fBoxFloat = Boxing.boxFloat(this.$targetAmplitude);
            if (((Number) animatable.getValue()).floatValue() < this.$targetAmplitude) {
                decreasingAmplitudeAnimationSpec = WavyProgressIndicatorKt.getIncreasingAmplitudeAnimationSpec();
            } else {
                decreasingAmplitudeAnimationSpec = WavyProgressIndicatorKt.getDecreasingAmplitudeAnimationSpec();
            }
            AnimationSpec<Float> animationSpec = decreasingAmplitudeAnimationSpec;
            final DeterminateCircularWavyProgressNode determinateCircularWavyProgressNode = this.this$0;
            this.label = 1;
            if (Animatable.animateTo$default(animatable, fBoxFloat, animationSpec, null, new Function1() { // from class: androidx.compose.material3.internal.DeterminateCircularWavyProgressNode$cacheDrawNode$1$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DeterminateCircularWavyProgressNode$cacheDrawNode$1$2.invokeSuspend$lambda$0(determinateCircularWavyProgressNode, (Animatable) obj2);
                }
            }, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.$targetAmplitude == 0.0f) {
            this.this$0.stopOffsetAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(DeterminateCircularWavyProgressNode determinateCircularWavyProgressNode, Animatable animatable) {
        determinateCircularWavyProgressNode.amplitudeState.setFloatValue(((Number) animatable.getValue()).floatValue());
        return Unit.INSTANCE;
    }
}
