package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: PrecisionPointer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"shouldUsePrecisionPointerComponentSizing", "Landroidx/compose/runtime/MutableState;", "", "getShouldUsePrecisionPointerComponentSizing", "()Landroidx/compose/runtime/MutableState;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PrecisionPointerKt {
    private static final MutableState<Boolean> shouldUsePrecisionPointerComponentSizing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    public static final MutableState<Boolean> getShouldUsePrecisionPointerComponentSizing() {
        return shouldUsePrecisionPointerComponentSizing;
    }
}
