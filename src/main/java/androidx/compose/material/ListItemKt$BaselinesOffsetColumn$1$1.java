package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ListItemKt$BaselinesOffsetColumn$1$1 implements MeasurePolicy {
    final /* synthetic */ List<Dp> $offsets;

    ListItemKt$BaselinesOffsetColumn$1$1(List<Dp> list) {
        this.$offsets = list;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int height;
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, null);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        int iValueOf = 0;
        ArrayList arrayList3 = arrayList2;
        int size2 = arrayList3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            iValueOf = Integer.valueOf(Math.max(iValueOf.intValue(), ((Placeable) arrayList2.get(i2)).getWidth()));
        }
        int iIntValue = iValueOf.intValue();
        final int[] iArr = new int[arrayList2.size()];
        List<Dp> list2 = this.$offsets;
        int size3 = arrayList3.size();
        int height2 = 0;
        for (int i3 = 0; i3 < size3; i3++) {
            Placeable placeable = (Placeable) arrayList2.get(i3);
            if (i3 > 0) {
                int i4 = i3 - 1;
                height = ((Placeable) arrayList2.get(i4)).getHeight() - ((Placeable) arrayList2.get(i4)).get(AlignmentLineKt.getLastBaseline());
            } else {
                height = 0;
            }
            int iMax = Math.max(0, (measureScope.mo748roundToPx0680j_4(list2.get(i3).m9701unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - height);
            iArr[i3] = iMax + height2;
            height2 += iMax + placeable.getHeight();
        }
        return MeasureScope.layout$default(measureScope, iIntValue, height2, null, new Function1() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListItemKt$BaselinesOffsetColumn$1$1.measure_3p2s80s$lambda$3(arrayList2, iArr, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(List list, int[] iArr, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i), 0, iArr[i], 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
