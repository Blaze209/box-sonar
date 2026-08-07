package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentContent.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/annotations/CommentContent;", "Lcom/box/android/domain/models/DomainModel;", "<init>", "()V", AuthenticationConstants.BUNDLE_MESSAGE, "TaggedMessage", "Lcom/box/android/domain/models/annotations/CommentContent$Message;", "Lcom/box/android/domain/models/annotations/CommentContent$TaggedMessage;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CommentContent implements DomainModel {
    public /* synthetic */ CommentContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CommentContent() {
    }

    /* JADX INFO: compiled from: CommentContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/annotations/CommentContent$Message;", "Lcom/box/android/domain/models/annotations/CommentContent;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Message extends CommentContent {
        private final String message;

        public static /* synthetic */ Message copy$default(Message message, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = message.message;
            }
            return message.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Message copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Message(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Message) && Intrinsics.areEqual(this.message, ((Message) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Message(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Message(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: CommentContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/annotations/CommentContent$TaggedMessage;", "Lcom/box/android/domain/models/annotations/CommentContent;", "taggedMessage", "", "<init>", "(Ljava/lang/String;)V", "getTaggedMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaggedMessage extends CommentContent {
        private final String taggedMessage;

        public static /* synthetic */ TaggedMessage copy$default(TaggedMessage taggedMessage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taggedMessage.taggedMessage;
            }
            return taggedMessage.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTaggedMessage() {
            return this.taggedMessage;
        }

        public final TaggedMessage copy(String taggedMessage) {
            Intrinsics.checkNotNullParameter(taggedMessage, "taggedMessage");
            return new TaggedMessage(taggedMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TaggedMessage) && Intrinsics.areEqual(this.taggedMessage, ((TaggedMessage) other).taggedMessage);
        }

        public int hashCode() {
            return this.taggedMessage.hashCode();
        }

        public String toString() {
            return "TaggedMessage(taggedMessage=" + this.taggedMessage + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaggedMessage(String taggedMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(taggedMessage, "taggedMessage");
            this.taggedMessage = taggedMessage;
        }

        public final String getTaggedMessage() {
            return this.taggedMessage;
        }
    }
}
