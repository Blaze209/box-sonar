package com.nimbusds.jose.produce;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSProvider;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.jwk.JWK;

/* JADX INFO: loaded from: classes3.dex */
public interface JWSSignerFactory extends JWSProvider {
    JWSSigner createJWSSigner(JWK jwk) throws JOSEException;

    JWSSigner createJWSSigner(JWK jwk, JWSAlgorithm jWSAlgorithm) throws JOSEException;
}
