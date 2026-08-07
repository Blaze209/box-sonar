package com.microsoft.identity.common.java.crypto;

/* JADX INFO: loaded from: classes14.dex */
public interface SymmetricAlgorithm extends Algorithm {
    @Override // com.microsoft.identity.common.java.crypto.Algorithm
    String name();

    public static class Builder {
        public static SymmetricAlgorithm of(final String str) {
            if (str == null) {
                throw new NullPointerException("name is marked non-null but is null");
            }
            return new SymmetricAlgorithm() { // from class: com.microsoft.identity.common.java.crypto.SymmetricAlgorithm.Builder.1
                @Override // com.microsoft.identity.common.java.crypto.SymmetricAlgorithm, com.microsoft.identity.common.java.crypto.Algorithm
                public String name() {
                    return str;
                }
            };
        }
    }
}
