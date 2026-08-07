package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jose4j.jws.RsaUsingShaAlgorithm;

/* JADX INFO: loaded from: classes3.dex */
public class RSASSA {
    public static Signature getSignerAndVerifier(JWSAlgorithm jWSAlgorithm, Provider provider) throws JOSEException {
        Signature signerAndVerifier;
        Signature signerAndVerifier2;
        Signature signerAndVerifier3;
        Signature signerAndVerifier4;
        Signature signerAndVerifier5;
        Signature signerAndVerifier6;
        Signature signerAndVerifier7;
        Signature signerAndVerifier8;
        Signature signerAndVerifier9;
        Signature signerAndVerifier10;
        Signature signerAndVerifier11;
        Signature signerAndVerifier12;
        if (jWSAlgorithm.equals(JWSAlgorithm.RS256) && (signerAndVerifier12 = getSignerAndVerifier("SHA256withRSA", provider)) != null) {
            return signerAndVerifier12;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.RS384) && (signerAndVerifier11 = getSignerAndVerifier("SHA384withRSA", provider)) != null) {
            return signerAndVerifier11;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.RS512) && (signerAndVerifier10 = getSignerAndVerifier("SHA512withRSA", provider)) != null) {
            return signerAndVerifier10;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS256) && (signerAndVerifier9 = getSignerAndVerifier(RsaUsingShaAlgorithm.RSASSA_PSS, provider, new PSSParameterSpec("SHA-256", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA256, 32, 1))) != null) {
            return signerAndVerifier9;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS256) && (signerAndVerifier8 = getSignerAndVerifier("SHA256withRSA/PSS", provider)) != null) {
            return signerAndVerifier8;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS256) && (signerAndVerifier7 = getSignerAndVerifier("SHA256withRSAandMGF1", provider)) != null) {
            return signerAndVerifier7;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS384) && (signerAndVerifier6 = getSignerAndVerifier(RsaUsingShaAlgorithm.RSASSA_PSS, provider, new PSSParameterSpec(MessageDigestAlgorithms.SHA_384, IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA384, 48, 1))) != null) {
            return signerAndVerifier6;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS384) && (signerAndVerifier5 = getSignerAndVerifier("SHA384withRSA/PSS", provider)) != null) {
            return signerAndVerifier5;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS384) && (signerAndVerifier4 = getSignerAndVerifier("SHA384withRSAandMGF1", provider)) != null) {
            return signerAndVerifier4;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS512) && (signerAndVerifier3 = getSignerAndVerifier(RsaUsingShaAlgorithm.RSASSA_PSS, provider, new PSSParameterSpec(MessageDigestAlgorithms.SHA_512, IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA512, 64, 1))) != null) {
            return signerAndVerifier3;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.PS512) && (signerAndVerifier2 = getSignerAndVerifier("SHA512withRSA/PSS", provider)) != null) {
            return signerAndVerifier2;
        }
        if (!jWSAlgorithm.equals(JWSAlgorithm.PS512) || (signerAndVerifier = getSignerAndVerifier("SHA512withRSAandMGF1", provider)) == null) {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(jWSAlgorithm, RSASSAProvider.SUPPORTED_ALGORITHMS));
        }
        return signerAndVerifier;
    }

    private static Signature getSignerAndVerifier(String str, Provider provider) throws JOSEException {
        return getSignerAndVerifier(str, provider, null);
    }

    private static Signature getSignerAndVerifier(String str, Provider provider, PSSParameterSpec pSSParameterSpec) throws JOSEException {
        Signature signature;
        try {
            if (provider != null) {
                signature = Signature.getInstance(str, provider);
            } else {
                signature = Signature.getInstance(str);
            }
            if (pSSParameterSpec == null) {
                return signature;
            }
            try {
                signature.setParameter(pSSParameterSpec);
                return signature;
            } catch (InvalidAlgorithmParameterException e) {
                throw new JOSEException("Invalid RSASSA-PSS salt length parameter: " + e.getMessage(), e);
            }
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private RSASSA() {
    }
}
