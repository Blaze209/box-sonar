package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.exception.ClientException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes14.dex */
public interface IRetryPolicy<T> {
    T attempt(Callable<T> callable) throws ClientException;
}
