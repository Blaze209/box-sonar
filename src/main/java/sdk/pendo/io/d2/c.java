package sdk.pendo.io.d2;

import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.UintMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final int E;
    private static final int F;
    private static final boolean G;
    private ObjArray A;
    private ObjArray B;
    private String d;
    private e[] e;
    private int f;
    private int[] g;
    private int h;
    private int j;
    private d k;
    private sdk.pendo.io.d2.b l;
    private short m;
    private short n;
    private short o;
    private short s;
    private short t;
    private short u;
    private short v;
    private int[] w;
    private int x;
    private long[] y;
    private int z;
    private int[] a = null;
    private int b = 0;
    private UintMap c = null;
    private byte[] i = new byte[256];
    private ObjArray p = new ObjArray();
    private ObjArray q = new ObjArray();
    private ObjArray r = new ObjArray();
    private int C = 0;
    private char[] D = new char[64];

    final class a {
        final byte[] a;

        public boolean equals(Object obj) {
            return (obj instanceof a) && Arrays.equals(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return ~Arrays.hashCode(this.a);
        }
    }

    public static class b extends RuntimeException {
        b(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.d2.c$c, reason: collision with other inner class name */
    final class C0372c {
        private g[] g = null;
        private int[] c = null;
        private int[] a = null;
        private g[] e = null;
        private byte[] h = null;
        private int b = 0;
        private int d = 0;
        private int f = 0;
        private int i = 0;
        private boolean j = false;

        C0372c() {
        }

        private void a(g gVar) {
            if (gVar.g()) {
                return;
            }
            gVar.a(true);
            gVar.b(true);
            int i = this.f;
            g[] gVarArr = this.e;
            if (i == gVarArr.length) {
                g[] gVarArr2 = new g[i * 2];
                System.arraycopy(gVarArr, 0, gVarArr2, 0, i);
                this.e = gVarArr2;
            }
            g[] gVarArr3 = this.e;
            int i2 = this.f;
            this.f = i2 + 1;
            gVarArr3[i2] = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0068  */
        private void b() {
            int[] iArrF = this.g[0].f();
            int iE = -1;
            int i = 1;
            while (true) {
                g[] gVarArr = this.g;
                if (i >= gVarArr.length) {
                    return;
                }
                g gVar = gVarArr[i];
                int[] iArrF2 = gVar.f();
                int[] iArrD = gVar.d();
                int iE2 = (gVar.e() - iE) - 1;
                if (iArrD.length == 0) {
                    int length = iArrF.length > iArrF2.length ? iArrF2.length : iArrF.length;
                    int iAbs = Math.abs(iArrF.length - iArrF2.length);
                    int i2 = 0;
                    while (i2 < length && iArrF[i2] == iArrF2[i2]) {
                        i2++;
                    }
                    if (i2 == iArrF2.length && iAbs == 0) {
                        k(iE2);
                    } else if (i2 == iArrF2.length && iAbs <= 3) {
                        e(iAbs, iE2);
                    } else if (i2 != iArrF.length || iAbs > 3) {
                        a(iArrF2, iArrD, iE2);
                    } else {
                        a(iArrF2, iAbs, iE2);
                    }
                } else if (iArrD.length == 1 && Arrays.equals(iArrF, iArrF2)) {
                    a(iArrD, iE2);
                } else {
                    a(iArrF2, iArrD, iE2);
                }
                iE = gVar.e();
                i++;
                iArrF = iArrF2;
            }
        }

        private void d() {
            while (true) {
                int i = this.f;
                if (i <= 0) {
                    return;
                }
                g[] gVarArr = this.e;
                int i2 = i - 1;
                this.f = i2;
                g gVar = gVarArr[i2];
                gVar.a(false);
                this.a = gVar.c();
                int[] iArrD = gVar.d();
                this.c = iArrD;
                this.b = this.a.length;
                this.d = iArrD.length;
                b(gVar);
            }
        }

        private int f(int i) {
            return b(i, 1);
        }

        private g g(int i) {
            g gVar;
            int i2 = 0;
            while (true) {
                g[] gVarArr = this.g;
                if (i2 >= gVarArr.length || (gVar = gVarArr[i2]) == null) {
                    break;
                }
                if (i >= gVar.e() && i < gVar.a()) {
                    return gVar;
                }
                i2++;
            }
            throw new IllegalArgumentException("bad offset: " + i);
        }

        private boolean h(int i) {
            switch (i) {
                case Token.SET /* 153 */:
                case Token.LET /* 154 */:
                case Token.CONST /* 155 */:
                case Token.SETCONST /* 156 */:
                case Token.SETCONSTVAR /* 157 */:
                case Token.ARRAYCOMP /* 158 */:
                case Token.LETEXPR /* 159 */:
                case 160:
                case Token.DEBUGGER /* 161 */:
                case Token.COMMENT /* 162 */:
                case Token.GENEXPR /* 163 */:
                case Token.METHOD /* 164 */:
                case Token.ARROW /* 165 */:
                case Token.YIELD_STAR /* 166 */:
                case Token.LAST_TOKEN /* 167 */:
                    return true;
                default:
                    switch (i) {
                        case 198:
                        case 199:
                        case 200:
                            return true;
                        default:
                            return false;
                    }
            }
        }

        private boolean i(int i) {
            if (i == 167 || i == 191 || i == 200 || i == 176 || i == 177) {
                return true;
            }
            switch (i) {
                case Context.VERSION_1_7 /* 170 */:
                case 171:
                case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                case 173:
                case 174:
                    return true;
                default:
                    return false;
            }
        }

        private void j(int i) {
            int i2 = this.d;
            if (i2 == this.c.length) {
                int[] iArr = new int[Math.max(i2 * 2, 4)];
                System.arraycopy(this.c, 0, iArr, 0, this.d);
                this.c = iArr;
            }
            int[] iArr2 = this.c;
            int i3 = this.d;
            this.d = i3 + 1;
            iArr2[i3] = i;
        }

        private void k(int i) {
            if (i <= 63) {
                byte[] bArr = this.h;
                int i2 = this.i;
                this.i = i2 + 1;
                bArr[i2] = (byte) i;
                return;
            }
            byte[] bArr2 = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr2[i3] = -5;
            this.i = c.a(i, bArr2, i4);
        }

        private int l(int i) {
            int i2 = i & 255;
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) i2;
            if (i2 == 7 || i2 == 8) {
                this.i = c.a(i >>> 8, bArr, i4);
            }
            return this.i;
        }

        int c() {
            this.h = new byte[f()];
            b();
            return this.i + 2;
        }

        void e() {
            this.g = new g[c.this.b];
            int[] iArrC = c.this.c();
            int i = 0;
            while (i < c.this.b) {
                this.g[i] = new g(i, c.this.a[i], i == c.this.b + (-1) ? c.this.j : c.this.a[i + 1], iArrC);
                i++;
            }
            i();
        }

        private void a() {
            this.d = 0;
        }

        private void b(int i) {
            int iE = e(i);
            int iD = h.d(iE);
            if (iD != 7 && iD != 6 && iD != 8 && iD != 5) {
                throw new IllegalStateException("bad local variable type: " + iE + " at index: " + i);
            }
            j(iE);
        }

        private void c(int i) {
            d(i, g());
        }

        private g d(int i) {
            return g(i + ((c.this.i[i] & 255) == 200 ? b(i + 1, 4) : (short) b(i + 1, 2)));
        }

        private int e(int i) {
            if (i < this.b) {
                return this.a[i];
            }
            return 0;
        }

        private int f() {
            return (this.g.length - 1) * ((c.this.o * 3) + 7 + (c.this.n * 3));
        }

        private int g() {
            int[] iArr = this.c;
            int i = this.d - 1;
            this.d = i;
            return iArr[i];
        }

        private long h() {
            long jG = g();
            return h.e((int) jG) ? jG : (jG << 32) | ((long) (g() & ViewCompat.MEASURED_SIZE_MASK));
        }

        private void i() {
            int[] iArrC = c.this.c();
            int i = 0;
            this.g[0].a(iArrC, iArrC.length, new int[0], 0, c.this.k);
            this.e = new g[]{this.g[0]};
            this.f = 1;
            d();
            while (true) {
                g[] gVarArr = this.g;
                if (i >= gVarArr.length) {
                    d();
                    return;
                }
                g gVar = gVarArr[i];
                if (!gVar.h()) {
                    d(gVar);
                }
                i++;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:120:0x0312  */
        /* JADX WARN: Code duplicated, block: B:121:0x0314  */
        /* JADX WARN: Code duplicated, block: B:122:0x0316  */
        /* JADX WARN: Code duplicated, block: B:123:0x0318  */
        /* JADX WARN: Code duplicated, block: B:127:0x031f  */
        /* JADX WARN: Code duplicated, block: B:130:0x0329  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x00e1, code lost:
        
            if (r12.equals(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x014f, code lost:
        
            if (r12.equals(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) == false) goto L37;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(int r12) {
            /*
                Method dump skipped, instruction units count: 1222
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d2.c.C0372c.a(int):int");
        }

        private void b(g gVar) {
            int iE = gVar.e();
            int i = 0;
            while (iE < gVar.a()) {
                i = c.this.i[iE] & 255;
                int iA = a(iE);
                if (h(i)) {
                    c(d(iE));
                } else if (i == 170) {
                    int i2 = iE + 1 + ((~iE) & 3);
                    c(g(b(i2, 4) + iE));
                    int iB = (b(i2 + 8, 4) - b(i2 + 4, 4)) + 1;
                    int i3 = i2 + 12;
                    for (int i4 = 0; i4 < iB; i4++) {
                        c(g(b((i4 * 4) + i3, 4) + iE));
                    }
                }
                for (int i5 = 0; i5 < c.this.f; i5++) {
                    e eVar = c.this.e[i5];
                    int iU = c.this.u(eVar.a);
                    int iU2 = c.this.u(eVar.b);
                    if (iE >= iU && iE < iU2) {
                        g gVarG = g(c.this.u(eVar.c));
                        short sA = eVar.d;
                        if (sA == 0) {
                            sA = c.this.k.a("java/lang/Throwable");
                        }
                        gVarG.a(this.a, this.b, new int[]{h.a(sA)}, 1, c.this.k);
                        a(gVarG);
                    }
                }
                iE += iA;
            }
            if (i(i)) {
                return;
            }
            int iB2 = gVar.b() + 1;
            g[] gVarArr = this.g;
            if (iB2 < gVarArr.length) {
                c(gVarArr[iB2]);
            }
        }

        private void c(g gVar) {
            if (gVar.a(this.a, this.b, this.c, this.d, c.this.k)) {
                a(gVar);
            }
        }

        private void d(g gVar) {
            int[] iArrC = new int[0];
            int[] iArr = {h.a("java/lang/Throwable", c.this.k)};
            for (int i = 0; i < c.this.f; i++) {
                e eVar = c.this.e[i];
                int iU = c.this.u(eVar.a);
                int iU2 = c.this.u(eVar.b);
                g gVarG = g(c.this.u(eVar.c));
                if ((gVar.e() > iU && gVar.e() < iU2) || (iU > gVar.e() && iU < gVar.a() && gVarG.h())) {
                    iArrC = gVarG.c();
                    break;
                }
            }
            int[] iArr2 = iArrC;
            int i2 = 0;
            while (i2 < c.this.f) {
                if (c.this.u(c.this.e[i2].a) == gVar.e()) {
                    for (int i3 = i2 + 1; i3 < c.this.f; i3++) {
                        c.this.e[i3 - 1] = c.this.e[i3];
                    }
                    c.i(c.this);
                    i2--;
                }
                i2++;
            }
            gVar.a(iArr2, iArr2.length, iArr, 1, c.this.k);
            int iA = gVar.a() - 1;
            c.this.i[iA] = ByteSourceJsonBootstrapper.UTF8_BOM_3;
            for (int iE = gVar.e(); iE < iA; iE++) {
                c.this.i[iE] = 0;
            }
        }

        private void e(int i, int i2) {
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) (251 - i);
            this.i = c.a(i2, bArr, i4);
        }

        private void a(int i, int i2) {
            g();
            d(i, i2);
        }

        private int b(int i, int i2) {
            if (i2 > 4) {
                throw new IllegalArgumentException("bad operand size");
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = (i3 << 8) | (c.this.i[i + i4] & 255);
            }
            return i3;
        }

        private void c(int i, int i2) {
            a(i, i2, this.a, this.b);
            a(i, i2, this.c, this.d);
        }

        private void d(int i, int i2) {
            int i3 = this.b;
            if (i >= i3) {
                int i4 = i + 1;
                int[] iArr = new int[i4];
                System.arraycopy(this.a, 0, iArr, 0, i3);
                this.a = iArr;
                this.b = i4;
            }
            this.a[i] = i2;
        }

        private void a(int i, int i2, int[] iArr, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (iArr[i4] == i) {
                    iArr[i4] = i2;
                }
            }
        }

        private int b(int[] iArr, int i) {
            while (i < iArr.length) {
                this.i = l(iArr[i]);
                i++;
            }
            return this.i;
        }

        private void a(long j) {
            j((int) (j & 16777215));
            long j2 = j >>> 32;
            if (j2 != 0) {
                j((int) (j2 & 16777215));
            }
        }

        int a(byte[] bArr, int i) {
            int iA = c.a(this.g.length - 1, bArr, c.b(this.i + 2, bArr, i));
            System.arraycopy(this.h, 0, bArr, iA, this.i);
            return iA + this.i;
        }

        private void a(int[] iArr, int i, int i2) {
            int length = iArr.length - i;
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) (i + 251);
            this.i = c.a(i2, bArr, i4);
            this.i = b(iArr, length);
        }

        private void a(int[] iArr, int[] iArr2, int i) {
            byte[] bArr = this.h;
            int i2 = this.i;
            int i3 = i2 + 1;
            this.i = i3;
            bArr[i2] = -1;
            int iA = c.a(i, bArr, i3);
            this.i = iA;
            this.i = c.a(iArr.length, this.h, iA);
            int iA2 = a(iArr);
            this.i = iA2;
            this.i = c.a(iArr2.length, this.h, iA2);
            this.i = a(iArr2);
        }

        private void a(int[] iArr, int i) {
            if (i <= 63) {
                byte[] bArr = this.h;
                int i2 = this.i;
                this.i = i2 + 1;
                bArr[i2] = (byte) (i + 64);
            } else {
                byte[] bArr2 = this.h;
                int i3 = this.i;
                int i4 = i3 + 1;
                this.i = i4;
                bArr2[i3] = -9;
                this.i = c.a(i, bArr2, i4);
            }
            l(iArr[0]);
        }

        private int a(int[] iArr) {
            return b(iArr, 0);
        }
    }

    static {
        int i;
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = c.class.getResourceAsStream("ClassFileWriter.class");
            if (resourceAsStream == null) {
                resourceAsStream = ClassLoader.getSystemResourceAsStream("external/sdk/pendo/io/mozilla/classfile/ClassFileWriter.class");
            }
            byte[] bArr = new byte[8];
            int i2 = 0;
            while (i2 < 8) {
                int i3 = resourceAsStream.read(bArr, i2, 8 - i2);
                if (i3 < 0) {
                    throw new IOException();
                }
                i2 += i3;
            }
            i = (bArr[4] << 8) | (bArr[5] & 255);
            try {
                int i4 = (bArr[7] & 255) | (bArr[6] << 8);
                F = i;
                E = i4;
                G = i4 >= 50;
                if (resourceAsStream == null) {
                    return;
                }
            } catch (Exception unused) {
                F = i;
                E = 48;
                G = false;
                if (resourceAsStream == null) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                F = i;
                E = 48;
                G = false;
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            i = 0;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        try {
            resourceAsStream.close();
        } catch (IOException unused4) {
        }
    }

    public c(String str, String str2, String str3) {
        this.d = str;
        d dVar = new d(this);
        this.k = dVar;
        this.t = dVar.a(str);
        this.u = this.k.a(str2);
        if (str3 != null) {
            this.v = this.k.c(str3);
        }
        this.s = (short) 33;
    }

    static /* synthetic */ int i(c cVar) {
        int i = cVar.f;
        cVar.f = i - 1;
        return i;
    }

    private int m(int i) {
        if (this.l == null) {
            throw new IllegalArgumentException("No method to add to");
        }
        int i2 = this.j;
        int i3 = i + i2;
        byte[] bArr = this.i;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 > length) {
                length = i3;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.i = bArr2;
        }
        this.j = i3;
        return i2;
    }

    private void n(int i) {
        if (G) {
            int[] iArr = this.a;
            if (iArr == null) {
                this.a = new int[4];
            } else {
                int length = iArr.length;
                int i2 = this.b;
                if (length == i2) {
                    int[] iArr2 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.a = iArr2;
                }
            }
            int[] iArr3 = this.a;
            int i3 = this.b;
            this.b = i3 + 1;
            iArr3[i3] = i;
        }
    }

    private void o(int i) {
        this.i[m(1)] = (byte) i;
    }

    private void p(int i) {
        a(i, this.i, m(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char r(int i) {
        switch (i) {
            case 4:
                return 'Z';
            case 5:
                return 'C';
            case 6:
                return 'F';
            case 7:
                return 'D';
            case 8:
                return 'B';
            case 9:
                return 'S';
            case 10:
                return 'I';
            case 11:
                return 'J';
            default:
                throw new IllegalArgumentException("bad operand");
        }
    }

    private static void s(int i) {
        throw new IllegalStateException((i < 0 ? new StringBuilder("Stack underflow: ") : new StringBuilder("Too big stack: ")).append(i).toString());
    }

    private static int y(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
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
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case Token.LABEL /* 131 */:
            case Token.LOOP /* 133 */:
            case 134:
            case 135:
            case 136:
            case Token.SCRIPT /* 137 */:
            case 138:
            case 139:
            case 140:
            case Token.SETELEM_OP /* 141 */:
            case Token.LOCAL_BLOCK /* 142 */:
            case Token.SET_REF_OP /* 143 */:
            case Token.DOTDOT /* 144 */:
            case Token.COLONCOLON /* 145 */:
            case Token.XML /* 146 */:
            case Token.DOTQUERY /* 147 */:
            case Token.XMLATTR /* 148 */:
            case Token.XMLEND /* 149 */:
            case 150:
            case Token.TO_DOUBLE /* 151 */:
            case Token.GET /* 152 */:
            case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
                return 0;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case Token.SET /* 153 */:
            case Token.LET /* 154 */:
            case Token.CONST /* 155 */:
            case Token.SETCONST /* 156 */:
            case Token.SETCONSTVAR /* 157 */:
            case Token.ARRAYCOMP /* 158 */:
            case Token.LETEXPR /* 159 */:
            case 160:
            case Token.DEBUGGER /* 161 */:
            case Token.COMMENT /* 162 */:
            case Token.GENEXPR /* 163 */:
            case Token.METHOD /* 164 */:
            case Token.ARROW /* 165 */:
            case Token.YIELD_STAR /* 166 */:
            case Token.LAST_TOKEN /* 167 */:
            case 168:
            case 169:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
                return 1;
            case Token.TARGET /* 132 */:
                return 2;
            case Context.VERSION_1_7 /* 170 */:
            case 171:
                return -1;
            default:
                switch (i) {
                    case 187:
                    case TsExtractor.TS_PACKET_SIZE /* 188 */:
                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                    case 192:
                    case 193:
                    case 198:
                    case 199:
                    case 200:
                    case 201:
                        return 1;
                    case 190:
                    case 191:
                    case 194:
                    case 195:
                    case 196:
                    case 202:
                        return 0;
                    case 197:
                        return 2;
                    default:
                        throw new IllegalArgumentException("Bad opcode: " + i);
                }
        }
    }

    private static int z(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case Token.TARGET /* 132 */:
            case 134:
            case 138:
            case 139:
            case Token.SET_REF_OP /* 143 */:
            case Token.COLONCOLON /* 145 */:
            case Token.XML /* 146 */:
            case Token.DOTQUERY /* 147 */:
            case Token.LAST_TOKEN /* 167 */:
            case 169:
            case 177:
            case 178:
            case 179:
            case 184:
            case ContextualToolbar.DRAG_BUTTON_ALPHA /* 186 */:
            case TsExtractor.TS_PACKET_SIZE /* 188 */:
            case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
            case 190:
            case 192:
            case 193:
            case 196:
            case 200:
            case 202:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case Token.LOOP /* 133 */:
            case 135:
            case 140:
            case Token.SETELEM_OP /* 141 */:
            case 168:
            case 187:
            case 197:
            case 201:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94:
                return 2;
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 128:
            case 130:
            case 136:
            case Token.SCRIPT /* 137 */:
            case Token.LOCAL_BLOCK /* 142 */:
            case Token.DOTDOT /* 144 */:
            case Token.XMLEND /* 149 */:
            case 150:
            case Token.SET /* 153 */:
            case Token.LET /* 154 */:
            case Token.CONST /* 155 */:
            case Token.SETCONST /* 156 */:
            case Token.SETCONSTVAR /* 157 */:
            case Token.ARRAYCOMP /* 158 */:
            case Context.VERSION_1_7 /* 170 */:
            case 171:
            case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
            case 174:
            case 176:
            case 180:
            case 181:
            case 182:
            case 183:
            case 185:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                return -1;
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case 129:
            case Token.LABEL /* 131 */:
            case Token.LETEXPR /* 159 */:
            case 160:
            case Token.DEBUGGER /* 161 */:
            case Token.COMMENT /* 162 */:
            case Token.GENEXPR /* 163 */:
            case Token.METHOD /* 164 */:
            case Token.ARROW /* 165 */:
            case Token.YIELD_STAR /* 166 */:
            case 173:
            case 175:
                return -2;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case Token.XMLATTR /* 148 */:
            case Token.TO_DOUBLE /* 151 */:
            case Token.GET /* 152 */:
                return -3;
            case 80:
            case 82:
                return -4;
            default:
                throw new IllegalArgumentException("Bad opcode: " + i);
        }
    }

    public void q(int i) {
        int i2 = this.m + i;
        if (i2 < 0 || 32767 < i2) {
            s(i2);
        }
        short s = (short) i2;
        this.m = s;
        if (i2 > this.n) {
            this.n = s;
        }
    }

    final char[] t(int i) {
        char[] cArr = this.D;
        if (i > cArr.length) {
            int length = cArr.length * 2;
            if (i <= length) {
                i = length;
            }
            this.D = new char[i];
        }
        return this.D;
    }

    public int u(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 < this.x) {
            return this.w[i2];
        }
        throw new IllegalArgumentException("Bad label");
    }

    public void v(int i) {
        this.m = (short) 1;
        w(i);
    }

    public void w(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 > this.x) {
            throw new IllegalArgumentException("Bad label");
        }
        int[] iArr = this.w;
        if (iArr[i2] != -1) {
            throw new IllegalStateException("Can only mark label once");
        }
        iArr[i2] = this.j;
    }

    public final void x(int i) {
        n(this.j);
        this.c.put(this.j, i);
        b(i, -1, this.j);
    }

    public void c(int i) {
        c(42, 25, i);
    }

    public void d(int i) {
        c(75, 58, i);
    }

    public void e(int i) {
        c(38, 24, i);
    }

    public void f(int i) {
        c(71, 57, i);
    }

    public void g(int i) {
        c(34, 23, i);
    }

    public void h(int i) {
        c(26, 21, i);
    }

    public void i(int i) {
        c(59, 54, i);
    }

    public void j(int i) {
        c(30, 22, i);
    }

    public void k(int i) {
        if (i == 0) {
            b(3);
            return;
        }
        if (i == 1) {
            b(4);
            return;
        }
        if (i == 2) {
            b(5);
            return;
        }
        if (i == 3) {
            b(6);
            return;
        }
        if (i == 4) {
            b(7);
        } else if (i != 5) {
            a(18, this.k.a(i));
        } else {
            b(8);
        }
    }

    public void l(int i) {
        byte b2 = (byte) i;
        if (b2 != i) {
            short s = (short) i;
            if (s == i) {
                a(17, (int) s);
                return;
            } else {
                k(i);
                return;
            }
        }
        if (i == -1) {
            b(2);
        } else if (i < 0 || i > 5) {
            a(16, (int) b2);
        } else {
            b((int) ((byte) (i + 3)));
        }
    }

    private static String f(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static String g(String str) {
        int length = str.length();
        int i = length + 1;
        int i2 = length + 2;
        char[] cArr = new char[i2];
        cArr[0] = 'L';
        cArr[i] = ';';
        str.getChars(0, length, cArr, 1);
        for (int i3 = 1; i3 != i; i3++) {
            if (cArr[i3] == '.') {
                cArr[i3] = '/';
            }
        }
        return new String(cArr, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return str;
        }
        if (cCharAt == 'L') {
            return f(str);
        }
        if (cCharAt == 'S' || cCharAt == 'V' || cCharAt == 'I' || cCharAt == 'J' || cCharAt == 'Z' || cCharAt == '[') {
            return str;
        }
        switch (cCharAt) {
            case 'B':
            case 'C':
            case 'D':
                return str;
            default:
                throw new IllegalArgumentException("bad descriptor:" + str);
        }
    }

    static String i(String str) {
        return str.replace('.', '/');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063 A[PHI: r1
      0x0063: PHI (r1v11 int) = (r1v3 int), (r1v16 int) binds: [B:15:0x0038, B:27:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x007b A[FALL_THROUGH, PHI: r1 r6
      0x007b: PHI (r1v8 int) = 
      (r1v3 int)
      (r1v3 int)
      (r1v3 int)
      (r1v3 int)
      (r1v3 int)
      (r1v16 int)
      (r1v16 int)
      (r1v16 int)
      (r1v16 int)
      (r1v16 int)
      (r1v16 int)
      (r1v3 int)
     binds: [B:14:0x0036, B:16:0x003a, B:17:0x003c, B:34:0x0060, B:19:0x0040, B:26:0x0050, B:28:0x0054, B:29:0x0056, B:30:0x0058, B:31:0x005a, B:32:0x005c, B:21:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r6v8 int) = 
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v13 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
     binds: [B:14:0x0036, B:16:0x003a, B:17:0x003c, B:34:0x0060, B:19:0x0040, B:26:0x0050, B:28:0x0054, B:29:0x0056, B:30:0x0058, B:31:0x005a, B:32:0x005c, B:21:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5 A[FALL_THROUGH, PHI: r6
      0x00a5: PHI (r6v3 int) = (r6v2 int), (r6v2 int), (r6v2 int), (r6v2 int), (r6v7 int), (r6v2 int), (r6v2 int), (r6v2 int) binds: [B:46:0x0089, B:47:0x008b, B:48:0x008d, B:51:0x0093, B:57:0x00a0, B:53:0x0097, B:54:0x0099, B:55:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0044. Please report as an issue. */
    public static int j(String str) {
        int i;
        boolean z;
        boolean z2;
        int iIndexOf;
        char cCharAt;
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(41);
        if (3 <= length && str.charAt(0) == '(' && 1 <= iLastIndexOf && (i = iLastIndexOf + 1) < length) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 1;
            while (true) {
                if (i4 != iLastIndexOf) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 == 'F') {
                        i2--;
                        i3++;
                        i4++;
                        continue;
                    } else if (cCharAt2 == 'L') {
                        i2--;
                        i3++;
                        iIndexOf = str.indexOf(59, i4 + 1);
                        if (i4 + 2 <= iIndexOf || iIndexOf >= iLastIndexOf) {
                            z = false;
                        } else {
                            i4 = iIndexOf + 1;
                        }
                    } else {
                        if (cCharAt2 != 'S' && cCharAt2 != 'I') {
                            if (cCharAt2 == 'J') {
                                i2--;
                            } else if (cCharAt2 != 'Z') {
                                if (cCharAt2 != '[') {
                                    switch (cCharAt2) {
                                        case 'D':
                                            i2--;
                                        case 'B':
                                        case 'C':
                                            i2--;
                                            i3++;
                                            i4++;
                                            continue;
                                        default:
                                            z = false;
                                            break;
                                    }
                                } else {
                                    do {
                                        i4++;
                                        cCharAt = str.charAt(i4);
                                    } while (cCharAt == '[');
                                    if (cCharAt != 'F') {
                                        if (cCharAt == 'L') {
                                            i2--;
                                            i3++;
                                            iIndexOf = str.indexOf(59, i4 + 1);
                                            if (i4 + 2 <= iIndexOf) {
                                            }
                                        } else if (cCharAt != 'S' && cCharAt != 'Z' && cCharAt != 'I' && cCharAt != 'J') {
                                            switch (cCharAt) {
                                            }
                                        }
                                        z = false;
                                    }
                                }
                            }
                        }
                        i2--;
                        i3++;
                        i4++;
                        continue;
                    }
                } else {
                    z = true;
                }
            }
            if (z) {
                char cCharAt3 = str.charAt(i);
                if (cCharAt3 == 'F' || cCharAt3 == 'L' || cCharAt3 == 'S') {
                    i2++;
                    z2 = z;
                } else if (cCharAt3 == 'V') {
                    z2 = z;
                } else {
                    if (cCharAt3 != 'I') {
                        if (cCharAt3 != 'J') {
                            if (cCharAt3 != 'Z' && cCharAt3 != '[') {
                                switch (cCharAt3) {
                                    case 'D':
                                        i2++;
                                    case 'B':
                                    case 'C':
                                        i2++;
                                        z2 = z;
                                        break;
                                    default:
                                        z2 = false;
                                        break;
                                }
                            }
                        } else {
                            i2++;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    return (i3 << 16) | (65535 & i2);
                }
            }
        }
        throw new IllegalArgumentException("Bad parameter signature: " + str);
    }

    public void b(int i) {
        if (y(i) != 0) {
            throw new IllegalArgumentException("Unexpected operands");
        }
        int iZ = this.m + z(i);
        if (iZ < 0 || 32767 < iZ) {
            s(iZ);
        }
        o(i);
        short s = (short) iZ;
        this.m = s;
        if (iZ > this.n) {
            this.n = s;
        }
        if (i == 191) {
            n(this.j);
        }
    }

    public void c(String str) {
        this.r.add(Short.valueOf(this.k.a(str)));
    }

    public void d(String str) {
        a(18, this.k.b(str));
    }

    public void e(String str) {
        int length = str.length();
        int i = 0;
        int iA = this.k.a(str, 0, length);
        if (iA == length) {
            d(str);
            return;
        }
        a(187, "java/lang/StringBuilder");
        b(89);
        l(length);
        b(183, "java/lang/StringBuilder", "<init>", "(I)V");
        while (true) {
            int i2 = i;
            i = iA;
            b(89);
            d(str.substring(i2, i));
            b(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            b(87);
            if (i == length) {
                b(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                return;
            }
            iA = this.k.a(str, i, length);
        }
    }

    private void d() {
        if (G) {
            for (int i = 0; i < this.f; i++) {
                n(u(this.e[i].c));
            }
            Arrays.sort(this.a, 0, this.b);
            int i2 = this.a[0];
            int i3 = 1;
            for (int i4 = 1; i4 < this.b; i4++) {
                int[] iArr = this.a;
                int i5 = iArr[i4];
                if (i2 != i5) {
                    if (i3 != i4) {
                        iArr[i3] = i5;
                    }
                    i3++;
                    i2 = i5;
                }
            }
            this.b = i3;
            int i6 = i3 - 1;
            if (this.a[i6] == this.j) {
                this.b = i6;
            }
        }
    }

    private void e() {
        byte[] bArr = this.i;
        for (int i = 0; i < this.z; i++) {
            long j = this.y[i];
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            int i4 = this.w[i2];
            if (i4 == -1) {
                throw new RuntimeException("unlocated label");
            }
            n(i4);
            int i5 = i3 - 1;
            this.c.put(i4, i5);
            int i6 = i4 - i5;
            if (((short) i6) != i6) {
                throw new b("Program too complex: too big jump offset");
            }
            bArr[i3] = (byte) (i6 >> 8);
            bArr[i3 + 1] = (byte) i6;
        }
        this.z = 0;
    }

    private int i() {
        if (this.v != 0) {
            this.k.c("SourceFile");
        }
        int iA = this.k.a() + 16 + (this.r.size() * 2) + 2;
        for (int i = 0; i < this.q.size(); i++) {
            iA += ((sdk.pendo.io.d2.a) this.q.get(i)).a();
        }
        int iD = iA + 2;
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            iD += ((sdk.pendo.io.d2.b) this.p.get(i2)).d();
        }
        int i3 = iD + 2;
        if (this.v != 0) {
            i3 = iD + 10;
        }
        return this.B != null ? i3 + 8 + this.C : i3;
    }

    public void b(int i, String str, String str2, String str3) {
        int iJ = j(str3);
        int i2 = iJ >>> 16;
        int iZ = this.m + ((short) iJ) + z(i);
        if (iZ < 0 || 32767 < iZ) {
            s(iZ);
        }
        switch (i) {
            case 182:
            case 183:
            case 184:
            case 185:
                o(i);
                if (i == 185) {
                    p(this.k.b(str, str2, str3));
                    o(i2 + 1);
                    o(0);
                } else {
                    p(this.k.c(str, str2, str3));
                }
                short s = (short) iZ;
                this.m = s;
                if (iZ > this.n) {
                    this.n = s;
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("bad opcode for method reference");
        }
    }

    public int c(int i, int i2) {
        if (i > i2) {
            throw new b("Bad bounds: " + i + ' ' + i2);
        }
        int iZ = this.m + z(Context.VERSION_1_7);
        if (iZ < 0 || 32767 < iZ) {
            s(iZ);
        }
        int i3 = (~this.j) & 3;
        int iM = m(i3 + 1 + (((i2 - i) + 4) * 4));
        int i4 = iM + 1;
        this.i[iM] = -86;
        while (i3 != 0) {
            this.i[i4] = 0;
            i3--;
            i4++;
        }
        b(i2, this.i, b(i, this.i, i4 + 4));
        short s = (short) iZ;
        this.m = s;
        if (iZ > this.n) {
            this.n = s;
        }
        return iM;
    }

    public final String f() {
        return this.d;
    }

    public int g() {
        return this.j;
    }

    public short h() {
        return this.m;
    }

    public byte[] j() {
        short sC;
        int i;
        short sC2;
        if (this.B != null) {
            sC = this.k.c("BootstrapMethods");
            i = 1;
        } else {
            sC = 0;
            i = 0;
        }
        if (this.v != 0) {
            i++;
            sC2 = this.k.c("SourceFile");
        } else {
            sC2 = 0;
        }
        int i2 = i();
        byte[] bArr = new byte[i2];
        int iA = a(this.r.size(), bArr, a((int) this.u, bArr, a((int) this.t, bArr, a((int) this.s, bArr, this.k.a(bArr, a(E, bArr, a(F, bArr, b(-889275714, bArr, 0))))))));
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            iA = a((int) ((Short) this.r.get(i3)).shortValue(), bArr, iA);
        }
        int iA2 = a(this.q.size(), bArr, iA);
        for (int i4 = 0; i4 < this.q.size(); i4++) {
            iA2 = ((sdk.pendo.io.d2.a) this.q.get(i4)).a(bArr, iA2);
        }
        int iA3 = a(this.p.size(), bArr, iA2);
        for (int i5 = 0; i5 < this.p.size(); i5++) {
            iA3 = ((sdk.pendo.io.d2.b) this.p.get(i5)).a(bArr, iA3);
        }
        int iA4 = a(i, bArr, iA3);
        if (this.B != null) {
            iA4 = a(this.B.size(), bArr, b(this.C + 2, bArr, a((int) sC, bArr, iA4)));
            for (int i6 = 0; i6 < this.B.size(); i6++) {
                a aVar = (a) this.B.get(i6);
                byte[] bArr2 = aVar.a;
                System.arraycopy(bArr2, 0, bArr, iA4, bArr2.length);
                iA4 += aVar.a.length;
            }
        }
        if (this.v != 0) {
            iA4 = a((int) this.v, bArr, b(2, bArr, a((int) sC2, bArr, iA4)));
        }
        if (iA4 == i2) {
            return bArr;
        }
        throw new RuntimeException();
    }

    private void b(int i, int i2) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i3 = i & Integer.MAX_VALUE;
        if (i3 >= this.x) {
            throw new IllegalArgumentException("Bad label");
        }
        int i4 = this.z;
        long[] jArr = this.y;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.y = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.y = jArr2;
            }
        }
        this.z = i4 + 1;
        this.y[i4] = ((long) i2) | (((long) i3) << 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a9  */
    public int[] c() {
        int i;
        int iB;
        int i2;
        int[] iArr = new int[this.o];
        if ((this.l.a() & 8) == 0) {
            if ("<init>".equals(this.l.b())) {
                iArr[0] = 6;
            } else {
                iArr[0] = h.a(this.t);
            }
            i = 1;
        } else {
            i = 0;
        }
        String strC = this.l.c();
        int iIndexOf = strC.indexOf(40);
        int iIndexOf2 = strC.indexOf(41);
        if (iIndexOf != 0 || iIndexOf2 < 0) {
            throw new IllegalArgumentException("bad method type");
        }
        int i3 = iIndexOf + 1;
        StringBuilder sb = new StringBuilder();
        while (i3 < iIndexOf2) {
            char cCharAt = strC.charAt(i3);
            if (cCharAt != 'F') {
                if (cCharAt == 'L') {
                    int iIndexOf3 = strC.indexOf(59, i3) + 1;
                    sb.append(strC.substring(i3, iIndexOf3));
                    i3 = iIndexOf3;
                } else if (cCharAt != 'S' && cCharAt != 'I' && cCharAt != 'J' && cCharAt != 'Z') {
                    if (cCharAt != '[') {
                        switch (cCharAt) {
                        }
                    } else {
                        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                        i3++;
                    }
                }
                iB = h.b(h(sb.toString()), this.k);
                i2 = i + 1;
                iArr[i] = iB;
                if (h.e(iB)) {
                    i += 2;
                } else {
                    i = i2;
                }
                sb.setLength(0);
            }
            sb.append(strC.charAt(i3));
            i3++;
            iB = h.b(h(sb.toString()), this.k);
            i2 = i + 1;
            iArr[i] = iB;
            if (h.e(iB)) {
                i += 2;
            } else {
                i = i2;
            }
            sb.setLength(0);
        }
        return iArr;
    }

    public int a() {
        int i = this.x;
        int[] iArr = this.w;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.w = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.w = iArr2;
            }
        }
        this.x = i + 1;
        this.w[i] = -1;
        return Integer.MIN_VALUE | i;
    }

    public final void d(int i, int i2) {
        n(this.j);
        this.c.put(this.j, i);
        b(i, i2, this.j);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x007b A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:51:0x0098 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x0103  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public void a(int i, int i2) {
        short s;
        int i3;
        int i4;
        int iU;
        int iZ = this.m + z(i);
        if (iZ < 0 || 32767 < iZ) {
            s(iZ);
        }
        if (i != 180 && i != 181) {
            if (i != 188) {
                if (i == 198 || i == 199) {
                    i3 = i2 & Integer.MIN_VALUE;
                    if (i3 == Integer.MIN_VALUE && (i2 < 0 || i2 > 65535)) {
                        throw new IllegalArgumentException("Bad label for branch");
                    }
                    i4 = this.j;
                    o(i);
                    if (i3 == Integer.MIN_VALUE) {
                        p(i2);
                        int i5 = i2 + i4;
                        n(i5);
                        this.c.put(i5, i4);
                    } else {
                        iU = u(i2);
                        if (iU == -1) {
                            p(iU - i4);
                            n(iU);
                            this.c.put(iU, i4);
                        } else {
                            b(i2, i4 + 1);
                            p(0);
                        }
                    }
                } else {
                    switch (i) {
                        case 16:
                            byte b2 = (byte) i2;
                            if (b2 != i2) {
                                throw new IllegalArgumentException("out of range byte");
                            }
                            o(i);
                            o(b2);
                            break;
                            break;
                        case 17:
                            if (((short) i2) != i2) {
                                throw new IllegalArgumentException("out of range short");
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                            if (i2 < 0 || i2 >= 65536) {
                                throw new b("out of range index");
                            }
                            if (i2 >= 256 || i == 19 || i == 20) {
                                if (i == 18) {
                                    o(19);
                                }
                                p(i2);
                            }
                            break;
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case Token.LAST_TOKEN /* 167 */:
                                            n(this.j + 3);
                                        case Token.SET /* 153 */:
                                        case Token.LET /* 154 */:
                                        case Token.CONST /* 155 */:
                                        case Token.SETCONST /* 156 */:
                                        case Token.SETCONSTVAR /* 157 */:
                                        case Token.ARRAYCOMP /* 158 */:
                                        case Token.LETEXPR /* 159 */:
                                        case 160:
                                        case Token.DEBUGGER /* 161 */:
                                        case Token.COMMENT /* 162 */:
                                        case Token.GENEXPR /* 163 */:
                                        case Token.METHOD /* 164 */:
                                        case Token.ARROW /* 165 */:
                                        case Token.YIELD_STAR /* 166 */:
                                        case 168:
                                            i3 = i2 & Integer.MIN_VALUE;
                                            if (i3 == Integer.MIN_VALUE) {
                                            }
                                            i4 = this.j;
                                            o(i);
                                            if (i3 == Integer.MIN_VALUE) {
                                                iU = u(i2);
                                                if (iU == -1) {
                                                    b(i2, i4 + 1);
                                                    p(0);
                                                } else {
                                                    p(iU - i4);
                                                    n(iU);
                                                    this.c.put(iU, i4);
                                                }
                                            } else {
                                                p(i2);
                                                int i6 = i2 + i4;
                                                n(i6);
                                                this.c.put(i6, i4);
                                            }
                                            break;
                                        case 169:
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Unexpected opcode for 1 operand");
                                    }
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                    if (i2 >= 0 || 65536 <= i2) {
                                        throw new b("out of range variable");
                                    }
                                    if (i2 >= 256) {
                                        o(196);
                                    }
                                    break;
                            }
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            if (i2 >= 0) {
                            }
                            throw new b("out of range variable");
                    }
                }
                s = (short) iZ;
                this.m = s;
                if (iZ > this.n) {
                    this.n = s;
                }
            }
            if (i2 < 0 || i2 >= 256) {
                throw new IllegalArgumentException("out of range index");
            }
            o(i);
            o(i2);
            s = (short) iZ;
            this.m = s;
            if (iZ > this.n) {
                this.n = s;
            }
        }
        if (i2 < 0 || i2 >= 65536) {
            throw new IllegalArgumentException("out of range field");
        }
        o(i);
        p(i2);
        s = (short) iZ;
        this.m = s;
        if (iZ > this.n) {
            this.n = s;
        }
    }

    public void b() {
        b(42);
    }

    public void c(short s) {
        C0372c c0372c;
        int iA;
        int iC;
        if (this.l == null) {
            throw new IllegalStateException("No method to stop");
        }
        e();
        this.o = s;
        if (G) {
            d();
            c0372c = new C0372c();
            c0372c.e();
        } else {
            c0372c = null;
        }
        int i = this.g != null ? (this.h * 4) + 8 : 0;
        ObjArray objArray = this.A;
        int size = objArray != null ? (objArray.size() * 10) + 8 : 0;
        int i2 = (c0372c == null || (iC = c0372c.c()) <= 0) ? 0 : iC + 6;
        int i3 = this.j + 16 + (this.f * 8) + 2 + i + size + i2;
        if (i3 > 65536) {
            throw new b("generated bytecode for method exceeds 64K limit.");
        }
        byte[] bArr = new byte[i3];
        int iB = b(this.j, bArr, a((int) this.o, bArr, a((int) this.n, bArr, b(i3 - 6, bArr, a((int) this.k.c("Code"), bArr, 0)))));
        System.arraycopy(this.i, 0, bArr, iB, this.j);
        int i4 = iB + this.j;
        int i5 = this.f;
        if (i5 > 0) {
            iA = a(i5, bArr, i4);
            for (int i6 = 0; i6 < this.f; i6++) {
                e eVar = this.e[i6];
                int iU = u(eVar.a);
                int iU2 = u(eVar.b);
                int iU3 = u(eVar.c);
                short s2 = eVar.d;
                if (iU == -1) {
                    throw new IllegalStateException("start label not defined");
                }
                if (iU2 == -1) {
                    throw new IllegalStateException("end label not defined");
                }
                if (iU3 == -1) {
                    throw new IllegalStateException("handler label not defined");
                }
                iA = a((int) s2, bArr, a(iU3, bArr, a(iU2, bArr, a(iU, bArr, iA))));
            }
        } else {
            iA = a(0, bArr, i4);
        }
        int i7 = this.g != null ? 1 : 0;
        if (this.A != null) {
            i7++;
        }
        if (i2 > 0) {
            i7++;
        }
        int iA2 = a(i7, bArr, iA);
        if (this.g != null) {
            iA2 = a(this.h, bArr, b((this.h * 4) + 2, bArr, a((int) this.k.c("LineNumberTable"), bArr, iA2)));
            for (int i8 = 0; i8 < this.h; i8++) {
                iA2 = b(this.g[i8], bArr, iA2);
            }
        }
        if (this.A != null) {
            int iA3 = a((int) this.k.c("LocalVariableTable"), bArr, iA2);
            int size2 = this.A.size();
            iA2 = a(size2, bArr, b((size2 * 10) + 2, bArr, iA3));
            for (int i9 = 0; i9 < size2; i9++) {
                int[] iArr = (int[]) this.A.get(i9);
                int i10 = iArr[0];
                int i11 = iArr[1];
                int i12 = iArr[2];
                iA2 = a(iArr[3], bArr, a(i11, bArr, a(i10, bArr, a(this.j - i12, bArr, a(i12, bArr, iA2)))));
            }
        }
        if (i2 > 0) {
            c0372c.a(bArr, a((int) this.k.c("StackMapTable"), bArr, iA2));
        }
        this.l.a(bArr);
        this.e = null;
        this.f = 0;
        this.h = 0;
        this.j = 0;
        this.l = null;
        this.n = (short) 0;
        this.m = (short) 0;
        this.x = 0;
        this.z = 0;
        this.A = null;
        this.a = null;
        this.b = 0;
        this.c = null;
    }

    private void c(int i, int i2, int i3) {
        if (i3 == 0) {
            b(i);
            return;
        }
        int i4 = 1;
        if (i3 != 1) {
            i4 = 2;
            if (i3 != 2) {
                i4 = 3;
                if (i3 != 3) {
                    a(i2, i3);
                    return;
                }
            }
        }
        b(i + i4);
    }

    public void a(int i, String str) {
        int iZ = this.m + z(i);
        if (iZ < 0 || 32767 < iZ) {
            s(iZ);
        }
        if (i != 187 && i != 189 && i != 192 && i != 193) {
            throw new IllegalArgumentException("bad opcode for class reference");
        }
        short sA = this.k.a(str);
        o(i);
        p(sA);
        short s = (short) iZ;
        this.m = s;
        if (iZ > this.n) {
            this.n = s;
        }
    }

    public void b(double d) {
        if (d == 0.0d) {
            b(14);
            if (1.0d / d >= 0.0d) {
                return;
            }
        } else if (d != 1.0d && d != -1.0d) {
            a(d);
            return;
        } else {
            b(15);
            if (d >= 0.0d) {
                return;
            }
        }
        b(119);
    }

    public void a(int i, String str, String str2, String str3) {
        int i2;
        int iZ = this.m + z(i);
        char cCharAt = str3.charAt(0);
        int i3 = (cCharAt == 'J' || cCharAt == 'D') ? 2 : 1;
        switch (i) {
            case 178:
            case 180:
                i2 = iZ + i3;
                break;
            case 179:
            case 181:
                i2 = iZ - i3;
                break;
            default:
                throw new IllegalArgumentException("bad opcode for field reference");
        }
        if (i2 < 0 || 32767 < i2) {
            s(i2);
        }
        short sA = this.k.a(str, str2, str3);
        o(i);
        p(sA);
        short s = (short) i2;
        this.m = s;
        if (i2 > this.n) {
            this.n = s;
        }
    }

    public void b(long j) {
        int i = (int) j;
        if (i != j) {
            a(j);
        } else {
            l(i);
            b(Token.LOOP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0030 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0032 A[RETURN] */
    public static int b(int i, boolean z) {
        if (i == 254 || i == 255) {
            return 1;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
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
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case Token.LABEL /* 131 */:
            case Token.LOOP /* 133 */:
            case 134:
            case 135:
            case 136:
            case Token.SCRIPT /* 137 */:
            case 138:
            case 139:
            case 140:
            case Token.SETELEM_OP /* 141 */:
            case Token.LOCAL_BLOCK /* 142 */:
            case Token.SET_REF_OP /* 143 */:
            case Token.DOTDOT /* 144 */:
            case Token.COLONCOLON /* 145 */:
            case Token.XML /* 146 */:
            case Token.DOTQUERY /* 147 */:
            case Token.XMLATTR /* 148 */:
            case Token.XMLEND /* 149 */:
            case 150:
            case Token.TO_DOUBLE /* 151 */:
            case Token.GET /* 152 */:
                return 1;
            case 16:
            case 18:
                return 2;
            case 17:
            case 19:
            case 20:
            case Token.SET /* 153 */:
            case Token.LET /* 154 */:
            case Token.CONST /* 155 */:
            case Token.SETCONST /* 156 */:
            case Token.SETCONSTVAR /* 157 */:
            case Token.ARRAYCOMP /* 158 */:
            case Token.LETEXPR /* 159 */:
            case 160:
            case Token.DEBUGGER /* 161 */:
            case Token.COMMENT /* 162 */:
            case Token.GENEXPR /* 163 */:
            case Token.METHOD /* 164 */:
            case Token.ARROW /* 165 */:
            case Token.YIELD_STAR /* 166 */:
            case Token.LAST_TOKEN /* 167 */:
            case 168:
                return 3;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 169:
                return z ? 3 : 2;
            case Token.TARGET /* 132 */:
                return z ? 5 : 3;
            default:
                switch (i) {
                    case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                    case 173:
                    case 174:
                    case 175:
                    case 176:
                    case 177:
                    case 190:
                    case 191:
                    case 194:
                    case 195:
                    case 196:
                    case 202:
                        return 1;
                    case 178:
                    case 179:
                    case 180:
                    case 181:
                    case 182:
                    case 183:
                    case 184:
                    case 187:
                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                    case 192:
                    case 193:
                    case 198:
                    case 199:
                        return 3;
                    case 185:
                    case ContextualToolbar.DRAG_BUTTON_ALPHA /* 186 */:
                    case 200:
                    case 201:
                        return 5;
                    case TsExtractor.TS_PACKET_SIZE /* 188 */:
                        return 2;
                    case 197:
                        return 4;
                    default:
                        throw new IllegalArgumentException("Bad opcode: " + i);
                }
        }
    }

    public void a(int i, int i2, int i3, String str) {
        if ((i & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad startLabel");
        }
        if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad endLabel");
        }
        if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad handlerLabel");
        }
        e eVar = new e(i, i2, i3, str == null ? (short) 0 : this.k.a(str));
        int i4 = this.f;
        if (i4 == 0) {
            this.e = new e[4];
        } else {
            e[] eVarArr = this.e;
            if (i4 == eVarArr.length) {
                e[] eVarArr2 = new e[i4 * 2];
                System.arraycopy(eVarArr, 0, eVarArr2, 0, i4);
                this.e = eVarArr2;
            }
        }
        this.e[i4] = eVar;
        this.f = i4 + 1;
    }

    static int b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        return i2 + 4;
    }

    public void a(String str, String str2, short s) {
        this.q.add(new sdk.pendo.io.d2.a(this.k.c(str), this.k.c(str2), s));
    }

    public void a(short s) {
        if (this.l == null) {
            throw new IllegalArgumentException("No method to stop");
        }
        int i = this.h;
        if (i == 0) {
            this.g = new int[16];
        } else {
            int[] iArr = this.g;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.g = iArr2;
            }
        }
        this.g[i] = (this.j << 16) + s;
        this.h = i + 1;
    }

    public void b(short s) {
        this.m = s;
    }

    public void a(double d) {
        a(20, this.k.a(d));
    }

    public void b(int i, int i2, int i3) {
        int i4;
        if (i3 < 0 || (i4 = this.j) < i3) {
            throw new IllegalArgumentException("Bad jump target: " + i3);
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("Bad case index: " + i2);
        }
        int i5 = (~i) & 3;
        int i6 = i + 1 + i5;
        if (i2 >= 0) {
            i6 += (i2 + 3) * 4;
        }
        if (i < 0 || ((i4 - 16) - i5) - 1 < i) {
            throw new IllegalArgumentException(i + " is outside a possible range of tableswitch in already generated code");
        }
        byte[] bArr = this.i;
        if ((bArr[i] & 255) != 170) {
            throw new IllegalArgumentException(i + " is not offset of tableswitch statement");
        }
        if (i6 < 0 || i4 < i6 + 4) {
            throw new b("Too big case index: " + i2);
        }
        b(i3 - i, bArr, i6);
    }

    public void a(long j) {
        a(20, this.k.a(j));
    }

    public void b(String str, String str2, short s) {
        this.l = new sdk.pendo.io.d2.b(str, this.k.c(str), str2, this.k.c(str2), s);
        this.c = new UintMap();
        this.p.add(this.l);
        n(0);
    }

    public void a(boolean z) {
        b(z ? 4 : 3);
    }

    public void a(String str, String str2, int i, int i2) {
        int[] iArr = {this.k.c(str), this.k.c(str2), i, i2};
        if (this.A == null) {
            this.A = new ObjArray();
        }
        this.A.add(iArr);
    }

    public void a(int i, short s) {
        w(i);
        this.m = s;
    }

    public final void a(int i, int i2, int i3) {
        if (i3 < 0 || i3 > this.n) {
            throw new IllegalArgumentException("Bad stack index: " + i3);
        }
        this.m = (short) i3;
        n(this.j);
        this.c.put(this.j, i);
        b(i, i2, this.j);
    }

    static int a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        return i2 + 2;
    }

    static int a(long j, byte[] bArr, int i) {
        return b((int) j, bArr, b((int) (j >>> 32), bArr, i));
    }
}
