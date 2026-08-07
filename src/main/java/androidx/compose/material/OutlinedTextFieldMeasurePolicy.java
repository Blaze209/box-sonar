package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.internal.LayoutUtilKt;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\"\u0010\u001d\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\"\u0010\u001e\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\"\u0010 \u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J<\u0010!\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001f\u001a\u00020\u00192\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0002J<\u0010$\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u00192\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/material/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> function1, boolean z, float f, PaddingValues paddingValues) {
        this.onLabelMeasured = function1;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        Measurable measurable3;
        long jM6647getZeroNHjbRc;
        Measurable measurable4;
        final OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        MeasureScope measureScope2 = measureScope;
        int i = measureScope2.mo748roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.getBottom());
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Leading")) {
                break;
            }
            i2++;
        }
        Measurable measurable5 = measurable;
        Placeable placeableMo8265measureBRTryo0 = measurable5 != null ? measurable5.mo8265measureBRTryo0(jM9630copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo0);
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "Trailing")) {
                break;
            }
            i3++;
        }
        Measurable measurable6 = measurable2;
        Placeable placeableMo8265measureBRTryo1 = measurable6 != null ? measurable6.mo8265measureBRTryo0(ConstraintsKt.m9660offsetNN6EwU$default(jM9630copyZbe2FdA$default, -iWidthOrZero, 0, 2, null)) : null;
        int iWidthOrZero2 = iWidthOrZero + TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo1);
        int i4 = measureScope2.mo748roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.mo1163calculateLeftPaddingu2uoSUM(measureScope2.getLayoutDirection())) + measureScope2.mo748roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.mo1164calculateRightPaddingu2uoSUM(measureScope2.getLayoutDirection()));
        int i5 = -iWidthOrZero2;
        int i6 = -i;
        long jM9659offsetNN6EwU = ConstraintsKt.m9659offsetNN6EwU(jM9630copyZbe2FdA$default, MathHelpersKt.lerp(i5 - i4, -i4, outlinedTextFieldMeasurePolicy.animationProgress), i6);
        int size3 = list2.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Label")) {
                break;
            }
            i7++;
        }
        Measurable measurable7 = measurable3;
        final Placeable placeableMo8265measureBRTryo2 = measurable7 != null ? measurable7.mo8265measureBRTryo0(jM9659offsetNN6EwU) : null;
        if (placeableMo8265measureBRTryo2 != null) {
            jM6647getZeroNHjbRc = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(placeableMo8265measureBRTryo2.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(placeableMo8265measureBRTryo2.getWidth())) << 32));
        } else {
            jM6647getZeroNHjbRc = Size.INSTANCE.m6647getZeroNHjbRc();
        }
        outlinedTextFieldMeasurePolicy.onLabelMeasured.invoke(Size.m6626boximpl(jM6647getZeroNHjbRc));
        long j2 = j;
        long jM9630copyZbe2FdA$default2 = Constraints.m9630copyZbe2FdA$default(ConstraintsKt.m9659offsetNN6EwU(j2, i5, i6 - Math.max(TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo2) / 2, measureScope2.mo748roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.getTop()))), 0, 0, 0, 0, 11, null);
        int size4 = list2.size();
        int i8 = 0;
        while (i8 < size4) {
            Measurable measurable8 = list.get(i8);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable8), "TextField")) {
                Placeable placeableMo8265measureBRTryo3 = measurable8.mo8265measureBRTryo0(jM9630copyZbe2FdA$default2);
                long jM9630copyZbe2FdA$default3 = Constraints.m9630copyZbe2FdA$default(jM9630copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                int size5 = list2.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size5) {
                        measurable4 = null;
                        break;
                    }
                    measurable4 = list.get(i9);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "Hint")) {
                        break;
                    }
                    i9++;
                }
                Measurable measurable9 = measurable4;
                final Placeable placeableMo8265measureBRTryo4 = measurable9 != null ? measurable9.mo8265measureBRTryo0(jM9630copyZbe2FdA$default3) : null;
                int iM2491calculateWidthO3s9Psw = OutlinedTextFieldKt.m2491calculateWidthO3s9Psw(TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo1), placeableMo8265measureBRTryo3.getWidth(), TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo2), TextFieldImplKt.widthOrZero(placeableMo8265measureBRTryo4), outlinedTextFieldMeasurePolicy.animationProgress, j2, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.paddingValues);
                int iM2490calculateHeightO3s9Psw = OutlinedTextFieldKt.m2490calculateHeightO3s9Psw(TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo1), placeableMo8265measureBRTryo3.getHeight(), TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo2), TextFieldImplKt.heightOrZero(placeableMo8265measureBRTryo4), outlinedTextFieldMeasurePolicy.animationProgress, j, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.paddingValues);
                int size6 = list2.size();
                int i10 = 0;
                while (i10 < size6) {
                    Measurable measurable10 = list.get(i10);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable10), OutlinedTextFieldKt.BorderId)) {
                        final Placeable placeableMo8265measureBRTryo5 = measurable10.mo8265measureBRTryo0(ConstraintsKt.Constraints(iM2491calculateWidthO3s9Psw != Integer.MAX_VALUE ? iM2491calculateWidthO3s9Psw : 0, iM2491calculateWidthO3s9Psw, iM2490calculateHeightO3s9Psw != Integer.MAX_VALUE ? iM2490calculateHeightO3s9Psw : 0, iM2490calculateHeightO3s9Psw));
                        final int i11 = iM2490calculateHeightO3s9Psw;
                        final Placeable placeable = placeableMo8265measureBRTryo1;
                        final Placeable placeable2 = placeableMo8265measureBRTryo3;
                        final int i12 = iM2491calculateWidthO3s9Psw;
                        final Placeable placeable3 = placeableMo8265measureBRTryo0;
                        return MeasureScope.layout$default(measureScope, i12, i11, null, new Function1() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OutlinedTextFieldMeasurePolicy.measure_3p2s80s$lambda$7(i11, i12, placeable3, placeable, placeable2, placeableMo8265measureBRTryo2, placeableMo8265measureBRTryo4, placeableMo8265measureBRTryo5, outlinedTextFieldMeasurePolicy, measureScope, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i10++;
                    outlinedTextFieldMeasurePolicy = this;
                    iM2491calculateWidthO3s9Psw = iM2491calculateWidthO3s9Psw;
                    placeableMo8265measureBRTryo3 = placeableMo8265measureBRTryo3;
                    placeableMo8265measureBRTryo1 = placeableMo8265measureBRTryo1;
                    iM2490calculateHeightO3s9Psw = iM2490calculateHeightO3s9Psw;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i8++;
            outlinedTextFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            j2 = j;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$7(int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        OutlinedTextFieldKt.place(placementScope, i, i2, placeable, placeable2, placeable3, placeable4, placeable5, placeable6, outlinedTextFieldMeasurePolicy.animationProgress, outlinedTextFieldMeasurePolicy.singleLine, measureScope.getDensity(), measureScope.getLayoutDirection(), outlinedTextFieldMeasurePolicy.paddingValues);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable5 = list.get(i2);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), "TextField")) {
                int iIntValue = function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue();
                int size2 = list2.size();
                int i3 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i3 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "Label")) {
                        break;
                    }
                    i3++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = intrinsicMeasurable2;
                int iIntValue2 = intrinsicMeasurable6 != null ? function2.invoke(intrinsicMeasurable6, Integer.valueOf(i)).intValue() : 0;
                int size3 = list2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = list.get(i4);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), "Trailing")) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable3;
                int iIntValue3 = intrinsicMeasurable7 != null ? function2.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue() : 0;
                int size4 = list2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), "Leading")) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable4;
                int iIntValue4 = intrinsicMeasurable8 != null ? function2.invoke(intrinsicMeasurable8, Integer.valueOf(i)).intValue() : 0;
                int size5 = list2.size();
                for (int i6 = 0; i6 < size5; i6++) {
                    IntrinsicMeasurable intrinsicMeasurable9 = list.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable9), "Hint")) {
                        intrinsicMeasurable = intrinsicMeasurable9;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable;
                return OutlinedTextFieldKt.m2491calculateWidthO3s9Psw(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(i)).intValue() : 0, this.animationProgress, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        int iSubtractConstraintSafely;
        int iIntValue;
        IntrinsicMeasurable intrinsicMeasurable3;
        int iIntValue2;
        IntrinsicMeasurable intrinsicMeasurable4;
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (true) {
            intrinsicMeasurable = null;
            if (i2 >= size) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i2);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "Leading")) {
                break;
            }
            i2++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = intrinsicMeasurable2;
        if (intrinsicMeasurable5 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue();
        } else {
            iSubtractConstraintSafely = i;
            iIntValue = 0;
        }
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i3);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), "Trailing")) {
                break;
            }
            i3++;
        }
        IntrinsicMeasurable intrinsicMeasurable6 = intrinsicMeasurable3;
        if (intrinsicMeasurable6 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable6.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = function2.invoke(intrinsicMeasurable6, Integer.valueOf(i)).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), "Label")) {
                break;
            }
            i4++;
        }
        IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable4;
        int iIntValue3 = intrinsicMeasurable7 != null ? function2.invoke(intrinsicMeasurable7, Integer.valueOf(MathHelpersKt.lerp(iSubtractConstraintSafely, i, this.animationProgress))).intValue() : 0;
        int size4 = list2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            IntrinsicMeasurable intrinsicMeasurable8 = list.get(i5);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable8), "TextField")) {
                int iIntValue4 = function2.invoke(intrinsicMeasurable8, Integer.valueOf(iSubtractConstraintSafely)).intValue();
                int size5 = list2.size();
                for (int i6 = 0; i6 < size5; i6++) {
                    IntrinsicMeasurable intrinsicMeasurable9 = list.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable9), "Hint")) {
                        intrinsicMeasurable = intrinsicMeasurable9;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable;
                return OutlinedTextFieldKt.m2490calculateHeightO3s9Psw(iIntValue, iIntValue2, iIntValue4, iIntValue3, intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0, this.animationProgress, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
