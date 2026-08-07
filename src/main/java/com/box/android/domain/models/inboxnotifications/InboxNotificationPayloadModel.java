package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "Lcom/box/android/domain/models/DomainModel;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "SendSharedLinkPayloadInboxModel", "CollabInvitePayloadInboxModel", "AtMentionPayloadInboxModel", "NotifyCollabPayloadInboxModel", "TaskUpdatedPayloadInboxModel", "TaskUpdatedPayloadInboxStatus", "CommentPayloadInboxModel", "EditFilePayloadInboxModel", "CommonPayloadInboxModel", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$AtMentionPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CollabInvitePayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommentPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$EditFilePayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$NotifyCollabPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$SendSharedLinkPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class InboxNotificationPayloadModel implements DomainModel {
    public /* synthetic */ InboxNotificationPayloadModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getType();

    private InboxNotificationPayloadModel() {
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$SendSharedLinkPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "sentBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getType", "()Ljava/lang/String;", "getSharedLink", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "getSentBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SendSharedLinkPayloadInboxModel extends InboxNotificationPayloadModel {
        private final InboxNotificationUserModel sentBy;
        private final String sharedLink;
        private final InboxNotificationTargetItemModel target;
        private final String type;

        public static /* synthetic */ SendSharedLinkPayloadInboxModel copy$default(SendSharedLinkPayloadInboxModel sendSharedLinkPayloadInboxModel, String str, String str2, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sendSharedLinkPayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                str2 = sendSharedLinkPayloadInboxModel.sharedLink;
            }
            if ((i & 4) != 0) {
                inboxNotificationTargetItemModel = sendSharedLinkPayloadInboxModel.target;
            }
            if ((i & 8) != 0) {
                inboxNotificationUserModel = sendSharedLinkPayloadInboxModel.sentBy;
            }
            return sendSharedLinkPayloadInboxModel.copy(str, str2, inboxNotificationTargetItemModel, inboxNotificationUserModel);
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
        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }

        public final SendSharedLinkPayloadInboxModel copy(String type, String sharedLink, InboxNotificationTargetItemModel target, InboxNotificationUserModel sentBy) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(sharedLink, "sharedLink");
            Intrinsics.checkNotNullParameter(target, "target");
            return new SendSharedLinkPayloadInboxModel(type, sharedLink, target, sentBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendSharedLinkPayloadInboxModel)) {
                return false;
            }
            SendSharedLinkPayloadInboxModel sendSharedLinkPayloadInboxModel = (SendSharedLinkPayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, sendSharedLinkPayloadInboxModel.type) && Intrinsics.areEqual(this.sharedLink, sendSharedLinkPayloadInboxModel.sharedLink) && Intrinsics.areEqual(this.target, sendSharedLinkPayloadInboxModel.target) && Intrinsics.areEqual(this.sentBy, sendSharedLinkPayloadInboxModel.sentBy);
        }

        public int hashCode() {
            int iHashCode = ((((this.type.hashCode() * 31) + this.sharedLink.hashCode()) * 31) + this.target.hashCode()) * 31;
            InboxNotificationUserModel inboxNotificationUserModel = this.sentBy;
            return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
        }

        public String toString() {
            return "SendSharedLinkPayloadInboxModel(type=" + this.type + ", sharedLink=" + this.sharedLink + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendSharedLinkPayloadInboxModel(String type, String sharedLink, InboxNotificationTargetItemModel target, InboxNotificationUserModel inboxNotificationUserModel) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(sharedLink, "sharedLink");
            Intrinsics.checkNotNullParameter(target, "target");
            this.type = type;
            this.sharedLink = sharedLink;
            this.target = target;
            this.sentBy = inboxNotificationUserModel;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final String getSharedLink() {
            return this.sharedLink;
        }

        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CollabInvitePayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "collab", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationModel;", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "invitedBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getType", "()Ljava/lang/String;", "getCollab", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationModel;", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "getInvitedBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CollabInvitePayloadInboxModel extends InboxNotificationPayloadModel {
        private final InboxNotificationCollaborationModel collab;
        private final InboxNotificationUserModel invitedBy;
        private final InboxNotificationTargetItemModel target;
        private final String type;

        public static /* synthetic */ CollabInvitePayloadInboxModel copy$default(CollabInvitePayloadInboxModel collabInvitePayloadInboxModel, String str, InboxNotificationCollaborationModel inboxNotificationCollaborationModel, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = collabInvitePayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                inboxNotificationCollaborationModel = collabInvitePayloadInboxModel.collab;
            }
            if ((i & 4) != 0) {
                inboxNotificationTargetItemModel = collabInvitePayloadInboxModel.target;
            }
            if ((i & 8) != 0) {
                inboxNotificationUserModel = collabInvitePayloadInboxModel.invitedBy;
            }
            return collabInvitePayloadInboxModel.copy(str, inboxNotificationCollaborationModel, inboxNotificationTargetItemModel, inboxNotificationUserModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxNotificationCollaborationModel getCollab() {
            return this.collab;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final InboxNotificationUserModel getInvitedBy() {
            return this.invitedBy;
        }

        public final CollabInvitePayloadInboxModel copy(String type, InboxNotificationCollaborationModel collab, InboxNotificationTargetItemModel target, InboxNotificationUserModel invitedBy) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(collab, "collab");
            Intrinsics.checkNotNullParameter(target, "target");
            return new CollabInvitePayloadInboxModel(type, collab, target, invitedBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CollabInvitePayloadInboxModel)) {
                return false;
            }
            CollabInvitePayloadInboxModel collabInvitePayloadInboxModel = (CollabInvitePayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, collabInvitePayloadInboxModel.type) && Intrinsics.areEqual(this.collab, collabInvitePayloadInboxModel.collab) && Intrinsics.areEqual(this.target, collabInvitePayloadInboxModel.target) && Intrinsics.areEqual(this.invitedBy, collabInvitePayloadInboxModel.invitedBy);
        }

        public int hashCode() {
            int iHashCode = ((((this.type.hashCode() * 31) + this.collab.hashCode()) * 31) + this.target.hashCode()) * 31;
            InboxNotificationUserModel inboxNotificationUserModel = this.invitedBy;
            return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
        }

        public String toString() {
            return "CollabInvitePayloadInboxModel(type=" + this.type + ", collab=" + this.collab + ", target=" + this.target + ", invitedBy=" + this.invitedBy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollabInvitePayloadInboxModel(String type, InboxNotificationCollaborationModel collab, InboxNotificationTargetItemModel target, InboxNotificationUserModel inboxNotificationUserModel) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(collab, "collab");
            Intrinsics.checkNotNullParameter(target, "target");
            this.type = type;
            this.collab = collab;
            this.target = target;
            this.invitedBy = inboxNotificationUserModel;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final InboxNotificationCollaborationModel getCollab() {
            return this.collab;
        }

        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        public final InboxNotificationUserModel getInvitedBy() {
            return this.invitedBy;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$AtMentionPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "comment", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "sentBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getType", "()Ljava/lang/String;", "getComment", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "getSentBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AtMentionPayloadInboxModel extends InboxNotificationPayloadModel {
        private final InboxNotificationCommentModel comment;
        private final InboxNotificationUserModel sentBy;
        private final InboxNotificationTargetItemModel target;
        private final String type;

        public static /* synthetic */ AtMentionPayloadInboxModel copy$default(AtMentionPayloadInboxModel atMentionPayloadInboxModel, String str, InboxNotificationCommentModel inboxNotificationCommentModel, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = atMentionPayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                inboxNotificationCommentModel = atMentionPayloadInboxModel.comment;
            }
            if ((i & 4) != 0) {
                inboxNotificationTargetItemModel = atMentionPayloadInboxModel.target;
            }
            if ((i & 8) != 0) {
                inboxNotificationUserModel = atMentionPayloadInboxModel.sentBy;
            }
            return atMentionPayloadInboxModel.copy(str, inboxNotificationCommentModel, inboxNotificationTargetItemModel, inboxNotificationUserModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxNotificationCommentModel getComment() {
            return this.comment;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }

        public final AtMentionPayloadInboxModel copy(String type, InboxNotificationCommentModel comment, InboxNotificationTargetItemModel target, InboxNotificationUserModel sentBy) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(target, "target");
            return new AtMentionPayloadInboxModel(type, comment, target, sentBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AtMentionPayloadInboxModel)) {
                return false;
            }
            AtMentionPayloadInboxModel atMentionPayloadInboxModel = (AtMentionPayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, atMentionPayloadInboxModel.type) && Intrinsics.areEqual(this.comment, atMentionPayloadInboxModel.comment) && Intrinsics.areEqual(this.target, atMentionPayloadInboxModel.target) && Intrinsics.areEqual(this.sentBy, atMentionPayloadInboxModel.sentBy);
        }

        public int hashCode() {
            int iHashCode = ((((this.type.hashCode() * 31) + this.comment.hashCode()) * 31) + this.target.hashCode()) * 31;
            InboxNotificationUserModel inboxNotificationUserModel = this.sentBy;
            return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
        }

        public String toString() {
            return "AtMentionPayloadInboxModel(type=" + this.type + ", comment=" + this.comment + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AtMentionPayloadInboxModel(String type, InboxNotificationCommentModel comment, InboxNotificationTargetItemModel target, InboxNotificationUserModel inboxNotificationUserModel) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(target, "target");
            this.type = type;
            this.comment = comment;
            this.target = target;
            this.sentBy = inboxNotificationUserModel;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final InboxNotificationCommentModel getComment() {
            return this.comment;
        }

        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$NotifyCollabPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "sentBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getType", "()Ljava/lang/String;", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "getSentBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotifyCollabPayloadInboxModel extends InboxNotificationPayloadModel {
        private final InboxNotificationUserModel sentBy;
        private final InboxNotificationTargetItemModel target;
        private final String type;

        public static /* synthetic */ NotifyCollabPayloadInboxModel copy$default(NotifyCollabPayloadInboxModel notifyCollabPayloadInboxModel, String str, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notifyCollabPayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                inboxNotificationTargetItemModel = notifyCollabPayloadInboxModel.target;
            }
            if ((i & 4) != 0) {
                inboxNotificationUserModel = notifyCollabPayloadInboxModel.sentBy;
            }
            return notifyCollabPayloadInboxModel.copy(str, inboxNotificationTargetItemModel, inboxNotificationUserModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }

        public final NotifyCollabPayloadInboxModel copy(String type, InboxNotificationTargetItemModel target, InboxNotificationUserModel sentBy) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(target, "target");
            return new NotifyCollabPayloadInboxModel(type, target, sentBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyCollabPayloadInboxModel)) {
                return false;
            }
            NotifyCollabPayloadInboxModel notifyCollabPayloadInboxModel = (NotifyCollabPayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, notifyCollabPayloadInboxModel.type) && Intrinsics.areEqual(this.target, notifyCollabPayloadInboxModel.target) && Intrinsics.areEqual(this.sentBy, notifyCollabPayloadInboxModel.sentBy);
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.target.hashCode()) * 31;
            InboxNotificationUserModel inboxNotificationUserModel = this.sentBy;
            return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
        }

        public String toString() {
            return "NotifyCollabPayloadInboxModel(type=" + this.type + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyCollabPayloadInboxModel(String type, InboxNotificationTargetItemModel target, InboxNotificationUserModel inboxNotificationUserModel) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(target, "target");
            this.type = type;
            this.target = target;
            this.sentBy = inboxNotificationUserModel;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "task", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTaskModel;", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTaskModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;)V", "getType", "()Ljava/lang/String;", "getTask", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTaskModel;", "getStatus", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskUpdatedPayloadInboxModel extends InboxNotificationPayloadModel {
        private final TaskUpdatedPayloadInboxStatus status;
        private final InboxNotificationTaskModel task;
        private final String type;

        public static /* synthetic */ TaskUpdatedPayloadInboxModel copy$default(TaskUpdatedPayloadInboxModel taskUpdatedPayloadInboxModel, String str, InboxNotificationTaskModel inboxNotificationTaskModel, TaskUpdatedPayloadInboxStatus taskUpdatedPayloadInboxStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskUpdatedPayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                inboxNotificationTaskModel = taskUpdatedPayloadInboxModel.task;
            }
            if ((i & 4) != 0) {
                taskUpdatedPayloadInboxStatus = taskUpdatedPayloadInboxModel.status;
            }
            return taskUpdatedPayloadInboxModel.copy(str, inboxNotificationTaskModel, taskUpdatedPayloadInboxStatus);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxNotificationTaskModel getTask() {
            return this.task;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final TaskUpdatedPayloadInboxStatus getStatus() {
            return this.status;
        }

        public final TaskUpdatedPayloadInboxModel copy(String type, InboxNotificationTaskModel task, TaskUpdatedPayloadInboxStatus status) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(status, "status");
            return new TaskUpdatedPayloadInboxModel(type, task, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskUpdatedPayloadInboxModel)) {
                return false;
            }
            TaskUpdatedPayloadInboxModel taskUpdatedPayloadInboxModel = (TaskUpdatedPayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, taskUpdatedPayloadInboxModel.type) && Intrinsics.areEqual(this.task, taskUpdatedPayloadInboxModel.task) && this.status == taskUpdatedPayloadInboxModel.status;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.task.hashCode()) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "TaskUpdatedPayloadInboxModel(type=" + this.type + ", task=" + this.task + ", status=" + this.status + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskUpdatedPayloadInboxModel(String type, InboxNotificationTaskModel task, TaskUpdatedPayloadInboxStatus status) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(status, "status");
            this.type = type;
            this.task = task;
            this.status = status;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final InboxNotificationTaskModel getTask() {
            return this.task;
        }

        public final TaskUpdatedPayloadInboxStatus getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;", "", "jsonValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "APPROVED", "REJECTED", "COMPLETED", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum TaskUpdatedPayloadInboxStatus {
        APPROVED("APPROVED"),
        REJECTED("REJECTED"),
        COMPLETED("COMPLETED");

        private final String jsonValue;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<TaskUpdatedPayloadInboxStatus> getEntries() {
            return $ENTRIES;
        }

        TaskUpdatedPayloadInboxStatus(String str) {
            this.jsonValue = str;
        }

        public final String getJsonValue() {
            return this.jsonValue;
        }

        /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus$Companion;", "", "<init>", "()V", "byName", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;", "input", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TaskUpdatedPayloadInboxStatus byName(String input) {
                Intrinsics.checkNotNullParameter(input, "input");
                for (TaskUpdatedPayloadInboxStatus taskUpdatedPayloadInboxStatus : TaskUpdatedPayloadInboxStatus.getEntries()) {
                    if (StringsKt.equals(taskUpdatedPayloadInboxStatus.name(), input, true)) {
                        return taskUpdatedPayloadInboxStatus;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommentPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "comment", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "sentBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getType", "()Ljava/lang/String;", "getComment", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "getSentBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommentPayloadInboxModel extends InboxNotificationPayloadModel {
        private final InboxNotificationCommentModel comment;
        private final InboxNotificationUserModel sentBy;
        private final InboxNotificationTargetItemModel target;
        private final String type;

        public static /* synthetic */ CommentPayloadInboxModel copy$default(CommentPayloadInboxModel commentPayloadInboxModel, String str, InboxNotificationCommentModel inboxNotificationCommentModel, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = commentPayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                inboxNotificationCommentModel = commentPayloadInboxModel.comment;
            }
            if ((i & 4) != 0) {
                inboxNotificationTargetItemModel = commentPayloadInboxModel.target;
            }
            if ((i & 8) != 0) {
                inboxNotificationUserModel = commentPayloadInboxModel.sentBy;
            }
            return commentPayloadInboxModel.copy(str, inboxNotificationCommentModel, inboxNotificationTargetItemModel, inboxNotificationUserModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxNotificationCommentModel getComment() {
            return this.comment;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }

        public final CommentPayloadInboxModel copy(String type, InboxNotificationCommentModel comment, InboxNotificationTargetItemModel target, InboxNotificationUserModel sentBy) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(target, "target");
            return new CommentPayloadInboxModel(type, comment, target, sentBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentPayloadInboxModel)) {
                return false;
            }
            CommentPayloadInboxModel commentPayloadInboxModel = (CommentPayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, commentPayloadInboxModel.type) && Intrinsics.areEqual(this.comment, commentPayloadInboxModel.comment) && Intrinsics.areEqual(this.target, commentPayloadInboxModel.target) && Intrinsics.areEqual(this.sentBy, commentPayloadInboxModel.sentBy);
        }

        public int hashCode() {
            int iHashCode = ((((this.type.hashCode() * 31) + this.comment.hashCode()) * 31) + this.target.hashCode()) * 31;
            InboxNotificationUserModel inboxNotificationUserModel = this.sentBy;
            return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
        }

        public String toString() {
            return "CommentPayloadInboxModel(type=" + this.type + ", comment=" + this.comment + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentPayloadInboxModel(String type, InboxNotificationCommentModel comment, InboxNotificationTargetItemModel target, InboxNotificationUserModel inboxNotificationUserModel) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(target, "target");
            this.type = type;
            this.comment = comment;
            this.target = target;
            this.sentBy = inboxNotificationUserModel;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final InboxNotificationCommentModel getComment() {
            return this.comment;
        }

        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$EditFilePayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "sentBy", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getType", "()Ljava/lang/String;", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "getSentBy", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditFilePayloadInboxModel extends InboxNotificationPayloadModel {
        private final InboxNotificationUserModel sentBy;
        private final InboxNotificationTargetItemModel target;
        private final String type;

        public static /* synthetic */ EditFilePayloadInboxModel copy$default(EditFilePayloadInboxModel editFilePayloadInboxModel, String str, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = editFilePayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                inboxNotificationTargetItemModel = editFilePayloadInboxModel.target;
            }
            if ((i & 4) != 0) {
                inboxNotificationUserModel = editFilePayloadInboxModel.sentBy;
            }
            return editFilePayloadInboxModel.copy(str, inboxNotificationTargetItemModel, inboxNotificationUserModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }

        public final EditFilePayloadInboxModel copy(String type, InboxNotificationTargetItemModel target, InboxNotificationUserModel sentBy) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(target, "target");
            return new EditFilePayloadInboxModel(type, target, sentBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditFilePayloadInboxModel)) {
                return false;
            }
            EditFilePayloadInboxModel editFilePayloadInboxModel = (EditFilePayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, editFilePayloadInboxModel.type) && Intrinsics.areEqual(this.target, editFilePayloadInboxModel.target) && Intrinsics.areEqual(this.sentBy, editFilePayloadInboxModel.sentBy);
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.target.hashCode()) * 31;
            InboxNotificationUserModel inboxNotificationUserModel = this.sentBy;
            return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
        }

        public String toString() {
            return "EditFilePayloadInboxModel(type=" + this.type + ", target=" + this.target + ", sentBy=" + this.sentBy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EditFilePayloadInboxModel(String type, InboxNotificationTargetItemModel target, InboxNotificationUserModel inboxNotificationUserModel) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(target, "target");
            this.type = type;
            this.target = target;
            this.sentBy = inboxNotificationUserModel;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final InboxNotificationTargetItemModel getTarget() {
            return this.target;
        }

        public final InboxNotificationUserModel getSentBy() {
            return this.sentBy;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0003J\u0099\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$¨\u0006>"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "type", "", "mainIcon", "Lcom/box/android/domain/models/inboxnotifications/AvatarModel;", "subIcon", "Lcom/box/android/domain/models/inboxnotifications/IconModel;", "title", "Lcom/box/android/domain/models/inboxnotifications/TextModel;", "message", "status", "Lcom/box/android/domain/models/inboxnotifications/StatusModel;", "timestamp", "statusIcons", "", "cardAction", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "primaryAction", "secondaryAction", "menuActions", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/AvatarModel;Lcom/box/android/domain/models/inboxnotifications/IconModel;Lcom/box/android/domain/models/inboxnotifications/TextModel;Lcom/box/android/domain/models/inboxnotifications/TextModel;Lcom/box/android/domain/models/inboxnotifications/StatusModel;Ljava/lang/String;Ljava/util/List;Lcom/box/android/domain/models/inboxnotifications/ActionModel;Lcom/box/android/domain/models/inboxnotifications/ActionModel;Lcom/box/android/domain/models/inboxnotifications/ActionModel;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getMainIcon", "()Lcom/box/android/domain/models/inboxnotifications/AvatarModel;", "getSubIcon", "()Lcom/box/android/domain/models/inboxnotifications/IconModel;", "getTitle", "()Lcom/box/android/domain/models/inboxnotifications/TextModel;", "getMessage", "getStatus", "()Lcom/box/android/domain/models/inboxnotifications/StatusModel;", "getTimestamp", "getStatusIcons", "()Ljava/util/List;", "getCardAction", "()Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "getPrimaryAction", "getSecondaryAction", "getMenuActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommonPayloadInboxModel extends InboxNotificationPayloadModel {
        private final ActionModel cardAction;
        private final AvatarModel mainIcon;
        private final List<ActionModel> menuActions;
        private final TextModel message;
        private final ActionModel primaryAction;
        private final ActionModel secondaryAction;
        private final StatusModel status;
        private final List<IconModel> statusIcons;
        private final IconModel subIcon;
        private final String timestamp;
        private final TextModel title;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CommonPayloadInboxModel copy$default(CommonPayloadInboxModel commonPayloadInboxModel, String str, AvatarModel avatarModel, IconModel iconModel, TextModel textModel, TextModel textModel2, StatusModel statusModel, String str2, List list, ActionModel actionModel, ActionModel actionModel2, ActionModel actionModel3, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = commonPayloadInboxModel.type;
            }
            if ((i & 2) != 0) {
                avatarModel = commonPayloadInboxModel.mainIcon;
            }
            if ((i & 4) != 0) {
                iconModel = commonPayloadInboxModel.subIcon;
            }
            if ((i & 8) != 0) {
                textModel = commonPayloadInboxModel.title;
            }
            if ((i & 16) != 0) {
                textModel2 = commonPayloadInboxModel.message;
            }
            if ((i & 32) != 0) {
                statusModel = commonPayloadInboxModel.status;
            }
            if ((i & 64) != 0) {
                str2 = commonPayloadInboxModel.timestamp;
            }
            if ((i & 128) != 0) {
                list = commonPayloadInboxModel.statusIcons;
            }
            if ((i & 256) != 0) {
                actionModel = commonPayloadInboxModel.cardAction;
            }
            if ((i & 512) != 0) {
                actionModel2 = commonPayloadInboxModel.primaryAction;
            }
            if ((i & 1024) != 0) {
                actionModel3 = commonPayloadInboxModel.secondaryAction;
            }
            if ((i & 2048) != 0) {
                list2 = commonPayloadInboxModel.menuActions;
            }
            ActionModel actionModel4 = actionModel3;
            List list3 = list2;
            ActionModel actionModel5 = actionModel;
            ActionModel actionModel6 = actionModel2;
            String str3 = str2;
            List list4 = list;
            TextModel textModel3 = textModel2;
            StatusModel statusModel2 = statusModel;
            return commonPayloadInboxModel.copy(str, avatarModel, iconModel, textModel, textModel3, statusModel2, str3, list4, actionModel5, actionModel6, actionModel4, list3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final ActionModel getPrimaryAction() {
            return this.primaryAction;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final ActionModel getSecondaryAction() {
            return this.secondaryAction;
        }

        public final List<ActionModel> component12() {
            return this.menuActions;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AvatarModel getMainIcon() {
            return this.mainIcon;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final IconModel getSubIcon() {
            return this.subIcon;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final TextModel getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final TextModel getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final StatusModel getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        public final List<IconModel> component8() {
            return this.statusIcons;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final ActionModel getCardAction() {
            return this.cardAction;
        }

        public final CommonPayloadInboxModel copy(String type, AvatarModel mainIcon, IconModel subIcon, TextModel title, TextModel message, StatusModel status, String timestamp, List<IconModel> statusIcons, ActionModel cardAction, ActionModel primaryAction, ActionModel secondaryAction, List<ActionModel> menuActions) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mainIcon, "mainIcon");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(statusIcons, "statusIcons");
            Intrinsics.checkNotNullParameter(menuActions, "menuActions");
            return new CommonPayloadInboxModel(type, mainIcon, subIcon, title, message, status, timestamp, statusIcons, cardAction, primaryAction, secondaryAction, menuActions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommonPayloadInboxModel)) {
                return false;
            }
            CommonPayloadInboxModel commonPayloadInboxModel = (CommonPayloadInboxModel) other;
            return Intrinsics.areEqual(this.type, commonPayloadInboxModel.type) && Intrinsics.areEqual(this.mainIcon, commonPayloadInboxModel.mainIcon) && Intrinsics.areEqual(this.subIcon, commonPayloadInboxModel.subIcon) && Intrinsics.areEqual(this.title, commonPayloadInboxModel.title) && Intrinsics.areEqual(this.message, commonPayloadInboxModel.message) && Intrinsics.areEqual(this.status, commonPayloadInboxModel.status) && Intrinsics.areEqual(this.timestamp, commonPayloadInboxModel.timestamp) && Intrinsics.areEqual(this.statusIcons, commonPayloadInboxModel.statusIcons) && Intrinsics.areEqual(this.cardAction, commonPayloadInboxModel.cardAction) && Intrinsics.areEqual(this.primaryAction, commonPayloadInboxModel.primaryAction) && Intrinsics.areEqual(this.secondaryAction, commonPayloadInboxModel.secondaryAction) && Intrinsics.areEqual(this.menuActions, commonPayloadInboxModel.menuActions);
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.mainIcon.hashCode()) * 31;
            IconModel iconModel = this.subIcon;
            int iHashCode2 = (((iHashCode + (iconModel == null ? 0 : iconModel.hashCode())) * 31) + this.title.hashCode()) * 31;
            TextModel textModel = this.message;
            int iHashCode3 = (iHashCode2 + (textModel == null ? 0 : textModel.hashCode())) * 31;
            StatusModel statusModel = this.status;
            int iHashCode4 = (((((iHashCode3 + (statusModel == null ? 0 : statusModel.hashCode())) * 31) + this.timestamp.hashCode()) * 31) + this.statusIcons.hashCode()) * 31;
            ActionModel actionModel = this.cardAction;
            int iHashCode5 = (iHashCode4 + (actionModel == null ? 0 : actionModel.hashCode())) * 31;
            ActionModel actionModel2 = this.primaryAction;
            int iHashCode6 = (iHashCode5 + (actionModel2 == null ? 0 : actionModel2.hashCode())) * 31;
            ActionModel actionModel3 = this.secondaryAction;
            return ((iHashCode6 + (actionModel3 != null ? actionModel3.hashCode() : 0)) * 31) + this.menuActions.hashCode();
        }

        public String toString() {
            return "CommonPayloadInboxModel(type=" + this.type + ", mainIcon=" + this.mainIcon + ", subIcon=" + this.subIcon + ", title=" + this.title + ", message=" + this.message + ", status=" + this.status + ", timestamp=" + this.timestamp + ", statusIcons=" + this.statusIcons + ", cardAction=" + this.cardAction + ", primaryAction=" + this.primaryAction + ", secondaryAction=" + this.secondaryAction + ", menuActions=" + this.menuActions + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommonPayloadInboxModel(String type, AvatarModel mainIcon, IconModel iconModel, TextModel title, TextModel textModel, StatusModel statusModel, String timestamp, List<IconModel> statusIcons, ActionModel actionModel, ActionModel actionModel2, ActionModel actionModel3, List<ActionModel> menuActions) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mainIcon, "mainIcon");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(statusIcons, "statusIcons");
            Intrinsics.checkNotNullParameter(menuActions, "menuActions");
            this.type = type;
            this.mainIcon = mainIcon;
            this.subIcon = iconModel;
            this.title = title;
            this.message = textModel;
            this.status = statusModel;
            this.timestamp = timestamp;
            this.statusIcons = statusIcons;
            this.cardAction = actionModel;
            this.primaryAction = actionModel2;
            this.secondaryAction = actionModel3;
            this.menuActions = menuActions;
        }

        @Override // com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel
        public String getType() {
            return this.type;
        }

        public final AvatarModel getMainIcon() {
            return this.mainIcon;
        }

        public final IconModel getSubIcon() {
            return this.subIcon;
        }

        public final TextModel getTitle() {
            return this.title;
        }

        public final TextModel getMessage() {
            return this.message;
        }

        public final StatusModel getStatus() {
            return this.status;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final List<IconModel> getStatusIcons() {
            return this.statusIcons;
        }

        public final ActionModel getCardAction() {
            return this.cardAction;
        }

        public final ActionModel getPrimaryAction() {
            return this.primaryAction;
        }

        public final ActionModel getSecondaryAction() {
            return this.secondaryAction;
        }

        public final List<ActionModel> getMenuActions() {
            return this.menuActions;
        }
    }
}
