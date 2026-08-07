package com.box.android.requests;

import com.box.android.coreservices.models.BoxFeatures;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;

/* JADX INFO: loaded from: classes12.dex */
public class BoxRequestFeatures extends BoxRequest<BoxFeatures, BoxRequestFeatures> {
    private static final long serialVersionUID = 972964042278973942L;

    public BoxRequestFeatures(BoxSession boxSession) {
        super(BoxFeatures.class, BoxInternalApi.FEATURES_URI, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }
}
