package sdk.pendo.io.h0;

import com.box.android.data.api.models.MetadataReservedKeys;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.internal.Buffer;
import sdk.pendo.io.c0.e;

/* JADX INFO: loaded from: classes4.dex */
public class a implements Closeable {
    private final Reader a;
    private long i;
    private int j;
    private String k;
    private int[] l;
    private String[] n;
    private int[] o;
    private boolean b = false;
    private final char[] c = new char[1024];
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    int h = 0;
    private int m = 1;

    /* JADX INFO: renamed from: sdk.pendo.io.h0.a$a, reason: collision with other inner class name */
    class C0391a extends e {
        C0391a() {
        }

        @Override // sdk.pendo.io.c0.e
        public void a(a aVar) throws IOException {
            if (aVar instanceof external.sdk.pendo.io.gson.internal.bind.a) {
                ((external.sdk.pendo.io.gson.internal.bind.a) aVar).D();
                return;
            }
            int iE = aVar.h;
            if (iE == 0) {
                iE = aVar.e();
            }
            if (iE == 13) {
                aVar.h = 9;
            } else if (iE == 12) {
                aVar.h = 8;
            } else {
                if (iE != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.t() + aVar.k());
                }
                aVar.h = 10;
            }
        }
    }

    static {
        e.a = new C0391a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.a = reader;
    }

    private void c() throws IOException {
        if (!this.b) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        b(true);
        int i = this.d;
        this.d = i - 1;
        if (i + 4 <= this.e || a(5)) {
            int i2 = this.d;
            char[] cArr = this.c;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.d = i2 + 5;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    private String s() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = this.d + i2;
                if (i3 < this.e) {
                    char c = this.c[i3];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    i = i2;
                } else if (i2 >= this.c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.c, this.d, i2);
                    this.d += i2;
                    if (!a(1)) {
                    }
                } else if (!a(i2 + 1)) {
                    i = i2;
                }
                String str = sb == null ? new String(this.c, this.d, i) : sb.append(this.c, this.d, i).toString();
                this.d += i;
                return str;
            }
        }
    }

    private int u() {
        String str;
        String str2;
        int i;
        char c = this.c[this.d];
        if (c == 't' || c == 'T') {
            str = TelemetryEventStrings.Value.TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = AbstractJsonLexerKt.NULL;
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.d + i2 >= this.e && !a(i2 + 1)) {
                return 0;
            }
            char c2 = this.c[this.d + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.d + length < this.e || a(length + 1)) && a(this.c[this.d + length])) {
            return 0;
        }
        this.d += length;
        this.h = i;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:84:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:90:0x00dd  */
    private int v() {
        char c;
        int i;
        int i2;
        char[] cArr = this.c;
        int i3 = this.d;
        int i4 = this.e;
        int i5 = 0;
        int i6 = 0;
        char c2 = 0;
        boolean z = false;
        int i7 = 1;
        long j = 0;
        while (true) {
            char c3 = 2;
            if (i3 + i6 != i4) {
                c = cArr[i3 + i6];
                i = i5;
                if (c != '+') {
                    if (c != 'E' || c == 'e') {
                        if (c2 == 2 && c2 != 4) {
                            return i;
                        }
                        c2 = 5;
                    } else if (c == '-') {
                        c3 = 6;
                        if (c2 == 0) {
                            c2 = 1;
                            z = true;
                        } else if (c2 != 5) {
                            return i;
                        }
                    } else if (c != '.') {
                        if (c < '0' || c > '9') {
                            if (!a(c)) {
                                break;
                            }
                            return i;
                        }
                        if (c2 == 1 || c2 == 0) {
                            j = -(c - '0');
                        } else if (c2 == 2) {
                            if (j == 0) {
                                return i;
                            }
                            long j2 = (10 * j) - ((long) (c - '0'));
                            i7 &= (j > Buffer.OVERFLOW_ZONE || (j == Buffer.OVERFLOW_ZONE && j2 < j)) ? 1 : i;
                            j = j2;
                        } else if (c2 == 3) {
                            c2 = 4;
                        } else if (c2 == 5 || c2 == 6) {
                            c2 = 7;
                        }
                    } else {
                        if (c2 != 2) {
                            return i;
                        }
                        c2 = 3;
                    }
                    i6++;
                    i5 = i;
                } else {
                    c3 = 6;
                    if (c2 != 5) {
                        return i;
                    }
                }
                c2 = c3;
                i6++;
                i5 = i;
            } else {
                if (i6 == cArr.length) {
                    return i5;
                }
                if (!a(i6 + 1)) {
                    i = i5;
                    break;
                }
                i3 = this.d;
                i4 = this.e;
                c = cArr[i3 + i6];
                i = i5;
                if (c != '+') {
                    if (c != 'E') {
                        if (c2 == 2) {
                        }
                        c2 = 5;
                    } else {
                        if (c2 == 2) {
                        }
                        c2 = 5;
                    }
                    i6++;
                    i5 = i;
                } else {
                    c3 = 6;
                    if (c2 != 5) {
                        return i;
                    }
                }
                c2 = c3;
                i6++;
                i5 = i;
            }
        }
        if (c2 == 2 && i7 != 0 && ((j != Long.MIN_VALUE || z) && (j != 0 || !z))) {
            if (!z) {
                j = -j;
            }
            this.i = j;
            this.d += i6;
            i2 = 15;
        } else {
            if (c2 != 2 && c2 != 4 && c2 != 7) {
                return i;
            }
            this.j = i6;
            i2 = 16;
        }
        this.h = i2;
        return i2;
    }

    private char w() throws IOException {
        int i;
        if (this.d == this.e && !a(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.c;
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.f++;
            this.g = i3;
            return c;
        }
        if (c == '\"' || c == '\'' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return '\r';
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            throw b("Invalid escape sequence");
        }
        if (i2 + 5 > this.e && !a(4)) {
            throw b("Unterminated escape sequence");
        }
        int i4 = this.d;
        int i5 = i4 + 4;
        char c2 = 0;
        while (i4 < i5) {
            char c3 = this.c[i4];
            char c4 = (char) (c2 << 4);
            if (c3 >= '0' && c3 <= '9') {
                i = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(this.c, this.d, 4)));
                }
                i = c3 - '7';
            }
            c2 = (char) (c4 + i);
            i4++;
        }
        this.d += 4;
        return c2;
    }

    private void x() {
        char c;
        do {
            if (this.d >= this.e && !a(1)) {
                return;
            }
            char[] cArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            c = cArr[i];
            if (c == '\n') {
                this.f++;
                this.g = i2;
                return;
            }
        } while (c != '\r');
    }

    private void y() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.d + i;
                if (i2 < this.e) {
                    char c = this.c[i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    this.d += i;
                    return;
                }
                this.d = i2;
            }
        } while (a(1));
    }

    public void a() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 3) {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + t() + k());
        }
        b(1);
        this.o[this.m - 1] = 0;
        this.h = 0;
    }

    public void b() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 1) {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + t() + k());
        }
        b(3);
        this.h = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.a.close();
    }

    int e() throws IOException {
        int i;
        int iB;
        int[] iArr = this.l;
        int i2 = this.m - 1;
        int i3 = iArr[i2];
        if (i3 == 1) {
            iArr[i2] = 2;
        } else {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 5) {
                    iArr[i2] = 4;
                    if (i3 == 5 && (iB = b(true)) != 44) {
                        if (iB != 59) {
                            if (iB != 125) {
                                throw b("Unterminated object");
                            }
                            this.h = 2;
                            return 2;
                        }
                        c();
                    }
                    int iB2 = b(true);
                    if (iB2 == 34) {
                        i = 13;
                    } else if (iB2 == 39) {
                        c();
                        i = 12;
                    } else {
                        if (iB2 == 125) {
                            if (i3 == 5) {
                                throw b("Expected name");
                            }
                            this.h = 2;
                            return 2;
                        }
                        c();
                        this.d--;
                        if (!a((char) iB2)) {
                            throw b("Expected name");
                        }
                        i = 14;
                    }
                } else if (i3 == 4) {
                    iArr[i2] = 5;
                    int iB3 = b(true);
                    if (iB3 != 58) {
                        if (iB3 != 61) {
                            throw b("Expected ':'");
                        }
                        c();
                        if (this.d < this.e || a(1)) {
                            char[] cArr = this.c;
                            int i4 = this.d;
                            if (cArr[i4] == '>') {
                                this.d = i4 + 1;
                            }
                        }
                    }
                } else if (i3 == 6) {
                    if (this.b) {
                        d();
                    }
                    this.l[this.m - 1] = 7;
                } else if (i3 == 7) {
                    if (b(false) == -1) {
                        i = 17;
                    } else {
                        c();
                        this.d--;
                    }
                } else if (i3 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.h = i;
                return i;
            }
            int iB4 = b(true);
            if (iB4 != 44) {
                if (iB4 != 59) {
                    if (iB4 != 93) {
                        throw b("Unterminated array");
                    }
                    this.h = 4;
                    return 4;
                }
                c();
            }
        }
        int iB5 = b(true);
        if (iB5 != 34) {
            if (iB5 == 39) {
                c();
                this.h = 8;
                return 8;
            }
            if (iB5 != 44 && iB5 != 59) {
                if (iB5 == 91) {
                    this.h = 3;
                    return 3;
                }
                if (iB5 != 93) {
                    if (iB5 == 123) {
                        this.h = 1;
                        return 1;
                    }
                    this.d--;
                    int iU = u();
                    if (iU != 0) {
                        return iU;
                    }
                    int iV = v();
                    if (iV != 0) {
                        return iV;
                    }
                    if (!a(this.c[this.d])) {
                        throw b("Expected value");
                    }
                    c();
                    i = 10;
                } else if (i3 == 1) {
                    this.h = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw b("Unexpected value");
            }
            c();
            this.d--;
            this.h = 7;
            return 7;
        }
        i = 9;
        this.h = i;
        return i;
    }

    public void f() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + t() + k());
        }
        int i = this.m;
        this.m = i - 1;
        int[] iArr = this.o;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.h = 0;
    }

    public void g() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + t() + k());
        }
        int i = this.m;
        int i2 = i - 1;
        this.m = i2;
        this.n[i2] = null;
        int[] iArr = this.o;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.h = 0;
    }

    public String getPath() {
        return a(false);
    }

    public String h() {
        return a(true);
    }

    public boolean i() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4 || iE == 17) ? false : true;
    }

    public final boolean j() {
        return this.b;
    }

    String k() {
        return " at line " + (this.f + 1) + " column " + ((this.d - this.g) + 1) + " path " + getPath();
    }

    public boolean l() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iE != 6) {
            throw new IllegalStateException("Expected a boolean but was " + t() + k());
        }
        this.h = 0;
        int[] iArr2 = this.o;
        int i2 = this.m - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public double m() throws IOException {
        String strB;
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iE == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iE == 8 || iE == 9) {
                strB = b(iE == 8 ? '\'' : '\"');
            } else if (iE == 10) {
                strB = s();
            } else if (iE != 11) {
                throw new IllegalStateException("Expected a double but was " + t() + k());
            }
            this.k = strB;
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        if (!this.b && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new d("JSON forbids NaN and infinities: " + d + k());
        }
        this.k = null;
        this.h = 0;
        int[] iArr2 = this.o;
        int i2 = this.m - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public int n() throws IOException {
        String strB;
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j = this.i;
            int i = (int) j;
            if (j != i) {
                throw new NumberFormatException("Expected an int but was " + this.i + k());
            }
            this.h = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iE == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected an int but was " + t() + k());
            }
            if (iE == 10) {
                strB = s();
            } else {
                strB = b(iE == 8 ? '\'' : '\"');
            }
            this.k = strB;
            try {
                int i3 = Integer.parseInt(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.k + k());
        }
        this.k = null;
        this.h = 0;
        int[] iArr3 = this.o;
        int i6 = this.m - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long o() throws IOException {
        String strB;
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iE == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected a long but was " + t() + k());
            }
            if (iE == 10) {
                strB = s();
            } else {
                strB = b(iE == 8 ? '\'' : '\"');
            }
            this.k = strB;
            try {
                long j = Long.parseLong(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i2 = this.m - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.k + k());
        }
        this.k = null;
        this.h = 0;
        int[] iArr3 = this.o;
        int i3 = this.m - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    public String p() throws IOException {
        char c;
        String strB;
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strB = s();
        } else {
            if (iE == 12) {
                c = '\'';
            } else {
                if (iE != 13) {
                    throw new IllegalStateException("Expected a name but was " + t() + k());
                }
                c = '\"';
            }
            strB = b(c);
        }
        this.h = 0;
        this.n[this.m - 1] = strB;
        return strB;
    }

    public void q() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 7) {
            throw new IllegalStateException("Expected null but was " + t() + k());
        }
        this.h = 0;
        int[] iArr = this.o;
        int i = this.m - 1;
        iArr[i] = iArr[i] + 1;
    }

    public String r() throws IOException {
        String str;
        char c;
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = s();
        } else {
            if (iE == 8) {
                c = '\'';
            } else if (iE == 9) {
                c = '\"';
            } else if (iE == 11) {
                str = this.k;
                this.k = null;
            } else if (iE == 15) {
                str = Long.toString(this.i);
            } else {
                if (iE != 16) {
                    throw new IllegalStateException("Expected a string but was " + t() + k());
                }
                str = new String(this.c, this.d, this.j);
                this.d += this.j;
            }
            str = b(c);
        }
        this.h = 0;
        int[] iArr = this.o;
        int i = this.m - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public b t() throws IOException {
        int iE = this.h;
        if (iE == 0) {
            iE = e();
        }
        switch (iE) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + k();
    }

    public void z() throws IOException {
        char c;
        int i = 0;
        do {
            int iE = this.h;
            if (iE == 0) {
                iE = e();
            }
            if (iE == 3) {
                b(1);
            } else {
                if (iE == 1) {
                    b(3);
                } else if (iE == 4 || iE == 2) {
                    this.m--;
                    i--;
                } else if (iE == 14 || iE == 10) {
                    y();
                } else {
                    if (iE == 8 || iE == 12) {
                        c = '\'';
                    } else if (iE == 9 || iE == 13) {
                        c = '\"';
                    } else if (iE == 16) {
                        this.d += this.j;
                    }
                    c(c);
                }
                this.h = 0;
            }
            i++;
            this.h = 0;
        } while (i != 0);
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        this.n[i2] = AbstractJsonLexerKt.NULL;
    }

    private boolean a(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.c;
        int i4 = this.g;
        int i5 = this.d;
        this.g = i4 - i5;
        int i6 = this.e;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.e = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.e = 0;
        }
        this.d = 0;
        do {
            Reader reader = this.a;
            int i8 = this.e;
            int i9 = reader.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.e + i9;
            this.e = i2;
            if (this.f == 0 && (i3 = this.g) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.d++;
                this.g = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[LOOP:1: B:4:0x0004->B:39:0x0085, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0071 A[SYNTHETIC] */
    private int b(boolean z) throws IOException {
        int i;
        char c;
        int i2;
        char c2;
        char[] cArr = this.c;
        while (true) {
            int i3 = this.d;
            while (true) {
                int i4 = this.e;
                while (true) {
                    if (i3 == i4) {
                        this.d = i3;
                        if (!a(1)) {
                            if (z) {
                                throw new EOFException("End of input" + k());
                            }
                            return -1;
                        }
                        i3 = this.d;
                        i4 = this.e;
                    }
                    i = i3 + 1;
                    c = cArr[i3];
                    if (c == '\n') {
                        this.f++;
                        this.g = i;
                    } else if (c == ' ' || c == '\r' || c == '\t') {
                    }
                    i3 = i;
                }
                if (c != '/') {
                    this.d = i;
                    if (c != '#') {
                        return c;
                    }
                    c();
                    break;
                }
                this.d = i;
                if (i == i4) {
                    this.d = i3;
                    boolean zA = a(2);
                    this.d++;
                    if (zA) {
                        c();
                        i2 = this.d;
                        c2 = cArr[i2];
                        if (c2 != '*') {
                            this.d = i2 + 1;
                            if (a("*/")) {
                                throw b("Unterminated comment");
                            }
                            i3 = this.d + 2;
                        } else if (c2 != '/') {
                            this.d = i2 + 1;
                            break;
                        }
                    }
                } else {
                    c();
                    i2 = this.d;
                    c2 = cArr[i2];
                    if (c2 != '*') {
                        this.d = i2 + 1;
                        if (a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i3 = this.d + 2;
                    } else if (c2 != '/') {
                        this.d = i2 + 1;
                        break;
                        break;
                    }
                }
                return c;
            }
            x();
        }
    }

    public final void c(boolean z) {
        this.b = z;
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder(MetadataReservedKeys.PREFIX);
        int i = 0;
        while (true) {
            int i2 = this.m;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.l[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.o[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(i4).append(AbstractJsonLexerKt.END_LIST);
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.n[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private String b(char c) throws IOException {
        char[] cArr = this.c;
        StringBuilder sb = null;
        do {
            int i = this.d;
            int i2 = this.e;
            int i3 = i;
            while (i < i2) {
                int i4 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.d = i4;
                    int i5 = (i4 - i3) - 1;
                    if (sb == null) {
                        return new String(cArr, i3, i5);
                    }
                    sb.append(cArr, i3, i5);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.d = i4;
                    int i6 = i4 - i3;
                    int i7 = i6 - 1;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i6 * 2, 16));
                    }
                    sb.append(cArr, i3, i7);
                    sb.append(w());
                    i3 = this.d;
                    i2 = this.e;
                    i = i3;
                } else {
                    if (c2 == '\n') {
                        this.f++;
                        this.g = i4;
                    }
                    i = i4;
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i - i3) * 2, 16));
            }
            sb.append(cArr, i3, i - i3);
            this.d = i;
        } while (a(1));
        throw b("Unterminated string");
    }

    private void c(char c) throws IOException {
        char[] cArr = this.c;
        while (true) {
            int i = this.d;
            int i2 = this.e;
            while (true) {
                if (i >= i2) {
                    this.d = i;
                    if (!a(1)) {
                        throw b("Unterminated string");
                    }
                    break;
                }
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.d = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.d = i3;
                    w();
                    break;
                } else {
                    if (c2 == '\n') {
                        this.f++;
                        this.g = i3;
                    }
                    i = i3;
                }
            }
        }
    }

    private boolean a(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private void b(int i) {
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    private boolean a(String str) {
        int length = str.length();
        while (true) {
            if (this.d + length > this.e && !a(length)) {
                return false;
            }
            char[] cArr = this.c;
            int i = this.d;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.c[this.d + i2] == str.charAt(i2)) {
                    }
                }
                return true;
            }
            this.f++;
            this.g = i + 1;
            this.d++;
        }
    }

    private IOException b(String str) throws d {
        throw new d(str + k());
    }
}
