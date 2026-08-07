package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativePageComplexityOrError {
    final NativeRenderServiceError mError;
    final NativePageComplexityResult mResult;

    public NativePageComplexityOrError(NativePageComplexityResult nativePageComplexityResult, NativeRenderServiceError nativeRenderServiceError) {
        this.mResult = nativePageComplexityResult;
        this.mError = nativeRenderServiceError;
    }

    public NativeRenderServiceError getError() {
        return this.mError;
    }

    public NativePageComplexityResult getResult() {
        return this.mResult;
    }

    public String toString() {
        return "NativePageComplexityOrError{mResult=" + this.mResult + ",mError=" + this.mError + "}";
    }
}
