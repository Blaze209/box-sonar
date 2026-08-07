package androidx.compose.material;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 implements MultiContentMeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-material-FabPosition$-floatingActionButtonPosition$0, reason: not valid java name */
    final /* synthetic */ int f65xbcc8c926;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-sheetPeekHeight$0, reason: not valid java name */
    final /* synthetic */ float f66$$v$c$androidxcomposeuiunitDp$sheetPeekHeight$0;
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ BottomSheetState $sheetState;

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(Function0<Float> function0, int i, float f, BottomSheetState bottomSheetState) {
        this.$sheetOffset = function0;
        this.f65xbcc8c926 = i;
        this.f66$$v$c$androidxcomposeuiunitDp$sheetPeekHeight$0 = f;
        this.$sheetState = bottomSheetState;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1154measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        List<? extends Measurable> list4 = list.get(2);
        List<? extends Measurable> list5 = list.get(3);
        List<? extends Measurable> list6 = list.get(4);
        final int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        final int iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j);
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list4.size());
        int size = list4.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list4.get(i).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList3.add(list2.get(i2).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            obj = arrayList4.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    Object obj6 = arrayList4.get(i3);
                    int height2 = ((Placeable) obj6).getHeight();
                    if (height < height2) {
                        height = height2;
                        obj = obj6;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        } else {
            obj = null;
        }
        Placeable placeable = (Placeable) obj;
        final int height3 = placeable != null ? placeable.getHeight() : 0;
        long jM9630copyZbe2FdA$default2 = Constraints.m9630copyZbe2FdA$default(jM9630copyZbe2FdA$default, 0, 0, 0, iM9639getMaxHeightimpl - height3, 7, null);
        ArrayList arrayList5 = new ArrayList(list3.size());
        int size3 = list3.size();
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList5.add(list3.get(i4).mo8265measureBRTryo0(jM9630copyZbe2FdA$default2));
        }
        final ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(list5.size());
        int size4 = list5.size();
        for (int i5 = 0; i5 < size4; i5++) {
            arrayList7.add(list5.get(i5).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList8 = arrayList7;
        if (!arrayList8.isEmpty()) {
            obj2 = arrayList8.get(0);
            int width = ((Placeable) obj2).getWidth();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList8);
            if (1 <= lastIndex2) {
                int i6 = 1;
                while (true) {
                    Object obj7 = arrayList8.get(i6);
                    int width2 = ((Placeable) obj7).getWidth();
                    if (width < width2) {
                        obj2 = obj7;
                        width = width2;
                    }
                    if (i6 == lastIndex2) {
                        break;
                    }
                    i6++;
                }
            }
        } else {
            obj2 = null;
        }
        Placeable placeable2 = (Placeable) obj2;
        final int width3 = placeable2 != null ? placeable2.getWidth() : 0;
        if (!arrayList8.isEmpty()) {
            obj3 = arrayList8.get(0);
            int height4 = ((Placeable) obj3).getHeight();
            int lastIndex3 = CollectionsKt.getLastIndex(arrayList8);
            if (1 <= lastIndex3) {
                int i7 = 1;
                while (true) {
                    Object obj8 = arrayList8.get(i7);
                    int height5 = ((Placeable) obj8).getHeight();
                    if (height4 < height5) {
                        obj3 = obj8;
                        height4 = height5;
                    }
                    if (i7 == lastIndex3) {
                        break;
                    }
                    i7++;
                }
            }
        } else {
            obj3 = null;
        }
        Placeable placeable3 = (Placeable) obj3;
        final int height6 = placeable3 != null ? placeable3.getHeight() : 0;
        ArrayList arrayList9 = new ArrayList(list6.size());
        int size5 = list6.size();
        for (int i8 = 0; i8 < size5; i8++) {
            arrayList9.add(list6.get(i8).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList10 = arrayList9;
        if (!arrayList10.isEmpty()) {
            obj4 = arrayList10.get(0);
            int width4 = ((Placeable) obj4).getWidth();
            int lastIndex4 = CollectionsKt.getLastIndex(arrayList10);
            if (1 <= lastIndex4) {
                int i9 = 1;
                while (true) {
                    Object obj9 = arrayList10.get(i9);
                    int width5 = ((Placeable) obj9).getWidth();
                    if (width4 < width5) {
                        obj4 = obj9;
                        width4 = width5;
                    }
                    if (i9 == lastIndex4) {
                        break;
                    }
                    i9++;
                }
            }
        } else {
            obj4 = null;
        }
        Placeable placeable4 = (Placeable) obj4;
        int width6 = placeable4 != null ? placeable4.getWidth() : 0;
        if (arrayList10.isEmpty()) {
            obj5 = null;
        } else {
            Object obj10 = arrayList10.get(0);
            int height7 = ((Placeable) obj10).getHeight();
            int lastIndex5 = CollectionsKt.getLastIndex(arrayList10);
            int i10 = 1;
            if (1 <= lastIndex5) {
                while (true) {
                    Object obj11 = arrayList10.get(i10);
                    int height8 = ((Placeable) obj11).getHeight();
                    if (height7 < height8) {
                        obj10 = obj11;
                        height7 = height8;
                    }
                    if (i10 == lastIndex5) {
                        break;
                    }
                    i10++;
                }
            }
            obj5 = obj10;
        }
        Placeable placeable5 = (Placeable) obj5;
        final int height9 = placeable5 != null ? placeable5.getHeight() : 0;
        final Function0<Float> function0 = this.$sheetOffset;
        final int i11 = this.f65xbcc8c926;
        final float f = this.f66$$v$c$androidxcomposeuiunitDp$sheetPeekHeight$0;
        final BottomSheetState bottomSheetState = this.$sheetState;
        final int i12 = width6;
        return MeasureScope.layout$default(measureScope, iM9640getMaxWidthimpl, iM9639getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj12) {
                return BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.measure_3p2s80s$lambda$10(function0, i11, measureScope, iM9640getMaxWidthimpl, width3, f, height6, i12, bottomSheetState, height9, iM9639getMaxHeightimpl, arrayList6, arrayList4, arrayList2, arrayList8, arrayList10, height3, (Placeable.PlacementScope) obj12);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$10(Function0 function0, int i, MeasureScope measureScope, int i2, int i3, float f, int i4, int i5, BottomSheetState bottomSheetState, int i6, int i7, List list, List list2, List list3, List list4, List list5, int i8, Placeable.PlacementScope placementScope) {
        int i9;
        int i10;
        int iRoundToInt = MathKt.roundToInt(((Number) function0.invoke()).floatValue());
        if (FabPosition.m2416equalsimpl0(i, FabPosition.INSTANCE.m2422getStart5ygKITE())) {
            i9 = measureScope.mo748roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        } else {
            i9 = FabPosition.m2416equalsimpl0(i, FabPosition.INSTANCE.m2420getCenter5ygKITE()) ? (i2 - i3) / 2 : (i2 - i3) - measureScope.mo748roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        }
        int i11 = i4 / 2;
        int i12 = measureScope.mo754toPx0680j_4(f) < ((float) i11) ? (iRoundToInt - i4) - measureScope.mo748roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing) : iRoundToInt - i11;
        int i13 = (i2 - i5) / 2;
        int i14 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getCurrentValue().ordinal()];
        if (i14 == 1) {
            i10 = i12 - i6;
        } else {
            if (i14 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = i7 - i6;
        }
        int size = list.size();
        for (int i15 = 0; i15 < size; i15++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i15), 0, i8, 0.0f, 4, null);
        }
        int size2 = list2.size();
        for (int i16 = 0; i16 < size2; i16++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list2.get(i16), 0, 0, 0.0f, 4, null);
        }
        int size3 = list3.size();
        for (int i17 = 0; i17 < size3; i17++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list3.get(i17), 0, 0, 0.0f, 4, null);
        }
        int size4 = list4.size();
        for (int i18 = 0; i18 < size4; i18++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list4.get(i18), i9, i12, 0.0f, 4, null);
        }
        int size5 = list5.size();
        for (int i19 = 0; i19 < size5; i19++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list5.get(i19), i13, i10, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
