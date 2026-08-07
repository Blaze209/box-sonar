package org.jose4j.jwe;

import java.security.Key;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmFactoryFactory;
import org.jose4j.jwx.CompactSerializer;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.InvalidAlgorithmException;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.StringUtil;
import org.jose4j.zip.CompressionAlgorithm;
import org.jose4j.zip.CompressionAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes5.dex */
public class JsonWebEncryption extends JsonWebStructure {
    public static final short COMPACT_SERIALIZATION_PARTS = 5;
    byte[] ciphertext;
    byte[] contentEncryptionKey;
    byte[] encryptedKey;
    byte[] iv;
    private byte[] plaintext;
    private Base64Url base64url = new Base64Url();
    private String plaintextCharEncoding = "UTF-8";
    private AlgorithmConstraints contentEncryptionAlgorithmConstraints = AlgorithmConstraints.NO_CONSTRAINTS;

    public void setPlainTextCharEncoding(String str) {
        this.plaintextCharEncoding = str;
    }

    public void setPlaintext(byte[] bArr) {
        this.plaintext = bArr;
    }

    public void setPlaintext(String str) {
        this.plaintext = StringUtil.getBytesUnchecked(str, this.plaintextCharEncoding);
    }

    public String getPlaintextString() throws JoseException {
        return StringUtil.newString(getPlaintextBytes(), this.plaintextCharEncoding);
    }

    public byte[] getPlaintextBytes() throws JoseException {
        if (this.plaintext == null) {
            decrypt();
        }
        return this.plaintext;
    }

    @Override // org.jose4j.jwx.JsonWebStructure
    public String getPayload() throws JoseException {
        return getPlaintextString();
    }

    @Override // org.jose4j.jwx.JsonWebStructure
    public void setPayload(String str) {
        setPlaintext(str);
    }

    public void setEncryptionMethodHeaderParameter(String str) {
        setHeader("enc", str);
    }

    public String getEncryptionMethodHeaderParameter() {
        return getHeader("enc");
    }

    public void setCompressionAlgorithmHeaderParameter(String str) {
        setHeader("zip", str);
    }

    public String getCompressionAlgorithmHeaderParameter() {
        return getHeader("zip");
    }

    public void enableDefaultCompression() {
        setCompressionAlgorithmHeaderParameter(CompressionAlgorithmIdentifiers.DEFLATE);
    }

