package com.microsoft.identity.common.java.platform;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.base64.Base64Flags;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.marker.CodeMarkerManager;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractDevicePopManager implements IDevicePopManager {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    public static final String DEFAULT_KEYSTORE_ENTRY_ALIAS = "microsoft-device-pop";
    public static final String NEGATIVE_THIRTY_THREE_INTERNAL_ERROR_MSG = "internal Keystore code: -33";
    private static final String PRIVATE_KEY_NOT_FOUND = "Not an instance of a PrivateKeyEntry";
    private static final int RSA_KEY_SIZE = 2048;
    public static final String STRONG_BOX_UNAVAILABLE_EXCEPTION = "StrongBoxUnavailableException";
    private static final String TAG = "AbstractDevicePopManager";
    protected final IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> mKeyManager;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    public static final Type MAP_STRING_STRING_TYPE = TypeToken.getParameterized(Map.class, String.class, String.class).getType();
    public static final Gson GSON = new Gson();
    private static final ExecutorService sThreadExecutor = Executors.newFixedThreadPool(5);
    private static final CodeMarkerManager sCodeMarkerManager = CodeMarkerManager.getInstance();

    public abstract KeyPair generateNewRsaKeyPair(int i) throws UnsupportedOperationException, NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException, InvalidAlgorithmParameterException, ClientException;

    protected abstract SecureHardwareState getSecureHardwareState(KeyPair keyPair);

    protected abstract void performCleanupIfMintShrFails(Exception exc);

    protected static final class CertificateProperties {
        public static final int CERTIFICATE_VALIDITY_YEARS = 99;
        public static final String COMMON_NAME = "CN=device-pop";
        public static final String COUNTRY = "US";
        public static final String ORGANIZATION_NAME = "Microsoft Corporation";
        public static final String ORGANIZATION_UNIT = "Identity";
        public static final BigInteger SERIAL_NUMBER = BigInteger.ONE;

        protected CertificateProperties() {
        }
    }

    private static final class SignedHttpRequestJwtClaims {
        private static final String ACCESS_TOKEN = "at";
        private static final String CLIENT_CLAIMS = "client_claims";
        private static final String CNF = "cnf";
        private static final String HTTP_HOST = "u";
        private static final String HTTP_METHOD = "m";
        private static final String HTTP_PATH = "p";
        public static final String JWK = "jwk";
        private static final String NONCE = "nonce";
        private static final String TIMESTAMP = "ts";

        private SignedHttpRequestJwtClaims() {
        }
    }

    protected static final class KeyPairGeneratorAlgorithms {
        public static final String RSA = "RSA";

        protected KeyPairGeneratorAlgorithms() {
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> getKeyManager() {
        return this.mKeyManager;
    }

    public AbstractDevicePopManager(IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> iKeyStoreKeyManager) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (iKeyStoreKeyManager == null) {
            throw new NullPointerException("keyManager is marked non-null but is null");
        }
        this.mKeyManager = iKeyStoreKeyManager;
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean asymmetricKeyExists() {
        return this.mKeyManager.exists();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean asymmetricKeyExists(String str) {
        if (str == null) {
            throw new NullPointerException("thumbprint is marked non-null but is null");
        }
        return this.mKeyManager.hasThumbprint(str.getBytes(UTF8));
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String getAsymmetricKeyThumbprint() throws ClientException {
        return new String(this.mKeyManager.getThumbprint(), UTF8);
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public void generateAsymmetricKey(final TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError) {
        if (taskCompletedCallbackWithError == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        sThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.platform.AbstractDevicePopManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    taskCompletedCallbackWithError.onTaskCompleted(AbstractDevicePopManager.this.generateAsymmetricKey());
                } catch (ClientException e) {
                    taskCompletedCallbackWithError.onError(e);
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String generateAsymmetricKey() throws ClientException {
        String str;
        String str2 = TAG + ":generateAsymmetricKey";
        try {
            CodeMarkerManager codeMarkerManager = sCodeMarkerManager;
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_START);
            String thumbprintForRsaKey = AbstractKeyStoreKeyManager.getThumbprintForRsaKey(AbstractKeyStoreKeyManager.getRsaKeyForKeyPair(generateNewRsaKeyPair(2048)));
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            return thumbprintForRsaKey;
        } catch (JOSEException e) {
            e = e;
            str = ClientException.THUMBPRINT_COMPUTATION_FAILURE;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException.getMessage(), clientException);
            throw clientException;
        } catch (UnsupportedOperationException e2) {
            e = e2;
            str = ClientException.BAD_KEY_SIZE;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            str = ClientException.INVALID_ALG;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException3.getMessage(), clientException3);
            throw clientException3;
        } catch (KeyStoreException e4) {
            e = e4;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException4 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException4.getMessage(), clientException4);
            throw clientException4;
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            str = "no_such_algorithm";
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException5 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException5.getMessage(), clientException5);
            throw clientException5;
        } catch (NoSuchProviderException e6) {
            e = e6;
            str = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException6 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException6.getMessage(), clientException6);
            throw clientException6;
        } catch (Throwable th) {
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public Date getAsymmetricKeyCreationDate() throws ClientException {
        return this.mKeyManager.getCreationDate();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean clearAsymmetricKey() {
        return this.mKeyManager.clear();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String getRequestConfirmation() throws ClientException {
        String str = TAG + ":getRequestConfirmation";
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        final ClientException[] clientExceptionArr = new ClientException[1];
        getRequestConfirmation(new TaskCompletedCallbackWithError<String, ClientException>() { // from class: com.microsoft.identity.common.java.platform.AbstractDevicePopManager.2
            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(String str2) {
                if (str2 == null) {
                    throw new NullPointerException("reqCnf is marked non-null but is null");
                }
                strArr[0] = str2;
                countDownLatch.countDown();
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(ClientException clientException) {
                if (clientException == null) {
                    throw new NullPointerException("error is marked non-null but is null");
                }
                clientExceptionArr[0] = clientException;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            String str2 = strArr[0];
            if (str2 != null) {
                return str2;
            }
            throw clientExceptionArr[0];
        } catch (InterruptedException e) {
            Logger.error(str, "Interrupted while waiting on callback.", e);
            throw new ClientException(ClientException.INTERRUPTED_OPERATION, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public void getRequestConfirmation(final TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError) {
        if (taskCompletedCallbackWithError == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        final String str = TAG + ":getRequestConfirmation";
        sThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.platform.AbstractDevicePopManager.3
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                try {
                    taskCompletedCallbackWithError.onTaskCompleted(AbstractDevicePopManager.getReqCnfForRsaKey(AbstractKeyStoreKeyManager.getRsaKeyForKeyPair(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) AbstractDevicePopManager.this.mKeyManager.getEntry()))));
                } catch (JOSEException e) {
                    e = e;
                    str2 = ClientException.THUMBPRINT_COMPUTATION_FAILURE;
                    ClientException clientException = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str, clientException.getMessage(), clientException);
                    taskCompletedCallbackWithError.onError(clientException);
                } catch (KeyStoreException e2) {
                    e = e2;
                    str2 = ClientException.KEYSTORE_NOT_INITIALIZED;
                    ClientException clientException2 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str, clientException2.getMessage(), clientException2);
                    taskCompletedCallbackWithError.onError(clientException2);
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    str2 = "no_such_algorithm";
                    ClientException clientException3 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str, clientException3.getMessage(), clientException3);
                    taskCompletedCallbackWithError.onError(clientException3);
                } catch (UnrecoverableEntryException e4) {
                    e = e4;
                    str2 = ClientException.INVALID_PROTECTION_PARAMS;
                    ClientException clientException4 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str, clientException4.getMessage(), clientException4);
                    taskCompletedCallbackWithError.onError(clientException4);
                } catch (JSONException e5) {
                    e = e5;
                    str2 = ClientException.JSON_CONSTRUCTION_FAILED;
                    ClientException clientException5 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str, clientException5.getMessage(), clientException5);
                    taskCompletedCallbackWithError.onError(clientException5);
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String sign(SigningAlgorithm signingAlgorithm, String str) throws ClientException {
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (str != null) {
            return Base64Util.encodeToString(sign(signingAlgorithm, str.getBytes(UTF8)), Base64Flags.NO_WRAP);
        }
        throw new NullPointerException("input is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public byte[] sign(SigningAlgorithm signingAlgorithm, byte[] bArr) throws ClientException {
        String str;
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (bArr == null) {
            throw new NullPointerException("inputBytesToSign is marked non-null but is null");
        }
        String str2 = TAG + ":sign";
        try {
            KeyStore.Entry entry = this.mKeyManager.getEntry();
            if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
                Logger.warn(str2, PRIVATE_KEY_NOT_FOUND);
                throw new ClientException(ClientException.INVALID_KEY_MISSING);
            }
            Signature signature = Signature.getInstance(signingAlgorithm.toString());
            signature.initSign(((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException e) {
            e = e;
            str = ClientException.INVALID_KEY;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException.getMessage(), clientException);
            throw clientException;
        } catch (KeyStoreException e2) {
            e = e2;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str = "no_such_algorithm";
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException3.getMessage(), clientException3);
            throw clientException3;
        } catch (SignatureException e4) {
            e = e4;
            str = ClientException.SIGNING_FAILURE;
            ClientException clientException4 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException4.getMessage(), clientException4);
            throw clientException4;
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException5 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException5.getMessage(), clientException5);
            throw clientException5;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean verify(SigningAlgorithm signingAlgorithm, String str, String str2) {
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("plainText is marked non-null but is null");
        }
        if (str2 != null) {
            return verify(signingAlgorithm, str.getBytes(UTF8), Base64Util.decode(str2, Base64Flags.NO_WRAP));
        }
        throw new NullPointerException("signatureStr is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean verify(SigningAlgorithm signingAlgorithm, byte[] bArr, byte[] bArr2) {
        String str;
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (bArr == null) {
            throw new NullPointerException("inputBytesToVerify is marked non-null but is null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("signatureBytes is marked non-null but is null");
        }
        String str2 = TAG + ":verify";
        try {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry();
            if (privateKeyEntry == null) {
                Logger.warn(str2, PRIVATE_KEY_NOT_FOUND);
                return false;
            }
            Signature signature = Signature.getInstance(signingAlgorithm.toString());
            signature.initVerify(privateKeyEntry.getCertificate());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException e) {
            e = e;
            str = ClientException.INVALID_KEY;
            Logger.error(str2, str, e);
            return false;
        } catch (KeyStoreException e2) {
            e = e2;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            Logger.error(str2, str, e);
            return false;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str = "no_such_algorithm";
            Logger.error(str2, str, e);
            return false;
        } catch (SignatureException e4) {
            e = e4;
            str = ClientException.SIGNING_FAILURE;
            Logger.error(str2, str, e);
            return false;
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            Logger.error(str2, str, e);
            return false;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String encrypt(IDevicePopManager.Cipher cipher, String str) throws ClientException {
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        if (str != null) {
            return Base64Util.encodeToString(encrypt(cipher, str.getBytes(UTF8)), Base64Flags.NO_PADDING, Base64Flags.NO_WRAP);
        }
        throw new NullPointerException("plaintext is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public byte[] encrypt(IDevicePopManager.Cipher cipher, byte[] bArr) throws ClientException {
        String str;
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        if (bArr == null) {
            throw new NullPointerException("plaintext is marked non-null but is null");
        }
        String str2 = TAG + ":encrypt";
        try {
            PublicKey publicKey = ((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getCertificate().getPublicKey();
            Cipher cipher2 = Cipher.getInstance(cipher.toString());
            if (cipher.getParameters() != null) {
                cipher2.init(1, publicKey, cipher.getParameters());
            } else {
                cipher2.init(1, publicKey);
            }
            return cipher2.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            str = ClientException.INVALID_ALG_PARAMETER;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException;
        } catch (InvalidKeyException e2) {
            e = e2;
            str = ClientException.INVALID_KEY;
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException2;
        } catch (KeyStoreException e3) {
            e = e3;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException3;
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            str = "no_such_algorithm";
            ClientException clientException4 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException4;
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException5 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException5;
        } catch (BadPaddingException e6) {
            e = e6;
            str = ClientException.BAD_PADDING;
            ClientException clientException6 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException6;
        } catch (IllegalBlockSizeException e7) {
            e = e7;
            str = ClientException.INVALID_BLOCK_SIZE;
            ClientException clientException7 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException7;
        } catch (NoSuchPaddingException e8) {
            e = e8;
            str = ClientException.NO_SUCH_PADDING;
            ClientException clientException8 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException8;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String decrypt(IDevicePopManager.Cipher cipher, String str) throws ClientException {
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("ciphertext is marked non-null but is null");
        }
        return new String(decrypt(cipher, Base64Util.decode(str, Base64Flags.NO_PADDING, Base64Flags.NO_WRAP)), UTF8);
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public byte[] decrypt(IDevicePopManager.Cipher cipher, byte[] bArr) throws ClientException {
        String str = "no_such_algorithm";
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        String str2 = TAG + ":decrypt";
        try {
            PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getPrivateKey();
            Cipher cipher2 = Cipher.getInstance(cipher.toString());
            if (cipher.getParameters() != null) {
                cipher2.init(2, privateKey, cipher.getParameters());
            } else {
                cipher2.init(2, privateKey);
            }
            return cipher2.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            str = ClientException.INVALID_ALG_PARAMETER;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException;
        } catch (InvalidKeyException e2) {
            e = e2;
            str = ClientException.INVALID_KEY;
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException2;
        } catch (KeyStoreException e3) {
            e = e3;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException3;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e4) {
            e = e4;
            ClientException clientException4 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException4;
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException5 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException5;
        } catch (BadPaddingException e6) {
            e = e6;
            str = ClientException.BAD_PADDING;
            ClientException clientException6 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException6;
        } catch (IllegalBlockSizeException e7) {
            e = e7;
            str = ClientException.INVALID_BLOCK_SIZE;
            ClientException clientException7 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException7;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public SecureHardwareState getSecureHardwareState() throws ClientException {
        String str;
        String str2 = TAG + ":getSecureHardwareState";
        try {
            return getSecureHardwareState(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()));
        } catch (KeyStoreException e) {
            e = e;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException2;
        } catch (UnrecoverableEntryException e3) {
            e = e3;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, str, e);
            throw clientException3;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String getPublicKey(IDevicePopManager.PublicKeyFormat publicKeyFormat) throws ClientException {
        if (publicKeyFormat == null) {
            throw new NullPointerException("format is marked non-null but is null");
        }
        String str = TAG + ":getPublicKey";
        int i = AnonymousClass4.$SwitchMap$com$microsoft$identity$common$java$crypto$IDevicePopManager$PublicKeyFormat[publicKeyFormat.ordinal()];
        if (i == 1) {
            return getX509SubjectPublicKeyInfo();
        }
        if (i == 2) {
            return getJwkPublicKey();
        }
        String str2 = "Unrecognized or unsupported key format: " + publicKeyFormat;
        ClientException clientException = new ClientException(ClientException.UNKNOWN_EXPORT_FORMAT, str2);
        Logger.error(str, str2, clientException);
        throw clientException;
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.platform.AbstractDevicePopManager$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$crypto$IDevicePopManager$PublicKeyFormat;

        static {
            int[] iArr = new int[IDevicePopManager.PublicKeyFormat.values().length];
            $SwitchMap$com$microsoft$identity$common$java$crypto$IDevicePopManager$PublicKeyFormat = iArr;
            try {
                iArr[IDevicePopManager.PublicKeyFormat.X_509_SubjectPublicKeyInfo_ASN_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$crypto$IDevicePopManager$PublicKeyFormat[IDevicePopManager.PublicKeyFormat.JWK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public Certificate[] getCertificateChain() throws ClientException {
        return this.mKeyManager.getCertificateChain();
    }

    private String getJwkPublicKey() throws ClientException {
        String str;
        String str2 = TAG + ":getJwkPublicKey";
        try {
            return GSON.toJson(getDevicePopJwkMinifiedJson().get("jwk"), MAP_STRING_STRING_TYPE);
        } catch (KeyStoreException e) {
            e = e;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException.getMessage(), clientException);
            throw clientException;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (UnrecoverableEntryException e3) {
            e = e3;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException3.getMessage(), clientException3);
            throw clientException3;
        }
    }

    private String getX509SubjectPublicKeyInfo() throws ClientException {
        String str;
        String str2 = TAG + ":getX509SubjectPublicKeyInfo";
        try {
            return new String(Base64Util.encode(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getPublic().getEncoded(), Base64Flags.DEFAULT), AuthenticationConstants.CHARSET_UTF8);
        } catch (KeyStoreException e) {
            e = e;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException.getMessage(), clientException);
            throw clientException;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (UnrecoverableEntryException e3) {
            e = e3;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException3 = new ClientException(str, e.getMessage(), e);
            Logger.error(str2, clientException3.getMessage(), clientException3);
            throw clientException3;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String mintSignedAccessToken(String str, long j, URL url, String str2, String str3) throws ClientException {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        return mintSignedAccessToken(str, j, url, str2, str3, null);
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String mintSignedAccessToken(String str, long j, URL url, String str2, String str3, String str4) throws ClientException {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        return mintSignedHttpRequestInternal(str, j, url, str2, str3, str4);
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String mintSignedHttpRequest(String str, long j, URL url, String str2, String str3) throws ClientException {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        return mintSignedHttpRequestInternal(str, j, url, null, str2, str3);
    }

    private String mintSignedHttpRequestInternal(String str, long j, URL url, String str2, String str3, String str4) throws ClientException {
        String str5;
        Exception exc;
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        String str6 = TAG + ":mintSignedHttpRequestInternal";
        try {
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            if (!StringUtil.isNullOrEmpty(str2)) {
                builder.claim("at", str2);
            }
            builder.claim("ts", Long.valueOf(j));
            builder.claim("u", url.getAuthority());
            builder.claim("cnf", getDevicePopJwkMinifiedJson());
            if (!StringUtil.isNullOrEmpty(url.getPath())) {
                builder.claim("p", url.getPath());
            }
            if (!StringUtil.isNullOrEmpty(str)) {
                builder.claim(CmcdData.OBJECT_TYPE_MANIFEST, str);
            }
            if (!StringUtil.isNullOrEmpty(str3)) {
                builder.claim("nonce", str3);
            }
            if (!StringUtil.isNullOrEmpty(str4)) {
                builder.claim(PopAuthenticationSchemeInternal.SerializedNames.CLIENT_CLAIMS, str4);
            }
            JWTClaimsSet jWTClaimsSetBuild = builder.build();
            RSASSASigner rSASSASigner = new RSASSASigner(((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getPrivateKey());
            SignedJWT signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(getAsymmetricKeyThumbprint()).build(), jWTClaimsSetBuild);
            signedJWT.sign(rSASSASigner);
            return signedJWT.serialize();
        } catch (JOSEException e) {
            if (isNegativeInternalError(e) || ((e.getCause() != null && isNegativeInternalError(e.getCause())) || (e.getCause().getCause() != null && isNegativeInternalError(e.getCause().getCause())))) {
                Logger.error(str6, "Getting Invalid key blob, Invalid private RSA key.", e);
                Logger.info(str6, "Unable to access asymmetric key, clearing the key.");
                clearAsymmetricKey();
                Logger.info(str6, "Generating new PoP asymmetric key.");
                String strGenerateAsymmetricKey = generateAsymmetricKey();
                Logger.info(str6, "Generated new PoP asymmetric key.");
                Logger.verbosePII(str6, "Generated new PoP asymmetric key with thumbprint: " + strGenerateAsymmetricKey);
            }
            str5 = ClientException.JWT_SIGNING_FAILURE;
            exc = e;
            performCleanupIfMintShrFails(exc);
            ClientException clientException = new ClientException(str5, exc.getMessage(), exc);
            Logger.error(str6, clientException.getMessage(), clientException);
            throw clientException;
        } catch (KeyStoreException e2) {
            str5 = ClientException.KEYSTORE_NOT_INITIALIZED;
            exc = e2;
            performCleanupIfMintShrFails(exc);
            ClientException clientException2 = new ClientException(str5, exc.getMessage(), exc);
            Logger.error(str6, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (NoSuchAlgorithmException e3) {
            str5 = "no_such_algorithm";
            exc = e3;
            performCleanupIfMintShrFails(exc);
            ClientException clientException3 = new ClientException(str5, exc.getMessage(), exc);
            Logger.error(str6, clientException3.getMessage(), clientException3);
            throw clientException3;
        } catch (UnrecoverableEntryException e4) {
            str5 = ClientException.INVALID_PROTECTION_PARAMS;
            exc = e4;
            performCleanupIfMintShrFails(exc);
            ClientException clientException4 = new ClientException(str5, exc.getMessage(), exc);
            Logger.error(str6, clientException4.getMessage(), clientException4);
            throw clientException4;
        }
    }

    private static boolean isNegativeInternalError(Throwable th) {
        if (th == null) {
            throw new NullPointerException("t is marked non-null but is null");
        }
        if (th.getMessage() == null || !th.getMessage().contains(NEGATIVE_THIRTY_THREE_INTERNAL_ERROR_MSG)) {
            return false;
        }
        Logger.info(TAG, "Found internal Keystore code: -33 error.");
        return true;
    }

    protected static Date getNow(Calendar calendar) {
        if (calendar == null) {
            throw new NullPointerException("calendar is marked non-null but is null");
        }
        return calendar.getTime();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public PublicKey getPublicKey() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        return ((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getCertificate().getPublicKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getReqCnfForRsaKey(RSAKey rSAKey) throws JSONException, JOSEException {
        if (rSAKey == null) {
            throw new NullPointerException("rsaKey is marked non-null but is null");
        }
        return base64UrlEncode(new JSONObject().put("kid", AbstractKeyStoreKeyManager.getThumbprintForRsaKey(rSAKey)).toString());
    }

    private static String base64UrlEncode(String str) {
        if (str != null) {
            return Base64Util.encodeToString(str.getBytes(UTF8), Base64Flags.NO_PADDING, Base64Flags.NO_WRAP, Base64Flags.URL_SAFE);
        }
        throw new NullPointerException("input is marked non-null but is null");
    }

    private Map<String, Object> getDevicePopJwkMinifiedJson() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        Map<String, Object> jSONObject = AbstractKeyStoreKeyManager.getRsaKeyForKeyPair(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry())).toPublicJWK().toJSONObject();
        HashMap map = new HashMap();
        map.put("jwk", jSONObject);
        return map;
    }
}
