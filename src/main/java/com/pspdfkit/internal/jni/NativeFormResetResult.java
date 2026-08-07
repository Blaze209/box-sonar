package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormResetResult {
    final String mErrorMessage;
    final boolean mHasError;

    public NativeFormResetResult(boolean z, String str) {
        this.mHasError = z;
        this.mErrorMessage = str;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeFormResetResult{mHasError=").append(this.mHasError).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
