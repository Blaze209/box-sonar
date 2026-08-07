package sdk.pendo.io.h0;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class c implements Closeable, Flushable {
    private static final Pattern j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] k = new String[128];
    private static final String[] l;
    private final Writer a;
    private int[] b = new int[32];
    private int c = 0;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;

    static {
        for (int i = 0; i <= 31; i++) {
            k[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.e = ":";
        this.i = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.a = writer;
    }

    private void a() throws IOException {
        int iL = l();
        if (iL == 5) {
            this.a.write(44);
        } else if (iL != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        j();
        b(4);
    }

    private void b() throws IOException {
        int iL = l();
        if (iL == 1) {
            b(2);
            j();
            return;
        }
        if (iL == 2) {
            this.a.append(AbstractJsonLexerKt.COMMA);
            j();
        } else {
            if (iL == 4) {
                this.a.append((CharSequence) this.e);
                b(5);
                return;
            }
            if (iL != 6) {
                if (iL != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        }
    }

    private void j() throws IOException {
        if (this.d == null) {
            return;
        }
        this.a.write(10);
        int i = this.c;
        for (int i2 = 1; i2 < i; i2++) {
            this.a.write(this.d);
        }
    }

    private int l() {
        int i = this.c;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m() throws IOException {
        if (this.h != null) {
            a();
            c(this.h);
            this.h = null;
        }
    }

    public c c() throws IOException {
        m();
        return a(1, AbstractJsonLexerKt.BEGIN_LIST);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i = this.c;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    public c d() throws IOException {
        m();
        return a(3, AbstractJsonLexerKt.BEGIN_OBJ);
    }

    public c e() {
        return a(1, 2, AbstractJsonLexerKt.END_LIST);
    }

    public c f() {
        return a(3, 5, AbstractJsonLexerKt.END_OBJ);
    }

    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.a.flush();
    }

    public final boolean g() {
        return this.i;
    }

    public final boolean h() {
        return this.g;
    }

    public boolean i() {
        return this.f;
    }

    public c k() throws IOException {
        if (this.h != null) {
            if (!this.i) {
                this.h = null;
                return this;
            }
            m();
        }
        b();
        this.a.write(AbstractJsonLexerKt.NULL);
        return this;
    }

    private c a(int i, int i2, char c) throws IOException {
        int iL = l();
        if (iL != i2 && iL != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.h != null) {
            throw new IllegalStateException("Dangling name: " + this.h);
        }
        this.c--;
        if (iL == i2) {
            j();
        }
        this.a.write(c);
        return this;
    }

    private void b(int i) {
        this.b[this.c - 1] = i;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public c d(String str) throws IOException {
        if (str == null) {
            return k();
        }
        m();
        b();
        c(str);
        return this;
    }

    private static boolean a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void c(String str) throws IOException {
        String str2;
        String[] strArr = this.g ? l : k;
        this.a.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.a.write(str, i, i2 - i);
                    }
                    this.a.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.a.write(str, i, i2 - i);
                }
                this.a.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.a.write(str, i, length - i);
        }
        this.a.write(34);
    }

    public final void b(String str) {
        String str2;
        if (str.length() == 0) {
            this.d = null;
            str2 = ":";
        } else {
            this.d = str;
            str2 = ": ";
        }
        this.e = str2;
    }

    public c d(boolean z) throws IOException {
        m();
        b();
        this.a.write(z ? TelemetryEventStrings.Value.TRUE : "false");
        return this;
    }

    public c a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.h != null) {
            throw new IllegalStateException();
        }
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.h = str;
        return this;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    private c a(int i, char c) throws IOException {
        b();
        a(i);
        this.a.write(c);
        return this;
    }

    private void a(int i) {
        int i2 = this.c;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = i;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public c a(long j2) throws IOException {
        m();
        b();
        this.a.write(Long.toString(j2));
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return k();
        }
        m();
        b();
        this.a.write(bool.booleanValue() ? TelemetryEventStrings.Value.TRUE : "false");
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return k();
        }
        m();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!a((Class<? extends Number>) cls) && !j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        b();
        this.a.append((CharSequence) string);
        return this;
    }
}
