package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCacheReadFileResult {
    final byte[] mData;
    final String mErrorDescription;
    final boolean mIsError;

    public NativeCacheReadFileResult(byte[] bArr, boolean z, String str) {
        this.mData = bArr;
        this.mIsError = z;
        this.mErrorDescription = str;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public boolean getIsError() {
        return this.mIsError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeCacheReadFileResult{mData=").append(this.mData).append(",mIsError=").append(this.mIsError).append(",mErrorDescription="), this.mErrorDescription, "}");
    }
}
