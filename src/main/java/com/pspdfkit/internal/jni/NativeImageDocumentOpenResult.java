package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeImageDocumentOpenResult {
    final NativeImageDocument mImageDocument;
    final NativeResult mResult;

    public NativeImageDocumentOpenResult(NativeResult nativeResult, NativeImageDocument nativeImageDocument) {
        this.mResult = nativeResult;
        this.mImageDocument = nativeImageDocument;
    }

    public NativeImageDocument getImageDocument() {
        return this.mImageDocument;
    }

    public NativeResult getResult() {
        return this.mResult;
    }

    public String toString() {
        return "NativeImageDocumentOpenResult{mResult=" + this.mResult + ",mImageDocument=" + this.mImageDocument + "}";
    }
}
