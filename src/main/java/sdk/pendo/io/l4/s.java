package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
public final class s {
    private final Map<Method, t<?>> a = new ConcurrentHashMap();
    final sdk.pendo.io.e2.e.a b;
    final sdk.pendo.io.e2.v c;
    final List<f.a> d;
    final List<c.a> e;

    @Nullable
    final Executor f;
    final boolean g;

    class a implements InvocationHandler {
        private final o a = o.e();
        private final Object[] b = new Object[0];
        final /* synthetic */ Class c;

        a(Class cls) {
            this.c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.b;
            }
            return this.a.a(method) ? this.a.a(method, this.c, obj, objArr) : s.this.a(method).a(objArr);
        }
    }

    public static final class b {
        private final o a;

        @Nullable
        private sdk.pendo.io.e2.e.a b;

        @Nullable
        private sdk.pendo.io.e2.v c;
        private final List<f.a> d;
        private final List<c.a> e;

        @Nullable
        private Executor f;
        private boolean g;

        public b() {
            this(o.e());
        }

        public b a(c.a aVar) {
            this.e.add((c.a) Objects.requireNonNull(aVar, "factory == null"));
            return this;
        }

        b(o oVar) {
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.a = oVar;
        }

        public b a(f.a aVar) {
            this.d.add((f.a) Objects.requireNonNull(aVar, "factory == null"));
            return this;
        }

        public b a(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return a(sdk.pendo.io.e2.v.a(str));
        }

        public b a(sdk.pendo.io.e2.v vVar) {
            Objects.requireNonNull(vVar, "baseUrl == null");
            List<String> listK = vVar.k();
            if (!"".equals(listK.get(listK.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + vVar);
            }
            this.c = vVar;
            return this;
        }

        public s a() {
            if (this.c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            sdk.pendo.io.e2.e.a zVar = this.b;
            if (zVar == null) {
                zVar = new z();
            }
            sdk.pendo.io.e2.e.a aVar = zVar;
            Executor executorA = this.f;
            if (executorA == null) {
                executorA = this.a.a();
            }
            Executor executor = executorA;
            ArrayList arrayList = new ArrayList(this.e);
            arrayList.addAll(this.a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.d.size() + 1 + this.a.c());
            arrayList2.add(new sdk.pendo.io.l4.a());
            arrayList2.addAll(this.d);
            arrayList2.addAll(this.a.b());
            return new s(aVar, this.c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.g);
        }

        public b a(sdk.pendo.io.e2.e.a aVar) {
            this.b = (sdk.pendo.io.e2.e.a) Objects.requireNonNull(aVar, "factory == null");
            return this;
        }

        public b a(z zVar) {
            return a((sdk.pendo.io.e2.e.a) Objects.requireNonNull(zVar, "client == null"));
        }
    }

    s(sdk.pendo.io.e2.e.a aVar, sdk.pendo.io.e2.v vVar, List<f.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.b = aVar;
        this.c = vVar;
        this.d = list;
        this.e = list2;
        this.f = executor;
        this.g = z;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public <T> f<e0, T> b(Type type, Annotation[] annotationArr) {
        return a((f.a) null, type, annotationArr);
    }

    public <T> f<T, String> c(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            f<T, String> fVar = (f<T, String>) this.d.get(i).stringConverter(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return sdk.pendo.io.l4.a.d.a;
    }

    private void b(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sbAppend = new StringBuilder("Type parameters are unsupported on ").append(cls2.getName());
                if (cls2 != cls) {
                    sbAppend.append(" which is an interface of ").append(cls.getName());
                }
                throw new IllegalArgumentException(sbAppend.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.g) {
            o oVarE = o.e();
            for (Method method : cls.getDeclaredMethods()) {
                if (!oVarE.a(method) && !Modifier.isStatic(method.getModifiers())) {
                    a(method);
                }
            }
        }
    }

    public <T> T a(Class<T> cls) {
        b(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    t<?> a(Method method) {
        t<?> tVarA;
        t<?> tVar = this.a.get(method);
        if (tVar != null) {
            return tVar;
        }
        synchronized (this.a) {
            tVarA = this.a.get(method);
            if (tVarA == null) {
                tVarA = t.a(this, method);
                this.a.put(method, tVarA);
            }
        }
        return tVarA;
    }

    public c<?, ?> a(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.e.indexOf(aVar) + 1;
        int size = this.e.size();
        for (int i = iIndexOf; i < size; i++) {
            c<?, ?> cVarA = this.e.get(i).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate call adapter for ").append(type).append(".\n");
        if (aVar != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.e.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.e.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> f<T, c0> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = iIndexOf; i < size; i++) {
            f<T, c0> fVar = (f<T, c0>) this.d.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (aVar != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.d.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.d.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> f<e0, T> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = iIndexOf; i < size; i++) {
            f<e0, T> fVar = (f<e0, T>) this.d.get(i).responseBodyConverter(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (aVar != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.d.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.d.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> f<T, c0> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }
}
