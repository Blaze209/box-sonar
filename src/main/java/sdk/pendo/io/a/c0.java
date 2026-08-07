package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
final class c0 {
    final h a;
    private final e b;
    private int c;
    private String d;
    private int e;
    private a[] f;
    private int g;
    private d h;
    private int i;
    private d j;
    private int k;
    private a[] l;

    private static class a extends b0 {
        final int h;
        a i;

        a(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.h = i3;
        }

        a(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.h = i3;
        }

        a(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.h = i3;
        }

        a(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.h = i3;
        }

        a(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.h = i3;
        }
    }

    c0(h hVar) {
        this.a = hVar;
        this.b = null;
        this.f = new a[256];
        this.g = 1;
        this.h = new d();
    }

    private void a(a aVar) {
        this.e++;
        int i = aVar.h;
        a[] aVarArr = this.f;
        int length = i % aVarArr.length;
        aVar.i = aVarArr[length];
        aVarArr[length] = aVar;
    }

    private static int b(int i, long j) {
        return (i + ((int) j) + ((int) (j >>> 32))) & Integer.MAX_VALUE;
    }

    private void b(int i, int i2, int i3) {
        a(new a(i, i2, i3, c(i2, i3)));
    }

    private static int c(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    b0 c(String str) {
        return b(19, str);
    }

    b0 d(String str) {
        return b(20, str);
    }

    b0 e(String str) {
        return b(8, str);
    }

    int f(String str) {
        int iC = c(1, str);
        for (a aVarB = b(iC); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 1 && aVarB.h == iC && aVarB.e.equals(str)) {
                return aVarB.a;
            }
        }
        this.h.b(1).a(str);
        int i = this.g;
        this.g = i + 1;
        return c(new a(i, 1, str, iC)).a;
    }

    int g(String str) {
        int iC = c(128, str);
        for (a aVarB = b(iC); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 128 && aVarB.h == iC && aVarB.e.equals(str)) {
                return aVarB.a;
            }
        }
        return b(new a(this.k, 128, str, iC));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ef  */
    c0(h hVar, e eVar) {
        int i;
        this.a = hVar;
        this.b = eVar;
        byte[] bArr = eVar.c;
        int iA = eVar.a(1) - 1;
        int i2 = eVar.b - iA;
        this.g = eVar.b();
        d dVar = new d(i2);
        this.h = dVar;
        dVar.a(bArr, iA, i2);
        this.f = new a[this.g * 2];
        char[] cArr = new char[eVar.c()];
        boolean z = false;
        int i3 = 1;
        while (i3 < this.g) {
            int iA2 = eVar.a(i3);
            byte b = bArr[iA2 - 1];
            switch (b) {
                case 1:
                    this.a(i3, eVar.h(i3, cArr));
                    if (b != 5 || b == 6) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    i3 += i;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    this.b(i3, b, eVar.d(iA2));
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
                case 5:
                case 6:
                    this.a(i3, b, eVar.e(iA2));
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    this.a(i3, b, eVar.g(iA2, cArr));
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
                case 9:
                case 10:
                case 11:
                    int iA3 = eVar.a(eVar.g(iA2 + 2));
                    String strA = eVar.a(iA2, cArr);
                    String strG = eVar.g(iA3, cArr);
                    String strG2 = eVar.g(iA3 + 2, cArr);
                    b = b;
                    this.a(i3, b, strA, strG, strG2);
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
                case 12:
                    this.a(i3, eVar.g(iA2, cArr), eVar.g(iA2 + 2, cArr));
                    b = b;
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
                case 15:
                    int iA4 = eVar.a(eVar.g(iA2 + 1));
                    int iA5 = eVar.a(eVar.g(iA4 + 2));
                    this.b(i3, eVar.c(iA2), eVar.a(iA4, cArr), eVar.g(iA5, cArr), eVar.g(iA5 + 2, cArr));
                    b = b;
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
                case 17:
                case 18:
                    int iA6 = eVar.a(eVar.g(iA2 + 2));
                    String strG3 = eVar.g(iA6, cArr);
                    String strG4 = eVar.g(iA6 + 2, cArr);
                    int iG = eVar.g(iA2);
                    int i4 = i3;
                    c0 c0Var = this;
                    c0Var.a(b, i4, strG3, strG4, iG);
                    b = b;
                    i3 = i4;
                    z = true;
                    this = c0Var;
                    if (b != 5) {
                        i = 2;
                    } else {
                        i = 2;
                    }
                    i3 += i;
                    break;
            }
        }
        if (z) {
            this.a(eVar, cArr);
        }
    }

