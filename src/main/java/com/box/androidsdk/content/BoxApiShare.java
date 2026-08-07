package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.requests.BoxRequestsShare;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiShare extends BoxApi {
    protected String getSharedItemsUrl() {
        return String.format("%s/shared_items", getBaseUri());
    }

    public BoxApiShare(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestsShare.GetSharedLink getSharedLinkRequest(String str) {
        return getSharedLinkRequest(str, null);
    }

    public BoxRequestsShare.GetSharedLink getSharedLinkRequest(String str, String str2) {
        BoxSharedLinkSession boxSharedLinkSession;
        if (this.mSession instanceof BoxSharedLinkSession) {
            boxSharedLinkSession = (BoxSharedLinkSession) this.mSession;
        } else {
            boxSharedLinkSession = new BoxSharedLinkSession(this.mSession);
        }
        boxSharedLinkSession.setSharedLink(str);
        boxSharedLinkSession.setPassword(str2);
        return new BoxRequestsShare.GetSharedLink(getSharedItemsUrl(), boxSharedLinkSession);
    }
}
