package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignerOptions {
    final NativeHashAlgorithm mHashAlgorithm;

    public NativeSignerOptions(NativeHashAlgorithm nativeHashAlgorithm) {
        this.mHashAlgorithm = nativeHashAlgorithm;
    }

    public NativeHashAlgorithm getHashAlgorithm() {
        return this.mHashAlgorithm;
    }

    public String toString() {
        return "NativeSignerOptions{mHashAlgorithm=" + this.mHashAlgorithm + "}";
    }
}
