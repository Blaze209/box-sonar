package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationActionResponseDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionResponseDTO;", "", "type", "", "status", "immediateAction", "Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "payload", "Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;)V", "getType", "()Ljava/lang/String;", "getStatus", "getImmediateAction", "()Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "getPayload", "()Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationActionResponseDTO {
    private final ActionDTO immediateAction;
    private final CommonPayloadDTOInbox payload;
    private final String status;
    private final String type;

    public static /* synthetic */ InboxNotificationActionResponseDTO copy$default(InboxNotificationActionResponseDTO inboxNotificationActionResponseDTO, String str, String str2, ActionDTO actionDTO, CommonPayloadDTOInbox commonPayloadDTOInbox, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationActionResponseDTO.type;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationActionResponseDTO.status;
        }
        if ((i & 4) != 0) {
            actionDTO = inboxNotificationActionResponseDTO.immediateAction;
        }
        if ((i & 8) != 0) {
            commonPayloadDTOInbox = inboxNotificationActionResponseDTO.payload;
        }
        return inboxNotificationActionResponseDTO.copy(str, str2, actionDTO, commonPayloadDTOInbox);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ActionDTO getImmediateAction() {
        return this.immediateAction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CommonPayloadDTOInbox getPayload() {
        return this.payload;
    }

    public final InboxNotificationActionResponseDTO copy(@Json(name = "type") String type, @Json(name = "status") String status, @Json(name = "immediate_action") ActionDTO immediateAction, @Json(name = "payload") CommonPayloadDTOInbox payload) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        return new InboxNotificationActionResponseDTO(type, status, immediateAction, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationActionResponseDTO)) {
            return false;
        }
        InboxNotificationActionResponseDTO inboxNotificationActionResponseDTO = (InboxNotificationActionResponseDTO) other;
        return Intrinsics.areEqual(this.type, inboxNotificationActionResponseDTO.type) && Intrinsics.areEqual(this.status, inboxNotificationActionResponseDTO.status) && Intrinsics.areEqual(this.immediateAction, inboxNotificationActionResponseDTO.immediateAction) && Intrinsics.areEqual(this.payload, inboxNotificationActionResponseDTO.payload);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.status.hashCode()) * 31;
        ActionDTO actionDTO = this.immediateAction;
        int iHashCode2 = (iHashCode + (actionDTO == null ? 0 : actionDTO.hashCode())) * 31;
        CommonPayloadDTOInbox commonPayloadDTOInbox = this.payload;
        return iHashCode2 + (commonPayloadDTOInbox != null ? commonPayloadDTOInbox.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationActionResponseDTO(type=" + this.type + ", status=" + this.status + ", immediateAction=" + this.immediateAction + ", payload=" + this.payload + ")";
    }

    public InboxNotificationActionResponseDTO(@Json(name = "type") String type, @Json(name = "status") String status, @Json(name = "immediate_action") ActionDTO actionDTO, @Json(name = "payload") CommonPayloadDTOInbox commonPayloadDTOInbox) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        this.type = type;
        this.status = status;
        this.immediateAction = actionDTO;
        this.payload = commonPayloadDTOInbox;
    }

    public final String getType() {
        return this.type;
    }

    public final String getStatus() {
        return this.status;
    }

    public final ActionDTO getImmediateAction() {
        return this.immediateAction;
    }

    public final CommonPayloadDTOInbox getPayload() {
        return this.payload;
    }
}
