package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeEmbeddedFileListResult {
    final ArrayList<NativeEmbeddedFile> mEmbeddedFiles;
    final String mErrorMessage;
    final boolean mHasError;

    public NativeEmbeddedFileListResult(boolean z, String str, ArrayList<NativeEmbeddedFile> arrayList) {
        this.mHasError = z;
        this.mErrorMessage = str;
        this.mEmbeddedFiles = arrayList;
    }

    public ArrayList<NativeEmbeddedFile> getEmbeddedFiles() {
        return this.mEmbeddedFiles;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public String toString() {
        return "NativeEmbeddedFileListResult{mHasError=" + this.mHasError + ",mErrorMessage=" + this.mErrorMessage + ",mEmbeddedFiles=" + this.mEmbeddedFiles + "}";
    }
}
