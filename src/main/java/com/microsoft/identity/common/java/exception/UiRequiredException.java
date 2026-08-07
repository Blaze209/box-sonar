package com.microsoft.identity.common.java.exception;

/* JADX INFO: loaded from: classes14.dex */
public final class UiRequiredException extends ServiceException {
    public static final String sName = "com.microsoft.identity.common.exception.UiRequiredException";
    private static final long serialVersionUID = 3039442374738287255L;

    public UiRequiredException(String str, String str2) {
        super(str, str2, null);
    }

    public UiRequiredException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    @Override // com.microsoft.identity.common.java.exception.ServiceException, com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }
}
