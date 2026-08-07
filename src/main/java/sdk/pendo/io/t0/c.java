package sdk.pendo.io.t0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.a1.g;
import sdk.pendo.io.y0.i;

/* JADX INFO: loaded from: classes5.dex */
public class c extends e {
    static final Set<String> o = new HashSet(Arrays.asList("Ed448", "Ed25519", "EdDSA", "X25519", "X448", "XDH"));
    private final String n;

    public c(Map<String, Object> map) {
        this(map, null);
    }

    @Override // sdk.pendo.io.t0.e
    protected void a(Map<String, Object> map) {
        if (this.h != null) {
            map.put("d", sdk.pendo.io.k0.b.b(i().a(this.h)));
        }
    }

    @Override // sdk.pendo.io.t0.e
    protected void b(Map<String, Object> map) {
        byte[] bArrA = i().a(this.f);
        map.put("crv", this.n);
        map.put("x", sdk.pendo.io.k0.b.b(bArrA));
    }

    @Override // sdk.pendo.io.t0.b
    public String c() {
        return "OKP";
    }

    i i() {
        return i.a(this.n, this.i, null);
    }

    public c(Map<String, Object> map, String str) throws g {
        super(map, str);
        String strA = b.a(map, "crv", true);
        this.n = strA;
        try {
            i iVarI = i();
            if (iVarI == null) {
                throw new sdk.pendo.io.a1.f("\"" + strA + "\" is an unknown or unsupported subtype value for the \"crv\" parameter.");
            }
            this.f = iVarI.b(sdk.pendo.io.k0.b.d(b.a(map, "x", true)), strA);
            e();
            if (map.containsKey("d")) {
                this.h = iVarI.a(sdk.pendo.io.k0.b.d(b.a(map, "d", false)), strA);
            }
            a("crv", "x", "d");
        } catch (NoClassDefFoundError e) {
            throw new g("Unable to instantiate key for OKP JWK with " + this.n + ". " + sdk.pendo.io.a1.b.a(e));
        }
    }
}
