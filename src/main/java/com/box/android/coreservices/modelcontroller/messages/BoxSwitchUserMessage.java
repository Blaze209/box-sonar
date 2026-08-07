package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxSwitchUserMessage extends BoxMessage<Boolean> {
    public static final String ACTION_CLEARED_USER = "com.box.android.clearedUser";
    public static final String ACTION_DESTROYED_USER = "com.box.android.destroyedUser";
    public static final String ACTION_SET_USER = "com.box.android.setUser";
    public static final String ACTION_SWITCHED_USER = "com.box.android.switchedUser";
    public static final String EXTRA_SWITCH_TO_USER_ID = "com.box.android.switchToUserId";

    public BoxSwitchUserMessage(String str) {
        setAction(str);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(Boolean bool) {
        putExtra("box_message_payload", bool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public Boolean getPayload() {
        return Boolean.valueOf(getBooleanExtra("box_message_payload", false));
    }

    public void setSwitchToUserId(String str) {
        putExtra(EXTRA_SWITCH_TO_USER_ID, str);
    }

    public String getSwitchToUserId() {
        return getStringExtra(EXTRA_SWITCH_TO_USER_ID);
    }
}
