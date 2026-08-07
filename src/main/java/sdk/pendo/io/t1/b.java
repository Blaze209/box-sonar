package sdk.pendo.io.t1;

import androidx.collection.SieveCacheKt;
import com.google.android.material.internal.ViewUtils;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import java.math.BigInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.internal.Buffer;
import sdk.pendo.io.v1.j;
import sdk.pendo.io.v1.k;

/* JADX INFO: loaded from: classes5.dex */
abstract class b {
    protected static boolean[] t;
    protected static boolean[] u;
    protected static boolean[] v;
    protected static boolean[] w;
    protected static boolean[] x;
    protected char a;
    j b;
    private String c;
    protected final a d = new a(15);
    protected Object e;
    protected String f;
    protected int g;
    protected final boolean h;
    protected final boolean i;
    protected final boolean j;
    protected final boolean k;
    protected final boolean l;
    protected final boolean m;
    protected final boolean n;
    protected final boolean o;
    protected final boolean p;
    protected final boolean q;
    protected final boolean r;
    protected final boolean s;

    public static class a {
        char[] a;
        int b = -1;

        public a(int i) {
            this.a = new char[i];
        }

        public void a(char c) {
            int i = this.b + 1;
            this.b = i;
            char[] cArr = this.a;
            if (cArr.length <= i) {
                char[] cArr2 = new char[(cArr.length * 2) + 1];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.a = cArr2;
            }
            this.a[this.b] = c;
        }

        public String toString() {
            return new String(this.a, 0, this.b + 1);
        }

        public void a() {
            this.b = -1;
        }
    }

    static {
        boolean[] zArr = new boolean[126];
        t = zArr;
        boolean[] zArr2 = new boolean[126];
        u = zArr2;
        boolean[] zArr3 = new boolean[126];
        v = zArr3;
        boolean[] zArr4 = new boolean[126];
        w = zArr4;
        boolean[] zArr5 = new boolean[126];
        x = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public b(int i) {
        this.i = (i & 4) > 0;
        this.j = (i & 2) > 0;
        this.k = (i & 1) > 0;
        this.o = (i & 8) > 0;
        this.q = (i & 16) > 0;
        this.h = (i & 32) > 0;
        this.l = (i & 64) > 0;
        this.p = (i & 128) > 0;
        this.m = (i & ViewUtils.EDGE_TO_EDGE_FLAGS) != 768;
        this.n = (i & 512) == 0;
        this.r = (i & 1024) > 0;
        this.s = (i & 2048) > 0;
    }

    public void a() throws e {
        if (this.o) {
            return;
        }
        int length = this.f.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = this.f.charAt(i);
            if (cCharAt >= 0) {
                if (cCharAt <= 31) {
                    throw new e(this.g + i, 0, Character.valueOf(cCharAt));
                }
                if (cCharAt == 127 && this.r) {
                    throw new e(this.g + i, 0, Character.valueOf(cCharAt));
                }
            }
        }
    }

    protected abstract void a(boolean[] zArr);

    protected abstract Object b(boolean[] zArr);

