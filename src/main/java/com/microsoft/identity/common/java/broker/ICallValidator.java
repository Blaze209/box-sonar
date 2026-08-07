package com.microsoft.identity.common.java.broker;

import com.microsoft.identity.common.java.exception.ClientException;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface ICallValidator {
    void throwIfNotInvokedByAcceptableApp(String str, int i, Map<String, Iterable<String>> map) throws ClientException;
}
