package sdk.pendo.io.t0;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class a extends e {
    private String n;

    public a(Map<String, Object> map) {
        this(map, null);
    }

    private int i() {
        return (int) Math.ceil(((double) sdk.pendo.io.y0.e.a(j()).getCurve().getField().getFieldSize()) / 8.0d);
    }

    @Override // sdk.pendo.io.t0.e
    protected void a(Map<String, Object> map) {
        ECPrivateKey eCPrivateKeyL = l();
        if (eCPrivateKeyL != null) {
            a(map, "d", eCPrivateKeyL.getS(), i());
        }
    }

    @Override // sdk.pendo.io.t0.e
    protected void b(Map<String, Object> map) {
        ECPoint w = k().getW();
        int i = i();
        a(map, "x", w.getAffineX(), i);
        a(map, "y", w.getAffineY(), i);
        map.put("crv", j());
    }

    @Override // sdk.pendo.io.t0.b
    public String c() {
        return "EC";
    }

    public String j() {
        return this.n;
    }

    public ECPublicKey k() {
        return (ECPublicKey) this.f;
    }

    public ECPrivateKey l() {
        return (ECPrivateKey) this.h;
    }

    public a(Map<String, Object> map, String str) throws sdk.pendo.io.a1.f {
        super(map, str);
        String strA = b.a(map, "crv", true);
        this.n = strA;
        ECParameterSpec eCParameterSpecA = sdk.pendo.io.y0.e.a(strA);
        if (eCParameterSpecA == null) {
            throw new sdk.pendo.io.a1.f("\"" + this.n + "\" is an unknown or unsupported value for the \"crv\" parameter.");
        }
        BigInteger bigIntegerB = b(map, "x", true);
        BigInteger bigIntegerB2 = b(map, "y", true);
        sdk.pendo.io.y0.c cVar = new sdk.pendo.io.y0.c(str, null);
        this.f = cVar.a(bigIntegerB, bigIntegerB2, eCParameterSpecA);
        e();
        if (map.containsKey("d")) {
            this.h = cVar.a(b(map, "d", false), eCParameterSpecA);
        }
        a("crv", "x", "y", "d");
    }
}
