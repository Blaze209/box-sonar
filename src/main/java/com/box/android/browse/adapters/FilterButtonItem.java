package com.box.android.browse.adapters;

import com.box.androidsdk.content.models.BoxItem;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes10.dex */
public class FilterButtonItem extends BoxItem {
    static final String FILTER_BUTTON_ID = "com.box.android.browse.FILTER_BUTTON";

    private FilterButtonItem(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static FilterButtonItem create() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", FILTER_BUTTON_ID);
        return new FilterButtonItem(jsonObject);
    }
}
