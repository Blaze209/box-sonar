package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.shaded.jcip.Immutable;
import java.security.Provider;
import java.util.Objects;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class PRFParams {
    private final int dkLen;
    private final String jcaMacAlg;
    private final Provider macProvider;

    public PRFParams(String str, Provider provider, int i) {
        this.jcaMacAlg = (String) Objects.requireNonNull(str);
        this.macProvider = provider;
        this.dkLen = i;
    }

    public String getMACAlgorithm() {
        return this.jcaMacAlg;
    }

    public Provider getMacProvider() {
        return this.macProvider;
    }

    public int getDerivedKeyByteLength() {
        return this.dkLen;
    }

    public static PRFParams resolve(JWEAlgorithm jWEAlgorithm, Provider provider) throws JOSEException {
        String str;
        int i;
        if (JWEAlgorithm.PBES2_HS256_A128KW.equals(jWEAlgorithm)) {
            str = "HmacSHA256";
            i = 16;
        } else if (JWEAlgorithm.PBES2_HS384_A192KW.equals(jWEAlgorithm)) {
            str = MacUtil.HMAC_SHA384;
            i = 24;
        } else if (JWEAlgorithm.PBES2_HS512_A256KW.equals(jWEAlgorithm)) {
            str = MacUtil.HMAC_SHA512;
            i = 32;
        } else {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(jWEAlgorithm, PasswordBasedCryptoProvider.SUPPORTED_ALGORITHMS));
        }
        return new PRFParams(str, provider, i);
    }
}
