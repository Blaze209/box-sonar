package com.microsoft.identity.common.internal.util;

import android.os.Build;
import android.security.keystore.KeyInfo;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.util.ThrowableUtil;
import com.microsoft.identity.common.java.util.ported.DateUtilities;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidKeyStoreUtil {
    private static final String ANDROID_KEY_STORE_TYPE = "AndroidKeyStore";
    private static int KEYSTORE_EXCEPTION_CAUSE_CHAIN_MAX_DEPTH = 20;
    private static final String TAG = "AndroidKeyStoreUtil";
    private static final LongCounter sFailedAndroidKeyStoreUnwrapOperationCount = OTelUtility.createLongCounter("failed_keystore_key_unwrap_operation_count", "Number of failed Android KeyStore unwrap operations");

    private AndroidKeyStoreUtil() {
    }

    private static synchronized KeyStore getKeyStore() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore;
        keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_TYPE);
        keyStore.load(null);
        return keyStore;
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static synchronized KeyPair generateKeyPair(String str, AlgorithmParameterSpec algorithmParameterSpec) throws ClientException {
        String str2;
        KeyPair keyPairGenerateKeyPair;
        try {
            if (str == null) {
                throw new NullPointerException("algorithm is marked non-null but is null");
            }
            if (algorithmParameterSpec == null) {
                throw new NullPointerException("algorithmSpec is marked non-null but is null");
            }
            String str3 = TAG + ":generateKeyPair";
            synchronized ((DateUtilities.isLocaleCalendarNonGregorian(Locale.getDefault()) ? DateUtilities.LOCALE_CHANGE_LOCK : new Object())) {
                Locale locale = Locale.getDefault();
                applyKeyStoreLocaleWorkarounds(locale);
                try {
                    Logger.info(str3, "Generating KeyPair from KeyStore");
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str, ANDROID_KEY_STORE_TYPE);
                    keyPairGenerator.initialize(algorithmParameterSpec);
                    keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                    if (keyPairGenerateKeyPair == null) {
                        Logger.error(str3, "Failed to generate a keypair. The way we're generating it might be incorrect.", null);
                        throw new ClientException(ClientException.INVALID_KEY, "Failed to generate a keypair");
                    }
                    Locale.setDefault(locale);
                } catch (IllegalStateException e) {
                    e = e;
                    str2 = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
                    Locale.setDefault(locale);
                    ClientException clientException = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str3, str2, e);
                    throw clientException;
                } catch (InvalidAlgorithmParameterException e2) {
                    e = e2;
                    str2 = ClientException.INVALID_ALG_PARAMETER;
                    Locale.setDefault(locale);
                    ClientException clientException2 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str3, str2, e);
                    throw clientException2;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    str2 = "no_such_algorithm";
                    Locale.setDefault(locale);
                    ClientException clientException3 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str3, str2, e);
                    throw clientException3;
                } catch (NoSuchProviderException e4) {
                    e = e4;
                    str2 = ClientException.NO_SUCH_PROVIDER;
                    Locale.setDefault(locale);
                    ClientException clientException4 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str3, str2, e);
                    throw clientException4;
                } catch (Throwable th) {
                    e = th;
                    str2 = ClientException.UNKNOWN_CRYPTO_ERROR;
                    Locale.setDefault(locale);
                    ClientException clientException5 = new ClientException(str2, e.getMessage(), e);
                    Logger.error(str3, str2, e);
                    throw clientException5;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return keyPairGenerateKeyPair;
    }

    public static synchronized boolean canLoadKey(String str) {
        if (str == null) {
            throw new NullPointerException("keyAlias is marked non-null but is null");
        }
        String str2 = TAG + ":hasKey";
        try {
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            Logger.error(str2, "Failed to check keystore key", e);
            return false;
        }
        return getKeyStore().containsAlias(str);
    }

    public static synchronized KeyPair readKey(String str) throws ClientException {
        String str2;
        try {
            if (str == null) {
                throw new NullPointerException("keyAlias is marked non-null but is null");
            }
            String str3 = TAG + ":readKeyPair";
            try {
                KeyStore keyStore = getKeyStore();
                if (!keyStore.containsAlias(str)) {
                    Logger.verbose(str3, "Alias doesn't exist.");
                    return null;
                }
                Key key = keyStore.getKey(str, null);
                if (key == null) {
                    Logger.verbose(str3, "Private key entry doesn't exist.");
                    return null;
                }
                Certificate certificate = keyStore.getCertificate(str);
                if (certificate == null) {
                    Logger.verbose(str3, "Public key entry doesn't exist.");
                    return null;
                }
                return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
            } catch (IOException e) {
                e = e;
                str2 = "io_error";
                ClientException clientException = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException;
            } catch (RuntimeException e2) {
                e = e2;
                str2 = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
                ClientException clientException2 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException2;
            } catch (KeyStoreException e3) {
                e = e3;
                str2 = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
                ClientException clientException3 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException3;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                str2 = "no_such_algorithm";
                ClientException clientException4 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException4;
            } catch (UnrecoverableKeyException e5) {
                e = e5;
                str2 = ClientException.INVALID_KEY_MISSING;
                ClientException clientException5 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException5;
            } catch (CertificateException e6) {
                e = e6;
                str2 = ClientException.CERTIFICATE_LOAD_FAILURE;
                ClientException clientException6 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException6;
            } catch (Throwable th) {
                e = th;
                str2 = ClientException.UNKNOWN_CRYPTO_ERROR;
                ClientException clientException7 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException7;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void applyKeyStoreLocaleWorkarounds(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("currentLocale is marked non-null but is null");
        }
    }

    public static synchronized void deleteKey(String str) throws ClientException {
        String str2;
        try {
            if (str == null) {
                throw new NullPointerException("aliasOfKeyToDelete is marked non-null but is null");
            }
            String str3 = TAG + ":deleteKeyFromKeyStore";
            try {
                getKeyStore().deleteEntry(str);
            } catch (IOException e) {
                e = e;
                str2 = "io_error";
                ClientException clientException = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException;
            } catch (KeyStoreException e2) {
                e = e2;
                str2 = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
                ClientException clientException2 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException2;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                str2 = "no_such_algorithm";
                ClientException clientException3 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException3;
            } catch (CertificateException e4) {
                e = e4;
                str2 = ClientException.CERTIFICATE_LOAD_FAILURE;
                ClientException clientException4 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException4;
            } catch (Throwable th) {
                e = th;
                str2 = ClientException.UNKNOWN_CRYPTO_ERROR;
                ClientException clientException5 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException5;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized byte[] wrap(SecretKey secretKey, KeyPair keyPair, String str, AlgorithmParameterSpec algorithmParameterSpec) throws ClientException {
        String str2;
        Cipher cipher;
        try {
            if (secretKey == null) {
                throw new NullPointerException("key is marked non-null but is null");
            }
            if (keyPair == null) {
                throw new NullPointerException("keyToWrap is marked non-null but is null");
            }
            if (str == null) {
                throw new NullPointerException("wrapAlgorithm is marked non-null but is null");
            }
            String str3 = TAG + ":wrap";
            try {
                Logger.verbose(str3, "Wrap secret key with a KeyPair.");
                cipher = Cipher.getInstance(str);
                if (algorithmParameterSpec != null) {
                    cipher.init(3, keyPair.getPublic(), algorithmParameterSpec);
                } else {
                    cipher.init(3, keyPair.getPublic());
                }
            } catch (InvalidKeyException e) {
                e = e;
                str2 = ClientException.INVALID_KEY;
                ClientException clientException = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException;
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                str2 = "no_such_algorithm";
                ClientException clientException2 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException2;
            } catch (IllegalBlockSizeException e3) {
                e = e3;
                str2 = ClientException.INVALID_BLOCK_SIZE;
                ClientException clientException3 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException3;
            } catch (NoSuchPaddingException e4) {
                e = e4;
                str2 = ClientException.NO_SUCH_PADDING;
                ClientException clientException4 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException4;
            } catch (Throwable th) {
                e = th;
                str2 = ClientException.UNKNOWN_CRYPTO_ERROR;
                ClientException clientException5 = new ClientException(str2, e.getMessage(), e);
                Logger.error(str3, str2, e);
                throw clientException5;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return cipher.wrap(secretKey);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005e A[Catch: all -> 0x00a5, TryCatch #1 {all -> 0x00a5, blocks: (B:7:0x0009, B:25:0x0051, B:27:0x005e, B:28:0x0087, B:29:0x008a, B:30:0x008b, B:31:0x0093, B:32:0x0094, B:33:0x009b, B:34:0x009c, B:35:0x00a4), top: B:39:0x0003 }] */
    public static synchronized SecretKey unwrap(byte[] bArr, String str, KeyPair keyPair, String str2, AlgorithmParameterSpec algorithmParameterSpec) throws ClientException {
        String str3;
        Cipher cipher;
        try {
            if (str == null) {
                throw new NullPointerException("wrappedKeyAlgorithm is marked non-null but is null");
            }
            if (keyPair == null) {
                throw new NullPointerException("keyPairForUnwrapping is marked non-null but is null");
            }
            if (str2 == null) {
                throw new NullPointerException("wrapAlgorithm is marked non-null but is null");
            }
            String str4 = TAG + ":unwrap";
            try {
                cipher = Cipher.getInstance(str2);
                if (algorithmParameterSpec != null) {
                    cipher.init(4, keyPair.getPrivate(), algorithmParameterSpec);
                } else {
                    cipher.init(4, keyPair.getPrivate());
                }
            } catch (IllegalArgumentException e) {
                e = e;
                str3 = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
                ClientException clientException = new ClientException(str3, e.getMessage(), e);
                if (e instanceof InvalidKeyException) {
                    sFailedAndroidKeyStoreUnwrapOperationCount.add(1L, createAttributesBuilderFromInvalidKeyException((InvalidKeyException) e).put(AttributeName.keystore_operation.name(), "unwrap").put(AttributeName.error_code.name(), str3).build());
                }
                Logger.error(str4, str3, e);
                throw clientException;
            } catch (InvalidKeyException e2) {
                e = e2;
                str3 = ClientException.INVALID_KEY;
                ClientException clientException2 = new ClientException(str3, e.getMessage(), e);
                if (e instanceof InvalidKeyException) {
                    sFailedAndroidKeyStoreUnwrapOperationCount.add(1L, createAttributesBuilderFromInvalidKeyException((InvalidKeyException) e).put(AttributeName.keystore_operation.name(), "unwrap").put(AttributeName.error_code.name(), str3).build());
                }
                Logger.error(str4, str3, e);
                throw clientException2;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                str3 = "no_such_algorithm";
                ClientException clientException3 = new ClientException(str3, e.getMessage(), e);
                if (e instanceof InvalidKeyException) {
                    sFailedAndroidKeyStoreUnwrapOperationCount.add(1L, createAttributesBuilderFromInvalidKeyException((InvalidKeyException) e).put(AttributeName.keystore_operation.name(), "unwrap").put(AttributeName.error_code.name(), str3).build());
                }
                Logger.error(str4, str3, e);
                throw clientException3;
            } catch (NoSuchPaddingException e4) {
                e = e4;
                str3 = ClientException.NO_SUCH_PADDING;
                ClientException clientException4 = new ClientException(str3, e.getMessage(), e);
                if (e instanceof InvalidKeyException) {
                    sFailedAndroidKeyStoreUnwrapOperationCount.add(1L, createAttributesBuilderFromInvalidKeyException((InvalidKeyException) e).put(AttributeName.keystore_operation.name(), "unwrap").put(AttributeName.error_code.name(), str3).build());
                }
                Logger.error(str4, str3, e);
                throw clientException4;
            } catch (Throwable th) {
                e = th;
                str3 = ClientException.UNKNOWN_CRYPTO_ERROR;
                ClientException clientException5 = new ClientException(str3, e.getMessage(), e);
                if (e instanceof InvalidKeyException) {
                    sFailedAndroidKeyStoreUnwrapOperationCount.add(1L, createAttributesBuilderFromInvalidKeyException((InvalidKeyException) e).put(AttributeName.keystore_operation.name(), "unwrap").put(AttributeName.error_code.name(), str3).build());
                }
                Logger.error(str4, str3, e);
                throw clientException5;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (SecretKey) cipher.unwrap(bArr, str, 3);
    }

    private static AttributesBuilder createAttributesBuilderFromInvalidKeyException(InvalidKeyException invalidKeyException) {
        String message;
        String strValueOf = "";
        String str = "InvalidKeyException";
        if (Build.VERSION.SDK_INT >= 33) {
            android.security.KeyStoreException keyStoreExceptionFindKeyStoreException = findKeyStoreException(invalidKeyException);
            if (keyStoreExceptionFindKeyStoreException != null) {
                message = keyStoreExceptionFindKeyStoreException.getMessage();
                if (message == null) {
                    message = "Keystore exception found, no error message";
                }
                str = "KeyStoreException";
                strValueOf = String.valueOf(keyStoreExceptionFindKeyStoreException.getNumericErrorCode());
            } else {
                message = "No keystore exception found";
            }
        } else {
            message = "API Level below 33, keystore exception not available";
        }
        return Attributes.builder().put(AttributeName.error_type.name(), str).put(AttributeName.keystore_exception_stack_trace.name(), ThrowableUtil.getStackTraceAsString(invalidKeyException)).put(AttributeName.keystore_exception_message.name(), message).put(AttributeName.keystore_numeric_error_code.name(), strValueOf);
    }

    private static android.security.KeyStoreException findKeyStoreException(Throwable th) {
        if (th == null) {
            throw new NullPointerException("throwable is marked non-null but is null");
        }
        if (Build.VERSION.SDK_INT >= 33) {
            for (int i = 0; th != null && i < KEYSTORE_EXCEPTION_CAUSE_CHAIN_MAX_DEPTH; i++) {
                if (th instanceof android.security.KeyStoreException) {
                    return (android.security.KeyStoreException) th;
                }
                th = th.getCause();
            }
        }
        return null;
    }

    public static synchronized List<String> getKeyPairEncryptionPaddings(KeyPair keyPair) {
        ArrayList arrayList;
        if (keyPair == null) {
            throw new NullPointerException("keyPair is marked non-null but is null");
        }
        String str = TAG + ":getKeyPairEncryptionPaddings";
        try {
            PrivateKey privateKey = keyPair.getPrivate();
            KeyInfo keyInfo = (KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), ANDROID_KEY_STORE_TYPE).getKeySpec(privateKey, KeyInfo.class);
            arrayList = new ArrayList();
            for (String str2 : keyInfo.getEncryptionPaddings()) {
                arrayList.add(str2.replace("Padding", ""));
            }
            Logger.info(str, "Supported encryption paddings: " + arrayList);
        } catch (Exception e) {
            Logger.warn(str, "Failed to retrieve key padding information: " + e.getMessage());
            return Collections.emptyList();
        }
        return arrayList;
    }
}
