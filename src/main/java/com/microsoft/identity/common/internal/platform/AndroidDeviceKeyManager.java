package com.microsoft.identity.common.internal.platform;

import android.security.keystore.KeyInfo;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.platform.AbstractKeyStoreKeyManager;
import com.microsoft.identity.common.logging.Logger;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidDeviceKeyManager<K extends KeyStore.Entry> extends AbstractKeyStoreKeyManager<K> {
    private static final String TAG = "AndroidDeviceKeyManager";

    public static class AndroidDeviceKeyManagerBuilder<K extends KeyStore.Entry> {
        private String keyAlias;
        private KeyStore keyStore;

        AndroidDeviceKeyManagerBuilder() {
        }

        public AndroidDeviceKeyManager<K> build() throws KeyStoreException {
            return new AndroidDeviceKeyManager<>(this.keyStore, this.keyAlias);
        }

        public AndroidDeviceKeyManagerBuilder<K> keyAlias(String str) {
            if (str == null) {
                throw new NullPointerException("keyAlias is marked non-null but is null");
            }
            this.keyAlias = str;
            return this;
        }

        public AndroidDeviceKeyManagerBuilder<K> keyStore(KeyStore keyStore) {
            if (keyStore == null) {
                throw new NullPointerException("keyStore is marked non-null but is null");
            }
            this.keyStore = keyStore;
            return this;
        }

        public String toString() {
            return "AndroidDeviceKeyManager.AndroidDeviceKeyManagerBuilder(keyStore=" + this.keyStore + ", keyAlias=" + this.keyAlias + ")";
        }
    }

    public static <K extends KeyStore.Entry> AndroidDeviceKeyManagerBuilder<K> builder() {
        return new AndroidDeviceKeyManagerBuilder<>();
    }

    public AndroidDeviceKeyManager(KeyStore keyStore, String str) throws KeyStoreException {
        super(keyStore, str, null);
        if (keyStore == null) {
            throw new NullPointerException("keyStore is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("keyAlias is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public void storeAsymmetricKey(PrivateKey privateKey, Certificate[] certificateArr) {
        if (privateKey == null) {
            throw new NullPointerException("privateKey is marked non-null but is null");
        }
        if (certificateArr == null) {
            throw new NullPointerException("certChain is marked non-null but is null");
        }
        throw new UnsupportedOperationException("This is not currently supported");
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public SecureHardwareState getSecureHardwareState() throws ClientException {
        String str;
        String str2 = TAG + ":getSecureHardwareState";
        try {
            try {
                K entry = getEntry();
                if (entry instanceof KeyStore.PrivateKeyEntry) {
                    try {
                        PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
                        boolean zIsInsideSecureHardware = ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), this.mKeyStore.getProvider()).getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
                        Logger.info(str2, "PrivateKey is secure hardware backed? " + zIsInsideSecureHardware);
                        if (zIsInsideSecureHardware) {
                            return SecureHardwareState.TRUE_UNATTESTED;
                        }
                        return SecureHardwareState.FALSE;
                    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                        Logger.error(str2, "Failed to query secure hardware state.", e);
                        return SecureHardwareState.UNKNOWN_QUERY_ERROR;
                    }
                }
                if (entry instanceof KeyStore.SecretKeyEntry) {
                    try {
                        SecretKey secretKey = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
                        boolean zIsInsideSecureHardware2 = ((KeyInfo) SecretKeyFactory.getInstance(secretKey.getAlgorithm(), this.mKeyStore.getProvider()).getKeySpec(secretKey, KeyInfo.class)).isInsideSecureHardware();
                        Logger.info(str2, "SecretKey is secure hardware backed? " + zIsInsideSecureHardware2);
                        if (zIsInsideSecureHardware2) {
                            return SecureHardwareState.TRUE_UNATTESTED;
                        }
                        return SecureHardwareState.FALSE;
                    } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                        Logger.error(str2, "Failed to query secure hardware state.", e2);
                        return SecureHardwareState.UNKNOWN_QUERY_ERROR;
                    }
                }
                throw new ClientException("unknown_error", "Cannot handle entries of type " + entry.getClass().getCanonicalName());
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                str = "no_such_algorithm";
                ClientException clientException = new ClientException(str, e.getMessage(), e);
                Logger.error(str2, str, e);
                throw clientException;
            }
        } catch (KeyStoreException e4) {
            e = e4;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException2;
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException3;
        }
    }
}
