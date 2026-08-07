package io.split.android.client.storage.cipher;

import io.split.android.client.storage.cipher.provider.KeyProvider;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import io.split.android.client.utils.logger.Logger;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes4.dex */
public class KeyManager {
    private final KeyProvider mProvider;

    public KeyManager(KeyProvider provider) {
        this.mProvider = provider;
    }

    public KeyManager(String apiKey) {
        Logger.d("Using SecureKeyStorageProvider");
        this.mProvider = new SecureKeyStorageProvider(apiKey);
    }

    public SecretKey getKey() {
        return this.mProvider.getKey();
    }
}
