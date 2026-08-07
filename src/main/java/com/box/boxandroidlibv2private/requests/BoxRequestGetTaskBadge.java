package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetTaskBadge extends BoxRequest<BoxTaskBadge, BoxRequestGetTaskBadge> {
    public static final String URI = "undoc/task_badge";

    public BoxRequestGetTaskBadge(String str, BoxSession boxSession) {
        super(BoxTaskBadge.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    public static String getUri() {
        return URI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxTaskBadge onSend() throws BoxException {
        return (BoxTaskBadge) super.onSend();
    }
}
