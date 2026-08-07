package sdk.pendo.io.x1;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k implements Serializable {
    private boolean c;
    private boolean h;
    private boolean i;
    public static final k u = new a();
    public static final k v = new c();
    public static final k w = new e();
    public static final k x = new f();
    public static final k y = new g();
    public static final k z = new d();
    public static final k A = new b();
    private static final ThreadLocal<WeakHashMap<Object, Object>> B = new ThreadLocal<>();
    private boolean a = true;
    private boolean b = true;
    private boolean d = true;
    private String e = "[";
    private String f = "]";
    private String g = SimpleComparison.EQUAL_TO_OPERATION;
    private String j = ",";
    private String k = "{";
    private String l = ",";
    private boolean m = true;
    private String n = "}";
    private boolean o = true;
    private String p = "<null>";
    private String q = "<size=";
    private String r = SimpleComparison.GREATER_THAN_OPERATION;
    private String s = SimpleComparison.LESS_THAN_OPERATION;
    private String t = SimpleComparison.GREATER_THAN_OPERATION;

    private static final class a extends k {
        a() {
        }
    }

    private static final class b extends k {
        b() {
            b(false);
            d(false);
            d("{");
            c("}");
            b("[");
            a("]");
            f(",");
            e(":");
            g(AbstractJsonLexerKt.NULL);
            k("\"<");
            j(">\"");
            i("\"<size=");
            h(">\"");
        }

        private void d(StringBuffer stringBuffer, String str) {
            stringBuffer.append('\"').append(sdk.pendo.io.w1.f.a(str)).append('\"');
        }

        private boolean l(String str) {
            return str.startsWith(b()) && str.endsWith(a());
        }

        private boolean m(String str) {
            return str.startsWith(d()) && str.endsWith(c());
        }

        @Override // sdk.pendo.io.x1.k
        public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!a(bool)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.a(stringBuffer, str, obj, bool);
        }

        @Override // sdk.pendo.io.x1.k
        protected void b(StringBuffer stringBuffer, String str, Object obj) {
            if (obj == null) {
                c(stringBuffer, str);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Character)) {
                d(stringBuffer, obj.toString());
                return;
            }
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                stringBuffer.append(obj);
                return;
            }
            String string = obj.toString();
            if (m(string) || l(string)) {
                stringBuffer.append(obj);
            } else {
                b(stringBuffer, str, string);
            }
        }

        @Override // sdk.pendo.io.x1.k
        protected void a(StringBuffer stringBuffer, String str, char c) {
            d(stringBuffer, String.valueOf(c));
        }

        @Override // sdk.pendo.io.x1.k
        protected void b(StringBuffer stringBuffer, String str) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.b(stringBuffer, "\"" + sdk.pendo.io.w1.f.a(str) + "\"");
        }

        @Override // sdk.pendo.io.x1.k
        protected void a(StringBuffer stringBuffer, String str, Collection<?> collection) {
            if (collection == null || collection.isEmpty()) {
                stringBuffer.append(collection);
                return;
            }
            stringBuffer.append(b());
            Iterator<?> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                a(stringBuffer, str, i, it.next());
                i++;
            }
            stringBuffer.append(a());
        }

        @Override // sdk.pendo.io.x1.k
        protected void a(StringBuffer stringBuffer, String str, Map<?, ?> map) {
            if (map == null || map.isEmpty()) {
                stringBuffer.append(map);
                return;
            }
            stringBuffer.append(d());
            boolean z = true;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String string = Objects.toString(entry.getKey(), null);
                if (string != null) {
                    if (z) {
                        z = false;
                    } else {
                        a(stringBuffer, string);
                    }
                    b(stringBuffer, string);
                    Object value = entry.getValue();
                    if (value == null) {
                        c(stringBuffer, string);
                    } else {
                        a(stringBuffer, string, value, true);
                    }
                }
            }
            stringBuffer.append(c());
        }
    }

    private static final class c extends k {
        c() {
            d("[");
            f(System.lineSeparator() + "  ");
            a(true);
            c(System.lineSeparator() + "]");
        }
    }

    private static final class d extends k {
        d() {
            b(false);
            d(false);
        }
    }

    private static final class e extends k {
        e() {
            c(false);
        }
    }

    private static final class f extends k {
        f() {
            e(true);
            d(false);
        }
    }

    private static final class g extends k {
        g() {
            b(false);
            d(false);
            c(false);
            d("");
            c("");
        }
    }

    protected k() {
    }

    static Map<Object, Object> f() {
        return B.get();
    }

    public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        b(stringBuffer, str);
        if (obj == null) {
            c(stringBuffer, str);
        } else {
            a(stringBuffer, str, obj, a(bool));
        }
        a(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer) {
        stringBuffer.append(this.e);
    }

    protected void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.j);
    }

    public void d(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            a(stringBuffer, obj);
            c(stringBuffer, obj);
            b(stringBuffer);
            if (this.h) {
                c(stringBuffer);
            }
        }
    }

    protected String e() {
        return this.p;
    }

    protected boolean g() {
        return this.d;
    }

    protected void h(String str) {
        if (str == null) {
            str = "";
        }
        this.r = str;
    }

    protected void i(String str) {
        if (str == null) {
            str = "";
        }
        this.q = str;
    }

    protected void j(String str) {
        if (str == null) {
            str = "";
        }
        this.t = str;
    }

    protected void k(String str) {
        if (str == null) {
            str = "";
        }
        this.s = str;
    }

    protected void a(StringBuffer stringBuffer, Object obj) {
        if (!this.b || obj == null) {
            return;
        }
        b(obj);
        stringBuffer.append(this.c ? a(obj.getClass()) : obj.getClass().getName());
    }

    protected void b(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void c(StringBuffer stringBuffer, Object obj) {
        if (!g() || obj == null) {
            return;
        }
        b(obj);
        stringBuffer.append(CommentBarInputBoxKt.MENTION_SYMBOL);
        stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    protected String d() {
        return this.e;
    }

    protected void e(String str) {
        if (str == null) {
            str = "";
        }
        this.g = str;
    }

    protected void f(String str) {
        if (str == null) {
            str = "";
        }
        this.j = str;
    }

    protected void g(String str) {
        if (str == null) {
            str = "";
        }
        this.p = str;
    }

    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(this.f);
    }

    public void b(StringBuffer stringBuffer, Object obj) {
        if (!this.i) {
            d(stringBuffer);
        }
        a(stringBuffer);
        c(obj);
    }

    protected void c(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.p);
    }

    protected void d(StringBuffer stringBuffer) {
        if (sdk.pendo.io.w1.g.b(stringBuffer, this.j)) {
            stringBuffer.setLength(stringBuffer.length() - this.j.length());
        }
    }

    protected void e(boolean z2) {
        this.c = z2;
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj) {
        sdk.pendo.io.w1.e.a(stringBuffer, obj);
    }

    protected void b(StringBuffer stringBuffer, String str) {
        if (!this.a || str == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(this.g);
    }

    protected void c(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.s);
        stringBuffer.append(a(obj.getClass()));
        stringBuffer.append(this.t);
    }

    protected void d(String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
    }

    protected void a(StringBuffer stringBuffer, String str, byte b2) {
        stringBuffer.append((int) b2);
    }

    protected void b(StringBuffer stringBuffer, String str, byte[] bArr) {
        b(stringBuffer, str, bArr.length);
    }

    protected String c() {
        return this.f;
    }

    protected void d(boolean z2) {
        this.d = z2;
    }

    protected void a(StringBuffer stringBuffer, String str, char c2) {
        stringBuffer.append(c2);
    }

    protected void b(StringBuffer stringBuffer, String str, char[] cArr) {
        b(stringBuffer, str, cArr.length);
    }

    protected void c(String str) {
        if (str == null) {
            str = "";
        }
        this.f = str;
    }

    protected void a(StringBuffer stringBuffer, String str, double d2) {
        stringBuffer.append(d2);
    }

    protected void b(StringBuffer stringBuffer, String str, double[] dArr) {
        b(stringBuffer, str, dArr.length);
    }

    protected void c(boolean z2) {
        this.a = z2;
    }

    static void c(Object obj) {
        Map<Object, Object> mapF;
        if (obj == null || (mapF = f()) == null) {
            return;
        }
        mapF.remove(obj);
        if (mapF.isEmpty()) {
            B.remove();
        }
    }

    protected void a(StringBuffer stringBuffer, String str, float f2) {
        stringBuffer.append(f2);
    }

    protected void b(StringBuffer stringBuffer, String str, float[] fArr) {
        b(stringBuffer, str, fArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    protected void b(StringBuffer stringBuffer, String str, int[] iArr) {
        b(stringBuffer, str, iArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, int i, Object obj) {
        if (i > 0) {
            stringBuffer.append(this.l);
        }
        if (obj == null) {
            c(stringBuffer, str);
        } else {
            a(stringBuffer, str, obj, this.m);
        }
    }

    protected void b(StringBuffer stringBuffer, String str, long[] jArr) {
        b(stringBuffer, str, jArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    protected void b(StringBuffer stringBuffer, String str, Object[] objArr) {
        b(stringBuffer, str, objArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected void b(StringBuffer stringBuffer, String str, short[] sArr) {
        b(stringBuffer, str, sArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    protected void b(StringBuffer stringBuffer, String str, boolean[] zArr) {
        b(stringBuffer, str, zArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append((int) s);
    }

    protected void b(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.q);
        stringBuffer.append(i);
        stringBuffer.append(this.r);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean z2) {
        stringBuffer.append(z2);
    }

    protected String b() {
        return this.k;
    }

    static void b(Object obj) {
        if (obj != null) {
            if (f() == null) {
                B.set(new WeakHashMap<>());
            }
            f().put(obj, null);
        }
    }

    protected void a(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void b(String str) {
        if (str == null) {
            str = "";
        }
        this.k = str;
    }

    protected void a(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void b(boolean z2) {
        this.b = z2;
    }

    protected void a(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < objArr.length; i++) {
            a(stringBuffer, str, i, objArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.k);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.l);
            }
            a(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.n);
    }

    protected void a(StringBuffer stringBuffer, String str) {
        c(stringBuffer);
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj, boolean z2) {
        int size;
        if (a(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            a(stringBuffer, str, obj);
            return;
        }
        b(obj);
        try {
            if (obj instanceof Collection) {
                if (z2) {
                    a(stringBuffer, str, (Collection<?>) obj);
                } else {
                    size = ((Collection) obj).size();
                    b(stringBuffer, str, size);
                }
            } else if (obj instanceof Map) {
                if (z2) {
                    a(stringBuffer, str, (Map<?, ?>) obj);
                } else {
                    size = ((Map) obj).size();
                    b(stringBuffer, str, size);
                }
            } else if (obj instanceof long[]) {
                if (z2) {
                    a(stringBuffer, str, (long[]) obj);
                } else {
                    b(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z2) {
                    a(stringBuffer, str, (int[]) obj);
                } else {
                    b(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z2) {
                    a(stringBuffer, str, (short[]) obj);
                } else {
                    b(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z2) {
                    a(stringBuffer, str, (byte[]) obj);
                } else {
                    b(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z2) {
                    a(stringBuffer, str, (char[]) obj);
                } else {
                    b(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z2) {
                    a(stringBuffer, str, (double[]) obj);
                } else {
                    b(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z2) {
                    a(stringBuffer, str, (float[]) obj);
                } else {
                    b(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z2) {
                    a(stringBuffer, str, (boolean[]) obj);
                } else {
                    b(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z2) {
                    a(stringBuffer, str, (Object[]) obj);
                } else {
                    b(stringBuffer, str, (Object[]) obj);
                }
            } else if (z2) {
                b(stringBuffer, str, obj);
            } else {
                c(stringBuffer, str, obj);
            }
        } finally {
            c(obj);
        }
    }

    protected String a() {
        return this.n;
    }

    protected String a(Class<?> cls) {
        return sdk.pendo.io.w1.d.a(cls);
    }

    protected boolean a(Boolean bool) {
        return bool == null ? this.o : bool.booleanValue();
    }

    static boolean a(Object obj) {
        Map<Object, Object> mapF = f();
        return mapF != null && mapF.containsKey(obj);
    }

    protected void a(String str) {
        if (str == null) {
            str = "";
        }
        this.n = str;
    }

    protected void a(boolean z2) {
        this.h = z2;
    }
}
