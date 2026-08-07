package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.box.android.domain.metrics.hubs.HubsObservability;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010!\u001a\u00020\"*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\"\u0010+\u001a\u00020,*\u00020-2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020,H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/AnimatedMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionProgress", "Lkotlin/Function0;", "", "indicatorAnimationProgress", "topIconIndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "startIconToLabelHorizontalPadding", "itemHorizontalPadding", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIconPosition--xw1Ddg", "()I", "I", "getIconPositionProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorAnimationProgress", "getTopIconIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getTopIconIndicatorVerticalPadding-D9Ej5fM", "getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM", "getStartIconIndicatorHorizontalPadding-D9Ej5fM", "getStartIconIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "getItemHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimatedMeasurePolicy implements MeasurePolicy {
    private final int iconPosition;
    private final Function0<Float> iconPositionProgress;
    private final Function0<Float> indicatorAnimationProgress;
    private final float itemHorizontalPadding;
    private final float startIconIndicatorHorizontalPadding;
    private final float startIconIndicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;
    private final float topIconIndicatorHorizontalPadding;
    private final float topIconIndicatorToLabelVerticalPadding;
    private final float topIconIndicatorVerticalPadding;

    public /* synthetic */ AnimatedMeasurePolicy(int i, Function0 function0, Function0 function1, float f, float f2, float f3, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function0, function1, f, f2, f3, f4, f5, f6, f7);
    }

    private AnimatedMeasurePolicy(int i, Function0<Float> function0, Function0<Float> function1, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.iconPosition = i;
        this.iconPositionProgress = function0;
        this.indicatorAnimationProgress = function1;
        this.topIconIndicatorHorizontalPadding = f;
        this.topIconIndicatorVerticalPadding = f2;
        this.topIconIndicatorToLabelVerticalPadding = f3;
        this.startIconIndicatorHorizontalPadding = f4;
        this.startIconIndicatorVerticalPadding = f5;
        this.startIconToLabelHorizontalPadding = f6;
        this.itemHorizontalPadding = f7;
    }

    /* JADX INFO: renamed from: getIconPosition--xw1Ddg, reason: not valid java name and from getter */
    public final int getIconPosition() {
        return this.iconPosition;
    }

    public final Function0<Float> getIconPositionProgress() {
        return this.iconPositionProgress;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorHorizontalPadding() {
        return this.topIconIndicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorVerticalPadding() {
        return this.topIconIndicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorToLabelVerticalPadding() {
        return this.topIconIndicatorToLabelVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconIndicatorHorizontalPadding() {
        return this.startIconIndicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getStartIconIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconIndicatorVerticalPadding() {
        return this.startIconIndicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconToLabelHorizontalPadding() {
        return this.startIconToLabelHorizontalPadding;
    }

    /* JADX INFO: renamed from: getItemHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        float fFloatValue = this.indicatorAnimationProgress.invoke().floatValue();
        float fFloatValue2 = this.iconPositionProgress.invoke().floatValue();
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), HubsObservability.HUB_ASSET_ICON)) {
                Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                        Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
                        float f = 2;
                        int width = placeableMo8265measureBRTryo0.getWidth() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(this.topIconIndicatorHorizontalPadding * f));
                        int height = placeableMo8265measureBRTryo0.getHeight() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(this.topIconIndicatorVerticalPadding * f));
                        int width2 = placeableMo8265measureBRTryo0.getWidth() + placeableMo8265measureBRTryo1.getWidth() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(this.startIconToLabelHorizontalPadding + Dp.m9687constructorimpl(this.startIconIndicatorHorizontalPadding * f)));
                        int iMax = Math.max(placeableMo8265measureBRTryo0.getHeight(), placeableMo8265measureBRTryo1.getHeight()) + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(this.startIconIndicatorVerticalPadding * f));
                        int iLerp = MathHelpersKt.lerp(width, width2, fFloatValue2);
                        int iRoundToInt = MathKt.roundToInt(iLerp * fFloatValue);
                        int iLerp2 = MathHelpersKt.lerp(height, iMax, fFloatValue2);
                        int size3 = list2.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Measurable measurable3 = list.get(i3);
                            int i4 = size3;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                Placeable placeableMo8265measureBRTryo2 = measurable3.mo8265measureBRTryo0(ConstraintsKt.m9655constrainN9IONVI(jM9630copyZbe2FdA$default, Constraints.INSTANCE.m9650fixedJhjzzOo(iLerp, iLerp2)));
                                int size4 = list2.size();
                                int i5 = 0;
                                while (i5 < size4) {
                                    Measurable measurable4 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "indicator")) {
                                        return NavigationItemKt.m3911placeAnimatedLabelAndIcon2QYhCQ8(measureScope, this.iconPosition, this.iconPositionProgress, placeableMo8265measureBRTryo1, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo2, measurable4.mo8265measureBRTryo0(ConstraintsKt.m9655constrainN9IONVI(jM9630copyZbe2FdA$default, Constraints.INSTANCE.m9650fixedJhjzzOo(iRoundToInt, iLerp2))), width, jM9630copyZbe2FdA$default, this.topIconIndicatorToLabelVerticalPadding, this.topIconIndicatorVerticalPadding, this.topIconIndicatorHorizontalPadding, this.startIconIndicatorHorizontalPadding, this.startIconIndicatorVerticalPadding, this.startIconToLabelHorizontalPadding, this.itemHorizontalPadding);
                                    }
                                    i5++;
                                    placeableMo8265measureBRTryo1 = placeableMo8265measureBRTryo1;
                                    placeableMo8265measureBRTryo2 = placeableMo8265measureBRTryo2;
                                    placeableMo8265measureBRTryo0 = placeableMo8265measureBRTryo0;
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i3++;
                            size3 = i4;
                            list2 = list2;
                            placeableMo8265measureBRTryo1 = placeableMo8265measureBRTryo1;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    measureScope = measureScope;
                    list2 = list2;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), HubsObservability.HUB_ASSET_ICON)) {
                int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), "label")) {
                        int iMaxIntrinsicWidth2 = intrinsicMeasurable2.maxIntrinsicWidth(i);
                        if (NavigationItemIconPosition.m3890equalsimpl0(this.iconPosition, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg())) {
                            float f = 2;
                            return Math.max(iMaxIntrinsicWidth2, iMaxIntrinsicWidth + intrinsicMeasureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(Dp.m9687constructorimpl(this.topIconIndicatorHorizontalPadding * f) + Dp.m9687constructorimpl(this.itemHorizontalPadding * f))));
                        }
                        return iMaxIntrinsicWidth + iMaxIntrinsicWidth2 + intrinsicMeasureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(this.startIconIndicatorHorizontalPadding * 2) + this.startIconToLabelHorizontalPadding) + this.itemHorizontalPadding));
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
