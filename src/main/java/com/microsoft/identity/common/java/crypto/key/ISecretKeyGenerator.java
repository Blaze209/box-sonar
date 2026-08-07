package com.microsoft.identity.common.java.crypto.key;

import com.microsoft.identity.common.java.exception.ClientException;
import javax.crypto.SecretKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISecretKeyGenerator.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/key/ISecretKeyGenerator;", "", "generateKeyFromRawBytes", "Ljavax/crypto/SecretKey;", "rawBytes", "", "generateRandomKey", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ISecretKeyGenerator {
    SecretKey generateKeyFromRawBytes(byte[] rawBytes);

    SecretKey generateRandomKey() throws ClientException;
}
