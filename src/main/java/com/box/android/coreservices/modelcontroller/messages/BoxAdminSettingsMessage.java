package com.box.android.coreservices.modelcontroller.messages;

import com.box.boxandroidlibv2private.dao.BoxAdminSettings;

/* JADX INFO: loaded from: classes9.dex */
public class BoxAdminSettingsMessage extends BoxMessage<BoxAdminSettings> {
    public static final String ACTION_FETCHED_CLIENT_SETTINGS = "com.box.android.BoxClientSettingsMessage.fetched_client_settings";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public BoxAdminSettings getPayload() {
        return (BoxAdminSettings) getSerializableExtra("box_message_payload");
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(BoxAdminSettings boxAdminSettings) {
        putExtra("box_message_payload", boxAdminSettings);
    }
}
