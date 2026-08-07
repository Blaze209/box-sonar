package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/AtMentionPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "type", "", "comment", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCommentDTO;", "target", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "sentBy", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCommentDTO;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;)V", "getType", "()Ljava/lang/String;", "getComment", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCommentDTO;", "getTarget", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "getSentBy", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AtMentionPayloadDTOInbox extends InboxNotificationPayloadDTO {
    private final InboxNotificationCommentDTO comment;
    private final InboxNotificationUserDTO sentBy;
    private final InboxNotificationTargetItemDTO target;
    private final String type;

    public static /* synthetic */ AtMentionPayloadDTOInbox copy$default(AtMentionPayloadDTOInbox atMentionPayloadDTOInbox, String str, InboxNotificationCommentDTO inboxNotificationCommentDTO, InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO, InboxNotificationUserDTO inboxNotificationUserDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = atMentionPayloadDTOInbox.type;
        }
        if ((i & 2) != 0) {
            inboxNotificationCommentDTO = atMentionPayloadDTOInbox.comment;
        }
        if ((i & 4) != 0) {
            inboxNotificationTargetItemDTO = atMentionPayloadDTOInbox.target;
        }
        if ((i & 8) != 0) {
            inboxNotificationUserDTO = atMentionPayloadDTOInbox.sentBy;
        }
        return atMentionPayloadDTOInbox.copy(str, inboxNotificationCommentDTO, inboxNotificationTargetItemDTO, inboxNotificationUserDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InboxNotificationCommentDTO getComment() {
        return this.comment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InboxNotificationTargetItemDTO getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InboxNotificationUserDTO getSentBy() {
        return this.sentBy;
    }

    public final AtMentionPayloadDTOInbox copy(@Json(name = "type") String type, @Json(name = "comment") InboxNotificationCommentDTO comment, @Json(name = "target") InboxNotificationTargetItemDTO target, @Json(name = "sent_by") InboxNotificationUserDTO sentBy) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(target, "target");
        return new AtMentionPayloadDTOInbox(type, comment, target, sentBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AtMentionPayloadDTOInbox)) {
            return false;
        }
        AtMentionPayloadDTOInbox atMentionPayloadDTOInbox = (AtMentionPayloadDTOInbox) other;
        return Intrinsics.areEqual(this.type, atMentionPayloadDTOInbox.type) && Intrinsics.areEqual(this.comment, atMentionPayloadDTOInbox.comment) && Intrinsics.areEqual(this.target, atMentionPayloadDTOInbox.target) && Intrinsics.areEqual(this.sentBy, atMentionPayloadDTOInbox.sentBy);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.comment.hashCode()) * 31) + this.target.hashCode()) * 31;
        InboxNotificationUserDTO inboxNotificationUserDTO = this.sentBy;
        return iHashCode + (inboxNotificationUserDTO == null ? 0 : inboxNotificationUserDTO.hashCode());
    }

    public String toString() {
        return "AtMentionPayloadDTOInbox(type=" + this.type + ", comment=" + this.comment + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtMentionPayloadDTOInbox(@Json(name = "type") String type, @Json(name = "comment") InboxNotificationCommentDTO comment, @Json(name = "target") InboxNotificationTargetItemDTO target, @Json(name = "sent_by") InboxNotificationUserDTO inboxNotificationUserDTO) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(target, "target");
        this.type = type;
        this.comment = comment;
        this.target = target;
        this.sentBy = inboxNotificationUserDTO;
    }

    @Override // com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadDTO
    public String getType() {
        return this.type;
    }

    public final InboxNotificationCommentDTO getComment() {
        return this.comment;
    }

    public final InboxNotificationTargetItemDTO getTarget() {
        return this.target;
    }

    public final InboxNotificationUserDTO getSentBy() {
        return this.sentBy;
    }
}
