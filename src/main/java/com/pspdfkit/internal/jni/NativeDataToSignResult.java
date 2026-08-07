package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDataToSignResult {
    final NativeDigitalSignatureCreationError mError;
    final boolean mHasError;
    final NativeDataToSign mValue;

    public NativeDataToSignResult(boolean z, NativeDigitalSignatureCreationError nativeDigitalSignatureCreationError, NativeDataToSign nativeDataToSign) {
        this.mHasError = z;
        this.mError = nativeDigitalSignatureCreationError;
        this.mValue = nativeDataToSign;
    }

    public NativeDigitalSignatureCreationError getError() {
        return this.mError;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public NativeDataToSign getValue() {
        return this.mValue;
    }

    public String toString() {
        return "NativeDataToSignResult{mHasError=" + this.mHasError + ",mError=" + this.mError + ",mValue=" + this.mValue + "}";
    }
}
