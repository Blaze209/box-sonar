package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnimateBoundsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020+H\u0016J\u0014\u0010,\u001a\u00020\u0010*\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b5\u00106R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRJ\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/animation/BoundsAnimationModifierNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "onChooseMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "setLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "getOnChooseMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "setOnChooseMeasureConstraints", "(Lkotlin/jvm/functions/Function2;)V", "getAnimateMotionFrameOfReference", "()Z", "setAnimateMotionFrameOfReference", "(Z)V", "directManipulationParentsDirty", "boundsAnimation", "Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "isMeasurementApproachInProgress", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoundsAnimationModifierNode extends Modifier.Node implements ApproachLayoutModifierNode {
    public static final int $stable = 8;
    private boolean animateMotionFrameOfReference;
    private BoundsTransform boundsTransform;
    private LookaheadScope lookaheadScope;
    private Function2<? super IntSize, ? super Constraints, Constraints> onChooseMeasureConstraints;
    private boolean directManipulationParentsDirty = true;
    private final BoundsTransformDeferredAnimation boundsAnimation = new BoundsTransformDeferredAnimation();

    public BoundsAnimationModifierNode(LookaheadScope lookaheadScope, BoundsTransform boundsTransform, Function2<? super IntSize, ? super Constraints, Constraints> function2, boolean z) {
        this.lookaheadScope = lookaheadScope;
        this.boundsTransform = boundsTransform;
        this.onChooseMeasureConstraints = function2;
        this.animateMotionFrameOfReference = z;
    }

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public final void setLookaheadScope(LookaheadScope lookaheadScope) {
        this.lookaheadScope = lookaheadScope;
    }

    public final BoundsTransform getBoundsTransform() {
        return this.boundsTransform;
    }

    public final void setBoundsTransform(BoundsTransform boundsTransform) {
        this.boundsTransform = boundsTransform;
    }

    public final Function2<IntSize, Constraints, Constraints> getOnChooseMeasureConstraints() {
        return this.onChooseMeasureConstraints;
    }

    public final void setOnChooseMeasureConstraints(Function2<? super IntSize, ? super Constraints, Constraints> function2) {
        this.onChooseMeasureConstraints = function2;
    }

    public final boolean getAnimateMotionFrameOfReference() {
        return this.animateMotionFrameOfReference;
    }

    public final void setAnimateMotionFrameOfReference(boolean z) {
        this.animateMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean mo378isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        this.boundsAnimation.m383updateTargetSizeuvyYCjk(IntSizeKt.m9870toSizeozmzZPI(lookaheadSize));
        return !this.boundsAnimation.isIdle();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.directManipulationParentsDirty = true;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean isPlacementApproachInProgress(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        this.boundsAnimation.updateTargetOffsetAndAnimate(this.lookaheadScope, placementScope, getCoroutineScope(), this.directManipulationParentsDirty, this.animateMotionFrameOfReference, this.boundsTransform);
        this.directManipulationParentsDirty = this.animateMotionFrameOfReference;
        return !this.boundsAnimation.isIdle();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult mo377approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        long currentSize;
        if (this.boundsAnimation.getCurrentSize() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            currentSize = IntSizeKt.m9870toSizeozmzZPI(approachMeasureScope.mo8243getLookaheadSizeYbymL2g());
        } else {
            currentSize = this.boundsAnimation.getCurrentSize();
        }
        Rect value = this.boundsAnimation.getValue();
        if (value != null) {
            currentSize = value.m6602getSizeNHjbRc();
        }
        long jM9866roundToIntSizeuvyYCjk = IntSizeKt.m9866roundToIntSizeuvyYCjk(currentSize);
        long value2 = this.onChooseMeasureConstraints.invoke(IntSize.m9850boximpl(jM9866roundToIntSizeuvyYCjk), Constraints.m9627boximpl(j)).getValue();
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(value2);
        long jM9654constrain4WqzIAM = ConstraintsKt.m9654constrain4WqzIAM(value2, jM9866roundToIntSizeuvyYCjk);
        return MeasureScope.layout$default(approachMeasureScope, (int) (jM9654constrain4WqzIAM >> 32), (int) (jM9654constrain4WqzIAM & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.BoundsAnimationModifierNode$approachMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                long jM6604getTopLeftF1C5BW0;
                Rect value3 = this.this$0.boundsAnimation.getValue();
                LookaheadScope lookaheadScope = this.this$0.getLookaheadScope();
                BoundsAnimationModifierNode boundsAnimationModifierNode = this.this$0;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                Offset offsetM6558boximpl = coordinates != null ? Offset.m6558boximpl(lookaheadScope.getLookaheadScopeCoordinates(placementScope).mo8275localPositionOfS_NoaFU(coordinates, Offset.INSTANCE.m6585getZeroF1C5BW0(), boundsAnimationModifierNode.getAnimateMotionFrameOfReference())) : null;
                if (value3 != null) {
                    this.this$0.boundsAnimation.m382updateCurrentBoundstz77jQw(value3.m6604getTopLeftF1C5BW0(), value3.m6602getSizeNHjbRc());
                    jM6604getTopLeftF1C5BW0 = value3.m6604getTopLeftF1C5BW0();
                } else {
                    Rect currentBounds = this.this$0.boundsAnimation.getCurrentBounds();
                    jM6604getTopLeftF1C5BW0 = currentBounds != null ? currentBounds.m6604getTopLeftF1C5BW0() : Offset.INSTANCE.m6585getZeroF1C5BW0();
                }
                long jM6573minusMKHz9U = offsetM6558boximpl != null ? Offset.m6573minusMKHz9U(jM6604getTopLeftF1C5BW0, offsetM6558boximpl.m6579unboximpl()) : Offset.INSTANCE.m6585getZeroF1C5BW0();
                Placeable.PlacementScope.place$default(placementScope, placeableMo8265measureBRTryo0, Math.round(Float.intBitsToFloat((int) (jM6573minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (jM6573minusMKHz9U & 4294967295L))), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
