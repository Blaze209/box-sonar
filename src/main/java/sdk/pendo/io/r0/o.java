package sdk.pendo.io.r0;

import java.security.Key;

/* JADX INFO: loaded from: classes4.dex */
public class o extends sdk.pendo.io.x0.c {
    private byte[] m;
    byte[] n;
    byte[] o;
    byte[] p;
    private sdk.pendo.io.q0.g r;
    private sdk.pendo.io.k0.b k = new sdk.pendo.io.k0.b();
    private String l = "UTF-8";
    private sdk.pendo.io.q0.c q = sdk.pendo.io.q0.c.c;

    private void a(g gVar, i iVar, byte[] bArr) throws sdk.pendo.io.a1.f {
        int iB = iVar.b();
        if (bArr.length != iB) {
            throw new sdk.pendo.io.a1.f(sdk.pendo.io.a1.a.a(bArr) + " bit content encryption key is not the correct size for the " + gVar.c() + " content encryption algorithm (" + sdk.pendo.io.a1.a.a(iB) + ").");
        }
    }

    private sdk.pendo.io.q0.g l() {
        p pVarR = r();
        Key keyH = h();
        if (j()) {
            pVarR.a(keyH, n());
        }
        return pVarR.a(keyH, this.b, i());
    }

    private void m() throws sdk.pendo.io.a1.g {
        p pVarR = r();
        g gVarN = n();
        i iVarB = gVarN.b();
        a();
        sdk.pendo.io.q0.g gVarL = this.r;
        if (gVarL == null) {
            gVarL = l();
        }
        Key keyA = pVarR.a(gVarL, p(), iVarB, f(), i());
        k kVar = new k(this.o, this.p, g());
        byte[] bArrO = o();
        byte[] encoded = keyA.getEncoded();
        a(gVarN, iVarB, encoded);
        c(a(f(), gVarN.a(kVar, bArrO, encoded, f(), i())));
    }

    p b(boolean z) throws sdk.pendo.io.a1.e {
        String strC = c();
        if (strC == null) {
            throw new sdk.pendo.io.a1.e("Encryption key management algorithm header (alg) not set.");
        }
        if (z) {
            b().a(strC);
        }
        return (p) sdk.pendo.io.q0.e.b().d().a(strC);
    }

    public void c(byte[] bArr) {
        this.m = bArr;
    }

    public void e(String str) {
        b(this.k.a(str));
    }

    public g n() throws sdk.pendo.io.a1.e {
        String strQ = q();
        if (strQ == null) {
            throw new sdk.pendo.io.a1.e("Content encryption header (enc) not set.");
        }
        this.q.a(strQ);
        return (g) sdk.pendo.io.q0.e.b().c().a(strQ);
    }

    byte[] o() {
        return sdk.pendo.io.a1.j.a(e());
    }

    public byte[] p() {
        return this.n;
    }

    public String q() {
        return b("enc");
    }

    public p r() {
        return b(true);
    }

    public String s() {
        return u();
    }

    public byte[] t() throws sdk.pendo.io.a1.g {
        if (this.m == null) {
            m();
        }
        return this.m;
    }

    public String u() {
        return sdk.pendo.io.a1.j.a(t(), this.l);
    }

    byte[] a(sdk.pendo.io.x0.b bVar, byte[] bArr) {
        String strC = bVar.c("zip");
        return strC != null ? ((sdk.pendo.io.c1.a) sdk.pendo.io.q0.e.b().a().a(strC)).a(bArr) : bArr;
    }

    public void b(sdk.pendo.io.q0.c cVar) {
        this.q = cVar;
    }

    @Override // sdk.pendo.io.x0.c
    protected void a(String[] strArr) throws sdk.pendo.io.a1.g {
        if (strArr.length != 5) {
            throw new sdk.pendo.io.a1.g("A JWE Compact Serialization must have exactly 5 parts separated by period ('.') characters");
        }
        d(strArr[0]);
        this.n = this.k.a(strArr[1]);
        e(strArr[2]);
        String str = strArr[3];
        a(str, "Encoded JWE Ciphertext");
        this.p = this.k.a(str);
        String str2 = strArr[4];
        a(str2, "Encoded JWE Authentication Tag");
        a(this.k.a(str2));
    }

    public void b(byte[] bArr) {
        this.o = bArr;
    }
}
