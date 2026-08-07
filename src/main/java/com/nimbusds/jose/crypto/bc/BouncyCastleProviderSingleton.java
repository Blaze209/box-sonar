package com.nimbusds.jose.crypto.bc;

import java.security.Provider;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class BouncyCastleProviderSingleton {
    private static Provider bouncyCastleProvider;

    private BouncyCastleProviderSingleton() {
    }

    public static Provider getInstance() {
        if (bouncyCastleProvider == null) {
            bouncyCastleProvider = new BouncyCastleProvider();
        }
        return bouncyCastleProvider;
    }
}
