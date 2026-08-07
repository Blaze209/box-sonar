package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRenderServiceError {
    final String mMessage;

    public NativeRenderServiceError(String str) {
        this.mMessage = str;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeRenderServiceError{mMessage="), this.mMessage, "}");
    }
}
