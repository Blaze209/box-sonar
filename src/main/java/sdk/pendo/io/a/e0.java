package sdk.pendo.io.a;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {
    private final byte[] a;
    private final int b;

    e0(byte[] bArr, int i) {
        this.a = bArr;
        this.b = i;
    }

    public int a() {
        return this.a[this.b];
    }

    public int b(int i) {
        return this.a[this.b + (i * 2) + 2];
    }

    public String toString() {
        char c;
        int iA = a();
        StringBuilder sb = new StringBuilder(iA * 2);
        for (int i = 0; i < iA; i++) {
            int iA2 = a(i);
            if (iA2 == 0) {
                c = AbstractJsonLexerKt.BEGIN_LIST;
            } else if (iA2 != 1) {
                if (iA2 == 2) {
                    c = '*';
                } else {
                    if (iA2 != 3) {
                        throw new AssertionError();
                    }
                    sb.append(b(i)).append(';');
                }
            } else {
                c = '.';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public int a(int i) {
        return this.a[this.b + (i * 2) + 1];
    }

    static void a(e0 e0Var, d dVar) {
        if (e0Var == null) {
            dVar.b(0);
            return;
        }
        byte[] bArr = e0Var.a;
        int i = e0Var.b;
        dVar.a(bArr, i, (bArr[i] * 2) + 1);
    }
}
