package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRenderTiming {
    final int mInitialTimeMs;
    final int mParseTimeMs;
    final Integer mRenderAnnotationTimeMs;
    final int mRenderPageTimeMs;

    public NativeRenderTiming(int i, int i2, int i3, Integer num) {
        this.mInitialTimeMs = i;
        this.mParseTimeMs = i2;
        this.mRenderPageTimeMs = i3;
        this.mRenderAnnotationTimeMs = num;
    }

    public int getInitialTimeMs() {
        return this.mInitialTimeMs;
    }

    public int getParseTimeMs() {
        return this.mParseTimeMs;
    }

    public Integer getRenderAnnotationTimeMs() {
        return this.mRenderAnnotationTimeMs;
    }

    public int getRenderPageTimeMs() {
        return this.mRenderPageTimeMs;
    }

    public String toString() {
        return "NativeRenderTiming{mInitialTimeMs=" + this.mInitialTimeMs + ",mParseTimeMs=" + this.mParseTimeMs + ",mRenderPageTimeMs=" + this.mRenderPageTimeMs + ",mRenderAnnotationTimeMs=" + this.mRenderAnnotationTimeMs + "}";
    }
}
