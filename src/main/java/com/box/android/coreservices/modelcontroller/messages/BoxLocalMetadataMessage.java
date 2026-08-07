package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.models.BoxLocalMetadata;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalMetadataMessage extends BoxMessage<BoxLocalMetadata> {
    public void setSourceObjectId(String str) {
        putExtra("item_id", str);
    }

    public String setSourceObjectId() {
        return getStringExtra("item_id");
    }

    public void setSourceObjectType(String str) {
        putExtra("item_type", str);
    }

    public String setSourceObjectType() {
        return getStringExtra("item_type");
    }
}
