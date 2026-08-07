package com.box.android.utilities.inbox;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InboxNotificationTypeIcons.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/utilities/inbox/NotificationTypeIcons;", "", "outlineIcon", "", "fillIcon", "isVisible", "", "<init>", "(IIZ)V", "getOutlineIcon", "()I", "getFillIcon", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationTypeIcons {
    public static final int $stable = 0;
    private final int fillIcon;
    private final boolean isVisible;
    private final int outlineIcon;

    public static /* synthetic */ NotificationTypeIcons copy$default(NotificationTypeIcons notificationTypeIcons, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = notificationTypeIcons.outlineIcon;
        }
        if ((i3 & 2) != 0) {
            i2 = notificationTypeIcons.fillIcon;
        }
        if ((i3 & 4) != 0) {
            z = notificationTypeIcons.isVisible;
        }
        return notificationTypeIcons.copy(i, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOutlineIcon() {
        return this.outlineIcon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFillIcon() {
        return this.fillIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final NotificationTypeIcons copy(int outlineIcon, int fillIcon, boolean isVisible) {
        return new NotificationTypeIcons(outlineIcon, fillIcon, isVisible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationTypeIcons)) {
            return false;
        }
        NotificationTypeIcons notificationTypeIcons = (NotificationTypeIcons) other;
        return this.outlineIcon == notificationTypeIcons.outlineIcon && this.fillIcon == notificationTypeIcons.fillIcon && this.isVisible == notificationTypeIcons.isVisible;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.outlineIcon) * 31) + Integer.hashCode(this.fillIcon)) * 31) + Boolean.hashCode(this.isVisible);
    }

    public String toString() {
        return "NotificationTypeIcons(outlineIcon=" + this.outlineIcon + ", fillIcon=" + this.fillIcon + ", isVisible=" + this.isVisible + ")";
    }

    public NotificationTypeIcons(int i, int i2, boolean z) {
        this.outlineIcon = i;
        this.fillIcon = i2;
        this.isVisible = z;
    }

    public /* synthetic */ NotificationTypeIcons(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? true : z);
    }

    public final int getFillIcon() {
        return this.fillIcon;
    }

    public final int getOutlineIcon() {
        return this.outlineIcon;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
