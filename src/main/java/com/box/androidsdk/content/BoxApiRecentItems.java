package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestRecentItems;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiRecentItems extends BoxApi {
    private static final String ENDPOINT_NAME = "recent_items";

    public BoxApiRecentItems(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getRecentItemsUrl() {
        return String.format("%s/recent_items", getBaseUri());
    }

    public BoxRequestRecentItems.GetRecentItems getRecentItemsRequest() {
        return new BoxRequestRecentItems.GetRecentItems(getRecentItemsUrl(), this.mSession);
    }
}
