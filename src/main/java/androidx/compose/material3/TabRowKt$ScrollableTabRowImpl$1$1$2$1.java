package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TabRowKt$ScrollableTabRowImpl$1$1$2$1 implements MultiContentMeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-edgePadding$0, reason: not valid java name */
    final /* synthetic */ float f123$$v$c$androidxcomposeuiunitDp$edgePadding$0;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-minTabWidth$0, reason: not valid java name */
    final /* synthetic */ float f124$$v$c$androidxcomposeuiunitDp$minTabWidth$0;
    final /* synthetic */ TabRowKt$ScrollableTabRowImpl$1$scope$1$1 $scope;
    final /* synthetic */ ScrollableTabData $scrollableTabData;
    final /* synthetic */ int $selectedTabIndex;

    TabRowKt$ScrollableTabRowImpl$1$1$2$1(float f, float f2, TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1, int i, ScrollableTabData scrollableTabData) {
        this.f123$$v$c$androidxcomposeuiunitDp$edgePadding$0 = f;
        this.f124$$v$c$androidxcomposeuiunitDp$minTabWidth$0 = f2;
        this.$scope = tabRowKt$ScrollableTabRowImpl$1$scope$1$1;
        this.$selectedTabIndex = i;
        this.$scrollableTabData = scrollableTabData;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1154measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        final int i = measureScope.mo748roundToPx0680j_4(this.f123$$v$c$androidxcomposeuiunitDp$edgePadding$0);
        int size = list2.size();
        int iValueOf = 0;
        List<? extends Measurable> list4 = list2;
        int size2 = list4.size();
        for (int i2 = 0; i2 < size2; i2++) {
            iValueOf = Integer.valueOf(Math.max(iValueOf.intValue(), list2.get(i2).maxIntrinsicHeight(Integer.MAX_VALUE)));
        }
        int iIntValue = iValueOf.intValue();
        int i3 = i * 2;
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, measureScope.mo748roundToPx0680j_4(this.f124$$v$c$androidxcomposeuiunitDp$minTabWidth$0), 0, iIntValue, iIntValue, 2, null);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.f123$$v$c$androidxcomposeuiunitDp$edgePadding$0;
        ArrayList arrayList = new ArrayList(list2.size());
        int size3 = list4.size();
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList.add(list2.get(i4).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        ArrayList arrayList2 = arrayList;
        MutableIntList mutableIntList = new MutableIntList(0, 1, null);
        int size4 = list4.size();
        for (int i5 = 0; i5 < size4; i5++) {
            mutableIntList.add(list2.get(i5).maxIntrinsicWidth(Integer.MAX_VALUE));
        }
        float f = this.f124$$v$c$androidxcomposeuiunitDp$minTabWidth$0;
        ArrayList arrayList3 = new ArrayList(size);
        int i6 = i3;
        int i7 = 0;
        while (i7 < size) {
            float fM9701unboximpl = ((Dp) ComparisonsKt.maxOf(Dp.m9685boximpl(f), Dp.m9685boximpl(measureScope.mo751toDpu2uoSUM(((Placeable) arrayList2.get(i7)).getWidth())))).m9701unboximpl();
            i6 += measureScope.mo748roundToPx0680j_4(fM9701unboximpl);
            TabPosition tabPosition = new TabPosition(floatRef.element, fM9701unboximpl, ((Dp) ComparisonsKt.maxOf(Dp.m9685boximpl(Dp.m9687constructorimpl(measureScope.mo751toDpu2uoSUM(mutableIntList.get(i7)) - Dp.m9687constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m9685boximpl(Dp.m9687constructorimpl(24)))).m9701unboximpl(), null);
            floatRef.element = Dp.m9687constructorimpl(floatRef.element + fM9701unboximpl);
            arrayList3.add(tabPosition);
            i7++;
            arrayList2 = arrayList2;
        }
        final ArrayList arrayList4 = arrayList2;
        final ArrayList arrayList5 = arrayList3;
        this.$scope.setTabPositions(arrayList5);
        int i8 = this.$selectedTabIndex;
        ArrayList arrayList6 = new ArrayList(list3.size());
        int size5 = list3.size();
        int i9 = 0;
        while (i9 < size5) {
            int i10 = iIntValue;
            iIntValue = i10;
            arrayList6.add(list3.get(i9).mo8265measureBRTryo0(Constraints.m9629copyZbe2FdA(j, 0, measureScope.mo748roundToPx0680j_4(((TabPosition) arrayList5.get(i8)).getContentWidth()), 0, i10)));
            i9++;
            floatRef = floatRef;
            list3 = list3;
            i8 = i8;
        }
        final Ref.FloatRef floatRef2 = floatRef;
        final ArrayList arrayList7 = arrayList6;
        final float f2 = this.f123$$v$c$androidxcomposeuiunitDp$edgePadding$0;
        final ScrollableTabData scrollableTabData = this.$scrollableTabData;
        final int i11 = this.$selectedTabIndex;
        final int i12 = iIntValue;
        return MeasureScope.layout$default(measureScope, i6, iIntValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$1$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt$ScrollableTabRowImpl$1$1$2$1.measure_3p2s80s$lambda$5(floatRef2, f2, arrayList4, arrayList7, scrollableTabData, measureScope, i, arrayList5, i11, i12, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5(Ref.FloatRef floatRef, float f, List list, List list2, ScrollableTabData scrollableTabData, MeasureScope measureScope, int i, List list3, int i2, int i3, Placeable.PlacementScope placementScope) {
        floatRef.element = f;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i4), measureScope.mo748roundToPx0680j_4(floatRef.element), 0, 0.0f, 4, null);
            floatRef.element = Dp.m9687constructorimpl(floatRef.element + ((TabPosition) list3.get(i4)).getWidth());
        }
        int size2 = list2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = (Placeable) list2.get(i5);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, Math.max(0, (measureScope.mo748roundToPx0680j_4(((TabPosition) list3.get(i2)).getWidth()) - placeable.getWidth()) / 2), i3 - placeable.getHeight(), 0.0f, 4, null);
        }
        scrollableTabData.onLaidOut(measureScope, i, list3, i2);
        return Unit.INSTANCE;
    }
}
