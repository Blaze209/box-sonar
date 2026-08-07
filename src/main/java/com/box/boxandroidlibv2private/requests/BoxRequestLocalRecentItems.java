package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequestList;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxRecentFiles;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestLocalRecentItems extends BoxRequestList<BoxIteratorBoxRecentFiles, BoxRequestLocalRecentItems> implements BoxCacheableRequest<BoxIteratorBoxRecentFiles> {
    private BoxExtendedApiRecentItems.FILTER mFilter;

    public BoxRequestLocalRecentItems(BoxSession boxSession, BoxExtendedApiRecentItems.FILTER filter) {
        super(BoxIteratorBoxRecentFiles.class, null, null, boxSession);
        this.mFilter = filter;
    }

    public BoxExtendedApiRecentItems.FILTER getFilter() {
        return this.mFilter;
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxIteratorBoxRecentFiles sendForCachedResult() throws BoxException {
        return (BoxIteratorBoxRecentFiles) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxIteratorBoxRecentFiles> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
