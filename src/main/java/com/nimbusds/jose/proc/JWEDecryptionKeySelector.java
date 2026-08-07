package com.nimbusds.jose.proc;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyConverter;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.shaded.jcip.ThreadSafe;
import java.security.Key;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class JWEDecryptionKeySelector<C extends SecurityContext> extends AbstractJWKSelectorWithSource<C> implements JWEKeySelector<C> {
    private final JWEAlgorithm jweAlg;
    private final EncryptionMethod jweEnc;

    @Override // com.nimbusds.jose.proc.AbstractJWKSelectorWithSource
    public /* bridge */ /* synthetic */ JWKSource getJWKSource() {
        return super.getJWKSource();
    }

    public JWEDecryptionKeySelector(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod, JWKSource<C> jWKSource) {
        super(jWKSource);
        this.jweAlg = (JWEAlgorithm) Objects.requireNonNull(jWEAlgorithm);
        this.jweEnc = (EncryptionMethod) Objects.requireNonNull(encryptionMethod);
    }

    public JWEAlgorithm getExpectedJWEAlgorithm() {
        return this.jweAlg;
    }

    public EncryptionMethod getExpectedJWEEncryptionMethod() {
        return this.jweEnc;
    }

    protected JWKMatcher createJWKMatcher(JWEHeader jWEHeader) {
        if (getExpectedJWEAlgorithm().equals(jWEHeader.getAlgorithm()) && getExpectedJWEEncryptionMethod().equals(jWEHeader.getEncryptionMethod())) {
            return JWKMatcher.forJWEHeader(jWEHeader);
        }
        return null;
    }

    @Override // com.nimbusds.jose.proc.JWEKeySelector
    public List<Key> selectJWEKeys(JWEHeader jWEHeader, C c) throws KeySourceException {
        if (!this.jweAlg.equals(jWEHeader.getAlgorithm()) || !this.jweEnc.equals(jWEHeader.getEncryptionMethod())) {
            return Collections.emptyList();
        }
        List<JWK> list = getJWKSource().get(new JWKSelector(createJWKMatcher(jWEHeader)), c);
        LinkedList linkedList = new LinkedList();
        for (Key key : KeyConverter.toJavaKeys(list)) {
            if ((key instanceof PrivateKey) || (key instanceof SecretKey)) {
                linkedList.add(key);
            }
        }
        return linkedList;
    }
}
