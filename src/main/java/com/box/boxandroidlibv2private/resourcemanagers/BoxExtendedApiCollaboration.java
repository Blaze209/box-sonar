package com.box.boxandroidlibv2private.resourcemanagers;

import com.box.androidsdk.content.BoxApiCollaboration;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.box.boxandroidlibv2private.requests.BoxRequestDeleteCollaboration;

/* JADX INFO: loaded from: classes13.dex */
public class BoxExtendedApiCollaboration extends BoxApiCollaboration {
    private final BoxCache mCache;

    public BoxExtendedApiCollaboration(BoxSession boxSession, BoxCache boxCache) {
        super(boxSession);
        this.mCache = boxCache;
    }

    public BoxRequestsShare.DeleteCollaboration getDeleteRequest(BoxCollaboration boxCollaboration) {
        return new BoxRequestDeleteCollaboration(this.mCache, boxCollaboration, getCollaborationInfoUrl(boxCollaboration.getUserId()), this.mSession);
    }
}
