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

/* JADX INFO: compiled from: ICryptoFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/ICryptoFactory;", "", "telemetryClassName", "Lcom/microsoft/identity/common/java/opentelemetry/CryptoFactoryName;", "getTelemetryClassName", "()Lcom/microsoft/identity/common/java/opentelemetry/CryptoFactoryName;", "getCipher", "Ljavax/crypto/Cipher;", "algorithm", "", "getKeyFactory", "Ljava/security/KeyFactory;", "getKeyPairGenerator", "Ljava/security/KeyPairGenerator;", "getMac", "Ljavax/crypto/Mac;", "getMessageDigest", "Ljava/security/MessageDigest;", "getSignature", "Ljava/security/Signature;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ICryptoFactory {
    Cipher getCipher(String algorithm) throws ClientException;

    KeyFactory getKeyFactory(String algorithm) throws ClientException;

    KeyPairGenerator getKeyPairGenerator(String algorithm) throws ClientException;

    Mac getMac(String algorithm) throws ClientException;

    MessageDigest getMessageDigest(String algorithm) throws ClientException;

    Signature getSignature(String algorithm) throws ClientException;

    CryptoFactoryName getTelemetryClassName();
}
