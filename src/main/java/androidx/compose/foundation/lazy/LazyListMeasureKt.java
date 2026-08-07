package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\u001a\u0092\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000¢\u0006\u0004\b0\u00101\u001aB\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b042\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a4\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a\u008c\u0001\u00107\u001a\b\u0012\u0004\u0012\u00020\u001b042\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006@"}, d2 = {"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-_s_dbAc", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", AlertFragment.ARG_ITEMS, "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Code duplicated, block: B:147:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:164:0x0422  */
    /* JADX INFO: renamed from: measureLazyList-_s_dbAc, reason: not valid java name */
    public static final LazyListMeasureResult m1339measureLazyList_s_dbAc(int i, final LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, final boolean z4, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        int i12;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int i13;
        int iMax;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Integer numValueOf;
        int i21 = i3;
        if (!(i21 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
        }
        if (i <= 0) {
            int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
            int iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, iM9642getMinWidthimpl, iM9641getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long jM1413getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m1413getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m9856equalsimpl0(jM1413getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m9863getZeroYbymL2g())) {
                    iM9642getMinWidthimpl = ConstraintsKt.m9657constrainWidthK40F9xA(j, (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM9641getMinHeightimpl = ConstraintsKt.m9656constrainHeightK40F9xA(j, (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iM9642getMinWidthimpl), Integer.valueOf(iM9641getMinHeightimpl), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$2((Placeable.PlacementScope) obj);
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), CollectionsKt.emptyList(), -i21, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
        }
        int i22 = i6;
        if (i22 >= i) {
            i22 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int iRound = Math.round(f);
        int i23 = i9 - iRound;
        if (i22 == 0 && i23 < 0) {
            iRound += i23;
            i23 = 0;
        }
        int i24 = iRound;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i25 = -i21;
        int i26 = (i5 < 0 ? i5 : 0) + i25;
        int mainAxisSizeWithSpacings = i23 + i26;
        int iMax2 = 0;
        while (mainAxisSizeWithSpacings < 0 && i22 > 0) {
            int i27 = i22 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            LazyListMeasuredItem lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i27, 0L, 2, null);
            arrayDeque2.add(0, lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default);
            iMax2 = Math.max(iMax2, lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default.getCrossAxisSize());
            mainAxisSizeWithSpacings = lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings;
            i22 = i27;
            arrayDeque = arrayDeque2;
            i26 = i26;
            i25 = i25;
        }
        int i28 = mainAxisSizeWithSpacings;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i29 = i25;
        int i30 = i26;
        int i31 = iMax2;
        if (i28 < i30) {
            i24 -= i30 - i28;
            i10 = i30;
        } else {
            i10 = i28;
        }
        int i32 = i24;
        int i33 = i10 - i30;
        int i34 = i2 + i4;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i34, 0);
        int mainAxisSizeWithSpacings2 = -i33;
        int i35 = i22;
        int i36 = 0;
        boolean z5 = false;
        while (i36 < arrayDeque3.size()) {
            if (mainAxisSizeWithSpacings2 >= iCoerceAtLeast) {
                arrayDeque3.remove(i36);
                Unit unit = Unit.INSTANCE;
                z5 = true;
            } else {
                i35++;
                mainAxisSizeWithSpacings2 += ((LazyListMeasuredItem) arrayDeque3.get(i36)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i36);
                i36++;
            }
        }
        int mainAxisSizeWithSpacings3 = mainAxisSizeWithSpacings2;
        int i37 = i31;
        boolean z6 = z5;
        int i38 = i22;
        int i39 = i34;
        int i40 = i35;
        int mainAxisSizeWithSpacings4 = i33;
        while (i40 < i && (mainAxisSizeWithSpacings3 < iCoerceAtLeast || mainAxisSizeWithSpacings3 <= 0 || arrayDeque3.isEmpty())) {
            int i41 = i37;
            int i42 = iCoerceAtLeast;
            int i43 = i39;
            int i44 = i38;
            LazyListMeasuredItem lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i40, 0L, 2, null);
            int i45 = i40;
            mainAxisSizeWithSpacings3 += lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings3 <= i30 && i45 != i - 1) {
                mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                Unit unit2 = Unit.INSTANCE;
                i37 = i41;
                z6 = true;
                i38 = i45 + 1;
            } else {
                int iMax3 = Math.max(i41, lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default2.getCrossAxisSize());
                Boolean.valueOf(arrayDeque3.add(lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default2));
                i38 = i44;
                i37 = iMax3;
            }
            i40 = i45 + 1;
            iCoerceAtLeast = i42;
            i39 = i43;
        }
        int i46 = i39;
        int i47 = i40;
        int i48 = i38;
        int iMax4 = i37;
        if (mainAxisSizeWithSpacings3 < i2) {
            int i49 = i2 - mainAxisSizeWithSpacings3;
            int i50 = mainAxisSizeWithSpacings3 + i49;
            int i51 = i48;
            int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i49;
            while (mainAxisSizeWithSpacings5 < i21 && i51 > 0) {
                i51--;
                int i52 = mainAxisSizeWithSpacings5;
                LazyListMeasuredItem lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i51, 0L, 2, null);
                arrayDeque3.add(0, lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default3);
                iMax4 = Math.max(iMax4, lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                mainAxisSizeWithSpacings5 = i52 + lazyListMeasuredItemM1345getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings();
                i47 = i47;
                i21 = i3;
            }
            i11 = i47;
            int i53 = mainAxisSizeWithSpacings5;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i49 + i32;
            if (i53 < 0) {
                i13 += i53;
                iMax = iMax4;
                i14 = i50 + i53;
                i16 = i51;
                i15 = 0;
            } else {
                iMax = iMax4;
                i14 = i50;
                i16 = i51;
                i15 = i53;
            }
        } else {
            i11 = i47;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i32;
            iMax = iMax4;
            i14 = mainAxisSizeWithSpacings3;
            i15 = mainAxisSizeWithSpacings4;
            i16 = i48;
        }
        float f2 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i13) || Math.abs(Math.round(f)) < Math.abs(i13)) ? f : i13;
        float f3 = f - f2;
        float f4 = 0.0f;
        if (z4 && i13 > i32 && f3 <= 0.0f) {
            f4 = (i13 - i32) + f3;
        }
        float f5 = f4;
        if ((i15 >= 0 ? 1 : i12) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i54 = -i15;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque3.size();
            while (true) {
                if (i12 >= size) {
                    i17 = i15;
                    i18 = i54;
                    break;
                }
                i18 = i54;
                int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque3.get(i12)).getMainAxisSizeWithSpacings();
                if (i15 == 0 || mainAxisSizeWithSpacings6 > i15) {
                    i17 = i15;
                    break;
                }
                i17 = i15;
                if (i12 == CollectionsKt.getLastIndex(arrayDeque3)) {
                    break;
                }
                i15 = i17 - mainAxisSizeWithSpacings6;
                i12++;
                lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.get(i12);
                i54 = i18;
            }
            i19 = i17;
        } else {
            i19 = i15;
            i18 = i54;
        }
        LazyListMeasuredItem lazyListMeasuredItem2 = lazyListMeasuredItem;
        List<LazyListMeasuredItem> listCreateItemsBeforeList = createItemsBeforeList(i16, lazyListMeasuredItemProvider2, i8, list);
        int size2 = listCreateItemsBeforeList.size();
        for (int i55 = 0; i55 < size2; i55++) {
            iMax = Math.max(iMax, listCreateItemsBeforeList.get(i55).getCrossAxisSize());
        }
        ArrayDeque arrayDeque4 = arrayDeque3;
        List<LazyListMeasuredItem> listCreateItemsAfterList = createItemsAfterList(arrayDeque4, lazyListMeasuredItemProvider2, i, i8, list);
        int size3 = listCreateItemsAfterList.size();
        for (int i56 = 0; i56 < size3; i56++) {
            iMax = Math.max(iMax, listCreateItemsAfterList.get(i56).getCrossAxisSize());
        }
        boolean z7 = Intrinsics.areEqual(lazyListMeasuredItem2, arrayDeque3.first()) && listCreateItemsBeforeList.isEmpty() && listCreateItemsAfterList.isEmpty();
        int iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(j, z ? iMax : i14);
        if (z) {
            iMax = i14;
        }
        int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(j, iMax);
        float f6 = f2;
        int iM9657constrainWidthK40F9xA2 = iM9657constrainWidthK40F9xA;
        int i57 = i11;
        final List<LazyListMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayDeque4, listCreateItemsBeforeList, listCreateItemsAfterList, iM9657constrainWidthK40F9xA2, iM9656constrainHeightK40F9xA, i14, i2, i18, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f6, iM9657constrainWidthK40F9xA2, iM9656constrainHeightK40F9xA, listCalculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, i19, i14, coroutineScope, graphicsContext);
        int i58 = i14;
        if (z4) {
            i20 = iM9656constrainHeightK40F9xA;
        } else {
            long jM1413getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m1413getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m9856equalsimpl0(jM1413getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m9863getZeroYbymL2g())) {
                i20 = iM9656constrainHeightK40F9xA;
            } else {
                int i59 = z ? iM9656constrainHeightK40F9xA : iM9657constrainWidthK40F9xA2;
                iM9657constrainWidthK40F9xA2 = ConstraintsKt.m9657constrainWidthK40F9xA(j, Math.max(iM9657constrainWidthK40F9xA2, (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                int iM9656constrainHeightK40F9xA2 = ConstraintsKt.m9656constrainHeightK40F9xA(j, Math.max(iM9656constrainHeightK40F9xA, (int) (jM1413getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i60 = z ? iM9656constrainHeightK40F9xA2 : iM9657constrainWidthK40F9xA2;
                if (i60 != i59) {
                    int size4 = listCalculateItemsOffsets.size();
                    for (int i61 = 0; i61 < size4; i61++) {
                        listCalculateItemsOffsets.get(i61).updateMainAxisLayoutSize(i60);
                    }
                }
                i20 = iM9656constrainHeightK40F9xA2;
            }
        }
        int i62 = iM9657constrainWidthK40F9xA2;
        LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
        int index = lazyListMeasuredItem3 != null ? lazyListMeasuredItem3.getIndex() : 0;
        LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
        final List listApplyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem4 != null ? lazyListMeasuredItem4.getIndex() : 0, listCalculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i62, i20, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$7(lazyListMeasuredItemProvider, ((Integer) obj).intValue());
            }
        });
        Integer numValueOf2 = null;
        if (z7) {
            LazyListMeasuredItem lazyListMeasuredItem5 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) listCalculateItemsOffsets);
            if (lazyListMeasuredItem5 != null) {
                numValueOf = Integer.valueOf(lazyListMeasuredItem5.getIndex());
            } else {
                numValueOf = null;
            }
        } else {
            LazyListMeasuredItem lazyListMeasuredItem6 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
            if (lazyListMeasuredItem6 != null) {
                numValueOf = Integer.valueOf(lazyListMeasuredItem6.getIndex());
            } else {
                numValueOf = null;
            }
        }
        if (z7) {
            LazyListMeasuredItem lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.lastOrNull((List) listCalculateItemsOffsets);
            if (lazyListMeasuredItem7 != null) {
                numValueOf2 = Integer.valueOf(lazyListMeasuredItem7.getIndex());
            }
        } else {
            LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
            if (lazyListMeasuredItem8 != null) {
                numValueOf2 = Integer.valueOf(lazyListMeasuredItem8.getIndex());
            }
        }
        return new LazyListMeasureResult(lazyListMeasuredItem2, i19, i57 < i || i58 > i2, f6, function3.invoke(Integer.valueOf(i62), Integer.valueOf(i20), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8(mutableState, listCalculateItemsOffsets, listApplyStickyItems, z4, (Placeable.PlacementScope) obj);
            }
        }), f5, z6, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), LazyLayoutMeasuredItemKt.updatedVisibleItems(numValueOf != null ? numValueOf.intValue() : 0, numValueOf2 != null ? numValueOf2.intValue() : 0, listCalculateItemsOffsets, listApplyStickyItems), i29, i46, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList__s_dbAc$lambda$2(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyListMeasuredItem measureLazyList__s_dbAc$lambda$7(LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i) {
        return LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList__s_dbAc$lambda$8(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8$0(list, list2, z, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m1436attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider3;
        int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + i2, i - 1);
        int index = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        ArrayList arrayList = null;
        if (index <= iMin) {
            int i3 = index;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i3, 0L, 2, null));
                if (i3 == iMin) {
                    break;
                }
                i3++;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() > iMin) {
            iMin = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
        }
        int size = list2.size();
        int i4 = 0;
        while (i4 < size) {
            int iIntValue = list2.get(i4).intValue();
            if (iIntValue > iMin) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider3 = lazyListMeasuredItemProvider2;
                arrayList.add(LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider3, iIntValue, 0L, 2, null));
            } else {
                lazyListMeasuredItemProvider3 = lazyListMeasuredItemProvider2;
            }
            i4++;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider3;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            int i4 = i3;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i4, 0L, 2, null));
                if (i4 == iMax) {
                    break;
                }
                i4--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i5 = size - 1;
                int iIntValue = list.get(size).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m1345getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, iIntValue, 0L, 2, null));
                }
                if (i5 < 0) {
                    break;
                }
                size = i5;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                throw new KotlinNothingValueException();
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size2 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        size2 = (i6 - size2) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.position(size2, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size();
            int mainAxisSizeWithSpacings = i5;
            for (int i8 = 0; i8 < size3; i8++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i8);
                mainAxisSizeWithSpacings -= lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem2.position(mainAxisSizeWithSpacings, i, i2);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size4 = list.size();
            int mainAxisSizeWithSpacings2 = i5;
            for (int i9 = 0; i9 < size4; i9++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list.get(i9);
                lazyListMeasuredItem3.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i10 = 0; i10 < size5; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem4 = list3.get(i10);
                lazyListMeasuredItem4.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem4);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem4.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList__s_dbAc$lambda$8$0(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyListMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyListMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
