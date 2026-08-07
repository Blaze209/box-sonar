package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCacheFileOperationError {
    final String mErrorDescription;
    final boolean mIsError;

    public NativeCacheFileOperationError(boolean z, String str) {
        this.mIsError = z;
        this.mErrorDescription = str;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public boolean getIsError() {
        return this.mIsError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeCacheFileOperationError{mIsError=").append(this.mIsError).append(",mErrorDescription="), this.mErrorDescription, "}");
    }
}
