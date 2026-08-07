package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxIteratorCollections;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsCollections {

    public static class GetCollections extends BoxRequestList<BoxIteratorCollections, GetCollections> implements BoxCacheableRequest<BoxIteratorCollections> {
        private static final long serialVersionUID = 8123965031279971506L;

        public GetCollections(String str, BoxSession boxSession) {
            super(BoxIteratorCollections.class, null, str, boxSession);
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorCollections sendForCachedResult() throws BoxException {
            return (BoxIteratorCollections) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorCollections> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetCollectionItems extends BoxRequestList<BoxIteratorItems, GetCollectionItems> implements BoxCacheableRequest<BoxIteratorItems> {
        private static final long serialVersionUID = 8123965031279971507L;

        public GetCollectionItems(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorItems.class, str, str2, boxSession);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorItems sendForCachedResult() throws BoxException {
            return (BoxIteratorItems) handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorItems> toTaskForCachedResult() throws BoxException {
            return handleToTaskForCachedResult();
        }
    }
}
