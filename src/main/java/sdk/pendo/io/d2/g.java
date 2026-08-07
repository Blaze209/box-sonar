package sdk.pendo.io.d2;

/* JADX INFO: loaded from: classes4.dex */
final class g {
    private int a;
    private int b;
    private int c;
    private int[] d;
    private int[] e;
    private boolean f;
    private boolean g;

    g(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        int[] iArr2 = new int[iArr.length];
        this.d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.e = new int[0];
        this.f = false;
        this.g = false;
    }

    int a() {
        return this.c;
    }

    int b() {
        return this.a;
    }

    int[] c() {
        int[] iArr = this.d;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    int[] d() {
        int[] iArr = this.e;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    int e() {
        return this.b;
    }

    int[] f() {
        int length = this.d.length - 1;
        while (length >= 0) {
            int[] iArr = this.d;
            if (iArr[length] != 0 || h.e(iArr[length - 1])) {
                break;
            }
            length--;
        }
        int i = length + 1;
        int i2 = 0;
        int i3 = i;
        for (int i4 = 0; i4 < i; i4++) {
            if (h.e(this.d[i4])) {
                i3--;
            }
        }
        int[] iArr2 = new int[i3];
        int i5 = 0;
        while (i2 < i3) {
            int[] iArr3 = this.d;
            iArr2[i2] = iArr3[i5];
            if (h.e(iArr3[i5])) {
                i5++;
            }
            i2++;
            i5++;
        }
        return iArr2;
    }

    boolean g() {
        return this.g;
    }

    boolean h() {
        return this.f;
    }

    public String toString() {
        return "sb " + this.a;
    }

    boolean a(int[] iArr, int i, int[] iArr2, int i2, d dVar) {
        if (this.f) {
            int[] iArr3 = this.d;
            if (iArr3.length == i && this.e.length == i2) {
                return a(iArr3, iArr, i, dVar) || a(this.e, iArr2, i2, dVar);
            }
            throw new IllegalArgumentException("bad merge attempt");
        }
        System.arraycopy(iArr, 0, this.d, 0, i);
        int[] iArr4 = new int[i2];
        this.e = iArr4;
        System.arraycopy(iArr2, 0, iArr4, 0, i2);
        this.f = true;
        return true;
    }

    void b(boolean z) {
        this.f = z;
    }

    private static boolean a(int[] iArr, int[] iArr2, int i, d dVar) {
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int iA = h.a(i3, iArr2[i2], dVar);
            iArr[i2] = iA;
            if (i3 != iA) {
                z = true;
            }
        }
        return z;
    }

    void a(boolean z) {
        this.g = z;
    }
}
