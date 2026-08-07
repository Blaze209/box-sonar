package expo.modules.ui;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import expo.modules.kotlin.views.ShadowNodeProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class HostView$MaybeMatchContentsLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $safeHeightPx;
    final /* synthetic */ int $safeWidthPx;
    final /* synthetic */ HostView this$0;

    HostView$MaybeMatchContentsLayout$2$1(HostView hostView, int i, int i2, Density density) {
        this.this$0 = hostView;
        this.$safeWidthPx = i;
        this.$safeHeightPx = i2;
        this.$density = density;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        int iM9640getMaxWidthimpl;
        int iM9639getMaxHeightimpl;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        boolean zBooleanValue = this.this$0.getProps().getUseViewportSizeMeasurement().getValue().booleanValue();
        int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        if (Constraints.m9640getMaxWidthimpl(j) == Integer.MAX_VALUE) {
            iM9640getMaxWidthimpl = this.$safeWidthPx;
        } else {
            iM9640getMaxWidthimpl = (zBooleanValue && Constraints.m9640getMaxWidthimpl(j) == 0) ? this.$safeWidthPx : Constraints.m9640getMaxWidthimpl(j);
        }
        int iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(j);
        if (Constraints.m9639getMaxHeightimpl(j) == Integer.MAX_VALUE) {
            iM9639getMaxHeightimpl = this.$safeHeightPx;
        } else {
            iM9639getMaxHeightimpl = (zBooleanValue && Constraints.m9639getMaxHeightimpl(j) == 0) ? this.$safeHeightPx : Constraints.m9639getMaxHeightimpl(j);
        }
        long jConstraints = ConstraintsKt.Constraints(iM9642getMinWidthimpl, iM9640getMaxWidthimpl, iM9641getMinHeightimpl, iM9639getMaxHeightimpl);
        List<? extends Measurable> list = measurables;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo8265measureBRTryo0(jConstraints));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        Iterator it2 = arrayList3.iterator();
        Integer num = null;
        if (it2.hasNext()) {
            numValueOf = Integer.valueOf(((Placeable) it2.next()).getWidth());
            while (it2.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((Placeable) it2.next()).getWidth());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        } else {
            numValueOf = null;
        }
        Integer num2 = numValueOf;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        Iterator it3 = arrayList3.iterator();
        if (it3.hasNext()) {
            Integer numValueOf3 = Integer.valueOf(((Placeable) it3.next()).getHeight());
            loop1: while (true) {
                num = numValueOf3;
                do {
                    if (!it3.hasNext()) {
                        break loop1;
                    }
                    numValueOf3 = Integer.valueOf(((Placeable) it3.next()).getHeight());
                } while (num.compareTo(numValueOf3) >= 0);
            }
        }
        Integer num3 = num;
        int iIntValue2 = num3 != null ? num3.intValue() : 0;
        if (zBooleanValue && (Constraints.m9640getMaxWidthimpl(j) == 0 || Constraints.m9639getMaxHeightimpl(j) == 0)) {
            Density density = this.$density;
            HostView hostView = this.this$0;
            double dMo751toDpu2uoSUM = density.mo751toDpu2uoSUM(iIntValue);
            double dMo751toDpu2uoSUM2 = density.mo751toDpu2uoSUM(iIntValue2);
            ShadowNodeProxy shadowNodeProxy = hostView.getShadowNodeProxy();
            if (Constraints.m9640getMaxWidthimpl(j) != 0) {
                dMo751toDpu2uoSUM = Double.NaN;
            }
            if (Constraints.m9639getMaxHeightimpl(j) != 0) {
                dMo751toDpu2uoSUM2 = Double.NaN;
            }
            shadowNodeProxy.setViewSize(dMo751toDpu2uoSUM, dMo751toDpu2uoSUM2);
        }
        return MeasureScope.layout$default(Layout, iIntValue, iIntValue2, null, new Function1() { // from class: expo.modules.ui.HostView$MaybeMatchContentsLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HostView$MaybeMatchContentsLayout$2$1.measure_3p2s80s$lambda$5(arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5(List list, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Placeable.PlacementScope.placeRelative$default(layout, (Placeable) it.next(), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
