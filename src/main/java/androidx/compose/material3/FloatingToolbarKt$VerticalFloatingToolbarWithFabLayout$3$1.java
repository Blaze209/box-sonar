package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1 implements MeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-material3-FloatingToolbarVerticalFabPosition$-fabPosition$0, reason: not valid java name */
    final /* synthetic */ int f118x954c13dd;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-collapsedShadowElevation$0, reason: not valid java name */
    final /* synthetic */ float f119$$v$c$androidxcomposeuiunitDp$collapsedShadowElevation$0;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-expandedShadowElevation$0, reason: not valid java name */
    final /* synthetic */ float f120$$v$c$androidxcomposeuiunitDp$expandedShadowElevation$0;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-toolbarToFabGap$0, reason: not valid java name */
    final /* synthetic */ float f121$$v$c$androidxcomposeuiunitDp$toolbarToFabGap$0;
    final /* synthetic */ State<Float> $expandedProgress;
    final /* synthetic */ Shape $toolbarShape;

    FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1(State<Float> state, float f, int i, float f2, float f3, Shape shape) {
        this.$expandedProgress = state;
        this.f121$$v$c$androidxcomposeuiunitDp$toolbarToFabGap$0 = f;
        this.f118x954c13dd = i;
        this.f119$$v$c$androidxcomposeuiunitDp$collapsedShadowElevation$0 = f2;
        this.f120$$v$c$androidxcomposeuiunitDp$expandedShadowElevation$0 = f3;
        this.$toolbarShape = shape;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable = list.get(0);
        Measurable measurable2 = list.get(1);
        int i = measureScope.mo748roundToPx0680j_4(FloatingToolbarKt.lerp(FloatingToolbarDefaults.INSTANCE.getFabSizeRange$material3(), 1.0f - this.$expandedProgress.getValue().floatValue()));
        final Placeable placeableMo8265measureBRTryo0 = measurable2.mo8265measureBRTryo0(Constraints.m9629copyZbe2FdA(j, i, i, i, i));
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(measureScope.mo748roundToPx0680j_4(FloatingToolbarDefaults.INSTANCE.m3429getContainerSizeD9Ej5fM()));
        final Placeable placeableMo8265measureBRTryo1 = measurable.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(j, RangesKt.coerceIn(measureScope.mo748roundToPx0680j_4(FloatingToolbarDefaults.INSTANCE.m3429getContainerSizeD9Ej5fM()), 0, Constraints.m9642getMinWidthimpl(j)), 0, 0, RangesKt.coerceIn((int) RangesKt.coerceAtLeast(iMaxIntrinsicHeight * this.$expandedProgress.getValue().floatValue(), 0.0f), 0, Constraints.m9639getMaxHeightimpl(j)), 6, null));
        int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        int i2 = measureScope.mo748roundToPx0680j_4(this.f121$$v$c$androidxcomposeuiunitDp$toolbarToFabGap$0) + iMaxIntrinsicHeight + measureScope.mo748roundToPx0680j_4(((Dp) FloatingToolbarDefaults.INSTANCE.getFabSizeRange$material3().getStart()).m9701unboximpl());
        final int width = (iM9642getMinWidthimpl - placeableMo8265measureBRTryo1.getWidth()) / 2;
        final int width2 = (iM9642getMinWidthimpl - placeableMo8265measureBRTryo0.getWidth()) / 2;
        final int height = FloatingToolbarVerticalFabPosition.m3494equalsimpl0(this.f118x954c13dd, FloatingToolbarVerticalFabPosition.INSTANCE.m3498getBottomdDJPGzU()) ? i2 - placeableMo8265measureBRTryo0.getHeight() : 0;
        final int height2 = FloatingToolbarVerticalFabPosition.m3494equalsimpl0(this.f118x954c13dd, FloatingToolbarVerticalFabPosition.INSTANCE.m3498getBottomdDJPGzU()) ? iMaxIntrinsicHeight - placeableMo8265measureBRTryo1.getHeight() : i2 - iMaxIntrinsicHeight;
        final float f = this.f119$$v$c$androidxcomposeuiunitDp$collapsedShadowElevation$0;
        final float f2 = this.f120$$v$c$androidxcomposeuiunitDp$expandedShadowElevation$0;
        final State<Float> state = this.$expandedProgress;
        final Shape shape = this.$toolbarShape;
        return MeasureScope.layout$default(measureScope, iM9642getMinWidthimpl, i2, null, new Function1() { // from class: androidx.compose.material3.FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1.measure_3p2s80s$lambda$0(f, f2, state, placeableMo8265measureBRTryo1, width, height2, placeableMo8265measureBRTryo0, width2, height, shape, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(float f, float f2, State state, Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, final Shape shape, Placeable.PlacementScope placementScope) {
        final float fM9730lerpMdfbLM = DpKt.m9730lerpMdfbLM(f, f2, RangesKt.coerceAtMost(((Number) state.getValue()).floatValue(), 1.0f));
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, i, i2, 0.0f, new Function1() { // from class: androidx.compose.material3.FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1.measure_3p2s80s$lambda$0$0(fM9730lerpMdfbLM, shape, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0$0(float f, Shape shape, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo754toPx0680j_4(f));
        graphicsLayerScope.setShape(shape);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }
}
