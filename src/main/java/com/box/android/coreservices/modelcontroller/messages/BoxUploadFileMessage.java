package com.box.android.coreservices.modelcontroller.messages;

import com.box.androidsdk.content.requests.BoxRequestsFile;

/* JADX INFO: loaded from: classes9.dex */
public class BoxUploadFileMessage extends BoxFileTransferMessage {
    private static final String USING_MULTIPUT = "usingMultiput";

    public BoxUploadFileMessage() {
        super(BoxRequestsFile.UploadFile.class.getName(), Controller.ACTION_UPLOADING_FILE);
    }

    public void setDestinationFileName(String str) {
        setFileName(str);
    }

    public String getDestinationFileName() {
        return getFileName();
    }

    public void setIsMultiputUpload() {
        putExtra(USING_MULTIPUT, true);
    }

    public boolean isMultiputUpload() {
        return getBooleanExtra(USING_MULTIPUT, false);
    }
}
