package com.nimbusds.jose;

import com.nimbusds.jose.jca.JCAAware;
import com.nimbusds.jose.jca.JWEJCAContext;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface JWEProvider extends JOSEProvider, JCAAware<JWEJCAContext> {
    Set<EncryptionMethod> supportedEncryptionMethods();

    Set<JWEAlgorithm> supportedJWEAlgorithms();
}
