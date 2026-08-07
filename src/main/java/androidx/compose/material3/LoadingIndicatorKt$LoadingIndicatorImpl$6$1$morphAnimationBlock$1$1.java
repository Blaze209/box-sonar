package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
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
@DebugMetadata(c = "androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1", f = "LoadingIndicator.kt", i = {0, 0, 0, 1, 1}, l = {410, 411}, m = "invokeSuspend", n = {"$this$launch", "morphAnimationSpec", "deferred", "$this$launch", "morphAnimationSpec"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
final class LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentMorphIndex$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $morphProgress;
    final /* synthetic */ MutableFloatState $morphRotationTargetAngle$delegate;
    final /* synthetic */ List<Morph> $morphSequence;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1(Animatable<Float, AnimationVector1D> animatable, List<Morph> list, MutableIntState mutableIntState, MutableFloatState mutableFloatState, Continuation<? super LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1> continuation) {
        super(2, continuation);
        this.$morphProgress = animatable;
        this.$morphSequence = list;
        this.$currentMorphIndex$delegate = mutableIntState;
        this.$morphRotationTargetAngle$delegate = mutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1 loadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1 = new LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1(this.$morphProgress, this.$morphSequence, this.$currentMorphIndex$delegate, this.$morphRotationTargetAngle$delegate, continuation);
        loadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1.L$0 = obj;
        return loadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x007a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0090  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0090 -> B:12:0x004c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r12.L$1
            androidx.compose.animation.core.SpringSpec r1 = (androidx.compose.animation.core.SpringSpec) r1
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L4b
        L1a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L23:
            java.lang.Object r1 = r12.L$2
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            java.lang.Object r4 = r12.L$1
            androidx.compose.animation.core.SpringSpec r4 = (androidx.compose.animation.core.SpringSpec) r4
            java.lang.Object r5 = r12.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r13)
            goto L7d
        L33:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            r1 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r4 = 1058642330(0x3f19999a, float:0.6)
            r5 = 1128792064(0x43480000, float:200.0)
            androidx.compose.animation.core.SpringSpec r1 = androidx.compose.animation.core.AnimationSpecKt.spring(r4, r5, r1)
            r4 = r13
        L4b:
            r7 = r1
        L4c:
            androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1 r5 = new androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1$deferred$1
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6 = r12.$morphProgress
            java.util.List<androidx.graphics.shapes.Morph> r8 = r12.$morphSequence
            androidx.compose.runtime.MutableIntState r9 = r12.$currentMorphIndex$delegate
            androidx.compose.runtime.MutableFloatState r10 = r12.$morphRotationTargetAngle$delegate
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1 = r7
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r12.L$0 = r4
            r12.L$1 = r1
            r12.L$2 = r13
            r12.label = r3
            r6 = 650(0x28a, double:3.21E-321)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r6, r5)
            if (r5 != r0) goto L7a
            goto L8f
        L7a:
            r5 = r4
            r4 = r1
            r1 = r13
        L7d:
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r12.L$0 = r5
            r12.L$1 = r4
            r6 = 0
            r12.L$2 = r6
            r12.label = r2
            java.lang.Object r13 = r1.await(r13)
            if (r13 != r0) goto L90
        L8f:
            return r0
        L90:
            r7 = r4
            r4 = r5
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
