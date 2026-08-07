package com.pspdfkit.internal.jni;

import com.pspdfkit.datastructures.Range;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentLibraryPreviewResult {
    final long mAnnotationId;
    final long mPageIndex;
    final String mPreviewText;
    final Range mRange;
    final Range mRangeInPreviewText;
    final String mUid;

    public NativeDocumentLibraryPreviewResult(String str, long j, long j2, Range range, String str2, Range range2) {
        this.mUid = str;
        this.mPageIndex = j;
        this.mAnnotationId = j2;
        this.mRange = range;
        this.mPreviewText = str2;
        this.mRangeInPreviewText = range2;
    }

    public long getAnnotationId() {
        return this.mAnnotationId;
    }

    public long getPageIndex() {
        return this.mPageIndex;
    }

    public String getPreviewText() {
        return this.mPreviewText;
    }

    public Range getRange() {
        return this.mRange;
    }

    public Range getRangeInPreviewText() {
        return this.mRangeInPreviewText;
    }

    public String getUid() {
        return this.mUid;
    }

    public String toString() {
        return "NativeDocumentLibraryPreviewResult{mUid=" + this.mUid + ",mPageIndex=" + this.mPageIndex + ",mAnnotationId=" + this.mAnnotationId + ",mRange=" + this.mRange + ",mPreviewText=" + this.mPreviewText + ",mRangeInPreviewText=" + this.mRangeInPreviewText + "}";
    }
}
