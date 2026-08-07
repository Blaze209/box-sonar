package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeReflowProcessorCreationResult {
    final String mErrorMessage;
    final NativeReflowProcessor mReflowProcessor;
    final boolean mSuccess;

    public NativeReflowProcessorCreationResult(NativeReflowProcessor nativeReflowProcessor, boolean z, String str) {
        this.mReflowProcessor = nativeReflowProcessor;
        this.mSuccess = z;
        this.mErrorMessage = str;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public NativeReflowProcessor getReflowProcessor() {
        return this.mReflowProcessor;
    }

    public boolean getSuccess() {
        return this.mSuccess;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeReflowProcessorCreationResult{mReflowProcessor=").append(this.mReflowProcessor).append(",mSuccess=").append(this.mSuccess).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
