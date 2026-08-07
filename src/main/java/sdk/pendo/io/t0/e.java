package sdk.pendo.io.t0;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.a1.g;
import sdk.pendo.io.a1.h;
import sdk.pendo.io.y0.k;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e extends b {
    protected boolean g;
    protected PrivateKey h;
    protected String i;
    private List<X509Certificate> j;
    private String k;
    private String l;
    private String m;

    public static class a {
        public static e a(String str) {
            return a(str, (String) null);
        }

        public static e a(String str, String str2) {
            return a(sdk.pendo.io.n0.a.a(str), str2);
        }

        public static e a(Map<String, Object> map, String str) throws g {
            String strB = b.b(map, "kty");
            strB.hashCode();
            strB.hashCode();
            switch (strB) {
                case "EC":
                    return new sdk.pendo.io.t0.a(map, str);
                case "OKP":
                    return new c(map, str);
                case "RSA":
                    return new f(map, str);
                default:
                    throw new g("Unknown key type (for public keys): '" + strB + "'");
            }
        }
    }

    protected e(PublicKey publicKey) {
        super(publicKey);
    }

    protected abstract void a(Map<String, Object> map);

    @Override // sdk.pendo.io.t0.b
    protected void a(Map<String, Object> map, b.EnumC0488b enumC0488b) {
        b(map);
        if (this.j != null) {
            k kVar = new k();
            ArrayList arrayList = new ArrayList(this.j.size());
            Iterator<X509Certificate> it = this.j.iterator();
            while (it.hasNext()) {
                arrayList.add(kVar.a(it.next()));
            }
            map.put("x5c", arrayList);
        }
        a("x5t", this.k, map);
        a("x5t#S256", this.l, map);
        a("x5u", this.m, map);
        if (this.g || enumC0488b == b.EnumC0488b.INCLUDE_PRIVATE) {
            a(map);
        }
    }

    BigInteger b(Map<String, Object> map, String str, boolean z) {
        return sdk.pendo.io.y0.b.a(b.a(map, str, z));
    }

    protected abstract void b(Map<String, Object> map);

    void e() {
        X509Certificate x509CertificateF = f();
        if (x509CertificateF != null && !x509CertificateF.getPublicKey().equals(h())) {
            throw new IllegalArgumentException("The key in the first certificate MUST match the bare public key represented by other members of the JWK. Public key = " + h() + " cert = " + x509CertificateF);
        }
    }

    public X509Certificate f() {
        List<X509Certificate> list = this.j;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.j.get(0);
    }

    public PrivateKey g() {
        return this.h;
    }

    public PublicKey h() {
        return (PublicKey) this.f;
    }

    protected e(Map<String, Object> map, String str) throws g {
        super(map);
        this.i = str;
        if (map.containsKey("x5c")) {
            List<String> listC = h.c(map, "x5c");
            this.j = new ArrayList(listC.size());
            k kVarB = k.b(str);
            Iterator<String> it = listC.iterator();
            while (it.hasNext()) {
                this.j.add(kVarB.a(it.next()));
            }
        }
        this.k = b.a(map, "x5t");
        this.l = b.a(map, "x5t#S256");
        this.m = b.a(map, "x5u");
        a("x5c", "x5t#S256", "x5t", "x5u");
    }

    void a(Map<String, Object> map, String str, BigInteger bigInteger) {
        map.put(str, sdk.pendo.io.y0.b.a(bigInteger));
    }

    void a(Map<String, Object> map, String str, BigInteger bigInteger, int i) {
        map.put(str, sdk.pendo.io.y0.b.a(bigInteger, i));
    }
}
