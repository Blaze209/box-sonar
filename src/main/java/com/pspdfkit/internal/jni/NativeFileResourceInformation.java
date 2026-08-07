package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFileResourceInformation {
    final String mFileDescription;
    final String mFileName;
    final Long mFileSize;
    final String mMimeType;
    final Date mModificationDate;
    final Long mRawSize;

    public NativeFileResourceInformation(String str, Long l, Long l2, String str2, Date date, String str3) {
        this.mFileName = str;
        this.mFileSize = l;
        this.mRawSize = l2;
        this.mFileDescription = str2;
        this.mModificationDate = date;
        this.mMimeType = str3;
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

    public Long getRawSize() {
        return this.mRawSize;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeFileResourceInformation{mFileName=").append(this.mFileName).append(",mFileSize=").append(this.mFileSize).append(",mRawSize=").append(this.mRawSize).append(",mFileDescription=").append(this.mFileDescription).append(",mModificationDate=").append(this.mModificationDate).append(",mMimeType="), this.mMimeType, "}");
    }
}
