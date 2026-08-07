package com.pspdfkit.instant.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeInstantError {
    final NativeInstantErrorCode mCode;
    final String mMessage;
    final Integer mUnderlyingError;

    public NativeInstantError(NativeInstantErrorCode nativeInstantErrorCode, String str, Integer num) {
        this.mCode = nativeInstantErrorCode;
        this.mMessage = str;
        this.mUnderlyingError = num;
    }

    public NativeInstantErrorCode getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public Integer getUnderlyingError() {
        return this.mUnderlyingError;
    }

    public String toString() {
        return "NativeInstantError{mCode=" + this.mCode + ",mMessage=" + this.mMessage + ",mUnderlyingError=" + this.mUnderlyingError + "}";
    }
}
