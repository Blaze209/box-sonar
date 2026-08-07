package sdk.pendo.io.x1;

import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    private int a = 0;

    private void b(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            a((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            a((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, (boolean[]) obj2);
        } else {
            a((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public a a(byte b, byte b2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Byte.compare(b, b2);
        return this;
    }

    public a a(char c, char c2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Character.compare(c, c2);
        return this;
    }

    public a a(double d, double d2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Double.compare(d, d2);
        return this;
    }

    public a a(float f, float f2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Float.compare(f, f2);
        return this;
    }

    public a a(int i, int i2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Integer.compare(i, i2);
        return this;
    }

    public a a(long j, long j2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Long.compare(j, j2);
        return this;
    }

    public a a(Object obj, Object obj2) {
        return a(obj, obj2, (Comparator<?>) null);
    }

    public a a(Object obj, Object obj2, Comparator<?> comparator) {
        int iCompareTo;
        if (this.a != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            iCompareTo = -1;
        } else if (obj2 == null) {
            iCompareTo = 1;
        } else {
            if (obj.getClass().isArray()) {
                b(obj, obj2, comparator);
                return this;
            }
            iCompareTo = comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
        }
        this.a = iCompareTo;
        return this;
    }

    public a a(short s, short s2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Short.compare(s, s2);
        return this;
    }

    public a a(boolean z, boolean z2) {
        if (this.a != 0 || z == z2) {
            return this;
        }
        this.a = z ? 1 : -1;
        return this;
    }

    public a a(byte[] bArr, byte[] bArr2) {
        if (this.a == 0 && bArr != bArr2) {
            if (bArr == null) {
                this.a = -1;
                return this;
            }
            if (bArr2 == null) {
                this.a = 1;
                return this;
            }
            if (bArr.length != bArr2.length) {
                this.a = bArr.length >= bArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < bArr.length && this.a == 0; i++) {
                a(bArr[i], bArr2[i]);
            }
        }
        return this;
    }

    public a a(char[] cArr, char[] cArr2) {
        if (this.a == 0 && cArr != cArr2) {
            if (cArr == null) {
                this.a = -1;
                return this;
            }
            if (cArr2 == null) {
                this.a = 1;
                return this;
            }
            if (cArr.length != cArr2.length) {
                this.a = cArr.length >= cArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < cArr.length && this.a == 0; i++) {
                a(cArr[i], cArr2[i]);
            }
        }
        return this;
    }

    public a a(double[] dArr, double[] dArr2) {
        if (this.a == 0 && dArr != dArr2) {
            if (dArr == null) {
                this.a = -1;
                return this;
            }
            if (dArr2 == null) {
                this.a = 1;
                return this;
            }
            if (dArr.length != dArr2.length) {
                this.a = dArr.length >= dArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < dArr.length && this.a == 0; i++) {
                a(dArr[i], dArr2[i]);
            }
        }
        return this;
    }

    public a a(float[] fArr, float[] fArr2) {
        if (this.a == 0 && fArr != fArr2) {
            if (fArr == null) {
                this.a = -1;
                return this;
            }
            if (fArr2 == null) {
                this.a = 1;
                return this;
            }
            if (fArr.length != fArr2.length) {
                this.a = fArr.length >= fArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < fArr.length && this.a == 0; i++) {
                a(fArr[i], fArr2[i]);
            }
        }
        return this;
    }

    public a a(int[] iArr, int[] iArr2) {
        if (this.a == 0 && iArr != iArr2) {
            if (iArr == null) {
                this.a = -1;
                return this;
            }
            if (iArr2 == null) {
                this.a = 1;
                return this;
            }
            if (iArr.length != iArr2.length) {
                this.a = iArr.length >= iArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < iArr.length && this.a == 0; i++) {
                a(iArr[i], iArr2[i]);
            }
        }
        return this;
    }

    public a a(long[] jArr, long[] jArr2) {
        if (this.a == 0 && jArr != jArr2) {
            if (jArr == null) {
                this.a = -1;
                return this;
            }
            if (jArr2 == null) {
                this.a = 1;
                return this;
            }
            if (jArr.length != jArr2.length) {
                this.a = jArr.length >= jArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < jArr.length && this.a == 0; i++) {
                a(jArr[i], jArr2[i]);
            }
        }
        return this;
    }

    public a a(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.a == 0 && objArr != objArr2) {
            if (objArr == null) {
                this.a = -1;
                return this;
            }
            if (objArr2 == null) {
                this.a = 1;
                return this;
            }
            if (objArr.length != objArr2.length) {
                this.a = objArr.length >= objArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < objArr.length && this.a == 0; i++) {
                a(objArr[i], objArr2[i], comparator);
            }
        }
        return this;
    }

    public a a(short[] sArr, short[] sArr2) {
        if (this.a == 0 && sArr != sArr2) {
            if (sArr == null) {
                this.a = -1;
                return this;
            }
            if (sArr2 == null) {
                this.a = 1;
                return this;
            }
            if (sArr.length != sArr2.length) {
                this.a = sArr.length >= sArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < sArr.length && this.a == 0; i++) {
                a(sArr[i], sArr2[i]);
            }
        }
        return this;
    }

    public a a(boolean[] zArr, boolean[] zArr2) {
        if (this.a == 0 && zArr != zArr2) {
            if (zArr == null) {
                this.a = -1;
                return this;
            }
            if (zArr2 == null) {
                this.a = 1;
                return this;
            }
            if (zArr.length != zArr2.length) {
                this.a = zArr.length >= zArr2.length ? 1 : -1;
                return this;
            }
            for (int i = 0; i < zArr.length && this.a == 0; i++) {
                a(zArr[i], zArr2[i]);
            }
        }
        return this;
    }

    public int a() {
        return this.a;
    }
}
