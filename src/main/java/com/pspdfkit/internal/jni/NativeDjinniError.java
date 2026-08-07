package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDjinniError {
    final long mCode;
    final String mMessage;

    public NativeDjinniError(String str, long j) {
        this.mMessage = str;
        this.mCode = j;
    }

    public long getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String toString() {
        return "NativeDjinniError{mMessage=" + this.mMessage + ",mCode=" + this.mCode + "}";
    }
}
