package com.microsoft.identity.common.crypto;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import com.microsoft.identity.common.internal.util.AndroidKeyStoreUtil;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.crypto.key.AES256SecretKeyGenerator;
import com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.util.FileUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.io.File;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.crypto.SecretKey;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidWrappedKeyProvider implements ISecretKeyProvider {
    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    static final int KEY_FILE_SIZE = 1024;
    private static final String TAG = "AndroidWrappedKeyProvider#";
    public static final String WRAPPED_KEY_KEY_IDENTIFIER = "A001";
    private static final String WRAP_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String WRAP_KEY_ALGORITHM = "RSA";
    private static final ConcurrentMap<String, SecretKey> sKeyCacheMap = new ConcurrentHashMap();
    public static boolean sSkipKeyInvalidationCheck = false;
    private final String mAlias;
    private final Context mContext;
    private final String mFilePath;

    SecretKey getKeyFromCache() {
        String str = TAG + ":getKeyFromCache";
        if (!sSkipKeyInvalidationCheck && (!AndroidKeyStoreUtil.canLoadKey(this.mAlias) || !getKeyFile().exists())) {
            Logger.warn(str, "Key is invalid, removing from cache");
            clearKeyFromCache();
        }
        return sKeyCacheMap.get(this.mFilePath);
    }

    void clearKeyFromCache() {
        sKeyCacheMap.remove(this.mFilePath);
    }

    public AndroidWrappedKeyProvider(String str, String str2, Context context) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("filePath is marked non-null but is null");
        }
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        this.mAlias = str;
        this.mFilePath = str2;
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getKeyTypeIdentifier() {
        return "A001";
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public synchronized SecretKey getKey() throws ClientException {
        String str = TAG + ":getKey";
        SecretKey keyFromCache = getKeyFromCache();
        if (keyFromCache != null) {
            return keyFromCache;
        }
        Logger.info(str, "Key not in cache or cache is empty, loading key from storage");
        SecretKey secretKeyFromStorage = readSecretKeyFromStorage();
        if (secretKeyFromStorage == null) {
            Logger.info(str, "Key does not exist in storage, generating a new key");
            secretKeyFromStorage = generateRandomKey();
        }
        sKeyCacheMap.put(this.mFilePath, secretKeyFromStorage);
        return secretKeyFromStorage;
    }

    protected SecretKey generateRandomKey() throws ClientException {
        String str = TAG + ":generateRandomKey";
        SecretKey secretKeyGenerateRandomKey = AES256SecretKeyGenerator.INSTANCE.generateRandomKey();
        saveSecretKeyToStorage(secretKeyGenerateRandomKey);
        Logger.info(str, "New key is generated with thumbprint: " + KeyUtil.getKeyThumbPrint(secretKeyGenerateRandomKey));
        return secretKeyGenerateRandomKey;
    }

    synchronized SecretKey readSecretKeyFromStorage() throws ClientException {
        String str = TAG + ":readSecretKeyFromStorage";
        try {
            KeyPair key = AndroidKeyStoreUtil.readKey(this.mAlias);
            if (key == null) {
                Logger.info(str, "key does not exist in keystore");
                deleteSecretKeyFromStorage();
                return null;
            }
            byte[] fromFile = FileUtil.readFromFile(getKeyFile(), 1024);
            if (fromFile == null) {
                Logger.warn(str, "Key file is empty");
                FileUtil.deleteFile(getKeyFile());
                sKeyCacheMap.remove(this.mFilePath);
                return null;
            }
            SecretKey secretKeyUnwrap = AndroidKeyStoreUtil.unwrap(fromFile, "AES", key, WRAP_ALGORITHM, null);
            Logger.info(str, "Key is loaded with thumbprint: " + KeyUtil.getKeyThumbPrint(secretKeyUnwrap));
            return secretKeyUnwrap;
        } catch (ClientException e) {
            Logger.warn(str, "Error when loading key from Storage, wipe all existing key data ");
            deleteSecretKeyFromStorage();
            throw e;
        }
    }

    private void saveSecretKeyToStorage(SecretKey secretKey) throws ClientException {
        if (secretKey == null) {
            throw new NullPointerException("unencryptedKey is marked non-null but is null");
        }
        String str = TAG + ":saveSecretKeyToStorage";
        KeyPair key = AndroidKeyStoreUtil.readKey(this.mAlias);
        if (key == null) {
            Logger.info(str, "No existing keypair. Generating a new one.");
            Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.KeyPairGeneration.name(), SpanExtension.current().getSpanContext());
            try {
                try {
                    Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
                    try {
                        KeyPair keyPairGenerateNewKeyPair = generateNewKeyPair();
                        spanCreateSpanFromParent.setStatus(StatusCode.OK);
                        if (scopeMakeCurrentSpan != null) {
                            scopeMakeCurrentSpan.close();
                        }
                        spanCreateSpanFromParent.end();
                        key = keyPairGenerateNewKeyPair;
                    } catch (Throwable th) {
                        if (scopeMakeCurrentSpan != null) {
                            try {
                                scopeMakeCurrentSpan.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (ClientException e) {
                    spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                    spanCreateSpanFromParent.recordException(e);
                    throw e;
                }
            } catch (Throwable th3) {
                spanCreateSpanFromParent.end();
                throw th3;
            }
        }
        FileUtil.writeDataToFile(AndroidKeyStoreUtil.wrap(secretKey, key, WRAP_ALGORITHM, null), getKeyFile());
    }

    private KeyPair generateNewKeyPair() throws ClientException {
        return generateNewKeyPairAPI28AndAbove();
    }

    private KeyPair generateNewKeyPairAPI28AndAbove() throws ClientException {
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITH_PURPOSE_WRAP_KEY)) {
            return generateWrappingKeyPair_WithPurposeWrapKey();
        }
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITHOUT_PURPOSE_WRAP_KEY)) {
            return generateWrappingKeyPair();
        }
        return generateKeyPairWithLegacySpec();
    }

    private KeyPair generateNewKeyPairAPI23AndAbove() throws ClientException {
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITHOUT_PURPOSE_WRAP_KEY)) {
            return generateWrappingKeyPair();
        }
        return generateKeyPairWithLegacySpec();
    }

    private KeyPair generateKeyPairWithLegacySpec() throws ClientException {
        Span spanCurrent = SpanExtension.current();
        try {
            KeyPair keyPairAttemptKeyPairGeneration = attemptKeyPairGeneration(getLegacySpecForKeyStoreKey());
            spanCurrent.setAttribute(AttributeName.key_pair_gen_successful_method.name(), "legacy_key_gen_spec");
            return keyPairAttemptKeyPairGeneration;
        } catch (Throwable th) {
            Logger.error(TAG + ":generateKeyPairWithLegacySpec", "Error generating keypair with legacy spec.", th);
            throw ExceptionAdapter.clientExceptionFromException(th);
        }
    }

    private KeyPair generateWrappingKeyPair_WithPurposeWrapKey() throws ClientException {
        String str = TAG + ":generateWrappingKeyPair_WithPurposeWrapKey";
        Span spanCurrent = SpanExtension.current();
        try {
            Logger.info(str, "Generating new keypair with new spec with purpose_wrap_key");
            KeyPair keyPairAttemptKeyPairGeneration = attemptKeyPairGeneration(getSpecForWrappingKey(35));
            spanCurrent.setAttribute(AttributeName.key_pair_gen_successful_method.name(), "new_key_gen_spec_with_wrap");
            return keyPairAttemptKeyPairGeneration;
        } catch (Throwable th) {
            Logger.error(str, "Error generating keypair with new spec with purpose_wrap_key.Attempting without purpose_wrap_key.", th);
            if (!StringUtil.isNullOrEmpty(th.getMessage())) {
                spanCurrent.setAttribute(AttributeName.keypair_gen_exception.name(), th.getMessage());
            }
            return generateWrappingKeyPair();
        }
    }

    private KeyPair generateWrappingKeyPair() throws ClientException {
        String str = TAG + ":generateWrappingKeyPair";
        Span spanCurrent = SpanExtension.current();
        try {
            Logger.info(str, "Generating new keypair with new spec without wrap key");
            KeyPair keyPairAttemptKeyPairGeneration = attemptKeyPairGeneration(getSpecForWrappingKey(3));
            spanCurrent.setAttribute(AttributeName.key_pair_gen_successful_method.name(), "new_key_gen_spec_without_wrap");
            return keyPairAttemptKeyPairGeneration;
        } catch (Throwable th) {
            Logger.error(str, "Error generating keypair with new spec.Attempting with legacy spec.", th);
            if (!StringUtil.isNullOrEmpty(th.getMessage())) {
                spanCurrent.setAttribute(AttributeName.keypair_gen_exception.name(), th.getMessage());
            }
            return generateKeyPairWithLegacySpec();
        }
    }

    private KeyPair attemptKeyPairGeneration(AlgorithmParameterSpec algorithmParameterSpec) throws ClientException {
        if (algorithmParameterSpec == null) {
            throw new NullPointerException("keyPairGenSpec is marked non-null but is null");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        KeyPair keyPairGenerateKeyPair = AndroidKeyStoreUtil.generateKeyPair("RSA", algorithmParameterSpec);
        recordKeyGenerationTime(jCurrentTimeMillis);
        return keyPairGenerateKeyPair;
    }

    private void recordKeyGenerationTime(long j) {
        SpanExtension.current().setAttribute(AttributeName.elapsed_time_keypair_generation.name(), System.currentTimeMillis() - j);
    }

    public void deleteSecretKeyFromStorage() throws ClientException {
        AndroidKeyStoreUtil.deleteKey(this.mAlias);
        FileUtil.deleteFile(getKeyFile());
        sKeyCacheMap.remove(this.mFilePath);
    }

    private AlgorithmParameterSpec getLegacySpecForKeyStoreKey() {
        String str = String.format(Locale.ROOT, "CN=%s, OU=%s", this.mAlias, this.mContext.getPackageName());
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 100);
        return new KeyPairGeneratorSpec.Builder(this.mContext).setAlias(this.mAlias).setSubject(new X500Principal(str)).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
    }

    private AlgorithmParameterSpec getSpecForWrappingKey(int i) {
        return new KeyGenParameterSpec.Builder(this.mAlias, i).setKeySize(2048).setDigests("SHA-256", MessageDigestAlgorithms.SHA_512).setEncryptionPaddings("PKCS1Padding").build();
    }

    private File getKeyFile() {
        Context context = this.mContext;
        return new File(context.getDir(context.getPackageName(), 0), this.mFilePath);
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getCipherTransformation() {
        return "AES/CBC/PKCS5Padding";
    }
}
