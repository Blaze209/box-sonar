package com.box.android.data.api.models;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCollaborationResponseDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\u0093\u0001\u00102\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010$¨\u00068"}, d2 = {"Lcom/box/android/data/api/models/InboxCollaborationResponseDTO;", "", "type", "", "id", "createdBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "createdAt", "modifiedAt", "expiresAt", "status", "accessibleBy", "inviteEmail", "role", "acknowledgedAt", "item", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "isAccessOnly", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/ItemIdDTO;Z)V", "getType", "()Ljava/lang/String;", "getId", "getCreatedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getCreatedAt", "getModifiedAt", "getExpiresAt", "getStatus", "getAccessibleBy", "getInviteEmail", "getRole", "getAcknowledgedAt", "getItem", "()Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxCollaborationResponseDTO {
    private final UserMiniDTO accessibleBy;
    private final String acknowledgedAt;
    private final String createdAt;
    private final UserMiniDTO createdBy;
    private final String expiresAt;
    private final String id;
    private final String inviteEmail;
    private final boolean isAccessOnly;
    private final ItemIdDTO item;
    private final String modifiedAt;
    private final String role;
    private final String status;
    private final String type;

    public static /* synthetic */ InboxCollaborationResponseDTO copy$default(InboxCollaborationResponseDTO inboxCollaborationResponseDTO, String str, String str2, UserMiniDTO userMiniDTO, String str3, String str4, String str5, String str6, UserMiniDTO userMiniDTO2, String str7, String str8, String str9, ItemIdDTO itemIdDTO, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxCollaborationResponseDTO.type;
        }
        return inboxCollaborationResponseDTO.copy(str, (i & 2) != 0 ? inboxCollaborationResponseDTO.id : str2, (i & 4) != 0 ? inboxCollaborationResponseDTO.createdBy : userMiniDTO, (i & 8) != 0 ? inboxCollaborationResponseDTO.createdAt : str3, (i & 16) != 0 ? inboxCollaborationResponseDTO.modifiedAt : str4, (i & 32) != 0 ? inboxCollaborationResponseDTO.expiresAt : str5, (i & 64) != 0 ? inboxCollaborationResponseDTO.status : str6, (i & 128) != 0 ? inboxCollaborationResponseDTO.accessibleBy : userMiniDTO2, (i & 256) != 0 ? inboxCollaborationResponseDTO.inviteEmail : str7, (i & 512) != 0 ? inboxCollaborationResponseDTO.role : str8, (i & 1024) != 0 ? inboxCollaborationResponseDTO.acknowledgedAt : str9, (i & 2048) != 0 ? inboxCollaborationResponseDTO.item : itemIdDTO, (i & 4096) != 0 ? inboxCollaborationResponseDTO.isAccessOnly : z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAcknowledgedAt() {
        return this.acknowledgedAt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ItemIdDTO getItem() {
        return this.item;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsAccessOnly() {
        return this.isAccessOnly;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final UserMiniDTO getAccessibleBy() {
        return this.accessibleBy;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final InboxCollaborationResponseDTO copy(@Json(name = "type") String type, @Json(name = "id") String id, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "created_at") String createdAt, @Json(name = "modified_at") String modifiedAt, @Json(name = BoxCollaboration.FIELD_EXPIRES_AT) String expiresAt, @Json(name = "status") String status, @Json(name = "accessible_by") UserMiniDTO accessibleBy, @Json(name = BoxCollaboration.FIELD_INVITE_EMAIL) String inviteEmail, @Json(name = "role") String role, @Json(name = BoxCollaboration.FIELD_ACKNOWLEDGED_AT) String acknowledgedAt, @Json(name = "item") ItemIdDTO item, @Json(name = "is_access_only") boolean isAccessOnly) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(accessibleBy, "accessibleBy");
        Intrinsics.checkNotNullParameter(role, "role");
        return new InboxCollaborationResponseDTO(type, id, createdBy, createdAt, modifiedAt, expiresAt, status, accessibleBy, inviteEmail, role, acknowledgedAt, item, isAccessOnly);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxCollaborationResponseDTO)) {
            return false;
        }
        InboxCollaborationResponseDTO inboxCollaborationResponseDTO = (InboxCollaborationResponseDTO) other;
        return Intrinsics.areEqual(this.type, inboxCollaborationResponseDTO.type) && Intrinsics.areEqual(this.id, inboxCollaborationResponseDTO.id) && Intrinsics.areEqual(this.createdBy, inboxCollaborationResponseDTO.createdBy) && Intrinsics.areEqual(this.createdAt, inboxCollaborationResponseDTO.createdAt) && Intrinsics.areEqual(this.modifiedAt, inboxCollaborationResponseDTO.modifiedAt) && Intrinsics.areEqual(this.expiresAt, inboxCollaborationResponseDTO.expiresAt) && Intrinsics.areEqual(this.status, inboxCollaborationResponseDTO.status) && Intrinsics.areEqual(this.accessibleBy, inboxCollaborationResponseDTO.accessibleBy) && Intrinsics.areEqual(this.inviteEmail, inboxCollaborationResponseDTO.inviteEmail) && Intrinsics.areEqual(this.role, inboxCollaborationResponseDTO.role) && Intrinsics.areEqual(this.acknowledgedAt, inboxCollaborationResponseDTO.acknowledgedAt) && Intrinsics.areEqual(this.item, inboxCollaborationResponseDTO.item) && this.isAccessOnly == inboxCollaborationResponseDTO.isAccessOnly;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.modifiedAt.hashCode()) * 31;
        String str = this.expiresAt;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status.hashCode()) * 31) + this.accessibleBy.hashCode()) * 31;
        String str2 = this.inviteEmail;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.role.hashCode()) * 31;
        String str3 = this.acknowledgedAt;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ItemIdDTO itemIdDTO = this.item;
        return ((iHashCode4 + (itemIdDTO != null ? itemIdDTO.hashCode() : 0)) * 31) + Boolean.hashCode(this.isAccessOnly);
    }

    public String toString() {
        return "InboxCollaborationResponseDTO(type=" + this.type + ", id=" + this.id + ", createdBy=" + this.createdBy + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", expiresAt=" + this.expiresAt + ", status=" + this.status + ", accessibleBy=" + this.accessibleBy + ", inviteEmail=" + this.inviteEmail + ", role=" + this.role + ", acknowledgedAt=" + this.acknowledgedAt + ", item=" + this.item + ", isAccessOnly=" + this.isAccessOnly + ")";
    }

    public InboxCollaborationResponseDTO(@Json(name = "type") String type, @Json(name = "id") String id, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "created_at") String createdAt, @Json(name = "modified_at") String modifiedAt, @Json(name = BoxCollaboration.FIELD_EXPIRES_AT) String str, @Json(name = "status") String status, @Json(name = "accessible_by") UserMiniDTO accessibleBy, @Json(name = BoxCollaboration.FIELD_INVITE_EMAIL) String str2, @Json(name = "role") String role, @Json(name = BoxCollaboration.FIELD_ACKNOWLEDGED_AT) String str3, @Json(name = "item") ItemIdDTO itemIdDTO, @Json(name = "is_access_only") boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(accessibleBy, "accessibleBy");
        Intrinsics.checkNotNullParameter(role, "role");
        this.type = type;
        this.id = id;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.expiresAt = str;
        this.status = status;
        this.accessibleBy = accessibleBy;
        this.inviteEmail = str2;
        this.role = role;
        this.acknowledgedAt = str3;
        this.item = itemIdDTO;
        this.isAccessOnly = z;
    }

    public final String getType() {
        return this.type;
    }

    public final String getId() {
        return this.id;
    }

    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getModifiedAt() {
        return this.modifiedAt;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getStatus() {
        return this.status;
    }

    public final UserMiniDTO getAccessibleBy() {
        return this.accessibleBy;
    }

    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getAcknowledgedAt() {
        return this.acknowledgedAt;
    }

    public final ItemIdDTO getItem() {
        return this.item;
    }

    public final boolean isAccessOnly() {
        return this.isAccessOnly;
    }
}
