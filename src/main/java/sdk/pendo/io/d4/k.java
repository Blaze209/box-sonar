package sdk.pendo.io.d4;

/* JADX INFO: loaded from: classes4.dex */
public final class k<T> {
    final float a;
    int b;
    int c;
    int d;
    T[] e;

    public k() {
        this(16, 0.75f);
    }

    static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int iA = a(t.hashCode()) & i;
        T t3 = tArr[iA];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                iA = (iA + 1) & i;
                t2 = tArr[iA];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[iA] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            b();
        }
        return true;
    }

    void b() {
        T t;
        T[] tArr = this.e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.b = i2;
                this.d = (int) (i * this.a);
                this.e = tArr2;
                return;
            }
            do {
                length--;
                t = tArr[length];
            } while (t == null);
            int iA = a(t.hashCode()) & i2;
            if (tArr2[iA] != null) {
                do {
                    iA = (iA + 1) & i2;
                } while (tArr2[iA] != null);
            }
            tArr2[iA] = tArr[length];
            i3 = i4;
        }
    }

    public k(int i, float f) {
        this.a = f;
        int iA = l.a(i);
        this.b = iA - 1;
        this.d = (int) (f * iA);
        this.e = (T[]) new Object[iA];
    }

    public Object[] a() {
        return this.e;
    }

    public boolean b(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int iA = a(t.hashCode()) & i;
        T t3 = tArr[iA];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(iA, tArr, i);
        }
        do {
            iA = (iA + 1) & i;
            t2 = tArr[iA];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(iA, tArr, i);
    }

    boolean a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t != null) {
                    int iA = a(t.hashCode()) & i2;
                    if (i > i3) {
                        if (i >= iA && iA > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    } else {
                        if (i >= iA || iA > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                } else {
                    tArr[i] = null;
                    return true;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }
}
