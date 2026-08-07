package com.microsoft.identity.common.java.crypto;

/* JADX INFO: loaded from: classes14.dex */
public interface AsymmetricAlgorithm extends Algorithm {

    public static class Builder {
        public static AsymmetricAlgorithm of(final String str) {
            if (str == null) {
                throw new NullPointerException("name is marked non-null but is null");
            }
            return new AsymmetricAlgorithm() { // from class: com.microsoft.identity.common.java.crypto.AsymmetricAlgorithm.Builder.1
                @Override // com.microsoft.identity.common.java.crypto.Algorithm
                public String name() {
                    return str;
                }
            };
        }
    }
}