    private b0 a(int i, int i2, int i3) {
        byte[] bArr = this.j.a;
        for (a aVarB = b(i3); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 64 && aVarB.h == i3) {
                int i4 = (int) aVarB.f;
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        this.j.b = i;
                        return aVarB;
                    }
                    if (bArr[i + i5] != bArr[i4 + i5]) {
                        break;
                    }
                    i5++;
                }
            }
        }
        int i6 = this.i;
        this.i = i6 + 1;
        return c(new a(i6, 64, i, i3));
    }

    b0 b(String str, String str2, q qVar, Object... objArr) {
        return a(18, str, str2, a(qVar, objArr).a);
    }

    int c() {
        return this.g;
    }

    int d() {
        return this.h.b;
    }

    int e() {
        return this.c;
    }

    e f() {
        return this.b;
    }

    private void b(int i, int i2, String str, String str2, String str3) {
        a(new a(i, 15, str, str2, str3, i2, a(15, str, str2, str3, i2)));
    }

    b0 a(q qVar, Object... objArr) {
        d dVar = this.j;
        if (dVar == null) {
            dVar = new d();
            this.j = dVar;
        }
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = a(objArr[i]).a;
        }
        int i2 = dVar.b;
        dVar.d(a(qVar.d(), qVar.c(), qVar.b(), qVar.a(), qVar.e()).a);
        dVar.d(length);
        for (int i3 = 0; i3 < length; i3++) {
            dVar.d(iArr[i3]);
        }
        int i4 = dVar.b - i2;
        int iHashCode = qVar.hashCode();
        for (Object obj : objArr) {
            iHashCode ^= obj.hashCode();
        }
        return a(i2, i4, iHashCode & Integer.MAX_VALUE);
    }

    b0 c(int i) {
        return this.l[i];
    }

    int d(int i, String str) {
        this.c = i;
        this.d = str;
        return a(str).a;
    }

    b0 a(Object obj) {
        if (obj instanceof Integer) {
            return a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return a(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return a(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return a(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return e((String) obj);
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            int iC = d0Var.c();
            if (iC == 10) {
                return a(d0Var.b());
            }
            String strA = d0Var.a();
            return iC == 11 ? b(strA) : a(strA);
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return a(qVar.d(), qVar.c(), qVar.b(), qVar.a(), qVar.e());
        }
        if (!(obj instanceof i)) {
            throw new IllegalArgumentException("value " + obj);
        }
        i iVar = (i) obj;
        return a(iVar.d(), iVar.c(), iVar.a(), iVar.b());
    }

    b0 b(String str) {
        return b(16, str);
    }

    private b0 b(int i, String str) {
        int iC = c(i, str);
        for (a aVarB = b(iC); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == i && aVarB.h == iC && aVarB.e.equals(str)) {
                return aVarB;
            }
        }
        this.h.b(i, f(str));
        int i2 = this.g;
        this.g = i2 + 1;
        return c(new a(i2, i, str, iC));
    }

    private static int c(int i, String str) {
        return (i + str.hashCode()) & Integer.MAX_VALUE;
    }

    b0 a(String str) {
        return b(7, str);
    }

    private a c(a aVar) {
        int i = this.e;
        a[] aVarArr = this.f;
        if (i > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i2 = (length * 2) + 1;
            a[] aVarArr2 = new a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                a aVar2 = this.f[i3];
                while (aVar2 != null) {
                    int i4 = aVar2.h % i2;
                    a aVar3 = aVar2.i;
                    aVar2.i = aVarArr2[i4];
                    aVarArr2[i4] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f = aVarArr2;
        }
        this.e++;
        int i5 = aVar.h;
        a[] aVarArr3 = this.f;
        int length2 = i5 % aVarArr3.length;
        aVar.i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    b0 a(double d) {
        return a(6, Double.doubleToRawLongBits(d));
    }

    int b(int i, int i2) {
        long j;
        long j2;
        if (i < i2) {
            j = i;
            j2 = i2;
        } else {
            j = i2;
            j2 = i;
        }
        long j3 = j | (j2 << 32);
        int iC = c(130, i + i2);
        for (a aVarB = b(iC); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 130 && aVarB.h == iC && aVarB.f == j3) {
                return aVarB.g;
            }
        }
        a[] aVarArr = this.l;
        int iG = g(this.a.b(aVarArr[i].e, aVarArr[i2].e));
        c(new a(this.k, 130, j3, iC)).g = iG;
        return iG;
    }

    private int b(a aVar) {
        if (this.l == null) {
            this.l = new a[16];
        }
        int i = this.k;
        a[] aVarArr = this.l;
        if (i == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.l = aVarArr2;
        }
        a[] aVarArr3 = this.l;
        int i2 = this.k;
        this.k = i2 + 1;
        aVarArr3[i2] = aVar;
        return c(aVar).a;
    }

    b0 a(String str, String str2, q qVar, Object... objArr) {
        return a(17, str, str2, a(qVar, objArr).a);
    }

    private b0 a(int i, String str, String str2, int i2) {
        int iB = b(i, str, str2, i2);
        for (a aVarB = b(iB); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == i && aVarB.h == iB && aVarB.f == i2 && aVarB.d.equals(str) && aVarB.e.equals(str2)) {
                return aVarB;
            }
        }
        this.h.b(i, i2, a(str, str2));
        int i3 = this.g;
        this.g = i3 + 1;
        return c(new a(i3, i, null, str, str2, i2, iB));
    }

    private a b(int i) {
        a[] aVarArr = this.f;
        return aVarArr[i % aVarArr.length];
    }

    private void a(int i, int i2, String str, String str2, int i3) {
        a(new a(i2, i, null, str, str2, i3, b(i, str, str2, i3)));
    }

    String b() {
        return this.d;
    }

    b0 a(String str, String str2, String str3) {
        return a(9, str, str2, str3);
    }

    private static int b(int i, String str, String str2) {
        return (i + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
    }

    b0 a(float f) {
        return a(4, Float.floatToRawIntBits(f));
    }

    private static int b(int i, String str, String str2, int i2) {
        return (i + (str.hashCode() * str2.hashCode() * (i2 + 1))) & Integer.MAX_VALUE;
    }

    b0 a(int i) {
        return a(3, i);
    }

    private b0 a(int i, int i2) {
        int iC = c(i, i2);
        for (a aVarB = b(iC); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == i && aVarB.h == iC && aVarB.f == i2) {
                return aVarB;
            }
        }
        this.h.b(i).c(i2);
        int i3 = this.g;
        this.g = i3 + 1;
        return c(new a(i3, i, i2, iC));
    }

    private static int b(int i, String str, String str2, String str3) {
        return (i + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
    }

    b0 a(long j) {
        return a(5, j);
    }

    void b(d dVar) {
        d dVarD = dVar.d(this.g);
        d dVar2 = this.h;
        dVarD.a(dVar2.a, 0, dVar2.b);
    }

    private b0 a(int i, long j) {
        int iB = b(i, j);
        for (a aVarB = b(iB); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == i && aVarB.h == iB && aVarB.f == j) {
                return aVarB;
            }
        }
        int i2 = this.g;
        this.h.b(i).a(j);
        this.g += 2;
        return c(new a(i2, i, j, iB));
    }

    private void a(int i, int i2, long j) {
        a(new a(i, i2, j, b(i2, j)));
    }

    private a a(int i, String str, String str2, String str3) {
        int iB = b(i, str, str2, str3);
        for (a aVarB = b(iB); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == i && aVarB.h == iB && aVarB.c.equals(str) && aVarB.d.equals(str2) && aVarB.e.equals(str3)) {
                return aVarB;
            }
        }
        this.h.b(i, a(str).a, a(str2, str3));
        int i2 = this.g;
        this.g = i2 + 1;
        return c(new a(i2, i, str, str2, str3, 0L, iB));
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        a(new a(i, i2, str, str2, str3, 0L, b(i2, str, str2, str3)));
    }

    b0 a(int i, String str, String str2, String str3, boolean z) {
        int iA = a(15, str, str2, str3, i);
        for (a aVarB = b(iA); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 15 && aVarB.h == iA && aVarB.f == i && aVarB.c.equals(str) && aVarB.d.equals(str2) && aVarB.e.equals(str3)) {
                return aVarB;
            }
        }
        if (i <= 4) {
            this.h.a(15, i, a(str, str2, str3).a);
        } else {
            this.h.a(15, i, a(str, str2, str3, z).a);
        }
        int i2 = this.g;
        this.g = i2 + 1;
        return c(new a(i2, 15, str, str2, str3, i, iA));
    }

    b0 a(String str, String str2, String str3, boolean z) {
        return a(z ? 11 : 10, str, str2, str3);
    }

    int a(String str, String str2) {
        int iB = b(12, str, str2);
        for (a aVarB = b(iB); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 12 && aVarB.h == iB && aVarB.d.equals(str) && aVarB.e.equals(str2)) {
                return aVarB.a;
            }
        }
        this.h.b(12, f(str), f(str2));
        int i = this.g;
        this.g = i + 1;
        return c(new a(i, 12, str, str2, iB)).a;
    }

    private void a(int i, String str, String str2) {
        a(new a(i, 12, str, str2, b(12, str, str2)));
    }

    private void a(int i, String str) {
        a(new a(i, 1, str, c(1, str)));
    }

    private void a(int i, int i2, String str) {
        a(new a(i, i2, str, c(i2, str)));
    }

    int a(String str, int i) {
        int iA = a(129, str, i);
        for (a aVarB = b(iA); aVarB != null; aVarB = aVarB.i) {
            if (aVarB.b == 129 && aVarB.h == iA && aVarB.f == i && aVarB.e.equals(str)) {
                return aVarB.a;
            }
        }
        return b(new a(this.k, 129, str, i, iA));
    }

    int a() {
        if (this.j == null) {
            return 0;
        }
        f("BootstrapMethods");
        return this.j.b + 8;
    }

    private void a(e eVar, char[] cArr) {
        byte[] bArr = eVar.c;
        int iA = eVar.a();
        for (int iG = eVar.g(iA - 2); iG > 0; iG--) {
            if ("BootstrapMethods".equals(eVar.g(iA, cArr))) {
                this.i = eVar.g(iA + 6);
                break;
            }
            iA += eVar.d(iA + 2) + 6;
        }
        if (this.i > 0) {
            int i = iA + 8;
            int iD = eVar.d(iA + 2) - 2;
            d dVar = new d(iD);
            this.j = dVar;
            dVar.a(bArr, i, iD);
            int i2 = i;
            for (int i3 = 0; i3 < this.i; i3++) {
                int i4 = i2 - i;
                int iG2 = eVar.g(i2);
                int iG3 = eVar.g(i2 + 2);
                i2 += 4;
                int iHashCode = eVar.b(iG2, cArr).hashCode();
                while (true) {
                    int i5 = iG3 - 1;
                    if (iG3 > 0) {
                        int iG4 = eVar.g(i2);
                        i2 += 2;
                        iHashCode ^= eVar.b(iG4, cArr).hashCode();
                        iG3 = i5;
                    }
                }
                a(new a(i3, 64, i4, iHashCode & Integer.MAX_VALUE));
            }
        }
    }

    private static int a(int i, String str, int i2) {
        return (i + str.hashCode() + i2) & Integer.MAX_VALUE;
    }

    private static int a(int i, String str, String str2, String str3, int i2) {
        return (i + (str.hashCode() * str2.hashCode() * str3.hashCode() * i2)) & Integer.MAX_VALUE;
    }

    void a(d dVar) {
        if (this.j != null) {
            d dVarD = dVar.d(f("BootstrapMethods")).c(this.j.b + 2).d(this.i);
            d dVar2 = this.j;
            dVarD.a(dVar2.a, 0, dVar2.b);
        }
    }
}
