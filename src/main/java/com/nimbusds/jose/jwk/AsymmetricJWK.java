package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JOSEException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public interface AsymmetricJWK {
    boolean matches(X509Certificate x509Certificate);

    KeyPair toKeyPair() throws JOSEException;

    PrivateKey toPrivateKey() throws JOSEException;

    PublicKey toPublicKey() throws JOSEException;
}
