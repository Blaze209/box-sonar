package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ButtonGroupMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/material3/ButtonGroupOverflowState;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "expandedRatio", "", "<init>", "(Landroidx/compose/material3/ButtonGroupOverflowState;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;F)V", "getOverflowState", "()Landroidx/compose/material3/ButtonGroupOverflowState;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getVerticalAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "getExpandedRatio", "()F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ButtonGroupMeasurePolicy implements MultiContentMeasurePolicy {
    private final float expandedRatio;
    private final Arrangement.Horizontal horizontalArrangement;
    private final ButtonGroupOverflowState overflowState;
    private final Alignment.Vertical verticalAlignment;

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

    public ButtonGroupMeasurePolicy(ButtonGroupOverflowState buttonGroupOverflowState, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, float f) {
        this.overflowState = buttonGroupOverflowState;
        this.horizontalArrangement = horizontal;
        this.verticalAlignment = vertical;
        this.expandedRatio = f;
    }

    public final ButtonGroupOverflowState getOverflowState() {
        return this.overflowState;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public /* synthetic */ ButtonGroupMeasurePolicy(ButtonGroupOverflowState buttonGroupOverflowState, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(buttonGroupOverflowState, horizontal, (i & 4) != 0 ? Alignment.INSTANCE.getTop() : vertical, f);
    }

    public final Alignment.Vertical getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public final float getExpandedRatio() {
        return this.expandedRatio;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1154measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Object buttonGroupParentData;
        long j2;
        List<? extends Measurable> list2;
        Integer numValueOf;
        int[] iArr;
        Animatable[] animatableArr;
        final ArrayList arrayList;
        List<? extends Measurable> list3 = list.get(0);
        int i = 1;
        List<? extends Measurable> list4 = list.get(1);
        this.overflowState.setTotalItemCount(list3.size());
        int i2 = measureScope.mo748roundToPx0680j_4(this.horizontalArrangement.getSpacing());
        long j3 = i2;
        int size = list3.size();
        final ArrayList arrayList2 = new ArrayList();
        int[] iArr2 = new int[size];
        Constraints[] constraintsArr = new Constraints[size];
        int size2 = list3.size();
        ButtonGroupParentData[] buttonGroupParentDataArr = new ButtonGroupParentData[size2];
        int i3 = 0;
        while (true) {
            buttonGroupParentData = null;
            if (i3 >= size2) {
                break;
            }
            int i4 = i;
            Object parentData = list3.get(i3).getParentData();
            buttonGroupParentData = parentData instanceof ButtonGroupParentData ? (ButtonGroupParentData) parentData : null;
            if (buttonGroupParentData == null) {
                buttonGroupParentData = new ButtonGroupParentData(0.0f, null, null, 7, null);
            }
            buttonGroupParentDataArr[i3] = buttonGroupParentData;
            i3++;
            i = i4;
        }
        int i5 = i;
        int size3 = list3.size();
        Animatable[] animatableArr2 = new Animatable[size3];
        for (int i6 = 0; i6 < size3; i6++) {
            animatableArr2[i6] = buttonGroupParentDataArr[i6].getPressedAnimatable();
        }
        int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        int i7 = 0;
        int iMin = 0;
        float f = 0.0f;
        for (int i8 = 0; i8 < size; i8++) {
            Measurable measurable = list3.get(i8);
            float weight = ButtonGroupKt.getWeight(ButtonGroupKt.getButtonGroupParentData(measurable));
            if (weight > 0.0f) {
                f += weight;
                i7++;
                Integer.valueOf(i7);
            } else {
                int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m9639getMaxHeightimpl(j));
                constraintsArr[i8] = Constraints.m9627boximpl(Constraints.m9630copyZbe2FdA$default(j, 0, RangesKt.coerceAtLeast(iMaxIntrinsicWidth, 0), 0, 0, 12, null));
                iArr2[i8] = iMaxIntrinsicWidth;
                iMin += iMaxIntrinsicWidth + Math.min(i2, RangesKt.coerceAtLeast((iM9640getMaxWidthimpl - iMin) - iMaxIntrinsicWidth, 0));
                Unit unit = Unit.INSTANCE;
            }
        }
        if (i7 != 0) {
            long j4 = j3 * ((long) (i7 - 1));
            long jCoerceAtLeast = RangesKt.coerceAtLeast(((long) ((iM9640getMaxWidthimpl != Integer.MAX_VALUE ? iM9640getMaxWidthimpl : iM9642getMinWidthimpl) - iMin)) - j4, 0L);
            float f2 = jCoerceAtLeast / f;
            for (int i9 = 0; i9 < size; i9++) {
                jCoerceAtLeast -= (long) Math.round(ButtonGroupKt.getWeight(ButtonGroupKt.getButtonGroupParentData(list3.get(i9))) * f2);
            }
            int i10 = 0;
            int iCoerceIn = 0;
            while (i10 < size) {
                if (constraintsArr[i10] == null) {
                    float weight2 = ButtonGroupKt.getWeight(ButtonGroupKt.getButtonGroupParentData(list3.get(i10)));
                    long j5 = jCoerceAtLeast;
                    int sign = MathKt.getSign(j5);
                    long j6 = j5 - ((long) sign);
                    int iMax = Math.max(0, Math.round(weight2 * f2) + sign);
                    constraintsArr[i10] = Constraints.m9627boximpl(Constraints.m9630copyZbe2FdA$default(j, iMax != Integer.MAX_VALUE ? iMax : 0, iMax, 0, 0, 12, null));
                    iArr2[i10] = iMax;
                    iCoerceIn += iMax;
                    j2 = j6;
                } else {
                    j2 = jCoerceAtLeast;
                }
                iCoerceIn = RangesKt.coerceIn((int) (((long) iCoerceIn) + j4), 0, iM9640getMaxWidthimpl - iMin);
                i10++;
                jCoerceAtLeast = j2;
                j4 = j4;
            }
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int size4 = list3.size();
        int[] iArr3 = new int[size4];
        for (int i11 = 0; i11 < size4; i11++) {
            Constraints constraints = constraintsArr[i11];
            iArr3[i11] = Constraints.m9640getMaxWidthimpl(constraints != null ? constraints.getValue() : j);
        }
        int iSum = ArraysKt.sum(iArr3) + ((list3.size() - 1) * i2);
        if (iSum <= iM9640getMaxWidthimpl) {
            iArr = iArr3;
            animatableArr = animatableArr2;
            arrayList = null;
        } else {
            if (list4.isEmpty()) {
                list2 = list4;
                iArr = iArr3;
                animatableArr = animatableArr2;
                numValueOf = null;
            } else {
                list2 = list4;
                numValueOf = Integer.valueOf(list2.get(0).maxIntrinsicWidth(Constraints.m9639getMaxHeightimpl(j)));
                int lastIndex = CollectionsKt.getLastIndex(list2);
                if (i5 <= lastIndex) {
                    int i12 = 1;
                    while (true) {
                        iArr = iArr3;
                        animatableArr = animatableArr2;
                        Integer numValueOf2 = Integer.valueOf(list2.get(i12).maxIntrinsicWidth(Constraints.m9639getMaxHeightimpl(j)));
                        if (numValueOf2.compareTo(numValueOf) > 0) {
                            numValueOf = numValueOf2;
                        }
                        if (i12 == lastIndex) {
                            break;
                        }
                        i12++;
                        animatableArr2 = animatableArr;
                        iArr3 = iArr;
                    }
                } else {
                    iArr = iArr3;
                    animatableArr = animatableArr2;
                }
            }
            Integer num = numValueOf;
            int iIntValue = num != null ? num.intValue() : 0;
            int i13 = iM9640getMaxWidthimpl - iIntValue;
            int i14 = iIntValue;
            int i15 = 0;
            while (i15 < size4) {
                int i16 = iArr[i15];
                if (i16 > i13) {
                    break;
                }
                i14 += i16;
                intRef.element += iArr[i15];
                i13 -= iArr[i15] + i2;
                i15++;
            }
            int i17 = i2 * i15;
            int i18 = i14 + i17;
            intRef.element += i17;
            ArrayList arrayList3 = new ArrayList(list2.size());
            int i19 = 0;
            for (int size5 = list2.size(); i19 < size5; size5 = size5) {
                arrayList3.add(list2.get(i19).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(j, 0, i13 + iIntValue, 0, 0, 13, null)));
                i19++;
                i18 = i18;
                list2 = list2;
            }
            iSum = i18;
            size4 = i15;
            arrayList = arrayList3;
        }
        this.overflowState.setVisibleItemCount(size4);
        int[] iArr4 = new int[size4];
        for (int i20 = 0; i20 < size4; i20++) {
            iArr4[i20] = 0;
        }
        if (list3.size() > 1) {
            for (int i21 = 0; i21 < size4; i21++) {
                float fFloatValue = ((Number) animatableArr[i21].getValue()).floatValue() * this.expandedRatio * iArr[i21];
                if (1 <= i21 && i21 < size4 - 1) {
                    float f3 = fFloatValue / 2.0f;
                    iArr4[i21] = MathKt.roundToInt(f3);
                    int i22 = i21 - 1;
                    iArr[i22] = iArr[i22] - MathKt.roundToInt(f3);
                    int i23 = i21 + 1;
                    iArr[i23] = iArr[i23] - MathKt.roundToInt(fFloatValue / 2);
                } else {
                    if (i21 == 0) {
                        int i24 = i21 + 1;
                        iArr[i24] = iArr[i24] - MathKt.roundToInt(fFloatValue);
                    } else {
                        int i25 = i21 - 1;
                        iArr[i25] = iArr[i25] - MathKt.roundToInt(fFloatValue);
                    }
                    iArr4[i21] = MathKt.roundToInt(fFloatValue);
                }
                iArr[i21] = iArr[i21] + MathKt.roundToInt(fFloatValue);
            }
        }
        int i26 = 0;
        while (i26 < size4) {
            Measurable measurable2 = list3.get(i26);
            Constraints constraints2 = constraintsArr[i26];
            long value = constraints2 != null ? constraints2.getValue() : j;
            int i27 = iArr[i26];
            arrayList2.add(measurable2.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(value, i27, i27, 0, 0, 12, null)));
            i26++;
            list3 = list3;
            iArr4 = iArr4;
        }
        final int[] iArr5 = iArr4;
        final List<? extends Measurable> list5 = list3;
        int iMax2 = Math.max(RangesKt.coerceAtLeast(iSum, 0), iM9642getMinWidthimpl);
        final int[] iArr6 = new int[size4];
        this.horizontalArrangement.arrange(measureScope, iMax2, ArraysKt.sliceArray(iArr2, new IntRange(0, size4 - 1)), measureScope.getLayoutDirection(), iArr6);
        Unit unit2 = Unit.INSTANCE;
        if (!arrayList2.isEmpty()) {
            Object obj = arrayList2.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                int i28 = 1;
                while (true) {
                    Object obj2 = arrayList2.get(i28);
                    int height2 = ((Placeable) obj2).getHeight();
                    if (height < height2) {
                        obj = obj2;
                        height = height2;
                    }
                    if (i28 == lastIndex2) {
                        break;
                    }
                    i28++;
                }
            }
            buttonGroupParentData = obj;
        }
        Placeable placeable = (Placeable) buttonGroupParentData;
        final int height3 = placeable != null ? placeable.getHeight() : Constraints.m9641getMinHeightimpl(j);
        return MeasureScope.layout$default(measureScope, iMax2, height3, null, new Function1() { // from class: androidx.compose.material3.ButtonGroupMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return ButtonGroupMeasurePolicy.measure_3p2s80s$lambda$4(arrayList2, measureScope, iArr5, list5, height3, this, iArr6, arrayList, intRef, (Placeable.PlacementScope) obj3);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    public static final Unit measure_3p2s80s$lambda$4(List list, MeasureScope measureScope, int[] iArr, List list2, int i, ButtonGroupMeasurePolicy buttonGroupMeasurePolicy, int[] iArr2, List list3, Ref.IntRef intRef, Placeable.PlacementScope placementScope) {
        int i2;
        int i3;
        int i4;
        Alignment.Vertical alignment;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = WhenMappings.$EnumSwitchMapping$0[measureScope.getLayoutDirection().ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (i5 < CollectionsKt.getLastIndex(list)) {
                    i2 = iArr[i5 + 1];
                    i3 = iArr[i5];
                    i4 = i2 - i3;
                } else {
                    i4 = 0;
                }
            } else if (i5 > 0) {
                i2 = iArr[i5 - 1];
                i3 = iArr[i5];
                i4 = i2 - i3;
            } else {
                i4 = 0;
            }
            Object parentData = ((Measurable) list2.get(i5)).getParentData();
            ButtonGroupParentData buttonGroupParentData = parentData instanceof ButtonGroupParentData ? (ButtonGroupParentData) parentData : null;
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i5), iArr2[i5] + i4, (buttonGroupParentData == null || (alignment = buttonGroupParentData.getAlignment()) == null) ? buttonGroupMeasurePolicy.verticalAlignment.align(((Placeable) list.get(i5)).getHeight(), i) : alignment.align(((Placeable) list.get(i5)).getHeight(), i), 0.0f, 4, null);
        }
        if (list3 != null) {
            int size2 = list3.size();
            for (int i7 = 0; i7 < size2; i7++) {
                Placeable placeable = (Placeable) list3.get(i7);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, intRef.element, buttonGroupMeasurePolicy.verticalAlignment.align(placeable.getHeight(), i), 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
