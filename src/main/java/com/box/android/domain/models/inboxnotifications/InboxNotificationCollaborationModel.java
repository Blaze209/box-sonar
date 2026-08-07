package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", "role", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "createdBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "acceptanceRequirementsStatus", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementsStatusModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementsStatusModel;)V", "getId", "()Ljava/lang/String;", "getType", "getRole", "getStatus", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "getCreatedBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "getAcceptanceRequirementsStatus", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementsStatusModel;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationCollaborationModel implements DomainModel {
    private final AcceptanceRequirementsStatusModel acceptanceRequirementsStatus;
    private final InboxNotificationUserModel createdBy;
    private final String id;
    private final String role;
    private final InboxNotificationCollaborationStatus status;
    private final String type;

    public static /* synthetic */ InboxNotificationCollaborationModel copy$default(InboxNotificationCollaborationModel inboxNotificationCollaborationModel, String str, String str2, String str3, InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, InboxNotificationUserModel inboxNotificationUserModel, AcceptanceRequirementsStatusModel acceptanceRequirementsStatusModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationCollaborationModel.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationCollaborationModel.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationCollaborationModel.role;
        }
        if ((i & 8) != 0) {
            inboxNotificationCollaborationStatus = inboxNotificationCollaborationModel.status;
        }
        if ((i & 16) != 0) {
            inboxNotificationUserModel = inboxNotificationCollaborationModel.createdBy;
        }
        if ((i & 32) != 0) {
            acceptanceRequirementsStatusModel = inboxNotificationCollaborationModel.acceptanceRequirementsStatus;
        }
        InboxNotificationUserModel inboxNotificationUserModel2 = inboxNotificationUserModel;
        AcceptanceRequirementsStatusModel acceptanceRequirementsStatusModel2 = acceptanceRequirementsStatusModel;
        return inboxNotificationCollaborationModel.copy(str, str2, str3, inboxNotificationCollaborationStatus, inboxNotificationUserModel2, acceptanceRequirementsStatusModel2);
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
    public final InboxNotificationCollaborationStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final InboxNotificationUserModel getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AcceptanceRequirementsStatusModel getAcceptanceRequirementsStatus() {
        return this.acceptanceRequirementsStatus;
    }

    public final InboxNotificationCollaborationModel copy(String id, String type, String role, InboxNotificationCollaborationStatus status, InboxNotificationUserModel createdBy, AcceptanceRequirementsStatusModel acceptanceRequirementsStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(acceptanceRequirementsStatus, "acceptanceRequirementsStatus");
        return new InboxNotificationCollaborationModel(id, type, role, status, createdBy, acceptanceRequirementsStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationCollaborationModel)) {
            return false;
        }
        InboxNotificationCollaborationModel inboxNotificationCollaborationModel = (InboxNotificationCollaborationModel) other;
        return Intrinsics.areEqual(this.id, inboxNotificationCollaborationModel.id) && Intrinsics.areEqual(this.type, inboxNotificationCollaborationModel.type) && Intrinsics.areEqual(this.role, inboxNotificationCollaborationModel.role) && this.status == inboxNotificationCollaborationModel.status && Intrinsics.areEqual(this.createdBy, inboxNotificationCollaborationModel.createdBy) && Intrinsics.areEqual(this.acceptanceRequirementsStatus, inboxNotificationCollaborationModel.acceptanceRequirementsStatus);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.role.hashCode()) * 31) + this.status.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.acceptanceRequirementsStatus.hashCode();
    }

    public String toString() {
        return "InboxNotificationCollaborationModel(id=" + this.id + ", type=" + this.type + ", role=" + this.role + ", status=" + this.status + ", createdBy=" + this.createdBy + ", acceptanceRequirementsStatus=" + this.acceptanceRequirementsStatus + ")";
    }

    public InboxNotificationCollaborationModel(String id, String type, String role, InboxNotificationCollaborationStatus status, InboxNotificationUserModel createdBy, AcceptanceRequirementsStatusModel acceptanceRequirementsStatus) {
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

    public final InboxNotificationCollaborationStatus getStatus() {
        return this.status;
    }

    public final InboxNotificationUserModel getCreatedBy() {
        return this.createdBy;
    }

    public final AcceptanceRequirementsStatusModel getAcceptanceRequirementsStatus() {
        return this.acceptanceRequirementsStatus;
    }
}
