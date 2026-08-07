package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

/* JADX INFO: loaded from: classes14.dex */
public interface SilentAuthenticationCallback {
    void onError(MsalException msalException);

    void onSuccess(IAuthenticationResult iAuthenticationResult);
}
