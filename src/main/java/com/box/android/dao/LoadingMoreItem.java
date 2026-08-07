package com.box.android.dao;

import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes9.dex */
public class LoadingMoreItem extends BoxItem {
    public static final LoadingMoreItem INSTANCE = new LoadingMoreItem();
    public static final String TYPE = "loadingMore";

    private LoadingMoreItem() {
        set("type", TYPE);
    }
}
