package com.box.boxandroidlibv2private.resourcemanagers;

import com.box.androidsdk.content.BoxApiFile;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxSession;
import com.box.boxandroidlibv2private.requests.BoxFileNotificationMute;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadFile;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadNewVersionFile;
import com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxExtendedApiFile extends BoxApiFile {
    public static final String ANALYTICS_PARAM_SOURCE_TYPE = "transfer_source_type";

    public BoxExtendedApiFile(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestUploadFile getUploadFileRequest(File file, String str, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        return new BoxRequestUploadFile(file, str, getFileUploadUrl(), this.mSession, iBoxRequestUploadFileHelper);
    }

    public BoxRequestUploadNewVersionFile getUploadNewVersionRequest(File file, String str, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        try {
            return new BoxRequestUploadNewVersionFile(new FileInputStream(file), getFileUploadNewVersionUrl(str), this.mSession, iBoxRequestUploadFileHelper);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public BoxRequestUploadFile getUploadFileRequest(InputStream inputStream, String str, String str2, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        return new BoxRequestUploadFile(inputStream, str, str2, getFileUploadUrl(), this.mSession, iBoxRequestUploadFileHelper);
    }

    public BoxRequestUploadNewVersionFile getUploadNewVersionRequest(InputStream inputStream, String str, IBoxRequestUploadFileHelper iBoxRequestUploadFileHelper) {
        return new BoxRequestUploadNewVersionFile(inputStream, getFileUploadNewVersionUrl(str), this.mSession, iBoxRequestUploadFileHelper);
    }

    public BoxFileNotificationMute.GetFileMute getFileNotificationMute(String str) {
        BoxFileNotificationMute.GetFileMute getFileMute = new BoxFileNotificationMute.GetFileMute(str, getFileInfoUrl(str), this.mSession);
        getFileMute.setFields(BoxFile.ALL_FIELDS);
        return getFileMute;
    }

    public BoxFileNotificationMute.AddFileMute addMuteNotificationCategory(String str, String str2) {
        return new BoxFileNotificationMute.AddFileMute(str, getFileInfoUrl(str), this.mSession, str2);
    }

    public BoxFileNotificationMute.RemoveFileMute removeMuteNotificationCategory(String str, String str2) {
        return new BoxFileNotificationMute.RemoveFileMute(str, getFileInfoUrl(str), this.mSession, str2);
    }
}
