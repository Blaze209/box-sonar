package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SearchBarKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBarKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> animatable, MutableWindowInsets mutableWindowInsets, MutableState<BackEventCompat> mutableState, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState2) {
        this.$animationProgress = animatable;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$currentBackEvent = mutableState;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        final Placeable placeableMo8265measureBRTryo0;
        int i;
        int iM9639getMaxHeightimpl;
        final float fFloatValue = this.$animationProgress.getValue().floatValue();
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable2 = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable3 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                break;
                            }
                            i4++;
                        }
                        Measurable measurable4 = measurable;
                        final int top = this.$unconsumedInsets.getTop(measureScope) + measureScope.mo748roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i5 = measureScope.mo748roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(j, measurable2.maxIntrinsicWidth(Constraints.m9639getMaxHeightimpl(j)));
                        int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(j, measurable2.minIntrinsicHeight(Constraints.m9640getMaxWidthimpl(j)));
                        int iRoundToInt = MathKt.roundToInt(Constraints.m9640getMaxWidthimpl(j) * 0.9f);
                        int iRoundToInt2 = MathKt.roundToInt(Constraints.m9639getMaxHeightimpl(j) * 0.9f);
                        final float fCalculatePredictiveBackMultiplier = SearchBarKt.calculatePredictiveBackMultiplier(this.$currentBackEvent.getValue(), fFloatValue, this.$finalBackProgress.getFloatValue());
                        int iLerp = MathHelpersKt.lerp(iM9657constrainWidthK40F9xA, iRoundToInt, fCalculatePredictiveBackMultiplier);
                        int i6 = top + iM9656constrainHeightK40F9xA;
                        int iLerp2 = MathHelpersKt.lerp(i6, iRoundToInt2, fCalculatePredictiveBackMultiplier);
                        int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
                        int iM9639getMaxHeightimpl2 = Constraints.m9639getMaxHeightimpl(j);
                        int iLerp3 = MathHelpersKt.lerp(iLerp, iM9640getMaxWidthimpl, fFloatValue);
                        final int iLerp4 = MathHelpersKt.lerp(iLerp2, iM9639getMaxHeightimpl2, fFloatValue);
                        final int iLerp5 = MathHelpersKt.lerp(top, 0, fFloatValue);
                        final int iLerp6 = MathHelpersKt.lerp(0, i5, fFloatValue);
                        final Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(ConstraintsKt.Constraints(iLerp3, iM9640getMaxWidthimpl, iM9656constrainHeightK40F9xA, iM9656constrainHeightK40F9xA));
                        int width = placeableMo8265measureBRTryo1.getWidth();
                        final Placeable placeableMo8265measureBRTryo2 = measurable3.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(width, iLerp4 - iLerp5));
                        if (measurable4 != null) {
                            if (Constraints.m9635getHasBoundedHeightimpl(j)) {
                                i = 0;
                                iM9639getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m9639getMaxHeightimpl(j) - (i6 + i5), 0);
                            } else {
                                i = 0;
                                iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j);
                            }
                            placeableMo8265measureBRTryo0 = measurable4.mo8265measureBRTryo0(ConstraintsKt.Constraints(width, width, i, iM9639getMaxHeightimpl));
                        } else {
                            placeableMo8265measureBRTryo0 = null;
                        }
                        final MutableState<BackEventCompat> mutableState = this.$currentBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = this.$firstBackEvent;
                        return MeasureScope.layout$default(measureScope, width, iLerp4, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$SearchBarLayout$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchBarKt$SearchBarLayout$2$1.measure_3p2s80s$lambda$3(measureScope, j, mutableState, fFloatValue, fCalculatePredictiveBackMultiplier, mutableState2, iLerp4, placeableMo8265measureBRTryo2, iLerp5, placeableMo8265measureBRTryo1, top, placeableMo8265measureBRTryo0, iLerp6, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i3++;
                    measureScope = measureScope;
                    j = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(MeasureScope measureScope, long j, MutableState mutableState, float f, float f2, MutableState mutableState2, int i, Placeable placeable, int i2, Placeable placeable2, int i3, Placeable placeable3, int i4, Placeable.PlacementScope placementScope) {
        int i5 = measureScope.mo748roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin);
        int iM4108calculatePredictiveBackOffsetXrOvwMX4 = SearchBarKt.m4108calculatePredictiveBackOffsetXrOvwMX4(j, i5, (BackEventCompat) mutableState.getValue(), measureScope.getLayoutDirection(), f, f2);
        int iM4109calculatePredictiveBackOffsetYdzo92Q0 = SearchBarKt.m4109calculatePredictiveBackOffsetYdzo92Q0(j, i5, (BackEventCompat) mutableState.getValue(), (BackEventCompat) mutableState2.getValue(), i, measureScope.mo748roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMaxOffsetY), f2);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iM4108calculatePredictiveBackOffsetXrOvwMX4, iM4109calculatePredictiveBackOffsetYdzo92Q0 + i2, 0.0f, 4, null);
        int i6 = iM4109calculatePredictiveBackOffsetYdzo92Q0 + i3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iM4108calculatePredictiveBackOffsetXrOvwMX4, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iM4108calculatePredictiveBackOffsetXrOvwMX4, i6 + placeable2.getHeight() + i4, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
