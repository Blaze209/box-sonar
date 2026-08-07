package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUploadFile extends BoxRequestsFile.UploadFile {
    private final IBoxRequestUploadFileHelper mBoxRequestUploadFileHelper;

    public BoxRequestUploadFile(File file, String str, String str2, BoxSession boxSession, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        super(file, str, str2, boxSession);
        this.mBoxRequestUploadFileHelper = iBoxRequestUploadFileHelper;
    }

    public BoxRequestUploadFile(InputStream inputStream, String str, String str2, String str3, BoxSession boxSession, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        super(inputStream, str, str2, str3, boxSession);
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
