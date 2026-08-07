package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppBarDsl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\u0006\u0010\bR+\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/AppBarMenuState;", "", "<init>", "()V", "value", "", "isExpanded", "isExpanded$annotations", "()Z", "<set-?>", "isShowing", "setShowing", "(Z)V", "isShowing$delegate", "Landroidx/compose/runtime/MutableState;", BoxAnalyticsParams.ACTION_DISMISS, "", "show", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppBarMenuState {
    public static final int $stable = 8;
    private boolean isExpanded;

    /* JADX INFO: renamed from: isShowing$delegate, reason: from kotlin metadata */
    private final MutableState isShowing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Keeping for binary compatibility")
    public static /* synthetic */ void isExpanded$annotations() {
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
