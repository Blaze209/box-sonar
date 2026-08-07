package sdk.pendo.io.a;

import androidx.media3.common.C;
import kotlin.UShort;

/* JADX INFO: loaded from: classes4.dex */
public class s {
    static final s n = new s();
    short a;
    private short b;
    private int[] c;
    int d;
    private int[] e;
    short f;
    short g;
    short h;
    short i;
    p j;
    s k;
    m l;
    s m;

    private s b(s sVar) {
        for (m mVar = this.l; mVar != null; mVar = mVar.c) {
            if ((this.a & 16) == 0 || mVar != this.l.c) {
                s sVar2 = mVar.b;
                if (sVar2.m == null) {
                    sVar2.m = sVar;
                    sVar = sVar2;
                }
            }
        }
        return sVar;
    }

    final void a(u uVar, boolean z) {
        short s;
        uVar.a(this);
        if (!z || (s = this.b) == 0) {
            return;
        }
        uVar.b(s & UShort.MAX_VALUE, this);
        if (this.c == null) {
            return;
        }
        int i = 1;
        while (true) {
            int[] iArr = this.c;
            if (i > iArr[0]) {
                return;
            }
            uVar.b(iArr[i], this);
            i++;
        }
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }

    private void a(int i, int i2, int i3) {
        if (this.e == null) {
            this.e = new int[6];
        }
        int[] iArr = this.e;
        int i4 = iArr[0];
        if (i4 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.e = iArr2;
        }
        int[] iArr3 = this.e;
        iArr3[i4 + 1] = i;
        int i5 = i4 + 2;
        iArr3[i5] = i2 | i3;
        iArr3[0] = i5;
    }

    final void a(int i) {
        if (this.b == 0) {
            this.b = (short) i;
            return;
        }
        if (this.c == null) {
            this.c = new int[4];
        }
        int[] iArr = this.c;
        int i2 = iArr[0] + 1;
        iArr[0] = i2;
        if (i2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.c = iArr2;
        }
        this.c[i2] = i;
    }

    final void a(s sVar) {
        s sVar2 = n;
        this.m = sVar2;
        while (this != n) {
            s sVar3 = this.m;
            this.m = sVar2;
            if ((this.a & 64) != 0 && this.i != sVar.i) {
                this.l = new m(this.g, sVar.l.b, this.l);
            }
            sVar2 = this;
            this = this.b(sVar3);
        }
        while (sVar2 != n) {
            s sVar4 = sVar2.m;
            sVar2.m = null;
            sVar2 = sVar4;
        }
    }

    final s a() {
        p pVar = this.j;
        return pVar == null ? this : pVar.a;
    }

    final void a(short s) {
        this.m = n;
        while (this != n) {
            s sVar = this.m;
            this.m = null;
            if (this.i == 0) {
                this.i = s;
                this = this.b(sVar);
            } else {
                this = sVar;
            }
        }
    }

    final void a(d dVar, int i, boolean z) {
        if ((this.a & 4) != 0) {
            int i2 = this.d - i;
            if (z) {
                dVar.c(i2);
                return;
            } else {
                dVar.d(i2);
                return;
            }
        }
        if (z) {
            a(i, C.BUFFER_FLAG_LAST_SAMPLE, dVar.b);
            dVar.c(-1);
        } else {
            a(i, 268435456, dVar.b);
            dVar.d(-1);
        }
    }

    final boolean a(byte[] bArr, int i) {
        this.a = (short) (this.a | 4);
        this.d = i;
        int[] iArr = this.e;
        boolean z = false;
        if (iArr == null) {
            return false;
        }
        for (int i2 = iArr[0]; i2 > 0; i2 -= 2) {
            int[] iArr2 = this.e;
            int i3 = iArr2[i2 - 1];
            int i4 = iArr2[i2];
            int i5 = i - i3;
            int i6 = 268435455 & i4;
            if ((i4 & (-268435456)) == 268435456) {
                if (i5 < -32768 || i5 > 32767) {
                    int i7 = bArr[i3] & 255;
                    if (i7 < 198) {
                        bArr[i3] = (byte) (i7 + 49);
                    } else {
                        bArr[i3] = (byte) (i7 + 20);
                    }
                    z = true;
                }
                bArr[i6] = (byte) (i5 >>> 8);
                bArr[i6 + 1] = (byte) i5;
            } else {
                bArr[i6] = (byte) (i5 >>> 24);
                bArr[i6 + 1] = (byte) (i5 >>> 16);
                bArr[i6 + 2] = (byte) (i5 >>> 8);
                bArr[i6 + 3] = (byte) i5;
            }
        }
        return z;
    }
}
