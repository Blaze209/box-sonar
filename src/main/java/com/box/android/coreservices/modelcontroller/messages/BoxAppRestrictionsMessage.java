package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxAppRestrictionsMessage extends BoxMessage<Boolean> {
    public static final String ACTION_APP_RESTRICTIONS_CHANGED = "com.box.android.BoxAppRestrictionsMessage.changed";

    public BoxAppRestrictionsMessage() {
        setAction(ACTION_APP_RESTRICTIONS_CHANGED);
    }
}
