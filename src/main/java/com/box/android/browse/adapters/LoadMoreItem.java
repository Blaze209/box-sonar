package com.box.android.browse.adapters;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: compiled from: BoxSearchAdapter.java */
/* JADX INFO: loaded from: classes10.dex */
class LoadMoreItem extends BoxItem {
    private BoxRequestsSearch.Search mRequest;

    private LoadMoreItem(JsonObject jsonObject) {
        super(jsonObject);
    }

    static LoadMoreItem create(BoxRequestsSearch.Search search) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", BoxSearchAdapter.LOAD_MORE_ID);
        LoadMoreItem loadMoreItem = new LoadMoreItem(jsonObject);
        loadMoreItem.setRequest(search);
        return loadMoreItem;
    }

    public BoxRequestsSearch.Search getRequest() {
        return this.mRequest;
    }

    private void setRequest(BoxRequestsSearch.Search search) {
        this.mRequest = search;
    }
}
