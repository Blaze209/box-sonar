package com.microsoft.identity.common.internal.platform;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import com.microsoft.identity.common.java.crypto.Algorithm;
import com.microsoft.identity.common.java.crypto.CryptoSuite;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.crypto.SymmetricAlgorithm;
import java.security.KeyStore;
import org.jose4j.jwe.SimpleAeadCipher;

/* JADX INFO: loaded from: classes14.dex */
public enum SymmetricCipher implements CryptoSuite {
    AES_GCM_NONE_HMACSHA256(SymmetricAlgorithm.Builder.of(SimpleAeadCipher.GCM_TRANSFORMATION_NAME), "HmacSHA256", 256) { // from class: com.microsoft.identity.common.internal.platform.SymmetricCipher.1
        @Override // com.microsoft.identity.common.internal.platform.SymmetricCipher
        public KeyGenParameterSpec.Builder decorateKeyGenerator(KeyGenParameterSpec.Builder builder) {
            return builder.setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(keySize());
        }
    };

    int mKeySize;
    String mMacString;
    SymmetricAlgorithm mValue;

    public abstract KeyGenParameterSpec.Builder decorateKeyGenerator(KeyGenParameterSpec.Builder builder);

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public boolean isAsymmetric() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public SigningAlgorithm signingAlgorithm() {
        return null;
    }

    SymmetricCipher(SymmetricAlgorithm symmetricAlgorithm, String str, int i) {
        this.mValue = symmetricAlgorithm;
        this.mMacString = str;
        this.mKeySize = i;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public Algorithm cipher() {
        return this.mValue;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public String macName() {
        return this.mMacString;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public Class<? extends KeyStore.Entry> keyClass() {
        return KeyStore.SecretKeyEntry.class;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public int keySize() {
        return this.mKeySize;
    }
}
