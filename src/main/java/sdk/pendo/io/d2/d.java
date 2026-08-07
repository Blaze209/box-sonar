package sdk.pendo.io.d2;

import com.google.common.base.Ascii;
import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import external.sdk.pendo.io.mozilla.javascript.UintMap;
import kotlin.UShort;

/* JADX INFO: loaded from: classes4.dex */
final class d {
    private c a;
    private UintMap b = new UintMap();
    private ObjToIntMap c = new ObjToIntMap();
    private ObjToIntMap d = new ObjToIntMap();
    private ObjToIntMap e = new ObjToIntMap();
    private ObjToIntMap f = new ObjToIntMap();
    private ObjToIntMap g = new ObjToIntMap();
    private UintMap j = new UintMap();
    private UintMap k = new UintMap();
    private int i = 1;
    private byte[] l = new byte[256];
    private int h = 0;

    d(c cVar) {
        this.a = cVar;
    }

    short a(String str) {
        String str2;
        int i = this.f.get(str, -1);
        if (i == -1) {
            if (str.indexOf(46) > 0) {
                String strI = c.i(str);
                int i2 = this.f.get(strI, -1);
                if (i2 != -1) {
                    this.f.put(str, i2);
                }
                str2 = strI;
                i = i2;
            } else {
                str2 = str;
            }
            if (i == -1) {
                short sC = c(str2);
                b(3);
                byte[] bArr = this.l;
                int i3 = this.h;
                int i4 = i3 + 1;
                this.h = i4;
                bArr[i3] = 7;
                this.h = c.a((int) sC, bArr, i4);
                i = this.i;
                this.i = i + 1;
                this.f.put(str2, i);
                if (!str.equals(str2)) {
                    this.f.put(str, i);
                }
            }
        }
        a(i, str);
        this.k.put(i, 7);
        return (short) i;
    }

    int b(String str) {
        int iC = c(str) & UShort.MAX_VALUE;
        int i = this.b.getInt(iC, -1);
        if (i == -1) {
            i = this.i;
            this.i = i + 1;
            b(3);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 8;
            this.h = c.a(iC, bArr, i3);
            this.b.put(iC, i);
        }
        this.k.put(i, 8);
        return i;
    }

    short c(String str, String str2, String str3) {
        f fVar = new f(str, str2, str3);
        int i = this.e.get(fVar, -1);
        if (i == -1) {
            short sA = a(str2, str3);
            short sA2 = a(str);
            b(5);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 10;
            int iA = c.a((int) sA2, bArr, i3);
            this.h = iA;
            this.h = c.a((int) sA, this.l, iA);
            i = this.i;
            this.i = i + 1;
            this.e.put(fVar, i);
        }
        a(i, fVar);
        this.k.put(i, 10);
        return (short) i;
    }

    byte d(int i) {
        return (byte) this.k.getInt(i, 0);
    }

    int a(double d) {
        b(9);
        byte[] bArr = this.l;
        int i = this.h;
        this.h = i + 1;
        bArr[i] = 6;
        this.h = c.a(Double.doubleToLongBits(d), this.l, this.h);
        int i2 = this.i;
        this.i = i2 + 2;
        this.k.put(i2, 6);
        return i2;
    }

