package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface JWKSetCache {
    JWKSet get();

    void put(JWKSet jWKSet);

    boolean requiresRefresh();
}
