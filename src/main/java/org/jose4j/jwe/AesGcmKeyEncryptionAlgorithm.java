package org.jose4j.jwe;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class AesGcmKeyEncryptionAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private static final int IV_BYTE_LENGTH = 12;
    private static final int TAG_BYTE_LENGTH = 16;
    private int keyByteLength;
    private SimpleAeadCipher simpleAeadCipher;

    public AesGcmKeyEncryptionAlgorithm(String str, int i) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
        this.simpleAeadCipher = new SimpleAeadCipher(getJavaAlgorithm(), 16);
        this.keyByteLength = i;
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public ContentEncryptionKeys manageForEncrypt(Key key, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, byte[] bArr, ProviderContext providerContext) throws JoseException {
        byte[] bArrBase64UrlDecode;
        SecureRandom secureRandom = providerContext.getSecureRandom();
        if (bArr == null) {
            bArr = ByteUtil.randomBytes(contentEncryptionKeyDescriptor.getContentEncryptionKeyByteLength(), secureRandom);
        }
        byte[] bArr2 = bArr;
        Base64Url base64Url = new Base64Url();
        String stringHeaderValue = headers.getStringHeaderValue("iv");
        if (stringHeaderValue == null) {
            bArrBase64UrlDecode = ByteUtil.randomBytes(12, secureRandom);
            headers.setStringHeaderValue("iv", base64Url.base64UrlEncode(bArrBase64UrlDecode));
        } else {
            bArrBase64UrlDecode = base64Url.base64UrlDecode(stringHeaderValue);
        }
        String cipherProvider = providerContext.getSuppliedKeyProviderContext().getCipherProvider();
        SimpleAeadCipher.CipherOutput cipherOutputEncrypt = this.simpleAeadCipher.encrypt(key, bArrBase64UrlDecode, bArr2, null, cipherProvider);
        byte[] ciphertext = cipherOutputEncrypt.getCiphertext();
        headers.setStringHeaderValue("tag", base64Url.base64UrlEncode(cipherOutputEncrypt.getTag()));
        return new ContentEncryptionKeys(bArr2, ciphertext);
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public Key manageForDecrypt(Key key, byte[] bArr, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, ProviderContext providerContext) throws JoseException {
        Base64Url base64Url = new Base64Url();
        return new SecretKeySpec(this.simpleAeadCipher.decrypt(key, base64Url.base64UrlDecode(headers.getStringHeaderValue("iv")), bArr, base64Url.base64UrlDecode(headers.getStringHeaderValue("tag")), null, providerContext.getSuppliedKeyProviderContext().getCipherProvider()), contentEncryptionKeyDescriptor.getContentEncryptionKeyAlgorithm());
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
        KeyValidationSupport.validateAesWrappingKey(key, getAlgorithmIdentifier(), this.keyByteLength);
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return this.simpleAeadCipher.isAvailable(this.log, this.keyByteLength, 12, getAlgorithmIdentifier());
    }

    public static class Aes128Gcm extends AesGcmKeyEncryptionAlgorithm {
        public Aes128Gcm() {
            super(KeyManagementAlgorithmIdentifiers.A128GCMKW, ByteUtil.byteLength(128));
        }
    }

    public static class Aes192Gcm extends AesGcmKeyEncryptionAlgorithm {
        public Aes192Gcm() {
            super(KeyManagementAlgorithmIdentifiers.A192GCMKW, ByteUtil.byteLength(192));
        }
    }

    public static class Aes256Gcm extends AesGcmKeyEncryptionAlgorithm {
        public Aes256Gcm() {
            super(KeyManagementAlgorithmIdentifiers.A256GCMKW, ByteUtil.byteLength(256));
        }
    }
}
