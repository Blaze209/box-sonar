package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarKt$TextOnlySnackbar$2$1 implements MeasurePolicy {
    public static final SnackbarKt$TextOnlySnackbar$2$1 INSTANCE = new SnackbarKt$TextOnlySnackbar$2$1();

    SnackbarKt$TextOnlySnackbar$2$1() {
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        boolean z = false;
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MIN_VALUE;
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeableMo8265measureBRTryo0 = list.get(i3).mo8265measureBRTryo0(j);
            arrayList.add(placeableMo8265measureBRTryo0);
            if (placeableMo8265measureBRTryo0.get(AlignmentLineKt.getFirstBaseline()) != Integer.MIN_VALUE && (i == Integer.MIN_VALUE || placeableMo8265measureBRTryo0.get(AlignmentLineKt.getFirstBaseline()) < i)) {
                i = placeableMo8265measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
            }
            if (placeableMo8265measureBRTryo0.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE && (i2 == Integer.MIN_VALUE || placeableMo8265measureBRTryo0.get(AlignmentLineKt.getLastBaseline()) > i2)) {
                i2 = placeableMo8265measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
            }
            iMax = Math.max(iMax, placeableMo8265measureBRTryo0.getHeight());
        }
        if (i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
            z = true;
        }
        final int iMax2 = Math.max(measureScope.mo748roundToPx0680j_4((i == i2 || !z) ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines), iMax);
        return MeasureScope.layout$default(measureScope, Constraints.m9640getMaxWidthimpl(j), iMax2, null, new Function1() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SnackbarKt$TextOnlySnackbar$2$1.measure_3p2s80s$lambda$1(arrayList, iMax2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(ArrayList arrayList, int i, Placeable.PlacementScope placementScope) {
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable placeable = (Placeable) arrayList2.get(i2);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
