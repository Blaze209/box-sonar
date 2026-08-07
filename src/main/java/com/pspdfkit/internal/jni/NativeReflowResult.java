package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeReflowResult {
    final String mErrorMessage;
    final NativeReflowProcessorErrorType mErrorType;
    final boolean mHasError;
    final ArrayList<Integer> mPageIndices;
    final String mReflowedContent;

    public NativeReflowResult(boolean z, NativeReflowProcessorErrorType nativeReflowProcessorErrorType, String str, ArrayList<Integer> arrayList, String str2) {
        this.mHasError = z;
        this.mErrorType = nativeReflowProcessorErrorType;
        this.mErrorMessage = str;
        this.mPageIndices = arrayList;
        this.mReflowedContent = str2;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public NativeReflowProcessorErrorType getErrorType() {
        return this.mErrorType;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public ArrayList<Integer> getPageIndices() {
        return this.mPageIndices;
    }

    public String getReflowedContent() {
        return this.mReflowedContent;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeReflowResult{mHasError=").append(this.mHasError).append(",mErrorType=").append(this.mErrorType).append(",mErrorMessage=").append(this.mErrorMessage).append(",mPageIndices=").append(this.mPageIndices).append(",mReflowedContent="), this.mReflowedContent, "}");
    }
}
