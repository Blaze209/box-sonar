package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentSignatureMetadata {
    final String mLocation;
    final String mReason;
    final String mSignersName;

    public NativeDocumentSignatureMetadata(String str, String str2, String str3) {
        this.mSignersName = str;
        this.mReason = str2;
        this.mLocation = str3;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public String getReason() {
        return this.mReason;
    }

    public String getSignersName() {
        return this.mSignersName;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeDocumentSignatureMetadata{mSignersName=").append(this.mSignersName).append(",mReason=").append(this.mReason).append(",mLocation="), this.mLocation, "}");
    }
}
