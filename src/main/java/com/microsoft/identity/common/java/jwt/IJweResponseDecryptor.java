package com.microsoft.identity.common.java.jwt;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface IJweResponseDecryptor {
    String decryptJwe(String str) throws ClientException;
}
