package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/SendSharedLinkPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "type", "", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "target", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "sentBy", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;)V", "getType", "()Ljava/lang/String;", "getSharedLink", "getTarget", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "getSentBy", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SendSharedLinkPayloadDTOInbox extends InboxNotificationPayloadDTO {
    private final InboxNotificationUserDTO sentBy;
    private final String sharedLink;
    private final InboxNotificationTargetItemDTO target;
    private final String type;

    public static /* synthetic */ SendSharedLinkPayloadDTOInbox copy$default(SendSharedLinkPayloadDTOInbox sendSharedLinkPayloadDTOInbox, String str, String str2, InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO, InboxNotificationUserDTO inboxNotificationUserDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendSharedLinkPayloadDTOInbox.type;
        }
        if ((i & 2) != 0) {
            str2 = sendSharedLinkPayloadDTOInbox.sharedLink;
        }
        if ((i & 4) != 0) {
            inboxNotificationTargetItemDTO = sendSharedLinkPayloadDTOInbox.target;
        }
        if ((i & 8) != 0) {
            inboxNotificationUserDTO = sendSharedLinkPayloadDTOInbox.sentBy;
        }
        return sendSharedLinkPayloadDTOInbox.copy(str, str2, inboxNotificationTargetItemDTO, inboxNotificationUserDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InboxNotificationTargetItemDTO getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InboxNotificationUserDTO getSentBy() {
        return this.sentBy;
    }

    public final SendSharedLinkPayloadDTOInbox copy(@Json(name = "type") String type, @Json(name = "shared_link") String sharedLink, @Json(name = "target") InboxNotificationTargetItemDTO target, @Json(name = "sent_by") InboxNotificationUserDTO sentBy) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sharedLink, "sharedLink");
        Intrinsics.checkNotNullParameter(target, "target");
        return new SendSharedLinkPayloadDTOInbox(type, sharedLink, target, sentBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendSharedLinkPayloadDTOInbox)) {
            return false;
        }
        SendSharedLinkPayloadDTOInbox sendSharedLinkPayloadDTOInbox = (SendSharedLinkPayloadDTOInbox) other;
        return Intrinsics.areEqual(this.type, sendSharedLinkPayloadDTOInbox.type) && Intrinsics.areEqual(this.sharedLink, sendSharedLinkPayloadDTOInbox.sharedLink) && Intrinsics.areEqual(this.target, sendSharedLinkPayloadDTOInbox.target) && Intrinsics.areEqual(this.sentBy, sendSharedLinkPayloadDTOInbox.sentBy);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.sharedLink.hashCode()) * 31) + this.target.hashCode()) * 31;
        InboxNotificationUserDTO inboxNotificationUserDTO = this.sentBy;
        return iHashCode + (inboxNotificationUserDTO == null ? 0 : inboxNotificationUserDTO.hashCode());
    }

    public String toString() {
        return "SendSharedLinkPayloadDTOInbox(type=" + this.type + ", sharedLink=" + this.sharedLink + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendSharedLinkPayloadDTOInbox(@Json(name = "type") String type, @Json(name = "shared_link") String sharedLink, @Json(name = "target") InboxNotificationTargetItemDTO target, @Json(name = "sent_by") InboxNotificationUserDTO inboxNotificationUserDTO) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sharedLink, "sharedLink");
        Intrinsics.checkNotNullParameter(target, "target");
        this.type = type;
        this.sharedLink = sharedLink;
        this.target = target;
        this.sentBy = inboxNotificationUserDTO;
    }

    @Override // com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadDTO
    public String getType() {
        return this.type;
    }

    public final String getSharedLink() {
        return this.sharedLink;
    }

    public final InboxNotificationTargetItemDTO getTarget() {
        return this.target;
    }

    public final InboxNotificationUserDTO getSentBy() {
        return this.sentBy;
    }
}
