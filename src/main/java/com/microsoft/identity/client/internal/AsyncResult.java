package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.exception.MsalException;

/* JADX INFO: loaded from: classes14.dex */
public class AsyncResult<T> {
    private MsalException mMsalException;
    private T mResult;

    public AsyncResult(T t, MsalException msalException) {
        this.mResult = t;
        this.mMsalException = msalException;
    }

    public T getResult() {
        return this.mResult;
    }

    public MsalException getException() {
        return this.mMsalException;
    }

    public boolean getSuccess() {
        return this.mMsalException == null;
    }
}
