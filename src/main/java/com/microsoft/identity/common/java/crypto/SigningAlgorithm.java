package com.microsoft.identity.common.java.crypto;

/* JADX INFO: loaded from: classes14.dex */
public enum SigningAlgorithm {
    NONE_WITH_RSA("NONEwithRSA"),
    SHA_1_WITH_RSA("SHA1withRSA"),
    SHA_256_WITH_RSA("SHA256withRSA");

    private final String mValue;

    SigningAlgorithm(String str) {
        if (str == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        this.mValue = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mValue;
    }
}
