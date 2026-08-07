package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;

/* JADX INFO: loaded from: classes14.dex */
public interface AsymmetricKeyAccessor extends IManagedKeyAccessor<KeyStore.PrivateKeyEntry> {
    String getPublicKey(IDevicePopManager.PublicKeyFormat publicKeyFormat) throws ClientException;

    PublicKey getPublicKey() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException;
}
