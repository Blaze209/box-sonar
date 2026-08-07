package com.box.android.coreservices.utilities;

import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.R;
import com.box.androidsdk.content.BoxException;

/* JADX INFO: loaded from: classes9.dex */
public class APIErrorStringProvider {
    public static final String ERROR_COLLAB_ALREADY_COLLAB = "user_already_collaborator";
    public static final String ERROR_INVITE_COLLAB_PERMISSION = "access_denied_insufficient_permissions";
    private static final int INVALID_RID = -1;
    private static final String STATUS_ITEM_NAME_INVALID = "item_name_invalid";
    private static final String STATUS_STORAGE_LIMIT_EXCEEDED = "storage_limit_exceeded";
    private static APIErrorStringProvider provider;

    private int getLoginErrorStringRId(int i, BoxException boxException) {
        return -1;
    }

    private int getUploadFileNewVersionErrorStringRId(int i, BoxException boxException) {
        return -1;
    }

    private APIErrorStringProvider() {
    }

    public static APIErrorStringProvider getInstance() {
        if (provider == null) {
            provider = new APIErrorStringProvider();
        }
        return provider;
    }

    public int getErrorStringRId(BoxMessage.Scenario scenario, BoxException boxException) {
        int downloadFileErrorStringRId;
        int responseCode = boxException.getResponseCode();
        if (responseCode >= 500) {
            return getGenericAPIErrorStringRId();
        }
        switch (AnonymousClass1.$SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[scenario.ordinal()]) {
            case 1:
                downloadFileErrorStringRId = getDownloadFileErrorStringRId(responseCode);
                break;
            case 2:
                downloadFileErrorStringRId = getUploadFileErrorStringRId(responseCode, boxException);
                break;
            case 3:
                downloadFileErrorStringRId = getUploadFileNewVersionErrorStringRId(responseCode, boxException);
                break;
            case 4:
                downloadFileErrorStringRId = getAddFileCommentErrorStringRId(responseCode);
                break;
            case 5:
                downloadFileErrorStringRId = getGetFileCommentsErrorStringRId(responseCode);
                break;
            case 6:
                downloadFileErrorStringRId = getDeleteFileCommentErrorStringRId(responseCode);
                break;
            case 7:
                downloadFileErrorStringRId = getCreateFolderErrorStringRId(responseCode, boxException);
                break;
            case 8:
                downloadFileErrorStringRId = getRenameFileErrorStringRId(responseCode, boxException);
                break;
            case 9:
                downloadFileErrorStringRId = getUpdateDescriptionErrorStringRId(responseCode);
                break;
            case 10:
                downloadFileErrorStringRId = getRenameFolderErrorStringRId(responseCode, boxException);
                break;
            case 11:
                downloadFileErrorStringRId = getDeleteFileErrorStringRId(responseCode);
                break;
            case 12:
                downloadFileErrorStringRId = getDeleteFolderErrorStringRId(boxException);
                break;
            case 13:
                downloadFileErrorStringRId = getInviteCollabErrorStringRId(boxException);
                break;
            case 14:
                downloadFileErrorStringRId = getGetCollabsErrorStringRId();
                break;
            case 15:
                downloadFileErrorStringRId = getDeleteCollabOtherErrorStringRId();
                break;
            case 16:
                downloadFileErrorStringRId = getDeleteCollabSelfErrorStringRId();
                break;
            case 17:
                downloadFileErrorStringRId = getUpdateCollabErrorStringRId(boxException);
                break;
            case 18:
                downloadFileErrorStringRId = getExportFilesErrorStringRId();
                break;
            case 19:
                downloadFileErrorStringRId = getSearchErrorStringRId();
                break;
            case 20:
                downloadFileErrorStringRId = getCreateSharedLinkRId();
                break;
            case 21:
                downloadFileErrorStringRId = getModifySharedLinkRId(responseCode);
                break;
            case 22:
                downloadFileErrorStringRId = getLoginErrorStringRId(responseCode, boxException);
                break;
            case 23:
                downloadFileErrorStringRId = getOpenBoxNoteStringRId();
                break;
            case 24:
                downloadFileErrorStringRId = getFileTransferStringRId(boxException);
                break;
            case 25:
                downloadFileErrorStringRId = getPreviewErrorRId(boxException);
                break;
            case 26:
                downloadFileErrorStringRId = getMoveFileFolderErrorRId(boxException);
                break;
            case 27:
                downloadFileErrorStringRId = getFetchFolderItemsErrorRId(responseCode, boxException);
                break;
            case 28:
                downloadFileErrorStringRId = getUpdateFavoritesErrorStringRid();
                break;
            case 29:
                downloadFileErrorStringRId = getCreateBoxNotesErrorStringRid(responseCode);
                break;
            default:
                downloadFileErrorStringRId = -1;
                break;
        }
        return downloadFileErrorStringRId == -1 ? getGenericAPIErrorStringRId() : downloadFileErrorStringRId;
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.APIErrorStringProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario;

        static {
            int[] iArr = new int[BoxMessage.Scenario.values().length];
            $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario = iArr;
            try {
                iArr[BoxMessage.Scenario.DOWNLOAD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.UPLOAD_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.UPLOAD_FILE_NEW_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.ADD_COMMENT_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.GET_COMMENTS_FILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.DELETE_COMMENTS_FILE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.CREATE_FOLDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.RENAME_FILE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.UPDATE_DESCRIPTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.RENAME_FOLDER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.DELETE_FILE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.DELETE_FOLDER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.INVITE_COLLABORATOR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.GET_COLLABORATIONS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.DELETE_COLLABORATION_OTHER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.DELETE_COLLABORATION_SELF.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.UPDATE_COLLABORATION.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.EXPORT_FILES.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.SEARCH.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.CREATE_SHARED_LINK.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.MODIFY_SHARED_LINK.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.GET_USER.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.OPEN_BOX_NOTE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.FILE_TRANSFER.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.PREVIEW.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.MOVE_FILE_FOLDER.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.FETCH_FOLDER_ITEMS.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.MODIFY_FAVORITES.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$modelcontroller$messages$BoxMessage$Scenario[BoxMessage.Scenario.CREATE_BOX_NOTE.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    private int getCreateBoxNotesErrorStringRid(int i) {
        if (i == 409) {
            return R.string.a_file_with_that_name_is_already_being_uploaded;
        }
        return getGenericAPIErrorStringRId();
    }

    private int getMoveFileFolderErrorRId(BoxException boxException) {
        if (boxException.getErrorType() == BoxException.ErrorType.ACCESS_DENIED) {
            return R.string.you_do_not_have_permission_to_move_this_item;
        }
        return getGenericAPIErrorStringRId();
    }

    private int getPreviewErrorRId(BoxException boxException) {
        if (boxException.getErrorType() == BoxException.ErrorType.ACCESS_DENIED) {
            return R.string.you_do_not_have_permission_to_preview_this_item;
        }
        return R.string.Preview_not_available;
    }

    private int getFileTransferStringRId(BoxException boxException) {
        if (boxException.getErrorType() == BoxException.ErrorType.ACCESS_DENIED) {
            return R.string.permission_denied_general;
        }
        return R.string.Problem_transferring_file;
    }

    private int getOpenBoxNoteStringRId() {
        return R.string.unable_to_open_box_note;
    }

    private int getCreateSharedLinkRId() {
        return R.string.LS_Share_failed_;
    }

    private int getModifySharedLinkRId(int i) {
        if (i == 403) {
            return R.string.Shared_link_access_deny;
        }
        if (i == 400) {
            return R.string.Shared_link_access_deny;
        }
        return R.string.err_conn1;
    }

    private int getSearchErrorStringRId() {
        return R.string.There_was_a_problem_performing_search;
    }

    private int getDeleteCollabOtherErrorStringRId() {
        return R.string.Unable_to_remove_user_as_a_collaborator_on_this_folder;
    }

    private int getDeleteCollabSelfErrorStringRId() {
        return R.string.Unable_to_remove_you_as_a_collaborator_on_this_folder;
    }

    private int getExportFilesErrorStringRId() {
        return R.string.There_was_a_problem_saving_these_files_to_your_sd_card;
    }

    private int getInviteCollabErrorStringRId(BoxException boxException) {
        if (boxException.getErrorType() == BoxException.ErrorType.ACCESS_DENIED) {
            if (ERROR_INVITE_COLLAB_PERMISSION.equals(boxException.getAsBoxError().getCode())) {
                return R.string.invite_people_insufficient_collab_role_permissions;
            }
            return R.string.invite_people_insufficient_collab_permissions;
        }
        if (boxException.getErrorType() == BoxException.ErrorType.INVALID_REQUEST && "user_already_collaborator".equals(boxException.getAsBoxError().getCode())) {
            return R.string.invite_people_already_collaborator;
        }
        return R.string.Unable_to_invite_people_into_this_folder;
    }

    private int getUpdateCollabErrorStringRId(BoxException boxException) {
        if (boxException.getErrorType() == BoxException.ErrorType.ACCESS_DENIED) {
            return R.string.update_collaboration_error_forbidden;
        }
        return R.string.update_collaboration_error_generic;
    }

    private int getGetCollabsErrorStringRId() {
        return R.string.Unable_to_fetch_people_for_this_folder;
    }

    private int getUpdateFavoritesErrorStringRid() {
        return R.string.Error_modifying_favorites;
    }

    private int getDeleteFolderErrorStringRId(BoxException boxException) {
        if (boxException.getErrorType() == BoxException.ErrorType.ACCESS_DENIED) {
            return R.string.LS_Unable_to_delete_folder;
        }
        return -1;
    }

    private int getDeleteFileErrorStringRId(int i) {
        if (i == 403) {
            return R.string.LS_Unable_to_delete_file;
        }
        return -1;
    }

    private int getRenameFolderErrorStringRId(int i, BoxException boxException) {
        if (i == 409) {
            return R.string.folder_rename_error_duplicate_name;
        }
        if (i == 400 && boxException != null && STATUS_ITEM_NAME_INVALID.equals(boxException.getAsBoxError().getCode())) {
            return R.string.folder_create_error_invalid_name;
        }
        if (i == 403) {
            return R.string.rename_error_forbidden;
        }
        return R.string.rename_error_genericerror;
    }

    private int getRenameFileErrorStringRId(int i, BoxException boxException) {
        if (i == 409) {
            return R.string.file_rename_error_duplicate_name;
        }
        if (i == 400 && boxException != null && boxException.getAsBoxError() != null && STATUS_ITEM_NAME_INVALID.equals(boxException.getAsBoxError().getCode())) {
            return R.string.rename_error_invalidname;
        }
        if (i == 403) {
            return R.string.rename_error_forbidden;
        }
        return R.string.rename_error_genericerror;
    }

    private int getUpdateDescriptionErrorStringRId(int i) {
        if (i == 403) {
            return R.string.update_description_error_generic;
        }
        return R.string.update_description_error_generic;
    }

    private int getCreateFolderErrorStringRId(int i, BoxException boxException) {
        if (i == 409) {
            return R.string.folder_create_error_duplicate_name;
        }
        if (i == 400 && boxException.getAsBoxError() != null && STATUS_ITEM_NAME_INVALID.equals(boxException.getAsBoxError().getCode())) {
            return R.string.folder_create_error_invalid_name;
        }
        if (i == 403) {
            return R.string.folder_create_error_permission_denied;
        }
        return R.string.folder_create_error_generic;
    }

    private int getFetchFolderItemsErrorRId(int i, BoxException boxException) {
        if (i == 403) {
            return R.string.permission_denied_general;
        }
        if (i == 404) {
            return R.string.LS_Unable_to_load_;
        }
        return getGenericAPIErrorStringRId();
    }

    private int getUploadFileErrorStringRId(int i, BoxException boxException) {
        if (i == 403) {
            if (boxException != null && boxException.getAsBoxError() != null) {
                STATUS_STORAGE_LIMIT_EXCEEDED.equals(boxException.getAsBoxError().getCode());
            }
            return -1;
        }
        if (i == 409) {
            return R.string.a_file_with_that_name_is_already_being_uploaded;
        }
        if (i == 400 && boxException != null && boxException.getAsBoxError() != null && STATUS_ITEM_NAME_INVALID.equals(boxException.getAsBoxError().getCode())) {
            return R.string.file_create_error_invalid_name;
        }
        if (boxException == null || boxException.getErrorType() != BoxException.ErrorType.NETWORK_ERROR) {
            return -1;
        }
        return R.string.check_connection_try_again;
    }

    private int getGetFileCommentsErrorStringRId(int i) {
        if (i == 403) {
            return R.string.get_comments_error_permission_denied;
        }
        return R.string.unable_to_load_comments;
    }

    private int getAddFileCommentErrorStringRId(int i) {
        if (i == 403) {
            return R.string.Error_posting_comment;
        }
        if (i == 409) {
            return R.string.Duplicate_comment_error;
        }
        return R.string.Error_posting_comment;
    }

    private int getDeleteFileCommentErrorStringRId(int i) {
        if (i == 403) {
            return R.string.Error_deleting_comment;
        }
        if (i == 404) {
            return R.string.comment_delete_was_successful;
        }
        return -1;
    }

    private int getDownloadFileErrorStringRId(int i) {
        if (i == 403) {
            return R.string.you_do_not_have_permission_to_open_or_download_this_item;
        }
        return -1;
    }

    private int getGenericAPIErrorStringRId() {
        return R.string.err_unknown;
    }
}
