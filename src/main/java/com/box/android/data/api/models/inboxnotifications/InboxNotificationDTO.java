package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J]\u0010\"\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006("}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationDTO;", "", "id", "", "type", "createdAt", "isSeen", "", "isRead", "payload", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "recipient", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "ownedBy", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getCreatedAt", "()Z", "getPayload", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "getRecipient", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "getOwnedBy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationDTO {
    private final String createdAt;
    private final String id;
    private final boolean isRead;
    private final boolean isSeen;
    private final InboxNotificationUserDTO ownedBy;
    private final InboxNotificationPayloadDTO payload;
    private final InboxNotificationUserDTO recipient;
    private final String type;

    public static /* synthetic */ InboxNotificationDTO copy$default(InboxNotificationDTO inboxNotificationDTO, String str, String str2, String str3, boolean z, boolean z2, InboxNotificationPayloadDTO inboxNotificationPayloadDTO, InboxNotificationUserDTO inboxNotificationUserDTO, InboxNotificationUserDTO inboxNotificationUserDTO2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationDTO.createdAt;
        }
        if ((i & 8) != 0) {
            z = inboxNotificationDTO.isSeen;
        }
        if ((i & 16) != 0) {
            z2 = inboxNotificationDTO.isRead;
        }
        if ((i & 32) != 0) {
            inboxNotificationPayloadDTO = inboxNotificationDTO.payload;
        }
        if ((i & 64) != 0) {
            inboxNotificationUserDTO = inboxNotificationDTO.recipient;
        }
        if ((i & 128) != 0) {
            inboxNotificationUserDTO2 = inboxNotificationDTO.ownedBy;
        }
        InboxNotificationUserDTO inboxNotificationUserDTO3 = inboxNotificationUserDTO;
        InboxNotificationUserDTO inboxNotificationUserDTO4 = inboxNotificationUserDTO2;
        boolean z3 = z2;
        InboxNotificationPayloadDTO inboxNotificationPayloadDTO2 = inboxNotificationPayloadDTO;
        return inboxNotificationDTO.copy(str, str2, str3, z, z3, inboxNotificationPayloadDTO2, inboxNotificationUserDTO3, inboxNotificationUserDTO4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSeen() {
        return this.isSeen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final InboxNotificationPayloadDTO getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final InboxNotificationUserDTO getRecipient() {
        return this.recipient;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final InboxNotificationUserDTO getOwnedBy() {
        return this.ownedBy;
    }

    public final InboxNotificationDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "created_at") String createdAt, @Json(name = "is_seen") boolean isSeen, @Json(name = "is_read") boolean isRead, @Json(name = "payload") InboxNotificationPayloadDTO payload, @Json(name = "recipient") InboxNotificationUserDTO recipient, @Json(name = BoxItem.FIELD_OWNED_BY) InboxNotificationUserDTO ownedBy) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new InboxNotificationDTO(id, type, createdAt, isSeen, isRead, payload, recipient, ownedBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationDTO)) {
            return false;
        }
        InboxNotificationDTO inboxNotificationDTO = (InboxNotificationDTO) other;
        return Intrinsics.areEqual(this.id, inboxNotificationDTO.id) && Intrinsics.areEqual(this.type, inboxNotificationDTO.type) && Intrinsics.areEqual(this.createdAt, inboxNotificationDTO.createdAt) && this.isSeen == inboxNotificationDTO.isSeen && this.isRead == inboxNotificationDTO.isRead && Intrinsics.areEqual(this.payload, inboxNotificationDTO.payload) && Intrinsics.areEqual(this.recipient, inboxNotificationDTO.recipient) && Intrinsics.areEqual(this.ownedBy, inboxNotificationDTO.ownedBy);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + Boolean.hashCode(this.isSeen)) * 31) + Boolean.hashCode(this.isRead)) * 31) + this.payload.hashCode()) * 31;
        InboxNotificationUserDTO inboxNotificationUserDTO = this.recipient;
        int iHashCode2 = (iHashCode + (inboxNotificationUserDTO == null ? 0 : inboxNotificationUserDTO.hashCode())) * 31;
        InboxNotificationUserDTO inboxNotificationUserDTO2 = this.ownedBy;
        return iHashCode2 + (inboxNotificationUserDTO2 != null ? inboxNotificationUserDTO2.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationDTO(id=" + this.id + ", type=" + this.type + ", createdAt=" + this.createdAt + ", isSeen=" + this.isSeen + ", isRead=" + this.isRead + ", payload=" + this.payload + ", recipient=" + this.recipient + ", ownedBy=" + this.ownedBy + ")";
    }

    public InboxNotificationDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "created_at") String createdAt, @Json(name = "is_seen") boolean z, @Json(name = "is_read") boolean z2, @Json(name = "payload") InboxNotificationPayloadDTO payload, @Json(name = "recipient") InboxNotificationUserDTO inboxNotificationUserDTO, @Json(name = BoxItem.FIELD_OWNED_BY) InboxNotificationUserDTO inboxNotificationUserDTO2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.id = id;
        this.type = type;
        this.createdAt = createdAt;
        this.isSeen = z;
        this.isRead = z2;
        this.payload = payload;
        this.recipient = inboxNotificationUserDTO;
        this.ownedBy = inboxNotificationUserDTO2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final boolean isSeen() {
        return this.isSeen;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final InboxNotificationPayloadDTO getPayload() {
        return this.payload;
    }

    public final InboxNotificationUserDTO getRecipient() {
        return this.recipient;
    }

    public final InboxNotificationUserDTO getOwnedBy() {
        return this.ownedBy;
    }
}
