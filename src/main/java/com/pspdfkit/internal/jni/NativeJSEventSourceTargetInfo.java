package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSEventSourceTargetInfo {
    final NativeDocumentProvider mDocumentProvider;
    final String mFqn;

    public NativeJSEventSourceTargetInfo(NativeDocumentProvider nativeDocumentProvider, String str) {
        this.mDocumentProvider = nativeDocumentProvider;
        this.mFqn = str;
    }

    public NativeDocumentProvider getDocumentProvider() {
        return this.mDocumentProvider;
    }

    public String getFqn() {
        return this.mFqn;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeJSEventSourceTargetInfo{mDocumentProvider=").append(this.mDocumentProvider).append(",mFqn="), this.mFqn, "}");
    }
}
