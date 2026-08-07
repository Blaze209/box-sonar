package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;

/* JADX INFO: loaded from: classes3.dex */
class ForceRefreshJWKSetCacheEvaluator extends JWKSetCacheRefreshEvaluator {
    private static final ForceRefreshJWKSetCacheEvaluator INSTANCE = new ForceRefreshJWKSetCacheEvaluator();

    public int hashCode() {
        return 0;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCacheRefreshEvaluator
    public boolean requiresRefresh(JWKSet jWKSet) {
        return true;
    }

    public static ForceRefreshJWKSetCacheEvaluator getInstance() {
        return INSTANCE;
    }

    private ForceRefreshJWKSetCacheEvaluator() {
    }

    public boolean equals(Object obj) {
        return obj instanceof ForceRefreshJWKSetCacheEvaluator;
    }
}
