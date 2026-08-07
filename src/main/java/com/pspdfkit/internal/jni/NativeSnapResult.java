package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSnapResult {
    final String mError;
    final boolean mHasError;
    final NativeSnapPoint mSnapPoint;

    public NativeSnapResult(NativeSnapPoint nativeSnapPoint, boolean z, String str) {
        this.mSnapPoint = nativeSnapPoint;
        this.mHasError = z;
        this.mError = str;
    }

    public String getError() {
        return this.mError;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public NativeSnapPoint getSnapPoint() {
        return this.mSnapPoint;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeSnapResult{mSnapPoint=").append(this.mSnapPoint).append(",mHasError=").append(this.mHasError).append(",mError="), this.mError, "}");
    }
}
