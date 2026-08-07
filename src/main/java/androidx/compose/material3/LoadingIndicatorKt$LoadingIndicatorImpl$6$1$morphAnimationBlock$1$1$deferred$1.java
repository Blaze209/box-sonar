package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.graphics.shapes.Morph;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoadingIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1", f = "LoadingIndicator.kt", i = {}, l = {399, 405}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentMorphIndex$delegate;
    final /* synthetic */ SpringSpec<Float> $morphAnimationSpec;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $morphProgress;
    final /* synthetic */ MutableFloatState $morphRotationTargetAngle$delegate;
    final /* synthetic */ List<Morph> $morphSequence;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1(Animatable<Float, AnimationVector1D> animatable, SpringSpec<Float> springSpec, List<Morph> list, MutableIntState mutableIntState, MutableFloatState mutableFloatState, Continuation<? super LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1> continuation) {
        super(2, continuation);
        this.$morphProgress = animatable;
        this.$morphAnimationSpec = springSpec;
        this.$morphSequence = list;
        this.$currentMorphIndex$delegate = mutableIntState;
        this.$morphRotationTargetAngle$delegate = mutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1(this.$morphProgress, this.$morphAnimationSpec, this.$morphSequence, this.$currentMorphIndex$delegate, this.$morphRotationTargetAngle$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        if (r12.$morphProgress.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r12) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6e
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1b:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L40
        L1f:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r12.$morphProgress
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.compose.animation.core.SpringSpec<java.lang.Float> r13 = r12.$morphAnimationSpec
            r6 = r13
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.label = r3
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L40
            goto L6d
        L40:
            androidx.compose.animation.core.AnimationResult r13 = (androidx.compose.animation.core.AnimationResult) r13
            androidx.compose.animation.core.AnimationEndReason r13 = r13.getEndReason()
            androidx.compose.animation.core.AnimationEndReason r1 = androidx.compose.animation.core.AnimationEndReason.Finished
            if (r13 != r1) goto L7d
            androidx.compose.runtime.MutableIntState r13 = r12.$currentMorphIndex$delegate
            int r1 = androidx.compose.material3.LoadingIndicatorKt.access$LoadingIndicatorImpl_eopBjH0$lambda$9(r13)
            int r1 = r1 + r3
            java.util.List<androidx.graphics.shapes.Morph> r3 = r12.$morphSequence
            int r3 = r3.size()
            int r1 = r1 % r3
            androidx.compose.material3.LoadingIndicatorKt.access$LoadingIndicatorImpl_eopBjH0$lambda$10(r13, r1)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r13 = r12.$morphProgress
            r1 = 0
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r12.label = r2
            java.lang.Object r13 = r13.snapTo(r1, r3)
            if (r13 != r0) goto L6e
        L6d:
            return r0
        L6e:
            androidx.compose.runtime.MutableFloatState r12 = r12.$morphRotationTargetAngle$delegate
            float r13 = androidx.compose.material3.LoadingIndicatorKt.access$LoadingIndicatorImpl_eopBjH0$lambda$5(r12)
            r0 = 1119092736(0x42b40000, float:90.0)
            float r13 = r13 + r0
            r0 = 1135869952(0x43b40000, float:360.0)
            float r13 = r13 % r0
            androidx.compose.material3.LoadingIndicatorKt.access$LoadingIndicatorImpl_eopBjH0$lambda$6(r12, r13)
        L7d:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
