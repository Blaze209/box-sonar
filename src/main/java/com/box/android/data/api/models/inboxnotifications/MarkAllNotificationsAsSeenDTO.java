package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkAllNotificationsAsSeenDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/MarkAllNotificationsAsSeenDTO;", "", "lastNotificationSeen", "Lcom/box/android/data/api/models/inboxnotifications/LastNotificationSeenDTO;", "<init>", "(Lcom/box/android/data/api/models/inboxnotifications/LastNotificationSeenDTO;)V", "getLastNotificationSeen", "()Lcom/box/android/data/api/models/inboxnotifications/LastNotificationSeenDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MarkAllNotificationsAsSeenDTO {
    private final LastNotificationSeenDTO lastNotificationSeen;

    public static /* synthetic */ MarkAllNotificationsAsSeenDTO copy$default(MarkAllNotificationsAsSeenDTO markAllNotificationsAsSeenDTO, LastNotificationSeenDTO lastNotificationSeenDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            lastNotificationSeenDTO = markAllNotificationsAsSeenDTO.lastNotificationSeen;
        }
        return markAllNotificationsAsSeenDTO.copy(lastNotificationSeenDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LastNotificationSeenDTO getLastNotificationSeen() {
        return this.lastNotificationSeen;
    }

    public final MarkAllNotificationsAsSeenDTO copy(@Json(name = "last_notification_seen") LastNotificationSeenDTO lastNotificationSeen) {
        Intrinsics.checkNotNullParameter(lastNotificationSeen, "lastNotificationSeen");
        return new MarkAllNotificationsAsSeenDTO(lastNotificationSeen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MarkAllNotificationsAsSeenDTO) && Intrinsics.areEqual(this.lastNotificationSeen, ((MarkAllNotificationsAsSeenDTO) other).lastNotificationSeen);
    }

    public int hashCode() {
        return this.lastNotificationSeen.hashCode();
    }

    public String toString() {
        return "MarkAllNotificationsAsSeenDTO(lastNotificationSeen=" + this.lastNotificationSeen + ")";
    }

    public MarkAllNotificationsAsSeenDTO(@Json(name = "last_notification_seen") LastNotificationSeenDTO lastNotificationSeen) {
        Intrinsics.checkNotNullParameter(lastNotificationSeen, "lastNotificationSeen");
        this.lastNotificationSeen = lastNotificationSeen;
    }

    public final LastNotificationSeenDTO getLastNotificationSeen() {
        return this.lastNotificationSeen;
    }
}
