package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativePageComplexityResult {
    final NativePageComplexity mComplexity;
    final long mNumImageObjects;
    final long mNumOtherObjects;
    final long mNumPathObjects;
    final long mNumTextObjects;
    final int mParseTimeMs;

    public NativePageComplexityResult(NativePageComplexity nativePageComplexity, int i, long j, long j2, long j3, long j4) {
        this.mComplexity = nativePageComplexity;
        this.mParseTimeMs = i;
        this.mNumImageObjects = j;
        this.mNumPathObjects = j2;
        this.mNumTextObjects = j3;
        this.mNumOtherObjects = j4;
    }

    public NativePageComplexity getComplexity() {
        return this.mComplexity;
    }

    public long getNumImageObjects() {
        return this.mNumImageObjects;
    }

    public long getNumOtherObjects() {
        return this.mNumOtherObjects;
    }

    public long getNumPathObjects() {
        return this.mNumPathObjects;
    }

    public long getNumTextObjects() {
        return this.mNumTextObjects;
    }

    public int getParseTimeMs() {
        return this.mParseTimeMs;
    }

    public String toString() {
        return "NativePageComplexityResult{mComplexity=" + this.mComplexity + ",mParseTimeMs=" + this.mParseTimeMs + ",mNumImageObjects=" + this.mNumImageObjects + ",mNumPathObjects=" + this.mNumPathObjects + ",mNumTextObjects=" + this.mNumTextObjects + ",mNumOtherObjects=" + this.mNumOtherObjects + "}";
    }
}
