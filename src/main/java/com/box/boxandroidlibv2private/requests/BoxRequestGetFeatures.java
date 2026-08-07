package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxFeatures;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetFeatures extends BoxRequest<BoxFeatures, BoxRequestGetFeatures> implements BoxCacheableRequest {
    public static final String URI = "internal_users/me/features";

    public BoxRequestGetFeatures(String str, BoxSession boxSession) {
        super(BoxFeatures.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    public static String getUri() {
        return URI;
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFeatures sendForCachedResult() throws BoxException {
        return (BoxFeatures) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxFeatures> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
