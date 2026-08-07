package androidx.compose.foundation.pager;

import androidx.collection.IntObjectMapKt;
import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PagerMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-pageSpacing$0, reason: not valid java name */
    final /* synthetic */ float f53$$v$c$androidxcomposeuiunitDp$pageSpacing$0;
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState pagerState, Orientation orientation, PaddingValues paddingValues, boolean z, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function1, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPosition snapPosition, CoroutineScope coroutineScope) {
        this.$state = pagerState;
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.f53$$v$c$androidxcomposeuiunitDp$pageSpacing$0 = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function1;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondViewportPageCount = i;
        this.$snapPosition = snapPosition;
        this.$coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public final MeasureResult mo1333measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        int iM9640getMaxWidthimpl;
        long jM9809constructorimpl;
        ObservableScopeInvalidator.m1436attachToScopeimpl(this.$state.m1523getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m623checkScrollableContainerConstraintsK40F9xA(j, z ? Orientation.Vertical : Orientation.Horizontal);
        if (z) {
            i = lazyLayoutMeasureScope.mo748roundToPx0680j_4(this.$contentPadding.mo1163calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo748roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (z) {
            i2 = lazyLayoutMeasureScope.mo748roundToPx0680j_4(this.$contentPadding.mo1164calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo748roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i4 = lazyLayoutMeasureScope.mo748roundToPx0680j_4(this.$contentPadding.getTop());
        int i5 = lazyLayoutMeasureScope.mo748roundToPx0680j_4(this.$contentPadding.getBottom());
        final int i6 = i4 + i5;
        final int i7 = i + i2;
        int i8 = z ? i6 : i7;
        if (z && !this.$reverseLayout) {
            i3 = i4;
        } else if (z && this.$reverseLayout) {
            i3 = i5;
        } else {
            i3 = (z || this.$reverseLayout) ? i2 : i;
        }
        int i9 = i8 - i3;
        long jM9659offsetNN6EwU = ConstraintsKt.m9659offsetNN6EwU(j, -i7, -i6);
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        this.$state.setDensity$foundation(lazyLayoutMeasureScope2);
        int i10 = lazyLayoutMeasureScope.mo748roundToPx0680j_4(this.f53$$v$c$androidxcomposeuiunitDp$pageSpacing$0);
        if (z) {
            iM9640getMaxWidthimpl = Constraints.m9639getMaxHeightimpl(j) - i6;
        } else {
            iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j) - i7;
        }
        if (!this.$reverseLayout || iM9640getMaxWidthimpl > 0) {
            jM9809constructorimpl = IntOffset.m9809constructorimpl((((long) i) << 32) | (((long) i4) & 4294967295L));
        } else {
            if (!z) {
                i += iM9640getMaxWidthimpl;
            }
            if (z) {
                i4 += iM9640getMaxWidthimpl;
            }
            jM9809constructorimpl = IntOffset.m9809constructorimpl((((long) i4) & 4294967295L) | (((long) i) << 32));
        }
        long j2 = jM9809constructorimpl;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, iM9640getMaxWidthimpl, i10), 0);
        this.$state.m1527setPremeasureConstraintsBRTryo0$foundation(ConstraintsKt.Constraints$default(0, this.$orientation == Orientation.Vertical ? Constraints.m9640getMaxWidthimpl(jM9659offsetNN6EwU) : iCoerceAtLeast, 0, this.$orientation != Orientation.Vertical ? Constraints.m9639getMaxHeightimpl(jM9659offsetNN6EwU) : iCoerceAtLeast, 5, null));
        PagerLazyLayoutItemProvider pagerLazyLayoutItemProviderInvoke = this.$itemProviderLambda.invoke();
        int i11 = iM9640getMaxWidthimpl + i3 + i9;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        PagerState pagerState = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int iMatchScrollPositionWithKey$foundation = pagerState.matchScrollPositionWithKey$foundation(pagerLazyLayoutItemProviderInvoke, pagerState.getCurrentPage());
            int iCurrentPageOffset = PagerKt.currentPageOffset(snapPosition, i11, iCoerceAtLeast, i10, i3, i9, pagerState.getCurrentPage(), pagerState.getCurrentPageOffsetFraction(), pagerState.getPageCount());
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            int i12 = iM9640getMaxWidthimpl;
            int i13 = i3;
            PagerMeasureResult pagerMeasureResultM1519measurePager7L1iB3k = PagerMeasureKt.m1519measurePager7L1iB3k(lazyLayoutMeasureScope, this.$pageCount.invoke().intValue(), pagerLazyLayoutItemProviderInvoke, i12, i13, i9, i10, iMatchScrollPositionWithKey$foundation, iCurrentPageOffset, jM9659offsetNN6EwU, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j2, iCoerceAtLeast, this.$beyondViewportPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(pagerLazyLayoutItemProviderInvoke, this.$state.getPinnedPages(), this.$state.getBeyondBoundsInfo()), this.$snapPosition, this.$state.m1524getPlacementScopeInvalidatorzYiylxw$foundation(), this.$coroutineScope, lazyLayoutMeasureScope2, new Function3() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1.measure_0kLqBqw$lambda$2(lazyLayoutMeasureScope, j, i7, i6, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                }
            }, IntObjectMapKt.mutableIntObjectMapOf());
            PagerState.applyMeasureResult$foundation$default(this.$state, pagerMeasureResultM1519measurePager7L1iB3k, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            PagerMeasurePolicyKt.keepAroundItems(lazyLayoutMeasureScope, this.$state.getCacheWindowLogic(), pagerMeasureResultM1519measurePager7L1iB3k.getVisiblePagesInfo());
            return pagerMeasureResultM1519measurePager7L1iB3k;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$2(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.m9657constrainWidthK40F9xA(j, i3 + i), ConstraintsKt.m9656constrainHeightK40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
