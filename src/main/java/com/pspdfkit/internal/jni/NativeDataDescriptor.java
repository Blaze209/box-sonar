package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDataDescriptor {
    final String mCheckpointPath;
    final String mContentSignature;
    final NativeDataProvider mDataProvider;
    final String mFilePath;
    final String mPassword;

    public NativeDataDescriptor(String str, NativeDataProvider nativeDataProvider, String str2, String str3, String str4) {
        this.mFilePath = str;
        this.mDataProvider = nativeDataProvider;
        this.mPassword = str2;
        this.mContentSignature = str3;
        this.mCheckpointPath = str4;
    }

    public String getCheckpointPath() {
        return this.mCheckpointPath;
    }

    public String getContentSignature() {
        return this.mContentSignature;
    }

    public NativeDataProvider getDataProvider() {
        return this.mDataProvider;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeDataDescriptor{mFilePath=").append(this.mFilePath).append(",mDataProvider=").append(this.mDataProvider).append(",mPassword=").append(this.mPassword).append(",mContentSignature=").append(this.mContentSignature).append(",mCheckpointPath="), this.mCheckpointPath, "}");
    }
}
