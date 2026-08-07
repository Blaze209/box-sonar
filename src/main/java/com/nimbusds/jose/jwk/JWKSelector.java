package com.nimbusds.jose.jwk;

import com.nimbusds.jose.shaded.jcip.Immutable;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class JWKSelector {
    private final JWKMatcher matcher;

    public JWKSelector(JWKMatcher jWKMatcher) {
        if (jWKMatcher == null) {
            throw new IllegalArgumentException("The JWK matcher must not be null");
        }
        this.matcher = jWKMatcher;
    }

    public JWKMatcher getMatcher() {
        return this.matcher;
    }

    public List<JWK> select(JWKSet jWKSet) {
        LinkedList linkedList = new LinkedList();
        if (jWKSet != null) {
            for (JWK jwk : jWKSet.getKeys()) {
                if (this.matcher.matches(jwk)) {
                    linkedList.add(jwk);
                }
            }
        }
        return linkedList;
    }
}
