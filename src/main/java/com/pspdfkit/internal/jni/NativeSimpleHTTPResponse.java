package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSimpleHTTPResponse {
    final byte[] mBody;
    final String mErrorString;
    final int mHttpResponseCode;

    public NativeSimpleHTTPResponse(byte[] bArr, int i, String str) {
        this.mBody = bArr;
        this.mHttpResponseCode = i;
        this.mErrorString = str;
    }

    public byte[] getBody() {
        return this.mBody;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public int getHttpResponseCode() {
        return this.mHttpResponseCode;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeSimpleHTTPResponse{mBody=").append(this.mBody).append(",mHttpResponseCode=").append(this.mHttpResponseCode).append(",mErrorString="), this.mErrorString, "}");
    }
}
