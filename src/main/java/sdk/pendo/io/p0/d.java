package sdk.pendo.io.p0;

import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes4.dex */
class d {
    private static final int[] o = {0, 0, 1, 1};
    private static final char[] p = a("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000");
    private static final int[] q = e();
    private static final int[] r = g();
    private static final int[] s = {2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String[] t = {"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] u = f();
    private Reader a;
    private int b;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean m;
    private int c = 0;
    private char[] d = new char[16384];
    private boolean l = true;
    private StringBuilder n = new StringBuilder();

    d(Reader reader) {
        this.a = reader;
    }

    private boolean d() throws IOException {
        int i;
        int i2 = this.g;
        if (i2 > 0) {
            char[] cArr = this.d;
            System.arraycopy(cArr, i2, cArr, 0, this.h - i2);
            int i3 = this.h;
            int i4 = this.g;
            this.h = i3 - i4;
            this.f -= i4;
            this.e -= i4;
            this.g = 0;
        }
        int i5 = this.f;
        char[] cArr2 = this.d;
        if (i5 >= cArr2.length) {
            char[] cArr3 = new char[i5 * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.d = cArr3;
        }
        Reader reader = this.a;
        char[] cArr4 = this.d;
        int i6 = this.h;
        int i7 = reader.read(cArr4, i6, cArr4.length - i6);
        if (i7 > 0) {
            this.h += i7;
            return false;
        }
        if (i7 != 0 || (i = this.a.read()) == -1) {
            return true;
        }
        char[] cArr5 = this.d;
        int i8 = this.h;
        this.h = i8 + 1;
        cArr5[i8] = (char) i;
        return false;
    }

    private static int[] e() {
        int[] iArr = new int[45];
        a("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", 0, iArr);
        return iArr;
    }

    private static int[] f() {
        int[] iArr = new int[45];
        b("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", 0, iArr);
        return iArr;
    }

    private static int[] g() {
        int[] iArr = new int[45];
        c("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006", 0, iArr);
        return iArr;
    }

    int a() {
        return this.j;
    }

    public final char b(int i) {
        return this.d[this.g + i];
    }

    public final String c() {
        char[] cArr = this.d;
        int i = this.g;
        return new String(cArr, i, this.e - i);
    }

    private void c(int i) {
        String str;
        try {
            str = t[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = t[0];
        }
        throw new Error(str);
    }

    public final void a(int i) {
        this.c = i;
    }

    public e b() throws c, IOException {
        int i;
        int i2;
        StringBuilder sb;
        char c;
        int i3 = this.h;
        char[] cArr = this.d;
        char[] cArr2 = p;
        int[] iArr = s;
        int[] iArr2 = r;
        int[] iArr3 = u;
        while (true) {
            int i4 = this.e;
            this.j += i4 - this.g;
            this.g = i4;
            this.f = i4;
            this.b = o[this.c];
            int i5 = -1;
            int i6 = i4;
            int i7 = -1;
            while (true) {
                if (i4 < i3) {
                    i2 = i4 + 1;
                    i = cArr[i4];
                } else if (this.m) {
                    i = i5;
                } else {
                    this.f = i4;
                    this.e = i6;
                    boolean zD = d();
                    int i8 = this.f;
                    i6 = this.e;
                    char[] cArr3 = this.d;
                    int i9 = this.h;
                    if (zD) {
                        cArr = cArr3;
                        i = i5;
                        i3 = i9;
                    } else {
                        i2 = i8 + 1;
                        i3 = i9;
                        i = cArr3[i8];
                        cArr = cArr3;
                    }
                }
                int i10 = iArr[iArr2[this.b] + cArr2[i == true ? 1 : 0]];
                if (i10 != i5) {
                    this.b = i10;
                    int i11 = iArr3[i10];
                    if ((i11 & 1) == 1) {
                        i6 = i2;
                        i7 = i10;
                        if ((i11 & 8) == 8) {
                        }
                    }
                    i5 = -1;
                    i4 = i2;
                }
            }
            this.e = i6;
            if (i7 >= 0) {
                i7 = q[i7];
            }
            switch (i7) {
                case 1:
                    throw new c(this.j, 0, new Character(b(0)));
                case 2:
                    String strC = c();
                    try {
                        return new e(0, Long.valueOf(strC));
                    } catch (NumberFormatException unused) {
                        return new e(0, new BigInteger(strC));
                    }
                case 3:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                    continue;
                case 4:
                    this.n = null;
                    this.n = new StringBuilder();
                    a(2);
                    continue;
                case 5:
                    return new e(1, null);
                case 6:
                    return new e(2, null);
                case 7:
                    return new e(3, null);
                case 8:
                    return new e(4, null);
                case 9:
                    return new e(5, null);
                case 10:
                    return new e(6, null);
                case 11:
                    this.n.append(c());
                    continue;
                case 12:
                    sb = this.n;
                    c = '\\';
                    break;
                case 13:
                    a(0);
                    return new e(0, this.n.toString());
                case 14:
                    sb = this.n;
                    c = '\"';
                    break;
                case 15:
                    sb = this.n;
                    c = '/';
                    break;
                case 16:
                    this.n.append('\b');
                    continue;
                case 17:
                    sb = this.n;
                    c = '\f';
                    break;
                case 18:
                    sb = this.n;
                    c = '\n';
                    break;
                case 19:
                    sb = this.n;
                    c = '\r';
                    break;
                case 20:
                    sb = this.n;
                    c = '\t';
                    break;
                case 21:
                    return new e(0, Double.valueOf(c()));
                case 22:
                    return new e(0, null);
                case 23:
                    return new e(0, Boolean.valueOf(c()));
                case 24:
                    try {
                        this.n.append((char) Integer.parseInt(c().substring(2), 16));
                        continue;
                    } catch (Exception e) {
                        throw new c(this.j, 2, e);
                    }
                    break;
                default:
                    if (i == -1 && this.g == this.f) {
                        this.m = true;
                        return null;
                    }
                    c(1);
                    continue;
                    break;
            }
            sb.append(c);
        }
    }

    private static int b(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int iCharAt = str.charAt(i2);
            i2 += 2;
            char cCharAt = str.charAt(i3);
            do {
                iArr[i] = cCharAt;
                iCharAt--;
                i++;
            } while (iCharAt > 0);
        }
        return i;
    }

    private static int c(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int iCharAt = str.charAt(i2) << 16;
            i2 += 2;
            iArr[i] = str.charAt(i3) | iCharAt;
            i++;
        }
        return i;
    }

    public final void a(Reader reader) {
        this.a = reader;
        this.l = true;
        this.m = false;
        this.g = 0;
        this.h = 0;
        this.e = 0;
        this.f = 0;
        this.k = 0;
        this.j = 0;
        this.i = 0;
        this.c = 0;
    }

    private static int a(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int iCharAt = str.charAt(i2);
            i2 += 2;
            char cCharAt = str.charAt(i3);
            do {
                iArr[i] = cCharAt;
                iCharAt--;
                i++;
            } while (iCharAt > 0);
        }
        return i;
    }

    private static char[] a(String str) {
        char[] cArr = new char[65536];
        int i = 0;
        int i2 = 0;
        while (i < 90) {
            int i3 = i + 1;
            int iCharAt = str.charAt(i);
            i += 2;
            char cCharAt = str.charAt(i3);
            do {
                cArr[i2] = cCharAt;
                iCharAt--;
                i2++;
            } while (iCharAt > 0);
        }
        return cArr;
    }
}
