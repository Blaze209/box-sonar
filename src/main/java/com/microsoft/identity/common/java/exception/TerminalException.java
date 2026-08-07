package com.microsoft.identity.common.java.exception;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public class TerminalException extends RuntimeException implements IErrorInformation {
    private final String mErrorCode;

    @Override // com.microsoft.identity.common.java.exception.IErrorInformation
    @Nullable
    public String getSubErrorCode() {
        return null;
    }

    @Override // com.microsoft.identity.common.java.exception.IErrorInformation
    public String getErrorCode() {
        return this.mErrorCode;
    }

    public TerminalException(@Nullable String str, Throwable th, String str2) {
        super(str, th);
        if (th == null) {
            throw new NullPointerException("cause is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        this.mErrorCode = str2;
    }

    public TerminalException(Throwable th, String str) {
        super(th);
        if (th == null) {
            throw new NullPointerException("cause is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        this.mErrorCode = str;
    }

    public TerminalException(String str) {
        if (str == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        this.mErrorCode = str;
    }

    public TerminalException(@Nullable String str, String str2) {
        super(str);
        if (str2 == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        this.mErrorCode = str2;
    }
}
