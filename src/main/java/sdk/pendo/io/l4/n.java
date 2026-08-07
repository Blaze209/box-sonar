package sdk.pendo.io.l4;

import cz.msebera.android.httpclient.entity.mime.MIME;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.y;

/* JADX INFO: loaded from: classes4.dex */
abstract class n<T> {

    class a extends n<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable Iterable<T> iterable) {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                n.this.a(pVar, it.next());
            }
        }
    }

    class b extends n<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                n.this.a(pVar, Array.get(obj, i));
            }
        }
    }

    static final class c<T> extends n<T> {
        private final Method a;
        private final int b;
        private final sdk.pendo.io.l4.f<T, c0> c;

        c(Method method, int i, sdk.pendo.io.l4.f<T, c0> fVar) {
            this.a = method;
            this.b = i;
            this.c = fVar;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            if (t == null) {
                throw w.a(this.a, this.b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                pVar.a(this.c.convert(t));
            } catch (IOException e) {
                throw w.a(this.a, e, this.b, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    static final class d<T> extends n<T> {
        private final String a;
        private final sdk.pendo.io.l4.f<T, String> b;
        private final boolean c;

        d(String str, sdk.pendo.io.l4.f<T, String> fVar, boolean z) {
            this.a = (String) Objects.requireNonNull(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            String strConvert;
            if (t == null || (strConvert = this.b.convert(t)) == null) {
                return;
            }
            pVar.a(this.a, strConvert, this.c);
        }
    }

    static final class e<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;
        private final sdk.pendo.io.l4.f<T, String> c;
        private final boolean d;

        e(Method method, int i, sdk.pendo.io.l4.f<T, String> fVar, boolean z) {
            this.a = method;
            this.b = i;
            this.c = fVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.a, this.b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.a, this.b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.a, this.b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.c.convert(value);
                if (strConvert == null) {
                    throw w.a(this.a, this.b, "Field map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                pVar.a(key, strConvert, this.d);
            }
        }
    }

    static final class f<T> extends n<T> {
        private final String a;
        private final sdk.pendo.io.l4.f<T, String> b;

        f(String str, sdk.pendo.io.l4.f<T, String> fVar) {
            this.a = (String) Objects.requireNonNull(str, "name == null");
            this.b = fVar;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            String strConvert;
            if (t == null || (strConvert = this.b.convert(t)) == null) {
                return;
            }
            pVar.a(this.a, strConvert);
        }
    }

    static final class g<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;
        private final sdk.pendo.io.l4.f<T, String> c;

        g(Method method, int i, sdk.pendo.io.l4.f<T, String> fVar) {
            this.a = method;
            this.b = i;
            this.c = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.a, this.b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.a, this.b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.a, this.b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                pVar.a(key, this.c.convert(value));
            }
        }
    }

    static final class h extends n<sdk.pendo.io.e2.u> {
        private final Method a;
        private final int b;

        h(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable sdk.pendo.io.e2.u uVar) {
            if (uVar == null) {
                throw w.a(this.a, this.b, "Headers parameter must not be null.", new Object[0]);
            }
            pVar.a(uVar);
        }
    }

    static final class i<T> extends n<T> {
        private final Method a;
        private final int b;
        private final sdk.pendo.io.e2.u c;
        private final sdk.pendo.io.l4.f<T, c0> d;

        i(Method method, int i, sdk.pendo.io.e2.u uVar, sdk.pendo.io.l4.f<T, c0> fVar) {
            this.a = method;
            this.b = i;
            this.c = uVar;
            this.d = fVar;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                pVar.a(this.c, this.d.convert(t));
            } catch (IOException e) {
                throw w.a(this.a, this.b, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    static final class j<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;
        private final sdk.pendo.io.l4.f<T, c0> c;
        private final String d;

        j(Method method, int i, sdk.pendo.io.l4.f<T, c0> fVar, String str) {
            this.a = method;
            this.b = i;
            this.c = fVar;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.a, this.b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.a, this.b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.a, this.b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                pVar.a(sdk.pendo.io.e2.u.a("Content-Disposition", "form-data; name=\"" + key + "\"", MIME.CONTENT_TRANSFER_ENC, this.d), this.c.convert(value));
            }
        }
    }

    static final class k<T> extends n<T> {
        private final Method a;
        private final int b;
        private final String c;
        private final sdk.pendo.io.l4.f<T, String> d;
        private final boolean e;

        k(Method method, int i, String str, sdk.pendo.io.l4.f<T, String> fVar, boolean z) {
            this.a = method;
            this.b = i;
            this.c = (String) Objects.requireNonNull(str, "name == null");
            this.d = fVar;
            this.e = z;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) throws EOFException {
            if (t == null) {
                throw w.a(this.a, this.b, "Path parameter \"" + this.c + "\" value must not be null.", new Object[0]);
            }
            pVar.b(this.c, this.d.convert(t), this.e);
        }
    }

    static final class l<T> extends n<T> {
        private final String a;
        private final sdk.pendo.io.l4.f<T, String> b;
        private final boolean c;

        l(String str, sdk.pendo.io.l4.f<T, String> fVar, boolean z) {
            this.a = (String) Objects.requireNonNull(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            String strConvert;
            if (t == null || (strConvert = this.b.convert(t)) == null) {
                return;
            }
            pVar.c(this.a, strConvert, this.c);
        }
    }

    static final class m<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;
        private final sdk.pendo.io.l4.f<T, String> c;
        private final boolean d;

        m(Method method, int i, sdk.pendo.io.l4.f<T, String> fVar, boolean z) {
            this.a = method;
            this.b = i;
            this.c = fVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.a, this.b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.a, this.b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.a, this.b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.c.convert(value);
                if (strConvert == null) {
                    throw w.a(this.a, this.b, "Query map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                pVar.c(key, strConvert, this.d);
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.l4.n$n, reason: collision with other inner class name */
    static final class C0413n<T> extends n<T> {
        private final sdk.pendo.io.l4.f<T, String> a;
        private final boolean b;

        C0413n(sdk.pendo.io.l4.f<T, String> fVar, boolean z) {
            this.a = fVar;
            this.b = z;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            pVar.c(this.a.convert(t), null, this.b);
        }
    }

    static final class o extends n<y.c> {
        static final o a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.l4.n
        public void a(sdk.pendo.io.l4.p pVar, @Nullable y.c cVar) {
            if (cVar != null) {
                pVar.a(cVar);
            }
        }
    }

    static final class p extends n<Object> {
        private final Method a;
        private final int b;

        p(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable Object obj) {
            if (obj == null) {
                throw w.a(this.a, this.b, "@Url parameter is null.", new Object[0]);
            }
            pVar.a(obj);
        }
    }

    static final class q<T> extends n<T> {
        final Class<T> a;

        q(Class<T> cls) {
            this.a = cls;
        }

        @Override // sdk.pendo.io.l4.n
        void a(sdk.pendo.io.l4.p pVar, @Nullable T t) {
            pVar.a(this.a, t);
        }
    }

    n() {
    }

    final n<Object> a() {
        return new b();
    }

    abstract void a(sdk.pendo.io.l4.p pVar, @Nullable T t);

    final n<Iterable<T>> b() {
        return new a();
    }
}
