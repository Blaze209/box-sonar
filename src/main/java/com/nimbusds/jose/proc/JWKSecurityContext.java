package com.nimbusds.jose.proc;

import com.nimbusds.jose.jwk.JWK;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JWKSecurityContext implements SecurityContext {
    private final List<JWK> keys;

    public JWKSecurityContext(List<JWK> list) {
        this.keys = (List) Objects.requireNonNull(list);
    }

    public List<JWK> getKeys() {
        return this.keys;
    }
}
