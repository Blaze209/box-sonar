package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxDownloadFileMessage extends BoxFileTransferMessage {
    public BoxDownloadFileMessage(String str, String str2) {
        super(str, str2);
    }

    public BoxDownloadFileMessage() {
    }

    public void setSourceFileName(String str) {
        setFileName(str);
    }

    public String getSourceFileName() {
        return getFileName();
    }
}
