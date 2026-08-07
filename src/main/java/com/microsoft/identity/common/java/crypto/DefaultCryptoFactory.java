package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryName;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultCryptoFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/DefaultCryptoFactory;", "Lcom/microsoft/identity/common/java/crypto/ICryptoFactory;", "()V", "telemetryClassName", "Lcom/microsoft/identity/common/java/opentelemetry/CryptoFactoryName;", "getTelemetryClassName", "()Lcom/microsoft/identity/common/java/opentelemetry/CryptoFactoryName;", "getCipher", "Ljavax/crypto/Cipher;", "algorithm", "", "getKeyFactory", "Ljava/security/KeyFactory;", "getKeyPairGenerator", "Ljava/security/KeyPairGenerator;", "getMac", "Ljavax/crypto/Mac;", "getMessageDigest", "Ljava/security/MessageDigest;", "getSignature", "Ljava/security/Signature;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultCryptoFactory implements ICryptoFactory {
    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public CryptoFactoryName getTelemetryClassName() {
        return CryptoFactoryName.DefaultCryptoFactory;
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public Signature getSignature(String algorithm) throws ClientException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Signature signature = ProviderFactory.getSignature(algorithm, null);
        Intrinsics.checkNotNullExpressionValue(signature, "getSignature(algorithm, null)");
        return signature;
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public Cipher getCipher(String algorithm) throws ClientException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Cipher cipher = ProviderFactory.getCipher(algorithm, null);
        Intrinsics.checkNotNullExpressionValue(cipher, "getCipher(algorithm, null)");
        return cipher;
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public Mac getMac(String algorithm) throws ClientException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Mac mac = ProviderFactory.getMac(algorithm, null);
        Intrinsics.checkNotNullExpressionValue(mac, "getMac(algorithm, null)");
        return mac;
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public KeyPairGenerator getKeyPairGenerator(String algorithm) throws ClientException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        KeyPairGenerator keyPairGenerator = ProviderFactory.getKeyPairGenerator(algorithm, null);
        Intrinsics.checkNotNullExpressionValue(keyPairGenerator, "getKeyPairGenerator(algorithm, null)");
        return keyPairGenerator;
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public KeyFactory getKeyFactory(String algorithm) throws ClientException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        KeyFactory keyFactory = ProviderFactory.getKeyFactory(algorithm, null);
        Intrinsics.checkNotNullExpressionValue(keyFactory, "getKeyFactory(algorithm, null)");
        return keyFactory;
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    public MessageDigest getMessageDigest(String algorithm) throws ClientException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = ProviderFactory.getMessageDigest(algorithm, null);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getMessageDigest(algorithm, null)");
        return messageDigest;
    }
}
