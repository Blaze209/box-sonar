package sdk.pendo.io.d2;

/* JADX INFO: loaded from: classes4.dex */
final class a {
    private short a;
    private short b;
    private short c;
    private boolean d = false;
    private short e;
    private short f;
    private short g;
    private int h;

    a(short s, short s2, short s3) {
        this.a = s;
        this.b = s2;
        this.c = s3;
    }

    int a() {
        return !this.d ? 8 : 16;
    }

    int a(byte[] bArr, int i) {
        int i2;
        int iA = c.a((int) this.b, bArr, c.a((int) this.a, bArr, c.a((int) this.c, bArr, i)));
        if (this.d) {
            iA = c.a((int) this.g, bArr, c.a((int) this.f, bArr, c.a((int) this.e, bArr, c.a(1, bArr, iA))));
            i2 = this.h;
        } else {
            i2 = 0;
        }
        return c.a(i2, bArr, iA);
    }
}
