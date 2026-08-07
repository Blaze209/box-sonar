package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalParentMessage extends BoxMessage<String> {
    public static final String ACTION_FETCH_LOCAL_PARENT = "com.box.android.BoxLocalParentMessage.fetch.local.Parent";

    public BoxLocalParentMessage() {
        setAction(ACTION_FETCH_LOCAL_PARENT);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(String str) {
        putExtra("box_message_payload", str);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public String getPayload() {
        return getStringExtra("box_message_payload");
    }
}
