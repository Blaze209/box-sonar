package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignatureRemovalResult {
    final String mErrorMessage;
    final boolean mHasError;

    public NativeSignatureRemovalResult(boolean z, String str) {
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
        return nv.a(new StringBuilder("NativeSignatureRemovalResult{mHasError=").append(this.mHasError).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
