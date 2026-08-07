package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ListItemKt$OffsetToBaselineOrCenter$1$1 implements MeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-offset$0, reason: not valid java name */
    final /* synthetic */ float f74$$v$c$androidxcomposeuiunitDp$offset$0;

    ListItemKt$OffsetToBaselineOrCenter$1$1(float f) {
        this.f74$$v$c$androidxcomposeuiunitDp$offset$0 = f;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iMax;
        final int iM9816getYimpl;
        final Placeable placeableMo8265measureBRTryo0 = list.get(0).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
        int i = placeableMo8265measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
        if (i != Integer.MIN_VALUE) {
            iM9816getYimpl = measureScope.mo748roundToPx0680j_4(this.f74$$v$c$androidxcomposeuiunitDp$offset$0) - i;
            iMax = Math.max(Constraints.m9641getMinHeightimpl(j), placeableMo8265measureBRTryo0.getHeight() + iM9816getYimpl);
        } else {
            iMax = Math.max(Constraints.m9641getMinHeightimpl(j), placeableMo8265measureBRTryo0.getHeight());
            iM9816getYimpl = IntOffset.m9816getYimpl(Alignment.INSTANCE.getCenter().mo6288alignKFBX0sM(IntSize.INSTANCE.m9863getZeroYbymL2g(), IntSize.m9853constructorimpl((((long) 0) << 32) | (((long) (iMax - placeableMo8265measureBRTryo0.getHeight())) & 4294967295L)), measureScope.getLayoutDirection()));
        }
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), iMax, null, new Function1() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListItemKt$OffsetToBaselineOrCenter$1$1.measure_3p2s80s$lambda$0(placeableMo8265measureBRTryo0, iM9816getYimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
