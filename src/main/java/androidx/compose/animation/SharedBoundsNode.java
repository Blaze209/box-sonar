package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SharedContentNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u000201H\u0016J#\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u001c\u0010>\u001a\u000201*\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\fH\u0002J)\u0010C\u001a\u000201*\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010D\u001a\u00020E2\u0006\u0010B\u001a\u00020\fH\u0000¢\u0006\u0002\bFJ\u0014\u0010G\u001a\u000206*\u0002072\u0006\u0010@\u001a\u00020AH\u0002J\u0017\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0016¢\u0006\u0004\bK\u0010LJ#\u0010M\u001a\u000206*\u00020N2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016¢\u0006\u0004\bO\u0010PJ\f\u0010Q\u001a\u000201*\u00020RH\u0016J\b\u0010S\u001a\u000201H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R$\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\nR\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001a\u001a\u0004\u0018\u00010$@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006T"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/animation/BoundsProvider;", "state", "Landroidx/compose/animation/SharedElementEntry;", "<init>", "(Landroidx/compose/animation/SharedElementEntry;)V", "boundsBeforeDetached", "Landroidx/compose/ui/geometry/Rect;", "lastBoundsInSharedTransitionScope", "getLastBoundsInSharedTransitionScope", "()Landroidx/compose/ui/geometry/Rect;", "calculateAlternativeTargetBounds", "targetBoundsBeforeDisposed", "approachCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getApproachCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlaced", "", "rootCoords", "getRootCoords", "value", "sharedElementEntry", "getSharedElementEntry", "()Landroidx/compose/animation/SharedElementEntry;", "setSharedElementEntry$animation", "requireLookaheadLayoutCoordinates", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "setup", "", "onAttach", "onDetach", "onReset", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachPlaceMatchBeyondTransition", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "currentBounds", "approachPlaceMatchInTransition", "targetData", "Landroidx/compose/animation/TargetData;", "approachPlaceMatchInTransition$animation", "approachPlace", "isMeasurementApproachInProgress", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode, ObserverModifierNode, BoundsProvider {
    public static final int $stable = 8;
    private Rect boundsBeforeDetached;
    private boolean isPlaced;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementEntry sharedElementEntry;

    public SharedBoundsNode(SharedElementEntry sharedElementEntry) {
        this.sharedElementEntry = sharedElementEntry;
        this.layer = sharedElementEntry.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementEntry));
    }

    @Override // androidx.compose.animation.BoundsProvider
    public Rect getLastBoundsInSharedTransitionScope() {
        if (getIsAttached()) {
            return !this.isPlaced ? this.boundsBeforeDetached : RectKt.m6609Recttz77jQw(LayoutCoordinates.m8272localPositionOfS_NoaFU$default(getRootCoords(), getApproachCoordinates(), 0L, false, 6, null), IntSizeKt.m9870toSizeozmzZPI(getApproachCoordinates().mo8273getSizeYbymL2g()));
        }
        return null;
    }

    @Override // androidx.compose.animation.BoundsProvider
    public Rect calculateAlternativeTargetBounds(Rect targetBoundsBeforeDisposed) {
        return this.sharedElementEntry.calculateTargetBounds(targetBoundsBeforeDisposed);
    }

    private final LayoutCoordinates getApproachCoordinates() {
        return DelegatableNodeKt.requireLayoutCoordinates(this);
    }

    private final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation();
    }

    public final SharedElementEntry getSharedElementEntry() {
        return this.sharedElementEntry;
    }

    public final void setSharedElementEntry$animation(SharedElementEntry sharedElementEntry) {
        if (Intrinsics.areEqual(sharedElementEntry, this.sharedElementEntry)) {
            return;
        }
        this.sharedElementEntry.setAttached(false);
        this.sharedElementEntry = sharedElementEntry;
        sharedElementEntry.setAttached(getIsAttached());
        if (getIsAttached()) {
            setup();
        }
    }

    private final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.sharedElementEntry.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    private final BoundsAnimation getBoundsAnimation() {
        return this.sharedElementEntry.getBoundsAnimation();
    }

    private final void setLayer(GraphicsLayer graphicsLayer) {
        if (graphicsLayer == null) {
            GraphicsLayer graphicsLayer2 = this.layer;
            if (graphicsLayer2 != null) {
                DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer2);
            }
        } else {
            this.sharedElementEntry.setLayer(graphicsLayer);
        }
        this.layer = graphicsLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement getSharedElement() {
        return this.sharedElementEntry.getSharedElement();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    private final void setup() {
        provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.sharedElementEntry);
        this.sharedElementEntry.setParentState((SharedElementEntry) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.isPlaced = false;
        this.sharedElementEntry.setBoundsProvider(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ObserverModifierNodeKt.observeReads(this, getSharedElement().getObservingVisibilityChange$animation());
        setup();
        this.sharedElementEntry.setAttached(true);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        LayoutCoordinates nullableRoot = getSharedElement().getScope().getNullableRoot();
        if (nullableRoot != null) {
            this.boundsBeforeDetached = (nullableRoot.isAttached() && this.isPlaced) ? RectKt.m6609Recttz77jQw(Offset.m6573minusMKHz9U(LayoutCoordinatesKt.positionInRoot(getApproachCoordinates()), LayoutCoordinatesKt.positionInRoot(nullableRoot)), IntSizeKt.m9870toSizeozmzZPI(getApproachCoordinates().mo8273getSizeYbymL2g())) : null;
        }
        setLayer(null);
        this.sharedElementEntry.setParentState(null);
        this.sharedElementEntry.setBoundsProvider(null);
        this.sharedElementEntry.setAttached(false);
        this.isPlaced = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        this.boundsBeforeDetached = null;
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
        }
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode, androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo372measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo8265measureBRTryo0, 0, 0, 0.0f, 4, null);
                this.getSharedElement().onLookaheadPlaced(placementScope, this.getSharedElementEntry());
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void approachPlaceMatchBeyondTransition(Placeable.PlacementScope placementScope, Placeable placeable, Rect rect) {
        long jM9826getZeronOccac;
        if (!getBoundsAnimation().getTarget()) {
            LayoutCoordinates coordinates = placementScope.getCoordinates();
            if (coordinates != null) {
                jM9826getZeronOccac = IntOffsetKt.m9832roundk4lQ0M(Offset.m6573minusMKHz9U(rect.m6604getTopLeftF1C5BW0(), getRootCoords().mo8274localPositionOfR5De75A(coordinates, Offset.INSTANCE.m6585getZeroF1C5BW0())));
            } else {
                jM9826getZeronOccac = IntOffset.INSTANCE.m9826getZeronOccac();
            }
            Placeable.PlacementScope.place$default(placementScope, placeable, IntOffset.m9815getXimpl(jM9826getZeronOccac), IntOffset.m9816getYimpl(jM9826getZeronOccac), 0.0f, 4, null);
            return;
        }
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
    }

    public final void approachPlaceMatchInTransition$animation(Placeable.PlacementScope placementScope, Placeable placeable, TargetData targetData, Rect rect) {
        Rect rectM6609Recttz77jQw;
        long jM6579unboximpl;
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates == null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            return;
        }
        boolean activeMatchFound = getSharedElement().getState$animation().getActiveMatchFound();
        long jMo8274localPositionOfR5De75A = getRootCoords().mo8274localPositionOfR5De75A(coordinates, Offset.INSTANCE.m6585getZeroF1C5BW0());
        if (!activeMatchFound) {
            getBoundsAnimation().animate(rect, SharedTransitionStateMachineKt.getTargetBounds(targetData), new BoundsTransform() { // from class: androidx.compose.animation.SharedBoundsNode$$ExternalSyntheticLambda0
                @Override // androidx.compose.animation.BoundsTransform
                public final FiniteAnimationSpec createAnimationSpec(Rect rect2, Rect rect3) {
                    return SharedBoundsNode.approachPlaceMatchInTransition$lambda$0(rect2, rect3);
                }
            });
        } else {
            BoundsAnimation.animate$default(getBoundsAnimation(), rect, SharedTransitionStateMachineKt.getTargetBounds(targetData), null, 4, null);
        }
        Rect value = getBoundsAnimation().getValue();
        Offset offsetM6558boximpl = value != null ? Offset.m6558boximpl(SharedTransitionStateMachineKt.calculateOffsetFromDirectManipulation(targetData, value)) : null;
        if (getBoundsAnimation().getTarget() || !activeMatchFound) {
            long jM6579unboximpl2 = offsetM6558boximpl != null ? offsetM6558boximpl.m6579unboximpl() : jMo8274localPositionOfR5De75A;
            if (offsetM6558boximpl == null) {
                rectM6609Recttz77jQw = RectKt.m6609Recttz77jQw(jMo8274localPositionOfR5De75A, IntSizeKt.m9870toSizeozmzZPI(coordinates.mo8273getSizeYbymL2g()));
            } else {
                rectM6609Recttz77jQw = RectKt.m6609Recttz77jQw(offsetM6558boximpl.m6579unboximpl(), value.m6602getSizeNHjbRc());
            }
            getSharedElement().getState$animation().updateBounds(rectM6609Recttz77jQw);
            jM6579unboximpl = jM6579unboximpl2;
        } else {
            jM6579unboximpl = offsetM6558boximpl != null ? offsetM6558boximpl.m6579unboximpl() : rect.m6604getTopLeftF1C5BW0();
        }
        long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(jM6579unboximpl, jMo8274localPositionOfR5De75A);
        Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(Float.intBitsToFloat((int) (jM6573minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (jM6573minusMKHz9U & 4294967295L))), 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec approachPlaceMatchInTransition$lambda$0(Rect rect, Rect rect2) {
        return AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    }

    private final MeasureResult approachPlace(MeasureScope measureScope, final Placeable placeable) {
        long jM9853constructorimpl;
        if (getSharedElement().getState$animation().getMatchIsOrHasBeenConfigured()) {
            jM9853constructorimpl = this.sharedElementEntry.getPlaceholderSize().mo426calculateSizeJyjRU_E(requireLookaheadLayoutCoordinates().mo8273getSizeYbymL2g(), IntSize.m9853constructorimpl((((long) placeable.getHeight()) & 4294967295L) | (((long) placeable.getWidth()) << 32)));
        } else {
            jM9853constructorimpl = IntSize.m9853constructorimpl((((long) placeable.getWidth()) << 32) | (((long) placeable.getHeight()) & 4294967295L));
        }
        return MeasureScope.layout$default(measureScope, (int) (jM9853constructorimpl >> 32), (int) (jM9853constructorimpl & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.approachPlace.1
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
                SharedBoundsNode.this.isPlaced = true;
                SharedBoundsNode.this.boundsBeforeDetached = null;
                SharedTransitionStateMachine.State state$animation = SharedBoundsNode.this.getSharedElement().getState$animation();
                if (!SharedBoundsNode.this.getSharedElementEntry().isEnabled()) {
                    Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                    return;
                }
                if (state$animation.getMatchIsOrHasBeenConfigured()) {
                    TargetData targetData = state$animation.getTargetData();
                    if (targetData == null) {
                        throw new IllegalArgumentException(("Match State is configured, but target data is null. State = " + state$animation).toString());
                    }
                    Rect currentBounds = state$animation.getCurrentBounds();
                    if (currentBounds != null) {
                        if (!SharedBoundsNode.this.getSharedElement().getScope().isTransitionActive()) {
                            SharedBoundsNode.this.approachPlaceMatchBeyondTransition(placementScope, placeable, currentBounds);
                            return;
                        } else {
                            SharedBoundsNode.this.approachPlaceMatchInTransition$animation(placementScope, placeable, targetData, currentBounds);
                            return;
                        }
                    }
                    throw new IllegalArgumentException(("Match State is configured, but current bounds is null. State = " + state$animation).toString());
                }
                Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI */
    public boolean mo378isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        return this.sharedElementEntry.isEnabled() && getSharedElement().getFoundMatch() && getSharedElement().getScope().isTransitionActive();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo377approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        Rect value = getBoundsAnimation().getValue();
        if (value == null) {
            value = getSharedElement().tryInitializingCurrentBounds();
        }
        if (value != null) {
            long jM9866roundToIntSizeuvyYCjk = IntSizeKt.m9866roundToIntSizeuvyYCjk(value.m6602getSizeNHjbRc());
            int i = (int) (jM9866roundToIntSizeuvyYCjk >> 32);
            int i2 = (int) (jM9866roundToIntSizeuvyYCjk & 4294967295L);
            if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
                throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getState$animation().getCurrentBounds()).toString());
            }
            j = Constraints.INSTANCE.m9650fixedJhjzzOo(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtLeast(i2, 0));
        }
        return approachPlace(approachMeasureScope, measurable.mo8265measureBRTryo0(j));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        final Rect currentBounds = getSharedElement().getState$animation().getCurrentBounds();
        SharedElementEntry sharedElementEntry = this.sharedElementEntry;
        sharedElementEntry.setClipPathInOverlay$animation((!sharedElementEntry.getShouldRenderInOverlay$animation() || currentBounds == null) ? null : this.sharedElementEntry.getOverlayClip().getClipPath(this.sharedElementEntry.getUserState(), currentBounds, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(this)));
        GraphicsLayer layer = this.sharedElementEntry.getLayer();
        if (layer == null) {
            throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + getSharedElement().getKey() + ",target: " + this.sharedElementEntry.getBoundsAnimation().getTarget() + ", is attached: " + getIsAttached()).toString());
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m7393recordJVtK1S4$default(contentDrawScope2, layer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.draw.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                contentDrawScope.drawContent();
            }
        }, 1, null);
        if (this.sharedElementEntry.getShouldRenderInPlace()) {
            GraphicsLayerKt.drawLayer(contentDrawScope2, layer);
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        getSharedElement().updateMatch$animation();
        ObserverModifierNodeKt.observeReads(this, getSharedElement().getObservingVisibilityChange$animation());
    }
}
