package org.jose4j.jwe;

import com.microsoft.identity.common.crypto.KeyStoreBackedSecretKeyProvider;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwx.Headers;
import org.jose4j.keys.AesKey;
import org.jose4j.keys.HmacKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.IntegrityException;
import org.jose4j.lang.JoseException;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes5.dex */
public class AesCbcHmacSha2ContentEncryptionAlgorithm extends AlgorithmInfo implements ContentEncryptionAlgorithm {
    public static final int IV_BYTE_LENGTH = 16;
    private final ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
    private final String hmacJavaAlgorithm;
    private final int tagTruncationLength;

    public AesCbcHmacSha2ContentEncryptionAlgorithm(String str, int i, String str2, int i2) {
        setAlgorithmIdentifier(str);
        this.contentEncryptionKeyDescriptor = new ContentEncryptionKeyDescriptor(i, "AES");
        this.hmacJavaAlgorithm = str2;
        this.tagTruncationLength = i2;
        setJavaAlgorithm(KeyStoreBackedSecretKeyProvider.AES_CBC_PKCS5_PADDING_TRANSFORMATION);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("AES");
    }

    public String getHmacJavaAlgorithm() {
        return this.hmacJavaAlgorithm;
    }

    public int getTagTruncationLength() {
        return this.tagTruncationLength;
    }

    @Override // org.jose4j.jwe.ContentEncryptionAlgorithm
    public ContentEncryptionKeyDescriptor getContentEncryptionKeyDescriptor() {
        return this.contentEncryptionKeyDescriptor;
    }

    @Override // org.jose4j.jwe.ContentEncryptionAlgorithm
    public ContentEncryptionParts encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, Headers headers, byte[] bArr4, ProviderContext providerContext) throws JoseException {
        return encrypt(bArr, bArr2, bArr3, InitializationVectorHelp.iv(16, bArr4, providerContext.getSecureRandom()), headers, providerContext);
    }

    ContentEncryptionParts encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Headers headers, ProviderContext providerContext) throws JoseException {
        HmacKey hmacKey = new HmacKey(ByteUtil.leftHalf(bArr3));
        AesKey aesKey = new AesKey(ByteUtil.rightHalf(bArr3));
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), ContentEncryptionHelp.getCipherProvider(headers, providerContext));
        try {
            cipher.init(1, aesKey, new IvParameterSpec(bArr4));
            try {
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                return new ContentEncryptionParts(bArr4, bArrDoFinal, ByteUtil.subArray(MacUtil.getInitializedMac(getHmacJavaAlgorithm(), hmacKey, ContentEncryptionHelp.getMacProvider(headers, providerContext)).doFinal(ByteUtil.concat(bArr2, bArr4, bArrDoFinal, getAdditionalAuthenticatedDataLengthBytes(bArr2))), 0, getTagTruncationLength()));
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new JoseException(e.toString(), e);
            }
        } catch (InvalidAlgorithmParameterException e2) {
            throw new JoseException(e2.toString(), e2);
        } catch (InvalidKeyException e3) {
            throw new JoseException("Invalid key for " + getJavaAlgorithm(), e3);
        }
    }

    @Override // org.jose4j.jwe.ContentEncryptionAlgorithm
    public byte[] decrypt(ContentEncryptionParts contentEncryptionParts, byte[] bArr, byte[] bArr2, Headers headers, ProviderContext providerContext) throws JoseException {
        String cipherProvider = ContentEncryptionHelp.getCipherProvider(headers, providerContext);
        String macProvider = ContentEncryptionHelp.getMacProvider(headers, providerContext);
        byte[] iv = contentEncryptionParts.getIv();
        byte[] ciphertext = contentEncryptionParts.getCiphertext();
        byte[] authenticationTag = contentEncryptionParts.getAuthenticationTag();
        if (!ByteUtil.secureEquals(authenticationTag, ByteUtil.subArray(MacUtil.getInitializedMac(getHmacJavaAlgorithm(), new HmacKey(ByteUtil.leftHalf(bArr2)), macProvider).doFinal(ByteUtil.concat(bArr, iv, ciphertext, getAdditionalAuthenticatedDataLengthBytes(bArr))), 0, getTagTruncationLength()))) {
            throw new IntegrityException("Authentication tag check failed. Message=" + new Base64Url().base64UrlEncode(authenticationTag));
        }
        AesKey aesKey = new AesKey(ByteUtil.rightHalf(bArr2));
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), cipherProvider);
        try {
            cipher.init(2, aesKey, new IvParameterSpec(iv));
            try {
                return cipher.doFinal(ciphertext);
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new JoseException(e.toString(), e);
            }
        } catch (InvalidAlgorithmParameterException e2) {
            throw new JoseException(e2.toString(), e2);
        } catch (InvalidKeyException e3) {
            throw new JoseException("Invalid key for " + getJavaAlgorithm(), e3);
        }
    }

    private byte[] getAdditionalAuthenticatedDataLengthBytes(byte[] bArr) {
        return ByteUtil.getBytes(ByteUtil.bitLength(bArr));
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return CipherStrengthSupport.isAvailable(getJavaAlgorithm(), getContentEncryptionKeyDescriptor().getContentEncryptionKeyByteLength() / 2);
    }

    public static class Aes128CbcHmacSha256 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        public Aes128CbcHmacSha256() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256, 32, "HmacSHA256", 16);
        }
    }

    public static class Aes192CbcHmacSha384 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        public Aes192CbcHmacSha384() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_192_CBC_HMAC_SHA_384, 48, MacUtil.HMAC_SHA384, 24);
        }
    }

    public static class Aes256CbcHmacSha512 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        public Aes256CbcHmacSha512() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_256_CBC_HMAC_SHA_512, 64, MacUtil.HMAC_SHA512, 32);
        }
    }
}
