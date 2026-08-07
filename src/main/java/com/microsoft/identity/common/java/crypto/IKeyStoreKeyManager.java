package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public interface IKeyStoreKeyManager<K extends KeyStore.Entry> {
    boolean clear();

    boolean exists();

    Certificate[] getCertificateChain() throws ClientException;

    Date getCreationDate() throws ClientException;

    K getEntry() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException;

    String getKeyAlias();

    SecureHardwareState getSecureHardwareState() throws ClientException;

    byte[] getThumbprint() throws ClientException;

    boolean hasThumbprint(byte[] bArr);

    void importKey(byte[] bArr, String str) throws ClientException;

    void storeAsymmetricKey(PrivateKey privateKey, Certificate[] certificateArr) throws KeyStoreException, ClientException;
}
