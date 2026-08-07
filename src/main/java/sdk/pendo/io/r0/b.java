package sdk.pendo.io.r0;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.SimpleAeadCipher;

/* JADX INFO: loaded from: classes4.dex */
public class b extends sdk.pendo.io.q0.f implements g {
    private i f;
    private s g;

    public static class a extends b {
        public a() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_128_GCM, 128);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.r0.b$b, reason: collision with other inner class name */
    public static class C0469b extends b {
        public C0469b() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_192_GCM, 192);
        }
    }

    public static class c extends b {
        public c() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM, 256);
        }
    }

    public b(String str, int i) {
        a(str);
        b(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        c("AES");
        this.f = new i(sdk.pendo.io.a1.a.b(i), "AES");
        this.g = new s(e(), 16);
    }

    @Override // sdk.pendo.io.r0.g
    public byte[] a(k kVar, byte[] bArr, byte[] bArr2, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        byte[] bArrC = kVar.c();
        return this.g.a(new sdk.pendo.io.y0.a(bArr2), bArrC, kVar.b(), kVar.a(), bArr, h.b(bVar, aVar));
    }

    @Override // sdk.pendo.io.r0.g
    public i b() {
        return this.f;
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return this.g.a(this.a, b().b(), 12, c());
    }
}
