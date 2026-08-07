package sdk.pendo.io.u1;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static final sdk.pendo.io.u1.e<sdk.pendo.io.r1.f> c = new j();
    public static final sdk.pendo.io.u1.e<sdk.pendo.io.r1.f> d = new k();
    public static final sdk.pendo.io.u1.e<sdk.pendo.io.r1.c> e = new l();
    public static final sdk.pendo.io.u1.e<sdk.pendo.io.r1.b> f = new m();
    public static final sdk.pendo.io.u1.e<Iterable<? extends Object>> g = new n();
    public static final sdk.pendo.io.u1.e<Enum<?>> h = new o();
    public static final sdk.pendo.io.u1.e<Map<String, ? extends Object>> i = new p();
    public static final sdk.pendo.io.u1.e<Object> j = new sdk.pendo.io.u1.c();
    public static final sdk.pendo.io.u1.e<Object> k = new sdk.pendo.io.u1.b();
    public static final sdk.pendo.io.u1.e<Object> l = new sdk.pendo.io.u1.a();
    public static final sdk.pendo.io.u1.e<Object> m = new q();
    private ConcurrentHashMap<Class<?>, sdk.pendo.io.u1.e<?>> a = new ConcurrentHashMap<>();
    private LinkedList<s> b = new LinkedList<>();

    class a implements sdk.pendo.io.u1.e<Double> {
        a() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(Double d, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            appendable.append(d.isInfinite() ? AbstractJsonLexerKt.NULL : d.toString());
        }
    }

    class b implements sdk.pendo.io.u1.e<Date> {
        b() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(Date date, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            appendable.append('\"');
            sdk.pendo.io.r1.i.a(date.toString(), appendable, gVar);
            appendable.append('\"');
        }
    }

    class c implements sdk.pendo.io.u1.e<Float> {
        c() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(Float f, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            appendable.append(f.isInfinite() ? AbstractJsonLexerKt.NULL : f.toString());
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.u1.d$d, reason: collision with other inner class name */
    class C0495d implements sdk.pendo.io.u1.e<int[]> {
        C0495d() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(int[] iArr, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = false;
            for (int i : iArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Integer.toString(i));
            }
            gVar.d(appendable);
        }
    }

    class e implements sdk.pendo.io.u1.e<short[]> {
        e() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(short[] sArr, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = false;
            for (short s : sArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Short.toString(s));
            }
            gVar.d(appendable);
        }
    }

    class f implements sdk.pendo.io.u1.e<long[]> {
        f() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(long[] jArr, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = false;
            for (long j : jArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Long.toString(j));
            }
            gVar.d(appendable);
        }
    }

    class g implements sdk.pendo.io.u1.e<float[]> {
        g() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(float[] fArr, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = false;
            for (float f : fArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Float.toString(f));
            }
            gVar.d(appendable);
        }
    }

    class h implements sdk.pendo.io.u1.e<double[]> {
        h() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(double[] dArr, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = false;
            for (double d : dArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Double.toString(d));
            }
            gVar.d(appendable);
        }
    }

    class i implements sdk.pendo.io.u1.e<boolean[]> {
        i() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(boolean[] zArr, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = false;
            for (boolean z2 : zArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Boolean.toString(z2));
            }
            gVar.d(appendable);
        }
    }

    class j implements sdk.pendo.io.u1.e<sdk.pendo.io.r1.f> {
        j() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends sdk.pendo.io.r1.f> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) {
            e.a(appendable);
        }
    }

    class k implements sdk.pendo.io.u1.e<sdk.pendo.io.r1.f> {
        k() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends sdk.pendo.io.r1.f> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) {
            e.a(appendable, gVar);
        }
    }

    class l implements sdk.pendo.io.u1.e<sdk.pendo.io.r1.c> {
        l() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends sdk.pendo.io.r1.c> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            appendable.append(e.a(gVar));
        }
    }

    class m implements sdk.pendo.io.u1.e<sdk.pendo.io.r1.b> {
        m() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends sdk.pendo.io.r1.b> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            appendable.append(e.a());
        }
    }

    class n implements sdk.pendo.io.u1.e<Iterable<? extends Object>> {
        n() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends Iterable<? extends Object>> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.c(appendable);
            boolean z = true;
            for (Object obj : e) {
                if (z) {
                    gVar.e(appendable);
                    z = false;
                } else {
                    gVar.a(appendable);
                }
                if (obj == null) {
                    appendable.append(AbstractJsonLexerKt.NULL);
                } else {
                    sdk.pendo.io.r1.i.a(obj, appendable, gVar);
                }
                gVar.b(appendable);
            }
            gVar.d(appendable);
        }
    }

    class o implements sdk.pendo.io.u1.e<Enum<?>> {
        o() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends Enum<?>> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.a(appendable, e.name());
        }
    }

    class p implements sdk.pendo.io.u1.e<Map<String, ? extends Object>> {
        p() {
        }

        @Override // sdk.pendo.io.u1.e
        public <E extends Map<String, ? extends Object>> void a(E e, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.j(appendable);
            boolean z = true;
            for (Map.Entry entry : e.entrySet()) {
                Object value = entry.getValue();
                if (value != null || !gVar.a()) {
                    if (z) {
                        gVar.h(appendable);
                        z = false;
                    } else {
                        gVar.i(appendable);
                    }
                    d.a(entry.getKey().toString(), value, appendable, gVar);
                }
            }
            gVar.k(appendable);
        }
    }

    class q implements sdk.pendo.io.u1.e<Object> {
        q() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(Object obj, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            appendable.append(obj.toString());
        }
    }

    class r implements sdk.pendo.io.u1.e<String> {
        r() {
        }

        @Override // sdk.pendo.io.u1.e
        public void a(String str, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
            gVar.a(appendable, str);
        }
    }

    static class s {
        public Class<?> a;
        public sdk.pendo.io.u1.e<?> b;

        public s(Class<?> cls, sdk.pendo.io.u1.e<?> eVar) {
            this.a = cls;
            this.b = eVar;
        }
    }

    public d() {
        a();
    }

    public sdk.pendo.io.u1.e a(Class cls) {
        return this.a.get(cls);
    }

    public sdk.pendo.io.u1.e b(Class<?> cls) {
        for (s sVar : this.b) {
            if (sVar.a.isAssignableFrom(cls)) {
                return sVar.b;
            }
        }
        return null;
    }

    public void a() {
        a(new r(), String.class);
        a(new a(), Double.class);
        a(new b(), Date.class);
        a(new c(), Float.class);
        sdk.pendo.io.u1.e<?> eVar = m;
        a(eVar, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        a(eVar, Boolean.class);
        a(new C0495d(), int[].class);
        a(new e(), short[].class);
        a(new f(), long[].class);
        a(new g(), float[].class);
        a(new h(), double[].class);
        a(new i(), boolean[].class);
        a(sdk.pendo.io.r1.f.class, d);
        a(sdk.pendo.io.r1.e.class, c);
        a(sdk.pendo.io.r1.c.class, e);
        a(sdk.pendo.io.r1.b.class, f);
        a(Map.class, i);
        a(Iterable.class, g);
        a(Enum.class, h);
        a(Number.class, eVar);
    }

    public void b(Class<?> cls, sdk.pendo.io.u1.e<?> eVar) {
        this.b.addLast(new s(cls, eVar));
    }

    public <T> void a(sdk.pendo.io.u1.e<T> eVar, Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.a.put(cls, eVar);
        }
    }

    public void a(Class<?> cls, sdk.pendo.io.u1.e<?> eVar) {
        b(cls, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    /* JADX WARN: Code duplicated, block: B:12:0x0027  */
    public static void a(String str, Object obj, Appendable appendable, sdk.pendo.io.r1.g gVar) throws IOException {
        if (str != null) {
            if (gVar.a(str)) {
                appendable.append('\"');
                sdk.pendo.io.r1.i.a(str, appendable, gVar);
                appendable.append('\"');
            }
            gVar.g(appendable);
            if (obj instanceof String) {
                gVar.a(appendable, (String) obj);
            } else {
                sdk.pendo.io.r1.i.a(obj, appendable, gVar);
            }
            gVar.f(appendable);
        }
        str = AbstractJsonLexerKt.NULL;
        appendable.append(str);
        gVar.g(appendable);
        if (obj instanceof String) {
            gVar.a(appendable, (String) obj);
        } else {
            sdk.pendo.io.r1.i.a(obj, appendable, gVar);
        }
        gVar.f(appendable);
    }
}
