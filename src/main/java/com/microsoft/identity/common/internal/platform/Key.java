package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface Key {
    byte[] decrypt(byte[] bArr) throws ClientException;

    byte[] encrypt(byte[] bArr) throws ClientException;

    byte[] sign(byte[] bArr) throws ClientException;

    boolean verify(byte[] bArr, byte[] bArr2) throws ClientException;
}
