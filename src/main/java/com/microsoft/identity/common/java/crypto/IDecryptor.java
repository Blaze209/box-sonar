package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import java.security.Key;

/* JADX INFO: loaded from: classes14.dex */
public interface IDecryptor {
    byte[] decryptWithGcm(Key key, String str, byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws ClientException;

    byte[] decryptWithIv(Key key, String str, byte[] bArr, byte[] bArr2) throws ClientException;
}
