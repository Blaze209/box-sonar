package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.domain.R;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.android.domain.models.BoxAuthMap;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalUsersDataMessage extends BoxMessage<BoxAuthMap> {
    public static final String ACTION_FETCH_LOCAL_USERS_DATA = "com.box.android.BoxLocalUsersDataMessage.fetch.local.users.data";

    public BoxLocalUsersDataMessage() {
        setAction(ACTION_FETCH_LOCAL_USERS_DATA);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(BoxAuthMap boxAuthMap) {
        putExtra("box_message_payload", boxAuthMap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public BoxAuthMap getPayload() {
        return (BoxAuthMap) getSerializableExtra("box_message_payload");
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public int getErrorStringRId(BoxMessage.Scenario scenario, int i, int i2) {
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
