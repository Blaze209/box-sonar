package com.box.android.inbox.notifications.inboxitem.collab;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: InboxItemCollaborationStatus.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/CollaborationStatusInfo;", "", "iconRes", "", "titleRes", "<init>", "(II)V", "getIconRes", "()I", "getTitleRes", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollaborationStatusInfo {
    public static final int $stable = 0;
    private final int iconRes;
    private final int titleRes;

    public static /* synthetic */ CollaborationStatusInfo copy$default(CollaborationStatusInfo collaborationStatusInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = collaborationStatusInfo.iconRes;
        }
        if ((i3 & 2) != 0) {
            i2 = collaborationStatusInfo.titleRes;
        }
        return collaborationStatusInfo.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    public final CollaborationStatusInfo copy(int iconRes, int titleRes) {
        return new CollaborationStatusInfo(iconRes, titleRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollaborationStatusInfo)) {
            return false;
        }
        CollaborationStatusInfo collaborationStatusInfo = (CollaborationStatusInfo) other;
        return this.iconRes == collaborationStatusInfo.iconRes && this.titleRes == collaborationStatusInfo.titleRes;
    }

    public int hashCode() {
        return (Integer.hashCode(this.iconRes) * 31) + Integer.hashCode(this.titleRes);
    }

    public String toString() {
        return "CollaborationStatusInfo(iconRes=" + this.iconRes + ", titleRes=" + this.titleRes + ")";
    }

    public CollaborationStatusInfo(int i, int i2) {
        this.iconRes = i;
        this.titleRes = i2;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
