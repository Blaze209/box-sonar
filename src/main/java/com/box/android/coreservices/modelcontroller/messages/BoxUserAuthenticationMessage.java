package com.box.android.coreservices.modelcontroller.messages;

import android.content.Intent;
import com.box.androidsdk.content.auth.BoxAuthentication;

/* JADX INFO: loaded from: classes9.dex */
public class BoxUserAuthenticationMessage extends BoxUserMessage {
    public static final String ACTION_AUTHENTICATE_USER = "com.box.android.BoxUserAuthenticationMessage.authenticate.user";
    public static final String ACTION_REGISTER_USER = "com.box.android.BoxUserMessage.register.user";
    private static final String SERVER_RESPONSE = "com.box.android.BoxUserAuthenticationMessage.serverResponse";

    public BoxUserAuthenticationMessage() {
        setAction(ACTION_AUTHENTICATE_USER);
    }

    public BoxUserAuthenticationMessage(Intent intent) {
        putExtras(intent);
    }

    public void setServerResponse(String str) {
        putExtra(SERVER_RESPONSE, str);
    }

    public String getServerResponse() {
        return getStringExtra(SERVER_RESPONSE);
    }

    public static BoxUserAuthenticationMessage newMessage(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        BoxUserAuthenticationMessage boxUserAuthenticationMessage = new BoxUserAuthenticationMessage();
        boxUserAuthenticationMessage.setAction(ACTION_AUTHENTICATE_USER);
        if (boxAuthenticationInfo == null || boxAuthenticationInfo.getUser() == null) {
            boxUserAuthenticationMessage.setSuccess(false);
            return boxUserAuthenticationMessage;
        }
        boxUserAuthenticationMessage.setPayload(boxAuthenticationInfo.getUser());
        boxUserAuthenticationMessage.setSuccess(true);
        return boxUserAuthenticationMessage;
    }
}
