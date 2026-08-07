package sdk.pendo.io.l0;

import java.util.Arrays;
import sdk.pendo.io.a1.j;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    protected final byte a = 61;
    private final int b;
    private final int c;
    protected final int d;
    private final int e;

    static class a {
        int a;
        long b;
        byte[] c;
        int d;
        int e;
        boolean f;
        int g;
        int h;

        a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.c), Integer.valueOf(this.g), Boolean.valueOf(this.f), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.d), Integer.valueOf(this.e));
        }
    }

    protected b(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.e = i4;
    }

    protected int a() {
        return 8192;
    }

    int a(a aVar) {
        if (aVar.c != null) {
            return aVar.d - aVar.e;
        }
        return 0;
    }

    abstract void a(byte[] bArr, int i, int i2, a aVar);

    protected abstract boolean a(byte b);

    abstract void b(byte[] bArr, int i, int i2, a aVar);

    public byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        a(bArr, 0, bArr.length, aVar);
        a(bArr, 0, -1, aVar);
        int i = aVar.d;
        byte[] bArr2 = new byte[i];
        c(bArr2, 0, i, aVar);
        return bArr2;
    }

    public byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        b(bArr, 0, bArr.length, aVar);
        b(bArr, 0, -1, aVar);
        int i = aVar.d - aVar.e;
        byte[] bArr2 = new byte[i];
        c(bArr2, 0, i, aVar);
        return bArr2;
    }

    public String d(byte[] bArr) {
        return j.a(c(bArr));
    }

    private byte[] b(a aVar) {
        byte[] bArr = aVar.c;
        if (bArr == null) {
            aVar.c = new byte[a()];
            aVar.d = 0;
            aVar.e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.c = bArr2;
        }
        return aVar.c;
    }

    protected boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || a(b)) {
                return true;
            }
        }
        return false;
    }

    int c(byte[] bArr, int i, int i2, a aVar) {
        if (aVar.c == null) {
            return aVar.f ? -1 : 0;
        }
        int iMin = Math.min(a(aVar), i2);
        System.arraycopy(aVar.c, aVar.e, bArr, i, iMin);
        int i3 = aVar.e + iMin;
        aVar.e = i3;
        if (i3 >= aVar.d) {
            aVar.c = null;
        }
        return iMin;
    }

    public byte[] a(String str) {
        return b(j.b(str));
    }

    protected byte[] a(int i, a aVar) {
        byte[] bArr = aVar.c;
        return (bArr == null || bArr.length < aVar.d + i) ? b(aVar) : bArr;
    }
}
