package com.pspdfkit.internal.jni;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeEmbeddedFile {
    final Date mCreationDate;
    final String mFileDescription;
    final String mFileName;
    final Long mFileSize;
    final String mMimeType;
    final Date mModificationDate;

    public NativeEmbeddedFile(String str, Long l, String str2, String str3, Date date, Date date2) {
        this.mFileName = str;
        this.mFileSize = l;
        this.mMimeType = str2;
        this.mFileDescription = str3;
        this.mModificationDate = date;
        this.mCreationDate = date2;
    }

    public Date getCreationDate() {
        return this.mCreationDate;
    }

    public String getFileDescription() {
        return this.mFileDescription;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public Long getFileSize() {
        return this.mFileSize;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Date getModificationDate() {
        return this.mModificationDate;
    }

    public String toString() {
        return "NativeEmbeddedFile{mFileName=" + this.mFileName + ",mFileSize=" + this.mFileSize + ",mMimeType=" + this.mMimeType + ",mFileDescription=" + this.mFileDescription + ",mModificationDate=" + this.mModificationDate + ",mCreationDate=" + this.mCreationDate + "}";
    }
}
