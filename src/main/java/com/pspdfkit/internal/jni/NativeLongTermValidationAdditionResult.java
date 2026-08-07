package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLongTermValidationAdditionResult {
    final NativeLongTermValidationAdditionError mError;
    final boolean mHasError;

    public NativeLongTermValidationAdditionResult(boolean z, NativeLongTermValidationAdditionError nativeLongTermValidationAdditionError) {
        this.mHasError = z;
        this.mError = nativeLongTermValidationAdditionError;
    }

    public NativeLongTermValidationAdditionError getError() {
        return this.mError;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return "NativeLongTermValidationAdditionResult{mHasError=" + this.mHasError + ",mError=" + this.mError + "}";
    }
}
