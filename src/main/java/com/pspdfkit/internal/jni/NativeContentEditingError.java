package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeContentEditingError {
    final NativeContentEditingErrorReason mError;
    final String mErrorMessage;

    public NativeContentEditingError(NativeContentEditingErrorReason nativeContentEditingErrorReason, String str) {
        this.mError = nativeContentEditingErrorReason;
        this.mErrorMessage = str;
    }

    public NativeContentEditingErrorReason getError() {
        return this.mError;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeContentEditingError{mError=").append(this.mError).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
