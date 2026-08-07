package sdk.pendo.io.r0;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwe.SimpleAeadCipher;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

/* JADX INFO: loaded from: classes4.dex */
public class c extends sdk.pendo.io.q0.f implements p {
    private s f;
    private int g;

    public static class a extends c {
        public a() {
            super(KeyManagementAlgorithmIdentifiers.A128GCMKW, sdk.pendo.io.a1.a.b(128));
        }
    }

    public static class b extends c {
        public b() {
            super(KeyManagementAlgorithmIdentifiers.A192GCMKW, sdk.pendo.io.a1.a.b(192));
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.r0.c$c, reason: collision with other inner class name */
    public static class C0470c extends c {
        public C0470c() {
            super(KeyManagementAlgorithmIdentifiers.A256GCMKW, sdk.pendo.io.a1.a.b(256));
        }
    }

    public c(String str, int i) {
        a(str);
        b(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        c(OctetSequenceJsonWebKey.KEY_TYPE);
        this.f = new s(e(), 16);
        this.g = i;
    }

    @Override // sdk.pendo.io.r0.p
    public Key a(sdk.pendo.io.q0.g gVar, byte[] bArr, i iVar, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return new SecretKeySpec(this.f.a(bArr, new sdk.pendo.io.k0.b().a(bVar.c("tag")), (byte[]) null, gVar.a()), iVar.a());
    }

    void b(Key key) throws sdk.pendo.io.a1.f {
        sdk.pendo.io.x0.d.a(key, c(), this.g);
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return this.f.a(this.a, this.g, 12, c());
    }

    @Override // sdk.pendo.io.r0.p
    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return new sdk.pendo.io.q0.g(this.f.a(key, new sdk.pendo.io.k0.b().a(bVar.c("iv")), 2, aVar.c().a()));
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        b(key);
    }
}
