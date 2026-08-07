package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface IHMacSigner {
    byte[] sign(byte[] bArr, String str, byte[] bArr2) throws ClientException;
}
