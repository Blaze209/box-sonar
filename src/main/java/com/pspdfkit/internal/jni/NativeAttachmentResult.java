package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAttachmentResult {
    final String mErrorString;
    final boolean mHasError;
    final String mMimeType;

    public NativeAttachmentResult(boolean z, String str, String str2) {
        this.mHasError = z;
        this.mErrorString = str;
        this.mMimeType = str2;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeAttachmentResult{mHasError=").append(this.mHasError).append(",mErrorString=").append(this.mErrorString).append(",mMimeType="), this.mMimeType, "}");
    }
}
