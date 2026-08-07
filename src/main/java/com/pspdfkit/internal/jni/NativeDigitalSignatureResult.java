package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDigitalSignatureResult {
    final NativeDigitalSignatureCreationError mError;
    final boolean mHasError;

    public NativeDigitalSignatureResult(boolean z, NativeDigitalSignatureCreationError nativeDigitalSignatureCreationError) {
        this.mHasError = z;
        this.mError = nativeDigitalSignatureCreationError;
    }

    public NativeDigitalSignatureCreationError getError() {
        return this.mError;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return "NativeDigitalSignatureResult{mHasError=" + this.mHasError + ",mError=" + this.mError + "}";
    }
}
