package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCollaborationDTO;", "", "id", "", "type", "role", "status", "createdBy", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "acceptanceRequirementsStatus", "Lcom/box/android/data/api/models/inboxnotifications/AcceptanceRequirementsStatusDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;Lcom/box/android/data/api/models/inboxnotifications/AcceptanceRequirementsStatusDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getRole", "getStatus", "getCreatedBy", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "getAcceptanceRequirementsStatus", "()Lcom/box/android/data/api/models/inboxnotifications/AcceptanceRequirementsStatusDTO;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationCollaborationDTO {
    private final AcceptanceRequirementsStatusDTO acceptanceRequirementsStatus;
    private final InboxNotificationUserDTO createdBy;
    private final String id;
    private final String role;
    private final String status;
    private final String type;

    public static /* synthetic */ InboxNotificationCollaborationDTO copy$default(InboxNotificationCollaborationDTO inboxNotificationCollaborationDTO, String str, String str2, String str3, String str4, InboxNotificationUserDTO inboxNotificationUserDTO, AcceptanceRequirementsStatusDTO acceptanceRequirementsStatusDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationCollaborationDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationCollaborationDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationCollaborationDTO.role;
        }
        if ((i & 8) != 0) {
            str4 = inboxNotificationCollaborationDTO.status;
        }
        if ((i & 16) != 0) {
            inboxNotificationUserDTO = inboxNotificationCollaborationDTO.createdBy;
        }
        if ((i & 32) != 0) {
            acceptanceRequirementsStatusDTO = inboxNotificationCollaborationDTO.acceptanceRequirementsStatus;
        }
        InboxNotificationUserDTO inboxNotificationUserDTO2 = inboxNotificationUserDTO;
        AcceptanceRequirementsStatusDTO acceptanceRequirementsStatusDTO2 = acceptanceRequirementsStatusDTO;
        return inboxNotificationCollaborationDTO.copy(str, str2, str3, str4, inboxNotificationUserDTO2, acceptanceRequirementsStatusDTO2);
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
    public final String getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final InboxNotificationUserDTO getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AcceptanceRequirementsStatusDTO getAcceptanceRequirementsStatus() {
        return this.acceptanceRequirementsStatus;
    }

    public final InboxNotificationCollaborationDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "role") String role, @Json(name = "status") String status, @Json(name = "created_by") InboxNotificationUserDTO createdBy, @Json(name = "acceptance_requirements_status") AcceptanceRequirementsStatusDTO acceptanceRequirementsStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(acceptanceRequirementsStatus, "acceptanceRequirementsStatus");
        return new InboxNotificationCollaborationDTO(id, type, role, status, createdBy, acceptanceRequirementsStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationCollaborationDTO)) {
            return false;
        }
        InboxNotificationCollaborationDTO inboxNotificationCollaborationDTO = (InboxNotificationCollaborationDTO) other;
        return Intrinsics.areEqual(this.id, inboxNotificationCollaborationDTO.id) && Intrinsics.areEqual(this.type, inboxNotificationCollaborationDTO.type) && Intrinsics.areEqual(this.role, inboxNotificationCollaborationDTO.role) && Intrinsics.areEqual(this.status, inboxNotificationCollaborationDTO.status) && Intrinsics.areEqual(this.createdBy, inboxNotificationCollaborationDTO.createdBy) && Intrinsics.areEqual(this.acceptanceRequirementsStatus, inboxNotificationCollaborationDTO.acceptanceRequirementsStatus);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.role.hashCode()) * 31) + this.status.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.acceptanceRequirementsStatus.hashCode();
    }

    public String toString() {
        return "InboxNotificationCollaborationDTO(id=" + this.id + ", type=" + this.type + ", role=" + this.role + ", status=" + this.status + ", createdBy=" + this.createdBy + ", acceptanceRequirementsStatus=" + this.acceptanceRequirementsStatus + ")";
    }

    public InboxNotificationCollaborationDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "role") String role, @Json(name = "status") String status, @Json(name = "created_by") InboxNotificationUserDTO createdBy, @Json(name = "acceptance_requirements_status") AcceptanceRequirementsStatusDTO acceptanceRequirementsStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(acceptanceRequirementsStatus, "acceptanceRequirementsStatus");
        this.id = id;
        this.type = type;
        this.role = role;
        this.status = status;
        this.createdBy = createdBy;
        this.acceptanceRequirementsStatus = acceptanceRequirementsStatus;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getStatus() {
        return this.status;
    }

    public final InboxNotificationUserDTO getCreatedBy() {
        return this.createdBy;
    }

    public final AcceptanceRequirementsStatusDTO getAcceptanceRequirementsStatus() {
        return this.acceptanceRequirementsStatus;
    }
}
