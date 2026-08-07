package com.box.android.utilities;

import android.content.Context;
import com.box.android.R;
import com.box.androidsdk.content.models.BoxCollaboration;

/* JADX INFO: loaded from: classes13.dex */
public class CollaborationUtils {
    public static final String EXTRA_COLLABORATIONS = "com.box.android.utilities.CollaborationUtils.ExtraCollaborations";
    public static final String EXTRA_ITEM = "com.box.android.utilities.CollaborationUtils.ExtraItem";
    public static final String EXTRA_OWNER_UPDATED = "com.box.android.utilities.CollaborationUtils.ExtraOwnerUpdated";
    public static final String EXTRA_USER_ID = "com.box.android.utilities.CollaborationUtils.ExtraUserId";

    public static String getRoleName(Context context, BoxCollaboration.Role role) {
        switch (AnonymousClass1.$SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[role.ordinal()]) {
            case 1:
                return context.getString(R.string.box_sharesdk_role_name_editor);
            case 2:
                return context.getString(R.string.box_sharesdk_role_name_viewer);
            case 3:
                return context.getString(R.string.box_sharesdk_role_name_previewer);
            case 4:
                return context.getString(R.string.box_sharesdk_role_name_uploader);
            case 5:
                return context.getString(R.string.box_sharesdk_role_name_previewer_uploader);
            case 6:
                return context.getString(R.string.box_sharesdk_role_name_viewer_uploader);
            case 7:
                return context.getString(R.string.box_sharesdk_role_name_co_owner);
            case 8:
                return context.getString(R.string.box_sharesdk_role_name_owner);
            default:
                return "";
        }
    }

    public static String getRoleDescription(Context context, BoxCollaboration.Role role) {
        switch (AnonymousClass1.$SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[role.ordinal()]) {
            case 1:
                return context.getString(R.string.box_sharesdk_role_description_editor);
            case 2:
                return context.getString(R.string.box_sharesdk_role_description_viewer);
            case 3:
                return context.getString(R.string.box_sharesdk_role_description_previewer);
            case 4:
                return context.getString(R.string.box_sharesdk_role_description_uploader);
            case 5:
                return context.getString(R.string.box_sharesdk_role_description_previewer_uploader);
            case 6:
                return context.getString(R.string.box_sharesdk_role_description_viewer_uploader);
            case 7:
                return context.getString(R.string.box_sharesdk_role_description_co_owner);
            case 8:
                return context.getString(R.string.box_sharesdk_role_description_owner);
            default:
                return "";
        }
    }

    /* JADX INFO: renamed from: com.box.android.utilities.CollaborationUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role;
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Status;

        static {
            int[] iArr = new int[BoxCollaboration.Status.values().length];
            $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Status = iArr;
            try {
                iArr[BoxCollaboration.Status.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Status[BoxCollaboration.Status.REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[BoxCollaboration.Role.values().length];
            $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role = iArr2;
            try {
                iArr2[BoxCollaboration.Role.EDITOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.VIEWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.PREVIEWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.UPLOADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.PREVIEWER_UPLOADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.VIEWER_UPLOADER.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.CO_OWNER.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Role[BoxCollaboration.Role.OWNER.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static String getCollaborationStatusText(Context context, BoxCollaboration.Status status) {
        int i = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$models$BoxCollaboration$Status[status.ordinal()];
        if (i == 1) {
            return context.getString(R.string.box_sharesdk_invited_status);
        }
        if (i == 2) {
            return context.getString(R.string.box_sharesdk_rejected_status);
        }
        return "";
    }

    public static String getSubtitleForItemType(Context context, String str) {
        if (str.equals("folder")) {
            return context.getString(R.string.box_sharesdk_subtitle_folder_type);
        }
        if (str.equals("file")) {
            return context.getString(R.string.box_sharesdk_subtitle_file_type);
        }
        return null;
    }
}
