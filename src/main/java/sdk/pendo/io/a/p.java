package sdk.pendo.io.a;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class p {
    s a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private short f;
    private short g;
    private int h;
    private int[] i;

    p(s sVar) {
        this.a = sVar;
    }

    private int b(int i) {
        int[] iArr = this.d;
        if (iArr == null || i >= iArr.length) {
            return i | 16777216;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = 16777216 | i;
        iArr[i] = i3;
        return i3;
    }

    private void c(int i) {
        short s;
        short s2 = this.g;
        if (s2 >= i) {
            s = (short) (s2 - i);
        } else {
            this.f = (short) (this.f - (i - s2));
            s = 0;
        }
        this.g = s;
    }

    private void d(int i) {
        if (this.e == null) {
            this.e = new int[10];
        }
        int length = this.e.length;
        short s = this.g;
        if (s >= length) {
            int[] iArr = new int[Math.max(s + 1, length * 2)];
            System.arraycopy(this.e, 0, iArr, 0, length);
            this.e = iArr;
        }
        int[] iArr2 = this.e;
        short s2 = this.g;
        short s3 = (short) (s2 + 1);
        this.g = s3;
        iArr2[s2] = i;
        short s4 = (short) (this.f + s3);
        s sVar = this.a;
        if (s4 > sVar.h) {
            sVar.h = s4;
        }
    }

    final void a(v vVar) {
        int[] iArr = this.b;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 2;
            if (i2 >= iArr.length) {
                break;
            }
            int i6 = iArr[i2];
            if (i6 != 4194308 && i6 != 4194307) {
                i5 = 1;
            }
            i2 += i5;
            i4++;
            if (i6 != 4194304) {
                i3 += i4;
                i4 = 0;
            }
        }
        int[] iArr2 = this.c;
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i7 += (i9 == 4194308 || i9 == 4194307) ? 2 : 1;
            i8++;
        }
        int iA = vVar.a(this.a.d, i3, i8);
        int i10 = 0;
        while (true) {
            int i11 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            int i12 = iArr[i10];
            i10 += (i12 == 4194308 || i12 == 4194307) ? 2 : 1;
            vVar.g(iA, i12);
            i3 = i11;
            iA++;
        }
        while (true) {
            int i13 = i8 - 1;
            if (i8 <= 0) {
                vVar.k();
                return;
            }
            int i14 = iArr2[i];
            i += (i14 == 4194308 || i14 == 4194307) ? 2 : 1;
            vVar.g(iA, i14);
            i8 = i13;
            iA++;
        }
    }

    private void a(int i) {
        if (this.i == null) {
            this.i = new int[2];
        }
        int length = this.i.length;
        int i2 = this.h;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.i, 0, iArr, 0, length);
            this.i = iArr;
        }
        int[] iArr2 = this.i;
        int i3 = this.h;
        this.h = i3 + 1;
        iArr2[i3] = i;
    }

    private int b() {
        short s = this.g;
        if (s <= 0) {
            short s2 = (short) (this.f - 1);
            this.f = s2;
            return (-s2) | 20971520;
        }
        int[] iArr = this.e;
        short s3 = (short) (s - 1);
        this.g = s3;
        return iArr[s3];
    }

    private void b(c0 c0Var, String str) {
        int iA = a(c0Var, str, str.charAt(0) == '(' ? d0.e(str) : 0);
        if (iA != 0) {
            d(iA);
            if (iA == 4194308 || iA == 4194307) {
                d(4194304);
            }
        }
    }

    final void a(p pVar) {
        this.b = pVar.b;
        this.c = pVar.c;
        this.f = (short) 0;
        this.d = pVar.d;
        this.e = pVar.e;
        this.g = pVar.g;
        this.h = pVar.h;
        this.i = pVar.i;
    }

    private void b(int i, int i2) {
        if (this.d == null) {
            this.d = new int[10];
        }
        int length = this.d.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.d, 0, iArr, 0, length);
            this.d = iArr;
        }
        this.d[i] = i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:108:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c3 A[FALL_THROUGH, PHI: r10
      0x01c3: PHI (r10v1 int) = (r10v0 int), (r10v2 int), (r10v0 int), (r10v0 int), (r10v0 int), (r10v0 int), (r10v0 int) binds: [B:3:0x001a, B:24:0x0068, B:13:0x003e, B:4:0x001d, B:99:0x0199, B:107:0x01b5, B:100:0x019d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:111:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:131:0x0245  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    /* JADX WARN: Code duplicated, block: B:92:0x017c  */
    /* JADX WARN: Code duplicated, block: B:97:0x018f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0199  */
    /* JADX WARN: Switch 'out' block B:123:0x0235 for B:64:0x00fd already processed. Defaulting to fallback option. */
    void a(int i, int i2, b0 b0Var, c0 c0Var) {
        String str;
        int i3;
        int iB;
        int iB2;
        int iB3;
        int iA;
        int i4;
        int iG = 4194309;
        int i5 = 4194307;
        switch (i) {
            case 0:
                return;
            case 1:
                d(iG);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
                iG = 4194305;
                d(iG);
                return;
            case 9:
            case 10:
                i5 = 4194308;
                d(i5);
                iG = 4194304;
                d(iG);
                return;
            case 11:
            case 12:
            case 13:
                iG = 4194306;
                d(iG);
                return;
            case 14:
            case 15:
                d(i5);
                iG = 4194304;
                d(iG);
                return;
            case 18:
                int i6 = b0Var.b;
                switch (i6) {
                    case 3:
                        iG = 4194305;
                        d(iG);
                        return;
                    case 4:
                        iG = 4194306;
                        d(iG);
                        return;
                    case 5:
                        i5 = 4194308;
                    case 6:
                        d(i5);
                        iG = 4194304;
                        d(iG);
                        return;
                    case 7:
                        str = "java/lang/Class";
                        iG = c0Var.g(str) | 8388608;
                        d(iG);
                        return;
                    case 8:
                        str = "java/lang/String";
                        iG = c0Var.g(str) | 8388608;
                        d(iG);
                        return;
                    default:
                        switch (i6) {
                            case 15:
                                str = "java/lang/invoke/MethodHandle";
                                break;
                            case 16:
                                str = "java/lang/invoke/MethodType";
                                break;
                            case 17:
                                b(c0Var, b0Var.e);
                                return;
                            default:
                                throw new AssertionError();
                        }
                        iG = c0Var.g(str) | 8388608;
                        d(iG);
                        return;
                }
                break;
            default:
                switch (i) {
                    case 21:
                        iG = 4194305;
                        d(iG);
                        return;
                    case 22:
                        i5 = 4194308;
                        d(i5);
                        iG = 4194304;
                        d(iG);
                        return;
                    case 23:
                        iG = 4194306;
                        d(iG);
                        return;
                    case 24:
                        d(i5);
                        iG = 4194304;
                        d(iG);
                        return;
                    case 25:
                        iG = b(i2);
                        d(iG);
                        return;
                    default:
                        switch (i) {
                            case 46:
                            case 51:
                            case 52:
                            case 53:
                                c(2);
                                iG = 4194305;
                                d(iG);
                                return;
                            case 47:
                                c(2);
                                i5 = 4194308;
                                d(i5);
                                iG = 4194304;
                                d(iG);
                                return;
                            case 48:
                                c(2);
                                iG = 4194306;
                                d(iG);
                                return;
                            case 49:
                                c(2);
                                d(i5);
                                iG = 4194304;
                                d(iG);
                                return;
                            case 50:
                                c(1);
                                int iB4 = b();
                                if (iB4 != 4194309) {
                                    iB4 -= 67108864;
                                }
                                iG = iB4;
                                d(iG);
                                return;
                            case 54:
                            case 56:
                            case 58:
                                b(i2, b());
                                if (i2 > 0) {
                                    i3 = i2 - 1;
                                    iB = b(i3);
                                    if (iB != 4194308 && iB != 4194307) {
                                        int i7 = iB & 62914560;
                                        if (i7 != 16777216 && i7 != 20971520) {
                                            return;
                                        }
                                        b(i3, iB | 1048576);
                                        return;
                                    }
                                    b(i3, 4194304);
                                    return;
                                }
                                return;
                            case 55:
                            case 57:
                                c(1);
                                b(i2, b());
                                b(i2 + 1, 4194304);
                                if (i2 > 0) {
                                    i3 = i2 - 1;
                                    iB = b(i3);
                                    if (iB != 4194308 && iB != 4194307) {
                                        int i8 = iB & 62914560;
                                        if (i8 != 16777216 && i8 != 20971520) {
                                            return;
                                        }
                                        b(i3, iB | 1048576);
                                        return;
                                    }
                                    b(i3, 4194304);
                                    return;
                                }
                                return;
                            default:
                                switch (i) {
                                    case 79:
                                    case 81:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                        c(3);
                                        return;
                                    case 80:
                                    case 82:
                                        c(4);
                                        return;
                                    case 87:
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
                                    case 191:
                                    case 194:
                                    case 195:
                                        c(1);
                                        return;
                                    case 88:
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
                                        c(2);
                                        return;
                                    case 89:
                                        iG = b();
                                        d(iG);
                                        d(iG);
                                        return;
                                    case 90:
                                        iG = b();
                                        iB2 = b();
                                        d(iG);
                                        d(iB2);
                                        d(iG);
                                        return;
                                    case 91:
                                        iG = b();
                                        iB2 = b();
                                        iB3 = b();
                                        d(iG);
                                        d(iB3);
                                        d(iB2);
                                        d(iG);
                                        return;
                                    case 92:
                                        iG = b();
                                        iB2 = b();
                                        d(iB2);
                                        d(iG);
                                        d(iB2);
                                        d(iG);
                                        return;
                                    case 93:
                                        iG = b();
                                        iB2 = b();
                                        iB3 = b();
                                        d(iB2);
                                        d(iG);
                                        d(iB3);
                                        d(iB2);
                                        d(iG);
                                        return;
                                    case 94:
                                        iG = b();
                                        iB2 = b();
                                        iB3 = b();
                                        int iB5 = b();
                                        d(iB2);
                                        d(iG);
                                        d(iB5);
                                        d(iB3);
                                        d(iB2);
                                        d(iG);
                                        return;
                                    case 95:
                                        iB2 = b();
                                        iG = b();
                                        d(iB2);
                                        d(iG);
                                        return;
                                    case 96:
                                    case 100:
                                    case 104:
                                    case 108:
                                    case 112:
                                    case 120:
                                    case 122:
                                    case 124:
                                    case 126:
                                    case 128:
                                    case 130:
                                    case 136:
                                    case Token.LOCAL_BLOCK /* 142 */:
                                    case Token.XMLEND /* 149 */:
                                    case 150:
                                        c(2);
                                        iG = 4194305;
                                        d(iG);
                                        return;
                                    case 97:
                                    case 101:
                                    case 105:
                                    case 109:
                                    case 113:
                                    case 127:
                                    case 129:
                                    case Token.LABEL /* 131 */:
                                        c(4);
                                        i5 = 4194308;
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case 98:
                                    case 102:
                                    case 106:
                                    case 110:
                                    case 114:
                                    case Token.SCRIPT /* 137 */:
                                    case Token.DOTDOT /* 144 */:
                                        c(2);
                                        iG = 4194306;
                                        d(iG);
                                        return;
                                    case 99:
                                    case 103:
                                    case 107:
                                    case 111:
                                    case 115:
                                        c(4);
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case Token.COLONCOLON /* 145 */:
                                    case Token.XML /* 146 */:
                                    case Token.DOTQUERY /* 147 */:
                                    case Token.LAST_TOKEN /* 167 */:
                                    case 177:
                                        return;
                                    case 121:
                                    case 123:
                                    case 125:
                                        c(3);
                                        i5 = 4194308;
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case Token.TARGET /* 132 */:
                                        b(i2, 4194305);
                                        return;
                                    case Token.LOOP /* 133 */:
                                    case 140:
                                        c(1);
                                        i5 = 4194308;
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case 134:
                                        c(1);
                                        iG = 4194306;
                                        d(iG);
                                        return;
                                    case 135:
                                    case Token.SETELEM_OP /* 141 */:
                                        c(1);
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case 138:
                                        c(2);
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case 139:
                                    case 190:
                                    case 193:
                                        c(1);
                                        iG = 4194305;
                                        d(iG);
                                        return;
                                    case Token.SET_REF_OP /* 143 */:
                                        c(2);
                                        i5 = 4194308;
                                        d(i5);
                                        iG = 4194304;
                                        d(iG);
                                        return;
                                    case Token.XMLATTR /* 148 */:
                                    case Token.TO_DOUBLE /* 151 */:
                                    case Token.GET /* 152 */:
                                        c(4);
                                        iG = 4194305;
                                        d(iG);
                                        return;
                                    case 168:
                                    case 169:
                                        throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
                                    case 178:
                                        b(c0Var, b0Var.e);
                                        return;
                                    case 179:
                                        a(b0Var.e);
                                        return;
                                    case 180:
                                        c(1);
                                        b(c0Var, b0Var.e);
                                        return;
                                    case 181:
                                        a(b0Var.e);
                                        b();
                                        return;
                                    case 182:
                                    case 183:
                                    case 184:
                                    case 185:
                                        a(b0Var.e);
                                        if (i != 184) {
                                            int iB6 = b();
                                            if (i == 183 && b0Var.d.charAt(0) == '<') {
                                                a(iB6);
                                            }
                                        }
                                        b(c0Var, b0Var.e);
                                        return;
                                    case ContextualToolbar.DRAG_BUTTON_ALPHA /* 186 */:
                                        a(b0Var.e);
                                        b(c0Var, b0Var.e);
                                        return;
                                    case 187:
                                        iA = c0Var.a(b0Var.e, i2);
                                        i4 = 12582912;
                                        iG = iA | i4;
                                        d(iG);
                                        return;
                                    case TsExtractor.TS_PACKET_SIZE /* 188 */:
                                        b();
                                        switch (i2) {
                                            case 4:
                                                iG = 71303177;
                                                d(iG);
                                                return;
                                            case 5:
                                                iG = 71303179;
                                                d(iG);
                                                return;
                                            case 6:
                                                iG = 71303170;
                                                d(iG);
                                                return;
                                            case 7:
                                                iG = 71303171;
                                                d(iG);
                                                return;
                                            case 8:
                                                iG = 71303178;
                                                d(iG);
                                                return;
                                            case 9:
                                                iG = 71303180;
                                                d(iG);
                                                return;
                                            case 10:
                                                iG = 71303169;
                                                d(iG);
                                                return;
                                            case 11:
                                                iG = 71303172;
                                                d(iG);
                                                return;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                                        String str2 = b0Var.e;
                                        b();
                                        if (str2.charAt(0) == '[') {
                                            b(c0Var, "[" + str2);
                                            return;
                                        }
                                        iA = c0Var.g(str2);
                                        i4 = 75497472;
                                        iG = iA | i4;
                                        d(iG);
                                        return;
                                    case 192:
                                        str = b0Var.e;
                                        b();
                                        if (str.charAt(0) == '[') {
                                            b(c0Var, str);
                                            return;
                                        }
                                        iG = c0Var.g(str) | 8388608;
                                        d(iG);
                                        return;
                                    default:
                                        switch (i) {
                                            case 197:
                                                c(i2);
                                                b(c0Var, b0Var.e);
                                                return;
                                            case 198:
                                            case 199:
                                                c(1);
                                                return;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                }
                        }
                }
        }
    }

    static int a(c0 c0Var, Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() | 4194304;
        }
        return obj instanceof String ? a(c0Var, d0.d((String) obj).a(), 0) : c0Var.a("", ((s) obj).d) | 12582912;
    }

    private static int a(c0 c0Var, String str, int i) {
        char cCharAt = str.charAt(i);
        int iG = 4194306;
        if (cCharAt == 'F') {
            return 4194306;
        }
        if (cCharAt == 'L') {
            return c0Var.g(str.substring(i + 1, str.length() - 1)) | 8388608;
        }
        if (cCharAt != 'S') {
            if (cCharAt == 'V') {
                return 0;
            }
            if (cCharAt != 'I') {
                if (cCharAt == 'J') {
                    return 4194308;
                }
                if (cCharAt != 'Z') {
                    if (cCharAt == '[') {
                        int i2 = i + 1;
                        while (str.charAt(i2) == '[') {
                            i2++;
                        }
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 != 'F') {
                            if (cCharAt2 == 'L') {
                                iG = c0Var.g(str.substring(i2 + 1, str.length() - 1)) | 8388608;
                            } else if (cCharAt2 == 'S') {
                                iG = 4194316;
                            } else if (cCharAt2 == 'Z') {
                                iG = 4194313;
                            } else if (cCharAt2 == 'I') {
                                iG = 4194305;
                            } else if (cCharAt2 != 'J') {
                                switch (cCharAt2) {
                                    case 'B':
                                        iG = 4194314;
                                        break;
                                    case 'C':
                                        iG = 4194315;
                                        break;
                                    case 'D':
                                        iG = 4194307;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                iG = 4194308;
                            }
                        }
                        return ((i2 - i) << 26) | iG;
                    }
                    switch (cCharAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return 4194307;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return 4194305;
    }

    static int a(c0 c0Var, String str) {
        return c0Var.g(str) | 8388608;
    }

    private int a(int i, int i2) {
        int i3 = (-67108864) & i;
        int i4 = 62914560 & i;
        if (i4 == 16777216) {
            int i5 = i3 + this.b[i & 1048575];
            if ((i & 1048576) == 0 || !(i5 == 4194308 || i5 == 4194307)) {
                return i5;
            }
            return 4194304;
        }
        if (i4 != 20971520) {
            return i;
        }
        int i6 = i3 + this.c[i2 - (i & 1048575)];
        if ((i & 1048576) == 0 || !(i6 == 4194308 || i6 == 4194307)) {
            return i6;
        }
        return 4194304;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:23:0x004d A[LOOP:0: B:7:0x000d->B:23:0x004d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0037 A[SYNTHETIC] */
    private int a(c0 c0Var, int i) {
        int i2;
        String strB;
        if (i == 4194310 || ((-4194304) & i) == 12582912) {
            for (int i3 = 0; i3 < this.h; i3++) {
                int i4 = this.i[i3];
                int i5 = (-67108864) & i4;
                int i6 = 62914560 & i4;
                int i7 = i4 & 1048575;
                if (i6 == 16777216) {
                    i2 = this.b[i7];
                } else {
                    if (i6 == 20971520) {
                        int[] iArr = this.c;
                        i2 = iArr[iArr.length - i7];
                    }
                    if (i == i4) {
                        if (i == 4194310) {
                            strB = c0Var.b();
                        } else {
                            strB = c0Var.c(i & 1048575).e;
                        }
                        return 8388608 | c0Var.g(strB);
                    }
                }
                i4 = i2 + i5;
                if (i == i4) {
                    if (i == 4194310) {
                        strB = c0Var.b();
                    } else {
                        strB = c0Var.c(i & 1048575).e;
                    }
                    return 8388608 | c0Var.g(strB);
                }
            }
        }
        return i;
    }

    final int a() {
        return this.c.length;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0064  */
    private static boolean a(c0 c0Var, int i, int[] iArr, int i2) {
        int iMin;
        int i3 = iArr[i2];
        if (i3 == i) {
            return false;
        }
        if ((67108863 & i) == 4194309) {
            if (i3 == 4194309) {
                return false;
            }
            i = 4194309;
        }
        if (i3 == 0) {
            iArr[i2] = i;
            return true;
        }
        int i4 = i3 & (-67108864);
        if (i4 != 0 || (i3 & 62914560) == 8388608) {
            if (i == 4194309) {
                return false;
            }
            if ((i & (-4194304)) != ((-4194304) & i3)) {
                int i5 = i & (-67108864);
                if (i5 != 0 || (i & 62914560) == 8388608) {
                    if (i5 != 0 && (i & 62914560) != 8388608) {
                        i5 -= 67108864;
                    }
                    if (i4 != 0 && (i3 & 62914560) != 8388608) {
                        i4 -= 67108864;
                    }
                    iMin = Math.min(i5, i4);
                } else {
                    i = 4194304;
                }
            } else if ((i3 & 62914560) == 8388608) {
                i = (i & (-67108864)) | 8388608 | c0Var.b(i & 1048575, 1048575 & i3);
            } else {
                iMin = (i & (-67108864)) - 67108864;
            }
            i = iMin | 8388608 | c0Var.g("java/lang/Object");
        } else if (i3 != 4194309 || ((i & (-67108864)) == 0 && (i & 62914560) != 8388608)) {
            i = 4194304;
        }
        if (i == i3) {
            return false;
        }
        iArr[i2] = i;
        return true;
    }

    final boolean a(c0 c0Var, p pVar, int i) {
        boolean zA;
        int i2;
        int length = this.b.length;
        int length2 = this.c.length;
        boolean zA2 = true;
        if (pVar.b == null) {
            pVar.b = new int[length];
            zA = true;
        } else {
            zA = false;
        }
        int i3 = 0;
        while (i3 < length) {
            int[] iArr = this.d;
            int iA = (iArr == null || i3 >= iArr.length || (i2 = iArr[i3]) == 0) ? this.b[i3] : a(i2, length2);
            if (this.i != null) {
                iA = a(c0Var, iA);
            }
            zA |= a(c0Var, iA, pVar.b, i3);
            i3++;
        }
        if (i > 0) {
            for (int i4 = 0; i4 < length; i4++) {
                zA |= a(c0Var, this.b[i4], pVar.b, i4);
            }
            if (pVar.c == null) {
                pVar.c = new int[1];
            } else {
                zA2 = zA;
            }
            return a(c0Var, i, pVar.c, 0) | zA2;
        }
        int length3 = this.c.length + this.f;
        if (pVar.c == null) {
            pVar.c = new int[this.g + length3];
        } else {
            zA2 = zA;
        }
        for (int i5 = 0; i5 < length3; i5++) {
            int iA2 = this.c[i5];
            if (this.i != null) {
                iA2 = a(c0Var, iA2);
            }
            zA2 |= a(c0Var, iA2, pVar.c, i5);
        }
        for (int i6 = 0; i6 < this.g; i6++) {
            int iA3 = a(this.e[i6], length2);
            if (this.i != null) {
                iA3 = a(c0Var, iA3);
            }
            zA2 |= a(c0Var, iA3, pVar.c, length3 + i6);
        }
        return zA2;
    }

    private void a(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            c((d0.b(str) >> 2) - 1);
        } else if (cCharAt == 'J' || cCharAt == 'D') {
            c(2);
        } else {
            c(1);
        }
    }

    static void a(c0 c0Var, int i, d dVar) {
        char c;
        d dVarB;
        String string;
        int i2;
        int i3 = ((-67108864) & i) >> 26;
        if (i3 == 0) {
            int i4 = i & 1048575;
            int i5 = i & 62914560;
            if (i5 == 4194304) {
                dVar.b(i4);
                return;
            }
            if (i5 == 8388608) {
                dVarB = dVar.b(7);
                string = c0Var.c(i4).e;
            } else {
                if (i5 != 12582912) {
                    throw new AssertionError();
                }
                dVarB = dVar.b(8);
                i2 = (int) c0Var.c(i4).f;
            }
            dVarB.d(i2);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            i3 = i6;
        }
        if ((i & 62914560) == 8388608) {
            sb.append('L').append(c0Var.c(i & 1048575).e).append(';');
        } else {
            int i7 = i & 1048575;
            if (i7 == 1) {
                c = 'I';
            } else if (i7 == 2) {
                c = 'F';
            } else if (i7 == 3) {
                c = 'D';
            } else if (i7 != 4) {
                switch (i7) {
                    case 9:
                        c = 'Z';
                        break;
                    case 10:
                        c = 'B';
                        break;
                    case 11:
                        c = 'C';
                        break;
                    case 12:
                        c = 'S';
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                c = 'J';
            }
            sb.append(c);
        }
        dVarB = dVar.b(7);
        string = sb.toString();
        i2 = c0Var.a(string).a;
        dVarB.d(i2);
    }

    final void a(c0 c0Var, int i, Object[] objArr, int i2, Object[] objArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            this.b[i3] = a(c0Var, objArr[i4]);
            Object obj = objArr[i4];
            if (obj == y.e || obj == y.d) {
                i3 += 2;
                this.b[i5] = 4194304;
            } else {
                i3 = i5;
            }
        }
        while (true) {
            int[] iArr = this.b;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = 4194304;
            i3++;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            Object obj2 = objArr2[i7];
            if (obj2 == y.e || obj2 == y.d) {
                i6++;
            }
        }
        this.c = new int[i6 + i2];
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i8 + 1;
            this.c[i8] = a(c0Var, objArr2[i9]);
            Object obj3 = objArr2[i9];
            if (obj3 == y.e || obj3 == y.d) {
                i8 += 2;
                this.c[i10] = 4194304;
            } else {
                i8 = i10;
            }
        }
        this.g = (short) 0;
        this.h = 0;
    }

    final void a(c0 c0Var, int i, String str, int i2) {
        int i3;
        int[] iArr = new int[i2];
        this.b = iArr;
        this.c = new int[0];
        if ((i & 8) == 0) {
            i3 = 1;
            if ((i & 262144) == 0) {
                iArr[0] = c0Var.g(c0Var.b()) | 8388608;
            } else {
                iArr[0] = 4194310;
            }
        } else {
            i3 = 0;
        }
        for (d0 d0Var : d0.a(str)) {
            int iA = a(c0Var, d0Var.a(), 0);
            int[] iArr2 = this.b;
            int i4 = i3 + 1;
            iArr2[i3] = iA;
            if (iA == 4194308 || iA == 4194307) {
                i3 += 2;
                iArr2[i4] = 4194304;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.b[i3] = 4194304;
            i3++;
        }
    }
}
