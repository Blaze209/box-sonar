package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/NonAdaptiveButtonGroupMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "expandedRatio", "", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;F)V", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getExpandedRatio", "()F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class NonAdaptiveButtonGroupMeasurePolicy implements MeasurePolicy {
    private final float expandedRatio;
    private final Arrangement.Horizontal horizontalArrangement;

    /* JADX INFO: compiled from: ButtonGroup.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NonAdaptiveButtonGroupMeasurePolicy(Arrangement.Horizontal horizontal, float f) {
        this.horizontalArrangement = horizontal;
        this.expandedRatio = f;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final float getExpandedRatio() {
        return this.expandedRatio;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        Object obj;
        List<? extends Measurable> list2 = list;
        int i2 = measureScope.mo748roundToPx0680j_4(this.horizontalArrangement.getSpacing());
        long j2 = i2;
        int size = list2.size();
        int[] iArr = new int[size];
        Constraints[] constraintsArr = new Constraints[size];
        int size2 = list2.size();
        ButtonGroupParentData[] buttonGroupParentDataArr = new ButtonGroupParentData[size2];
        for (int i3 = 0; i3 < size2; i3++) {
            Object parentData = list2.get(i3).getParentData();
            ButtonGroupParentData buttonGroupParentData = parentData instanceof ButtonGroupParentData ? (ButtonGroupParentData) parentData : null;
            if (buttonGroupParentData == null) {
                buttonGroupParentData = new ButtonGroupParentData(0.0f, null, null, 7, null);
            }
            buttonGroupParentDataArr[i3] = buttonGroupParentData;
        }
        int size3 = list2.size();
        Animatable[] animatableArr = new Animatable[size3];
        for (int i4 = 0; i4 < size3; i4++) {
            animatableArr[i4] = buttonGroupParentDataArr[i4].getPressedAnimatable();
        }
        int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        int i5 = 0;
        int i6 = 0;
        int iMin = 0;
        float f = 0.0f;
        for (int i7 = 0; i7 < size; i7++) {
            Measurable measurable = list2.get(i7);
            float weight = ButtonGroupKt.getWeight(ButtonGroupKt.getButtonGroupParentData(measurable));
            if (weight > 0.0f) {
                f += weight;
                i5++;
            } else {
                int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m9639getMaxHeightimpl(j));
                constraintsArr[i7] = Constraints.m9627boximpl(Constraints.m9630copyZbe2FdA$default(j, 0, RangesKt.coerceAtLeast(iMaxIntrinsicWidth, 0), 0, 0, 12, null));
                iArr[i7] = iMaxIntrinsicWidth;
                iMin = Math.min(i2, RangesKt.coerceAtLeast((iM9640getMaxWidthimpl - i6) - iMaxIntrinsicWidth, 0));
                i6 += iMaxIntrinsicWidth + iMin;
            }
        }
        if (i5 == 0) {
            i6 -= iMin;
            i = 0;
        } else {
            long j3 = j2 * ((long) (i5 - 1));
            long jCoerceAtLeast = RangesKt.coerceAtLeast(((long) ((iM9640getMaxWidthimpl != Integer.MAX_VALUE ? iM9640getMaxWidthimpl : iM9642getMinWidthimpl) - i6)) - j3, 0L);
            float f2 = jCoerceAtLeast / f;
            long jRound = jCoerceAtLeast;
            int i8 = 0;
            while (i8 < size) {
                jRound -= (long) Math.round(ButtonGroupKt.getWeight(ButtonGroupKt.getButtonGroupParentData(list2.get(i8))) * f2);
                i8++;
                j3 = j3;
            }
            long j4 = j3;
            int i9 = 0;
            int iCoerceIn = 0;
            while (i9 < size) {
                if (constraintsArr[i9] == null) {
                    float weight2 = ButtonGroupKt.getWeight(ButtonGroupKt.getButtonGroupParentData(list2.get(i9)));
                    int sign = MathKt.getSign(jRound);
                    jRound -= (long) sign;
                    int iMax = Math.max(0, Math.round(weight2 * f2) + sign);
                    constraintsArr[i9] = Constraints.m9627boximpl(Constraints.m9630copyZbe2FdA$default(j, iMax != Integer.MAX_VALUE ? iMax : 0, iMax, 0, 0, 12, null));
                    iArr[i9] = iMax;
                    iCoerceIn += iMax;
                }
                iCoerceIn = RangesKt.coerceIn((int) (((long) iCoerceIn) + j4), 0, iM9640getMaxWidthimpl - i6);
                i9++;
                size = size;
            }
            i = iCoerceIn;
        }
        int i10 = size;
        int size4 = list2.size();
        int[] iArr2 = new int[size4];
        for (int i11 = 0; i11 < size4; i11++) {
            Constraints constraints = constraintsArr[i11];
            iArr2[i11] = Constraints.m9640getMaxWidthimpl(constraints != null ? constraints.getValue() : j);
        }
        int size5 = list2.size();
        final int[] iArr3 = new int[size5];
        for (int i12 = 0; i12 < size5; i12++) {
            iArr3[i12] = 0;
        }
        if (list2.size() > 1) {
            int size6 = list2.size();
            for (int i13 = 0; i13 < size6; i13++) {
                float fFloatValue = ((Number) animatableArr[i13].getValue()).floatValue() * this.expandedRatio * iArr2[i13];
                if (1 <= i13 && i13 < CollectionsKt.getLastIndex(list2)) {
                    float f3 = fFloatValue / 2.0f;
                    iArr3[i13] = MathKt.roundToInt(f3);
                    int i14 = i13 - 1;
                    iArr2[i14] = iArr2[i14] - MathKt.roundToInt(f3);
                    int i15 = i13 + 1;
                    iArr2[i15] = iArr2[i15] - MathKt.roundToInt(fFloatValue / 2);
                } else {
                    if (i13 == 0) {
                        int i16 = i13 + 1;
                        iArr2[i16] = iArr2[i16] - MathKt.roundToInt(fFloatValue);
                    } else {
                        int i17 = i13 - 1;
                        iArr2[i17] = iArr2[i17] - MathKt.roundToInt(fFloatValue);
                    }
                    iArr3[i13] = MathKt.roundToInt(fFloatValue);
                }
                iArr2[i13] = iArr2[i13] + MathKt.roundToInt(fFloatValue);
            }
        }
        ArrayList arrayList = new ArrayList(list2.size());
        int size7 = list2.size();
        int i18 = 0;
        while (i18 < size7) {
            ArrayList arrayList2 = arrayList;
            Measurable measurable2 = list2.get(i18);
            Constraints constraints2 = constraintsArr[i18];
            long value = constraints2 != null ? constraints2.getValue() : j;
            int i19 = iArr2[i18];
            arrayList2.add(measurable2.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(value, i19, i19, 0, 0, 12, null)));
            i18++;
            list2 = list;
            arrayList = arrayList;
        }
        final ArrayList arrayList3 = arrayList;
        int iMax2 = Math.max(RangesKt.coerceAtLeast(i6 + i, 0), iM9642getMinWidthimpl);
        final int[] iArr4 = new int[i10];
        this.horizontalArrangement.arrange(measureScope, iMax2, iArr, measureScope.getLayoutDirection(), iArr4);
        if (arrayList3.isEmpty()) {
            obj = null;
        } else {
            Object obj2 = arrayList3.get(0);
            int height = ((Placeable) obj2).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(arrayList3);
            int i20 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj3 = arrayList3.get(i20);
                    int height2 = ((Placeable) obj3).getHeight();
                    if (height < height2) {
                        obj2 = obj3;
                        height = height2;
                    }
                    if (i20 == lastIndex) {
                        break;
                    }
                    i20++;
                }
            }
            obj = obj2;
        }
        Placeable placeable = (Placeable) obj;
        return MeasureScope.layout$default(measureScope, iMax2, placeable != null ? placeable.getHeight() : Constraints.m9641getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.material3.NonAdaptiveButtonGroupMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj4) {
                return NonAdaptiveButtonGroupMeasurePolicy.measure_3p2s80s$lambda$3(arrayList3, measureScope, iArr3, iArr4, (Placeable.PlacementScope) obj4);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    public static final Unit measure_3p2s80s$lambda$3(List list, MeasureScope measureScope, int[] iArr, int[] iArr2, Placeable.PlacementScope placementScope) {
        int i;
        int i2;
        int i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[measureScope.getLayoutDirection().ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (i4 < CollectionsKt.getLastIndex(list)) {
                    i = iArr[i4 + 1];
                    i2 = iArr[i4];
                    i3 = i - i2;
                } else {
                    i3 = 0;
                }
            } else if (i4 > 0) {
                i = iArr[i4 - 1];
                i2 = iArr[i4];
                i3 = i - i2;
            } else {
                i3 = 0;
            }
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i4), iArr2[i4] + i3, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
