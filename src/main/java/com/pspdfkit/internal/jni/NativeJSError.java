package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSError {
    final String mMessage;

    public NativeJSError(String str) {
        this.mMessage = str;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeJSError{mMessage="), this.mMessage, "}");
    }
}
