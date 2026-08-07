package com.microsoft.identity.common.java.request;

import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;

/* JADX INFO: loaded from: classes14.dex */
public interface ILocalAuthenticationCallback {
    void onCancel();

    void onError(BaseException baseException);

    void onSuccess(ILocalAuthenticationResult iLocalAuthenticationResult);
}
