package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxIteratorRecentItems;
import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestRecentItems {

    public static class GetRecentItems extends BoxRequestList<BoxIteratorRecentItems, GetRecentItems> implements BoxCacheableRequest<BoxIteratorRecentItems> {
        private static final String DEFAULT_LIMIT = "90";
        private static final String LIMIT = "limit";
        private static final long serialVersionUID = 8123965031279971506L;

        public GetRecentItems(String str, BoxSession boxSession) {
            super(BoxIteratorRecentItems.class, null, str, boxSession);
            this.mQueryMap.put("limit", DEFAULT_LIMIT);
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorRecentItems sendForCachedResult() throws BoxException {
            return (BoxIteratorRecentItems) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorRecentItems> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }
}
