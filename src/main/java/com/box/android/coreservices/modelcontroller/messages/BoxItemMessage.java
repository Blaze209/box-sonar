package com.box.android.coreservices.modelcontroller.messages;

import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes9.dex */
public class BoxItemMessage extends BoxMessage<BoxItem> {
    public void setItemId(String str) {
        putExtra("item_id", str);
    }

    public String getItemId() {
        return getStringExtra("item_id");
    }
}
