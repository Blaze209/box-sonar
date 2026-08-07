package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes14.dex */
public interface IKeyAccessor {
    byte[] decrypt(byte[] bArr) throws ClientException;

    byte[] encrypt(byte[] bArr) throws ClientException;

    IKeyAccessor generateDerivedKey(byte[] bArr, byte[] bArr2, CryptoSuite cryptoSuite) throws ClientException;

    Certificate[] getCertificateChain() throws ClientException;

    SecureHardwareState getSecureHardwareState() throws ClientException;

    byte[] getThumbprint() throws ClientException;

    byte[] sign(byte[] bArr) throws ClientException;

    boolean verify(byte[] bArr, byte[] bArr2) throws ClientException;
}
