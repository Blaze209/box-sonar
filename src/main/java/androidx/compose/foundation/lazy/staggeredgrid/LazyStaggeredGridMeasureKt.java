package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", ViewProps.POSITION, "Lkotlin/Function2;", "calculateExtraItems", ViewProps.FILTER, "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", Analytics.Data.ACTION, "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", ViewProps.TRANSFORM, "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* JADX INFO: renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1480measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int iM1479maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length || (iM1479maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation[i6]) == -1) {
                    iM1479maxInRangejy6DScQ = i6 == 0 ? 0 : m1479maxInRangejy6DScQ(iArr, SpanRange.m1489constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = iM1479maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation(z4)), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation, scrollOffsets, true);
    }

    /* JADX WARN: Code duplicated, block: B:334:0x06b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:335:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:338:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:340:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:341:0x06e6  */
    /* JADX WARN: Code duplicated, block: B:344:0x06ec A[LOOP:23: B:337:0x06d2->B:344:0x06ec, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:348:0x06f6  */
    /* JADX WARN: Code duplicated, block: B:349:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:352:0x071c  */
    /* JADX WARN: Code duplicated, block: B:353:0x071f  */
    /* JADX WARN: Code duplicated, block: B:355:0x0729  */
    /* JADX WARN: Code duplicated, block: B:357:0x072f A[LOOP:21: B:317:0x0684->B:357:0x072f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:359:0x073c  */
    /* JADX WARN: Code duplicated, block: B:384:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:394:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:396:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:397:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:400:0x07c3 A[LOOP:26: B:393:0x07b7->B:400:0x07c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:402:0x07c8  */
    /* JADX WARN: Code duplicated, block: B:404:0x07d5  */
    /* JADX WARN: Code duplicated, block: B:406:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:431:0x08ec  */
    /* JADX WARN: Code duplicated, block: B:456:0x0925  */
    /* JADX WARN: Code duplicated, block: B:542:0x0739 A[EDGE_INSN: B:542:0x0739->B:358:0x0739 BREAK  A[LOOP:21: B:317:0x0684->B:357:0x072f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:0x06f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x06e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:552:0x07b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:0x0765 A[SYNTHETIC] */
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        char c;
        int i2;
        int iIndexOf;
        int i3;
        int i4;
        int i5;
        int[] iArr3;
        int[] iArr4;
        int i6;
        String str;
        int i7;
        int iM9657constrainWidthK40F9xA;
        int iM9639getMaxHeightimpl;
        List listEmptyList;
        List<LazyStaggeredGridMeasuredItem> list;
        ArrayList arrayList;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        boolean z4;
        ArrayList arrayList2;
        List<Integer> list2;
        boolean z5;
        int lane;
        int length;
        int i10;
        boolean z6;
        boolean z7;
        boolean z8;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        boolean z9;
        List<LazyStaggeredGridItemInfo> visibleItemsInfo;
        int size;
        int i11;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3;
        int lane2;
        int[] positions;
        int i12;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4;
        List<LazyStaggeredGridItemInfo> list3;
        boolean z10;
        boolean z11;
        boolean z12;
        int i13;
        int[] gaps;
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints());
            int iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured(0, iM9642getMinWidthimpl, iM9641getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long jM1413getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m1413getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m9856equalsimpl0(jM1413getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m9863getZeroYbymL2g())) {
                    iM9642getMinWidthimpl = ConstraintsKt.m9657constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM9641getMinHeightimpl = ConstraintsKt.m9656constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, iM9642getMinWidthimpl, iM9641getMinHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyStaggeredGridMeasureKt.measure$lambda$0$0((Placeable.PlacementScope) obj);
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m9853constructorimpl((((long) Constraints.m9641getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints())) & 4294967295L) | (((long) Constraints.m9642getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints())) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        String str2 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, iArrCopyOf, itemCount);
        offsetBy(iArrCopyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i14 = 0; i14 < laneCount; i14++) {
            arrayDequeArr[i14] = new ArrayDeque(16);
        }
        offsetBy(iArrCopyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z13 = false;
        while (true) {
            if (!measure$lambda$0$hasSpaceBeforeFirst(iArrCopyOf, iArrCopyOf2, lazyStaggeredGridMeasureContext2)) {
                c = ' ';
                i2 = 0;
                iIndexOf = -1;
                break;
            }
            iIndexOf = indexOfMaxValue(iArrCopyOf);
            c = ' ';
            int i15 = iArrCopyOf[iIndexOf];
            int length2 = iArrCopyOf2.length;
            for (int i16 = 0; i16 < length2; i16++) {
                if (iArrCopyOf[i16] != iArrCopyOf[iIndexOf]) {
                    int i17 = iArrCopyOf2[i16];
                    int i18 = iArrCopyOf2[iIndexOf];
                    if (i17 < i18) {
                        iArrCopyOf2[i16] = i18;
                    }
                }
            }
            i2 = 0;
            int iFindPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i15, iIndexOf);
            if (iFindPreviousItemIndex < 0) {
                break;
            }
            long jM1474getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex, iIndexOf);
            int i19 = (int) (jM1474getSpanRangelOCCd4c & 4294967295L);
            ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
            boolean z14 = z13;
            int i20 = (int) (jM1474getSpanRangelOCCd4c >> 32);
            int i21 = i19 - i20;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iFindPreviousItemIndex, i21 != 1 ? -2 : i20);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iFindPreviousItemIndex, jM1474getSpanRangelOCCd4c);
            int iM1479maxInRangejy6DScQ = m1479maxInRangejy6DScQ(iArrCopyOf2, jM1474getSpanRangelOCCd4c);
            int[] gaps2 = i21 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex) : null;
            boolean z15 = z14;
            while (i20 < i19) {
                iArrCopyOf[i20] = iFindPreviousItemIndex;
                int mainAxisSizeWithSpacings = iM1479maxInRangejy6DScQ + lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i20]);
                iArrCopyOf2[i20] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z15 = true;
                }
                i20++;
            }
            arrayDequeArr = arrayDequeArr2;
            z13 = z15;
        }
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        boolean z16 = z13;
        int i22 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i23 = iArrCopyOf2[i2];
        if (i23 < i22) {
            offsetBy(iArrCopyOf2, i22 - i23);
            i3 = i - (i22 - i23);
        } else {
            i3 = i;
        }
        offsetBy(iArrCopyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i24 = -1;
        if (iIndexOf == -1) {
            iIndexOf = ArraysKt.indexOf(iArrCopyOf, i2);
        }
        if (iIndexOf != -1 && measure$lambda$0$misalignedStart(iArrCopyOf, lazyStaggeredGridMeasureContext2, iArrCopyOf2, iIndexOf) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length3 = iArrCopyOf.length;
            int[] iArr5 = new int[length3];
            int i25 = 0;
            while (i25 < length3) {
                iArr5[i25] = i24;
                i25++;
                i24 = -1;
            }
            int length4 = iArrCopyOf2.length;
            int[] iArr6 = new int[length4];
            for (int i26 = 0; i26 < length4; i26++) {
                iArr6[i26] = iArrCopyOf2[iIndexOf];
            }
            return measure(lazyStaggeredGridMeasureContext2, i3, iArr5, iArr6, false);
        }
        int[] iArrCopyOf3 = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf3, "copyOf(...)");
        int length5 = iArrCopyOf2.length;
        int[] iArr7 = new int[length5];
        for (int i27 = 0; i27 < length5; i27++) {
            iArr7[i27] = -iArrCopyOf2[i27];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i22;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        ArrayDeque[] arrayDequeArr4 = arrayDequeArr3;
        int iIndexOfMinValue$default = indexOfMinValue$default(iArrCopyOf3, 0, 1, null);
        int laneCount2 = 0;
        while (iIndexOfMinValue$default != -1 && laneCount2 < lazyStaggeredGridMeasureContext2.getLaneCount()) {
            int i28 = iArrCopyOf3[iIndexOfMinValue$default];
            iIndexOfMinValue$default = indexOfMinValue(iArrCopyOf3, i28);
            laneCount2++;
            if (i28 >= 0) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope = measureScope;
                int i29 = i3;
                long jM1474getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i28, iIndexOfMinValue$default);
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(i28, jM1474getSpanRangelOCCd4c2);
                int[] iArr8 = iArrCopyOf;
                int[] iArr9 = iArrCopyOf2;
                int i30 = (int) (jM1474getSpanRangelOCCd4c2 & 4294967295L);
                int i31 = itemCount;
                int i32 = (int) (jM1474getSpanRangelOCCd4c2 >> c);
                int i33 = i30 - i32;
                lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(i28, i33 != 1 ? -2 : i32);
                int iM1479maxInRangejy6DScQ2 = m1479maxInRangejy6DScQ(iArr7, jM1474getSpanRangelOCCd4c2);
                for (int i34 = i32; i34 < i30; i34++) {
                    iArr7[i34] = lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + iM1479maxInRangejy6DScQ2;
                    iArrCopyOf3[i34] = i28;
                    arrayDequeArr4[i34].addLast(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2);
                }
                if (iM1479maxInRangejy6DScQ2 >= mainAxisSpacing || iArr7[i32] > mainAxisSpacing) {
                    z16 = z16;
                } else {
                    lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2.setVisible(false);
                    z16 = true;
                }
                laneCount2 = i33 != 1 ? lazyStaggeredGridMeasureContext2.getLaneCount() : laneCount2;
                measureScope = lazyLayoutMeasureScope;
                i3 = i29;
                iArrCopyOf = iArr8;
                iArrCopyOf2 = iArr9;
                itemCount = i31;
            } else {
                iIndexOfMinValue$default = iIndexOfMinValue$default;
            }
        }
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = measureScope;
        int i35 = i3;
        int[] iArr10 = iArrCopyOf;
        int[] iArr11 = iArrCopyOf2;
        int i36 = itemCount;
        loop9: while (true) {
            int i37 = 0;
            while (true) {
                if (i37 >= length5) {
                    for (int i38 = 0; i38 < laneCount; i38++) {
                        if (!arrayDequeArr4[i38].isEmpty()) {
                            i4 = i36;
                            i5 = 1;
                            break loop9;
                        }
                    }
                    break;
                }
                int i39 = iArr7[i37];
                if (i39 < iCoerceAtLeast || i39 <= 0) {
                    break;
                }
                i37++;
            }
            i5 = 1;
            int iIndexOfMinValue$default2 = indexOfMinValue$default(iArr7, 0, 1, null);
            int iMaxOrThrow = ArraysKt.maxOrThrow(iArrCopyOf3) + 1;
            i4 = i36;
            if (iMaxOrThrow >= i4) {
                break;
            }
            int i40 = length5;
            String str3 = str2;
            boolean z17 = z16;
            ArrayDeque[] arrayDequeArr5 = arrayDequeArr4;
            int i41 = iCoerceAtLeast;
            LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope2;
            int i42 = i35;
            long jM1474getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iMaxOrThrow, iIndexOfMinValue$default2);
            int[] iArr12 = iArrCopyOf3;
            int i43 = (int) (jM1474getSpanRangelOCCd4c3 & 4294967295L);
            int i44 = (int) (jM1474getSpanRangelOCCd4c3 >> c);
            int i45 = i43 - i44;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iMaxOrThrow, i45 != 1 ? -2 : i44);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iMaxOrThrow, jM1474getSpanRangelOCCd4c3);
            int iM1479maxInRangejy6DScQ3 = m1479maxInRangejy6DScQ(iArr7, jM1474getSpanRangelOCCd4c3);
            if (i45 != 1) {
                gaps = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iMaxOrThrow);
                if (gaps == null) {
                    gaps = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                gaps = null;
            }
            for (int i46 = i44; i46 < i43; i46++) {
                if (gaps != null) {
                    gaps[i46] = iM1479maxInRangejy6DScQ3 - iArr7[i46];
                }
                iArr12[i46] = iMaxOrThrow;
                iArr7[i46] = iM1479maxInRangejy6DScQ3 + lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                arrayDequeArr5[i46].addLast(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(iMaxOrThrow, gaps);
            if (iM1479maxInRangejy6DScQ3 < mainAxisSpacing && iArr7[i44] <= mainAxisSpacing) {
                lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            iArrCopyOf3 = iArr12;
            z16 = z17;
            i36 = i4;
            str2 = str3;
            lazyLayoutMeasureScope2 = lazyLayoutMeasureScope3;
            iCoerceAtLeast = i41;
            arrayDequeArr4 = arrayDequeArr5;
            length5 = i40;
            i35 = i42;
        }
        int i47 = 0;
        while (i47 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr4[i47];
            while (arrayDeque.size() > i5 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps3 = lazyStaggeredGridMeasuredItem.getSpan() != i5 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr11[i47] = iArr11[i47] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i47]));
                i5 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr10[i47] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i47++;
            i5 = 1;
        }
        for (int i48 : iArrCopyOf3) {
            if (i48 == i4 - 1) {
                offsetBy(iArr7, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            }
        }
        int i49 = 0;
        while (true) {
            if (i49 < length5) {
                if (iArr7[i49] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i4 = i4;
                    i7 = i35;
                    i35 = i7;
                    iArr4 = iArr10;
                    iArr3 = iArr11;
                    iCoerceAtLeast = iCoerceAtLeast;
                    i6 = length5;
                    str = str2;
                    break;
                }
                i49++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr7[indexOfMaxValue(iArr7)];
                iArr3 = iArr11;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr7, mainAxisAvailableSize);
                boolean z18 = false;
                loop31: while (true) {
                    int length6 = iArr3.length;
                    int i50 = 0;
                    while (true) {
                        if (i50 >= length6) {
                            iArr4 = iArr10;
                            break loop31;
                        }
                        if (iArr3[i50] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i50++;
                        length5 = length5;
                        iArr10 = iArr10;
                        i35 = i35;
                    }
                    int iIndexOfMinValue$default3 = indexOfMinValue$default(iArr3, 0, 1, null);
                    int iIndexOfMaxValue = indexOfMaxValue(iArr10);
                    if (iIndexOfMinValue$default3 != iIndexOfMaxValue) {
                        if (iArr3[iIndexOfMinValue$default3] == iArr3[iIndexOfMaxValue]) {
                            iIndexOfMinValue$default3 = iIndexOfMaxValue;
                        } else {
                            z18 = true;
                        }
                    }
                    int i51 = iArr10[iIndexOfMinValue$default3];
                    if (i51 == -1) {
                        i51 = i4;
                    }
                    int iFindPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i51, iIndexOfMinValue$default3);
                    if (iFindPreviousItemIndex2 < 0) {
                        iArr4 = iArr10;
                        if ((!z18 && !measure$lambda$0$misalignedStart(iArr4, lazyStaggeredGridMeasureContext2, iArr3, iIndexOfMinValue$default3)) || !z) {
                            break;
                        }
                        lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                        int length7 = iArr4.length;
                        int[] iArr13 = new int[length7];
                        for (int i52 = 0; i52 < length7; i52++) {
                            iArr13[i52] = -1;
                        }
                        int length8 = iArr3.length;
                        int[] iArr14 = new int[length8];
                        for (int i53 = 0; i53 < length8; i53++) {
                            iArr14[i53] = iArr3[iIndexOfMinValue$default3];
                        }
                        return measure(lazyStaggeredGridMeasureContext2, i35, iArr13, iArr14, false);
                    }
                    int i54 = i35;
                    int[] iArr15 = iArr10;
                    boolean z19 = z18;
                    int i55 = mainAxisAvailableSize;
                    long jM1474getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex2, iIndexOfMinValue$default3);
                    int i56 = i4;
                    int i57 = length5;
                    int i58 = (int) (jM1474getSpanRangelOCCd4c4 & 4294967295L);
                    int i59 = iCoerceAtLeast;
                    String str4 = str2;
                    int i60 = (int) (jM1474getSpanRangelOCCd4c4 >> c);
                    int i61 = i58 - i60;
                    lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iFindPreviousItemIndex2, i61 != 1 ? -2 : i60);
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iFindPreviousItemIndex2, jM1474getSpanRangelOCCd4c4);
                    int iM1479maxInRangejy6DScQ4 = m1479maxInRangejy6DScQ(iArr3, jM1474getSpanRangelOCCd4c4);
                    int[] gaps4 = i61 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex2) : null;
                    while (i60 < i58) {
                        if (iArr3[i60] != iM1479maxInRangejy6DScQ4) {
                            z19 = true;
                        }
                        arrayDequeArr4[i60].addFirst(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ4);
                        iArr15[i60] = iFindPreviousItemIndex2;
                        iArr3[i60] = iM1479maxInRangejy6DScQ4 + lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i60]);
                        i60++;
                    }
                    str2 = str4;
                    mainAxisAvailableSize = i55;
                    z18 = z19;
                    length5 = i57;
                    iCoerceAtLeast = i59;
                    i4 = i56;
                    iArr10 = iArr15;
                    i35 = i54;
                }
                i6 = length5;
                str = str2;
                if (z18 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i35, iArr4, iArr3, false);
                }
                i7 = i35 + mainAxisAvailableSize;
                int i62 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i62 >= 0) {
                    break;
                }
                i7 += i62;
                offsetBy(iArr7, i62);
                offsetBy(iArr3, -i62);
                break;
            }
        }
        float fScrollToBeConsumed$foundation = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation(lazyLayoutMeasureScope2.isLookingAhead());
        float f = (MathKt.getSign(Math.round(fScrollToBeConsumed$foundation)) != MathKt.getSign(i7) || Math.abs(Math.round(fScrollToBeConsumed$foundation)) < Math.abs(i7)) ? fScrollToBeConsumed$foundation : i7;
        float f2 = fScrollToBeConsumed$foundation - f;
        float f3 = 0.0f;
        if (lazyLayoutMeasureScope2.isLookingAhead() && i7 > i35 && f2 <= 0.0f) {
            f3 = (i7 - i35) + f2;
        }
        float f4 = f3;
        int[] iArrCopyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf4, str);
        int length9 = iArrCopyOf4.length;
        for (int i63 = 0; i63 < length9; i63++) {
            iArrCopyOf4[i63] = -iArrCopyOf4[i63];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i64 = 0; i64 < laneCount; i64++) {
                ArrayDeque arrayDeque2 = arrayDequeArr4[i64];
                int size2 = arrayDeque2.size();
                int i65 = 0;
                while (i65 < size2) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i65);
                    int[] gaps5 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps5 == null ? 0 : gaps5[i64]);
                    if (i65 == CollectionsKt.getLastIndex(arrayDeque2) || (i13 = iArr3[i64]) == 0 || i13 < mainAxisSizeWithSpacings2) {
                        break;
                    }
                    iArr3[i64] = i13 - mainAxisSizeWithSpacings2;
                    i65++;
                    iArr4[i64] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i65)).getIndex();
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            iM9657constrainWidthK40F9xA = Constraints.m9640getMaxWidthimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        } else {
            iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding);
        }
        int i66 = iM9657constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            iM9639getMaxHeightimpl = ConstraintsKt.m9656constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding);
        } else {
            iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        }
        int i67 = iM9639getMaxHeightimpl;
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.getIsVertical() ? i67 : i66, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i68 = iArrCopyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size3 = pinnedItems.size() - 1;
        if (size3 >= 0) {
            int i69 = size3;
            ArrayList arrayList3 = null;
            while (true) {
                int i70 = i69 - 1;
                int iIntValue = pinnedItems.get(i69).intValue();
                int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue);
                int i71 = i68;
                if (lane3 == -2 || lane3 == -1) {
                    int i72 = 0;
                    while (true) {
                        if (i72 < laneCount) {
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr4[i72].firstOrNull();
                            if ((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > iIntValue) {
                                i72++;
                            }
                        }
                    }
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr4[lane3].firstOrNull();
                    z12 = (lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) > iIntValue;
                }
                if (z12) {
                    long jM1474getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue, 0);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iIntValue, jM1474getSpanRangelOCCd4c5);
                    int mainAxisSizeWithSpacings3 = i71 - lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                    lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ5.position(mainAxisSizeWithSpacings3, 0, afterContentPadding);
                    arrayList3.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ5);
                    i68 = mainAxisSizeWithSpacings3;
                } else {
                    i68 = i71;
                }
                if (i70 < 0) {
                    break;
                }
                i69 = i70;
                iArrCopyOf4 = iArrCopyOf4;
            }
            listEmptyList = arrayList3;
        } else {
            iArrCopyOf4 = iArrCopyOf4;
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list4 = listEmptyList;
        int[] iArr16 = iArrCopyOf4;
        int i73 = iCoerceAtLeast;
        List<LazyStaggeredGridMeasuredItem> listCalculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr4, iArr16, afterContentPadding, i22, i73);
        int mainAxisSizeWithSpacings4 = iArr16[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull((List) listCalculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (!lazyLayoutMeasureScope2.isLookingAhead() || lazyStaggeredGridMeasureContext2.getApproachLayoutInfo() == null || lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            list = listCalculateVisibleItems;
            iArr4 = iArr4;
            f4 = f4;
            arrayList = null;
        } else {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
            int size4 = visibleItemsInfo2.size() - 1;
            while (true) {
                if (-1 >= size4) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                }
                if (visibleItemsInfo2.get(size4).getIndex() > index2 && (size4 == 0 || visibleItemsInfo2.get(size4 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = visibleItemsInfo2.get(size4);
                    break;
                }
                size4--;
            }
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo5 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo());
            if (lazyStaggeredGridItemInfo == null || (index = lazyStaggeredGridItemInfo.getIndex()) > (iMin = Math.min(lazyStaggeredGridItemInfo5.getIndex(), i4 - 1))) {
                list = listCalculateVisibleItems;
                iArr4 = iArr4;
                f4 = f4;
                arrayList = null;
            } else {
                int i74 = index;
                int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4;
                ArrayList arrayList4 = null;
                while (true) {
                    if (arrayList4 != null) {
                        int size5 = arrayList4.size();
                        list = listCalculateVisibleItems;
                        int i75 = 0;
                        while (true) {
                            if (i75 >= size5) {
                                z11 = false;
                                break;
                            }
                            int i76 = i75;
                            if (((LazyStaggeredGridMeasuredItem) arrayList4.get(i75)).getIndex() == i74) {
                                z11 = true;
                                break;
                            }
                            i75 = i76 + 1;
                        }
                        z9 = z11;
                        if (z9) {
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            visibleItemsInfo = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
                            size = visibleItemsInfo.size();
                            i11 = 0;
                            while (true) {
                                if (i11 < size) {
                                    lazyStaggeredGridItemInfo2 = null;
                                    break;
                                }
                                lazyStaggeredGridItemInfo4 = visibleItemsInfo.get(i11);
                                list3 = visibleItemsInfo;
                                if (lazyStaggeredGridItemInfo4.getIndex() == i74) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (z10) {
                                    lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo4;
                                    break;
                                }
                                i11++;
                                visibleItemsInfo = list3;
                            }
                            lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                            if (lazyStaggeredGridItemInfo3 != null) {
                                lane2 = lazyStaggeredGridItemInfo3.getLane();
                            } else {
                                lane2 = 0;
                            }
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(i74, lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i74, lane2));
                            arrayList4.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ6);
                            positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                            if (positions.length > lane2) {
                                i12 = positions[lane2];
                            } else {
                                i12 = 0;
                            }
                            lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ6.position(mainAxisSizeWithSpacings5, i12, afterContentPadding);
                            mainAxisSizeWithSpacings5 += lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ6.getMainAxisSizeWithSpacings();
                        }
                        if (i74 != iMin) {
                            break;
                        }
                        i74++;
                        listCalculateVisibleItems = list;
                        iArr4 = iArr4;
                        f4 = f4;
                    } else {
                        list = listCalculateVisibleItems;
                    }
                    if (z9) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        visibleItemsInfo = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
                        size = visibleItemsInfo.size();
                        i11 = 0;
                        while (true) {
                            if (i11 < size) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo4 = visibleItemsInfo.get(i11);
                            list3 = visibleItemsInfo;
                            if (lazyStaggeredGridItemInfo4.getIndex() == i74) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo4;
                                break;
                            }
                            i11++;
                            visibleItemsInfo = list3;
                        }
                        lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                        if (lazyStaggeredGridItemInfo3 != null) {
                            lane2 = lazyStaggeredGridItemInfo3.getLane();
                        } else {
                            lane2 = 0;
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ7 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(i74, lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i74, lane2));
                        arrayList4.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ7);
                        positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                        if (positions.length > lane2) {
                            i12 = positions[lane2];
                        } else {
                            i12 = 0;
                        }
                        lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ7.position(mainAxisSizeWithSpacings5, i12, afterContentPadding);
                        mainAxisSizeWithSpacings5 += lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ7.getMainAxisSizeWithSpacings();
                    }
                    if (i74 != iMin) {
                        break;
                        break;
                    }
                    i74++;
                    listCalculateVisibleItems = list;
                    iArr4 = iArr4;
                    f4 = f4;
                }
                arrayList = arrayList4;
                mainAxisSizeWithSpacings4 = mainAxisSizeWithSpacings5;
            }
        }
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size6 = pinnedItems2.size();
        int i77 = 0;
        ArrayList arrayListEmptyList = null;
        while (i77 < size6) {
            int iIntValue2 = pinnedItems2.get(i77).intValue();
            int i78 = i4;
            if (iIntValue2 >= i78) {
                arrayList2 = arrayList;
                list2 = pinnedItems2;
            } else {
                if (arrayList != null) {
                    int size7 = arrayList.size();
                    list2 = pinnedItems2;
                    int i79 = 0;
                    while (true) {
                        if (i79 >= size7) {
                            arrayList2 = arrayList;
                            z7 = false;
                            break;
                        }
                        arrayList2 = arrayList;
                        if (((LazyStaggeredGridMeasuredItem) arrayList.get(i79)).getIndex() == iIntValue2) {
                            z7 = true;
                            break;
                        }
                        i79++;
                        arrayList = arrayList2;
                    }
                    z5 = z7;
                    if (!z5) {
                        lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue2);
                        if (lane == -2 && lane != -1) {
                            z8 = iArrCopyOf3[lane] < iIntValue2;
                        } else {
                            length = iArrCopyOf3.length;
                            i10 = 0;
                            while (true) {
                                if (i10 < length) {
                                    if (iArrCopyOf3[i10] < iIntValue2) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (!z6) {
                                        i10++;
                                    }
                                }
                            }
                        }
                    }
                    if (z8) {
                        long jM1474getSpanRangelOCCd4c6 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = new ArrayList();
                        }
                        List list5 = arrayListEmptyList;
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ8 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iIntValue2, jM1474getSpanRangelOCCd4c6);
                        lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ8.position(mainAxisSizeWithSpacings4, 0, afterContentPadding);
                        mainAxisSizeWithSpacings4 += lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ8.getMainAxisSizeWithSpacings();
                        list5.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ8);
                        arrayListEmptyList = list5;
                    }
                    i77++;
                    pinnedItems2 = list2;
                    size6 = size6;
                    arrayList = arrayList2;
                    i4 = i78;
                } else {
                    arrayList2 = arrayList;
                    list2 = pinnedItems2;
                }
                if (!z5) {
                    lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue2);
                    if (lane == -2) {
                    }
                    length = iArrCopyOf3.length;
                    i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            if (iArrCopyOf3[i10] < iIntValue2) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (!z6) {
                                i10++;
                            }
                        }
                    }
                }
                if (z8) {
                    long jM1474getSpanRangelOCCd4c7 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = new ArrayList();
                    }
                    List list6 = arrayListEmptyList;
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ9 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iIntValue2, jM1474getSpanRangelOCCd4c7);
                    lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ9.position(mainAxisSizeWithSpacings4, 0, afterContentPadding);
                    mainAxisSizeWithSpacings4 += lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ9.getMainAxisSizeWithSpacings();
                    list6.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ9);
                    arrayListEmptyList = list6;
                }
                i77++;
                pinnedItems2 = list2;
                size6 = size6;
                arrayList = arrayList2;
                i4 = i78;
            }
            if (z8) {
                long jM1474getSpanRangelOCCd4c8 = lazyStaggeredGridMeasureContext2.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = new ArrayList();
                }
                List list7 = arrayListEmptyList;
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ10 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iIntValue2, jM1474getSpanRangelOCCd4c8);
                lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ10.position(mainAxisSizeWithSpacings4, 0, afterContentPadding);
                mainAxisSizeWithSpacings4 += lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ10.getMainAxisSizeWithSpacings();
                list7.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ10);
                arrayListEmptyList = list7;
            }
            i77++;
            pinnedItems2 = list2;
            size6 = size6;
            arrayList = arrayList2;
            i4 = i78;
        }
        int i80 = i4;
        ArrayList arrayList5 = arrayList;
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        final ArrayList arrayList6 = new ArrayList();
        arrayList6.addAll(list4);
        arrayList6.addAll(list);
        if (arrayList5 != null) {
            arrayList6.addAll(arrayList5);
        }
        arrayList6.addAll(arrayListEmptyList);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f, i66, i67, arrayList6, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.getIsVertical(), lazyLayoutMeasureScope2.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.getIsInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        if (lazyLayoutMeasureScope2.isLookingAhead()) {
            i8 = i66;
            i9 = i67;
        } else {
            long jM1413getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().m1413getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m9856equalsimpl0(jM1413getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m9863getZeroYbymL2g())) {
                i8 = i66;
                i9 = i67;
            } else {
                int i81 = lazyStaggeredGridMeasureContext2.getIsVertical() ? i67 : i66;
                int iM9657constrainWidthK40F9xA2 = ConstraintsKt.m9657constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(i66, (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(i67, (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i82 = lazyStaggeredGridMeasureContext2.getIsVertical() ? iM9656constrainHeightK40F9xA : iM9657constrainWidthK40F9xA2;
                if (i82 != i81) {
                    int size8 = arrayList6.size();
                    for (int i83 = 0; i83 < size8; i83++) {
                        ((LazyStaggeredGridMeasuredItem) arrayList6.get(i83)).updateMainAxisLayoutSize(i82);
                    }
                }
                i8 = iM9657constrainWidthK40F9xA2;
                i9 = iM9656constrainHeightK40F9xA;
            }
        }
        int i84 = i6;
        int i85 = 0;
        while (true) {
            if (i85 >= i84) {
                z2 = false;
                break;
            }
            if (iArr7[i85] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                z2 = true;
                break;
            }
            i85++;
        }
        if (z2) {
            z3 = true;
        } else {
            int length10 = iArrCopyOf3.length;
            int i86 = 0;
            while (true) {
                if (i86 >= length10) {
                    z4 = true;
                    break;
                }
                if (!(iArrCopyOf3[i86] < i80 + (-1))) {
                    z4 = false;
                    break;
                }
                i86++;
            }
            if (z4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        final LazyLayoutMeasureScope lazyLayoutMeasureScope4 = lazyLayoutMeasureScope2;
        return new LazyStaggeredGridMeasureResult(iArr4, iArr3, f, MeasureScope.layout$default(lazyLayoutMeasureScope2, i8, i9, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext2, arrayList6, lazyLayoutMeasureScope4, (Placeable.PlacementScope) obj);
            }
        }, 4, null), f4, z3, lazyStaggeredGridMeasureContext2.getIsVertical(), z16, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4, i80, list, IntSize.m9853constructorimpl((((long) i9) & 4294967295L) | (((long) i8) << c)), i22, i73, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37(final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m1436attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m1487getPlacementScopeInvalidatorzYiylxw$foundation());
        return Unit.INSTANCE;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int size = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length; i6++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemFirstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItemFirstOrNull != null ? lazyStaggeredGridMeasuredItemFirstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemRemoveFirst = arrayDequeArr[i4].removeFirst();
                    if (lazyStaggeredGridMeasuredItemRemoveFirst.getLane() == i4) {
                        long jM1489constructorimpl = SpanRange.m1489constructorimpl(lazyStaggeredGridMeasuredItemRemoveFirst.getLane(), lazyStaggeredGridMeasuredItemRemoveFirst.getSpan());
                        int iM1479maxInRangejy6DScQ = m1479maxInRangejy6DScQ(iArr, jM1489constructorimpl);
                        int i7 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4];
                        if (lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSize() + iM1479maxInRangejy6DScQ >= i2 && iM1479maxInRangejy6DScQ <= i3) {
                            lazyStaggeredGridMeasuredItemRemoveFirst.position(iM1479maxInRangejy6DScQ, i7, i);
                            arrayList.add(lazyStaggeredGridMeasuredItemRemoveFirst);
                        }
                        int i8 = (int) (jM1489constructorimpl & 4294967295L);
                        for (int i9 = (int) (jM1489constructorimpl >> 32); i9 < i8; i9++) {
                            iArr[i9] = lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSizeWithSpacings() + iM1479maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b8 A[LOOP:3: B:35:0x00a8->B:39:0x00b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc A[EDGE_INSN: B:62:0x00bc->B:41:0x00bc BREAK  A[LOOP:3: B:35:0x00a8->B:39:0x00b8], SYNTHETIC] */
    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        List<LazyStaggeredGridItemInfo> visibleItemsInfo;
        int size;
        int i3;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3;
        int lane;
        if (z && lazyStaggeredGridMeasureContext.getApproachLayoutInfo() != null && !lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
            int size2 = visibleItemsInfo2.size();
            while (true) {
                size2--;
                if (-1 >= size2) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                }
                if (visibleItemsInfo2.get(size2).getIndex() > i && (size2 == 0 || visibleItemsInfo2.get(size2 - 1).getIndex() <= i)) {
                    lazyStaggeredGridItemInfo = visibleItemsInfo2.get(size2);
                    break;
                }
            }
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo4.getIndex(), i2 - 1))) {
                ArrayList arrayList = null;
                while (true) {
                    if (arrayList == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        visibleItemsInfo = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                        size = visibleItemsInfo.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo2 = visibleItemsInfo.get(i3);
                            if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                break;
                                break;
                            }
                            i3++;
                        }
                        lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                        if (lazyStaggeredGridItemInfo3 != null) {
                            lane = lazyStaggeredGridItemInfo3.getLane();
                        } else {
                            lane = 0;
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ);
                        int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
                    } else {
                        int size3 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (arrayList.get(i4).getIndex() != index) {
                                    i4++;
                                }
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                visibleItemsInfo = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                                size = visibleItemsInfo.size();
                                i3 = 0;
                                while (true) {
                                    if (i3 < size) {
                                        lazyStaggeredGridItemInfo2 = null;
                                        break;
                                    }
                                    lazyStaggeredGridItemInfo2 = visibleItemsInfo.get(i3);
                                    if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                        break;
                                    }
                                    i3++;
                                }
                                lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                                if (lazyStaggeredGridItemInfo3 != null) {
                                    lane = lazyStaggeredGridItemInfo3.getLane();
                                } else {
                                    lane = 0;
                                }
                                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                                arrayList.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2);
                                int[] positions2 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                                function2.invoke(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2, Integer.valueOf(positions2.length > lane ? positions2[lane] : 0));
                            }
                        }
                    }
                    if (index == iMin) {
                        return arrayList;
                    }
                    index++;
                }
            }
        }
        return null;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function2, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (function2.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                        long jM1474getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iIntValue, jM1474getSpanRangelOCCd4c);
                        function1.invoke(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iIntValue2 = pinnedItems.get(i2).intValue();
                if (function2.invoke(Integer.valueOf(iIntValue2)).booleanValue()) {
                    long jM1474getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1474getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1483getAndMeasurejy6DScQ(iIntValue2, jM1474getSpanRangelOCCd4c2);
                    function1.invoke(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM1483getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m1478forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m1479maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int iIntValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > iIntValue) {
                i = i3;
                i2 = iIntValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            int i3 = iArr[length];
            if (i3 >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), i3)) {
                if (lazyStaggeredGridMeasureContext.getLaneInfo().getLane(i3) == -2) {
                    int length2 = iArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i4 = -1;
                            break;
                        } else if (iArr[i4] == i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int i5 = i4 + 1;
                    if (i5 <= length) {
                        while (true) {
                            if (iArr[i5] == i3) {
                                iArr[i5] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i3, i5);
                            }
                            if (i5 == length) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    length = i4;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i3, length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37$0(List list, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).place(placementScope, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
