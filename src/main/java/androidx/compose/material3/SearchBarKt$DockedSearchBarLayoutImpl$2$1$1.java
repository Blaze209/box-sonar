package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SearchBarKt$DockedSearchBarLayoutImpl$2$1$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $maxHeight;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ SearchBarState $state;

    SearchBarKt$DockedSearchBarLayoutImpl$2$1$1(SearchBarState searchBarState, float f, float f2) {
        this.$state = searchBarState;
        this.$maxHeight = f;
        this.$minHeight = f2;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1154measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer num;
        List<? extends Measurable> list2 = list.get(0);
        int i = 1;
        List<? extends Measurable> list3 = list.get(1);
        int iLerp = MathHelpersKt.lerp(SearchBarKt.getCollapsedBounds(this.$state).getHeight(), measureScope.mo748roundToPx0680j_4(this.$maxHeight), this.$state.getProgress());
        LayoutCoordinates collapsedCoords = this.$state.getCollapsedCoords();
        long jM9655constrainN9IONVI = ConstraintsKt.m9655constrainN9IONVI(j, ConstraintsKt.Constraints$default(0, collapsedCoords != null ? (int) (collapsedCoords.mo8273getSizeYbymL2g() >> 32) : Constraints.m9640getMaxWidthimpl(j), RangesKt.coerceAtMost(measureScope.mo748roundToPx0680j_4(this.$minHeight), iLerp), iLerp, 1, null));
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(jM9655constrainN9IONVI, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list2.get(i2).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            numValueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    Integer numValueOf4 = Integer.valueOf(((Placeable) arrayList2.get(i3)).getWidth());
                    if (numValueOf4.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        } else {
            numValueOf = null;
        }
        Integer num2 = numValueOf;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        if (!arrayList2.isEmpty()) {
            numValueOf2 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                int i4 = 1;
                while (true) {
                    Integer numValueOf5 = Integer.valueOf(((Placeable) arrayList2.get(i4)).getHeight());
                    if (numValueOf5.compareTo(numValueOf2) > 0) {
                        numValueOf2 = numValueOf5;
                    }
                    if (i4 == lastIndex2) {
                        break;
                    }
                    i4++;
                }
            }
        } else {
            numValueOf2 = null;
        }
        Integer num3 = numValueOf2;
        final int iIntValue2 = num3 != null ? num3.intValue() : 0;
        long jM9630copyZbe2FdA$default2 = Constraints.m9630copyZbe2FdA$default(ConstraintsKt.m9660offsetNN6EwU$default(jM9630copyZbe2FdA$default, 0, -iIntValue2, 1, null), 0, iIntValue, 0, 0, 13, null);
        ArrayList arrayList3 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i5 = 0; i5 < size2; i5++) {
            arrayList3.add(list3.get(i5).mo8265measureBRTryo0(jM9630copyZbe2FdA$default2));
        }
        final ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            numValueOf3 = Integer.valueOf(((Placeable) arrayList4.get(0)).getHeight());
            int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex3) {
                int i6 = 1;
                while (true) {
                    Integer numValueOf6 = Integer.valueOf(((Placeable) arrayList4.get(i6)).getHeight());
                    if (numValueOf6.compareTo(numValueOf3) > 0) {
                        numValueOf3 = numValueOf6;
                    }
                    if (i6 == lastIndex3) {
                        break;
                    }
                    i6++;
                }
            }
        } else {
            numValueOf3 = null;
        }
        Integer num4 = numValueOf3;
        int iIntValue3 = (num4 != null ? num4.intValue() : 0) + iIntValue2;
        if (arrayList4.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf7 = Integer.valueOf(((Placeable) arrayList4.get(0)).getWidth());
            int lastIndex4 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex4) {
                while (true) {
                    Integer numValueOf8 = Integer.valueOf(((Placeable) arrayList4.get(i)).getWidth());
                    if (numValueOf8.compareTo(numValueOf7) > 0) {
                        numValueOf7 = numValueOf8;
                    }
                    if (i == lastIndex4) {
                        break;
                    }
                    i++;
                }
            }
            num = numValueOf7;
        }
        Integer num5 = num;
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m9657constrainWidthK40F9xA(jM9655constrainN9IONVI, Math.max(iIntValue, num5 != null ? num5.intValue() : 0)), ConstraintsKt.m9656constrainHeightK40F9xA(jM9655constrainN9IONVI, iIntValue3), null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayoutImpl$2$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$DockedSearchBarLayoutImpl$2$1$1.measure_3p2s80s$lambda$6(arrayList2, arrayList4, iIntValue2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$6(List list, List list2, int i, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i2), 0, 0, 0.0f, 4, null);
        }
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list2.get(i3), 0, i, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
