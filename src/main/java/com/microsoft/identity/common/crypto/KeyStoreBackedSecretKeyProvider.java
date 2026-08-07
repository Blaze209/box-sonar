package com.microsoft.identity.common.crypto;

import android.content.Context;
import com.microsoft.identity.common.crypto.wrappedsecretkey.WrappedSecretKey;
import com.microsoft.identity.common.internal.util.AndroidKeyStoreUtil;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.crypto.key.AES256SecretKeyGenerator;
import com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.util.FileUtil;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.io.File;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.crypto.SecretKey;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KeyStoreBackedSecretKeyProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u00016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0007J\b\u0010\"\u001a\u00020 H\u0007J\b\u0010#\u001a\u00020\u001aH\u0002J\u0006\u0010$\u001a\u00020\u000fJ\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u001aH\u0002J\u0016\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0&H\u0002J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u0004\u0018\u00010\u000fJ\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020.2\u0006\u0010(\u001a\u00020\u001aH\u0002J\u0016\u00102\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c0&H\u0002J\u0018\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001aH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/microsoft/identity/common/crypto/KeyStoreBackedSecretKeyProvider;", "Lcom/microsoft/identity/common/java/crypto/key/ISecretKeyProvider;", "context", "Landroid/content/Context;", "alias", "", "filePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "cipherTransformation", "getCipherTransformation", "cryptoParameterSpecFactory", "Lcom/microsoft/identity/common/crypto/CryptoParameterSpecFactory;", "key", "Ljavax/crypto/SecretKey;", "getKey", "()Ljavax/crypto/SecretKey;", "keyFile", "Ljava/io/File;", "keyFromCache", "getKeyFromCache", "keyTypeIdentifier", "getKeyTypeIdentifier", "attemptKeyGeneration", "Lkotlin/Result;", "Ljava/security/KeyPair;", "spec", "Lcom/microsoft/identity/common/crypto/IKeyGenSpec;", "attemptKeyGeneration-IoAF18A", "(Lcom/microsoft/identity/common/crypto/IKeyGenSpec;)Ljava/lang/Object;", "clearCachedKeyIfCantLoadOrFileDoesNotExist", "", "clearKeyFromCache", "deleteSecretKeyFromStorage", "generateKeyPair", "generateNewSecretKey", "getKeyPairCompatibleCipherSpecs", "", "Lcom/microsoft/identity/common/crypto/CipherSpec;", "keyPair", "handleAllFailures", "", "failures", "", "loadSecretKeyFromFile", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey;", "readSecretKeyFromStorage", "unwrapSecretKey", "wrappedSecretKey", "validateSpecsAvailable", "specs", "wrapSecretKey", "secretKey", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyStoreBackedSecretKeyProvider implements ISecretKeyProvider {
    public static final String AES_CBC_PKCS5_PADDING_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static final int KEY_FILE_SIZE = 1024;
    public static final String KEY_TYPE_IDENTIFIER = "A001";
    private static final String TAG = "KeyStoreBackedSecretKeyProvider";
    private final String alias;
    private final String cipherTransformation;
    private final CryptoParameterSpecFactory cryptoParameterSpecFactory;
    private final String filePath;
    private final File keyFile;
    private final String keyTypeIdentifier;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentMap<String, SecretKey> sKeyCacheMap = new ConcurrentHashMap();

    public KeyStoreBackedSecretKeyProvider(Context context, String alias, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.alias = alias;
        this.filePath = filePath;
        this.keyTypeIdentifier = "A001";
        this.cipherTransformation = AES_CBC_PKCS5_PADDING_TRANSFORMATION;
        this.cryptoParameterSpecFactory = new CryptoParameterSpecFactory(context, getAlias(), null, 4, null);
        this.keyFile = new File(context.getDir(context.getPackageName(), 0), filePath);
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getAlias() {
        return this.alias;
    }

    /* JADX INFO: compiled from: KeyStoreBackedSecretKeyProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/crypto/KeyStoreBackedSecretKeyProvider$Companion;", "", "()V", "AES_CBC_PKCS5_PADDING_TRANSFORMATION", "", "KEY_FILE_SIZE", "", "getKEY_FILE_SIZE$annotations", "KEY_TYPE_IDENTIFIER", "TAG", "sKeyCacheMap", "Ljava/util/concurrent/ConcurrentMap;", "Ljavax/crypto/SecretKey;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_FILE_SIZE$annotations() {
        }

        private Companion() {
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getKeyTypeIdentifier() {
        return this.keyTypeIdentifier;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getCipherTransformation() {
        return this.cipherTransformation;
    }

    public final SecretKey getKeyFromCache() {
        clearCachedKeyIfCantLoadOrFileDoesNotExist();
        return sKeyCacheMap.get(this.filePath);
    }

    public final void clearKeyFromCache() {
        sKeyCacheMap.remove(this.filePath);
    }

    public final void deleteSecretKeyFromStorage() throws ClientException {
        AndroidKeyStoreUtil.deleteKey(getAlias());
        FileUtil.deleteFile(this.keyFile);
        sKeyCacheMap.remove(this.filePath);
    }

    private final void clearCachedKeyIfCantLoadOrFileDoesNotExist() {
        if (AndroidWrappedKeyProvider.sSkipKeyInvalidationCheck) {
            return;
        }
        if (AndroidKeyStoreUtil.canLoadKey(getAlias()) && this.keyFile.exists()) {
            return;
        }
        sKeyCacheMap.remove(this.filePath);
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public synchronized SecretKey getKey() throws ClientException {
        SecretKey keyFromCache = getKeyFromCache();
        if (keyFromCache != null) {
            return keyFromCache;
        }
        SecretKey secretKeyFromStorage = readSecretKeyFromStorage();
        if (secretKeyFromStorage != null) {
            sKeyCacheMap.put(this.filePath, secretKeyFromStorage);
            Logger.verbose("KeyStoreBackedSecretKeyProvider:getKey", "Key loaded from storage and cached with thumbprint: " + KeyUtil.getKeyThumbPrint(secretKeyFromStorage));
            return secretKeyFromStorage;
        }
        SecretKey secretKeyGenerateNewSecretKey = generateNewSecretKey();
        sKeyCacheMap.put(this.filePath, secretKeyGenerateNewSecretKey);
        Logger.verbose("KeyStoreBackedSecretKeyProvider:getKey", "New key is generated and cached with thumbprint: " + KeyUtil.getKeyThumbPrint(secretKeyGenerateNewSecretKey));
        return secretKeyGenerateNewSecretKey;
    }

    public final SecretKey generateNewSecretKey() throws ClientException {
        SecretKey secretKeyGenerateRandomKey = AES256SecretKeyGenerator.INSTANCE.generateRandomKey();
        KeyPair key = AndroidKeyStoreUtil.readKey(getAlias());
        if (key == null) {
            Logger.info("KeyStoreBackedSecretKeyProvider:generateNewSecretKey", "No existing keypair found. Generating a new one.");
            key = generateKeyPair();
        }
        FileUtil.writeDataToFile(wrapSecretKey(secretKeyGenerateRandomKey, key).serialize(), this.keyFile);
        return secretKeyGenerateRandomKey;
    }

    public final synchronized SecretKey readSecretKeyFromStorage() throws ClientException {
        try {
            KeyPair key = AndroidKeyStoreUtil.readKey(getAlias());
            if (key == null) {
                Logger.info("KeyStoreBackedSecretKeyProvider:readSecretKeyFromStorage", "key does not exist in keystore");
                deleteSecretKeyFromStorage();
                return null;
            }
            WrappedSecretKey wrappedSecretKeyLoadSecretKeyFromFile = loadSecretKeyFromFile();
            if (wrappedSecretKeyLoadSecretKeyFromFile == null) {
                Logger.warn("KeyStoreBackedSecretKeyProvider:readSecretKeyFromStorage", "Key file is empty");
                FileUtil.deleteFile(this.keyFile);
                clearKeyFromCache();
                return null;
            }
            return unwrapSecretKey(wrappedSecretKeyLoadSecretKeyFromFile, key);
        } catch (ClientException e) {
            Logger.warn("KeyStoreBackedSecretKeyProvider:readSecretKeyFromStorage", "Error when loading key from Storage, wipe all existing key data ");
            deleteSecretKeyFromStorage();
            throw e;
        }
    }

    private final WrappedSecretKey wrapSecretKey(SecretKey secretKey, KeyPair keyPair) {
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.SecretKeyWrapping.name(), SpanExtension.current().getSpanContext());
        try {
            try {
                Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
                try {
                    Scope scope = scopeMakeCurrentSpan;
                    spanCreateSpanFromParent.setAttribute(AttributeName.secret_key_wrapping_operation.name(), "WRAP");
                    CipherSpec cipherSpec = (CipherSpec) CollectionsKt.firstOrNull((List) getKeyPairCompatibleCipherSpecs(keyPair));
                    if (cipherSpec == null) {
                        throw new ClientException(ClientException.UNKNOWN_CRYPTO_ERROR, "No compatible cipher specs found for key pair: " + keyPair);
                    }
                    spanCreateSpanFromParent.setAttribute(AttributeName.secret_key_wrapping_transformation.name(), cipherSpec.getTransformation());
                    Logger.info("KeyStoreBackedSecretKeyProvider:wrapSecretKey", "Wrapping secret key with cipher spec: " + cipherSpec);
                    byte[] wrappedKey = AndroidKeyStoreUtil.wrap(secretKey, keyPair, cipherSpec.getTransformation(), cipherSpec.getAlgorithmParameterSpec());
                    spanCreateSpanFromParent.setStatus(StatusCode.OK);
                    Intrinsics.checkNotNullExpressionValue(wrappedKey, "wrappedKey");
                    String algorithm = secretKey.getAlgorithm();
                    Intrinsics.checkNotNullExpressionValue(algorithm, "secretKey.algorithm");
                    WrappedSecretKey wrappedSecretKey = new WrappedSecretKey(wrappedKey, algorithm, cipherSpec.getTransformation());
                    AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
                    spanCreateSpanFromParent.end();
                    return wrappedSecretKey;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                Logger.error("KeyStoreBackedSecretKeyProvider:wrapSecretKey", "Failed to wrap secret key", e);
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                spanCreateSpanFromParent.recordException(e);
                throw e;
            }
        } catch (Throwable th3) {
            spanCreateSpanFromParent.end();
            throw th3;
        }
    }

    private final SecretKey unwrapSecretKey(WrappedSecretKey wrappedSecretKey, KeyPair keyPair) {
        Object next;
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.SecretKeyWrapping.name(), SpanExtension.current().getSpanContext());
        try {
            try {
                Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
                try {
                    Scope scope = scopeMakeCurrentSpan;
                    spanCreateSpanFromParent.setAttribute(AttributeName.secret_key_wrapping_operation.name(), "UNWRAP");
                    Iterator<T> it = getKeyPairCompatibleCipherSpecs(keyPair).iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!StringsKt.contains((CharSequence) ((CipherSpec) next).getTransformation(), (CharSequence) wrappedSecretKey.getCipherTransformation(), true));
                    CipherSpec cipherSpec = (CipherSpec) next;
                    if (cipherSpec == null) {
                        throw new ClientException(ClientException.UNKNOWN_CRYPTO_ERROR, "No compatible cipher specs found for key pair: " + keyPair);
                    }
                    spanCreateSpanFromParent.setAttribute(AttributeName.secret_key_wrapping_transformation.name(), cipherSpec.getTransformation());
                    Logger.info("KeyStoreBackedSecretKeyProvider:unwrapSecretKey", "Unwrapping secret key with cipher spec: " + cipherSpec);
                    SecretKey secretKeyUnwrap = AndroidKeyStoreUtil.unwrap(wrappedSecretKey.getWrappedKeyData(), wrappedSecretKey.getAlgorithm(), keyPair, cipherSpec.getTransformation(), cipherSpec.getAlgorithmParameterSpec());
                    spanCreateSpanFromParent.setStatus(StatusCode.OK);
                    AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
                    Intrinsics.checkNotNullExpressionValue(secretKeyUnwrap, "{\n            SpanExtens…y\n            }\n        }");
                    spanCreateSpanFromParent.end();
                    return secretKeyUnwrap;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                Logger.error("KeyStoreBackedSecretKeyProvider:unwrapSecretKey", "Failed to wrap secret key", e);
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                spanCreateSpanFromParent.recordException(e);
                throw e;
            }
        } catch (Throwable th3) {
            spanCreateSpanFromParent.end();
            throw th3;
        }
    }

    private final List<CipherSpec> getKeyPairCompatibleCipherSpecs(KeyPair keyPair) throws ClientException {
        List<String> supportedPaddings = AndroidKeyStoreUtil.getKeyPairEncryptionPaddings(keyPair);
        List<CipherSpec> prioritizedCipherParameterSpecs = this.cryptoParameterSpecFactory.getPrioritizedCipherParameterSpecs();
        Logger.verbose("KeyStoreBackedSecretKeyProvider:selectCompatibleCipherSpecs", "Supported paddings by the keyPair: " + supportedPaddings + ",Specs available in order of priority: " + prioritizedCipherParameterSpecs);
        ArrayList arrayList = new ArrayList();
        for (Object obj : prioritizedCipherParameterSpecs) {
            CipherSpec cipherSpec = (CipherSpec) obj;
            Intrinsics.checkNotNullExpressionValue(supportedPaddings, "supportedPaddings");
            List<String> list = supportedPaddings;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (String padding : list) {
                    String padding2 = cipherSpec.getPadding();
                    Intrinsics.checkNotNullExpressionValue(padding, "padding");
                    if (StringsKt.contains((CharSequence) padding2, (CharSequence) padding, true)) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        Logger.verbose("KeyStoreBackedSecretKeyProvider:selectCompatibleCipherSpecs", "Found " + arrayList2.size() + " compatible cipher specs: " + arrayList2);
        return arrayList2;
    }

    private final KeyPair generateKeyPair() throws ClientException {
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.KeyPairGeneration.name(), SpanExtension.current().getSpanContext());
        ArrayList arrayList = new ArrayList();
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                Scope scope = scopeMakeCurrentSpan;
                List<IKeyGenSpec> prioritizedKeyGenParameterSpecs = this.cryptoParameterSpecFactory.getPrioritizedKeyGenParameterSpecs();
                validateSpecsAvailable(prioritizedKeyGenParameterSpecs);
                int i = 0;
                for (IKeyGenSpec iKeyGenSpec : prioritizedKeyGenParameterSpecs) {
                    i++;
                    Logger.verbose("KeyStoreBackedSecretKeyProvider:generateKeyPair", "Attempting key generation with spec " + i + ": " + iKeyGenSpec);
                    Object objM13842attemptKeyGenerationIoAF18A = m13842attemptKeyGenerationIoAF18A(iKeyGenSpec);
                    if (Result.m14787isSuccessimpl(objM13842attemptKeyGenerationIoAF18A)) {
                        KeyPair keyPair = (KeyPair) objM13842attemptKeyGenerationIoAF18A;
                        Logger.info("KeyStoreBackedSecretKeyProvider:generateKeyPair", "Key pair generated successfully with spec: " + iKeyGenSpec);
                        spanCreateSpanFromParent.setAttribute(AttributeName.key_pair_gen_description.name(), iKeyGenSpec.getDescription());
                        spanCreateSpanFromParent.setAttribute(AttributeName.key_pair_gen_algorithm.name(), iKeyGenSpec.getAlgorithm());
                        spanCreateSpanFromParent.setAttribute(AttributeName.key_pair_gen_encryptionPaddings.name(), iKeyGenSpec.mo13841getEncryptionPaddings().toString());
                        spanCreateSpanFromParent.setStatus(StatusCode.OK);
                        AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
                        spanCreateSpanFromParent.end();
                        return keyPair;
                    }
                    Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM13842attemptKeyGenerationIoAF18A);
                    if (thM14783exceptionOrNullimpl != null) {
                        Logger.warn("KeyStoreBackedSecretKeyProvider:generateKeyPair", "Failed to generate key pair with spec: " + iKeyGenSpec + ", error: " + thM14783exceptionOrNullimpl.getMessage());
                        arrayList.add(thM14783exceptionOrNullimpl);
                    }
                }
                handleAllFailures(arrayList);
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            spanCreateSpanFromParent.end();
            throw th3;
        }
    }

    private final void validateSpecsAvailable(List<? extends IKeyGenSpec> specs) throws ClientException {
        if (specs.isEmpty()) {
            ClientException clientException = new ClientException(ClientException.UNKNOWN_CRYPTO_ERROR, "No key generation specifications available for generating key pair.");
            SpanExtension.current().setStatus(StatusCode.ERROR);
            ClientException clientException2 = clientException;
            SpanExtension.current().recordException(clientException2);
            ClientException clientExceptionClientExceptionFromException = ExceptionAdapter.clientExceptionFromException(clientException2);
            Intrinsics.checkNotNullExpressionValue(clientExceptionClientExceptionFromException, "clientExceptionFromException(error)");
            throw clientExceptionClientExceptionFromException;
        }
    }

    /* JADX INFO: renamed from: attemptKeyGeneration-IoAF18A, reason: not valid java name */
    private final Object m13842attemptKeyGenerationIoAF18A(IKeyGenSpec spec) {
        try {
            Result.Companion companion = Result.INSTANCE;
            KeyStoreBackedSecretKeyProvider keyStoreBackedSecretKeyProvider = this;
            long jCurrentTimeMillis = System.currentTimeMillis();
            KeyPair keyPairGenerateKeyPair = AndroidKeyStoreUtil.generateKeyPair(spec.getAlgorithm(), spec.getAlgorithmParameterSpec());
            Intrinsics.checkNotNullExpressionValue(keyPairGenerateKeyPair, "generateKeyPair(\n       …rameterSpec\n            )");
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_keypair_generation.name(), System.currentTimeMillis() - jCurrentTimeMillis);
            return Result.m14780constructorimpl(keyPairGenerateKeyPair);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final Void handleAllFailures(List<? extends Throwable> failures) throws ClientException {
        if (failures.isEmpty()) {
            throw new IllegalArgumentException("No failures encountered, but no key pair generated. This should not happen.".toString());
        }
        List<? extends Throwable> list = failures;
        String strJoinToString$default = CollectionsKt.joinToString$default(list, "; ", null, null, 0, null, new Function1<Throwable, CharSequence>() { // from class: com.microsoft.identity.common.crypto.KeyStoreBackedSecretKeyProvider$handleAllFailures$errorMessages$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Throwable exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                StringBuilder sbAppend = new StringBuilder().append(exception.getClass().getSimpleName()).append(": ");
                String message = exception.getMessage();
                if (message == null) {
                    message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                }
                return sbAppend.append(message).toString();
            }
        }, 30, null);
        for (Throwable th : list) {
            Logger.error("KeyStoreBackedSecretKeyProvider:handleAllFailures", "Key pair generation failed with: " + th.getMessage(), th);
        }
        SpanExtension.current().setAttribute(AttributeName.keypair_gen_exception.name(), strJoinToString$default);
        Throwable th2 = (Throwable) CollectionsKt.last((List) failures);
        SpanExtension.current().setStatus(StatusCode.ERROR);
        SpanExtension.current().recordException(th2);
        ClientException clientExceptionClientExceptionFromException = ExceptionAdapter.clientExceptionFromException(th2);
        Intrinsics.checkNotNullExpressionValue(clientExceptionClientExceptionFromException, "clientExceptionFromException(finalError)");
        throw clientExceptionClientExceptionFromException;
    }

    private final WrappedSecretKey loadSecretKeyFromFile() throws ClientException {
        if (!this.keyFile.exists()) {
            Logger.warn("KeyStoreBackedSecretKeyProvider:loadFromFile", "Key file does not exist");
            return null;
        }
        byte[] fromFile = FileUtil.readFromFile(this.keyFile, 1024);
        if (fromFile == null || fromFile.length == 0) {
            Logger.warn("KeyStoreBackedSecretKeyProvider:loadFromFile", "Key file is empty");
            return null;
        }
        return WrappedSecretKey.INSTANCE.deserialize(fromFile);
    }
}
