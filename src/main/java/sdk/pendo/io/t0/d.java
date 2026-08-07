package sdk.pendo.io.t0;

import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
public class d extends b {
    private byte[] g;

    public d(Map<String, Object> map) {
        super(map);
        this.g = new sdk.pendo.io.k0.b().a(b.b(map, "k"));
        this.f = new SecretKeySpec(this.g, "AES");
        a("k");
    }

    private String e() {
        return sdk.pendo.io.k0.b.b(this.g);
    }

    @Override // sdk.pendo.io.t0.b
    protected void a(Map<String, Object> map, b.EnumC0488b enumC0488b) {
        if (b.EnumC0488b.INCLUDE_SYMMETRIC.compareTo(enumC0488b) >= 0) {
            map.put("k", e());
        }
    }

    @Override // sdk.pendo.io.t0.b
    public String c() {
        return OctetSequenceJsonWebKey.KEY_TYPE;
    }
}
