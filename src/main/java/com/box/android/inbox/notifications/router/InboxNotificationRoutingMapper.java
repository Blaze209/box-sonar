package com.box.android.inbox.notifications.router;

import com.box.android.domain.models.inboxnotifications.ActionHandlerModel;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationTargetItemModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import com.box.android.inbox.notifications.InboxItemReducer;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationRoutingMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;", "", "<init>", "()V", "getRoutingTarget", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationRoutingMapper {
    public static final int $stable = 0;

    @Inject
    public InboxNotificationRoutingMapper() {
    }

    public final InboxItemReducer.RoutingTarget getRoutingTarget(InboxNotificationModel notification) {
        InboxNotificationTargetItemModel target;
        ActionHandlerModel actionHandler;
        String uri;
        Intrinsics.checkNotNullParameter(notification, "notification");
        InboxNotificationPayloadModel payload = notification.getPayload();
        if (payload instanceof InboxNotificationPayloadModel.AtMentionPayloadInboxModel) {
            InboxNotificationPayloadModel.AtMentionPayloadInboxModel atMentionPayloadInboxModel = (InboxNotificationPayloadModel.AtMentionPayloadInboxModel) payload;
            return new InboxItemReducer.RoutingTarget.FileWithAnnotation(atMentionPayloadInboxModel.getTarget().getId(), atMentionPayloadInboxModel.getTarget().getName(), atMentionPayloadInboxModel.getComment().getId());
        }
        if (payload instanceof InboxNotificationPayloadModel.CommentPayloadInboxModel) {
            InboxNotificationPayloadModel.CommentPayloadInboxModel commentPayloadInboxModel = (InboxNotificationPayloadModel.CommentPayloadInboxModel) payload;
            return new InboxItemReducer.RoutingTarget.FileWithComment(commentPayloadInboxModel.getTarget().getId(), commentPayloadInboxModel.getTarget().getName(), commentPayloadInboxModel.getComment().getId());
        }
        if (payload instanceof InboxNotificationPayloadModel.EditFilePayloadInboxModel) {
            InboxNotificationPayloadModel.EditFilePayloadInboxModel editFilePayloadInboxModel = (InboxNotificationPayloadModel.EditFilePayloadInboxModel) payload;
            return new InboxItemReducer.RoutingTarget.File(editFilePayloadInboxModel.getTarget().getId(), editFilePayloadInboxModel.getTarget().getName());
        }
        boolean z = payload instanceof InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel;
        if (z || (payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) || (payload instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel)) {
            if (z) {
                target = ((InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) payload).getTarget();
            } else if (payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
                target = ((InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload).getTarget();
            } else {
                if (!(payload instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel)) {
                    throw new IllegalStateException("Unexpected payload type");
                }
                target = ((InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) payload).getTarget();
            }
            String lowerCase = target.getType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "file")) {
                return new InboxItemReducer.RoutingTarget.File(target.getId(), target.getName());
            }
            return Intrinsics.areEqual(lowerCase, "folder") ? new InboxItemReducer.RoutingTarget.Folder(target.getId(), target.getName()) : new InboxItemReducer.RoutingTarget.File(target.getId(), target.getName());
        }
        if (payload instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) {
            InboxNotificationUserModel recipient = notification.getRecipient();
            String id = recipient != null ? recipient.getId() : null;
            InboxNotificationUserModel ownedBy = notification.getOwnedBy();
            return new InboxItemReducer.RoutingTarget.Task(((InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) payload).getTask().getId(), Intrinsics.areEqual(id, ownedBy != null ? ownedBy.getId() : null));
        }
        if (!(payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel)) {
            throw new NoWhenBranchMatchedException();
        }
        ActionModel cardAction = ((InboxNotificationPayloadModel.CommonPayloadInboxModel) payload).getCardAction();
        if (cardAction != null && (actionHandler = cardAction.getActionHandler()) != null && (uri = actionHandler.getUri()) != null) {
            return new InboxItemReducer.RoutingTarget.Url(uri);
        }
        return InboxItemReducer.RoutingTarget.None.INSTANCE;
    }
}
