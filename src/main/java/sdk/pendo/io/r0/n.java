package sdk.pendo.io.r0;

import java.security.Key;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes4.dex */
public class n extends sdk.pendo.io.q0.f implements p {
    private d f;
    private i g;
    private m h;

    public static class a extends n {
        public a() {
            super(KeyManagementAlgorithmIdentifiers.ECDH_ES_A128KW, new d.a().g());
        }
    }

    public static class b extends n {
        public b() {
            super(KeyManagementAlgorithmIdentifiers.ECDH_ES_A192KW, new d.b().g());
        }
    }

    public static class c extends n {
        public c() {
            super(KeyManagementAlgorithmIdentifiers.ECDH_ES_A256KW, new d.c().g());
        }
    }

    public n(String str, d dVar) {
        a(str);
        b("N/A");
        c("EC");
        a(sdk.pendo.io.y0.h.ASYMMETRIC);
        this.f = dVar;
        this.h = new m("alg");
        this.g = new i(dVar.f(), "AES");
    }

    @Override // sdk.pendo.io.r0.p
    public Key a(sdk.pendo.io.q0.g gVar, byte[] bArr, i iVar, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        return this.f.a(this.f.a(this.h.a(gVar, sdk.pendo.io.a1.a.a, this.g, bVar, aVar), bVar, aVar), bArr, iVar, bVar, aVar);
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return this.h.d() && this.f.d();
    }

    @Override // sdk.pendo.io.r0.p
    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return this.h.a(key, bVar, aVar);
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        this.h.a(key, gVar);
    }
}
