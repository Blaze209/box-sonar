package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxPincodeMessage extends BoxMessage<Boolean> {
    public static final String ACTION_ENTERED_PINCODE = "com.box.android.enteredPincode";
    private static final String USER_ID_EXTRA = "com.box.android.userId";

    public BoxPincodeMessage() {
        setAction(ACTION_ENTERED_PINCODE);
    }

    public BoxPincodeMessage(String str, boolean z) {
        setAction(ACTION_ENTERED_PINCODE);
        setPayload(Boolean.valueOf(z));
        setUserId(str);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(Boolean bool) {
        putExtra("box_message_payload", bool);
        setSuccess(bool.booleanValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public Boolean getPayload() {
        return Boolean.valueOf(getBooleanExtra("box_message_payload", false));
    }

    public String getUserId() {
        return getStringExtra(USER_ID_EXTRA);
    }

    public void setUserId(String str) {
        putExtra(USER_ID_EXTRA, str);
    }
}
