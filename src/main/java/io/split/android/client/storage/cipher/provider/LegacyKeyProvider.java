package io.split.android.client.storage.cipher.provider;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyKeyProvider implements KeyProvider {
    private static final String ALGORITHM = "AES";
    private static final int KEY_LENGTH = 16;
    private final SecretKey mSecretKey;

    public LegacyKeyProvider(String apiKey) {
        this.mSecretKey = new SecretKeySpec(sanitizeKey(apiKey).getBytes(), "AES");
    }

    @Override // io.split.android.client.storage.cipher.provider.KeyProvider
    public SecretKey getKey() {
        return this.mSecretKey;
    }

    private static String sanitizeKey(String key) {
        if (key.length() < 16) {
            return keyFilled(key);
        }
        return key.length() > 16 ? key.substring(0, 16) : key;
    }

    private static String keyFilled(String key) {
        int length = 16 - key.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return key + ((Object) sb);
    }
}
