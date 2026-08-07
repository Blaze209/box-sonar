package com.microsoft.identity.client.exception;

import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.exception.BaseException;

/* JADX INFO: loaded from: classes14.dex */
public class MsalException extends BaseException {
    MsalException() {
    }

    MsalException(String str) {
        super(str);
    }

    MsalException(String str, String str2) {
        super(str, str2);
    }

    MsalException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException, com.microsoft.identity.common.java.exception.IErrorInformation
    public String getErrorCode() {
        return super.getErrorCode();
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException, java.lang.Throwable
    public String getMessage() {
        if (!MsalUtils.isEmpty(super.getMessage())) {
            return super.getMessage();
        }
        return "";
    }
}
