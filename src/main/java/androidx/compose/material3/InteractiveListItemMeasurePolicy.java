package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\b\u001a\u00020\t*\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J(\u0010\u0017\u001a\u00020\u0013*\u00020\u00142\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J(\u0010\u0019\u001a\u00020\u0013*\u00020\u00142\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J(\u0010\u001a\u001a\u00020\u0013*\u00020\u00142\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016JR\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\f2\u0006\u0010\u0018\u001a\u00020\u00132,\u0010\u001c\u001a(\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b H\u0002JR\u0010!\u001a\u00020\u00132\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\f2\u0006\u0010\u0016\u001a\u00020\u00132,\u0010\u001c\u001a(\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b H\u0002JN\u0010\"\u001a\u00020\t*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010$H\u0002J?\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u00100J?\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b7\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00068"}, d2 = {"Landroidx/compose/material3/InteractiveListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVerticalAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "calculateIntrinsicWidth", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicHeight", "place", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "contentPlaceable", "overlinePlaceable", "supportingPlaceable", "calculateWidth", "leadingWidth", "trailingWidth", "overlineWidth", "supportingWidth", "contentWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "calculateHeight", "leadingHeight", "trailingHeight", "overlineHeight", "supportingHeight", "contentHeight", "calculateHeight-VsPV1Ek", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InteractiveListItemMeasurePolicy implements MultiContentMeasurePolicy {
    private final Alignment.Vertical verticalAlignment;

    public InteractiveListItemMeasurePolicy(Alignment.Vertical vertical) {
        this.verticalAlignment = vertical;
    }

    public final Alignment.Vertical getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1154measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        List<? extends Measurable> list4 = list.get(2);
        List<? extends Measurable> list5 = list.get(3);
        List<? extends Measurable> list6 = list.get(4);
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull((List) list2);
        Placeable placeableMo8265measureBRTryo0 = measurable != null ? measurable.mo8265measureBRTryo0(jM9630copyZbe2FdA$default) : null;
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo0);
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull((List) list3);
        Placeable placeableMo8265measureBRTryo1 = measurable2 != null ? measurable2.mo8265measureBRTryo0(ConstraintsKt.m9660offsetNN6EwU$default(jM9630copyZbe2FdA$default, -widthOrZero, 0, 2, null)) : null;
        int widthOrZero2 = widthOrZero + LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo1);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull((List) list4);
        Placeable placeableMo8265measureBRTryo2 = measurable3 != null ? measurable3.mo8265measureBRTryo0(ConstraintsKt.m9660offsetNN6EwU$default(jM9630copyZbe2FdA$default, -widthOrZero2, 0, 2, null)) : null;
        int heightOrZero = LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo2);
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull((List) list6);
        Placeable placeableMo8265measureBRTryo3 = measurable4 != null ? measurable4.mo8265measureBRTryo0(ConstraintsKt.m9659offsetNN6EwU(jM9630copyZbe2FdA$default, -widthOrZero2, -heightOrZero)) : null;
        int heightOrZero2 = heightOrZero + LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo3);
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull((List) list5);
        Placeable placeableMo8265measureBRTryo4 = measurable5 != null ? measurable5.mo8265measureBRTryo0(ConstraintsKt.m9659offsetNN6EwU(jM9630copyZbe2FdA$default, -widthOrZero2, -heightOrZero2)) : null;
        return place(measureScope, m3613calculateWidthVsPV1Ek(LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo0), LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo1), LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo2), LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo4), LayoutUtilKt.getWidthOrZero(placeableMo8265measureBRTryo3), j), m3612calculateHeightVsPV1Ek(LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo0), LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo1), LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo2), LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo4), LayoutUtilKt.getHeightOrZero(placeableMo8265measureBRTryo3), j), placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, placeableMo8265measureBRTryo3, placeableMo8265measureBRTryo2, placeableMo8265measureBRTryo4);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicHeight", "maxIntrinsicHeight(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(list, i, AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final /* synthetic */ class C07231 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C07231 INSTANCE = new C07231();

        C07231() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicWidth", "maxIntrinsicWidth(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(list, i, C07231.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final /* synthetic */ class C07241 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C07241 INSTANCE = new C07241();

        C07241() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicHeight", "minIntrinsicHeight(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(list, i, C07241.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final /* synthetic */ class C07251 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C07251 INSTANCE = new C07251();

        C07251() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(list, i, C07251.INSTANCE);
    }

    private final int calculateIntrinsicWidth(List<? extends List<? extends IntrinsicMeasurable>> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasure) {
        List<? extends IntrinsicMeasurable> list = measurables.get(0);
        List<? extends IntrinsicMeasurable> list2 = measurables.get(1);
        List<? extends IntrinsicMeasurable> list3 = measurables.get(2);
        List<? extends IntrinsicMeasurable> list4 = measurables.get(3);
        List<? extends IntrinsicMeasurable> list5 = measurables.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list);
        int iIntValue = intrinsicMeasurable != null ? intrinsicMeasure.invoke(intrinsicMeasurable, Integer.valueOf(height)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list2);
        int iIntValue2 = intrinsicMeasurable2 != null ? intrinsicMeasure.invoke(intrinsicMeasurable2, Integer.valueOf(height)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list3);
        int iIntValue3 = intrinsicMeasurable3 != null ? intrinsicMeasure.invoke(intrinsicMeasurable3, Integer.valueOf(height)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list4);
        int iIntValue4 = intrinsicMeasurable4 != null ? intrinsicMeasure.invoke(intrinsicMeasurable4, Integer.valueOf(height)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list5);
        return m3613calculateWidthVsPV1Ek(iIntValue, iIntValue2, iIntValue3, iIntValue4, intrinsicMeasurable5 != null ? intrinsicMeasure.invoke(intrinsicMeasurable5, Integer.valueOf(height)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    private final int calculateIntrinsicHeight(List<? extends List<? extends IntrinsicMeasurable>> measurables, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasure) {
        int iSubtractConstraintSafely;
        int i;
        int i2;
        List<? extends IntrinsicMeasurable> list = measurables.get(0);
        List<? extends IntrinsicMeasurable> list2 = measurables.get(1);
        List<? extends IntrinsicMeasurable> list3 = measurables.get(2);
        List<? extends IntrinsicMeasurable> list4 = measurables.get(3);
        List<? extends IntrinsicMeasurable> list5 = measurables.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list);
        if (intrinsicMeasurable != null) {
            int iIntValue = intrinsicMeasure.invoke(intrinsicMeasurable, Integer.valueOf(width)).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(width, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            i = iIntValue;
        } else {
            iSubtractConstraintSafely = width;
            i = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list2);
        if (intrinsicMeasurable2 != null) {
            int iIntValue2 = intrinsicMeasure.invoke(intrinsicMeasurable2, Integer.valueOf(iSubtractConstraintSafely)).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            i2 = iIntValue2;
        } else {
            i2 = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list3);
        int iIntValue3 = intrinsicMeasurable3 != null ? intrinsicMeasure.invoke(intrinsicMeasurable3, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list4);
        int iIntValue4 = intrinsicMeasurable4 != null ? intrinsicMeasure.invoke(intrinsicMeasurable4, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list5);
        return m3612calculateHeightVsPV1Ek(i, i2, iIntValue3, iIntValue4, intrinsicMeasurable5 != null ? intrinsicMeasure.invoke(intrinsicMeasurable5, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    private final MeasureResult place(MeasureScope measureScope, final int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, final Placeable placeable5) {
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1() { // from class: androidx.compose.material3.InteractiveListItemMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InteractiveListItemMeasurePolicy.place$lambda$0(placeable, this, i2, placeable3, placeable4, placeable5, placeable2, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit place$lambda$0(Placeable placeable, InteractiveListItemMeasurePolicy interactiveListItemMeasurePolicy, int i, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, int i2, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, interactiveListItemMeasurePolicy.verticalAlignment.align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeable);
        int iAlign = interactiveListItemMeasurePolicy.verticalAlignment.align(LayoutUtilKt.getHeightOrZero(placeable2) + LayoutUtilKt.getHeightOrZero(placeable3) + LayoutUtilKt.getHeightOrZero(placeable4), i);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, iAlign, 0.0f, 4, null);
        }
        int heightOrZero = iAlign + LayoutUtilKt.getHeightOrZero(placeable3);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, heightOrZero, 0.0f, 4, null);
        }
        int heightOrZero2 = heightOrZero + LayoutUtilKt.getHeightOrZero(placeable2);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, widthOrZero, heightOrZero2, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i2 - placeable5.getWidth(), interactiveListItemMeasurePolicy.verticalAlignment.align(placeable5.getHeight(), i), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    private final int m3613calculateWidthVsPV1Ek(int leadingWidth, int trailingWidth, int overlineWidth, int supportingWidth, int contentWidth, long constraints) {
        if (Constraints.m9636getHasBoundedWidthimpl(constraints)) {
            return Constraints.m9640getMaxWidthimpl(constraints);
        }
        return leadingWidth + Math.max(contentWidth, Math.max(overlineWidth, supportingWidth)) + trailingWidth;
    }

    /* JADX INFO: renamed from: calculateHeight-VsPV1Ek, reason: not valid java name */
    private final int m3612calculateHeightVsPV1Ek(int leadingHeight, int trailingHeight, int overlineHeight, int supportingHeight, int contentHeight, long constraints) {
        return ConstraintsKt.m9656constrainHeightK40F9xA(constraints, Math.max(leadingHeight, Math.max(contentHeight + overlineHeight + supportingHeight, trailingHeight)));
    }
}
