package org.jose4j.jwk;

import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.ECParameterSpec;
import org.jose4j.keys.EcKeyUtil;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class EcJwkGenerator {
    public static EllipticCurveJsonWebKey generateJwk(ECParameterSpec eCParameterSpec) throws JoseException {
        return generateJwk(eCParameterSpec, null, null);
    }

    public static EllipticCurveJsonWebKey generateJwk(ECParameterSpec eCParameterSpec, String str, SecureRandom secureRandom) throws JoseException {
        KeyPair keyPairGenerateKeyPair = new EcKeyUtil(str, secureRandom).generateKeyPair(eCParameterSpec);
        EllipticCurveJsonWebKey ellipticCurveJsonWebKey = (EllipticCurveJsonWebKey) PublicJsonWebKey.Factory.newPublicJwk(keyPairGenerateKeyPair.getPublic());
        ellipticCurveJsonWebKey.setPrivateKey(keyPairGenerateKeyPair.getPrivate());
        return ellipticCurveJsonWebKey;
    }
}
