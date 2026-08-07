package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.exception.ClientException;
import java.security.cert.Certificate;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public interface AsymmetricKey extends Key {
    String decrypt(String str) throws ClientException;

    String encrypt(String str) throws ClientException;

    String getAlias();

    Certificate[] getCertificateChain() throws ClientException;

    Date getCreatedOn() throws ClientException;

    String getPublicKey() throws ClientException;

    SecureHardwareState getSecureHardwareState() throws ClientException;

    String getThumbprint() throws ClientException;

    String sign(String str) throws ClientException;

    boolean verify(String str, String str2);
}
