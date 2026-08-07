package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeImage {
    final NativeDataDescriptor mDataDescriptor;
    final byte[] mEncodedData;
    final NativeImageEncoding mEncoding;

    public NativeImage(NativeImageEncoding nativeImageEncoding, byte[] bArr, NativeDataDescriptor nativeDataDescriptor) {
        this.mEncoding = nativeImageEncoding;
        this.mEncodedData = bArr;
        this.mDataDescriptor = nativeDataDescriptor;
    }

    public NativeDataDescriptor getDataDescriptor() {
        return this.mDataDescriptor;
    }

    public byte[] getEncodedData() {
        return this.mEncodedData;
    }

    public NativeImageEncoding getEncoding() {
        return this.mEncoding;
    }

    public String toString() {
        return "NativeImage{mEncoding=" + this.mEncoding + ",mEncodedData=" + this.mEncodedData + ",mDataDescriptor=" + this.mDataDescriptor + "}";
    }
}
