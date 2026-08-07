package org.jose4j.jwk;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import org.jose4j.keys.RsaKeyUtil;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class RsaJsonWebKey extends PublicJsonWebKey {
    public static final String EXPONENT_MEMBER_NAME = "e";
    public static final String FACTOR_CRT_COEFFICIENT = "t";
    public static final String FACTOR_CRT_EXPONENT_OTHER_MEMBER_NAME = "d";
    public static final String FIRST_CRT_COEFFICIENT_MEMBER_NAME = "qi";
    public static final String FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME = "dp";
    public static final String FIRST_PRIME_FACTOR_MEMBER_NAME = "p";
    public static final String KEY_TYPE = "RSA";
    public static final String MODULUS_MEMBER_NAME = "n";
    public static final String OTHER_PRIMES_INFO_MEMBER_NAME = "oth";
    public static final String PRIME_FACTOR_OTHER_MEMBER_NAME = "r";
    public static final String PRIVATE_EXPONENT_MEMBER_NAME = "d";
    public static final String SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME = "dq";
    public static final String SECOND_PRIME_FACTOR_MEMBER_NAME = "q";

    public RsaJsonWebKey(RSAPublicKey rSAPublicKey) {
        super(rSAPublicKey);
    }

    public RsaJsonWebKey(Map<String, Object> map) throws JoseException {
        this(map, null);
    }

    public RsaJsonWebKey(Map<String, Object> map, String str) throws JoseException {
        char c;
        super(map, str);
        BigInteger bigIntFromBase64UrlEncodedParam = getBigIntFromBase64UrlEncodedParam(map, "n", true);
        BigInteger bigIntFromBase64UrlEncodedParam2 = getBigIntFromBase64UrlEncodedParam(map, "e", true);
        RsaKeyUtil rsaKeyUtil = new RsaKeyUtil(str, null);
        this.key = rsaKeyUtil.publicKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2);
        checkForBareKeyCertMismatch();
        if (map.containsKey("d")) {
            BigInteger bigIntFromBase64UrlEncodedParam3 = getBigIntFromBase64UrlEncodedParam(map, "d", false);
            if (map.containsKey("p")) {
                c = 0;
                this.privateKey = rsaKeyUtil.privateKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2, bigIntFromBase64UrlEncodedParam3, getBigIntFromBase64UrlEncodedParam(map, "p", false), getBigIntFromBase64UrlEncodedParam(map, "q", false), getBigIntFromBase64UrlEncodedParam(map, "dp", false), getBigIntFromBase64UrlEncodedParam(map, "dq", false), getBigIntFromBase64UrlEncodedParam(map, "qi", false));
            } else {
                c = 0;
                this.privateKey = rsaKeyUtil.privateKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam3);
            }
        } else {
            c = 0;
        }
        String[] strArr = new String[8];
        strArr[c] = "n";
        strArr[1] = "e";
        strArr[2] = "d";
        strArr[3] = "p";
        strArr[4] = "q";
        strArr[5] = "dp";
        strArr[6] = "dq";
        strArr[7] = "qi";
        removeFromOtherParams(strArr);
    }

    @Override // org.jose4j.jwk.JsonWebKey
    public String getKeyType() {
        return "RSA";
    }

    public RSAPublicKey getRsaPublicKey() {
        return (RSAPublicKey) this.key;
    }

    public RSAPublicKey getRSAPublicKey() {
        return getRsaPublicKey();
    }

    public RSAPrivateKey getRsaPrivateKey() {
        return (RSAPrivateKey) this.privateKey;
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPublicTypeSpecificParams(Map<String, Object> map) {
        RSAPublicKey rsaPublicKey = getRsaPublicKey();
        putBigIntAsBase64UrlEncodedParam(map, "n", rsaPublicKey.getModulus());
        putBigIntAsBase64UrlEncodedParam(map, "e", rsaPublicKey.getPublicExponent());
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPrivateTypeSpecificParams(Map<String, Object> map) {
        RSAPrivateKey rsaPrivateKey = getRsaPrivateKey();
        if (rsaPrivateKey != null) {
            putBigIntAsBase64UrlEncodedParam(map, "d", rsaPrivateKey.getPrivateExponent());
            if (rsaPrivateKey instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rsaPrivateKey;
                putBigIntAsBase64UrlEncodedParam(map, "p", rSAPrivateCrtKey.getPrimeP());
                putBigIntAsBase64UrlEncodedParam(map, "q", rSAPrivateCrtKey.getPrimeQ());
                putBigIntAsBase64UrlEncodedParam(map, "dp", rSAPrivateCrtKey.getPrimeExponentP());
                putBigIntAsBase64UrlEncodedParam(map, "dq", rSAPrivateCrtKey.getPrimeExponentQ());
                putBigIntAsBase64UrlEncodedParam(map, "qi", rSAPrivateCrtKey.getCrtCoefficient());
            }
        }
    }

    @Override // org.jose4j.jwk.JsonWebKey
    protected String produceThumbprintHashInput() {
        HashMap map = new HashMap();
        fillPublicTypeSpecificParams(map);
        return String.format("{\"e\":\"%s\",\"kty\":\"RSA\",\"n\":\"%s\"}", map.get("e"), map.get("n"));
    }
}
