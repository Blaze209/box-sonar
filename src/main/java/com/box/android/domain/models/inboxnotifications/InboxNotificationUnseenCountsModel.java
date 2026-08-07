package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: InboxNotificationUnseenCountsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUnseenCountsModel;", "Lcom/box/android/domain/models/DomainModel;", "unseenNotificationsCount", "", "<init>", "(I)V", "getUnseenNotificationsCount", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationUnseenCountsModel implements DomainModel {
    private final int unseenNotificationsCount;

    public static /* synthetic */ InboxNotificationUnseenCountsModel copy$default(InboxNotificationUnseenCountsModel inboxNotificationUnseenCountsModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = inboxNotificationUnseenCountsModel.unseenNotificationsCount;
        }
        return inboxNotificationUnseenCountsModel.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUnseenNotificationsCount() {
        return this.unseenNotificationsCount;
    }

    public final InboxNotificationUnseenCountsModel copy(int unseenNotificationsCount) {
        return new InboxNotificationUnseenCountsModel(unseenNotificationsCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InboxNotificationUnseenCountsModel) && this.unseenNotificationsCount == ((InboxNotificationUnseenCountsModel) other).unseenNotificationsCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.unseenNotificationsCount);
    }

    public String toString() {
        return "InboxNotificationUnseenCountsModel(unseenNotificationsCount=" + this.unseenNotificationsCount + ")";
    }

    public InboxNotificationUnseenCountsModel(int i) {
        this.unseenNotificationsCount = i;
    }

    public final int getUnseenNotificationsCount() {
        return this.unseenNotificationsCount;
    }
}
