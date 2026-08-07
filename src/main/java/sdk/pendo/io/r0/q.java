package sdk.pendo.io.r0;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.PbkdfKey;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes4.dex */
public class q extends sdk.pendo.io.q0.f implements p {
    private static final byte[] k = {0};
    private d f;
    private i g;
    private sdk.pendo.io.s0.e h;
    private long i = 8192;
    private int j = 12;

    public static class a extends q {
        public a() {
            super(KeyManagementAlgorithmIdentifiers.PBES2_HS256_A128KW, "HmacSHA256", new d.a().g());
        }
    }

    public static class b extends q {
        public b() {
            super(KeyManagementAlgorithmIdentifiers.PBES2_HS384_A192KW, MacUtil.HMAC_SHA384, new d.b().g());
        }
    }

    public static class c extends q {
        public c() {
            super(KeyManagementAlgorithmIdentifiers.PBES2_HS512_A256KW, MacUtil.HMAC_SHA512, new d.c().g());
        }
    }

    public q(String str, String str2, d dVar) {
        a(str);
        b("n/a");
        this.h = new sdk.pendo.io.s0.e(str2);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        c(PbkdfKey.ALGORITHM);
        this.f = dVar;
        this.g = new i(dVar.f(), "AES");
    }

    private Key a(Key key, Long l, byte[] bArr, sdk.pendo.io.m0.a aVar) {
        return new SecretKeySpec(this.h.a(key.getEncoded(), sdk.pendo.io.a1.a.a(sdk.pendo.io.a1.j.b(c()), k, bArr), l.intValue(), this.g.b(), aVar.c().e()), this.g.a());
    }

    public void b(Key key) throws sdk.pendo.io.a1.f {
        sdk.pendo.io.x0.d.b(key);
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return this.f.d();
    }

    @Override // sdk.pendo.io.r0.p
    public Key a(sdk.pendo.io.q0.g gVar, byte[] bArr, i iVar, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        return this.f.a(this.f.a(gVar.b(), bVar, aVar), bArr, iVar, bVar, aVar);
    }

    @Override // sdk.pendo.io.r0.p
    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return new sdk.pendo.io.q0.g(a(key, bVar.a("p2c"), new sdk.pendo.io.k0.b().a(bVar.c("p2s")), aVar));
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        b(key);
    }
}