    public void setContentEncryptionAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.contentEncryptionAlgorithmConstraints = algorithmConstraints;
    }

    public ContentEncryptionAlgorithm getContentEncryptionAlgorithm() throws InvalidAlgorithmException {
        String encryptionMethodHeaderParameter = getEncryptionMethodHeaderParameter();
        if (encryptionMethodHeaderParameter == null) {
            throw new InvalidAlgorithmException("Content encryption header (enc) not set.");
        }
        this.contentEncryptionAlgorithmConstraints.checkConstraint(encryptionMethodHeaderParameter);
        return (ContentEncryptionAlgorithm) AlgorithmFactoryFactory.getInstance().getJweContentEncryptionAlgorithmFactory().getAlgorithm(encryptionMethodHeaderParameter);
    }

    public KeyManagementAlgorithm getKeyManagementModeAlgorithm() throws InvalidAlgorithmException {
        return getKeyManagementModeAlgorithm(true);
    }

    KeyManagementAlgorithm getKeyManagementModeAlgorithm(boolean z) throws InvalidAlgorithmException {
        String algorithmHeaderValue = getAlgorithmHeaderValue();
        if (algorithmHeaderValue == null) {
            throw new InvalidAlgorithmException("Encryption key management algorithm header (alg) not set.");
        }
        if (z) {
            getAlgorithmConstraints().checkConstraint(algorithmHeaderValue);
        }
        return (KeyManagementAlgorithm) AlgorithmFactoryFactory.getInstance().getJweKeyManagementAlgorithmFactory().getAlgorithm(algorithmHeaderValue);
    }

    @Override // org.jose4j.jwx.JsonWebStructure
    public KeyManagementAlgorithm getAlgorithmNoConstraintCheck() throws InvalidAlgorithmException {
        return getKeyManagementModeAlgorithm(false);
    }

    @Override // org.jose4j.jwx.JsonWebStructure
    public KeyManagementAlgorithm getAlgorithm() throws InvalidAlgorithmException {
        return getKeyManagementModeAlgorithm();
    }

    @Override // org.jose4j.jwx.JsonWebStructure
    protected void setCompactSerializationParts(String[] strArr) throws JoseException {
        if (strArr.length != 5) {
            throw new JoseException("A JWE Compact Serialization must have exactly 5 parts separated by period ('.') characters");
        }
        setEncodedHeader(strArr[0]);
        this.encryptedKey = this.base64url.base64UrlDecode(strArr[1]);
        setEncodedIv(strArr[2]);
        String str = strArr[3];
        checkNotEmptyPart(str, "Encoded JWE Ciphertext");
        this.ciphertext = this.base64url.base64UrlDecode(str);
        String str2 = strArr[4];
        checkNotEmptyPart(str2, "Encoded JWE Authentication Tag");
        setIntegrity(this.base64url.base64UrlDecode(str2));
    }

    private void decrypt() throws JoseException {
        KeyManagementAlgorithm keyManagementModeAlgorithm = getKeyManagementModeAlgorithm();
        ContentEncryptionAlgorithm contentEncryptionAlgorithm = getContentEncryptionAlgorithm();
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor = contentEncryptionAlgorithm.getContentEncryptionKeyDescriptor();
        if (isDoKeyValidation()) {
            keyManagementModeAlgorithm.validateDecryptionKey(getKey(), contentEncryptionAlgorithm);
        }
        checkCrit();
        setPlaintext(decompress(getHeaders(), contentEncryptionAlgorithm.decrypt(new ContentEncryptionParts(this.iv, this.ciphertext, getIntegrity()), getEncodedHeaderAsciiBytesForAdditionalAuthenticatedData(), keyManagementModeAlgorithm.manageForDecrypt(getKey(), getEncryptedKey(), contentEncryptionKeyDescriptor, getHeaders(), getProviderCtx()).getEncoded(), getHeaders(), getProviderCtx())));
    }

    public byte[] getEncryptedKey() {
        return this.encryptedKey;
    }

    byte[] getEncodedHeaderAsciiBytesForAdditionalAuthenticatedData() {
        return StringUtil.getBytesAscii(getEncodedHeader());
    }

    byte[] decompress(Headers headers, byte[] bArr) throws JoseException {
        String stringHeaderValue = headers.getStringHeaderValue("zip");
        return stringHeaderValue != null ? ((CompressionAlgorithm) AlgorithmFactoryFactory.getInstance().getCompressionAlgorithmFactory().getAlgorithm(stringHeaderValue)).decompress(bArr) : bArr;
    }

    byte[] compress(Headers headers, byte[] bArr) throws InvalidAlgorithmException {
        String stringHeaderValue = headers.getStringHeaderValue("zip");
        return stringHeaderValue != null ? ((CompressionAlgorithm) AlgorithmFactoryFactory.getInstance().getCompressionAlgorithmFactory().getAlgorithm(stringHeaderValue)).compress(bArr) : bArr;
    }

    @Override // org.jose4j.jwx.JsonWebStructure
    public String getCompactSerialization() throws JoseException {
        KeyManagementAlgorithm keyManagementModeAlgorithm = getKeyManagementModeAlgorithm();
        ContentEncryptionAlgorithm contentEncryptionAlgorithm = getContentEncryptionAlgorithm();
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor = contentEncryptionAlgorithm.getContentEncryptionKeyDescriptor();
        Key key = getKey();
        if (isDoKeyValidation()) {
            keyManagementModeAlgorithm.validateEncryptionKey(getKey(), contentEncryptionAlgorithm);
        }
        ContentEncryptionKeys contentEncryptionKeysManageForEncrypt = keyManagementModeAlgorithm.manageForEncrypt(key, contentEncryptionKeyDescriptor, getHeaders(), this.contentEncryptionKey, getProviderCtx());
        setContentEncryptionKey(contentEncryptionKeysManageForEncrypt.getContentEncryptionKey());
        this.encryptedKey = contentEncryptionKeysManageForEncrypt.getEncryptedKey();
        byte[] encodedHeaderAsciiBytesForAdditionalAuthenticatedData = getEncodedHeaderAsciiBytesForAdditionalAuthenticatedData();
        byte[] contentEncryptionKey = contentEncryptionKeysManageForEncrypt.getContentEncryptionKey();
        byte[] bArr = this.plaintext;
        if (bArr == null) {
            throw new NullPointerException("The plaintext payload for the JWE has not been set.");
        }
        ContentEncryptionParts contentEncryptionPartsEncrypt = contentEncryptionAlgorithm.encrypt(compress(getHeaders(), bArr), encodedHeaderAsciiBytesForAdditionalAuthenticatedData, contentEncryptionKey, getHeaders(), getIv(), getProviderCtx());
        setIv(contentEncryptionPartsEncrypt.getIv());
        this.ciphertext = contentEncryptionPartsEncrypt.getCiphertext();
        return CompactSerializer.serialize(getEncodedHeader(), this.base64url.base64UrlEncode(contentEncryptionKeysManageForEncrypt.getEncryptedKey()), this.base64url.base64UrlEncode(contentEncryptionPartsEncrypt.getIv()), this.base64url.base64UrlEncode(contentEncryptionPartsEncrypt.getCiphertext()), this.base64url.base64UrlEncode(contentEncryptionPartsEncrypt.getAuthenticationTag()));
    }

    public byte[] getContentEncryptionKey() {
        return this.contentEncryptionKey;
    }

    public void setContentEncryptionKey(byte[] bArr) {
        this.contentEncryptionKey = bArr;
    }

    public void setEncodedContentEncryptionKey(String str) {
        setContentEncryptionKey(Base64Url.decode(str));
    }

    public byte[] getIv() {
        return this.iv;
    }

    public void setIv(byte[] bArr) {
        this.iv = bArr;
    }

    public void setEncodedIv(String str) {
        setIv(this.base64url.base64UrlDecode(str));
    }
}
