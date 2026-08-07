package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    byte[] a;
    int b;

    public d() {
        this.a = new byte[64];
    }

    final d a(String str, int i, int i2) {
        int length = str.length();
        int i3 = i;
        int i4 = i3;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 1 || cCharAt > 127) {
                i4 = cCharAt <= 2047 ? i4 + 2 : i4 + 3;
            } else {
                i4++;
            }
            i3++;
        }
        if (i4 > i2) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i5 = this.b;
        int i6 = i5 - i;
        int i7 = i6 - 2;
        if (i7 >= 0) {
            byte[] bArr = this.a;
            bArr[i7] = (byte) (i4 >>> 8);
            bArr[i6 - 1] = (byte) i4;
        }
        if ((i5 + i4) - i > this.a.length) {
            a(i4 - i);
        }
        int i8 = this.b;
        while (i < length) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 1 || cCharAt2 > 127) {
                byte[] bArr2 = this.a;
                int i9 = i8 + 1;
                if (cCharAt2 <= 2047) {
                    bArr2[i8] = (byte) (((cCharAt2 >> 6) & 31) | 192);
                    i8 += 2;
                    bArr2[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    bArr2[i8] = (byte) (((cCharAt2 >> '\f') & 15) | 224);
                    int i10 = i8 + 2;
                    bArr2[i9] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                    i8 += 3;
                    bArr2[i10] = (byte) ((cCharAt2 & '?') | 128);
                }
            } else {
                this.a[i8] = (byte) cCharAt2;
                i8++;
            }
            i++;
        }
        this.b = i8;
        return this;
    }

    final d b(int i, int i2) {
        int i3 = this.b;
        if (i3 + 3 > this.a.length) {
            a(3);
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) i2;
        this.b = i3 + 3;
        return this;
    }

    public d c(int i) {
        int i2 = this.b;
        if (i2 + 4 > this.a.length) {
            a(4);
        }
        byte[] bArr = this.a;
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.b = i2 + 4;
        return this;
    }

    public d d(int i) {
        int i2 = this.b;
        if (i2 + 2 > this.a.length) {
            a(2);
        }
        byte[] bArr = this.a;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        this.b = i2 + 2;
        return this;
    }

    public d(int i) {
        this.a = new byte[i];
    }

    private void a(int i) {
        byte[] bArr = this.a;
        int length = bArr.length * 2;
        int i2 = this.b;
        int i3 = i + i2;
        if (length <= i3) {
            length = i3;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.a = bArr2;
    }

    final d b(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 + 5 > this.a.length) {
            a(5);
        }
        byte[] bArr = this.a;
        bArr[i4] = (byte) i;
        bArr[i4 + 1] = (byte) (i2 >>> 8);
        bArr[i4 + 2] = (byte) i2;
        bArr[i4 + 3] = (byte) (i3 >>> 8);
        bArr[i4 + 4] = (byte) i3;
        this.b = i4 + 5;
        return this;
    }

    d(byte[] bArr) {
        this.a = bArr;
        this.b = bArr.length;
    }

    final d a(int i, int i2) {
        int i3 = this.b;
        if (i3 + 2 > this.a.length) {
            a(2);
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) i2;
        this.b = i3 + 2;
        return this;
    }

    public d b(int i) {
        int i2 = this.b;
        int i3 = i2 + 1;
        if (i3 > this.a.length) {
            a(1);
        }
        this.a[i2] = (byte) i;
        this.b = i3;
        return this;
    }

    final d a(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 + 4 > this.a.length) {
            a(4);
        }
        byte[] bArr = this.a;
        bArr[i4] = (byte) i;
        bArr[i4 + 1] = (byte) i2;
        bArr[i4 + 2] = (byte) (i3 >>> 8);
        bArr[i4 + 3] = (byte) i3;
        this.b = i4 + 4;
        return this;
    }

    public d a(byte[] bArr, int i, int i2) {
        if (this.b + i2 > this.a.length) {
            a(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.a, this.b, i2);
        }
        this.b += i2;
        return this;
    }

    public d a(long j) {
        int i = this.b;
        if (i + 8 > this.a.length) {
            a(8);
        }
        byte[] bArr = this.a;
        int i2 = (int) (j >>> 32);
        bArr[i] = (byte) (i2 >>> 24);
        bArr[i + 1] = (byte) (i2 >>> 16);
        bArr[i + 2] = (byte) (i2 >>> 8);
        bArr[i + 3] = (byte) i2;
        int i3 = (int) j;
        bArr[i + 4] = (byte) (i3 >>> 24);
        bArr[i + 5] = (byte) (i3 >>> 16);
        bArr[i + 6] = (byte) (i3 >>> 8);
        bArr[i + 7] = (byte) i3;
        this.b = i + 8;
        return this;
    }

    public d a(String str) {
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i = this.b;
        if (i + 2 + length > this.a.length) {
            a(length + 2);
        }
        byte[] bArr = this.a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i + 2;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 1 || cCharAt > 127) {
                this.b = i3;
                return a(str, i4, 65535);
            }
            bArr[i3] = (byte) cCharAt;
            i4++;
            i3++;
        }
        this.b = i3;
        return this;
    }
}
