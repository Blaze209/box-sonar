package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeResult {
    final String mErrorString;
    final boolean mHasError;

    public NativeResult(boolean z, String str) {
        this.mHasError = z;
        this.mErrorString = str;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeResult{mHasError=").append(this.mHasError).append(",mErrorString="), this.mErrorString, "}");
    }
}
