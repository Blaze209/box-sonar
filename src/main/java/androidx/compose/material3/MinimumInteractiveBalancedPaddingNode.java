package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010!\u001a\u00020\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/material3/MinimumInteractiveBalancedPaddingNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "hasVisibleLeadingContent", "", "hasVisibleTrailingContent", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(ZZLandroidx/compose/animation/core/AnimationSpec;)V", "getHasVisibleLeadingContent", "()Z", "setHasVisibleLeadingContent", "(Z)V", "getHasVisibleTrailingContent", "setHasVisibleTrailingContent", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "paddingAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "updateAnimation", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MinimumInteractiveBalancedPaddingNode extends Modifier.Node implements LayoutModifierNode {
    private AnimationSpec<Float> animationSpec;
    private boolean hasVisibleLeadingContent;
    private boolean hasVisibleTrailingContent;
    private Animatable<Float, AnimationVector1D> paddingAnimation;

    public MinimumInteractiveBalancedPaddingNode(boolean z, boolean z2, AnimationSpec<Float> animationSpec) {
        this.hasVisibleLeadingContent = z;
        this.hasVisibleTrailingContent = z2;
        this.animationSpec = animationSpec;
        this.paddingAnimation = AnimatableKt.Animatable$default((z || z2) ? 0.0f : 1.0f, 0.0f, 2, null);
    }

    public final boolean getHasVisibleLeadingContent() {
        return this.hasVisibleLeadingContent;
    }

    public final void setHasVisibleLeadingContent(boolean z) {
        this.hasVisibleLeadingContent = z;
    }

    public final boolean getHasVisibleTrailingContent() {
        return this.hasVisibleTrailingContent;
    }

    public final void setHasVisibleTrailingContent(boolean z) {
        this.hasVisibleTrailingContent = z;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final void setAnimationSpec(AnimationSpec<Float> animationSpec) {
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo372measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f;
        float f2;
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
        if (this.hasVisibleLeadingContent && this.hasVisibleTrailingContent) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            float fFloatValue = this.paddingAnimation.getValue().floatValue();
            int i = placeableMo8265measureBRTryo0.get(InteractiveComponentSizeKt.getMinimumInteractiveTopAlignmentLine());
            f = i != Integer.MIN_VALUE ? i * fFloatValue : 0.0f;
            int i2 = placeableMo8265measureBRTryo0.get(InteractiveComponentSizeKt.getMinimumInteractiveLeftAlignmentLine());
            f2 = i2 != Integer.MIN_VALUE ? i2 * fFloatValue : 0.0f;
        }
        float f3 = 2;
        final int width = placeableMo8265measureBRTryo0.getWidth() + Math.round(RangesKt.coerceAtLeast((f - f2) * f3, 0.0f));
        final int height = placeableMo8265measureBRTryo0.getHeight() + Math.round(RangesKt.coerceAtLeast((f2 - f) * f3, 0.0f));
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.material3.MinimumInteractiveBalancedPaddingNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MinimumInteractiveBalancedPaddingNode.measure_3p2s80s$lambda$2(placeableMo8265measureBRTryo0, width, height, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(Placeable placeable, int i, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, (i - placeable.getWidth()) / 2, (i2 - placeable.getHeight()) / 2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.MinimumInteractiveBalancedPaddingNode$updateAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingToolbar.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.MinimumInteractiveBalancedPaddingNode$updateAnimation$1", f = "FloatingToolbar.kt", i = {}, l = {2155, 2157}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MinimumInteractiveBalancedPaddingNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        
            if (r13 == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        
            if (r13 == r0) goto L20;
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
                goto L7a
            L12:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L1b:
                kotlin.ResultKt.throwOnFailure(r13)
                goto L55
            L1f:
                kotlin.ResultKt.throwOnFailure(r13)
                androidx.compose.material3.MinimumInteractiveBalancedPaddingNode r13 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.this
                boolean r13 = r13.getHasVisibleLeadingContent()
                if (r13 != 0) goto L58
                androidx.compose.material3.MinimumInteractiveBalancedPaddingNode r13 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.this
                boolean r13 = r13.getHasVisibleTrailingContent()
                if (r13 != 0) goto L58
                androidx.compose.material3.MinimumInteractiveBalancedPaddingNode r13 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.this
                androidx.compose.animation.core.Animatable r4 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.access$getPaddingAnimation$p(r13)
                r13 = 1065353216(0x3f800000, float:1.0)
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
                androidx.compose.material3.MinimumInteractiveBalancedPaddingNode r13 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.this
                androidx.compose.animation.core.AnimationSpec r6 = r13.getAnimationSpec()
                r9 = r12
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r12.label = r3
                r7 = 0
                r8 = 0
                r10 = 12
                r11 = 0
                java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L55
                goto L79
            L55:
                androidx.compose.animation.core.AnimationResult r13 = (androidx.compose.animation.core.AnimationResult) r13
                goto L7c
            L58:
                androidx.compose.material3.MinimumInteractiveBalancedPaddingNode r13 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.this
                androidx.compose.animation.core.Animatable r3 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.access$getPaddingAnimation$p(r13)
                r13 = 0
                java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
                androidx.compose.material3.MinimumInteractiveBalancedPaddingNode r13 = androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.this
                androidx.compose.animation.core.AnimationSpec r5 = r13.getAnimationSpec()
                r8 = r12
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r12.label = r2
                r6 = 0
                r7 = 0
                r9 = 12
                r10 = 0
                java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
                if (r13 != r0) goto L7a
            L79:
                return r0
            L7a:
                androidx.compose.animation.core.AnimationResult r13 = (androidx.compose.animation.core.AnimationResult) r13
            L7c:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MinimumInteractiveBalancedPaddingNode.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void updateAnimation() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }
}
