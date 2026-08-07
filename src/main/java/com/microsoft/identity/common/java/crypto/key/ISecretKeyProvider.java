package com.microsoft.identity.common.java.crypto.key;

import com.microsoft.identity.common.java.exception.ClientException;
import javax.crypto.SecretKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISecretKeyProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8fX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/key/ISecretKeyProvider;", "", "alias", "", "getAlias", "()Ljava/lang/String;", "cipherTransformation", "getCipherTransformation", "key", "Ljavax/crypto/SecretKey;", "getKey", "()Ljavax/crypto/SecretKey;", "keyTypeIdentifier", "getKeyTypeIdentifier", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ISecretKeyProvider {
    String getAlias();

    String getCipherTransformation();

    SecretKey getKey() throws ClientException;

    String getKeyTypeIdentifier();
}
