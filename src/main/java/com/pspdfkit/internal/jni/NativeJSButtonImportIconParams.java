package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSButtonImportIconParams {
    final Integer mPageNumber;
    final String mPath;

    public NativeJSButtonImportIconParams(String str, Integer num) {
        this.mPath = str;
        this.mPageNumber = num;
    }

    public Integer getPageNumber() {
        return this.mPageNumber;
    }

    public String getPath() {
        return this.mPath;
    }

    public String toString() {
        return "NativeJSButtonImportIconParams{mPath=" + this.mPath + ",mPageNumber=" + this.mPageNumber + "}";
    }
}
