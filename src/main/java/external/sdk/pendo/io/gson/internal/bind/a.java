package external.sdk.pendo.io.gson.internal.bind;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.data.api.models.MetadataReservedKeys;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.k;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.a0.n;
import sdk.pendo.io.h0.b;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends sdk.pendo.io.h0.a {
    private static final Reader t = new C0322a();
    private static final Object u = new Object();
    private Object[] p;
    private int q;
    private String[] r;
    private int[] s;

    /* JADX INFO: renamed from: external.sdk.pendo.io.gson.internal.bind.a$a, reason: collision with other inner class name */
    class C0322a extends Reader {
        C0322a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public a(i iVar) {
        super(t);
        this.p = new Object[32];
        this.q = 0;
        this.r = new String[32];
        this.s = new int[32];
        a(iVar);
    }

    private Object B() {
        return this.p[this.q - 1];
    }

    private Object C() {
        Object[] objArr = this.p;
        int i = this.q - 1;
        this.q = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private String k() {
        return " at path " + getPath();
    }

    i A() {
        b bVarT = t();
        if (bVarT == b.NAME || bVarT == b.END_ARRAY || bVarT == b.END_OBJECT || bVarT == b.END_DOCUMENT) {
            throw new IllegalStateException("Unexpected " + bVarT + " when reading a JsonElement.");
        }
        i iVar = (i) B();
        z();
        return iVar;
    }

    public void D() {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) B()).next();
        a(entry.getValue());
        a(new n((String) entry.getKey()));
    }

    @Override // sdk.pendo.io.h0.a
    public void a() {
        a(b.BEGIN_ARRAY);
        a(((f) B()).iterator());
        this.s[this.q - 1] = 0;
    }

    @Override // sdk.pendo.io.h0.a
    public void b() {
        a(b.BEGIN_OBJECT);
        a(((l) B()).l().iterator());
    }

    @Override // sdk.pendo.io.h0.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.p = new Object[]{u};
        this.q = 1;
    }

    @Override // sdk.pendo.io.h0.a
    public void f() {
        a(b.END_ARRAY);
        C();
        C();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // sdk.pendo.io.h0.a
    public void g() {
        a(b.END_OBJECT);
        C();
        C();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // sdk.pendo.io.h0.a
    public String getPath() {
        return a(false);
    }

    @Override // sdk.pendo.io.h0.a
    public String h() {
        return a(true);
    }

    @Override // sdk.pendo.io.h0.a
    public boolean i() {
        b bVarT = t();
        return (bVarT == b.END_OBJECT || bVarT == b.END_ARRAY || bVarT == b.END_DOCUMENT) ? false : true;
    }

    @Override // sdk.pendo.io.h0.a
    public boolean l() {
        a(b.BOOLEAN);
        boolean zA = ((n) C()).a();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zA;
    }

    @Override // sdk.pendo.io.h0.a
    public double m() {
        b bVarT = t();
        b bVar = b.NUMBER;
        if (bVarT != bVar && bVarT != b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarT + k());
        }
        double dL = ((n) B()).l();
        if (!j() && (Double.isNaN(dL) || Double.isInfinite(dL))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dL);
        }
        C();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dL;
    }

    @Override // sdk.pendo.io.h0.a
    public int n() {
        b bVarT = t();
        b bVar = b.NUMBER;
        if (bVarT != bVar && bVarT != b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarT + k());
        }
        int iC = ((n) B()).c();
        C();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iC;
    }

    @Override // sdk.pendo.io.h0.a
    public long o() {
        b bVarT = t();
        b bVar = b.NUMBER;
        if (bVarT != bVar && bVarT != b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarT + k());
        }
        long jM = ((n) B()).m();
        C();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jM;
    }

    @Override // sdk.pendo.io.h0.a
    public String p() {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) B()).next();
        String str = (String) entry.getKey();
        this.r[this.q - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // sdk.pendo.io.h0.a
    public void q() {
        a(b.NULL);
        C();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // sdk.pendo.io.h0.a
    public String r() {
        b bVarT = t();
        b bVar = b.STRING;
        if (bVarT != bVar && bVarT != b.NUMBER) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarT + k());
        }
        String strG = ((n) C()).g();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return strG;
    }

    @Override // sdk.pendo.io.h0.a
    public b t() {
        if (this.q == 0) {
            return b.END_DOCUMENT;
        }
        Object objB = B();
        if (objB instanceof Iterator) {
            boolean z = this.p[this.q - 2] instanceof l;
            Iterator it = (Iterator) objB;
            if (!it.hasNext()) {
                return z ? b.END_OBJECT : b.END_ARRAY;
            }
            if (z) {
                return b.NAME;
            }
            a(it.next());
            return t();
        }
        if (objB instanceof l) {
            return b.BEGIN_OBJECT;
        }
        if (objB instanceof f) {
            return b.BEGIN_ARRAY;
        }
        if (!(objB instanceof n)) {
            if (objB instanceof k) {
                return b.NULL;
            }
            if (objB == u) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        n nVar = (n) objB;
        if (nVar.q()) {
            return b.STRING;
        }
        if (nVar.o()) {
            return b.BOOLEAN;
        }
        if (nVar.p()) {
            return b.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // sdk.pendo.io.h0.a
    public String toString() {
        return CmcdData.OBJECT_TYPE_AUDIO_ONLY + k();
    }

    @Override // sdk.pendo.io.h0.a
    public void z() {
        if (t() == b.NAME) {
            p();
            this.r[this.q - 2] = AbstractJsonLexerKt.NULL;
        } else {
            C();
            int i = this.q;
            if (i > 0) {
                this.r[i - 1] = AbstractJsonLexerKt.NULL;
            }
        }
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    private void a(b bVar) {
        if (t() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + t() + k());
        }
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder(MetadataReservedKeys.PREFIX);
        int i = 0;
        while (true) {
            int i2 = this.q;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.p;
            Object obj = objArr[i];
            if (obj instanceof f) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    int i3 = this.s[i];
                    if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                        i3--;
                    }
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(i3).append(AbstractJsonLexerKt.END_LIST);
                }
            } else if ((obj instanceof l) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.r[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private void a(Object obj) {
        int i = this.q;
        Object[] objArr = this.p;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.p = Arrays.copyOf(objArr, i2);
            this.s = Arrays.copyOf(this.s, i2);
            this.r = (String[]) Arrays.copyOf(this.r, i2);
        }
        Object[] objArr2 = this.p;
        int i3 = this.q;
        this.q = i3 + 1;
        objArr2[i3] = obj;
    }
}
