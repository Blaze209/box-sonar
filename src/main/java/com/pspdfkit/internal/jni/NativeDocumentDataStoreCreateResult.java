package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentDataStoreCreateResult {
    final NativeDocumentDataStore mDocumentDataStore;
    final int mErrorCode;
    final String mErrorString;
    final boolean mHasError;

    public NativeDocumentDataStoreCreateResult(boolean z, String str, int i, NativeDocumentDataStore nativeDocumentDataStore) {
        this.mHasError = z;
        this.mErrorString = str;
        this.mErrorCode = i;
        this.mDocumentDataStore = nativeDocumentDataStore;
    }

    public NativeDocumentDataStore getDocumentDataStore() {
        return this.mDocumentDataStore;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return "NativeDocumentDataStoreCreateResult{mHasError=" + this.mHasError + ",mErrorString=" + this.mErrorString + ",mErrorCode=" + this.mErrorCode + ",mDocumentDataStore=" + this.mDocumentDataStore + "}";
    }
}
