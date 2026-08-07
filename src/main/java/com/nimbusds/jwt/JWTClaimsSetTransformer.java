package com.nimbusds.jwt;

/* JADX INFO: loaded from: classes3.dex */
public interface JWTClaimsSetTransformer<T> {
    T transform(JWTClaimsSet jWTClaimsSet);
}
