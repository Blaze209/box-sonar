package sdk.pendo.io.v0;

import java.text.DateFormat;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    private long a;

    private d(long j) {
        c(j);
    }

    private boolean a() {
        long jB = b();
        long j = 1000 * jB;
        if (jB > 0 && j < jB) {
            return false;
        }
        if (jB >= 0 || j <= jB) {
            return jB != 0 || j == 0;
        }
        return false;
    }

    public static d b(long j) {
        return new d(j);
    }

    public static d d() {
        return a(System.currentTimeMillis());
    }

    public long c() {
        long jB = b();
        long j = 1000 * jB;
        if (a()) {
            return j;
        }
        throw new ArithmeticException("converting " + jB + " seconds to milliseconds (x1000) resulted in long integer overflow (" + j + ")");
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof d) && this.a == ((d) obj).a;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NumericDate{");
        sb.append(b());
        if (a()) {
            sb.append(" -> ").append(DateFormat.getDateTimeInstance(2, 1).format(new Date(c())));
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public static d a(long j) {
        return b(j / 1000);
    }

    public long b() {
        return this.a;
    }

    public void c(long j) {
        this.a = j;
    }

    public boolean a(d dVar) {
        return this.a < dVar.b();
    }
}
