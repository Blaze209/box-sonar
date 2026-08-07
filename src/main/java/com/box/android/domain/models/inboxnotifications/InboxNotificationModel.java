package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J]\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006)"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", "createdAt", "isSeen", "", "isRead", "payload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "recipient", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "ownedBy", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getId", "()Ljava/lang/String;", "getType", "getCreatedAt", "()Z", "getPayload", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "getRecipient", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "getOwnedBy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationModel implements DomainModel {
    private final String createdAt;
    private final String id;
    private final boolean isRead;
    private final boolean isSeen;
    private final InboxNotificationUserModel ownedBy;
    private final InboxNotificationPayloadModel payload;
    private final InboxNotificationUserModel recipient;
    private final String type;

    public static /* synthetic */ InboxNotificationModel copy$default(InboxNotificationModel inboxNotificationModel, String str, String str2, String str3, boolean z, boolean z2, InboxNotificationPayloadModel inboxNotificationPayloadModel, InboxNotificationUserModel inboxNotificationUserModel, InboxNotificationUserModel inboxNotificationUserModel2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationModel.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationModel.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationModel.createdAt;
        }
        if ((i & 8) != 0) {
            z = inboxNotificationModel.isSeen;
        }
        if ((i & 16) != 0) {
            z2 = inboxNotificationModel.isRead;
        }
        if ((i & 32) != 0) {
            inboxNotificationPayloadModel = inboxNotificationModel.payload;
        }
        if ((i & 64) != 0) {
            inboxNotificationUserModel = inboxNotificationModel.recipient;
        }
        if ((i & 128) != 0) {
            inboxNotificationUserModel2 = inboxNotificationModel.ownedBy;
        }
        InboxNotificationUserModel inboxNotificationUserModel3 = inboxNotificationUserModel;
        InboxNotificationUserModel inboxNotificationUserModel4 = inboxNotificationUserModel2;
        boolean z3 = z2;
        InboxNotificationPayloadModel inboxNotificationPayloadModel2 = inboxNotificationPayloadModel;
        return inboxNotificationModel.copy(str, str2, str3, z, z3, inboxNotificationPayloadModel2, inboxNotificationUserModel3, inboxNotificationUserModel4);
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
    public final InboxNotificationPayloadModel getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final InboxNotificationUserModel getRecipient() {
        return this.recipient;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final InboxNotificationUserModel getOwnedBy() {
        return this.ownedBy;
    }

    public final InboxNotificationModel copy(String id, String type, String createdAt, boolean isSeen, boolean isRead, InboxNotificationPayloadModel payload, InboxNotificationUserModel recipient, InboxNotificationUserModel ownedBy) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new InboxNotificationModel(id, type, createdAt, isSeen, isRead, payload, recipient, ownedBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationModel)) {
            return false;
        }
        InboxNotificationModel inboxNotificationModel = (InboxNotificationModel) other;
        return Intrinsics.areEqual(this.id, inboxNotificationModel.id) && Intrinsics.areEqual(this.type, inboxNotificationModel.type) && Intrinsics.areEqual(this.createdAt, inboxNotificationModel.createdAt) && this.isSeen == inboxNotificationModel.isSeen && this.isRead == inboxNotificationModel.isRead && Intrinsics.areEqual(this.payload, inboxNotificationModel.payload) && Intrinsics.areEqual(this.recipient, inboxNotificationModel.recipient) && Intrinsics.areEqual(this.ownedBy, inboxNotificationModel.ownedBy);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + Boolean.hashCode(this.isSeen)) * 31) + Boolean.hashCode(this.isRead)) * 31) + this.payload.hashCode()) * 31;
        InboxNotificationUserModel inboxNotificationUserModel = this.recipient;
        int iHashCode2 = (iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode())) * 31;
        InboxNotificationUserModel inboxNotificationUserModel2 = this.ownedBy;
        return iHashCode2 + (inboxNotificationUserModel2 != null ? inboxNotificationUserModel2.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationModel(id=" + this.id + ", type=" + this.type + ", createdAt=" + this.createdAt + ", isSeen=" + this.isSeen + ", isRead=" + this.isRead + ", payload=" + this.payload + ", recipient=" + this.recipient + ", ownedBy=" + this.ownedBy + ")";
    }

    public InboxNotificationModel(String id, String type, String createdAt, boolean z, boolean z2, InboxNotificationPayloadModel payload, InboxNotificationUserModel inboxNotificationUserModel, InboxNotificationUserModel inboxNotificationUserModel2) {
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
        this.recipient = inboxNotificationUserModel;
        this.ownedBy = inboxNotificationUserModel2;
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

    public final InboxNotificationPayloadModel getPayload() {
        return this.payload;
    }

    public final InboxNotificationUserModel getRecipient() {
        return this.recipient;
    }

    public final InboxNotificationUserModel getOwnedBy() {
        return this.ownedBy;
    }
}
