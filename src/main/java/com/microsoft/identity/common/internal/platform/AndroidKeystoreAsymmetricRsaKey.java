package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.exception.ClientException;
import java.security.cert.Certificate;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidKeystoreAsymmetricRsaKey implements AsymmetricRsaKey {
    public static final IDevicePopManager.Cipher RSA_ECB_PKCS_1_PADDING = IDevicePopManager.Cipher.RSA_ECB_PKCS1_PADDING;
    public static final SigningAlgorithm SHA_256_WITH_RSA = SigningAlgorithm.SHA_256_WITH_RSA;
    private final String mAlias;
    private final IDevicePopManager mDevicePopManager;

    AndroidKeystoreAsymmetricRsaKey(IDevicePopManager iDevicePopManager, String str) throws ClientException {
        this.mDevicePopManager = iDevicePopManager;
        this.mAlias = str;
        if (iDevicePopManager.asymmetricKeyExists()) {
            return;
        }
        iDevicePopManager.generateAsymmetricKey();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public Date getCreatedOn() throws ClientException {
        return this.mDevicePopManager.getAsymmetricKeyCreationDate();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String getThumbprint() throws ClientException {
        return this.mDevicePopManager.getAsymmetricKeyThumbprint();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String getPublicKey() throws ClientException {
        return this.mDevicePopManager.getPublicKey(IDevicePopManager.PublicKeyFormat.JWK);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String sign(String str) throws ClientException {
        return this.mDevicePopManager.sign(SHA_256_WITH_RSA, str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public boolean verify(String str, String str2) {
        return this.mDevicePopManager.verify(SHA_256_WITH_RSA, str, str2);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String encrypt(String str) throws ClientException {
        return this.mDevicePopManager.encrypt(RSA_ECB_PKCS_1_PADDING, str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String decrypt(String str) throws ClientException {
        return this.mDevicePopManager.decrypt(RSA_ECB_PKCS_1_PADDING, str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public SecureHardwareState getSecureHardwareState() throws ClientException {
        return this.mDevicePopManager.getSecureHardwareState();
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    public byte[] encrypt(byte[] bArr) throws ClientException {
        return this.mDevicePopManager.encrypt(RSA_ECB_PKCS_1_PADDING, bArr);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    public byte[] decrypt(byte[] bArr) throws ClientException {
        return this.mDevicePopManager.encrypt(RSA_ECB_PKCS_1_PADDING, bArr);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    public byte[] sign(byte[] bArr) throws ClientException {
        return this.mDevicePopManager.sign(SHA_256_WITH_RSA, bArr);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    public boolean verify(byte[] bArr, byte[] bArr2) throws ClientException {
        return this.mDevicePopManager.verify(SHA_256_WITH_RSA, bArr, bArr2);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public Certificate[] getCertificateChain() throws ClientException {
        return this.mDevicePopManager.getCertificateChain();
    }
}
