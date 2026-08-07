package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxIteratorCollections;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetFavoritesCollection extends BoxRequestItem<BoxCollection, BoxRequestGetFavoritesCollection> implements BoxCacheableRequest {
    protected BoxExtendedApiCollections mCollectionsApi;

    public BoxRequestGetFavoritesCollection(String str, BoxSession boxSession, BoxExtendedApiCollections boxExtendedApiCollections) {
        super(BoxCollection.class, null, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mCollectionsApi = boxExtendedApiCollections;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxCollection onSend() throws BoxException {
        for (BoxCollection boxCollection : (BoxIteratorCollections) this.mCollectionsApi.getCollectionsRequest().send()) {
            if (boxCollection.getCollectionType().equals("favorites")) {
                return boxCollection;
            }
        }
        return null;
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxCollection sendForCachedResult() throws BoxException {
        return (BoxCollection) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxCollection> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
