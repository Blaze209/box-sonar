package com.box.android.base.compose;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: ViewInteropNestedScrollConnection.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001dH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/box/android/base/compose/ViewInteropNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tmpArray", "", "getTmpArray", "()[I", "tmpArray$delegate", "Lkotlin/Lazy;", "viewHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "getViewHelper", "()Landroidx/core/view/NestedScrollingChildHelper;", "viewHelper$delegate", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", GuideCapping.INSERT_CAPPING_CONSUMED, "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ViewInteropNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: tmpArray$delegate, reason: from kotlin metadata */
    private final Lazy tmpArray;
    private final View view;

    /* JADX INFO: renamed from: viewHelper$delegate, reason: from kotlin metadata */
    private final Lazy viewHelper;

    public ViewInteropNestedScrollConnection(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.tmpArray = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.box.android.base.compose.ViewInteropNestedScrollConnection$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ViewInteropNestedScrollConnection.tmpArray_delegate$lambda$0();
            }
        });
        this.viewHelper = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.box.android.base.compose.ViewInteropNestedScrollConnection$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ViewInteropNestedScrollConnection.viewHelper_delegate$lambda$0(this.f$0);
            }
        });
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public /* bridge */ Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return super.mo945onPostFlingRZ2iAVY(j, j2, continuation);
    }

    private final int[] getTmpArray() {
        return (int[]) this.tmpArray.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] tmpArray_delegate$lambda$0() {
        return new int[2];
    }

    private final NestedScrollingChildHelper getViewHelper() {
        return (NestedScrollingChildHelper) this.viewHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollingChildHelper viewHelper_delegate$lambda$0(ViewInteropNestedScrollConnection viewInteropNestedScrollConnection) {
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(viewInteropNestedScrollConnection.view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        return nestedScrollingChildHelper;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo1299onPreScrollOzD1aCk(long available, int source) {
        if (getViewHelper().startNestedScroll(ViewInteropNestedScrollConnectionKt.m11673guessScrollAxisk4lQ0M(available), ViewInteropNestedScrollConnectionKt.m11675toViewTypeGyEprt8(source))) {
            int[] tmpArray = getTmpArray();
            ArraysKt.fill$default(tmpArray, 0, 0, 0, 6, (Object) null);
            NestedScrollingChildHelper viewHelper = getViewHelper();
            float fIntBitsToFloat = Float.intBitsToFloat((int) (available >> 32));
            int iCeil = ((int) (fIntBitsToFloat >= 0.0f ? Math.ceil(fIntBitsToFloat) : Math.floor(fIntBitsToFloat))) * (-1);
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & available));
            viewHelper.dispatchNestedPreScroll(iCeil, ((int) (fIntBitsToFloat2 >= 0.0f ? Math.ceil(fIntBitsToFloat2) : Math.floor(fIntBitsToFloat2))) * (-1), tmpArray, null, ViewInteropNestedScrollConnectionKt.m11675toViewTypeGyEprt8(source));
            return ViewInteropNestedScrollConnectionKt.m11674toOffsetUv8p0NA(tmpArray, available);
        }
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (getViewHelper().startNestedScroll(ViewInteropNestedScrollConnectionKt.m11673guessScrollAxisk4lQ0M(available), ViewInteropNestedScrollConnectionKt.m11675toViewTypeGyEprt8(source))) {
            int[] tmpArray = getTmpArray();
            ArraysKt.fill$default(tmpArray, 0, 0, 0, 6, (Object) null);
            NestedScrollingChildHelper viewHelper = getViewHelper();
            float fIntBitsToFloat = Float.intBitsToFloat((int) (consumed >> 32));
            int iCeil = ((int) (fIntBitsToFloat >= 0.0f ? Math.ceil(fIntBitsToFloat) : Math.floor(fIntBitsToFloat))) * (-1);
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (consumed & 4294967295L));
            int iCeil2 = ((int) (fIntBitsToFloat2 >= 0.0f ? Math.ceil(fIntBitsToFloat2) : Math.floor(fIntBitsToFloat2))) * (-1);
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (available >> 32));
            double d = fIntBitsToFloat3;
            int iCeil3 = ((int) (fIntBitsToFloat3 >= 0.0f ? Math.ceil(d) : Math.floor(d))) * (-1);
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (4294967295L & available));
            viewHelper.dispatchNestedScroll(iCeil, iCeil2, iCeil3, ((int) (fIntBitsToFloat4 >= 0.0f ? Math.ceil(fIntBitsToFloat4) : Math.floor(fIntBitsToFloat4))) * (-1), null, ViewInteropNestedScrollConnectionKt.m11675toViewTypeGyEprt8(source), tmpArray);
            return ViewInteropNestedScrollConnectionKt.m11674toOffsetUv8p0NA(tmpArray, available);
        }
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo1298onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        boolean z = getViewHelper().dispatchNestedPreFling(Velocity.m9925getXimpl(j) * (-1.0f), Velocity.m9926getYimpl(j) * (-1.0f)) || getViewHelper().dispatchNestedFling(Velocity.m9925getXimpl(j) * (-1.0f), Velocity.m9926getYimpl(j) * (-1.0f), true);
        if (getViewHelper().hasNestedScrollingParent(0)) {
            getViewHelper().stopNestedScroll(0);
        } else if (getViewHelper().hasNestedScrollingParent(1)) {
            getViewHelper().stopNestedScroll(1);
        }
        if (!z) {
            j = Velocity.INSTANCE.m9936getZero9UxMQ8M();
        }
        return Velocity.m9916boximpl(j);
    }
}
