package com.box.boxandroidlibv2private.resourcemanagers;

import com.box.androidsdk.content.BoxApiRecentItems;
import com.box.androidsdk.content.models.BoxSession;
import com.box.boxandroidlibv2private.requests.BoxRequestLocalRecentItems;

/* JADX INFO: loaded from: classes13.dex */
public class BoxExtendedApiRecentItems extends BoxApiRecentItems {

    public enum FILTER {
        ALL,
        SHARED_LINKS,
        FILES_PREVIEWED,
        FILES_EDITED,
        OFFLINE,
        BOX_NOTE
    }

    public BoxExtendedApiRecentItems(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestLocalRecentItems getSqlRecentItems(FILTER filter) {
        return new BoxRequestLocalRecentItems(this.mSession, filter);
    }
}
