package com.nimbusds.jose.jwk;

import com.nimbusds.jose.KeyException;

/* JADX INFO: loaded from: classes3.dex */
public class JWKException extends KeyException {
    public JWKException(String str) {
        super(str);
    }

    public static JWKException expectedClass(Class<? extends JWK> cls) {
        return new JWKException("Invalid JWK: Must be an instance of " + cls);
    }

    public static JWKException expectedPrivate() {
        return new JWKException("Expected private JWK but none available");
    }
}
