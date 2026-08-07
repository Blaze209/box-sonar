package org.jose4j.jwk;

import java.security.KeyPair;
import java.security.SecureRandom;
import org.jose4j.keys.RsaKeyUtil;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class RsaJwkGenerator {
    public static RsaJsonWebKey generateJwk(int i) throws JoseException {
        return generateJwk(i, null, null);
    }

    public static RsaJsonWebKey generateJwk(int i, String str, SecureRandom secureRandom) throws JoseException {
        KeyPair keyPairGenerateKeyPair = new RsaKeyUtil(str, secureRandom).generateKeyPair(i);
        RsaJsonWebKey rsaJsonWebKey = (RsaJsonWebKey) PublicJsonWebKey.Factory.newPublicJwk(keyPairGenerateKeyPair.getPublic());
        rsaJsonWebKey.setPrivateKey(keyPairGenerateKeyPair.getPrivate());
        return rsaJsonWebKey;
    }
}
