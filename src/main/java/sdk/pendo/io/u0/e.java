package sdk.pendo.io.u0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import sdk.pendo.io.a1.j;

/* JADX INFO: loaded from: classes5.dex */
public class e extends sdk.pendo.io.x0.c {
    private byte[] k;
    private String l = "UTF-8";
    private String m;
    private Boolean n;

    public e() {
        if (Boolean.getBoolean("external.sdk.pendo.io.jose4j.jws.default-allow-none")) {
            return;
        }
        a(sdk.pendo.io.q0.c.d);
    }

    private f b(boolean z) throws sdk.pendo.io.a1.e {
        String strC = c();
        if (strC == null) {
            throw new sdk.pendo.io.a1.e("Signature algorithm header (alg) not set.");
        }
        if (z) {
            b().a(strC);
        }
        return (f) sdk.pendo.io.q0.e.b().e().a(strC);
    }

    private byte[] o() throws sdk.pendo.io.a1.g {
        if (!r()) {
            return j.a(sdk.pendo.io.x0.a.a(e(), m()));
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(j.a(e()));
            byteArrayOutputStream.write(46);
            byteArrayOutputStream.write(this.k);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new sdk.pendo.io.a1.g("This should never happen from a ByteArrayOutputStream", e);
        }
    }

    private String p() {
        return j.a(this.k, this.l);
    }

    @Override // sdk.pendo.io.x0.c
    protected void a(String[] strArr) throws sdk.pendo.io.a1.g {
        if (strArr.length != 3) {
            throw new sdk.pendo.io.a1.g("A JWS Compact Serialization must have exactly 3 parts separated by period ('.') characters");
        }
        d(strArr[0]);
        if (r()) {
            f(strArr[1]);
        } else {
            e(strArr[1]);
        }
        b(this.a.a(strArr[2]));
    }

    @Override // sdk.pendo.io.x0.c
    protected boolean c(String str) {
        return "b64".equals(str);
    }

    public void e(String str) {
        this.m = str;
        this.k = this.a.a(str);
    }

    public void f(String str) {
        this.k = j.a(str, this.l);
        this.m = null;
    }

    @Override // sdk.pendo.io.x0.c
    protected void k() {
        this.n = null;
    }

    public f l() {
        return b(true);
    }

    public String m() {
        String str = this.m;
        return str != null ? str : this.a.a(this.k);
    }

    protected byte[] n() {
        return g();
    }

    public String q() {
        return p();
    }

    protected boolean r() {
        Object objB = this.b.b("b64");
        return (objB == null || !(objB instanceof Boolean) || ((Boolean) objB).booleanValue()) ? false : true;
    }

    public boolean s() throws sdk.pendo.io.a1.g {
        f fVarL = l();
        Key keyH = h();
        if (j()) {
            fVarL.a(keyH);
        }
        if (this.n == null) {
            a();
            this.n = Boolean.valueOf(fVarL.a(n(), keyH, o(), i()));
        }
        return this.n.booleanValue();
    }

    protected void b(byte[] bArr) {
        a(bArr);
    }
}