    public void b() throws e {
        int length = this.f.length();
        if (length == 1) {
            return;
        }
        if (length == 2) {
            if (this.f.equals("00")) {
                throw new e(this.g, 6, this.f);
            }
            return;
        }
        char cCharAt = this.f.charAt(0);
        char cCharAt2 = this.f.charAt(1);
        if (cCharAt != '-') {
            if (cCharAt == '0' && cCharAt2 >= '0' && cCharAt2 <= '9') {
                throw new e(this.g, 6, this.f);
            }
            return;
        }
        char cCharAt3 = this.f.charAt(2);
        if (cCharAt2 == '0' && cCharAt3 >= '0' && cCharAt3 <= '9') {
            throw new e(this.g, 6, this.f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (a(java.lang.String.valueOf(r0), r4.f) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Number c() throws sdk.pendo.io.t1.e {
        /*
            r4 = this;
            boolean r0 = r4.h
            if (r0 != 0) goto L7
            r4.b()
        L7:
            boolean r0 = r4.p     // Catch: java.lang.NumberFormatException -> L4a
            if (r0 != 0) goto L16
            java.lang.String r0 = r4.f     // Catch: java.lang.NumberFormatException -> L4a
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L4a
            java.lang.Float r4 = java.lang.Float.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L4a
            return r4
        L16:
            java.lang.String r0 = r4.f     // Catch: java.lang.NumberFormatException -> L4a
            int r0 = r0.length()     // Catch: java.lang.NumberFormatException -> L4a
            r1 = 18
            if (r0 <= r1) goto L43
            boolean r0 = r4.s     // Catch: java.lang.NumberFormatException -> L4a
            if (r0 != 0) goto L3b
            java.lang.String r0 = r4.f     // Catch: java.lang.NumberFormatException -> L4a
            double r0 = java.lang.Double.parseDouble(r0)     // Catch: java.lang.NumberFormatException -> L4a
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L4a
            java.lang.String r3 = r4.f     // Catch: java.lang.NumberFormatException -> L4a
            boolean r2 = r4.a(r2, r3)     // Catch: java.lang.NumberFormatException -> L4a
            if (r2 == 0) goto L3b
        L36:
            java.lang.Double r4 = java.lang.Double.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L4a
            return r4
        L3b:
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch: java.lang.NumberFormatException -> L4a
            java.lang.String r1 = r4.f     // Catch: java.lang.NumberFormatException -> L4a
            r0.<init>(r1)     // Catch: java.lang.NumberFormatException -> L4a
            return r0
        L43:
            java.lang.String r0 = r4.f     // Catch: java.lang.NumberFormatException -> L4a
            double r0 = java.lang.Double.parseDouble(r0)     // Catch: java.lang.NumberFormatException -> L4a
            goto L36
        L4a:
            sdk.pendo.io.t1.e r0 = new sdk.pendo.io.t1.e
            int r1 = r4.g
            java.lang.String r4 = r4.f
            r2 = 1
            r0.<init>(r1, r2, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t1.b.c():java.lang.Number");
    }

    protected <T> T d(k<T> kVar) throws e {
        if (this.a != '{') {
            throw new RuntimeException("Internal Error");
        }
        Object objB = kVar.b();
        boolean z = false;
        while (true) {
            d();
            char c = this.a;
            if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                if (c != ',') {
                    if (c == ':' || c == '[' || c == ']' || c == '{') {
                        throw new e(this.g, 0, Character.valueOf(this.a));
                    }
                    if (c != '}') {
                        if (c == '\"' || c == '\'') {
                            g();
                        } else {
                            a(v);
                            if (!this.j) {
                                throw new e(this.g, 1, this.f);
                            }
                        }
                        String str = this.f;
                        j();
                        char c2 = this.a;
                        if (c2 != ':') {
                            if (c2 == 26) {
                                throw new e(this.g - 1, 3, null);
                            }
                            throw new e(this.g - 1, 0, Character.valueOf(this.a));
                        }
                        e();
                        this.c = str;
                        kVar.a(objB, str, a((k<?>) kVar, w));
                        this.c = null;
                        j();
                        char c3 = this.a;
                        if (c3 != '}') {
                            if (c3 == 26) {
                                throw new e(this.g - 1, 3, null);
                            }
                            if (c3 != ',') {
                                throw new e(this.g - 1, 1, Character.valueOf(this.a));
                            }
                        }
                    } else if (z && !this.l) {
                        throw new e(this.g, 0, Character.valueOf(this.a));
                    }
                    d();
                    return kVar.a(objB);
                }
                if (z && !this.l) {
                    throw new e(this.g, 0, Character.valueOf(this.a));
                }
                z = true;
            }
        }
    }

    protected abstract void d();

    protected abstract void e();

    abstract void f();

    protected abstract void g();

    protected void h() throws e {
        a aVar;
        int i;
        char c = this.a;
        while (true) {
            d();
            char c2 = this.a;
            char cA = '\"';
            if (c2 == '\"' || c2 == '\'') {
                if (c == c2) {
                    d();
                    this.f = this.d.toString();
                    return;
                }
                this.d.a(c2);
            } else if (c2 == '\\') {
                d();
                char c3 = this.a;
                if (c3 != '\"') {
                    if (c3 != '\'') {
                        cA = '/';
                        if (c3 != '/') {
                            if (c3 != '\\') {
                                if (c3 == 'b') {
                                    aVar = this.d;
                                    cA = '\b';
                                } else if (c3 == 'f') {
                                    aVar = this.d;
                                    cA = '\f';
                                } else if (c3 == 'n') {
                                    aVar = this.d;
                                    cA = '\n';
                                } else if (c3 != 'r') {
                                    if (c3 == 'x') {
                                        aVar = this.d;
                                        i = 2;
                                    } else if (c3 == 't') {
                                        aVar = this.d;
                                        cA = '\t';
                                    } else if (c3 == 'u') {
                                        aVar = this.d;
                                        i = 4;
                                    }
                                    cA = a(i);
                                } else {
                                    aVar = this.d;
                                    cA = '\r';
                                }
                                aVar.a(cA);
                            } else {
                                this.d.a('\\');
                            }
                        }
                    } else {
                        this.d.a('\'');
                    }
                }
                aVar = this.d;
                aVar.a(cA);
            } else if (c2 != 127) {
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
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
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                        if (!this.o) {
                            throw new e(this.g, 0, Character.valueOf(this.a));
                        }
                        continue;
                        break;
                    case 26:
                        throw new e(this.g - 1, 3, null);
                }
                this.d.a(c2);
            } else if (this.o) {
                continue;
            } else {
                if (this.r) {
                    throw new e(this.g, 0, Character.valueOf(this.a));
                }
                this.d.a(c2);
            }
        }
    }

    protected void i() {
        while (true) {
            char c = this.a;
            if (c < '0' || c > '9') {
                return;
            } else {
                f();
            }
        }
    }

    protected void j() {
        while (true) {
            char c = this.a;
            if (c > ' ' || c == 26) {
                return;
            } else {
                f();
            }
        }
    }

    private boolean a(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        if (charArray.length > charArray2.length) {
            return false;
        }
        int i = 0;
        for (char c : charArray) {
            if (c < '0' || c > '9') {
                char c2 = charArray2[i];
                if (c2 >= '0' && c2 <= '9') {
                    return false;
                }
                i++;
                if (charArray2[i] == '+') {
                }
            } else if (c != charArray2[i]) {
                return false;
            }
            i++;
        }
        return i == charArray2.length;
    }

    protected <T> T b(k<T> kVar) throws e {
        char c;
        Object objA = kVar.a();
        if (this.a != '[') {
            throw new RuntimeException("Internal Error");
        }
        d();
        if (this.a == ',' && !this.l) {
            throw new e(this.g, 0, Character.valueOf(this.a));
        }
        while (true) {
            boolean z = false;
            while (true) {
                c = this.a;
                if (c != '\t' && c != '\n' && c != '\r') {
                    if (c == 26) {
                        throw new e(this.g - 1, 3, "EOF");
                    }
                    if (c != ' ') {
                        if (c != ',') {
                            break;
                        }
                        if (z && !this.l) {
                            throw new e(this.g, 0, Character.valueOf(this.a));
                        }
                        d();
                        z = true;
                    }
                }
                d();
            }
            if (c != ':') {
                if (c == ']') {
                    if (z && !this.l) {
                        throw new e(this.g, 0, Character.valueOf(this.a));
                    }
                    d();
                    return kVar.a(objA);
                }
                if (c != '}') {
                    kVar.a(objA, a((k<?>) kVar, u));
                }
            }
            throw new e(this.g, 0, Character.valueOf(this.a));
        }
    }

    protected <T> T c(k<T> kVar) throws e {
        while (true) {
            char c = this.a;
            if (c != '\t' && c != '\n') {
                switch (c) {
                    case '\r':
                    case ' ':
                        break;
                    case '\"':
                    case '\'':
                        g();
                        return kVar.a((Object) this.f);
                    case '-':
                        Object objB = b(x);
                        this.e = objB;
                        return kVar.a(objB);
                    case 'N':
                        a(x);
                        if (!this.i) {
                            throw new e(this.g, 1, this.f);
                        }
                        if ("NaN".equals(this.f)) {
                            return kVar.a(Float.valueOf(Float.NaN));
                        }
                        if (this.j) {
                            return kVar.a((Object) this.f);
                        }
                        throw new e(this.g, 1, this.f);
                    case '[':
                        return (T) b(kVar);
                    case ']':
                    case '}':
                        break;
                    case 'f':
                        a(x);
                        if ("false".equals(this.f)) {
                            return kVar.a(Boolean.FALSE);
                        }
                        if (this.j) {
                            return kVar.a((Object) this.f);
                        }
                        throw new e(this.g, 1, this.f);
                    case 'n':
                        a(x);
                        if (AbstractJsonLexerKt.NULL.equals(this.f)) {
                            return null;
                        }
                        if (this.j) {
                            return kVar.a((Object) this.f);
                        }
                        throw new e(this.g, 1, this.f);
                    case 't':
                        a(x);
                        if (TelemetryEventStrings.Value.TRUE.equals(this.f)) {
                            return kVar.a(Boolean.TRUE);
                        }
                        if (this.j) {
                            return kVar.a((Object) this.f);
                        }
                        throw new e(this.g, 1, this.f);
                    case '{':
                        return (T) d(kVar);
                    default:
                        switch (c) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                Object objB2 = b(x);
                                this.e = objB2;
                                return kVar.a(objB2);
                            case ':':
                                break;
                            default:
                                a(x);
                                if (this.j) {
                                    return kVar.a((Object) this.f);
                                }
                                throw new e(this.g, 1, this.f);
                        }
                        break;
                }
            }
            d();
        }
        throw new e(this.g, 0, Character.valueOf(this.a));
    }

    protected <T> T a(k<T> kVar) throws e {
        this.g = -1;
        try {
            d();
            T t2 = (T) c(kVar);
            if (this.m) {
                if (!this.n) {
                    j();
                }
                if (this.a != 26) {
                    throw new e(this.g - 1, 1, Character.valueOf(this.a));
                }
            }
            this.f = null;
            this.e = null;
            return t2;
        } catch (IOException e) {
            throw new e(this.g, e);
        }
    }

    protected void c(boolean[] zArr) {
        while (true) {
            char c = this.a;
            if (c == 26) {
                return;
            }
            if (c >= 0 && c < '~' && zArr[c]) {
                return;
            } else {
                f();
            }
        }
    }

    protected Number a(String str) throws e {
        int i;
        int i2;
        int length = str.length();
        boolean z = false;
        if (str.charAt(0) == '-') {
            if (!this.h && length >= 3 && str.charAt(1) == '0') {
                throw new e(this.g, 6, str);
            }
            i = 20;
            i2 = 1;
        } else {
            if (!this.h && length >= 2 && str.charAt(0) == '0') {
                throw new e(this.g, 6, str);
            }
            i = 19;
            i2 = 0;
        }
        int i3 = i2;
        if (length >= i) {
            if (length > i) {
                return new BigInteger(str, 10);
            }
            length--;
            z = true;
        }
        long jCharAt = 0;
        while (i2 < length) {
            jCharAt = (jCharAt * 10) + ((long) ('0' - str.charAt(i2)));
            i2++;
        }
        if (z) {
            if (jCharAt <= Buffer.OVERFLOW_ZONE) {
                if (jCharAt >= Buffer.OVERFLOW_ZONE) {
                    char cCharAt = str.charAt(i2);
                    if (i3 == 0) {
                    }
                }
                return new BigInteger(str, 10);
            }
            jCharAt = (jCharAt * 10) + ((long) ('0' - str.charAt(i2)));
        }
        if (i3 != 0) {
            return (!this.q || jCharAt < SieveCacheKt.NodeMetaAndPreviousMask) ? Long.valueOf(jCharAt) : Integer.valueOf((int) jCharAt);
        }
        long j = -jCharAt;
        return (!this.q || j > SieveCacheKt.NodeLinkMask) ? Long.valueOf(j) : Integer.valueOf((int) j);
    }

    protected Object a(k<?> kVar, boolean[] zArr) throws e {
        while (true) {
            char c = this.a;
            if (c != '\t' && c != '\n') {
                switch (c) {
                    case '\r':
                    case ' ':
                        break;
                    case '\"':
                    case '\'':
                        g();
                        return this.f;
                    case '-':
                        return b(zArr);
                    case 'N':
                        a(zArr);
                        if (!this.i) {
                            throw new e(this.g, 1, this.f);
                        }
                        if ("NaN".equals(this.f)) {
                            return Float.valueOf(Float.NaN);
                        }
                        if (this.j) {
                            return this.f;
                        }
                        throw new e(this.g, 1, this.f);
                    case '[':
                        return b(kVar.a(this.c));
                    case ']':
                    case '}':
                        break;
                    case 'f':
                        a(zArr);
                        if ("false".equals(this.f)) {
                            return Boolean.FALSE;
                        }
                        if (this.j) {
                            return this.f;
                        }
                        throw new e(this.g, 1, this.f);
                    case 'n':
                        a(zArr);
                        if (AbstractJsonLexerKt.NULL.equals(this.f)) {
                            return null;
                        }
                        if (this.j) {
                            return this.f;
                        }
                        throw new e(this.g, 1, this.f);
                    case 't':
                        a(zArr);
                        if (TelemetryEventStrings.Value.TRUE.equals(this.f)) {
                            return Boolean.TRUE;
                        }
                        if (this.j) {
                            return this.f;
                        }
                        throw new e(this.g, 1, this.f);
                    case '{':
                        return d(kVar.b(this.c));
                    default:
                        switch (c) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                return b(zArr);
                            case ':':
                                break;
                            default:
                                a(zArr);
                                if (this.j) {
                                    return this.f;
                                }
                                throw new e(this.g, 1, this.f);
                        }
                        break;
                }
            }
            d();
        }
        throw new e(this.g, 0, Character.valueOf(this.a));
    }

    protected char a(int i) throws e {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 * 16;
            d();
            char c = this.a;
            if (c <= '9' && c >= '0') {
                i2 = c - '0';
            } else if (c <= 'F' && c >= 'A') {
                i2 = c - '7';
            } else {
                if (c < 'a' || c > 'f') {
                    if (c == 26) {
                        throw new e(this.g, 3, "EOF");
                    }
                    throw new e(this.g, 4, Character.valueOf(this.a));
                }
                i2 = c - 'W';
            }
            i3 = i5 + i2;
        }
        return (char) i3;
    }
}
