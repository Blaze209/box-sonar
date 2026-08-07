package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeProgressiveRenderSessionOrError {
    final NativeRenderServiceError mError;
    final NativeProgressiveRenderSession mSession;

    public NativeProgressiveRenderSessionOrError(NativeProgressiveRenderSession nativeProgressiveRenderSession, NativeRenderServiceError nativeRenderServiceError) {
        this.mSession = nativeProgressiveRenderSession;
        this.mError = nativeRenderServiceError;
    }

    public NativeRenderServiceError getError() {
        return this.mError;
    }

    public NativeProgressiveRenderSession getSession() {
        return this.mSession;
    }

    public String toString() {
        return "NativeProgressiveRenderSessionOrError{mSession=" + this.mSession + ",mError=" + this.mError + "}";
    }
}
