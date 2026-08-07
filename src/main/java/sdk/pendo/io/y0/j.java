package sdk.pendo.io.y0;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class j extends g {
    public j(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    @Override // sdk.pendo.io.y0.g
    String a() {
        return "RSA";
    }

    public RSAPublicKey b(BigInteger bigInteger, BigInteger bigInteger2) throws sdk.pendo.io.a1.g {
        try {
            return (RSAPublicKey) b().generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.a1.g("Invalid key spec: " + e, e);
        }
    }

    public RSAPrivateKey a(RSAPrivateKeySpec rSAPrivateKeySpec) throws sdk.pendo.io.a1.g {
        try {
            return (RSAPrivateKey) b().generatePrivate(rSAPrivateKeySpec);
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.a1.g("Invalid key spec: " + e, e);
        }
    }

    public RSAPrivateKey a(BigInteger bigInteger, BigInteger bigInteger2) {
        return a(new RSAPrivateKeySpec(bigInteger, bigInteger2));
    }

    public RSAPrivateKey a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        return a(new RSAPrivateCrtKeySpec(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bigInteger6, bigInteger7, bigInteger8));
    }
}
