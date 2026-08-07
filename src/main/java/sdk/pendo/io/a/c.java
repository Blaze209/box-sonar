package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public final String a;
    private byte[] b;
    c c;

    static final class a {
        private int a;
        private c[] b = new c[6];

        a() {
        }

        private void a(c cVar) {
            int i = this.a;
            c[] cVarArr = this.b;
            if (i >= cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length + 6];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                this.b = cVarArr2;
            }
            c[] cVarArr3 = this.b;
            int i2 = this.a;
            this.a = i2 + 1;
            cVarArr3[i2] = cVar;
        }

        private boolean c(c cVar) {
            for (int i = 0; i < this.a; i++) {
                if (this.b[i].a.equals(cVar.a)) {
                    return true;
                }
            }
            return false;
        }

        void b(c cVar) {
            while (cVar != null) {
                if (!c(cVar)) {
                    a(cVar);
                }
                cVar = cVar.c;
            }
        }

        c[] a() {
            int i = this.a;
            c[] cVarArr = new c[i];
            System.arraycopy(this.b, 0, cVarArr, 0, i);
            return cVarArr;
        }
    }

    protected c(String str) {
        this.a = str;
    }

    final int a(c0 c0Var) {
        return a(c0Var, (byte[]) null, 0, -1, -1);
    }

    public boolean b() {
        return false;
    }

    static int a(c0 c0Var, int i, int i2) {
        int i3;
        if ((i & 4096) == 0 || c0Var.e() >= 49) {
            i3 = 0;
        } else {
            c0Var.f("Synthetic");
            i3 = 6;
        }
        if (i2 != 0) {
            c0Var.f("Signature");
            i3 += 8;
        }
        if ((i & 131072) == 0) {
            return i3;
        }
        c0Var.f("Deprecated");
        return i3 + 6;
    }

    final int a(c0 c0Var, byte[] bArr, int i, int i2, int i3) {
        h hVar = c0Var.a;
        c cVar = this;
        int i4 = 0;
        while (cVar != null) {
            c0Var.f(cVar.a);
            byte[] bArr2 = bArr;
            i4 += cVar.a(hVar, bArr2, i, i2, i3).b + 6;
            cVar = cVar.c;
            bArr = bArr2;
        }
        return i4;
    }

    final int a() {
        int i = 0;
        while (this != null) {
            i++;
            this = this.c;
        }
        return i;
    }

    static void a(c0 c0Var, int i, int i2, d dVar) {
        if ((i & 4096) != 0 && c0Var.e() < 49) {
            dVar.d(c0Var.f("Synthetic")).c(0);
        }
        if (i2 != 0) {
            dVar.d(c0Var.f("Signature")).c(2).d(i2);
        }
        if ((i & 131072) != 0) {
            dVar.d(c0Var.f("Deprecated")).c(0);
        }
    }

    final void a(c0 c0Var, d dVar) {
        a(c0Var, (byte[]) null, 0, -1, -1, dVar);
    }

    final void a(c0 c0Var, byte[] bArr, int i, int i2, int i3, d dVar) {
        h hVar = c0Var.a;
        c cVar = this;
        while (cVar != null) {
            byte[] bArr2 = bArr;
            int i4 = i;
            d dVarA = cVar.a(hVar, bArr2, i4, i2, i3);
            dVar.d(c0Var.f(cVar.a)).c(dVarA.b);
            dVar.a(dVarA.a, 0, dVarA.b);
            cVar = cVar.c;
            bArr = bArr2;
            i = i4;
        }
    }

    protected c a(e eVar, int i, int i2, char[] cArr, int i3, s[] sVarArr) {
        c cVar = new c(this.a);
        byte[] bArr = new byte[i2];
        cVar.b = bArr;
        System.arraycopy(eVar.c, i, bArr, 0, i2);
        return cVar;
    }

    protected d a(h hVar, byte[] bArr, int i, int i2, int i3) {
        return new d(this.b);
    }
}
