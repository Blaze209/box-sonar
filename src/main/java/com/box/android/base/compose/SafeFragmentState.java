package com.box.android.base.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeAndroidFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/base/compose/SafeFragmentState;", "", "state", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "<init>", "(Landroidx/compose/runtime/MutableState;)V", "getState", "()Landroidx/compose/runtime/MutableState;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SafeFragmentState {
    public static final int $stable = 0;
    private final MutableState<Fragment.SavedState> state;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFragmentState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SafeFragmentState(MutableState<Fragment.SavedState> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    public /* synthetic */ SafeFragmentState(MutableState mutableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState);
    }

    public final MutableState<Fragment.SavedState> getState() {
        return this.state;
    }
}
