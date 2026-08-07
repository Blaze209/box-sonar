package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDigitalSignatureCreationResult {
    final NativeDigitalSignatureCreationError mError;
    final boolean mHasError;
    final NativeDigitalSignatureCreator mValue;

    public NativeDigitalSignatureCreationResult(boolean z, NativeDigitalSignatureCreationError nativeDigitalSignatureCreationError, NativeDigitalSignatureCreator nativeDigitalSignatureCreator) {
        this.mHasError = z;
        this.mError = nativeDigitalSignatureCreationError;
        this.mValue = nativeDigitalSignatureCreator;
    }

    public NativeDigitalSignatureCreationError getError() {
        return this.mError;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public NativeDigitalSignatureCreator getValue() {
        return this.mValue;
    }

    public String toString() {
        return "NativeDigitalSignatureCreationResult{mHasError=" + this.mHasError + ",mError=" + this.mError + ",mValue=" + this.mValue + "}";
    }
}
