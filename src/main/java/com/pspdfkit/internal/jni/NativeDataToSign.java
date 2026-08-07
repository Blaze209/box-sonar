package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDataToSign {
    final byte[] mData;
    final NativeSignerOptions mSignerOptions;

    public NativeDataToSign(byte[] bArr, NativeSignerOptions nativeSignerOptions) {
        this.mData = bArr;
        this.mSignerOptions = nativeSignerOptions;
    }

    public byte[] getData() {
        return this.mData;
    }

    public NativeSignerOptions getSignerOptions() {
        return this.mSignerOptions;
    }

    public String toString() {
        return "NativeDataToSign{mData=" + this.mData + ",mSignerOptions=" + this.mSignerOptions + "}";
    }
}
