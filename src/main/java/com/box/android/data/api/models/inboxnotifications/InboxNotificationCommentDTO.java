package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxComment;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCommentDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCommentDTO;", "", "id", "", "type", "message", "isReplyComment", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "getMessage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCommentDTO;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationCommentDTO {
    private final String id;
    private final Boolean isReplyComment;
    private final String message;
    private final String type;

    public static /* synthetic */ InboxNotificationCommentDTO copy$default(InboxNotificationCommentDTO inboxNotificationCommentDTO, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationCommentDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationCommentDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationCommentDTO.message;
        }
        if ((i & 8) != 0) {
            bool = inboxNotificationCommentDTO.isReplyComment;
        }
        return inboxNotificationCommentDTO.copy(str, str2, str3, bool);
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
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsReplyComment() {
        return this.isReplyComment;
    }

    public final InboxNotificationCommentDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "message") String message, @Json(name = BoxComment.FIELD_IS_REPLY_COMMENT) Boolean isReplyComment) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        return new InboxNotificationCommentDTO(id, type, message, isReplyComment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationCommentDTO)) {
            return false;
        }
        InboxNotificationCommentDTO inboxNotificationCommentDTO = (InboxNotificationCommentDTO) other;
        return Intrinsics.areEqual(this.id, inboxNotificationCommentDTO.id) && Intrinsics.areEqual(this.type, inboxNotificationCommentDTO.type) && Intrinsics.areEqual(this.message, inboxNotificationCommentDTO.message) && Intrinsics.areEqual(this.isReplyComment, inboxNotificationCommentDTO.isReplyComment);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.message.hashCode()) * 31;
        Boolean bool = this.isReplyComment;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "InboxNotificationCommentDTO(id=" + this.id + ", type=" + this.type + ", message=" + this.message + ", isReplyComment=" + this.isReplyComment + ")";
    }

    public InboxNotificationCommentDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "message") String message, @Json(name = BoxComment.FIELD_IS_REPLY_COMMENT) Boolean bool) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        this.id = id;
        this.type = type;
        this.message = message;
        this.isReplyComment = bool;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Boolean isReplyComment() {
        return this.isReplyComment;
    }
}
