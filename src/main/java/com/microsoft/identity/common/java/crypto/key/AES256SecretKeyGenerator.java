package com.microsoft.identity.common.java.crypto.key;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AES256SecretKeyGenerator.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/key/AES256SecretKeyGenerator;", "Lcom/microsoft/identity/common/java/crypto/key/ISecretKeyGenerator;", "()V", "AES_ALGORITHM", "", "AES_KEY_SIZE", "", "TAG", "kotlin.jvm.PlatformType", "generateKeyFromRawBytes", "Ljavax/crypto/SecretKey;", "rawBytes", "", "generateRandomKey", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AES256SecretKeyGenerator implements ISecretKeyGenerator {
    public static final String AES_ALGORITHM = "AES";
    public static final int AES_KEY_SIZE = 256;
    public static final AES256SecretKeyGenerator INSTANCE = new AES256SecretKeyGenerator();
    private static final String TAG = "AES256SecretKeyGenerator";

    private AES256SecretKeyGenerator() {
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyGenerator
    public SecretKey generateRandomKey() throws ClientException {
        String str = TAG + ":generateRandomKey";
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256, new SecureRandom());
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "keygen.generateKey()");
            return secretKeyGenerateKey;
        } catch (NoSuchAlgorithmException e) {
            String message = e.getMessage();
            NoSuchAlgorithmException noSuchAlgorithmException = e;
            ClientException clientException = new ClientException("no_such_algorithm", message, noSuchAlgorithmException);
            Logger.error(str, clientException.getErrorCode(), noSuchAlgorithmException);
            throw clientException;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyGenerator
    public SecretKey generateKeyFromRawBytes(byte[] rawBytes) {
        Intrinsics.checkNotNullParameter(rawBytes, "rawBytes");
        return new SecretKeySpec(rawBytes, "AES");
    }
}
