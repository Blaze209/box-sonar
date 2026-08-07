package androidx.fragment.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FragmentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005R\"\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Landroidx/fragment/compose/FragmentState;", "", "state", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "(Landroidx/compose/runtime/MutableState;)V", "getState$fragment_compose_release", "()Landroidx/compose/runtime/MutableState;", "setState$fragment_compose_release", "fragment-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FragmentState {
    public static final int $stable = 0;
    private MutableState<Fragment.SavedState> state;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public FragmentState(MutableState<Fragment.SavedState> mutableState) {
        this.state = mutableState;
    }

    public /* synthetic */ FragmentState(MutableState mutableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState);
    }

    public final MutableState<Fragment.SavedState> getState$fragment_compose_release() {
        return this.state;
    }

    public final void setState$fragment_compose_release(MutableState<Fragment.SavedState> mutableState) {
        this.state = mutableState;
    }
}
