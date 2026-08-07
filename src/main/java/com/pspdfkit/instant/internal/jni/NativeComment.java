package com.pspdfkit.instant.internal.jni;

import com.pspdfkit.internal.jni.NativeInstantRecordOperations;
import java.util.Date;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeComment {
    final String mAuthorName;
    final String mContent;
    final Date mCreatedAt;
    final String mCreatedBy;
    final byte[] mCustomData;
    final String mId;
    final String mInstantRecordGroup;
    final EnumSet<NativeInstantRecordOperations> mInstantRecordOperations;
    final int mPageIndex;
    final String mRootId;
    final Date mUpdatedAt;
    final String mUpdatedBy;

    public NativeComment(String str, String str2, int i, String str3, String str4, Date date, Date date2, String str5, String str6, byte[] bArr, String str7, EnumSet<NativeInstantRecordOperations> enumSet) {
        this.mId = str;
        this.mRootId = str2;
        this.mPageIndex = i;
        this.mContent = str3;
        this.mAuthorName = str4;
        this.mCreatedAt = date;
        this.mUpdatedAt = date2;
        this.mCreatedBy = str5;
        this.mUpdatedBy = str6;
        this.mCustomData = bArr;
        this.mInstantRecordGroup = str7;
        this.mInstantRecordOperations = enumSet;
    }

    public String getAuthorName() {
        return this.mAuthorName;
    }

    public String getContent() {
        return this.mContent;
    }

    public Date getCreatedAt() {
        return this.mCreatedAt;
    }

    public String getCreatedBy() {
        return this.mCreatedBy;
    }

    public byte[] getCustomData() {
        return this.mCustomData;
    }

    public String getId() {
        return this.mId;
    }

    public String getInstantRecordGroup() {
        return this.mInstantRecordGroup;
    }

    public EnumSet<NativeInstantRecordOperations> getInstantRecordOperations() {
        return this.mInstantRecordOperations;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public String getRootId() {
        return this.mRootId;
    }

    public Date getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public String getUpdatedBy() {
        return this.mUpdatedBy;
    }

    public String toString() {
        return "NativeComment{mId=" + this.mId + ",mRootId=" + this.mRootId + ",mPageIndex=" + this.mPageIndex + ",mContent=" + this.mContent + ",mAuthorName=" + this.mAuthorName + ",mCreatedAt=" + this.mCreatedAt + ",mUpdatedAt=" + this.mUpdatedAt + ",mCreatedBy=" + this.mCreatedBy + ",mUpdatedBy=" + this.mUpdatedBy + ",mCustomData=" + this.mCustomData + ",mInstantRecordGroup=" + this.mInstantRecordGroup + ",mInstantRecordOperations=" + this.mInstantRecordOperations + "}";
    }
}
