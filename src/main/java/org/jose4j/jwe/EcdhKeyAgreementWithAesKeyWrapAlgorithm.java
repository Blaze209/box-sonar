package org.jose4j.jwe;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwx.Headers;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class EcdhKeyAgreementWithAesKeyWrapAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private EcdhKeyAgreementAlgorithm ecdh;
    private AesKeyWrapManagementAlgorithm keyWrap;
    private ContentEncryptionKeyDescriptor keyWrapKeyDescriptor;

    public EcdhKeyAgreementWithAesKeyWrapAlgorithm(String str, AesKeyWrapManagementAlgorithm aesKeyWrapManagementAlgorithm) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm("N/A");
        setKeyType("EC");
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
        this.keyWrap = aesKeyWrapManagementAlgorithm;
        this.ecdh = new EcdhKeyAgreementAlgorithm("alg");
        this.keyWrapKeyDescriptor = new ContentEncryptionKeyDescriptor(aesKeyWrapManagementAlgorithm.getKeyByteLength(), "AES");
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public ContentEncryptionKeys manageForEncrypt(Key key, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, byte[] bArr, ProviderContext providerContext) throws JoseException {
        ContentEncryptionKeys contentEncryptionKeysManageForEncrypt = this.ecdh.manageForEncrypt(key, this.keyWrapKeyDescriptor, headers, (byte[]) null, providerContext);
        return this.keyWrap.manageForEncrypt(new SecretKeySpec(contentEncryptionKeysManageForEncrypt.getContentEncryptionKey(), this.keyWrapKeyDescriptor.getContentEncryptionKeyAlgorithm()), contentEncryptionKeyDescriptor, headers, bArr, providerContext);
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public Key manageForDecrypt(Key key, byte[] bArr, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, ProviderContext providerContext) throws JoseException {
        return this.keyWrap.manageForDecrypt(this.ecdh.manageForDecrypt(key, ByteUtil.EMPTY_BYTES, this.keyWrapKeyDescriptor, headers, providerContext), bArr, contentEncryptionKeyDescriptor, headers, providerContext);
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public void validateEncryptionKey(Key key, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws InvalidKeyException {
        this.ecdh.validateEncryptionKey(key, contentEncryptionAlgorithm);
    }

    @Override // org.jose4j.jwe.KeyManagementAlgorithm
    public void validateDecryptionKey(Key key, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws InvalidKeyException {
        this.ecdh.validateDecryptionKey(key, contentEncryptionAlgorithm);
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return this.ecdh.isAvailable() && this.keyWrap.isAvailable();
    }

    public static class EcdhKeyAgreementWithAes128KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        public EcdhKeyAgreementWithAes128KeyWrapAlgorithm() {
            super(KeyManagementAlgorithmIdentifiers.ECDH_ES_A128KW, new AesKeyWrapManagementAlgorithm.Aes128().setUseGeneralProviderContext());
        }
    }

    public static class EcdhKeyAgreementWithAes192KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        public EcdhKeyAgreementWithAes192KeyWrapAlgorithm() {
            super(KeyManagementAlgorithmIdentifiers.ECDH_ES_A192KW, new AesKeyWrapManagementAlgorithm.Aes192().setUseGeneralProviderContext());
        }
    }

    public static class EcdhKeyAgreementWithAes256KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        public EcdhKeyAgreementWithAes256KeyWrapAlgorithm() {
            super(KeyManagementAlgorithmIdentifiers.ECDH_ES_A256KW, new AesKeyWrapManagementAlgorithm.Aes256().setUseGeneralProviderContext());
        }
    }
}
