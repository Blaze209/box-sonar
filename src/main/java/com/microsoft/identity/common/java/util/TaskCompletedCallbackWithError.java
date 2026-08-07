package com.microsoft.identity.common.java.util;

/* JADX INFO: loaded from: classes14.dex */
public interface TaskCompletedCallbackWithError<T, U> extends TaskCompletedCallback<T> {
    void onError(U u);
}
