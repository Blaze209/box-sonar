package com.box.android.coreservices.utilities;

import android.content.SharedPreferences;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;

/* JADX INFO: loaded from: classes9.dex */
public final class Permissions {
    private static final HashSet<ACTION> SHARED_LINK_PROHIBITED_ACTIONS = new HashSet<>(Arrays.asList(ACTION.INVITE_COLLABORATOR, ACTION.SAVE_FOR_OFFLINE, ACTION.RENAME, ACTION.DELETE, ACTION.MOVE, ACTION.UPLOAD, ACTION.CHANGE_DESCRIPTION, ACTION.SEARCH, ACTION.FAVORITE));
    private static final HashSet<ACTION> ROOT_PROHIBITED_ACTIONS = new HashSet<>(Arrays.asList(ACTION.INVITE_COLLABORATOR, ACTION.SHARE_LINK, ACTION.SAVE_FOR_OFFLINE, ACTION.EXPORT, ACTION.RENAME, ACTION.DELETE, ACTION.COPY, ACTION.MOVE, ACTION.DOWNLOAD, ACTION.CREATE_SHORTCUT, ACTION.CHANGE_DESCRIPTION, ACTION.FAVORITE));
    private static final HashSet<ACTION> BOX_NOTE_PROHIBITED_ACTIONS = new HashSet<>(Arrays.asList(ACTION.UPLOAD, ACTION.DOWNLOAD, ACTION.SAVE_FOR_OFFLINE));

    public enum ACTION {
        INVITE_COLLABORATOR,
        SHARE_LINK,
        SAVE_FOR_OFFLINE,
        EXPORT,
        RENAME,
        DELETE,
        COPY,
        MOVE,
        UPLOAD,
        CHANGE_DESCRIPTION,
        DOWNLOAD,
        CREATE_SHORTCUT,
        SEARCH,
        COMMENT,
        FAVORITE,
        CREATE_BOX_NOTE
    }

    private Permissions() {
    }

    public static boolean hasPermission(BoxItem boxItem, ACTION action, boolean z, SharedPreferences sharedPreferences) {
        EnumSet<BoxItem.Permission> permissions;
        if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(boxItem.getName(), "")) && BOX_NOTE_PROHIBITED_ACTIONS.contains(action)) {
            return false;
        }
        if (boxItem.getUserId().equals("0") && ROOT_PROHIBITED_ACTIONS.contains(action)) {
            return false;
        }
        if ((z && SHARED_LINK_PROHIBITED_ACTIONS.contains(action)) || (permissions = boxItem.getPermissions()) == null) {
            return false;
        }
        switch (AnonymousClass1.$SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[action.ordinal()]) {
            case 1:
                return permissions.contains(BoxItem.Permission.CAN_DOWNLOAD);
            case 2:
                return permissions.contains(BoxItem.Permission.CAN_UPLOAD);
            case 3:
                return permissions.contains(BoxItem.Permission.CAN_DOWNLOAD);
            case 4:
                return permissions.contains(BoxItem.Permission.CAN_RENAME);
            case 5:
                return permissions.contains(BoxItem.Permission.CAN_SHARE);
            case 6:
                return permissions.contains(BoxItem.Permission.CAN_INVITE_COLLABORATOR);
            case 7:
                return permissions.contains(BoxItem.Permission.CAN_DELETE);
            case 8:
                return permissions.contains(BoxItem.Permission.CAN_COMMENT);
            default:
                return true;
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.Permissions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION;

        static {
            int[] iArr = new int[ACTION.values().length];
            $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION = iArr;
            try {
                iArr[ACTION.SAVE_FOR_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.RENAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.SHARE_LINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.INVITE_COLLABORATOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.DELETE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$Permissions$ACTION[ACTION.COMMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
