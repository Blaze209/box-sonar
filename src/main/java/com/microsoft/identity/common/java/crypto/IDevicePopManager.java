package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Date;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* JADX INFO: loaded from: classes14.dex */
public interface IDevicePopManager {
    public static final String MGF_1 = "MGF1";
    public static final String SHA_1 = "SHA-1";

    public enum PublicKeyFormat {
        X_509_SubjectPublicKeyInfo_ASN_1,
        JWK
    }

    boolean asymmetricKeyExists();

    boolean asymmetricKeyExists(String str);

    boolean clearAsymmetricKey();

    String decrypt(Cipher cipher, String str) throws ClientException;

    byte[] decrypt(Cipher cipher, byte[] bArr) throws ClientException;

    String encrypt(Cipher cipher, String str) throws ClientException;

    byte[] encrypt(Cipher cipher, byte[] bArr) throws ClientException;

    String generateAsymmetricKey() throws ClientException;

    void generateAsymmetricKey(TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError);

    Date getAsymmetricKeyCreationDate() throws ClientException;

    String getAsymmetricKeyThumbprint() throws ClientException;

    Certificate[] getCertificateChain() throws ClientException;

    IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> getKeyManager();

    String getPublicKey(PublicKeyFormat publicKeyFormat) throws ClientException;

    PublicKey getPublicKey() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException;

    String getRequestConfirmation() throws ClientException;

    void getRequestConfirmation(TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError);

    SecureHardwareState getSecureHardwareState() throws ClientException;

    String mintSignedAccessToken(String str, long j, URL url, String str2, String str3) throws ClientException;

    String mintSignedAccessToken(String str, long j, URL url, String str2, String str3, String str4) throws ClientException;

    String mintSignedHttpRequest(String str, long j, URL url, String str2, String str3) throws ClientException;

    String sign(SigningAlgorithm signingAlgorithm, String str) throws ClientException;

    byte[] sign(SigningAlgorithm signingAlgorithm, byte[] bArr) throws ClientException;

    boolean verify(SigningAlgorithm signingAlgorithm, String str, String str2);

    boolean verify(SigningAlgorithm signingAlgorithm, byte[] bArr, byte[] bArr2);

    public enum Cipher implements AsymmetricAlgorithm {
        RSA_ECB_PKCS1_PADDING("RSA/ECB/PKCS1Padding"),
        RSA_NONE_OAEPWithSHA_1AndMGF1Padding("RSA/NONE/OAEPWithSHA-1AndMGF1Padding") { // from class: com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher.1
            @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher
            public AlgorithmParameterSpec getParameters() {
                return new OAEPParameterSpec("SHA-1", IDevicePopManager.MGF_1, new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT);
            }
        },
        RSA_ECB_OAEPWithSHA_1AndMGF1Padding("RSA/ECB/OAEPWithSHA-1AndMGF1Padding") { // from class: com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher.2
            @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher
            public AlgorithmParameterSpec getParameters() {
                return new OAEPParameterSpec("SHA-1", IDevicePopManager.MGF_1, new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT);
            }
        },
        RSA_ECB_OAEPWithSHA_256AndMGF1Padding("RSA/ECB/OAEPWithSHA-256AndMGF1Padding") { // from class: com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher.3
            @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher
            public AlgorithmParameterSpec getParameters() {
                return new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT);
            }
        };

        private final String mValue;

        public AlgorithmParameterSpec getParameters() {
            return null;
        }

        public boolean supportsShr() {
            return true;
        }

        Cipher(String str) {
            if (str == null) {
                throw new NullPointerException("value is marked non-null but is null");
            }
            this.mValue = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }

        public Algorithm cipherName() {
            return AsymmetricAlgorithm.Builder.of(this.mValue);
        }
    }
}
