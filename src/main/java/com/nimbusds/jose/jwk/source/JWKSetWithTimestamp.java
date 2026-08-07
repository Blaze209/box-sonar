package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.shaded.jcip.Immutable;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Deprecated
public final class JWKSetWithTimestamp {
    private final JWKSet jwkSet;
    private final Date timestamp;

    public JWKSetWithTimestamp(JWKSet jWKSet) {
        this(jWKSet, new Date());
    }

    public JWKSetWithTimestamp(JWKSet jWKSet, Date date) {
        this.jwkSet = (JWKSet) Objects.requireNonNull(jWKSet);
        this.timestamp = (Date) Objects.requireNonNull(date);
    }

    public JWKSet getJWKSet() {
        return this.jwkSet;
    }

    public Date getDate() {
        return this.timestamp;
    }
}
