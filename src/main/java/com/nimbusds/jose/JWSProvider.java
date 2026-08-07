package com.nimbusds.jose;

import com.nimbusds.jose.jca.JCAAware;
import com.nimbusds.jose.jca.JCAContext;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface JWSProvider extends JOSEProvider, JCAAware<JCAContext> {
    Set<JWSAlgorithm> supportedJWSAlgorithms();
}
