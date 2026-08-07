package com.box.android.coreservices.modelcontroller.messages;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class BoxBatchOperationsMessage extends BoxMessage<ArrayList<BoxMessage<?>>> {
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(ArrayList<BoxMessage<?>> arrayList) {
        putParcelableArrayListExtra("box_message_payload", arrayList);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public ArrayList<BoxMessage<?>> getPayload() {
        return getParcelableArrayListExtra("box_message_payload");
    }
}
