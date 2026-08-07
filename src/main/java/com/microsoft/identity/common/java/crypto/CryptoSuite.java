package com.microsoft.identity.common.java.crypto;

import java.security.KeyStore;

/* JADX INFO: loaded from: classes14.dex */
public interface CryptoSuite {
    Algorithm cipher();

    boolean isAsymmetric();

    Class<? extends KeyStore.Entry> keyClass();

    int keySize();

    String macName();

    SigningAlgorithm signingAlgorithm();
}
