package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeContentEditingResult {
    final byte[] mBinaryData;
    final NativeContentEditingError mError;
    final String mJsonData;

    public NativeContentEditingResult(NativeContentEditingError nativeContentEditingError, String str, byte[] bArr) {
        this.mError = nativeContentEditingError;
        this.mJsonData = str;
        this.mBinaryData = bArr;
    }

    public byte[] getBinaryData() {
        return this.mBinaryData;
    }

    public NativeContentEditingError getError() {
        return this.mError;
    }

    public String getJsonData() {
        return this.mJsonData;
    }

    public String toString() {
        return "NativeContentEditingResult{mError=" + this.mError + ",mJsonData=" + this.mJsonData + ",mBinaryData=" + this.mBinaryData + "}";
    }
}
