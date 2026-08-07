package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDigitalSignatureBinaryResult {
    final NativeDigitalSignatureCreationError mError;
    final boolean mHasError;
    final byte[] mValue;

    public NativeDigitalSignatureBinaryResult(boolean z, NativeDigitalSignatureCreationError nativeDigitalSignatureCreationError, byte[] bArr) {
        this.mHasError = z;
        this.mError = nativeDigitalSignatureCreationError;
        this.mValue = bArr;
    }

    public NativeDigitalSignatureCreationError getError() {
        return this.mError;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public byte[] getValue() {
        return this.mValue;
    }

    public String toString() {
        return "NativeDigitalSignatureBinaryResult{mHasError=" + this.mHasError + ",mError=" + this.mError + ",mValue=" + this.mValue + "}";
    }
}
