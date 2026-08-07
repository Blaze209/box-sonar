package com.box.boxandroidlibv2private.resourcemanagers;

import com.box.androidsdk.content.BoxApiFolder;
import com.box.androidsdk.content.models.BoxSession;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFullFolder;

/* JADX INFO: loaded from: classes13.dex */
public class BoxExtendedApiFolder extends BoxApiFolder {
    public BoxExtendedApiFolder(BoxSession boxSession) {
        super(boxSession);
    }

    @Override // com.box.androidsdk.content.BoxApiFolder
    public String getFolderInfoUrl(String str) {
        return super.getFolderInfoUrl(str);
    }

    public BoxRequestGetFullFolder getFullFolderRequest(String str) {
        return new BoxRequestGetFullFolder(str, getFolderInfoUrl(str), this.mSession, this);
    }
}
