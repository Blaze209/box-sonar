package com.box.android.utilities;

import com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType;
import com.box.android.domain.models.inboxnotifications.AcceptanceRequirementsStatusModel;
import com.box.android.domain.models.inboxnotifications.ActionHandlerModel;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.ActionStyleLevel;
import com.box.android.domain.models.inboxnotifications.AvatarModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationTargetItemModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import com.box.android.domain.models.inboxnotifications.TextAtomModel;
import com.box.android.domain.models.inboxnotifications.TextModel;
import com.box.android.inbox.notifications.router.IInboxRouter;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.pspdfkit.analytics.Analytics;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewModels.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/box/android/utilities/PreviewModels;", "", "<init>", "()V", "Inbox", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewModels {
    public static final int $stable = 0;
    public static final PreviewModels INSTANCE = new PreviewModels();

    /* JADX INFO: compiled from: PreviewModels.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0002J6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u001a\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001c\u001a\u00020\u0016R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/box/android/utilities/PreviewModels$Inbox;", "", "<init>", "()V", "createMockUser", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "id", "", "name", "createMockAvatar", "Lcom/box/android/domain/models/inboxnotifications/AvatarModel;", "createMockTextModel", "Lcom/box/android/domain/models/inboxnotifications/TextModel;", "text", "fontWeight", "createMockActionModel", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "actionId", "value", "styleLevel", "Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;", "focus", "", "handlerType", "createMockTargetItem", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "createMockAcceptanceRequirements", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementsStatusModel;", "withRequirements", "createMockCollab", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationModel;", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "createMockInviteCollabPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CollabInvitePayloadInboxModel;", "MOCK_COMMON_PAYLOAD", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "getMOCK_COMMON_PAYLOAD", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "MOCK_NOTIFICATION", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "getMOCK_NOTIFICATION", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "mockRouter", "Lcom/box/android/inbox/notifications/router/IInboxRouter;", "getMockRouter", "()Lcom/box/android/inbox/notifications/router/IInboxRouter;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Inbox {
        public static final int $stable;
        public static final Inbox INSTANCE;
        private static final InboxNotificationPayloadModel.CommonPayloadInboxModel MOCK_COMMON_PAYLOAD;
        private static final InboxNotificationModel MOCK_NOTIFICATION;
        private static final IInboxRouter mockRouter;

        private Inbox() {
        }

        private final InboxNotificationUserModel createMockUser(String id, String name) {
            return new InboxNotificationUserModel(id, "user", name, false);
        }

        private final AvatarModel createMockAvatar() {
            return new AvatarModel("user_123", "JS", "John Smith", "user");
        }

        private final TextModel createMockTextModel(String text, String fontWeight) {
            return new TextModel("text", CollectionsKt.listOf(new TextAtomModel("text", text, fontWeight, null, null)));
        }

        static /* synthetic */ TextModel createMockTextModel$default(Inbox inbox, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL;
            }
            return inbox.createMockTextModel(str, str2);
        }

        static /* synthetic */ ActionModel createMockActionModel$default(Inbox inbox, String str, String str2, ActionStyleLevel actionStyleLevel, boolean z, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                actionStyleLevel = ActionStyleLevel.DEFAULT;
            }
            ActionStyleLevel actionStyleLevel2 = actionStyleLevel;
            if ((i & 8) != 0) {
                z = false;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                str3 = "post-action-handler";
            }
            return inbox.createMockActionModel(str, str2, actionStyleLevel2, z2, str3);
        }

        private final ActionModel createMockActionModel(String actionId, String value, ActionStyleLevel styleLevel, boolean focus, String handlerType) {
            return new ActionModel(Analytics.Data.ACTION, focus, null, value, styleLevel, new ActionHandlerModel(handlerType, null, actionId, null, null, null));
        }

        private final InboxNotificationTargetItemModel createMockTargetItem() {
            return new InboxNotificationTargetItemModel("item_123", "file", "Sample Document.docx", true, true);
        }

        private final AcceptanceRequirementsStatusModel createMockAcceptanceRequirements(boolean withRequirements) {
            return new AcceptanceRequirementsStatusModel(new AcceptanceRequirementType.TermsOfService(Boolean.valueOf(!withRequirements), null), new AcceptanceRequirementType.StrongPassword(Boolean.valueOf(withRequirements), Boolean.valueOf(!withRequirements)), new AcceptanceRequirementType.MFA(false, true));
        }

        private final InboxNotificationCollaborationModel createMockCollab(InboxNotificationCollaborationStatus status, boolean withRequirements) {
            return new InboxNotificationCollaborationModel("collab_123", BoxCollaboration.TYPE, "editor", status, createMockUser("user_789", "Admin User"), createMockAcceptanceRequirements(withRequirements));
        }

        public static /* synthetic */ InboxNotificationPayloadModel.CollabInvitePayloadInboxModel createMockInviteCollabPayload$default(Inbox inbox, InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                inboxNotificationCollaborationStatus = InboxNotificationCollaborationStatus.PENDING;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return inbox.createMockInviteCollabPayload(inboxNotificationCollaborationStatus, z);
        }

        public final InboxNotificationPayloadModel.CollabInvitePayloadInboxModel createMockInviteCollabPayload(InboxNotificationCollaborationStatus status, boolean withRequirements) {
            Intrinsics.checkNotNullParameter(status, "status");
            return new InboxNotificationPayloadModel.CollabInvitePayloadInboxModel("collabInvite", createMockCollab(status, withRequirements), createMockTargetItem(), createMockUser("user_123", "John Doe"));
        }

        static {
            Inbox inbox = new Inbox();
            INSTANCE = inbox;
            InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = new InboxNotificationPayloadModel.CommonPayloadInboxModel("common", inbox.createMockAvatar(), null, inbox.createMockTextModel("Document shared", "bold"), null, null, "2024-01-15T10:30:00Z", CollectionsKt.emptyList(), null, null, null, CollectionsKt.listOf((Object[]) new ActionModel[]{createMockActionModel$default(inbox, SemanticAttributes.FaasDocumentOperationValues.EDIT, "Edit", null, false, null, 28, null), createMockActionModel$default(inbox, "delete", "Delete", null, false, null, 28, null)}));
            MOCK_COMMON_PAYLOAD = commonPayloadInboxModel;
            MOCK_NOTIFICATION = new InboxNotificationModel("notification_1", "notification", "2024-01-15T10:30:00Z", true, false, commonPayloadInboxModel, inbox.createMockUser("user_123", "John Doe"), inbox.createMockUser("user_456", "Jane Smith"));
            mockRouter = new IInboxRouter() { // from class: com.box.android.utilities.PreviewModels$Inbox$mockRouter$1
                @Override // com.box.android.inbox.notifications.router.IInboxRouter
                public void navigateToFile(String fileId, String fileName) {
                    Intrinsics.checkNotNullParameter(fileId, "fileId");
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                }

                @Override // com.box.android.inbox.notifications.router.IInboxRouter
                public void navigateToFileWithAnnotation(String fileId, String fileName, String annotationId) {
                    Intrinsics.checkNotNullParameter(fileId, "fileId");
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                }

                @Override // com.box.android.inbox.notifications.router.IInboxRouter
                public void navigateToFileWithComment(String fileId, String fileName, String commentId) {
                    Intrinsics.checkNotNullParameter(fileId, "fileId");
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    Intrinsics.checkNotNullParameter(commentId, "commentId");
                }

                @Override // com.box.android.inbox.notifications.router.IInboxRouter
                public void navigateToFolder(String folderId, String folderName) {
                    Intrinsics.checkNotNullParameter(folderId, "folderId");
                    Intrinsics.checkNotNullParameter(folderName, "folderName");
                }

                @Override // com.box.android.inbox.notifications.router.IInboxRouter
                public void navigateToTask(String taskId, boolean isMyTask) {
                    Intrinsics.checkNotNullParameter(taskId, "taskId");
                }

                @Override // com.box.android.inbox.notifications.router.IInboxRouter
                public void navigateToUrl(String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                }
            };
            $stable = 8;
        }

        public final InboxNotificationPayloadModel.CommonPayloadInboxModel getMOCK_COMMON_PAYLOAD() {
            return MOCK_COMMON_PAYLOAD;
        }

        public final InboxNotificationModel getMOCK_NOTIFICATION() {
            return MOCK_NOTIFICATION;
        }

        public final IInboxRouter getMockRouter() {
            return mockRouter;
        }
    }

    private PreviewModels() {
    }
}
