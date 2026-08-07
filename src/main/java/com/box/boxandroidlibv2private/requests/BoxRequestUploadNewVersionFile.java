package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUploadNewVersionFile extends BoxRequestsFile.UploadNewVersion {
    private final IBoxRequestUploadFileHelper mBoxRequestUploadFileHelper;

    public BoxRequestUploadNewVersionFile(InputStream inputStream, String str, BoxSession boxSession, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        super(inputStream, str, boxSession);
        this.mBoxRequestUploadFileHelper = iBoxRequestUploadFileHelper;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxFile onSend() throws BoxException {
        IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper = this.mBoxRequestUploadFileHelper;
        if (iBoxRequestUploadFileHelper != null) {
            iBoxRequestUploadFileHelper.checkBasicError();
            this.mBoxRequestUploadFileHelper.addCustomProperties(this.mQueryMap);
        }
        return (BoxFile) super.onSend();
    }
}
