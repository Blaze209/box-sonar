package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.internal.LayoutUtilKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\"\u0010\u0019\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\"\u0010\u001a\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\"\u0010\u001c\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J8\u0010\u001d\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001fH\u0002J<\u0010 \u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u00152\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues) {
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        int i;
        Measurable measurable3;
        final int height;
        Measurable measurable4;
        final TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        final MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        final int i2 = measureScope2.mo748roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.getTop());
        int i3 = measureScope2.mo748roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.getBottom());
        final int i4 = measureScope2.mo748roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list3 = list2;
        int size = list3.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                measurable = null;
                break;
            }
            measurable = list2.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Leading")) {
                break;
            }
            i5++;
        }
        Measurable measurable5 = measurable;
        Placeable placeableMo8265measureBRTryo0 = measurable5 != null ? measurable5.mo8265measureBRTryo0(jM9630copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo0);
        int size2 = list3.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list2.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "Trailing")) {
                break;
            }
            i6++;
        }
        Measurable measurable6 = measurable2;
        Placeable placeableMo8265measureBRTryo1 = measurable6 != null ? measurable6.mo8265measureBRTryo0(ConstraintsKt.m9660offsetNN6EwU$default(jM9630copyZbe2FdA$default, -iWidthOrZero, 0, 2, null)) : null;
        int i7 = -i3;
        int i8 = -(iWidthOrZero + TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo1));
        long jM9659offsetNN6EwU = ConstraintsKt.m9659offsetNN6EwU(jM9630copyZbe2FdA$default, i8, i7);
        int size3 = list3.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                i = i3;
                measurable3 = null;
                break;
            }
            measurable3 = list2.get(i9);
            i = i3;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Label")) {
                break;
            }
            i9++;
            i3 = i;
        }
        Measurable measurable7 = measurable3;
        Placeable placeableMo8265measureBRTryo2 = measurable7 != null ? measurable7.mo8265measureBRTryo0(jM9659offsetNN6EwU) : null;
        if (placeableMo8265measureBRTryo2 != null) {
            height = placeableMo8265measureBRTryo2.get(AlignmentLineKt.getLastBaseline());
            if (height == Integer.MIN_VALUE) {
                height = placeableMo8265measureBRTryo2.getHeight();
            }
        } else {
            height = 0;
        }
        final int iMax = Math.max(height, i2);
        Placeable placeable = placeableMo8265measureBRTryo2;
        long jM9659offsetNN6EwU2 = ConstraintsKt.m9659offsetNN6EwU(Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), i8, placeableMo8265measureBRTryo2 != null ? (i7 - i4) - iMax : (-i2) - i);
        int size4 = list3.size();
        int i10 = 0;
        while (i10 < size4) {
            Measurable measurable8 = list2.get(i10);
            int i11 = size4;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable8), "TextField")) {
                final Placeable placeableMo8265measureBRTryo3 = measurable8.mo8265measureBRTryo0(jM9659offsetNN6EwU2);
                long jM9630copyZbe2FdA$default2 = Constraints.m9630copyZbe2FdA$default(jM9659offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                int size5 = list3.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size5) {
                        measurable4 = null;
                        break;
                    }
                    measurable4 = list2.get(i12);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "Hint")) {
                        break;
                    }
                    i12++;
                    list2 = list;
                }
                Measurable measurable9 = measurable4;
                final Placeable placeableMo8265measureBRTryo4 = measurable9 != null ? measurable9.mo8265measureBRTryo0(jM9630copyZbe2FdA$default2) : null;
                final int iM2650calculateWidthVsPV1Ek = TextFieldKt.m2650calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo1), placeableMo8265measureBRTryo3.getWidth(), TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo4), j);
                final int iM2649calculateHeightO3s9Psw = TextFieldKt.m2649calculateHeightO3s9Psw(placeableMo8265measureBRTryo3.getHeight(), placeable != null, iMax, TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo1), TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo4), j, measureScope2.getDensity(), textFieldMeasurePolicy.paddingValues);
                final Placeable placeable2 = placeableMo8265measureBRTryo1;
                final Placeable placeable3 = placeable;
                final Placeable placeable4 = placeableMo8265measureBRTryo0;
                return MeasureScope.layout$default(measureScope, iM2650calculateWidthVsPV1Ek, iM2649calculateHeightO3s9Psw, null, new Function1() { // from class: androidx.compose.material.TextFieldMeasurePolicy$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextFieldMeasurePolicy.measure_3p2s80s$lambda$6(placeable3, i2, height, iM2650calculateWidthVsPV1Ek, iM2649calculateHeightO3s9Psw, placeableMo8265measureBRTryo3, placeableMo8265measureBRTryo4, placeable4, placeable2, textFieldMeasurePolicy, iMax, i4, measureScope2, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
            i10++;
            textFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            list2 = list;
            placeable = placeable;
            size4 = i11;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$6(Placeable placeable, int i, int i2, int i3, int i4, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, TextFieldMeasurePolicy textFieldMeasurePolicy, int i5, int i6, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        if (placeable == null) {
            TextFieldKt.placeWithoutLabel(placementScope, i3, i4, placeable2, placeable3, placeable4, placeable5, textFieldMeasurePolicy.singleLine, measureScope.getDensity(), textFieldMeasurePolicy.paddingValues);
        } else {
            TextFieldKt.placeWithLabel(placementScope, i3, i4, placeable2, placeable, placeable3, placeable4, placeable5, textFieldMeasurePolicy.singleLine, RangesKt.coerceAtLeast(i - i2, 0), i5 + i6, textFieldMeasurePolicy.animationProgress, measureScope.getDensity());
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        List<? extends IntrinsicMeasurable> list = measurables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable5 = measurables.get(i);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), "TextField")) {
                int iIntValue = intrinsicMeasurer.invoke(intrinsicMeasurable5, Integer.valueOf(height)).intValue();
                int size2 = list.size();
                int i2 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i2 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = measurables.get(i2);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "Label")) {
                        break;
                    }
                    i2++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = intrinsicMeasurable2;
                int iIntValue2 = intrinsicMeasurable6 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable6, Integer.valueOf(height)).intValue() : 0;
                int size3 = list.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = measurables.get(i3);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), "Trailing")) {
                        break;
                    }
                    i3++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable3;
                int iIntValue3 = intrinsicMeasurable7 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable7, Integer.valueOf(height)).intValue() : 0;
                int size4 = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = measurables.get(i4);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), "Leading")) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable4;
                int iIntValue4 = intrinsicMeasurable8 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable8, Integer.valueOf(height)).intValue() : 0;
                int size5 = list.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    IntrinsicMeasurable intrinsicMeasurable9 = measurables.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable9), "Hint")) {
                        intrinsicMeasurable = intrinsicMeasurable9;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable;
                return TextFieldKt.m2650calculateWidthVsPV1Ek(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable10 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable10, Integer.valueOf(height)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        int i2;
        int iIntValue;
        int iSubtractConstraintSafely;
        IntrinsicMeasurable intrinsicMeasurable3;
        int iIntValue2;
        IntrinsicMeasurable intrinsicMeasurable4;
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        int i3 = 0;
        while (true) {
            intrinsicMeasurable = null;
            if (i3 >= size) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i3);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "Leading")) {
                break;
            }
            i3++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = intrinsicMeasurable2;
        if (intrinsicMeasurable5 != null) {
            i2 = i;
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i2, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = function2.invoke(intrinsicMeasurable5, Integer.valueOf(i2)).intValue();
        } else {
            i2 = i;
            iIntValue = 0;
            iSubtractConstraintSafely = i2;
        }
        int size2 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size2) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), "Trailing")) {
                break;
            }
            i4++;
        }
        IntrinsicMeasurable intrinsicMeasurable6 = intrinsicMeasurable3;
        if (intrinsicMeasurable6 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable6.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = function2.invoke(intrinsicMeasurable6, Integer.valueOf(i2)).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i5);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), "Label")) {
                break;
            }
            i5++;
        }
        IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable4;
        int iIntValue3 = intrinsicMeasurable7 != null ? function2.invoke(intrinsicMeasurable7, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        int size4 = list2.size();
        for (int i6 = 0; i6 < size4; i6++) {
            IntrinsicMeasurable intrinsicMeasurable8 = list.get(i6);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable8), "TextField")) {
                int iIntValue4 = function2.invoke(intrinsicMeasurable8, Integer.valueOf(iSubtractConstraintSafely)).intValue();
                int size5 = list2.size();
                for (int i7 = 0; i7 < size5; i7++) {
                    IntrinsicMeasurable intrinsicMeasurable9 = list.get(i7);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable9), "Hint")) {
                        intrinsicMeasurable = intrinsicMeasurable9;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable;
                return TextFieldKt.m2649calculateHeightO3s9Psw(iIntValue4, iIntValue3 > 0, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
