package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.ActionDTO;
import com.box.android.data.api.models.inboxnotifications.AtMentionPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.AvatarDTO;
import com.box.android.data.api.models.inboxnotifications.CollabInvitePayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.CommentPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.CommonPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.EditFilePayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.IconDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationCollaborationDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationCommentDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationTargetItemDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationUserDTO;
import com.box.android.data.api.models.inboxnotifications.NotifyCollabPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.SendSharedLinkPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.StatusDTO;
import com.box.android.data.api.models.inboxnotifications.TaskUpdatedPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.TextDTO;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.AvatarModel;
import com.box.android.domain.models.inboxnotifications.IconModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCommentModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationTargetItemModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import com.box.android.domain.models.inboxnotifications.StatusModel;
import com.box.android.domain.models.inboxnotifications.TextModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationPayloadMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationPayloadMapper {
    public static final InboxNotificationPayloadMapper INSTANCE = new InboxNotificationPayloadMapper();

    private InboxNotificationPayloadMapper() {
    }

    public final InboxNotificationPayloadModel toDomain(InboxNotificationPayloadDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        if (dto instanceof SendSharedLinkPayloadDTOInbox) {
            SendSharedLinkPayloadDTOInbox sendSharedLinkPayloadDTOInbox = (SendSharedLinkPayloadDTOInbox) dto;
            String type = sendSharedLinkPayloadDTOInbox.getType();
            String sharedLink = sendSharedLinkPayloadDTOInbox.getSharedLink();
            InboxNotificationTargetItemModel domain = InboxNotificationTargetItemMapper.INSTANCE.toDomain(sendSharedLinkPayloadDTOInbox.getTarget());
            InboxNotificationUserDTO sentBy = sendSharedLinkPayloadDTOInbox.getSentBy();
            return new InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel(type, sharedLink, domain, sentBy != null ? InboxNotificationUserMapper.INSTANCE.toDomain(sentBy) : null);
        }
        if (dto instanceof CollabInvitePayloadDTOInbox) {
            CollabInvitePayloadDTOInbox collabInvitePayloadDTOInbox = (CollabInvitePayloadDTOInbox) dto;
            String type2 = collabInvitePayloadDTOInbox.getType();
            InboxNotificationCollaborationModel domain2 = InboxNotificationCollaborationMapper.INSTANCE.toDomain(collabInvitePayloadDTOInbox.getCollab());
            InboxNotificationTargetItemModel domain3 = InboxNotificationTargetItemMapper.INSTANCE.toDomain(collabInvitePayloadDTOInbox.getTarget());
            InboxNotificationUserDTO invitedBy = collabInvitePayloadDTOInbox.getInvitedBy();
            return new InboxNotificationPayloadModel.CollabInvitePayloadInboxModel(type2, domain2, domain3, invitedBy != null ? InboxNotificationUserMapper.INSTANCE.toDomain(invitedBy) : null);
        }
        if (dto instanceof AtMentionPayloadDTOInbox) {
            AtMentionPayloadDTOInbox atMentionPayloadDTOInbox = (AtMentionPayloadDTOInbox) dto;
            String type3 = atMentionPayloadDTOInbox.getType();
            InboxNotificationCommentModel domain4 = InboxNotificationCommentMapper.INSTANCE.toDomain(atMentionPayloadDTOInbox.getComment());
            InboxNotificationTargetItemModel domain5 = InboxNotificationTargetItemMapper.INSTANCE.toDomain(atMentionPayloadDTOInbox.getTarget());
            InboxNotificationUserDTO sentBy2 = atMentionPayloadDTOInbox.getSentBy();
            return new InboxNotificationPayloadModel.AtMentionPayloadInboxModel(type3, domain4, domain5, sentBy2 != null ? InboxNotificationUserMapper.INSTANCE.toDomain(sentBy2) : null);
        }
        if (dto instanceof NotifyCollabPayloadDTOInbox) {
            NotifyCollabPayloadDTOInbox notifyCollabPayloadDTOInbox = (NotifyCollabPayloadDTOInbox) dto;
            String type4 = notifyCollabPayloadDTOInbox.getType();
            InboxNotificationTargetItemModel domain6 = InboxNotificationTargetItemMapper.INSTANCE.toDomain(notifyCollabPayloadDTOInbox.getTarget());
            InboxNotificationUserDTO sentBy3 = notifyCollabPayloadDTOInbox.getSentBy();
            return new InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel(type4, domain6, sentBy3 != null ? InboxNotificationUserMapper.INSTANCE.toDomain(sentBy3) : null);
        }
        if (dto instanceof TaskUpdatedPayloadDTOInbox) {
            TaskUpdatedPayloadDTOInbox taskUpdatedPayloadDTOInbox = (TaskUpdatedPayloadDTOInbox) dto;
            return new InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel(taskUpdatedPayloadDTOInbox.getType(), InboxNotificationTaskMapper.INSTANCE.toDomain(taskUpdatedPayloadDTOInbox.getTask()), InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.INSTANCE.byName(taskUpdatedPayloadDTOInbox.getStatus()));
        }
        if (dto instanceof CommentPayloadDTOInbox) {
            CommentPayloadDTOInbox commentPayloadDTOInbox = (CommentPayloadDTOInbox) dto;
            String type5 = commentPayloadDTOInbox.getType();
            InboxNotificationCommentModel domain7 = InboxNotificationCommentMapper.INSTANCE.toDomain(commentPayloadDTOInbox.getComment());
            InboxNotificationTargetItemModel domain8 = InboxNotificationTargetItemMapper.INSTANCE.toDomain(commentPayloadDTOInbox.getTarget());
            InboxNotificationUserDTO sentBy4 = commentPayloadDTOInbox.getSentBy();
            return new InboxNotificationPayloadModel.CommentPayloadInboxModel(type5, domain7, domain8, sentBy4 != null ? InboxNotificationUserMapper.INSTANCE.toDomain(sentBy4) : null);
        }
        if (dto instanceof EditFilePayloadDTOInbox) {
            EditFilePayloadDTOInbox editFilePayloadDTOInbox = (EditFilePayloadDTOInbox) dto;
            String type6 = editFilePayloadDTOInbox.getType();
            InboxNotificationTargetItemModel domain9 = InboxNotificationTargetItemMapper.INSTANCE.toDomain(editFilePayloadDTOInbox.getTarget());
            InboxNotificationUserDTO sentBy5 = editFilePayloadDTOInbox.getSentBy();
            return new InboxNotificationPayloadModel.EditFilePayloadInboxModel(type6, domain9, sentBy5 != null ? InboxNotificationUserMapper.INSTANCE.toDomain(sentBy5) : null);
        }
        if (!(dto instanceof CommonPayloadDTOInbox)) {
            throw new NoWhenBranchMatchedException();
        }
        CommonPayloadDTOInbox commonPayloadDTOInbox = (CommonPayloadDTOInbox) dto;
        String type7 = commonPayloadDTOInbox.getType();
        AvatarModel domain10 = AvatarMapper.INSTANCE.toDomain(commonPayloadDTOInbox.getMainIcon());
        IconDTO subIcon = commonPayloadDTOInbox.getSubIcon();
        IconModel domain11 = subIcon != null ? IconMapper.INSTANCE.toDomain(subIcon) : null;
        TextModel domain12 = TextMapper.INSTANCE.toDomain(commonPayloadDTOInbox.getTitle());
        TextDTO message = commonPayloadDTOInbox.getMessage();
        TextModel domain13 = message != null ? TextMapper.INSTANCE.toDomain(message) : null;
        StatusDTO status = commonPayloadDTOInbox.getStatus();
        StatusModel domain14 = status != null ? StatusMapper.INSTANCE.toDomain(status) : null;
        String timestamp = commonPayloadDTOInbox.getTimestamp();
        List<IconDTO> statusIcons = commonPayloadDTOInbox.getStatusIcons();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(statusIcons, 10));
        Iterator<T> it = statusIcons.iterator();
        while (it.hasNext()) {
            arrayList.add(IconMapper.INSTANCE.toDomain((IconDTO) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ActionDTO cardAction = commonPayloadDTOInbox.getCardAction();
        ActionModel domain15 = cardAction != null ? ActionMapper.INSTANCE.toDomain(cardAction) : null;
        ActionDTO primaryAction = commonPayloadDTOInbox.getPrimaryAction();
        ActionModel domain16 = primaryAction != null ? ActionMapper.INSTANCE.toDomain(primaryAction) : null;
        ActionDTO secondaryAction = commonPayloadDTOInbox.getSecondaryAction();
        ActionModel domain17 = secondaryAction != null ? ActionMapper.INSTANCE.toDomain(secondaryAction) : null;
        List<ActionDTO> menuActions = commonPayloadDTOInbox.getMenuActions();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(menuActions, 10));
        Iterator<T> it2 = menuActions.iterator();
        while (it2.hasNext()) {
            arrayList3.add(ActionMapper.INSTANCE.toDomain((ActionDTO) it2.next()));
        }
        return new InboxNotificationPayloadModel.CommonPayloadInboxModel(type7, domain10, domain11, domain12, domain13, domain14, timestamp, arrayList2, domain15, domain16, domain17, arrayList3);
    }

    public final InboxNotificationPayloadDTO fromDomain(InboxNotificationPayloadModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model instanceof InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) {
            InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel sendSharedLinkPayloadInboxModel = (InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) model;
            String type = sendSharedLinkPayloadInboxModel.getType();
            String sharedLink = sendSharedLinkPayloadInboxModel.getSharedLink();
            InboxNotificationTargetItemDTO inboxNotificationTargetItemDTOFromDomain = InboxNotificationTargetItemMapper.INSTANCE.fromDomain(sendSharedLinkPayloadInboxModel.getTarget());
            InboxNotificationUserModel sentBy = sendSharedLinkPayloadInboxModel.getSentBy();
            return new SendSharedLinkPayloadDTOInbox(type, sharedLink, inboxNotificationTargetItemDTOFromDomain, sentBy != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(sentBy) : null);
        }
        if (model instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
            InboxNotificationPayloadModel.CollabInvitePayloadInboxModel collabInvitePayloadInboxModel = (InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) model;
            String type2 = collabInvitePayloadInboxModel.getType();
            InboxNotificationCollaborationDTO inboxNotificationCollaborationDTOFromDomain = InboxNotificationCollaborationMapper.INSTANCE.fromDomain(collabInvitePayloadInboxModel.getCollab());
            InboxNotificationTargetItemDTO inboxNotificationTargetItemDTOFromDomain2 = InboxNotificationTargetItemMapper.INSTANCE.fromDomain(collabInvitePayloadInboxModel.getTarget());
            InboxNotificationUserModel invitedBy = collabInvitePayloadInboxModel.getInvitedBy();
            return new CollabInvitePayloadDTOInbox(type2, inboxNotificationCollaborationDTOFromDomain, inboxNotificationTargetItemDTOFromDomain2, invitedBy != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(invitedBy) : null);
        }
        if (model instanceof InboxNotificationPayloadModel.AtMentionPayloadInboxModel) {
            InboxNotificationPayloadModel.AtMentionPayloadInboxModel atMentionPayloadInboxModel = (InboxNotificationPayloadModel.AtMentionPayloadInboxModel) model;
            String type3 = atMentionPayloadInboxModel.getType();
            InboxNotificationCommentDTO inboxNotificationCommentDTOFromDomain = InboxNotificationCommentMapper.INSTANCE.fromDomain(atMentionPayloadInboxModel.getComment());
            InboxNotificationTargetItemDTO inboxNotificationTargetItemDTOFromDomain3 = InboxNotificationTargetItemMapper.INSTANCE.fromDomain(atMentionPayloadInboxModel.getTarget());
            InboxNotificationUserModel sentBy2 = atMentionPayloadInboxModel.getSentBy();
            return new AtMentionPayloadDTOInbox(type3, inboxNotificationCommentDTOFromDomain, inboxNotificationTargetItemDTOFromDomain3, sentBy2 != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(sentBy2) : null);
        }
        if (model instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) {
            InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel notifyCollabPayloadInboxModel = (InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) model;
            String type4 = notifyCollabPayloadInboxModel.getType();
            InboxNotificationTargetItemDTO inboxNotificationTargetItemDTOFromDomain4 = InboxNotificationTargetItemMapper.INSTANCE.fromDomain(notifyCollabPayloadInboxModel.getTarget());
            InboxNotificationUserModel sentBy3 = notifyCollabPayloadInboxModel.getSentBy();
            return new NotifyCollabPayloadDTOInbox(type4, inboxNotificationTargetItemDTOFromDomain4, sentBy3 != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(sentBy3) : null);
        }
        if (model instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) {
            InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel taskUpdatedPayloadInboxModel = (InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) model;
            return new TaskUpdatedPayloadDTOInbox(taskUpdatedPayloadInboxModel.getType(), InboxNotificationTaskMapper.INSTANCE.fromDomain(taskUpdatedPayloadInboxModel.getTask()), taskUpdatedPayloadInboxModel.getStatus().getJsonValue());
        }
        if (model instanceof InboxNotificationPayloadModel.CommentPayloadInboxModel) {
            InboxNotificationPayloadModel.CommentPayloadInboxModel commentPayloadInboxModel = (InboxNotificationPayloadModel.CommentPayloadInboxModel) model;
            String type5 = commentPayloadInboxModel.getType();
            InboxNotificationCommentDTO inboxNotificationCommentDTOFromDomain2 = InboxNotificationCommentMapper.INSTANCE.fromDomain(commentPayloadInboxModel.getComment());
            InboxNotificationTargetItemDTO inboxNotificationTargetItemDTOFromDomain5 = InboxNotificationTargetItemMapper.INSTANCE.fromDomain(commentPayloadInboxModel.getTarget());
            InboxNotificationUserModel sentBy4 = commentPayloadInboxModel.getSentBy();
            return new CommentPayloadDTOInbox(type5, inboxNotificationCommentDTOFromDomain2, inboxNotificationTargetItemDTOFromDomain5, sentBy4 != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(sentBy4) : null);
        }
        if (model instanceof InboxNotificationPayloadModel.EditFilePayloadInboxModel) {
            InboxNotificationPayloadModel.EditFilePayloadInboxModel editFilePayloadInboxModel = (InboxNotificationPayloadModel.EditFilePayloadInboxModel) model;
            String type6 = editFilePayloadInboxModel.getType();
            InboxNotificationTargetItemDTO inboxNotificationTargetItemDTOFromDomain6 = InboxNotificationTargetItemMapper.INSTANCE.fromDomain(editFilePayloadInboxModel.getTarget());
            InboxNotificationUserModel sentBy5 = editFilePayloadInboxModel.getSentBy();
            return new EditFilePayloadDTOInbox(type6, inboxNotificationTargetItemDTOFromDomain6, sentBy5 != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(sentBy5) : null);
        }
        if (!(model instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel)) {
            throw new NoWhenBranchMatchedException();
        }
        InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = (InboxNotificationPayloadModel.CommonPayloadInboxModel) model;
        String type7 = commonPayloadInboxModel.getType();
        AvatarDTO avatarDTOFromDomain = AvatarMapper.INSTANCE.fromDomain(commonPayloadInboxModel.getMainIcon());
        IconModel subIcon = commonPayloadInboxModel.getSubIcon();
        IconDTO iconDTOFromDomain = subIcon != null ? IconMapper.INSTANCE.fromDomain(subIcon) : null;
        TextDTO textDTOFromDomain = TextMapper.INSTANCE.fromDomain(commonPayloadInboxModel.getTitle());
        TextModel message = commonPayloadInboxModel.getMessage();
        TextDTO textDTOFromDomain2 = message != null ? TextMapper.INSTANCE.fromDomain(message) : null;
        StatusModel status = commonPayloadInboxModel.getStatus();
        StatusDTO statusDTOFromDomain = status != null ? StatusMapper.INSTANCE.fromDomain(status) : null;
        String timestamp = commonPayloadInboxModel.getTimestamp();
        List<IconModel> statusIcons = commonPayloadInboxModel.getStatusIcons();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(statusIcons, 10));
        Iterator<T> it = statusIcons.iterator();
        while (it.hasNext()) {
            arrayList.add(IconMapper.INSTANCE.fromDomain((IconModel) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ActionModel cardAction = commonPayloadInboxModel.getCardAction();
        ActionDTO actionDTOFromDomain = cardAction != null ? ActionMapper.INSTANCE.fromDomain(cardAction) : null;
        ActionModel primaryAction = commonPayloadInboxModel.getPrimaryAction();
        ActionDTO actionDTOFromDomain2 = primaryAction != null ? ActionMapper.INSTANCE.fromDomain(primaryAction) : null;
        ActionModel secondaryAction = commonPayloadInboxModel.getSecondaryAction();
        ActionDTO actionDTOFromDomain3 = secondaryAction != null ? ActionMapper.INSTANCE.fromDomain(secondaryAction) : null;
        List<ActionModel> menuActions = commonPayloadInboxModel.getMenuActions();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(menuActions, 10));
        Iterator<T> it2 = menuActions.iterator();
        while (it2.hasNext()) {
            arrayList3.add(ActionMapper.INSTANCE.fromDomain((ActionModel) it2.next()));
        }
        return new CommonPayloadDTOInbox(type7, avatarDTOFromDomain, iconDTOFromDomain, textDTOFromDomain, textDTOFromDomain2, statusDTOFromDomain, timestamp, arrayList2, actionDTOFromDomain, actionDTOFromDomain2, actionDTOFromDomain3, arrayList3);
    }
}
