package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface ICryptoOperation<T> {
    T perform() throws ClientException;
}
