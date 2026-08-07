package com.microsoft.identity.common.internal.broker;

import com.microsoft.identity.common.java.exception.BaseException;

/* JADX INFO: loaded from: classes14.dex */
public interface IInstallCertCallback {
    void onError(BaseException baseException);

    void onSuccess(boolean z);
}
