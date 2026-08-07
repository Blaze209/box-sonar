package com.box.android.coreservices.modelcontroller.messages;

import com.box.androidsdk.content.auth.BoxAuthentication;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalUserDataMessage extends BoxMessage<BoxAuthentication.BoxAuthenticationInfo> {
    public static final String ACTION_ADD_LOCAL_USER_DATA = "com.box.android.BoxLocalUserDataMessage.add.local.user.data";
    public static final String ACTION_ENCRYPT_LOCAL_USER_DATA = "com.box.android.BoxLocalUserDataMessage.encrypt.local.user.data";
    public static final String ACTION_FETCH_LOCAL_USER_DATA = "com.box.android.BoxLocalUserDataMessage.fetch.local.user.data";
    public static final String ACTION_REMOVE_LOCAL_USER_DATA = "com.box.android.BoxLocalUserDataMessage.removed.local.user.data";

    public BoxLocalUserDataMessage() {
        setAction(ACTION_FETCH_LOCAL_USER_DATA);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        putExtra("box_message_payload", boxAuthenticationInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public BoxAuthentication.BoxAuthenticationInfo getPayload() {
        return (BoxAuthentication.BoxAuthenticationInfo) getSerializableExtra("box_message_payload");
    }
}
