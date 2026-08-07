package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAPStreamResult {
    final NativeDataProvider mApStreamDataProvider;
    final NativeAPStreamOrigin mApStreamOrigin;

    public NativeAPStreamResult(NativeDataProvider nativeDataProvider, NativeAPStreamOrigin nativeAPStreamOrigin) {
        this.mApStreamDataProvider = nativeDataProvider;
        this.mApStreamOrigin = nativeAPStreamOrigin;
    }

    public NativeDataProvider getApStreamDataProvider() {
        return this.mApStreamDataProvider;
    }

    public NativeAPStreamOrigin getApStreamOrigin() {
        return this.mApStreamOrigin;
    }

    public String toString() {
        return "NativeAPStreamResult{mApStreamDataProvider=" + this.mApStreamDataProvider + ",mApStreamOrigin=" + this.mApStreamOrigin + "}";
    }
}
