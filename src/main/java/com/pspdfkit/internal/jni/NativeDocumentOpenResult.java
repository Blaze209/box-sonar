package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentOpenResult {
    final NativeDocument mDocument;
    final NativeDocumentOpenErrorCode mErrorCode;
    final String mErrorString;
    final boolean mHasError;

    public NativeDocumentOpenResult(boolean z, String str, NativeDocumentOpenErrorCode nativeDocumentOpenErrorCode, NativeDocument nativeDocument) {
        this.mHasError = z;
        this.mErrorString = str;
        this.mErrorCode = nativeDocumentOpenErrorCode;
        this.mDocument = nativeDocument;
    }

    public NativeDocument getDocument() {
        return this.mDocument;
    }

    public NativeDocumentOpenErrorCode getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return "NativeDocumentOpenResult{mHasError=" + this.mHasError + ",mErrorString=" + this.mErrorString + ",mErrorCode=" + this.mErrorCode + ",mDocument=" + this.mDocument + "}";
    }
}
