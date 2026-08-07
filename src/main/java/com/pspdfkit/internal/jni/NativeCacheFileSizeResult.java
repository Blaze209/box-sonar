package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCacheFileSizeResult {
    final String mErrorDescription;
    final long mFileSize;
    final boolean mIsError;

    public NativeCacheFileSizeResult(long j, boolean z, String str) {
        this.mFileSize = j;
        this.mIsError = z;
        this.mErrorDescription = str;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public boolean getIsError() {
        return this.mIsError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeCacheFileSizeResult{mFileSize=").append(this.mFileSize).append(",mIsError=").append(this.mIsError).append(",mErrorDescription="), this.mErrorDescription, "}");
    }
}
