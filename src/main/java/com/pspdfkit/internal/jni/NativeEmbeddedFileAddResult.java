package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeEmbeddedFileAddResult {
    final String mErrorMessage;
    final boolean mHasError;
    final boolean mIsDuplicate;

    public NativeEmbeddedFileAddResult(boolean z, String str, boolean z2) {
        this.mHasError = z;
        this.mErrorMessage = str;
        this.mIsDuplicate = z2;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public boolean getIsDuplicate() {
        return this.mIsDuplicate;
    }

    public String toString() {
        return "NativeEmbeddedFileAddResult{mHasError=" + this.mHasError + ",mErrorMessage=" + this.mErrorMessage + ",mIsDuplicate=" + this.mIsDuplicate + "}";
    }
}
