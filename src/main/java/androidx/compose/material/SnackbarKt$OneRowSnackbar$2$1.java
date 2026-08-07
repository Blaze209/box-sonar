package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2) {
        this.$actionTag = str;
        this.$textTag = str2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int height;
        int iMax;
        String str = this.$actionTag;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int height2 = 0;
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                long j2 = j;
                final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j2);
                int iCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m9640getMaxWidthimpl(j2) - placeableMo8265measureBRTryo0.getWidth()) - measureScope.mo748roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m9642getMinWidthimpl(j2));
                String str2 = this.$textTag;
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                        final Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(j2, 0, iCoerceAtLeast, 0, 0, 9, null));
                        int i3 = placeableMo8265measureBRTryo1.get(AlignmentLineKt.getFirstBaseline());
                        int i4 = placeableMo8265measureBRTryo1.get(AlignmentLineKt.getLastBaseline());
                        boolean z = true;
                        boolean z2 = (i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE) ? false : true;
                        if (i3 != i4 && z2) {
                            z = false;
                        }
                        final int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j) - placeableMo8265measureBRTryo0.getWidth();
                        if (!z) {
                            height = measureScope.mo748roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i3;
                            iMax = Math.max(measureScope.mo748roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), placeableMo8265measureBRTryo1.getHeight() + height);
                            height2 = (iMax - placeableMo8265measureBRTryo0.getHeight()) / 2;
                        } else {
                            iMax = Math.max(measureScope.mo748roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), placeableMo8265measureBRTryo0.getHeight());
                            height = (iMax - placeableMo8265measureBRTryo1.getHeight()) / 2;
                            int i5 = placeableMo8265measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                            if (i5 != Integer.MIN_VALUE) {
                                height2 = (i3 + height) - i5;
                            }
                        }
                        final int i6 = height;
                        final int i7 = height2;
                        return MeasureScope.layout$default(measureScope, Constraints.m9640getMaxWidthimpl(j), iMax, null, new Function1() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SnackbarKt$OneRowSnackbar$2$1.measure_3p2s80s$lambda$3(placeableMo8265measureBRTryo1, i6, placeableMo8265measureBRTryo0, iM9640getMaxWidthimpl, i7, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i2++;
                    measureScope = measureScope;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i3, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
