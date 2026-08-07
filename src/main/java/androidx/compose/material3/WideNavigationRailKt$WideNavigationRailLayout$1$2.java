package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/material3/WideNavigationRailKt$WideNavigationRailLayout$1$2", "Landroidx/compose/ui/layout/MeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt$WideNavigationRailLayout$1$2 implements MeasurePolicy {
    final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
    final /* synthetic */ Arrangement.Vertical $arrangement;
    final /* synthetic */ MutableIntState $currentWidth$delegate;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $header;
    final /* synthetic */ State<Dp> $itemMinHeight$delegate;
    final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
    final /* synthetic */ State<Dp> $minWidth$delegate;
    final /* synthetic */ float $minimumA11ySize;
    final /* synthetic */ State<Dp> $widthFullRange$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    WideNavigationRailKt$WideNavigationRailLayout$1$2(Function2<? super Composer, ? super Integer, Unit> function2, boolean z, float f, State<Dp> state, State<Dp> state2, State<Dp> state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State<Dp> state4) {
        this.$header = function2;
        this.$expanded = z;
        this.$minimumA11ySize = f;
        this.$minWidth$delegate = state;
        this.$itemMinHeight$delegate = state2;
        this.$widthFullRange$delegate = state3;
        this.$actualMaxExpandedWidth$delegate = mutableIntState;
        this.$currentWidth$delegate = mutableIntState2;
        this.$arrangement = vertical;
        this.$itemVerticalSpacedBy$delegate = state4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, androidx.compose.ui.layout.Placeable] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iM9642getMinWidthimpl;
        int height;
        int i;
        int i2;
        int i3;
        int iCoerceIn;
        int i4;
        List<? extends Measurable> listSubList = list;
        final int iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j);
        int size = listSubList.size();
        int iM9642getMinWidthimpl2 = Constraints.m9642getMinWidthimpl(j);
        if (Constraints.m9642getMinWidthimpl(j) == 0) {
            iM9642getMinWidthimpl2 = RangesKt.coerceAtMost(measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.ExpandedRailMinWidth), Constraints.m9640getMaxWidthimpl(j));
            iM9642getMinWidthimpl = RangesKt.coerceAtMost(measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$6(this.$minWidth$delegate)), Constraints.m9640getMaxWidthimpl(j));
        } else {
            iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        }
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, iM9642getMinWidthimpl, iM9639getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WideNavigationRailKt$WideNavigationRailLayout$1$2.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.$header != null) {
            int size2 = listSubList.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    Measurable measurable = listSubList.get(i5);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), BoxAnalyticsParams.CTA_LOCATION_HEADER)) {
                        objectRef.element = measurable.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
                        if (size > 1) {
                            listSubList = listSubList.subList(1, size);
                        }
                        size--;
                        height = ((Placeable) objectRef.element).getHeight();
                        break;
                    }
                    i5++;
                } else {
                    ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            height = 0;
        }
        final ArrayList arrayList = size > 0 ? new ArrayList() : null;
        int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(jM9630copyZbe2FdA$default) - measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.ItemHorizontalPadding);
        if (!this.$expanded) {
            iM9640getMaxWidthimpl = iM9642getMinWidthimpl;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iM9640getMaxWidthimpl, measureScope.mo748roundToPx0680j_4(this.$minimumA11ySize));
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(Constraints.m9639getMaxHeightimpl(jM9630copyZbe2FdA$default), measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$9(this.$itemMinHeight$delegate)));
        if (arrayList != null) {
            float f = this.$minimumA11ySize;
            boolean z = this.$expanded;
            State<Dp> state = this.$itemMinHeight$delegate;
            int i6 = height;
            ArrayList arrayList2 = new ArrayList(listSubList.size());
            int size3 = listSubList.size();
            int i7 = 0;
            i3 = 0;
            int height2 = i6;
            while (i7 < size3) {
                Measurable measurable2 = listSubList.get(i7);
                List<? extends Measurable> list2 = listSubList;
                ArrayList arrayList3 = arrayList2;
                int i8 = size3;
                int i9 = -height2;
                boolean z2 = z;
                State<Dp> state2 = state;
                int i10 = i7;
                float f2 = f;
                int i11 = iM9642getMinWidthimpl2;
                int i12 = iM9642getMinWidthimpl;
                Placeable placeableMo8265measureBRTryo0 = measurable2.mo8265measureBRTryo0(ConstraintsKt.m9655constrainN9IONVI(ConstraintsKt.m9660offsetNN6EwU$default(jM9630copyZbe2FdA$default, 0, i9, 1, null), Constraints.INSTANCE.m9649fitPrioritizingWidthZbe2FdA(measureScope.mo748roundToPx0680j_4(f), iCoerceAtLeast, measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$9(state2)), iCoerceAtLeast2)));
                int measuredWidth = placeableMo8265measureBRTryo0.getMeasuredWidth();
                if (z2 && i3 < measuredWidth) {
                    i3 = measuredWidth + measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.ItemHorizontalPadding);
                }
                height2 = placeableMo8265measureBRTryo0.getHeight();
                arrayList3.add(Boolean.valueOf(arrayList.add(placeableMo8265measureBRTryo0)));
                i7 = i10 + 1;
                listSubList = list2;
                z = z2;
                f = f2;
                iM9642getMinWidthimpl2 = i11;
                size3 = i8;
                state = state2;
                iM9642getMinWidthimpl = i12;
            }
            i = iM9642getMinWidthimpl2;
            i2 = iM9642getMinWidthimpl;
        } else {
            i = iM9642getMinWidthimpl2;
            i2 = iM9642getMinWidthimpl;
            i3 = 0;
        }
        if (!this.$expanded) {
            iCoerceIn = i2;
            if (WideNavigationRailKt.WideNavigationRailLayout$lambda$4(this.$actualMaxExpandedWidth$delegate) > 0) {
                iCoerceIn = RangesKt.coerceIn(measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$7(this.$widthFullRange$delegate)), iCoerceIn, RangesKt.coerceAtLeast(WideNavigationRailKt.WideNavigationRailLayout$lambda$1(this.$currentWidth$delegate), iCoerceIn));
            }
        } else {
            Placeable placeable = (Placeable) objectRef.element;
            int iMax = Math.max(i3, placeable != null ? placeable.getWidth() : 0);
            iCoerceIn = i2;
            if (iMax > iCoerceIn && iMax > (i4 = i)) {
                iCoerceIn = RangesKt.coerceAtMost(measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$7(this.$widthFullRange$delegate)), RangesKt.coerceAtMost(Math.max(iMax, i4), Constraints.m9640getMaxWidthimpl(j)));
                this.$actualMaxExpandedWidth$delegate.setIntValue(iCoerceIn);
            }
        }
        int i13 = iCoerceIn;
        this.$currentWidth$delegate.setIntValue(i13);
        final Arrangement.Vertical vertical = this.$arrangement;
        final State<Dp> state3 = this.$itemVerticalSpacedBy$delegate;
        return MeasureScope.layout$default(measureScope, i13, iM9639getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WideNavigationRailKt$WideNavigationRailLayout$1$2.measure_3p2s80s$lambda$3(iM9639getMaxHeightimpl, measureScope, objectRef, arrayList, vertical, state3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit measure_3p2s80s$lambda$3(int i, MeasureScope measureScope, Ref.ObjectRef objectRef, List list, Arrangement.Vertical vertical, State state, Placeable.PlacementScope placementScope) {
        int height;
        int i2 = i - measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WNRVerticalPadding);
        if (objectRef.element == 0 || ((Placeable) objectRef.element).getHeight() <= 0) {
            height = 0;
        } else {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) objectRef.element, 0, 0, 0.0f, 4, null);
            height = ((Placeable) objectRef.element).getHeight() + measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WNRHeaderPadding);
        }
        if (list != null) {
            if (!Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                i2 -= height;
            }
            int[] iArr = new int[list.size()];
            List list2 = list;
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = ((Placeable) list.get(i3)).getHeight();
                if (i3 < list.size() - 1) {
                    iArr[i3] = iArr[i3] + measureScope.mo748roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$8(state));
                }
            }
            int[] iArr2 = new int[list.size()];
            vertical.arrange(measureScope, i2, iArr, iArr2);
            if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                height = 0;
            }
            int size2 = list2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i4), 0, iArr2[i4] + height, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
