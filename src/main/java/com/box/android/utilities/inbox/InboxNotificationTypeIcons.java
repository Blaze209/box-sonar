package com.box.android.utilities.inbox;

import com.box.android.R;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.base.presentation.utilities.FolderTypeIcon;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.inboxnotifications.IconModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.TextAtomModel;
import com.box.android.domain.models.item.ItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxNotificationTypeIcons.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tJ\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0012H\u0002J1\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/utilities/inbox/InboxNotificationTypeIcons;", "", "<init>", "()V", "getNotificationTypeIcons", "Lcom/box/android/utilities/inbox/NotificationTypeIcons;", "payload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "shouldShowRequirementsButton", "", "isDarkTheme", "getCommonCardIconPair", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "extractFileIconFromAtom", "Lcom/box/android/base/presentation/utilities/FileTypeIcon;", "getCollabInviteIconPair", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CollabInvitePayloadInboxModel;", "getNotifyCollabIconPair", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$NotifyCollabPayloadInboxModel;", "getIconPairForTarget", "resourceType", "", "resourceName", "hasCollaborations", "isExternallyOwned", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/utilities/inbox/NotificationTypeIcons;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationTypeIcons {
    public static final int $stable = 0;

    public static /* synthetic */ NotificationTypeIcons getNotificationTypeIcons$default(InboxNotificationTypeIcons inboxNotificationTypeIcons, InboxNotificationPayloadModel inboxNotificationPayloadModel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return inboxNotificationTypeIcons.getNotificationTypeIcons(inboxNotificationPayloadModel, z, z2);
    }

    public final NotificationTypeIcons getNotificationTypeIcons(InboxNotificationPayloadModel payload, boolean shouldShowRequirementsButton, boolean isDarkTheme) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (payload instanceof InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) {
            return new NotificationTypeIcons(R.drawable.ic_notification_link_icon_outline, R.drawable.ic_notification_link_icon, false, 4, null);
        }
        if (payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
            if (shouldShowRequirementsButton) {
                return new NotificationTypeIcons(R.drawable.ic_notification_special_pending_icon_outline, R.drawable.ic_notification_special_pending_icon, false, 4, null);
            }
            return getCollabInviteIconPair((InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload);
        }
        if (payload instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) {
            return getNotifyCollabIconPair((InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) payload);
        }
        if ((payload instanceof InboxNotificationPayloadModel.AtMentionPayloadInboxModel) || (payload instanceof InboxNotificationPayloadModel.CommentPayloadInboxModel)) {
            return new NotificationTypeIcons(R.drawable.ic_notification_comment_icon_outline, R.drawable.ic_notification_comment_icon, false, 4, null);
        }
        if ((payload instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) || (payload instanceof InboxNotificationPayloadModel.EditFilePayloadInboxModel)) {
            return new NotificationTypeIcons(R.drawable.ic_notification_edit_icon_outline, R.drawable.ic_notification_edit_icon, false, 4, null);
        }
        if (!(payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel)) {
            throw new NoWhenBranchMatchedException();
        }
        InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload;
        if (commonPayloadInboxModel.getSubIcon() != null) {
            return getCommonCardIconPair(commonPayloadInboxModel, isDarkTheme);
        }
        return new NotificationTypeIcons(R.drawable.ic_file_outline_for_inbox, R.drawable.ic_file_default, false);
    }

    private final NotificationTypeIcons getCommonCardIconPair(InboxNotificationPayloadModel.CommonPayloadInboxModel payload, boolean isDarkTheme) {
        int iResolveIconSource;
        IconModel subIcon = payload.getSubIcon();
        if (subIcon != null && ((iResolveIconSource = InboxSubIconMapper.INSTANCE.resolveIconSource(subIcon.getImageSource(), isDarkTheme)) != InboxSubIconMapper.INSTANCE.getDefaultIconResourceId() || subIcon.getImageSource().getUrl() != null)) {
            return new NotificationTypeIcons(iResolveIconSource, iResolveIconSource, false, 4, null);
        }
        FileTypeIcon fileTypeIconExtractFileIconFromAtom = extractFileIconFromAtom(payload);
        if (fileTypeIconExtractFileIconFromAtom != null) {
            return new NotificationTypeIcons(R.drawable.ic_file_outline_for_inbox, fileTypeIconExtractFileIconFromAtom.getDrawable(), false, 4, null);
        }
        return new NotificationTypeIcons(R.drawable.ic_file_outline_for_inbox, InboxSubIconMapper.INSTANCE.getDefaultIconResourceId(), false, 4, null);
    }

    private final FileTypeIcon extractFileIconFromAtom(InboxNotificationPayloadModel.CommonPayloadInboxModel payload) {
        if (payload.getTitle().getAtoms().isEmpty()) {
            return null;
        }
        String value = ((TextAtomModel) CollectionsKt.last((List) payload.getTitle().getAtoms())).getValue();
        if (StringsKt.contains$default((CharSequence) value, '.', false, 2, (Object) null)) {
            String fileExtension = CommonBoxUtil.getFileExtension(value, "");
            if (fileExtension.length() > 0) {
                return SupportedFileExtensionIcons.INSTANCE.findFileIcon(fileExtension);
            }
        }
        return null;
    }

    private final NotificationTypeIcons getCollabInviteIconPair(InboxNotificationPayloadModel.CollabInvitePayloadInboxModel payload) {
        return getIconPairForTarget(payload.getTarget().getType(), payload.getTarget().getName(), payload.getTarget().getHasCollaborations(), payload.getTarget().isExternallyOwned());
    }

    private final NotificationTypeIcons getNotifyCollabIconPair(InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel payload) {
        return getIconPairForTarget(payload.getTarget().getType(), payload.getTarget().getName(), payload.getTarget().getHasCollaborations(), payload.getTarget().isExternallyOwned());
    }

    private final NotificationTypeIcons getIconPairForTarget(String resourceType, String resourceName, Boolean hasCollaborations, Boolean isExternallyOwned) {
        if (Intrinsics.areEqual(resourceType, ItemType.FOLDER.getValue())) {
            return new NotificationTypeIcons(R.drawable.ic_folder_outline_for_inbox, SupportedFileExtensionIcons.INSTANCE.findFolderIcon(hasCollaborations != null ? hasCollaborations.booleanValue() : false, isExternallyOwned != null ? isExternallyOwned.booleanValue() : false).getDrawable(), false, 4, null);
        }
        if (Intrinsics.areEqual(resourceType, ItemType.FILE.getValue()) && !StringsKt.isBlank(resourceName)) {
            return new NotificationTypeIcons(R.drawable.ic_file_outline_for_inbox, SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(resourceName, "")).getDrawable(), false, 4, null);
        }
        return new NotificationTypeIcons(R.drawable.ic_folder_outline_for_inbox, FolderTypeIcon.PERSONAL.getDrawable(), false, 4, null);
    }
}
