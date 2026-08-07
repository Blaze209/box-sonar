package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.react.uimanager.ViewProps;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bJ#\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/FabVisibleNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", ViewProps.VISIBLE, "", "alignment", "Landroidx/compose/ui/Alignment;", "targetScale", "", "scaleAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "alphaAnimationSpec", "<init>", "(ZLandroidx/compose/ui/Alignment;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "scaleAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "alphaAnimatable", "updateNode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FabVisibleNode extends DelegatingNode implements LayoutModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private final Animatable<Float, AnimationVector1D> alphaAnimatable;
    private AnimationSpec<Float> alphaAnimationSpec;
    private final Animatable<Float, AnimationVector1D> scaleAnimatable;
    private AnimationSpec<Float> scaleAnimationSpec;
    private float targetScale;

    public FabVisibleNode(boolean z, Alignment alignment, float f, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2) {
        this.alignment = alignment;
        this.targetScale = f;
        this.scaleAnimationSpec = animationSpec;
        this.alphaAnimationSpec = animationSpec2;
        this.scaleAnimatable = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
        this.alphaAnimatable = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
        delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.material3.FabVisibleNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FabVisibleNode._init_$lambda$0(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    public /* synthetic */ FabVisibleNode(boolean z, Alignment alignment, float f, AnimationSpec animationSpec, AnimationSpec animationSpec2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, alignment, f, (i & 8) != 0 ? null : animationSpec, (i & 16) != 0 ? null : animationSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult _init_$lambda$0(FabVisibleNode fabVisibleNode, CacheDrawScope cacheDrawScope) {
        final GraphicsLayer graphicsLayerObtainGraphicsLayer = cacheDrawScope.obtainGraphicsLayer();
        final float f = cacheDrawScope.mo754toPx0680j_4(Dp.m9687constructorimpl(16));
        float f2 = 2.0f * f;
        long jM9869toIntSizeuvyYCjk = IntSizeKt.m9869toIntSizeuvyYCjk(Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m6349getSizeNHjbRc() >> 32)) + f2)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m6349getSizeNHjbRc() & 4294967295L)) + f2)) & 4294967295L)));
        long jM9869toIntSizeuvyYCjk2 = IntSizeKt.m9869toIntSizeuvyYCjk(cacheDrawScope.m6349getSizeNHjbRc());
        graphicsLayerObtainGraphicsLayer.m7497setTopLeftgyyYBs(IntOffset.m9809constructorimpl((((long) (-MathKt.roundToInt(f))) & 4294967295L) | (((long) (-MathKt.roundToInt(f))) << 32)));
        graphicsLayerObtainGraphicsLayer.setAlpha(fabVisibleNode.alphaAnimatable.getValue().floatValue());
        long j = 1;
        long jMo6288alignKFBX0sM = fabVisibleNode.alignment.mo6288alignKFBX0sM(IntSize.m9853constructorimpl((j & 4294967295L) | (j << 32)), jM9869toIntSizeuvyYCjk2, cacheDrawScope.getLayoutDirection());
        float fM9815getXimpl = IntOffset.m9815getXimpl(jMo6288alignKFBX0sM);
        graphicsLayerObtainGraphicsLayer.m7493setPivotOffsetk4lQ0M(Offset.m6574plusMKHz9U(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m9816getYimpl(jMo6288alignKFBX0sM))) & 4294967295L) | (Float.floatToRawIntBits(fM9815getXimpl) << 32)), Offset.m6561constructorimpl((4294967295L & ((long) Float.floatToRawIntBits(f))) | (Float.floatToRawIntBits(f) << 32))));
        graphicsLayerObtainGraphicsLayer.setScaleX(MathHelpersKt.lerp(fabVisibleNode.targetScale, 1.0f, fabVisibleNode.scaleAnimatable.getValue().floatValue()));
        graphicsLayerObtainGraphicsLayer.setScaleY(MathHelpersKt.lerp(fabVisibleNode.targetScale, 1.0f, fabVisibleNode.scaleAnimatable.getValue().floatValue()));
        CacheDrawScope.m6348recordTdoYBX4$default(cacheDrawScope, graphicsLayerObtainGraphicsLayer, null, null, jM9869toIntSizeuvyYCjk, new Function1() { // from class: androidx.compose.material3.FabVisibleNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FabVisibleNode.lambda$0$0$0(f, (ContentDrawScope) obj);
            }
        }, 3, null);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.FabVisibleNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FabVisibleNode.lambda$0$1(graphicsLayerObtainGraphicsLayer, (ContentDrawScope) obj);
            }
        });
    }

    static final Unit lambda$0$0$0(float f, ContentDrawScope contentDrawScope) {
        float f2;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().inset(f, f, f, f);
        try {
            contentDrawScope.drawContent();
            return Unit.INSTANCE;
        } finally {
            f2 = -f;
            contentDrawScope2.getDrawContext().getTransform().inset(f2, f2, f2, f2);
        }
    }

    static final Unit lambda$0$1(GraphicsLayer graphicsLayer, ContentDrawScope contentDrawScope) {
        GraphicsLayerKt.drawLayer(contentDrawScope, graphicsLayer);
        return Unit.INSTANCE;
    }

    public final void updateNode(boolean visible, Alignment alignment, float targetScale, AnimationSpec<Float> scaleAnimationSpec, AnimationSpec<Float> alphaAnimationSpec) {
        this.alignment = alignment;
        this.targetScale = targetScale;
        this.scaleAnimationSpec = scaleAnimationSpec;
        this.alphaAnimationSpec = alphaAnimationSpec;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(visible, scaleAnimationSpec, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass2(visible, alphaAnimationSpec, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.FabVisibleNode$updateNode$1, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.FabVisibleNode$updateNode$1", f = "FloatingActionButton.kt", i = {}, l = {1243}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $scaleAnimationSpec;
        final /* synthetic */ boolean $visible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$visible = z;
            this.$scaleAnimationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FabVisibleNode.this.new AnonymousClass1(this.$visible, this.$scaleAnimationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = FabVisibleNode.this.scaleAnimatable;
                Float fBoxFloat = Boxing.boxFloat(this.$visible ? 1.0f : 0.0f);
                FiniteAnimationSpec finiteAnimationSpecFastSpatialSpec = this.$scaleAnimationSpec;
                if (finiteAnimationSpecFastSpatialSpec == null) {
                    finiteAnimationSpecFastSpatialSpec = ((MotionScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(FabVisibleNode.this, MaterialTheme.INSTANCE.getLocalMotionScheme())).fastSpatialSpec();
                }
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fBoxFloat, finiteAnimationSpecFastSpatialSpec, null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.FabVisibleNode$updateNode$2, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.FabVisibleNode$updateNode$2", f = "FloatingActionButton.kt", i = {}, l = {1253}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $alphaAnimationSpec;
        final /* synthetic */ boolean $visible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$visible = z;
            this.$alphaAnimationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FabVisibleNode.this.new AnonymousClass2(this.$visible, this.$alphaAnimationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = FabVisibleNode.this.alphaAnimatable;
                Float fBoxFloat = Boxing.boxFloat(this.$visible ? 1.0f : 0.0f);
                FiniteAnimationSpec finiteAnimationSpecFastEffectsSpec = this.$alphaAnimationSpec;
                if (finiteAnimationSpecFastEffectsSpec == null) {
                    finiteAnimationSpecFastEffectsSpec = ((MotionScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(FabVisibleNode.this, MaterialTheme.INSTANCE.getLocalMotionScheme())).fastEffectsSpec();
                }
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fBoxFloat, finiteAnimationSpecFastEffectsSpec, null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo372measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        if (this.alphaAnimatable.getValue().floatValue() == 0.0f) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.material3.FabVisibleNode$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FabVisibleNode.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.FabVisibleNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FabVisibleNode.measure_3p2s80s$lambda$1(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
