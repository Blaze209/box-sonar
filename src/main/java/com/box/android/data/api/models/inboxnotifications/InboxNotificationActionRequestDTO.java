package com.box.android.data.api.models.inboxnotifications;

import com.box.android.common.utilities.IntentConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationActionRequestDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionRequestDTO;", "", "type", "", "notificationId", "actionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getNotificationId", "getActionId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationActionRequestDTO {
    private final String actionId;
    private final String notificationId;
    private final String type;

    public static /* synthetic */ InboxNotificationActionRequestDTO copy$default(InboxNotificationActionRequestDTO inboxNotificationActionRequestDTO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationActionRequestDTO.type;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationActionRequestDTO.notificationId;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationActionRequestDTO.actionId;
        }
        return inboxNotificationActionRequestDTO.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNotificationId() {
        return this.notificationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    public final InboxNotificationActionRequestDTO copy(@Json(name = "type") String type, @Json(name = IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL) String notificationId, @Json(name = BoxNoteCreation.FIELD_ACTION_ID) String actionId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        return new InboxNotificationActionRequestDTO(type, notificationId, actionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationActionRequestDTO)) {
            return false;
        }
        InboxNotificationActionRequestDTO inboxNotificationActionRequestDTO = (InboxNotificationActionRequestDTO) other;
        return Intrinsics.areEqual(this.type, inboxNotificationActionRequestDTO.type) && Intrinsics.areEqual(this.notificationId, inboxNotificationActionRequestDTO.notificationId) && Intrinsics.areEqual(this.actionId, inboxNotificationActionRequestDTO.actionId);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.notificationId.hashCode()) * 31) + this.actionId.hashCode();
    }

    public String toString() {
        return "InboxNotificationActionRequestDTO(type=" + this.type + ", notificationId=" + this.notificationId + ", actionId=" + this.actionId + ")";
    }

    public InboxNotificationActionRequestDTO(@Json(name = "type") String type, @Json(name = IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL) String notificationId, @Json(name = BoxNoteCreation.FIELD_ACTION_ID) String actionId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        this.type = type;
        this.notificationId = notificationId;
        this.actionId = actionId;
    }

    public /* synthetic */ InboxNotificationActionRequestDTO(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "action-request" : str, str2, str3);
    }

    public final String getType() {
        return this.type;
    }

    public final String getNotificationId() {
        return this.notificationId;
    }

    public final String getActionId() {
        return this.actionId;
    }
}
