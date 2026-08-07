package com.box.android.updates.force;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: ForceUpdateDialogConfigProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/box/android/updates/force/ForceUpdateDialogConfig;", "", "isEmmDialog", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ForceUpdateDialogConfig {
    public static final int $stable = 0;
    private final boolean isEmmDialog;

    public static /* synthetic */ ForceUpdateDialogConfig copy$default(ForceUpdateDialogConfig forceUpdateDialogConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = forceUpdateDialogConfig.isEmmDialog;
        }
        return forceUpdateDialogConfig.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEmmDialog() {
        return this.isEmmDialog;
    }

    public final ForceUpdateDialogConfig copy(boolean isEmmDialog) {
        return new ForceUpdateDialogConfig(isEmmDialog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ForceUpdateDialogConfig) && this.isEmmDialog == ((ForceUpdateDialogConfig) other).isEmmDialog;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isEmmDialog);
    }

    public String toString() {
        return "ForceUpdateDialogConfig(isEmmDialog=" + this.isEmmDialog + ")";
    }

    public ForceUpdateDialogConfig(boolean z) {
        this.isEmmDialog = z;
    }

    public final boolean isEmmDialog() {
        return this.isEmmDialog;
    }
}
