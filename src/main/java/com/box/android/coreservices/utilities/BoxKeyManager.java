package com.box.android.coreservices.utilities;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxKeyManager {
    private static String ALGORITHM = "RSA";
    private static String ALIAS = "boxTokenKey";
    private static String ALIAS_TEST = "boxTokenTestKey";
    private static String CHAR_ENCODING = "UTF-8";
    private static String CIPHER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static String ENCRYPTION_TEST_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final int KEY_SIZE = 2048;
    private static String SHARED_PREFS_TEST_KEYSTORE_STRING_KEY = "testKeyStoreEncryptionStringKey";

    private BoxKeyManager() {
    }

    private static PrivateKey getDecryptionKeyFromSharedPrefs(IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        String privateKeyString = iMoCoBoxGlobalSettings.getPrivateKeyString();
        if (!StringUtils.isNotBlank(privateKeyString)) {
            return null;
        }
        try {
            return KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(privateKeyString, 0)));
        } catch (NoSuchAlgorithmException e) {
            BoxLogUtils.logException(e);
            return null;
        } catch (InvalidKeySpecException e2) {
            BoxLogUtils.logException(e2);
            return null;
        } catch (Exception e3) {
            BoxLogUtils.logException(e3);
            return null;
        }
    }

    public static PublicKey generateKeyStoreEncryptionKey() {
        return generateKeyStoreEncryptionKeyWithRetry(ALIAS);
    }

    private static PublicKey getEncryptionKeyFromKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(ALIAS, null);
            if (entry == null || !(entry instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            return ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_GET_ENCRYPTION_KEY, e.getClass().getName());
            BoxLogUtils.logException(e);
            return null;
        }
    }

    private static PublicKey getTestEncryptionKeyFromKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(ALIAS_TEST, null);
            if (entry == null || !(entry instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            return ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_GET_ENCRYPTION_KEY, e.getClass().getName());
            BoxLogUtils.logException(e);
            return null;
        }
    }

    private static PrivateKey getDecryptionKeyFromKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(ALIAS, null);
            if (entry != null) {
                return ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            }
            return null;
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_GET_DECRYPTION_KEY, e.getClass().getName());
            BoxLogUtils.logException(e);
            return null;
        }
    }

    private static PrivateKey getTestDecryptionKeyFromKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(ALIAS_TEST, null);
            if (entry != null) {
                return ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            }
            return null;
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_GET_DECRYPTION_KEY, e.getClass().getName());
            BoxLogUtils.logException(e);
            return null;
        }
    }

    public static String encrypt(String str) {
        try {
            PublicKey encryptionKeyFromKeyStore = getEncryptionKeyFromKeyStore();
            if (encryptionKeyFromKeyStore == null) {
                encryptionKeyFromKeyStore = generateKeyStoreEncryptionKey();
            }
            if (encryptionKeyFromKeyStore != null) {
                return encryptWithKey(str, encryptionKeyFromKeyStore);
            }
            return null;
        } catch (Exception e) {
            BoxLogUtils.e(BoxKeyManager.class.getName(), e);
            BoxLogUtils.logException(e);
            return null;
        }
    }

    private static String encryptWithKey(String str, PublicKey publicKey) throws Exception {
        byte[] bytes = str.getBytes(CHAR_ENCODING);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(1, publicKey);
        return new String(Base64.encode(cipher.doFinal(bytes), 0), CHAR_ENCODING);
    }

    public static String decrypt(String str, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        try {
            PrivateKey decryptionKeyFromKeyStore = getDecryptionKeyFromKeyStore();
            if (decryptionKeyFromKeyStore != null) {
                return decryptWithKey(str, decryptionKeyFromKeyStore);
            }
            return decryptWithSharedPrefsKey(str, iMoCoBoxGlobalSettings);
        } catch (Exception e) {
            BoxLogUtils.e(BoxKeyManager.class.getName(), e);
            BoxLogUtils.logException(e);
            return null;
        }
    }

    public static String decryptWithSharedPrefsKey(String str, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        PrivateKey decryptionKeyFromSharedPrefs = getDecryptionKeyFromSharedPrefs(iMoCoBoxGlobalSettings);
        if (decryptionKeyFromSharedPrefs == null) {
            return null;
        }
        try {
            return decryptWithKey(str, decryptionKeyFromSharedPrefs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String decryptWithKey(String str, PrivateKey privateKey) throws Exception {
        byte[] bArrDecode = Base64.decode(str.getBytes(CHAR_ENCODING), 0);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(2, privateKey);
        return new String(cipher.doFinal(bArrDecode), CHAR_ENCODING);
    }

    public static void testKeyStore() {
        String string = ApplicationProvider.application.getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL.name(), 0).getString(SHARED_PREFS_TEST_KEYSTORE_STRING_KEY, "");
        if ("".equals(string)) {
            if (getEncryptionKeyFromKeyStore() == null && generateTestKeyStoreEncryptionKey() != null) {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_GENERATE_KEY, "success");
            }
            testKeyStoreEncrypt();
            return;
        }
        testKeyStoreDecrypt(string);
    }

    private static void testKeyStoreEncrypt() {
        try {
            ApplicationProvider.application.getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL.name(), 0).edit().putString(SHARED_PREFS_TEST_KEYSTORE_STRING_KEY, encryptWithKey(ENCRYPTION_TEST_STRING, getTestEncryptionKeyFromKeyStore())).commit();
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_ENCRYPT, "success");
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_ENCRYPT, e.getClass().getName());
            BoxLogUtils.logException(e);
        }
    }

    private static void testKeyStoreDecrypt(String str) {
        try {
            if (!decryptWithKey(str, getTestDecryptionKeyFromKeyStore()).equals(ENCRYPTION_TEST_STRING)) {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_DECRYPT, "failedToDecrypt");
            } else {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_DECRYPT, "success");
            }
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_DECRYPT, e.getClass().getName());
            BoxLogUtils.logException(e);
        }
    }

    private static PublicKey generateTestKeyStoreEncryptionKey() {
        return generateKeyStoreEncryptionKeyWithRetry(ALIAS_TEST);
    }

    private static PublicKey generateKeyStoreEncryptionKeyWithRetry(String str) {
        PublicKey publicKeyGenerateKeyStoreEncryptionKey = generateKeyStoreEncryptionKey(str, true, true);
        if (publicKeyGenerateKeyStoreEncryptionKey == null) {
            BoxLogUtils.e("BoxKeyManager", "Failed to generate key with extended digests and attestation challenge, retrying without attestation.");
            publicKeyGenerateKeyStoreEncryptionKey = generateKeyStoreEncryptionKey(str, true, false);
        }
        if (publicKeyGenerateKeyStoreEncryptionKey == null) {
            BoxLogUtils.e("BoxKeyManager", "Failed to generate key with extended digests, trying again with standard digests and no attestation.");
            publicKeyGenerateKeyStoreEncryptionKey = generateKeyStoreEncryptionKey(str, false, false);
        }
        if (publicKeyGenerateKeyStoreEncryptionKey == null) {
            BoxLogUtils.e("BoxKeyManager", "Failed to generate key with all fallback options. Key generation failed.");
        }
        return publicKeyGenerateKeyStoreEncryptionKey;
    }

    private static PublicKey generateKeyStoreEncryptionKey(String str, boolean z, boolean z2) {
        String[] strArr;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", KEYSTORE_PROVIDER);
            KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(str, 3).setKeySize(2048).setEncryptionPaddings("PKCS1Padding");
            if (z) {
                strArr = new String[]{"SHA-256", MessageDigestAlgorithms.SHA_512};
            } else {
                strArr = new String[]{"SHA-256"};
            }
            KeyGenParameterSpec.Builder digests = encryptionPaddings.setDigests(strArr);
            if (z2) {
                digests.setAttestationChallenge(new byte[0]);
            }
            keyPairGenerator.initialize(digests.build());
            return keyPairGenerator.generateKeyPair().getPublic();
        } catch (Exception e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_GENERATE_KEY, e.getClass().getName());
            BoxLogUtils.logException(e);
            return null;
        }
    }
}
