package org.jose4j.jwk;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.HashMap;
import java.util.Map;
import org.jose4j.keys.EcKeyUtil;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class EllipticCurveJsonWebKey extends PublicJsonWebKey {
    public static final String CURVE_MEMBER_NAME = "crv";
    public static final String KEY_TYPE = "EC";
    public static final String PRIVATE_KEY_MEMBER_NAME = "d";
    public static final String X_MEMBER_NAME = "x";
    public static final String Y_MEMBER_NAME = "y";
    private String curveName;

    public EllipticCurveJsonWebKey(ECPublicKey eCPublicKey) {
        super(eCPublicKey);
        this.curveName = EllipticCurves.getName(eCPublicKey.getParams().getCurve());
    }

    public EllipticCurveJsonWebKey(Map<String, Object> map) throws JoseException {
        this(map, null);
    }

    public EllipticCurveJsonWebKey(Map<String, Object> map, String str) throws JoseException {
        super(map, str);
        String string = getString(map, "crv", true);
        this.curveName = string;
        ECParameterSpec spec = EllipticCurves.getSpec(string);
        BigInteger bigIntFromBase64UrlEncodedParam = getBigIntFromBase64UrlEncodedParam(map, "x", true);
        BigInteger bigIntFromBase64UrlEncodedParam2 = getBigIntFromBase64UrlEncodedParam(map, "y", true);
        EcKeyUtil ecKeyUtil = new EcKeyUtil(str, null);
        this.key = ecKeyUtil.publicKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2, spec);
        checkForBareKeyCertMismatch();
        if (map.containsKey("d")) {
            this.privateKey = ecKeyUtil.privateKey(getBigIntFromBase64UrlEncodedParam(map, "d", false), spec);
        }
        removeFromOtherParams("crv", "x", "y", "d");
    }

    public ECPublicKey getECPublicKey() {
        return (ECPublicKey) this.key;
    }

    public ECPrivateKey getEcPrivateKey() {
        return (ECPrivateKey) this.privateKey;
    }

    @Override // org.jose4j.jwk.JsonWebKey
    public String getKeyType() {
        return "EC";
    }

    public String getCurveName() {
        return this.curveName;
    }

    private int getCoordinateByteLength() {
        return (int) Math.ceil(((double) EllipticCurves.getSpec(getCurveName()).getCurve().getField().getFieldSize()) / 8.0d);
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPublicTypeSpecificParams(Map<String, Object> map) {
        ECPoint w = getECPublicKey().getW();
        int coordinateByteLength = getCoordinateByteLength();
        putBigIntAsBase64UrlEncodedParam(map, "x", w.getAffineX(), coordinateByteLength);
        putBigIntAsBase64UrlEncodedParam(map, "y", w.getAffineY(), coordinateByteLength);
        map.put("crv", getCurveName());
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPrivateTypeSpecificParams(Map<String, Object> map) {
        ECPrivateKey ecPrivateKey = getEcPrivateKey();
        if (ecPrivateKey != null) {
            putBigIntAsBase64UrlEncodedParam(map, "d", ecPrivateKey.getS(), getCoordinateByteLength());
        }
    }

    @Override // org.jose4j.jwk.JsonWebKey
    protected String produceThumbprintHashInput() {
        HashMap map = new HashMap();
        fillPublicTypeSpecificParams(map);
        return String.format("{\"crv\":\"%s\",\"kty\":\"EC\",\"x\":\"%s\",\"y\":\"%s\"}", map.get("crv"), map.get("x"), map.get("y"));
    }
}
