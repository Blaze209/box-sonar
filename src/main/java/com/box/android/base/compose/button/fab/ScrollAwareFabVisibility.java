package com.box.android.base.compose.button.fab;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ScrollAwareFabVisibility.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/compose/button/fab/ScrollAwareFabVisibility;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "<init>", "()V", "<set-?>", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "show", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScrollAwareFabVisibility implements NestedScrollConnection {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: isVisible$delegate, reason: from kotlin metadata */
    private final MutableState isVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public /* bridge */ Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return super.mo945onPostFlingRZ2iAVY(j, j2, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public /* bridge */ long mo946onPostScrollDzOQY0M(long j, long j2, int i) {
        return super.mo946onPostScrollDzOQY0M(j, j2, i);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public /* bridge */ Object mo1298onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return super.mo1298onPreFlingQWom1Mo(j, continuation);
    }

    private final void setVisible(boolean z) {
        this.isVisible.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isVisible() {
        return ((Boolean) this.isVisible.getValue()).booleanValue();
    }

    public final void show() {
        setVisible(true);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo1299onPreScrollOzD1aCk(long available, int source) {
        int i = (int) (available & 4294967295L);
        if (Float.intBitsToFloat(i) < -1.0f) {
            setVisible(false);
        } else if (Float.intBitsToFloat(i) > 1.0f) {
            setVisible(true);
        }
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }
}
