package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativePlatformDocumentDigesterResult {
    final byte[] mDocumentDigest;
    final String mError;

    public NativePlatformDocumentDigesterResult(byte[] bArr, String str) {
        this.mDocumentDigest = bArr;
        this.mError = str;
    }

    public byte[] getDocumentDigest() {
        return this.mDocumentDigest;
    }

    public String getError() {
        return this.mError;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativePlatformDocumentDigesterResult{mDocumentDigest=").append(this.mDocumentDigest).append(",mError="), this.mError, "}");
    }
}
