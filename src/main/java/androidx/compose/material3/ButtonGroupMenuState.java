package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0007\u0010\nR+\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u0005¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/ButtonGroupMenuState;", "", "initialIsShowing", "", "<init>", "(Z)V", "value", "isExpanded", "isExpanded$annotations", "()V", "()Z", "<set-?>", "isShowing", "setShowing", "isShowing$delegate", "Landroidx/compose/runtime/MutableState;", BoxAnalyticsParams.ACTION_DISMISS, "", "show", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonGroupMenuState {
    public static final int $stable = 8;
    private boolean isExpanded;

    /* JADX INFO: renamed from: isShowing$delegate, reason: from kotlin metadata */
    private final MutableState isShowing;

    public ButtonGroupMenuState() {
        this(false, 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Keeping for binary compatibility")
    public static /* synthetic */ void isExpanded$annotations() {
    }

    public ButtonGroupMenuState(boolean z) {
        this.isExpanded = z;
        this.isShowing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
    }

    public /* synthetic */ ButtonGroupMenuState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    private final void setShowing(boolean z) {
        this.isShowing.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: isShowing, reason: merged with bridge method [inline-methods] */
    public final boolean isExpanded() {
        return ((Boolean) this.isShowing.getValue()).booleanValue();
    }

    public final void dismiss() {
        setShowing(false);
    }

    public final void show() {
        setShowing(true);
    }
}
