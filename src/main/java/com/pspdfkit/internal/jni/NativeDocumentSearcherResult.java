package com.pspdfkit.internal.jni;

import com.pspdfkit.datastructures.Range;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentSearcherResult {
    final NativeAnnotation mAnnotation;
    final boolean mIsAnnotation;
    final long mPageIndex;
    final String mPreviewText;
    final Range mRangeInPreviewText;
    final Range mRangeInText;

    public NativeDocumentSearcherResult(long j, Range range, String str, Range range2, boolean z, NativeAnnotation nativeAnnotation) {
        this.mPageIndex = j;
        this.mRangeInText = range;
        this.mPreviewText = str;
        this.mRangeInPreviewText = range2;
        this.mIsAnnotation = z;
        this.mAnnotation = nativeAnnotation;
    }

    public NativeAnnotation getAnnotation() {
        return this.mAnnotation;
    }

    public boolean getIsAnnotation() {
        return this.mIsAnnotation;
    }

    public long getPageIndex() {
        return this.mPageIndex;
    }

    public String getPreviewText() {
        return this.mPreviewText;
    }

    public Range getRangeInPreviewText() {
        return this.mRangeInPreviewText;
    }

    public Range getRangeInText() {
        return this.mRangeInText;
    }

    public String toString() {
        return "NativeDocumentSearcherResult{mPageIndex=" + this.mPageIndex + ",mRangeInText=" + this.mRangeInText + ",mPreviewText=" + this.mPreviewText + ",mRangeInPreviewText=" + this.mRangeInPreviewText + ",mIsAnnotation=" + this.mIsAnnotation + ",mAnnotation=" + this.mAnnotation + "}";
    }
}
