package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSaveAsDestination {
    final NativeDataProvider mDataProvider;
    final String mFilePath;

    public NativeSaveAsDestination(String str, NativeDataProvider nativeDataProvider) {
        this.mFilePath = str;
        this.mDataProvider = nativeDataProvider;
    }

    public NativeDataProvider getDataProvider() {
        return this.mDataProvider;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String toString() {
        return "NativeSaveAsDestination{mFilePath=" + this.mFilePath + ",mDataProvider=" + this.mDataProvider + "}";
    }
}
