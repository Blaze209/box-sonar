package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCacheFileRetrieveResult {
    final String mErrorString;
    final String mFilePath;
    final boolean mHasError;

    public NativeCacheFileRetrieveResult(String str, boolean z, String str2) {
        this.mFilePath = str;
        this.mHasError = z;
        this.mErrorString = str2;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeCacheFileRetrieveResult{mFilePath=").append(this.mFilePath).append(",mHasError=").append(this.mHasError).append(",mErrorString="), this.mErrorString, "}");
    }
}
