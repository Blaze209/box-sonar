package com.microsoft.identity.common.java.crypto.key;

import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes14.dex */
public class PredefinedKeyProvider implements ISecretKeyProvider {
    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static final String USER_PROVIDED_KEY_IDENTIFIER = "U001";
    private final String mAlias;
    private final SecretKey mKey;

    public PredefinedKeyProvider(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        this.mAlias = str;
        this.mKey = AES256SecretKeyGenerator.INSTANCE.generateKeyFromRawBytes(bArr);
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getKeyTypeIdentifier() {
        return USER_PROVIDED_KEY_IDENTIFIER;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public SecretKey getKey() {
        return this.mKey;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider
    public String getCipherTransformation() {
        return "AES/CBC/PKCS5Padding";
    }
}