    short b(String str, String str2, String str3) {
        short sA = a(str2, str3);
        short sA2 = a(str);
        b(5);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 11;
        int iA = c.a((int) sA2, bArr, i2);
        this.h = iA;
        this.h = c.a((int) sA, this.l, iA);
        a(this.i, new f(str, str2, str3));
        this.k.put(this.i, 11);
        int i3 = this.i;
        this.i = i3 + 1;
        return (short) i3;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0087  */
    short c(String str) {
        boolean z;
        int i = this.c.get(str, -1);
        if (i == -1) {
            int length = str.length();
            if (length > 65535) {
                z = true;
            } else {
                b((length * 3) + 3);
                int i2 = this.h;
                this.l[i2] = 1;
                int i3 = i2 + 3;
                char[] cArrT = this.a.t(length);
                z = false;
                str.getChars(0, length, cArrT, 0);
                for (int i4 = 0; i4 != length; i4++) {
                    char c = cArrT[i4];
                    if (c != 0 && c <= 127) {
                        this.l[i3] = (byte) c;
                        i3++;
                    } else if (c > 2047) {
                        byte[] bArr = this.l;
                        bArr[i3] = (byte) ((c >> '\f') | 224);
                        int i5 = i3 + 2;
                        bArr[i3 + 1] = (byte) (((c >> 6) & 63) | 128);
                        i3 += 3;
                        bArr[i5] = (byte) ((c & '?') | 128);
                    } else {
                        byte[] bArr2 = this.l;
                        int i6 = i3 + 1;
                        bArr2[i3] = (byte) ((c >> 6) | 192);
                        i3 += 2;
                        bArr2[i6] = (byte) ((c & '?') | 128);
                    }
                }
                int i7 = this.h;
                int i8 = i7 + 1;
                int i9 = i3 - (i7 + 3);
                if (i9 > 65535) {
                    z = true;
                } else {
                    byte[] bArr3 = this.l;
                    bArr3[i8] = (byte) (i9 >>> 8);
                    bArr3[i7 + 2] = (byte) i9;
                    this.h = i3;
                    i = this.i;
                    this.i = i + 1;
                    this.c.put(str, i);
                }
            }
            if (z) {
                throw new IllegalArgumentException("Too big string");
            }
        }
        a(i, str);
        this.k.put(i, 1);
        return (short) i;
    }

    private void b(int i) {
        int i2 = this.h;
        int i3 = i + i2;
        byte[] bArr = this.l;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 <= length) {
                i3 = length;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.l = bArr2;
        }
    }

    int a(int i) {
        b(5);
        byte[] bArr = this.l;
        int i2 = this.h;
        int i3 = i2 + 1;
        this.h = i3;
        bArr[i2] = 3;
        this.h = c.b(i, bArr, i3);
        this.k.put(this.i, 3);
        int i4 = this.i;
        this.i = i4 + 1;
        return (short) i4;
    }

    Object c(int i) {
        return this.j.getObject(i);
    }

    int a(long j) {
        b(9);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 5;
        this.h = c.a(j, bArr, i2);
        int i3 = this.i;
        this.i = i3 + 2;
        this.k.put(i3, 5);
        return i3;
    }

    short a(String str, String str2, String str3) {
        f fVar = new f(str, str2, str3);
        int i = this.d.get(fVar, -1);
        if (i == -1) {
            short sA = a(str2, str3);
            short sA2 = a(str);
            b(5);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 9;
            int iA = c.a((int) sA2, bArr, i3);
            this.h = iA;
            this.h = c.a((int) sA, this.l, iA);
            i = this.i;
            this.i = i + 1;
            this.d.put(fVar, i);
        }
        a(i, fVar);
        this.k.put(i, 9);
        return (short) i;
    }

    private short a(String str, String str2) {
        short sC = c(str);
        short sC2 = c(str2);
        b(5);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = Ascii.FF;
        int iA = c.a((int) sC, bArr, i2);
        this.h = iA;
        this.h = c.a((int) sC2, this.l, iA);
        this.k.put(this.i, 12);
        int i3 = this.i;
        this.i = i3 + 1;
        return (short) i3;
    }

    int a(String str, int i, int i2) {
        int i3 = 65535;
        if ((i2 - i) * 3 > 65535) {
            while (i != i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == 0 || cCharAt > 127) {
                    i3 = cCharAt < 2047 ? i3 - 2 : i3 - 3;
                } else {
                    i3--;
                }
                if (i3 < 0) {
                    return i;
                }
                i++;
            }
        }
        return i2;
    }

    int a() {
        return this.h + 2;
    }

    void a(int i, Object obj) {
        this.j.put(i, obj);
    }

    int a(byte[] bArr, int i) {
        int iA = c.a((int) ((short) this.i), bArr, i);
        System.arraycopy(this.l, 0, bArr, iA, this.h);
        return iA + this.h;
    }
}
