package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0154 A[PHI: r5 r6
      0x0154: PHI (r5v10 int) = (r5v9 int), (r5v16 int), (r5v16 int) binds: [B:61:0x0149, B:56:0x011b, B:58:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0154: PHI (r6v9 int) = (r6v8 int), (r6v15 int), (r6v15 int) binds: [B:61:0x0149, B:56:0x011b, B:58:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        int height;
        int iMax;
        int height2;
        int i;
        MeasureScope measureScope2 = measureScope;
        int iMin = Math.min(Constraints.m9640getMaxWidthimpl(j), measureScope2.mo748roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
        String str = this.$actionTag;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                break;
            }
            i2++;
        }
        Measurable measurable3 = measurable;
        final Placeable placeableMo8265measureBRTryo0 = measurable3 != null ? measurable3.mo8265measureBRTryo0(j) : null;
        String str2 = this.$dismissActionTag;
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                break;
            }
            i3++;
        }
        Measurable measurable4 = measurable2;
        final Placeable placeableMo8265measureBRTryo1 = measurable4 != null ? measurable4.mo8265measureBRTryo0(j) : null;
        int width = placeableMo8265measureBRTryo0 != null ? placeableMo8265measureBRTryo0.getWidth() : 0;
        int height3 = placeableMo8265measureBRTryo0 != null ? placeableMo8265measureBRTryo0.getHeight() : 0;
        int width2 = placeableMo8265measureBRTryo1 != null ? placeableMo8265measureBRTryo1.getWidth() : 0;
        int height4 = placeableMo8265measureBRTryo1 != null ? placeableMo8265measureBRTryo1.getHeight() : 0;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(((iMin - width) - width2) - (width2 == 0 ? measureScope2.mo748roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0), Constraints.m9642getMinWidthimpl(j));
        String str3 = this.$textTag;
        int size3 = list2.size();
        int i4 = 0;
        while (i4 < size3) {
            Measurable measurable5 = list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str3)) {
                int i5 = height4;
                final Placeable placeableMo8265measureBRTryo2 = measurable5.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(j, 0, iCoerceAtLeast, 0, 0, 9, null));
                int i6 = placeableMo8265measureBRTryo2.get(AlignmentLineKt.getFirstBaseline());
                int i7 = placeableMo8265measureBRTryo2.get(AlignmentLineKt.getLastBaseline());
                boolean z = true;
                boolean z2 = (i6 == Integer.MIN_VALUE || i7 == Integer.MIN_VALUE) ? false : true;
                if (i6 != i7 && z2) {
                    z = false;
                }
                final int i8 = iMin - width2;
                final int i9 = i8 - width;
                if (!z) {
                    height = measureScope2.mo748roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i6;
                    iMax = Math.max(measureScope2.mo748roundToPx0680j_4(SnackbarTokens.INSTANCE.m5784getTwoLinesContainerHeightD9Ej5fM()), placeableMo8265measureBRTryo2.getHeight() + height);
                    if (placeableMo8265measureBRTryo0 != null) {
                        height2 = (iMax - placeableMo8265measureBRTryo0.getHeight()) / 2;
                    } else {
                        height2 = 0;
                    }
                } else {
                    iMax = Math.max(measureScope2.mo748roundToPx0680j_4(SnackbarTokens.INSTANCE.m5783getSingleLineContainerHeightD9Ej5fM()), Math.max(height3, i5));
                    height = (iMax - placeableMo8265measureBRTryo2.getHeight()) / 2;
                    if (placeableMo8265measureBRTryo0 == null || (i = placeableMo8265measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) {
                        height2 = 0;
                    } else {
                        height2 = (i6 + height) - i;
                    }
                }
                final int i10 = height2;
                int i11 = iMax;
                final int i12 = height;
                final int height5 = placeableMo8265measureBRTryo1 != null ? (i11 - placeableMo8265measureBRTryo1.getHeight()) / 2 : 0;
                return MeasureScope.layout$default(measureScope2, iMin, i11, null, new Function1() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SnackbarKt$OneRowSnackbar$2$1.measure_3p2s80s$lambda$4(placeableMo8265measureBRTryo2, i12, placeableMo8265measureBRTryo0, i9, i10, placeableMo8265measureBRTryo1, i8, height5, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
            i4++;
            height4 = height4;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$4(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable placeable3, int i4, int i5, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i3, 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i4, i5, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
