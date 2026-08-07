package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.SwipeEdge;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
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
final class SearchBarKt$FullScreenSearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $firstInProgressValue;
    final /* synthetic */ PaddingValues $inputFieldPadding;
    final /* synthetic */ boolean $isContained;
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $lastInProgressValue;
    final /* synthetic */ SearchBarState $state;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBarKt$FullScreenSearchBarLayout$2$1(MutableState<BackEventProgress.InProgress> mutableState, SearchBarState searchBarState, boolean z, PaddingValues paddingValues, MutableWindowInsets mutableWindowInsets, MutableState<BackEventProgress.InProgress> mutableState2) {
        this.$lastInProgressValue = mutableState;
        this.$state = searchBarState;
        this.$isContained = z;
        this.$inputFieldPadding = paddingValues;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$firstInProgressValue = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int iLerp;
        final MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        final long j2 = j;
        float fTransform = SearchBarKt.transform(this.$lastInProgressValue.getValue());
        Integer numValueOf = Integer.valueOf(SearchBarKt.getCollapsedBounds(this.$state).getWidth());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : measureScope2.mo748roundToPx0680j_4(SearchBarKt.getSearchBarMinWidth());
        Integer numValueOf2 = Integer.valueOf(SearchBarKt.getCollapsedBounds(this.$state).getHeight());
        Integer num = numValueOf2.intValue() != 0 ? numValueOf2 : null;
        int iIntValue2 = num != null ? num.intValue() : measureScope2.mo748roundToPx0680j_4(SearchBarDefaults.INSTANCE.m4060getInputFieldHeightD9Ej5fM());
        final int iCoerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.m9640getMaxWidthimpl(j2) * 0.9f), iIntValue);
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.m9639getMaxHeightimpl(j2) * 0.9f), iIntValue2);
        int iLerp2 = MathHelpersKt.lerp(Constraints.m9640getMaxWidthimpl(j2), iCoerceAtLeast, fTransform);
        int iLerp3 = MathHelpersKt.lerp(Constraints.m9639getMaxHeightimpl(j2), iCoerceAtLeast2, fTransform);
        if (!this.$isContained) {
            iLerp2 = ConstraintsKt.m9657constrainWidthK40F9xA(j2, MathHelpersKt.lerp(iIntValue, iLerp2, this.$state.getProgress()));
            iLerp3 = ConstraintsKt.m9656constrainHeightK40F9xA(j2, MathHelpersKt.lerp(iIntValue2, iLerp3, this.$state.getProgress()));
        }
        List<? extends Measurable> list3 = list2;
        int size = list3.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable = list2.get(i2);
            float f = fTransform;
            final int i3 = iCoerceAtLeast2;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Surface")) {
                Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(iLerp2, iLerp3));
                int iLerp4 = MathHelpersKt.lerp(iIntValue, (iLerp2 - measureScope2.mo748roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$inputFieldPadding, measureScope2.getLayoutDirection()))) - measureScope2.mo748roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$inputFieldPadding, measureScope2.getLayoutDirection())), this.$state.getAnimatable$material3().getValue().floatValue());
                int size2 = list3.size();
                int i4 = 0;
                while (i4 < size2) {
                    Measurable measurable2 = list2.get(i4);
                    final Placeable placeable = placeableMo8265measureBRTryo0;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                        Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(iLerp4, iIntValue2));
                        int top = this.$unconsumedInsets.getTop(measureScope2);
                        if (this.$isContained) {
                            i = measureScope2.mo748roundToPx0680j_4(SearchBarKt.getAppBarWithSearchVerticalPadding());
                        } else {
                            i = measureScope2.mo748roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        }
                        int i5 = top + i;
                        final int iLerp5 = MathHelpersKt.lerp(0, i5, Math.min(this.$state.getProgress(), 1 - f));
                        if (this.$isContained) {
                            iLerp = measureScope2.mo748roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        } else {
                            iLerp = MathHelpersKt.lerp(0, measureScope2.mo748roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding()), this.$state.getProgress());
                        }
                        final int i6 = iLerp;
                        int height = placeableMo8265measureBRTryo1.getHeight() + iLerp5 + i6;
                        int size3 = list3.size();
                        int i7 = 0;
                        while (i7 < size3) {
                            Measurable measurable3 = list2.get(i7);
                            final Placeable placeable2 = placeableMo8265measureBRTryo1;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Content")) {
                                final Placeable placeableMo8265measureBRTryo2 = measurable3.mo8265measureBRTryo0(ConstraintsKt.Constraints(iLerp2, iLerp2, 0, RangesKt.coerceAtLeast(iLerp3 - height, 0)));
                                int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j2);
                                int iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j2);
                                final MutableState<BackEventProgress.InProgress> mutableState = this.$lastInProgressValue;
                                final float f2 = f;
                                final int i8 = i5;
                                final boolean z = this.$isContained;
                                final SearchBarState searchBarState = this.$state;
                                final MutableState<BackEventProgress.InProgress> mutableState2 = this.$firstInProgressValue;
                                final int i9 = iLerp2;
                                return MeasureScope.layout$default(measureScope, iM9640getMaxWidthimpl, iM9639getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$5(mutableState, f2, z, searchBarState, i9, placeable, placeable2, iLerp5, placeableMo8265measureBRTryo2, i6, j2, measureScope2, iCoerceAtLeast, mutableState2, i3, i8, (Placeable.PlacementScope) obj);
                                    }
                                }, 4, null);
                            }
                            i7++;
                            measureScope2 = measureScope;
                            list2 = list;
                            j2 = j;
                            i5 = i5;
                            f = f;
                            placeableMo8265measureBRTryo1 = placeable2;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i4++;
                    measureScope2 = measureScope;
                    list2 = list;
                    j2 = j;
                    placeableMo8265measureBRTryo0 = placeable;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            fTransform = f;
            i2++;
            measureScope2 = measureScope;
            list2 = list;
            j2 = j;
            iCoerceAtLeast2 = i3;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final int measure_3p2s80s$lambda$5$endOffsetX(BackEventProgress.InProgress inProgress, long j, MeasureScope measureScope, int i, SearchBarState searchBarState) {
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(inProgress.getSwipeEdge() == SwipeEdge.Left ? (Constraints.m9640getMaxWidthimpl(j) - measureScope.mo748roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin)) - i : measureScope.mo748roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin), SearchBarKt.getCollapsedBounds(searchBarState).getRight() - i), SearchBarKt.getCollapsedBounds(searchBarState).getLeft());
    }

    private static final int measure_3p2s80s$lambda$5$endOffsetY(BackEventProgress.InProgress inProgress, MutableState<BackEventProgress.InProgress> mutableState, long j, int i, MeasureScope measureScope, int i2, SearchBarState searchBarState) {
        float touchY = inProgress.getTouchY();
        BackEventProgress.InProgress value = mutableState.getValue();
        if (value == null) {
            return 0;
        }
        float touchY2 = touchY - value.getTouchY();
        return RangesKt.coerceAtMost((MathHelpersKt.lerp(0, Math.min(RangesKt.coerceAtLeast(((Constraints.m9639getMaxHeightimpl(j) - i) / 2) - measureScope.mo748roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin), 0), measureScope.mo748roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMaxOffsetY)), Math.abs(touchY2) / Constraints.m9639getMaxHeightimpl(j)) * ((int) Math.signum(touchY2))) + i2, SearchBarKt.getCollapsedBounds(searchBarState).getTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5(MutableState mutableState, float f, final boolean z, SearchBarState searchBarState, int i, Placeable placeable, Placeable placeable2, int i2, Placeable placeable3, int i3, long j, MeasureScope measureScope, int i4, MutableState mutableState2, int i5, int i6, Placeable.PlacementScope placementScope) {
        final SearchBarState searchBarState2;
        int iMeasure_3p2s80s$lambda$5$endOffsetY;
        BackEventProgress.InProgress inProgress = (BackEventProgress.InProgress) mutableState.getValue();
        int iLerp = MathHelpersKt.lerp(0, inProgress != null ? measure_3p2s80s$lambda$5$endOffsetX(inProgress, j, measureScope, i4, searchBarState) : 0, f);
        if (!z) {
            iLerp = MathHelpersKt.lerp(SearchBarKt.getCollapsedBounds(searchBarState).getLeft(), iLerp, searchBarState.getProgress());
        }
        int i7 = iLerp;
        float fLerp = MathHelpersKt.lerp(IntOffset.m9815getXimpl(SearchBarKt.getCollapsedBounds(searchBarState).m9839getCenternOccac()), i7 + (i / 2.0f), searchBarState.getAnimatable$material3().getValue().floatValue());
        BackEventProgress.InProgress inProgress2 = (BackEventProgress.InProgress) mutableState.getValue();
        if (inProgress2 != null) {
            iMeasure_3p2s80s$lambda$5$endOffsetY = measure_3p2s80s$lambda$5$endOffsetY(inProgress2, mutableState2, j, i5, measureScope, i6, searchBarState);
            searchBarState2 = searchBarState;
        } else {
            searchBarState2 = searchBarState;
            iMeasure_3p2s80s$lambda$5$endOffsetY = 0;
        }
        int iLerp2 = MathHelpersKt.lerp(0, iMeasure_3p2s80s$lambda$5$endOffsetY, f);
        int iLerp3 = MathHelpersKt.lerp(SearchBarKt.getCollapsedBounds(searchBarState2).getTop(), iLerp2, searchBarState2.getProgress());
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, i7, z ? iLerp2 : iLerp3, 0.0f, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$5$0(z, searchBarState2, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        int i8 = iLerp3 + i2;
        Placeable.PlacementScope.place$default(placementScope, placeable2, MathKt.roundToInt(fLerp - (placeable2.getWidth() / 2.0f)), i8, 0.0f, 4, null);
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable3, i7, i8 + placeable2.getHeight() + i3, 0.0f, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$5$1(z, searchBarState2, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5$0(boolean z, SearchBarState searchBarState, GraphicsLayerScope graphicsLayerScope) {
        if (z) {
            graphicsLayerScope.setAlpha(searchBarState.getProgress());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5$1(boolean z, SearchBarState searchBarState, GraphicsLayerScope graphicsLayerScope) {
        float progress;
        if (z) {
            progress = searchBarState.getContentProgress$material3();
        } else {
            progress = searchBarState.getProgress();
        }
        graphicsLayerScope.setAlpha(progress);
        return Unit.INSTANCE;
    }
}
