package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JWKSetCacheRefreshEvaluator {
    public abstract boolean requiresRefresh(JWKSet jWKSet);

    public static JWKSetCacheRefreshEvaluator forceRefresh() {
        return ForceRefreshJWKSetCacheEvaluator.getInstance();
    }

    public static JWKSetCacheRefreshEvaluator noRefresh() {
        return NoRefreshJWKSetCacheEvaluator.getInstance();
    }

    public static JWKSetCacheRefreshEvaluator referenceComparison(JWKSet jWKSet) {
        return new ReferenceComparisonRefreshJWKSetEvaluator(jWKSet);
    }
}
