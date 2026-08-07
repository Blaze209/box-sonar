package sdk.pendo.io.a;

import androidx.core.internal.view.SupportMenu;
import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    @Deprecated
    public final byte[] a;
    public final int b;
    final byte[] c;
    private final int[] d;
    private final String[] e;
    private final i[] f;
    private final int[] g;
    private final int h;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x005f A[PHI: r8
      0x005f: PHI (r8v5 int) = (r8v0 int), (r8v1 int), (r8v6 int) binds: [B:12:0x0050, B:22:0x006e, B:17:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    e(byte[] bArr, int i, boolean z) {
        this.c = bArr;
        this.a = bArr;
        if (z) {
            int i2 = i + 6;
            if (f(i2) > 61) {
                throw new IllegalArgumentException("Unsupported class file major version " + ((int) f(i2)));
            }
        }
        int iG = g(i + 8);
        this.d = new int[iG];
        this.e = new String[iG];
        int i3 = i + 10;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 1;
        while (i5 < iG) {
            int i6 = i5 + 1;
            int i7 = i3 + 1;
            this.d[i5] = i7;
            int iG2 = 3;
            switch (bArr[i3]) {
                case 1:
                    iG2 = 3 + g(i7);
                    if (iG2 > i4) {
                        i5 = i6;
                        i4 = iG2;
                    } else {
                        i5 = i6;
                    }
                    i3 += iG2;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i5 = i6;
                    iG2 = 5;
                    i3 += iG2;
                    break;
                case 5:
                case 6:
                    i5 += 2;
                    iG2 = 9;
                    i3 += iG2;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i5 = i6;
                    i3 += iG2;
                    break;
                case 15:
                    iG2 = 4;
                    i5 = i6;
                    i3 += iG2;
                    break;
                case 17:
                    z2 = true;
                    z3 = true;
                    i5 = i6;
                    iG2 = 5;
                    i3 += iG2;
                    break;
                case 18:
                    z3 = true;
                    i5 = i6;
                    iG2 = 5;
                    i3 += iG2;
                    break;
            }
        }
        this.h = i4;
        this.b = i3;
        this.f = z2 ? new i[iG] : null;
        this.g = z3 ? b(i4) : null;
    }

    private s b(int i, s[] sVarArr) {
        s sVarC = c(i, sVarArr);
        sVarC.a = (short) (sVarC.a & (-2));
        return sVarC;
    }

    public void a(g gVar, c[] cVarArr, int i) {
        k kVar;
        e eVar;
        String str;
        int i2;
        String str2;
        int i3;
        k kVar2 = new k();
        kVar2.a = cVarArr;
        kVar2.b = i;
        char[] cArr = new char[this.h];
        kVar2.c = cArr;
        int i4 = this.b;
        int iG = g(i4);
        String strA = a(i4 + 2, cArr);
        String strA2 = a(i4 + 4, cArr);
        int iG2 = g(i4 + 6);
        String[] strArr = new String[iG2];
        int i5 = i4 + 8;
        for (int i6 = 0; i6 < iG2; i6++) {
            strArr[i6] = a(i5, cArr);
            i5 += 2;
        }
        int iA = a();
        int iG3 = g(iA - 2);
        String str3 = null;
        String strA3 = null;
        String strA4 = null;
        int i7 = 0;
        int i8 = 0;
        String strG = null;
        int i9 = 0;
        int i10 = 0;
        String strA5 = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        c cVar = null;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (iG3 > 0) {
            int i18 = iA;
            String strG2 = g(i18, cArr);
            int iD = d(i18 + 2);
            String strG3 = str3;
            int i19 = i18 + 6;
            String str4 = strA3;
            if ("SourceFile".equals(strG2)) {
                strG3 = g(i19, cArr);
                i3 = iG;
                i2 = i19;
                strA = strA;
                strA3 = str4;
                iD = iD;
                kVar2 = kVar2;
            } else {
                if ("InnerClasses".equals(strG2)) {
                    i3 = iG;
                    i2 = i19;
                    i16 = i2;
                } else if ("EnclosingMethod".equals(strG2)) {
                    i3 = iG;
                    i2 = i19;
                    i8 = i2;
                } else {
                    if ("NestHost".equals(strG2)) {
                        strA4 = a(i19, cArr);
                    } else if ("NestMembers".equals(strG2)) {
                        i3 = iG;
                        i2 = i19;
                        i14 = i2;
                    } else if ("PermittedSubclasses".equals(strG2)) {
                        i3 = iG;
                        i2 = i19;
                        i15 = i2;
                    } else if ("Signature".equals(strG2)) {
                        strG = g(i19, cArr);
                    } else if ("RuntimeVisibleAnnotations".equals(strG2)) {
                        i3 = iG;
                        i2 = i19;
                        i7 = i2;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(strG2)) {
                        i3 = iG;
                        i2 = i19;
                        i12 = i2;
                    } else {
                        if ("Deprecated".equals(strG2)) {
                            i3 = 131072 | iG;
                        } else if ("Synthetic".equals(strG2)) {
                            i3 = iG | 4096;
                        } else if ("SourceDebugExtension".equals(strG2)) {
                            if (iD > this.c.length - i19) {
                                throw new IllegalArgumentException();
                            }
                            strA3 = a(i19, iD, new char[iD]);
                            i3 = iG;
                            i2 = i19;
                            strA = strA;
                        } else if ("RuntimeInvisibleAnnotations".equals(strG2)) {
                            i3 = iG;
                            i2 = i19;
                            i11 = i2;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(strG2)) {
                            i3 = iG;
                            i2 = i19;
                            i13 = i2;
                        } else if ("Record".equals(strG2)) {
                            i3 = 65536 | iG;
                            i2 = i19;
                            i17 = i2;
                        } else if ("Module".equals(strG2)) {
                            i3 = iG;
                            i2 = i19;
                            i9 = i2;
                        } else if ("ModuleMainClass".equals(strG2)) {
                            strA5 = a(i19, cArr);
                        } else if ("ModulePackages".equals(strG2)) {
                            i3 = iG;
                            i2 = i19;
                            i10 = i2;
                        } else {
                            if ("BootstrapMethods".equals(strG2)) {
                                str = str4;
                                i2 = i19;
                                iD = iD;
                                str2 = strA4;
                            } else {
                                str = str4;
                                str2 = strA4;
                                i2 = i19;
                                iD = iD;
                                c cVarA = a(cVarArr, strG2, i2, iD, cArr, -1, null);
                                cVarA.c = cVar;
                                cVar = cVarA;
                            }
                            strA3 = str;
                            strA4 = str2;
                            i3 = iG;
                        }
                        i2 = i19;
                    }
                    i3 = iG;
                    i2 = i19;
                }
                strA3 = str4;
                strA = strA;
            }
            int i20 = i2 + iD;
            iG3--;
            iG = i3;
            str3 = strG3;
            kVar2 = kVar2;
            strA = strA;
            iA = i20;
        }
        String str5 = str3;
        k kVar3 = kVar2;
        String str6 = strA;
        String str7 = strA3;
        String str8 = strA4;
        c cVar2 = cVar;
        gVar.a(d(this.d[1] - 7), iG, str6, strG, strA2, strArr);
        if ((i & 2) == 0 && (str5 != null || str7 != null)) {
            gVar.a(str5, str7);
        }
        if (i9 != 0) {
            kVar = kVar3;
            eVar = this;
            eVar.a(gVar, kVar, i9, i10, strA5);
        } else {
            kVar = kVar3;
            eVar = this;
        }
        if (str8 != null) {
            gVar.a(str8);
        }
        if (i8 != 0) {
            String strA6 = eVar.a(i8, cArr);
            int iG4 = eVar.g(i8 + 2);
            gVar.a(strA6, iG4 == 0 ? null : eVar.g(eVar.d[iG4], cArr), iG4 == 0 ? null : eVar.g(eVar.d[iG4] + 2, cArr));
        }
        if (i7 != 0) {
            int iG5 = eVar.g(i7);
            int iA2 = i7 + 2;
            while (true) {
                int i21 = iG5 - 1;
                if (iG5 <= 0) {
                    break;
                }
                iA2 = eVar.a(gVar.a(eVar.g(iA2, cArr), true), iA2 + 2, true, cArr);
                iG5 = i21;
            }
        }
        int i22 = i11;
        if (i22 != 0) {
            int iG6 = eVar.g(i22);
            int iA3 = i22 + 2;
            while (true) {
                int i23 = iG6 - 1;
                if (iG6 <= 0) {
                    break;
                }
                iA3 = eVar.a(gVar.a(eVar.g(iA3, cArr), false), iA3 + 2, true, cArr);
                iG6 = i23;
            }
        }
        int i24 = i12;
        if (i24 != 0) {
            int iG7 = eVar.g(i24);
            int iA4 = i24 + 2;
            while (true) {
                int i25 = iG7 - 1;
                if (iG7 <= 0) {
                    break;
                }
                int iA5 = eVar.a(kVar, iA4);
                iA4 = eVar.a(gVar.a(kVar.h, kVar.i, eVar.g(iA5, cArr), true), iA5 + 2, true, cArr);
                iG7 = i25;
            }
        }
        int i26 = i13;
        if (i26 != 0) {
            int iG8 = eVar.g(i26);
            int iA6 = i26 + 2;
            while (true) {
                int i27 = iG8 - 1;
                if (iG8 <= 0) {
                    break;
                }
                int iA7 = eVar.a(kVar, iA6);
                iA6 = eVar.a(gVar.a(kVar.h, kVar.i, eVar.g(iA7, cArr), false), iA7 + 2, true, cArr);
                iG8 = i27;
            }
        }
        while (cVar2 != null) {
            c cVar3 = cVar2.c;
            cVar2.c = null;
            gVar.a(cVar2);
            cVar2 = cVar3;
        }
        int i28 = i14;
        if (i28 != 0) {
            int iG9 = eVar.g(i28);
            int i29 = i28 + 2;
            while (true) {
                int i30 = iG9 - 1;
                if (iG9 <= 0) {
                    break;
                }
                gVar.b(eVar.a(i29, cArr));
                i29 += 2;
                iG9 = i30;
            }
        }
        int i31 = i15;
        if (i31 != 0) {
            int iG10 = eVar.g(i31);
            int i32 = i31 + 2;
            while (true) {
                int i33 = iG10 - 1;
                if (iG10 <= 0) {
                    break;
                }
                gVar.c(eVar.a(i32, cArr));
                i32 += 2;
                iG10 = i33;
            }
        }
        int i34 = i16;
        if (i34 != 0) {
            int iG11 = eVar.g(i34);
            int i35 = i34 + 2;
            while (true) {
                int i36 = iG11 - 1;
                if (iG11 <= 0) {
                    break;
                }
                gVar.a(eVar.a(i35, cArr), eVar.a(i35 + 2, cArr), eVar.g(i35 + 4, cArr), eVar.g(i35 + 6));
                i35 += 8;
                iG11 = i36;
            }
        }
        int i37 = i17;
        if (i37 != 0) {
            int iG12 = eVar.g(i37);
            int iC = i37 + 2;
            while (true) {
                int i38 = iG12 - 1;
                if (iG12 <= 0) {
                    break;
                }
                iC = eVar.c(gVar, kVar, iC);
                iG12 = i38;
            }
        }
        int iG13 = eVar.g(i5);
        int iA8 = i5 + 2;
        while (true) {
            int i39 = iG13 - 1;
            if (iG13 <= 0) {
                break;
            }
            iA8 = eVar.a(gVar, kVar, iA8);
            iG13 = i39;
        }
        int iG14 = eVar.g(iA8);
        int iB = iA8 + 2;
        while (true) {
            int i40 = iG14 - 1;
            if (iG14 <= 0) {
                gVar.a();
                return;
            } else {
                iB = eVar.b(gVar, kVar, iB);
                iG14 = i40;
            }
        }
    }

    public int c() {
        return this.h;
    }

    public int d(int i) {
        byte[] bArr = this.c;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public long e(int i) {
        return (((long) d(i + 4)) & 4294967295L) | (((long) d(i)) << 32);
    }

    public short f(int i) {
        byte[] bArr = this.c;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String g(int i, char[] cArr) {
        int iG = g(i);
        if (i == 0 || iG == 0) {
            return null;
        }
        return h(iG, cArr);
    }

    final String h(int i, char[] cArr) {
        String[] strArr = this.e;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.d[i];
        String strA = a(i2 + 2, g(i2), cArr);
        strArr[i] = strA;
        return strA;
    }

    private void a(k kVar) {
        int i;
        String str = kVar.f;
        Object[] objArr = kVar.q;
        int i2 = 0;
        if ((kVar.d & 8) == 0) {
            if ("<init>".equals(kVar.e)) {
                objArr[0] = y.g;
            } else {
                objArr[0] = a(this.b + 2, kVar.c);
            }
            i2 = 1;
        }
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt == 'F') {
                i = i2 + 1;
                objArr[i2] = y.c;
            } else if (cCharAt != 'L') {
                if (cCharAt != 'S' && cCharAt != 'I') {
                    if (cCharAt == 'J') {
                        i = i2 + 1;
                        objArr[i2] = y.e;
                    } else if (cCharAt != 'Z') {
                        if (cCharAt != '[') {
                            switch (cCharAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i = i2 + 1;
                                    objArr[i2] = y.d;
                                    break;
                                default:
                                    kVar.o = i2;
                                    return;
                            }
                        } else {
                            while (str.charAt(i4) == '[') {
                                i4++;
                            }
                            if (str.charAt(i4) == 'L') {
                                do {
                                    i4++;
                                } while (str.charAt(i4) != ';');
                            }
                            int i5 = i4 + 1;
                            objArr[i2] = str.substring(i3, i5);
                            i3 = i5;
                            i2++;
                        }
                    }
                }
                i = i2 + 1;
                objArr[i2] = y.b;
            } else {
                int i6 = i4;
                while (str.charAt(i6) != ';') {
                    i6++;
                }
                objArr[i2] = str.substring(i4, i6);
                i2++;
                i3 = i6 + 1;
            }
            i2 = i;
            i3 = i4;
        }
    }

    private String f(int i, char[] cArr) {
        return g(this.d[g(i)], cArr);
    }

    public int b() {
        return this.d.length;
    }

    public int c(int i) {
        return this.c[i] & 255;
    }

    public String d(int i, char[] cArr) {
        return f(i, cArr);
    }

    public String e(int i, char[] cArr) {
        return f(i, cArr);
    }

    public int g(int i) {
        byte[] bArr = this.c;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    private void a(int i, s[] sVarArr) {
        if (sVarArr[i] == null) {
            s sVarC = c(i, sVarArr);
            sVarC.a = (short) (sVarC.a | 1);
        }
    }

    private int[] b(int i) {
        char[] cArr = new char[i];
        int iA = a();
        for (int iG = g(iA - 2); iG > 0; iG--) {
            String strG = g(iA, cArr);
            int iD = d(iA + 2);
            int i2 = iA + 6;
            if ("BootstrapMethods".equals(strG)) {
                int iG2 = g(i2);
                int[] iArr = new int[iG2];
                int iG3 = iA + 8;
                for (int i3 = 0; i3 < iG2; i3++) {
                    iArr[i3] = iG3;
                    iG3 += (g(iG3 + 2) * 2) + 4;
                }
                return iArr;
            }
            iA = i2 + iD;
        }
        throw new IllegalArgumentException();
    }

    private i c(int i, char[] cArr) {
        i iVar = this.f[i];
        if (iVar != null) {
            return iVar;
        }
        int[] iArr = this.d;
        int i2 = iArr[i];
        int i3 = iArr[g(i2 + 2)];
        String strG = g(i3, cArr);
        String strG2 = g(i3 + 2, cArr);
        int i4 = this.g[g(i2)];
        q qVar = (q) b(g(i4), cArr);
        int iG = g(i4 + 2);
        Object[] objArr = new Object[iG];
        int i5 = i4 + 4;
        for (int i6 = 0; i6 < iG; i6++) {
            objArr[i6] = b(g(i5), cArr);
            i5 += 2;
        }
        i[] iVarArr = this.f;
        i iVar2 = new i(strG, strG2, qVar, objArr);
        iVarArr[i] = iVar2;
        return iVar2;
    }

    final int a() {
        int i = this.b;
        int iG = i + 8 + (g(i + 6) * 2);
        int iG2 = g(iG);
        int iD = iG + 2;
        while (true) {
            int i2 = iG2 - 1;
            if (iG2 <= 0) {
                break;
            }
            int iG3 = g(iD + 6);
            iD += 8;
            while (true) {
                int i3 = iG3 - 1;
                if (iG3 > 0) {
                    iD += d(iD + 2) + 6;
                    iG3 = i3;
                }
            }
            iG2 = i2;
        }
        int iG4 = g(iD);
        int iD2 = iD + 2;
        while (true) {
            int i4 = iG4 - 1;
            if (iG4 <= 0) {
                return iD2 + 2;
            }
            int iG5 = g(iD2 + 6);
            iD2 += 8;
            while (true) {
                int i5 = iG5 - 1;
                if (iG5 > 0) {
                    iD2 += d(iD2 + 2) + 6;
                    iG5 = i5;
                }
            }
            iG4 = i4;
        }
    }

    public Object b(int i, char[] cArr) {
        int i2 = this.d[i];
        byte b = this.c[i2 - 1];
        switch (b) {
            case 3:
                return Integer.valueOf(d(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(d(i2)));
            case 5:
                return Long.valueOf(e(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(e(i2)));
            case 7:
                return d0.d(g(i2, cArr));
            case 8:
                return g(i2, cArr);
            default:
                switch (b) {
                    case 15:
                        int iC = c(i2);
                        int i3 = this.d[g(i2 + 1)];
                        int i4 = this.d[g(i3 + 2)];
                        return new q(iC, a(i3, cArr), g(i4, cArr), g(i4 + 2, cArr), this.c[i3 - 1] == 11);
                    case 16:
                        return d0.c(g(i2, cArr));
                    case 17:
                        return c(i, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    protected s c(int i, s[] sVarArr) {
        if (sVarArr[i] == null) {
            sVarArr[i] = new s();
        }
        return sVarArr[i];
    }

    private int b(g gVar, k kVar, int i) {
        int i2;
        int i3;
        int i4;
        e eVar = this;
        char[] cArr = kVar.c;
        kVar.d = eVar.g(i);
        kVar.e = eVar.g(i + 2, cArr);
        int i5 = i + 4;
        kVar.f = eVar.g(i5, cArr);
        int iG = eVar.g(i + 6);
        int i6 = i + 8;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        c cVar = null;
        int iG2 = 0;
        int i11 = 0;
        int i12 = 0;
        String[] strArr = null;
        boolean z = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int i17 = iG - 1;
            if (iG <= 0) {
                break;
            }
            int i18 = i7;
            String strG = eVar.g(i6, cArr);
            int iD = eVar.d(i6 + 2);
            int i19 = i8;
            int i20 = i6 + 6;
            int i21 = i18;
            if ("Code".equals(strG)) {
                if ((kVar.b & 1) == 0) {
                    i16 = i20;
                }
            } else if ("Exceptions".equals(strG)) {
                int iG3 = eVar.g(i20);
                int i22 = i6 + 8;
                strArr = new String[iG3];
                for (int i23 = 0; i23 < iG3; i23++) {
                    strArr[i23] = eVar.a(i22, cArr);
                    i22 += 2;
                }
                i13 = i20;
            } else if ("Signature".equals(strG)) {
                iG2 = eVar.g(i20);
            } else if ("Deprecated".equals(strG)) {
                kVar.d |= 131072;
            } else if ("RuntimeVisibleAnnotations".equals(strG)) {
                i21 = i20;
            } else {
                if ("RuntimeVisibleTypeAnnotations".equals(strG)) {
                    i3 = i20;
                    i4 = iD;
                } else if ("AnnotationDefault".equals(strG)) {
                    i12 = i20;
                } else if ("Synthetic".equals(strG)) {
                    kVar.d |= 4096;
                    i3 = i9;
                    i4 = iD;
                    z = true;
                } else if ("RuntimeInvisibleAnnotations".equals(strG)) {
                    i19 = i20;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(strG)) {
                    i10 = i20;
                } else if ("RuntimeVisibleParameterAnnotations".equals(strG)) {
                    i14 = i20;
                } else if ("RuntimeInvisibleParameterAnnotations".equals(strG)) {
                    i15 = i20;
                } else if ("MethodParameters".equals(strG)) {
                    i11 = i20;
                } else {
                    i3 = i9;
                    i4 = iD;
                    c cVarA = eVar.a(kVar.a, strG, i20, i4, cArr, -1, null);
                    cVarA.c = cVar;
                    cVar = cVarA;
                    i10 = i10;
                }
                i6 = i20 + i4;
                cArr = cArr;
                iG = i17;
                i8 = i19;
                i7 = i21;
                i9 = i3;
            }
            i3 = i9;
            i4 = iD;
            i6 = i20 + i4;
            cArr = cArr;
            iG = i17;
            i8 = i19;
            i7 = i21;
            i9 = i3;
        }
        int i24 = i7;
        int i25 = i8;
        int i26 = i9;
        char[] cArr2 = cArr;
        int i27 = i10;
        int i28 = i12;
        int i29 = i11;
        u uVarA = gVar.a(kVar.d, kVar.e, kVar.f, iG2 == 0 ? null : eVar.h(iG2, cArr2), strArr);
        if (uVarA == null) {
            return i6;
        }
        if (uVarA instanceof v) {
            v vVar = (v) uVarA;
            int i30 = iG2;
            i2 = i29;
            boolean zA = vVar.a(eVar, z, (kVar.d & 131072) != 0, eVar.g(i5), i30, i13);
            eVar = eVar;
            if (zA) {
                vVar.f(i, i6 - i);
                return i6;
            }
        } else {
            i2 = i29;
        }
        if (i2 != 0 && (kVar.b & 2) == 0) {
            int iC = eVar.c(i2);
            int i31 = i2 + 1;
            while (true) {
                int i32 = iC - 1;
                if (iC <= 0) {
                    break;
                }
                uVarA.b(eVar.g(i31, cArr2), eVar.g(i31 + 2));
                i31 += 4;
                iC = i32;
            }
        }
        if (r3 != 0) {
            a aVarA = uVarA.a();
            eVar.a(aVarA, i28, (String) null, cArr2);
            if (aVarA != null) {
                aVarA.a();
            }
        }
        if (i24 != 0) {
            int iG4 = eVar.g(i24);
            int iA = i24 + 2;
            while (true) {
                int i33 = iG4 - 1;
                if (iG4 <= 0) {
                    break;
                }
                iA = eVar.a(uVarA.a(eVar.g(iA, cArr2), true), iA + 2, true, cArr2);
                iG4 = i33;
            }
        }
        if (i25 != 0) {
            int iG5 = eVar.g(i25);
            int iA2 = i25 + 2;
            while (true) {
                int i34 = iG5 - 1;
                if (iG5 <= 0) {
                    break;
                }
                iA2 = eVar.a(uVarA.a(eVar.g(iA2, cArr2), false), iA2 + 2, true, cArr2);
                iG5 = i34;
            }
        }
        if (i26 != 0) {
            int iG6 = eVar.g(i26);
            int iA3 = i26 + 2;
            while (true) {
                int i35 = iG6 - 1;
                if (iG6 <= 0) {
                    break;
                }
                int iA4 = eVar.a(kVar, iA3);
                iA3 = eVar.a(uVarA.c(kVar.h, kVar.i, eVar.g(iA4, cArr2), true), iA4 + 2, true, cArr2);
                iG6 = i35;
            }
        }
        if (i27 != 0) {
            int iG7 = eVar.g(i27);
            int iA5 = i27 + 2;
            while (true) {
                int i36 = iG7 - 1;
                if (iG7 <= 0) {
                    break;
                }
                int iA6 = eVar.a(kVar, iA5);
                iA5 = eVar.a(uVarA.c(kVar.h, kVar.i, eVar.g(iA6, cArr2), false), iA6 + 2, true, cArr2);
                iG7 = i36;
            }
        }
        int i37 = i14;
        if (i37 != 0) {
            eVar.a(uVarA, kVar, i37, true);
        }
        int i38 = i15;
        if (i38 != 0) {
            eVar.a(uVarA, kVar, i38, false);
        }
        while (cVar != null) {
            c cVar2 = cVar.c;
            cVar.c = null;
            uVarA.a(cVar);
            cVar = cVar2;
        }
        int i39 = i16;
        if (i39 != 0) {
            uVarA.b();
            eVar.a(uVarA, kVar, i39);
        }
        uVarA.c();
        return i6;
    }

    private int c(g gVar, k kVar, int i) {
        int i2;
        c cVar;
        char[] cArr = kVar.c;
        String strG = g(i, cArr);
        String strG2 = g(i + 2, cArr);
        int iG = g(i + 4);
        int i3 = i + 6;
        int i4 = 0;
        c cVar2 = null;
        int i5 = 0;
        String strG3 = null;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = iG - 1;
            if (iG <= 0) {
                break;
            }
            String strG4 = g(i3, cArr);
            int iD = d(i3 + 2);
            int i9 = i3 + 6;
            if ("Signature".equals(strG4)) {
                strG3 = g(i9, cArr);
                i9 = i4;
            } else {
                if ("RuntimeVisibleAnnotations".equals(strG4)) {
                    i6 = i9;
                    cVar = cVar2;
                    i2 = iD;
                    i9 = i4;
                    i9 = i6;
                } else if (!"RuntimeVisibleTypeAnnotations".equals(strG4)) {
                    if ("RuntimeInvisibleAnnotations".equals(strG4)) {
                        i7 = i9;
                        cVar = cVar2;
                        i2 = iD;
                        i9 = i4;
                        i9 = i7;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strG4)) {
                        i5 = i9;
                        cVar = cVar2;
                        i2 = iD;
                        i9 = i4;
                        i9 = i5;
                    } else {
                        int i10 = i4;
                        i9 = i9;
                        c cVar3 = cVar2;
                        i2 = iD;
                        c cVarA = a(kVar.a, strG4, i9, i2, cArr, -1, null);
                        cVarA.c = cVar3;
                        cVar = cVarA;
                        i9 = i10;
                        i5 = i5;
                    }
                }
                int i11 = i9 + i2;
                i4 = i9;
                i3 = i11;
                cVar2 = cVar;
                iG = i8;
            }
            cVar = cVar2;
            i2 = iD;
            int i12 = i9 + i2;
            i4 = i9;
            i3 = i12;
            cVar2 = cVar;
            iG = i8;
        }
        int i13 = i4;
        c cVar4 = cVar2;
        int i14 = i5;
        z zVarB = gVar.b(strG, strG2, strG3);
        if (zVarB == null) {
            return i3;
        }
        if (i6 != 0) {
            int iG2 = g(i6);
            int iA = i6 + 2;
            while (true) {
                int i15 = iG2 - 1;
                if (iG2 <= 0) {
                    break;
                }
                iA = a(zVarB.a(g(iA, cArr), true), iA + 2, true, cArr);
                iG2 = i15;
            }
        }
        if (i7 != 0) {
            int iG3 = g(i7);
            int iA2 = i7 + 2;
            while (true) {
                int i16 = iG3 - 1;
                if (iG3 <= 0) {
                    break;
                }
                iA2 = a(zVarB.a(g(iA2, cArr), false), iA2 + 2, true, cArr);
                iG3 = i16;
            }
        }
        if (i13 != 0) {
            int iG4 = g(i13);
            int iA3 = i13 + 2;
            while (true) {
                int i17 = iG4 - 1;
                if (iG4 <= 0) {
                    break;
                }
                int iA4 = a(kVar, iA3);
                iA3 = a(zVarB.a(kVar.h, kVar.i, g(iA4, cArr), true), iA4 + 2, true, cArr);
                iG4 = i17;
            }
        }
        if (i14 != 0) {
            int iG5 = g(i14);
            int iA5 = i14 + 2;
            while (true) {
                int i18 = iG5 - 1;
                if (iG5 <= 0) {
                    break;
                }
                int iA6 = a(kVar, iA5);
                iA5 = a(zVarB.a(kVar.h, kVar.i, g(iA6, cArr), false), iA6 + 2, true, cArr);
                iG5 = i18;
            }
        }
        c cVar5 = cVar4;
        while (cVar5 != null) {
            c cVar6 = cVar5.c;
            cVar5.c = null;
            zVarB.a(cVar5);
            cVar5 = cVar6;
        }
        zVarB.a();
        return i3;
    }

    public int a(int i) {
        return this.d[i];
    }

    private int a(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || c(iArr[i]) < 67) {
            return -1;
        }
        return g(iArr[i] + 1);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004d A[FALL_THROUGH] */
    private int[] b(u uVar, k kVar, int i, boolean z) {
        int i2;
        char[] cArr = kVar.c;
        int iG = g(i);
        int[] iArr = new int[iG];
        int iA = i + 2;
        for (int i3 = 0; i3 < iG; i3++) {
            iArr[i3] = iA;
            int iD = d(iA);
            int i4 = iD >>> 24;
            if (i4 != 23) {
                switch (i4) {
                    default:
                        switch (i4) {
                            case 64:
                            case 65:
                                int iG2 = g(iA + 1);
                                i2 = iA + 3;
                                while (true) {
                                    int i5 = iG2 - 1;
                                    if (iG2 > 0) {
                                        int iG3 = g(i2);
                                        int iG4 = g(i2 + 2);
                                        i2 += 6;
                                        b(iG3, kVar.g);
                                        b(iG3 + iG4, kVar.g);
                                        iG2 = i5;
                                    }
                                    break;
                                }
                                break;
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i2 = iA + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = iA + 3;
                        break;
                }
            } else {
                i2 = iA + 3;
            }
            int iC = c(i2);
            if (i4 == 66) {
                e0 e0Var = iC != 0 ? new e0(this.c, i2) : null;
                int i6 = i2 + (iC * 2) + 1;
                iA = a(uVar.b(iD & (-256), e0Var, g(i6, cArr), z), i6 + 2, true, cArr);
            } else {
                iA = a((a) null, i2 + (iC * 2) + 3, true, cArr);
            }
        }
        return iArr;
    }

    private c a(c[] cVarArr, String str, int i, int i2, char[] cArr, int i3, s[] sVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.a.equals(str)) {
                return cVar.a(this, i, i2, cArr, i3, sVarArr);
            }
        }
        return new c(str).a(this, i, i2, (char[]) null, -1, (s[]) null);
    }

    public String a(int i, char[] cArr) {
        return f(i, cArr);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 31461. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private void a(sdk.pendo.io.a.u r43, sdk.pendo.io.a.k r44, int r45) {
        /*
            Method dump skipped, instruction units count: 3146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.e.a(sdk.pendo.io.a.u, sdk.pendo.io.a.k, int):void");
    }

    private int a(a aVar, int i, String str, char[] cArr) {
        int i2 = 0;
        if (aVar == null) {
            int i3 = this.c[i] & 255;
            if (i3 == 64) {
                return a((a) null, i + 3, true, cArr);
            }
            if (i3 != 91) {
                return i3 != 101 ? i + 3 : i + 5;
            }
            return a((a) null, i + 1, false, cArr);
        }
        int i4 = i + 1;
        int i5 = this.c[i] & 255;
        if (i5 == 64) {
            return a(aVar.a(str, g(i4, cArr)), i + 3, true, cArr);
        }
        if (i5 != 70) {
            if (i5 == 83) {
                aVar.a(str, Short.valueOf((short) d(this.d[g(i4)])));
                return i + 3;
            }
            if (i5 == 99) {
                aVar.a(str, d0.f(g(i4, cArr)));
                return i + 3;
            }
            if (i5 == 101) {
                aVar.a(str, g(i4, cArr), g(i + 3, cArr));
                return i + 5;
            }
            if (i5 == 115) {
                aVar.a(str, g(i4, cArr));
                return i + 3;
            }
            if (i5 != 73 && i5 != 74) {
                if (i5 == 90) {
                    aVar.a(str, d(this.d[g(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    return i + 3;
                }
                if (i5 == 91) {
                    int iG = g(i4);
                    int i6 = i + 3;
                    if (iG == 0) {
                        return a(aVar.a(str), i + 1, false, cArr);
                    }
                    int i7 = this.c[i6] & 255;
                    if (i7 == 70) {
                        float[] fArr = new float[iG];
                        while (i2 < iG) {
                            fArr[i2] = Float.intBitsToFloat(d(this.d[g(i6 + 1)]));
                            i6 += 3;
                            i2++;
                        }
                        aVar.a(str, fArr);
                        return i6;
                    }
                    if (i7 == 83) {
                        short[] sArr = new short[iG];
                        while (i2 < iG) {
                            sArr[i2] = (short) d(this.d[g(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        aVar.a(str, sArr);
                        return i6;
                    }
                    if (i7 == 90) {
                        boolean[] zArr = new boolean[iG];
                        for (int i8 = 0; i8 < iG; i8++) {
                            zArr[i8] = d(this.d[g(i6 + 1)]) != 0;
                            i6 += 3;
                        }
                        aVar.a(str, zArr);
                        return i6;
                    }
                    if (i7 == 73) {
                        int[] iArr = new int[iG];
                        while (i2 < iG) {
                            iArr[i2] = d(this.d[g(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        aVar.a(str, iArr);
                        return i6;
                    }
                    if (i7 == 74) {
                        long[] jArr = new long[iG];
                        while (i2 < iG) {
                            jArr[i2] = e(this.d[g(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        aVar.a(str, jArr);
                        return i6;
                    }
                    switch (i7) {
                        case 66:
                            byte[] bArr = new byte[iG];
                            while (i2 < iG) {
                                bArr[i2] = (byte) d(this.d[g(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            aVar.a(str, bArr);
                            return i6;
                        case 67:
                            char[] cArr2 = new char[iG];
                            while (i2 < iG) {
                                cArr2[i2] = (char) d(this.d[g(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            aVar.a(str, cArr2);
                            return i6;
                        case 68:
                            double[] dArr = new double[iG];
                            while (i2 < iG) {
                                dArr[i2] = Double.longBitsToDouble(e(this.d[g(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            aVar.a(str, dArr);
                            return i6;
                        default:
                            return a(aVar.a(str), i + 1, false, cArr);
                    }
                }
                switch (i5) {
                    case 66:
                        aVar.a(str, Byte.valueOf((byte) d(this.d[g(i4)])));
                        return i + 3;
                    case 67:
                        aVar.a(str, Character.valueOf((char) d(this.d[g(i4)])));
                        return i + 3;
                    case 68:
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        aVar.a(str, b(g(i4), cArr));
        return i + 3;
    }

    private int a(a aVar, int i, boolean z, char[] cArr) {
        int iG = g(i);
        int iA = i + 2;
        if (!z) {
            while (true) {
                int i2 = iG - 1;
                if (iG <= 0) {
                    break;
                }
                iA = a(aVar, iA, (String) null, cArr);
                iG = i2;
            }
        } else {
            while (true) {
                int i3 = iG - 1;
                if (iG <= 0) {
                    break;
                }
                iA = a(aVar, iA + 2, g(iA, cArr), cArr);
                iG = i3;
            }
        }
        if (aVar != null) {
            aVar.a();
        }
        return iA;
    }

    private int a(g gVar, k kVar, int i) {
        int i2;
        int i3;
        int i4;
        k kVar2 = kVar;
        char[] cArr = kVar2.c;
        int iG = g(i);
        String strG = g(i + 2, cArr);
        String strG2 = g(i + 4, cArr);
        int iG2 = g(i + 6);
        int i5 = i + 8;
        int i6 = iG;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        String strG3 = null;
        Object objB = null;
        c cVar = null;
        while (true) {
            int i11 = iG2 - 1;
            if (iG2 <= 0) {
                break;
            }
            int i12 = i7;
            String strG4 = g(i5, cArr);
            int iD = d(i5 + 2);
            int i13 = i5 + 6;
            if ("ConstantValue".equals(strG4)) {
                int iG3 = g(i13);
                if (iG3 == 0) {
                    i2 = i13;
                    i13 = i8;
                    i3 = iD;
                    i7 = i12;
                    objB = null;
                } else {
                    objB = b(iG3, cArr);
                    i2 = i13;
                    i13 = i8;
                    i3 = iD;
                    i7 = i12;
                }
            } else if ("Signature".equals(strG4)) {
                strG3 = g(i13, cArr);
                i2 = i13;
                i13 = i8;
                i3 = iD;
                i7 = i12;
            } else {
                if ("Deprecated".equals(strG4)) {
                    i4 = 131072 | i6;
                } else if ("Synthetic".equals(strG4)) {
                    i4 = i6 | 4096;
                } else if ("RuntimeVisibleAnnotations".equals(strG4)) {
                    i7 = i13;
                    i2 = i7;
                    i13 = i8;
                    i3 = iD;
                } else {
                    if ("RuntimeVisibleTypeAnnotations".equals(strG4)) {
                        i2 = i13;
                        i9 = i2;
                    } else if ("RuntimeInvisibleAnnotations".equals(strG4)) {
                        i2 = i13;
                        i3 = iD;
                        i7 = i12;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strG4)) {
                        i2 = i13;
                        i10 = i2;
                    } else {
                        i2 = i13;
                        int i14 = i8;
                        i3 = iD;
                        c cVarA = a(kVar2.a, strG4, i2, i3, cArr, -1, null);
                        cVarA.c = cVar;
                        cVar = cVarA;
                        i9 = i9;
                        i13 = i14;
                        i7 = i12;
                        i10 = i10;
                    }
                    i13 = i8;
                    i3 = iD;
                    i7 = i12;
                }
                i2 = i13;
                i6 = i4;
                i13 = i8;
                i3 = iD;
                i7 = i12;
            }
            int i15 = i2 + i3;
            kVar2 = kVar;
            i8 = i13;
            i5 = i15;
            iG2 = i11;
        }
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        int i19 = i10;
        n nVarA = gVar.a(i6, strG, strG2, strG3, objB);
        if (nVarA == null) {
            return i5;
        }
        if (i16 != 0) {
            int iG4 = g(i16);
            int iA = i16 + 2;
            while (true) {
                int i20 = iG4 - 1;
                if (iG4 <= 0) {
                    break;
                }
                iA = a(nVarA.a(g(iA, cArr), true), iA + 2, true, cArr);
                iG4 = i20;
            }
        }
        if (i17 != 0) {
            int iG5 = g(i17);
            int iA2 = i17 + 2;
            while (true) {
                int i21 = iG5 - 1;
                if (iG5 <= 0) {
                    break;
                }
                iA2 = a(nVarA.a(g(iA2, cArr), false), iA2 + 2, true, cArr);
                iG5 = i21;
            }
        }
        if (i18 != 0) {
            int iG6 = g(i18);
            int iA3 = i18 + 2;
            while (true) {
                int i22 = iG6 - 1;
                if (iG6 <= 0) {
                    break;
                }
                int iA4 = a(kVar, iA3);
                iA3 = a(nVarA.a(kVar.h, kVar.i, g(iA4, cArr), true), iA4 + 2, true, cArr);
                iG6 = i22;
            }
        }
        if (i19 != 0) {
            int iG7 = g(i19);
            int iA5 = i19 + 2;
            while (true) {
                int i23 = iG7 - 1;
                if (iG7 <= 0) {
                    break;
                }
                int iA6 = a(kVar, iA5);
                iA5 = a(nVarA.a(kVar.h, kVar.i, g(iA6, cArr), false), iA6 + 2, true, cArr);
                iG7 = i23;
            }
        }
        while (cVar != null) {
            c cVar2 = cVar.c;
            cVar.c = null;
            nVarA.a(cVar);
            cVar = cVar2;
        }
        nVarA.a();
        return i5;
    }

    private void a(g gVar, k kVar, int i, int i2, String str) {
        String[] strArr;
        char[] cArr = kVar.c;
        int i3 = i + 6;
        w wVarA = gVar.a(d(i, cArr), g(i + 2), g(i + 4, cArr));
        if (wVarA == null) {
            return;
        }
        if (str != null) {
            wVarA.a(str);
        }
        if (i2 != 0) {
            int iG = g(i2);
            int i4 = i2 + 2;
            while (true) {
                int i5 = iG - 1;
                if (iG <= 0) {
                    break;
                }
                wVarA.b(e(i4, cArr));
                i4 += 2;
                iG = i5;
            }
        }
        int iG2 = g(i3);
        int i6 = i + 8;
        while (true) {
            int i7 = iG2 - 1;
            if (iG2 <= 0) {
                break;
            }
            String strD = d(i6, cArr);
            int iG3 = g(i6 + 2);
            String strG = g(i6 + 4, cArr);
            i6 += 6;
            wVarA.a(strD, iG3, strG);
            iG2 = i7;
        }
        int iG4 = g(i6);
        int i8 = i6 + 2;
        while (true) {
            int i9 = iG4 - 1;
            String[] strArr2 = null;
            if (iG4 <= 0) {
                break;
            }
            String strE = e(i8, cArr);
            int iG5 = g(i8 + 2);
            int iG6 = g(i8 + 4);
            i8 += 6;
            if (iG6 != 0) {
                strArr2 = new String[iG6];
                for (int i10 = 0; i10 < iG6; i10++) {
                    strArr2[i10] = d(i8, cArr);
                    i8 += 2;
                }
            }
            wVarA.a(strE, iG5, strArr2);
            iG4 = i9;
        }
        int iG7 = g(i8);
        int i11 = i8 + 2;
        while (true) {
            int i12 = iG7 - 1;
            if (iG7 <= 0) {
                break;
            }
            String strE2 = e(i11, cArr);
            int iG8 = g(i11 + 2);
            int iG9 = g(i11 + 4);
            i11 += 6;
            if (iG9 != 0) {
                strArr = new String[iG9];
                for (int i13 = 0; i13 < iG9; i13++) {
                    strArr[i13] = d(i11, cArr);
                    i11 += 2;
                }
            } else {
                strArr = null;
            }
            wVarA.b(strE2, iG8, strArr);
            iG7 = i12;
        }
        int iG10 = g(i11);
        int i14 = i11 + 2;
        while (true) {
            int i15 = iG10 - 1;
            if (iG10 <= 0) {
                break;
            }
            wVarA.c(a(i14, cArr));
            i14 += 2;
            iG10 = i15;
        }
        int iG11 = g(i14);
        int i16 = i14 + 2;
        while (true) {
            int i17 = iG11 - 1;
            if (iG11 <= 0) {
                wVarA.a();
                return;
            }
            String strA = a(i16, cArr);
            int iG12 = g(i16 + 2);
            i16 += 4;
            String[] strArr3 = new String[iG12];
            for (int i18 = 0; i18 < iG12; i18++) {
                strArr3[i18] = a(i16, cArr);
                i16 += 2;
            }
            wVarA.a(strA, strArr3);
            iG11 = i17;
        }
    }

    private void a(u uVar, k kVar, int i, boolean z) {
        int iA = i + 1;
        int i2 = this.c[i] & 255;
        uVar.a(i2, z);
        char[] cArr = kVar.c;
        for (int i3 = 0; i3 < i2; i3++) {
            int iG = g(iA);
            iA += 2;
            while (true) {
                int i4 = iG - 1;
                if (iG > 0) {
                    iA = a(uVar.a(i3, g(iA, cArr), z), iA + 2, true, cArr);
                    iG = i4;
                }
            }
        }
    }

    private int a(int i, boolean z, boolean z2, k kVar) {
        int iA;
        int i2;
        e eVar;
        char[] cArr = kVar.c;
        s[] sVarArr = kVar.g;
        if (z) {
            iA = i + 1;
            i2 = this.c[i] & 255;
        } else {
            kVar.m = -1;
            iA = i;
            i2 = 255;
        }
        kVar.p = 0;
        if (i2 < 64) {
            kVar.n = 3;
            kVar.r = 0;
            eVar = this;
        } else if (i2 < 128) {
            i2 -= 64;
            eVar = this;
            iA = eVar.a(iA, kVar.s, 0, cArr, sVarArr);
            kVar.n = 4;
            kVar.r = 1;
        } else {
            if (i2 < 247) {
                throw new IllegalArgumentException();
            }
            int iG = g(iA);
            int i3 = iA;
            iA = i3 + 2;
            if (i2 == 247) {
                eVar = this;
                iA = eVar.a(iA, kVar.s, 0, cArr, sVarArr);
                kVar.n = 4;
                kVar.r = 1;
            } else {
                if (i2 >= 248 && i2 < 251) {
                    kVar.n = 2;
                    int i4 = 251 - i2;
                    kVar.p = i4;
                    kVar.o -= i4;
                } else if (i2 == 251) {
                    kVar.n = 3;
                } else if (i2 < 255) {
                    int i5 = i2 - 251;
                    int i6 = z2 ? kVar.o : 0;
                    int i7 = i5;
                    while (i7 > 0) {
                        iA = a(iA, kVar.q, i6, cArr, sVarArr);
                        i7--;
                        i6++;
                    }
                    eVar = this;
                    kVar.n = 1;
                    kVar.p = i5;
                    kVar.o += i5;
                    kVar.r = 0;
                } else {
                    eVar = this;
                    int iG2 = eVar.g(iA);
                    int iA2 = i3 + 4;
                    kVar.n = 0;
                    kVar.p = iG2;
                    kVar.o = iG2;
                    for (int i8 = 0; i8 < iG2; i8++) {
                        iA2 = eVar.a(iA2, kVar.q, i8, cArr, sVarArr);
                    }
                    int iG3 = eVar.g(iA2);
                    iA = iA2 + 2;
                    kVar.r = iG3;
                    for (int i9 = 0; i9 < iG3; i9++) {
                        iA = eVar.a(iA, kVar.s, i9, cArr, sVarArr);
                    }
                }
                kVar.r = 0;
                eVar = this;
            }
            i2 = iG;
        }
        int i10 = kVar.m + i2 + 1;
        kVar.m = i10;
        eVar.b(i10, sVarArr);
        return iA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    private int a(k kVar, int i) {
        int i2;
        int i3;
        int iD = d(i);
        int i4 = iD >>> 24;
        if (i4 != 0 && i4 != 1) {
            switch (i4) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = iD & (-256);
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = iD & (-16777216);
                    i3 = i + 1;
                    break;
                case 22:
                    i2 = iD & SupportMenu.CATEGORY_MASK;
                    i3 = i + 2;
                    break;
                default:
                    switch (i4) {
                        case 64:
                        case 65:
                            i2 = iD & (-16777216);
                            int iG = g(i + 1);
                            i3 = i + 3;
                            kVar.j = new s[iG];
                            kVar.k = new s[iG];
                            kVar.l = new int[iG];
                            for (int i5 = 0; i5 < iG; i5++) {
                                int iG2 = g(i3);
                                int iG3 = g(i3 + 2);
                                int iG4 = g(i3 + 4);
                                i3 += 6;
                                kVar.j[i5] = b(iG2, kVar.g);
                                kVar.k[i5] = b(iG2 + iG3, kVar.g);
                                kVar.l[i5] = iG4;
                            }
                            break;
                        case 66:
                            i2 = iD & (-256);
                            i3 = i + 3;
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = iD & (-16777216);
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = iD & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
        } else {
            i2 = iD & SupportMenu.CATEGORY_MASK;
            i3 = i + 2;
        }
        kVar.h = i2;
        int iC = c(i3);
        kVar.i = iC == 0 ? null : new e0(this.c, i3);
        return i3 + 1 + (iC * 2);
    }

    private String a(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.c;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            if ((b & 128) == 0) {
                cArr[i5] = (char) (b & 127);
                i5++;
                i = i6;
            } else {
                if ((b & CtapException.ERR_EXTENSION_FIRST) == 192) {
                    i3 = i5 + 1;
                    i += 2;
                    cArr[i5] = (char) (((b & Ascii.US) << 6) + (bArr[i6] & 63));
                } else {
                    i3 = i5 + 1;
                    int i7 = i + 2;
                    i += 3;
                    cArr[i5] = (char) (((b & Ascii.SI) << 12) + ((bArr[i6] & 63) << 6) + (bArr[i7] & 63));
                }
                i5 = i3;
            }
        }
        return new String(cArr, 0, i5);
    }

    private int a(int i, Object[] objArr, int i2, char[] cArr, s[] sVarArr) {
        int i3 = i + 1;
        switch (this.c[i] & 255) {
            case 0:
                objArr[i2] = y.a;
                return i3;
            case 1:
                objArr[i2] = y.b;
                return i3;
            case 2:
                objArr[i2] = y.c;
                return i3;
            case 3:
                objArr[i2] = y.d;
                return i3;
            case 4:
                objArr[i2] = y.e;
                return i3;
            case 5:
                objArr[i2] = y.f;
                return i3;
            case 6:
                objArr[i2] = y.g;
                return i3;
            case 7:
                objArr[i2] = a(i3, cArr);
                break;
            case 8:
                objArr[i2] = b(g(i3), sVarArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i + 3;
    }
}
