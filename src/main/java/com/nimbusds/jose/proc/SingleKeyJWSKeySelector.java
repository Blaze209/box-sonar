package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SingleKeyJWSKeySelector<C extends SecurityContext> implements JWSKeySelector<C> {
    private final JWSAlgorithm expectedJWSAlg;
    private final List<Key> singletonKeyList;

    public SingleKeyJWSKeySelector(JWSAlgorithm jWSAlgorithm, Key key) {
        this.singletonKeyList = Collections.singletonList(Objects.requireNonNull(key));
        this.expectedJWSAlg = (JWSAlgorithm) Objects.requireNonNull(jWSAlgorithm);
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<? extends Key> selectJWSKeys(JWSHeader jWSHeader, C c) {
        if (!this.expectedJWSAlg.equals(jWSHeader.getAlgorithm())) {
            return Collections.emptyList();
        }
        return this.singletonKeyList;
    }
}
