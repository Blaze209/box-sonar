package expo.modules.kotlin.views;

import android.content.res.Resources;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoSizingComposable.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class AutoSizingComposableKt$AutoSizingComposable$1$1 implements MeasurePolicy {
    final /* synthetic */ EnumSet<Direction> $axis;
    final /* synthetic */ ShadowNodeProxy $shadowNodeProxy;

    AutoSizingComposableKt$AutoSizingComposable$1$1(EnumSet<Direction> enumSet, ShadowNodeProxy shadowNodeProxy) {
        this.$axis = enumSet;
        this.$shadowNodeProxy = shadowNodeProxy;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Measurable measurable = (Measurable) CollectionsKt.first((List) measurables);
        int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m9641getMinHeightimpl(j));
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(iMaxIntrinsicWidth);
        double d = ((double) iMaxIntrinsicWidth) / ((double) Resources.getSystem().getDisplayMetrics().density);
        double d2 = ((double) iMinIntrinsicHeight) / ((double) Resources.getSystem().getDisplayMetrics().density);
        if (!this.$axis.contains(Direction.HORIZONTAL)) {
            d = Double.NaN;
        }
        if (!this.$axis.contains(Direction.VERTICAL)) {
            d2 = Double.NaN;
        }
        this.$shadowNodeProxy.setViewSize(d, d2);
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
        return MeasureScope.layout$default(Layout, placeableMo8265measureBRTryo0.getMeasuredWidth(), placeableMo8265measureBRTryo0.getMeasuredHeight(), null, new Function1() { // from class: expo.modules.kotlin.views.AutoSizingComposableKt$AutoSizingComposable$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AutoSizingComposableKt$AutoSizingComposable$1$1.measure_3p2s80s$lambda$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
