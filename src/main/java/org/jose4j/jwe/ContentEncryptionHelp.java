package org.jose4j.jwe;

import org.jose4j.jca.ProviderContext;
import org.jose4j.jwx.Headers;

/* JADX INFO: loaded from: classes5.dex */
class ContentEncryptionHelp {
    ContentEncryptionHelp() {
    }

    static String getCipherProvider(Headers headers, ProviderContext providerContext) {
        return choseContext(headers, providerContext).getCipherProvider();
    }

    static String getMacProvider(Headers headers, ProviderContext providerContext) {
        return choseContext(headers, providerContext).getMacProvider();
    }

    private static ProviderContext.Context choseContext(Headers headers, ProviderContext providerContext) {
        return (headers == null || !KeyManagementAlgorithmIdentifiers.DIRECT.equals(headers.getStringHeaderValue("alg"))) ? providerContext.getGeneralProviderContext() : providerContext.getSuppliedKeyProviderContext();
    }
}
