package org.jose4j.jwe;

import java.security.Key;
import org.jose4j.jwa.AlgorithmAvailability;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.InvalidKeyException;

/* JADX INFO: loaded from: classes5.dex */
public class AesKeyWrapManagementAlgorithm extends WrappingKeyManagementAlgorithm {
    int keyByteLength;

    public AesKeyWrapManagementAlgorithm(String str, int i) {
        super("AESWrap", str);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        this.keyByteLength = i;
    }

    int getKeyByteLength() {
        return this.keyByteLength;
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public void validateEncryptionKey(Key key, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws InvalidKeyException {
        validateKey(key);
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public void validateDecryptionKey(Key key, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws InvalidKeyException {
        validateKey(key);
    }

    void validateKey(Key key) throws InvalidKeyException {
        KeyValidationSupport.validateAesWrappingKey(key, getAlgorithmIdentifier(), getKeyByteLength());
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        int keyByteLength = getKeyByteLength();
        String javaAlgorithm = getJavaAlgorithm();
        return AlgorithmAvailability.isAvailable("Cipher", javaAlgorithm) && CipherStrengthSupport.isAvailable(javaAlgorithm, keyByteLength);
    }

    AesKeyWrapManagementAlgorithm setUseGeneralProviderContext() {
        this.useSuppliedKeyProviderContext = false;
        return this;
    }

    public static class Aes128 extends AesKeyWrapManagementAlgorithm {
        public Aes128() {
            super(KeyManagementAlgorithmIdentifiers.A128KW, 16);
        }
    }

    public static class Aes192 extends AesKeyWrapManagementAlgorithm {
        public Aes192() {
            super(KeyManagementAlgorithmIdentifiers.A192KW, 24);
        }
    }

    public static class Aes256 extends AesKeyWrapManagementAlgorithm {
        public Aes256() {
            super(KeyManagementAlgorithmIdentifiers.A256KW, 32);
        }
    }
}
