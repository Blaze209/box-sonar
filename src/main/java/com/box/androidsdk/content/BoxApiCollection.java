package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsCollections;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiCollection extends BoxApi {
    public BoxApiCollection(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getCollectionsUrl() {
        return String.format("%s/collections", getBaseUri());
    }

    protected String getCollectionItemsUrl(String str) {
        return String.format("%s/%s/items", getCollectionsUrl(), str);
    }

    public BoxRequestsCollections.GetCollections getCollectionsRequest() {
        return new BoxRequestsCollections.GetCollections(getCollectionsUrl(), this.mSession);
    }

    public BoxRequestsCollections.GetCollectionItems getItemsRequest(String str) {
        return new BoxRequestsCollections.GetCollectionItems(str, getCollectionItemsUrl(str), this.mSession);
    }
}
