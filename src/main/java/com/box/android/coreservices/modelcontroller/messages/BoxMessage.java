package com.box.android.coreservices.modelcontroller.messages;

import android.content.Intent;
import com.box.android.domain.R;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.androidsdk.content.BoxException;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes9.dex */
public class BoxMessage<E> extends Intent {
    public static final String EXCEPTION_EXTRA = "box_message_exception";
    public static final String IS_LOCAL_EXTRA = "box_is_local";
    public static final String PAYLOAD_EXTRA = "box_message_payload";
    public static final String REQUEST_ID_EXTRA = "box_message_request_id";

    public enum Scenario {
        DOWNLOAD_FILE,
        UPLOAD_FILE,
        UPLOAD_FILE_NEW_VERSION,
        ADD_COMMENT_FILE,
        GET_COMMENTS_FILE,
        DELETE_COMMENTS_FILE,
        CREATE_FOLDER,
        UPDATE_DESCRIPTION,
        RENAME_FILE,
        RENAME_FOLDER,
        DELETE_FILE,
        DELETE_FOLDER,
        INVITE_COLLABORATOR,
        GET_COLLABORATIONS,
        UPDATE_COLLABORATION,
        DELETE_COLLABORATION_SELF,
        DELETE_COLLABORATION_OTHER,
        EXPORT_FILES,
        SEARCH,
        CREATE_SHARED_LINK,
        MODIFY_SHARED_LINK,
        GET_USER,
        OPEN_BOX_NOTE,
        FILE_TRANSFER,
        PREVIEW,
        OPEN_FILE,
        MOVE_FILE_FOLDER,
        FETCH_FOLDER_ITEMS,
        MODIFY_FAVORITES,
        CREATE_BOX_NOTE
    }

    public void setRequestId(long j) {
        putExtra("box_message_request_id", j);
    }

    public long getRequestId() {
        return getLongExtra("box_message_request_id", 0L);
    }

    public void setPayload(E e) {
        if (e instanceof Serializable) {
            putExtra("box_message_payload", (Serializable) e);
        }
    }

    public E getPayload() {
        return (E) getSerializableExtra("box_message_payload");
    }

    public void setException(Exception exc) {
        putExtra("box_message_exception", exc);
    }

    public Exception getException() {
        return (Exception) getSerializableExtra("box_message_exception");
    }

    public boolean wasNetworkException() {
        Exception exception = getException();
        if (exception == null) {
            return false;
        }
        return (exception instanceof IOException) || (exception.getCause() instanceof UnknownHostException);
    }

    protected int getHttpErrorResponseCode() {
        Exception exception = getException();
        if (exception == null || !(exception instanceof BoxException)) {
            return -1;
        }
        return ((BoxException) exception).getResponseCode();
    }

    public boolean didErrorOut() {
        return getException() != null;
    }

    public void setSuccess(boolean z) {
        putExtra("success", z);
    }

    public boolean wasSuccessful() {
        return getBooleanExtra("success", false);
    }

    public boolean wasConflictError() {
        return getHttpErrorResponseCode() == 409;
    }

    public boolean wasInvalidName() {
        return getHttpErrorResponseCode() == 400;
    }

    public boolean wasApplicationRestricted() {
        return getHttpErrorResponseCode() == 403;
    }

    public void setIsLocal(boolean z) {
        putExtra(IS_LOCAL_EXTRA, z);
    }

    public boolean isLocal() {
        return getBooleanExtra(IS_LOCAL_EXTRA, false);
    }

    public int getErrorStringRId(Scenario scenario, int i, int i2) {
        if (wasNetworkException()) {
            return i;
        }
        Exception exception = getException();
        if (exception instanceof PermissionDeniedException) {
            return R.string.permission_denied_general;
        }
        return exception instanceof SQLException ? R.string.SQL_error : i2;
    }
}
