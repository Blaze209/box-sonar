package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCommentModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", "message", "isReplyComment", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "getMessage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationCommentModel implements DomainModel {
    private final String id;
    private final Boolean isReplyComment;
    private final String message;
    private final String type;

    public static /* synthetic */ InboxNotificationCommentModel copy$default(InboxNotificationCommentModel inboxNotificationCommentModel, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationCommentModel.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationCommentModel.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationCommentModel.message;
        }
        if ((i & 8) != 0) {
            bool = inboxNotificationCommentModel.isReplyComment;
        }
        return inboxNotificationCommentModel.copy(str, str2, str3, bool);
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

    public final InboxNotificationCommentModel copy(String id, String type, String message, Boolean isReplyComment) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        return new InboxNotificationCommentModel(id, type, message, isReplyComment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationCommentModel)) {
            return false;
        }
        InboxNotificationCommentModel inboxNotificationCommentModel = (InboxNotificationCommentModel) other;
        return Intrinsics.areEqual(this.id, inboxNotificationCommentModel.id) && Intrinsics.areEqual(this.type, inboxNotificationCommentModel.type) && Intrinsics.areEqual(this.message, inboxNotificationCommentModel.message) && Intrinsics.areEqual(this.isReplyComment, inboxNotificationCommentModel.isReplyComment);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.message.hashCode()) * 31;
        Boolean bool = this.isReplyComment;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "InboxNotificationCommentModel(id=" + this.id + ", type=" + this.type + ", message=" + this.message + ", isReplyComment=" + this.isReplyComment + ")";
    }

    public InboxNotificationCommentModel(String id, String type, String message, Boolean bool) {
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
