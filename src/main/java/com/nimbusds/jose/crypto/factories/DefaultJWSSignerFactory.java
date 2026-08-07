package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jca.JCAContext;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.produce.JWSSignerFactory;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultJWSSignerFactory implements JWSSignerFactory {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;
    private final JCAContext jcaContext = new JCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(MACSigner.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(RSASSASigner.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDSASigner.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(Ed25519Signer.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    @Override // com.nimbusds.jose.JWSProvider
    public Set<JWSAlgorithm> supportedJWSAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JCAContext getJCAContext() {
        return this.jcaContext;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    @Override // com.nimbusds.jose.produce.JWSSignerFactory
    public JWSSigner createJWSSigner(JWK jwk) throws JOSEException {
        OctetKeyPair octetKeyPair;
        JWSSigner ed25519Signer;
        if (!jwk.isPrivate()) {
            throw JWKException.expectedPrivate();
        }
        if (jwk.getKeyUse() != null && !KeyUse.SIGNATURE.equals(jwk.getKeyUse())) {
            throw new JWKException("The JWK use must be sig (signature) or unspecified");
        }
        if (jwk instanceof OctetSequenceKey) {
            ed25519Signer = new MACSigner((OctetSequenceKey) jwk);
        } else if (jwk instanceof RSAKey) {
            ed25519Signer = new RSASSASigner((RSAKey) jwk);
        } else {
            if (!(jwk instanceof ECKey)) {
                if (jwk instanceof OctetKeyPair) {
                    octetKeyPair = (OctetKeyPair) jwk;
                    if (Ed25519Signer.SUPPORTED_CURVES.contains(octetKeyPair.getCurve())) {
                        ed25519Signer = new Ed25519Signer(octetKeyPair);
                    }
                }
                throw new JOSEException("Unsupported JWK type and / or curve");
            }
            ECKey eCKey = (ECKey) jwk;
            if (ECDSASigner.SUPPORTED_CURVES.contains(eCKey.getCurve())) {
                ed25519Signer = new ECDSASigner(eCKey);
            } else {
                if (jwk instanceof OctetKeyPair) {
                    octetKeyPair = (OctetKeyPair) jwk;
                    if (Ed25519Signer.SUPPORTED_CURVES.contains(octetKeyPair.getCurve())) {
                        ed25519Signer = new Ed25519Signer(octetKeyPair);
                    }
                }
                throw new JOSEException("Unsupported JWK type and / or curve");
            }
        }
        ed25519Signer.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
        ed25519Signer.getJCAContext().setProvider(this.jcaContext.getProvider());
        return ed25519Signer;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0084  */
    @Override // com.nimbusds.jose.produce.JWSSignerFactory
    public JWSSigner createJWSSigner(JWK jwk, JWSAlgorithm jWSAlgorithm) throws JOSEException {
        OctetKeyPair octetKeyPair;
        JWSSigner ed25519Signer;
        if (!jwk.isPrivate()) {
            throw JWKException.expectedPrivate();
        }
        if (jwk.getKeyUse() != null && !KeyUse.SIGNATURE.equals(jwk.getKeyUse())) {
            throw new JWKException("The JWK use must be sig (signature) or unspecified");
        }
        if (MACSigner.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm) && (jwk instanceof OctetSequenceKey)) {
            ed25519Signer = new MACSigner((OctetSequenceKey) jwk);
        } else if (RSASSASigner.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm) && (jwk instanceof RSAKey)) {
            ed25519Signer = new RSASSASigner((RSAKey) jwk);
        } else if (ECDSASigner.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm) && (jwk instanceof ECKey)) {
            ECKey eCKey = (ECKey) jwk;
            if (ECDSASigner.SUPPORTED_CURVES.contains(eCKey.getCurve())) {
                ed25519Signer = new ECDSASigner(eCKey);
            } else {
                if (Ed25519Signer.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                    octetKeyPair = (OctetKeyPair) jwk;
                    if (Ed25519Signer.SUPPORTED_CURVES.contains(octetKeyPair.getCurve())) {
                        ed25519Signer = new Ed25519Signer(octetKeyPair);
                    }
                }
                throw new JOSEException("Unsupported JWK type, JWK curve and / or JWS algorithm");
            }
        } else {
            if (Ed25519Signer.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm) && (jwk instanceof OctetKeyPair)) {
                octetKeyPair = (OctetKeyPair) jwk;
                if (Ed25519Signer.SUPPORTED_CURVES.contains(octetKeyPair.getCurve())) {
                    ed25519Signer = new Ed25519Signer(octetKeyPair);
                }
            }
            throw new JOSEException("Unsupported JWK type, JWK curve and / or JWS algorithm");
        }
        ed25519Signer.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
        ed25519Signer.getJCAContext().setProvider(this.jcaContext.getProvider());
        return ed25519Signer;
    }
}
