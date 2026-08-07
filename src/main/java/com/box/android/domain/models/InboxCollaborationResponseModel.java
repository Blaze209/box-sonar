package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import com.box.android.domain.models.item.UserModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCollaborationResponseModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00105\u001a\u00020\u0014HÆ\u0003J\u0093\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010(¨\u0006="}, d2 = {"Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "", "id", "createdBy", "Lcom/box/android/domain/models/item/UserModel;", "createdAt", "Ljava/util/Date;", "modifiedAt", "expiresAt", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "accessibleBy", "inviteEmail", "role", "acknowledgedAt", "item", "Lcom/box/android/domain/models/ItemId;", "isAccessOnly", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;Lcom/box/android/domain/models/item/UserModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/domain/models/ItemId;Z)V", "getType", "()Ljava/lang/String;", "getId", "getCreatedBy", "()Lcom/box/android/domain/models/item/UserModel;", "getCreatedAt", "()Ljava/util/Date;", "getModifiedAt", "getExpiresAt", "getStatus", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "getAccessibleBy", "getInviteEmail", "getRole", "getAcknowledgedAt", "getItem", "()Lcom/box/android/domain/models/ItemId;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxCollaborationResponseModel implements DomainModel {
    private final UserModel accessibleBy;
    private final Date acknowledgedAt;
    private final Date createdAt;
    private final UserModel createdBy;
    private final Date expiresAt;
    private final String id;
    private final String inviteEmail;
    private final boolean isAccessOnly;
    private final ItemId item;
    private final Date modifiedAt;
    private final String role;
    private final InboxNotificationCollaborationStatus status;
    private final String type;

    public static /* synthetic */ InboxCollaborationResponseModel copy$default(InboxCollaborationResponseModel inboxCollaborationResponseModel, String str, String str2, UserModel userModel, Date date, Date date2, Date date3, InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, UserModel userModel2, String str3, String str4, Date date4, ItemId itemId, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxCollaborationResponseModel.type;
        }
        return inboxCollaborationResponseModel.copy(str, (i & 2) != 0 ? inboxCollaborationResponseModel.id : str2, (i & 4) != 0 ? inboxCollaborationResponseModel.createdBy : userModel, (i & 8) != 0 ? inboxCollaborationResponseModel.createdAt : date, (i & 16) != 0 ? inboxCollaborationResponseModel.modifiedAt : date2, (i & 32) != 0 ? inboxCollaborationResponseModel.expiresAt : date3, (i & 64) != 0 ? inboxCollaborationResponseModel.status : inboxNotificationCollaborationStatus, (i & 128) != 0 ? inboxCollaborationResponseModel.accessibleBy : userModel2, (i & 256) != 0 ? inboxCollaborationResponseModel.inviteEmail : str3, (i & 512) != 0 ? inboxCollaborationResponseModel.role : str4, (i & 1024) != 0 ? inboxCollaborationResponseModel.acknowledgedAt : date4, (i & 2048) != 0 ? inboxCollaborationResponseModel.item : itemId, (i & 4096) != 0 ? inboxCollaborationResponseModel.isAccessOnly : z);
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
    public final Date getAcknowledgedAt() {
        return this.acknowledgedAt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ItemId getItem() {
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
    public final UserModel getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final InboxNotificationCollaborationStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final UserModel getAccessibleBy() {
        return this.accessibleBy;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final InboxCollaborationResponseModel copy(String type, String id, UserModel createdBy, Date createdAt, Date modifiedAt, Date expiresAt, InboxNotificationCollaborationStatus status, UserModel accessibleBy, String inviteEmail, String role, Date acknowledgedAt, ItemId item, boolean isAccessOnly) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(accessibleBy, "accessibleBy");
        Intrinsics.checkNotNullParameter(role, "role");
        return new InboxCollaborationResponseModel(type, id, createdBy, createdAt, modifiedAt, expiresAt, status, accessibleBy, inviteEmail, role, acknowledgedAt, item, isAccessOnly);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxCollaborationResponseModel)) {
            return false;
        }
        InboxCollaborationResponseModel inboxCollaborationResponseModel = (InboxCollaborationResponseModel) other;
        return Intrinsics.areEqual(this.type, inboxCollaborationResponseModel.type) && Intrinsics.areEqual(this.id, inboxCollaborationResponseModel.id) && Intrinsics.areEqual(this.createdBy, inboxCollaborationResponseModel.createdBy) && Intrinsics.areEqual(this.createdAt, inboxCollaborationResponseModel.createdAt) && Intrinsics.areEqual(this.modifiedAt, inboxCollaborationResponseModel.modifiedAt) && Intrinsics.areEqual(this.expiresAt, inboxCollaborationResponseModel.expiresAt) && this.status == inboxCollaborationResponseModel.status && Intrinsics.areEqual(this.accessibleBy, inboxCollaborationResponseModel.accessibleBy) && Intrinsics.areEqual(this.inviteEmail, inboxCollaborationResponseModel.inviteEmail) && Intrinsics.areEqual(this.role, inboxCollaborationResponseModel.role) && Intrinsics.areEqual(this.acknowledgedAt, inboxCollaborationResponseModel.acknowledgedAt) && Intrinsics.areEqual(this.item, inboxCollaborationResponseModel.item) && this.isAccessOnly == inboxCollaborationResponseModel.isAccessOnly;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.modifiedAt.hashCode()) * 31;
        Date date = this.expiresAt;
        int iHashCode2 = (((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.status.hashCode()) * 31) + this.accessibleBy.hashCode()) * 31;
        String str = this.inviteEmail;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.role.hashCode()) * 31;
        Date date2 = this.acknowledgedAt;
        int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
        ItemId itemId = this.item;
        return ((iHashCode4 + (itemId != null ? itemId.hashCode() : 0)) * 31) + Boolean.hashCode(this.isAccessOnly);
    }

    public String toString() {
        return "InboxCollaborationResponseModel(type=" + this.type + ", id=" + this.id + ", createdBy=" + this.createdBy + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", expiresAt=" + this.expiresAt + ", status=" + this.status + ", accessibleBy=" + this.accessibleBy + ", inviteEmail=" + this.inviteEmail + ", role=" + this.role + ", acknowledgedAt=" + this.acknowledgedAt + ", item=" + this.item + ", isAccessOnly=" + this.isAccessOnly + ")";
    }

    public InboxCollaborationResponseModel(String type, String id, UserModel createdBy, Date createdAt, Date modifiedAt, Date date, InboxNotificationCollaborationStatus status, UserModel accessibleBy, String str, String role, Date date2, ItemId itemId, boolean z) {
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
        this.expiresAt = date;
        this.status = status;
        this.accessibleBy = accessibleBy;
        this.inviteEmail = str;
        this.role = role;
        this.acknowledgedAt = date2;
        this.item = itemId;
        this.isAccessOnly = z;
    }

    public final String getType() {
        return this.type;
    }

    public final String getId() {
        return this.id;
    }

    public final UserModel getCreatedBy() {
        return this.createdBy;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    public final InboxNotificationCollaborationStatus getStatus() {
        return this.status;
    }

    public final UserModel getAccessibleBy() {
        return this.accessibleBy;
    }

    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final String getRole() {
        return this.role;
    }

    public final Date getAcknowledgedAt() {
        return this.acknowledgedAt;
    }

    public final ItemId getItem() {
        return this.item;
    }

    public final boolean isAccessOnly() {
        return this.isAccessOnly;
    }
}
