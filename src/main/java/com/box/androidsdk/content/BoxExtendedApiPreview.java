package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxFilePreviewRequest;
import com.box.androidsdk.content.requests.BoxRequestsFile;

/* JADX INFO: loaded from: classes13.dex */
public class BoxExtendedApiPreview extends BoxApiPreview {
    public BoxExtendedApiPreview(BoxSession boxSession) {
        super(boxSession);
    }

    @Override // com.box.androidsdk.content.BoxApiFile
    public BoxRequestsFile.FilePreviewed getFilePreviewedRequest(String str) {
        return new BoxFilePreviewRequest(str, getPreviewFileUrl(), this.mSession);
    }
}
