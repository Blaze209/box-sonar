package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRenderResult {
    final NativeRenderResultError mError;
    final Long mPageSize;
    final boolean mSuccess;
    final NativeRenderTiming mTiming;

    public NativeRenderResult(boolean z, NativeRenderResultError nativeRenderResultError, Long l, NativeRenderTiming nativeRenderTiming) {
        this.mSuccess = z;
        this.mError = nativeRenderResultError;
        this.mPageSize = l;
        this.mTiming = nativeRenderTiming;
    }

    public NativeRenderResultError getError() {
        return this.mError;
    }

    public Long getPageSize() {
        return this.mPageSize;
    }

    public boolean getSuccess() {
        return this.mSuccess;
    }

    public NativeRenderTiming getTiming() {
        return this.mTiming;
    }

    public String toString() {
        return "NativeRenderResult{mSuccess=" + this.mSuccess + ",mError=" + this.mError + ",mPageSize=" + this.mPageSize + ",mTiming=" + this.mTiming + "}";
    }
}
