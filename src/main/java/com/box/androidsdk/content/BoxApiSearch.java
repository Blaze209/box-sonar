package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsSearch;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiSearch extends BoxApi {
    public BoxApiSearch(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestsSearch.Search getSearchRequest(String str) {
        return new BoxRequestsSearch.Search(str, getSearchUrl(), this.mSession);
    }

    protected String getSearchUrl() {
        return String.format("%s/search", getBaseUri());
    }
}
