package external.sdk.pendo.io.gson;

import external.sdk.pendo.io.gson.internal.Excluder;
import external.sdk.pendo.io.gson.internal.bind.ArrayTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.CollectionTypeAdapterFactory;
import external.sdk.pendo.io.gson.internal.bind.DateTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import external.sdk.pendo.io.gson.internal.bind.MapTypeAdapterFactory;
import external.sdk.pendo.io.gson.internal.bind.NumberTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.ObjectTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory;
import external.sdk.pendo.io.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import sdk.pendo.io.a0.d;
import sdk.pendo.io.a0.e;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.j;
import sdk.pendo.io.a0.k;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.r;
import sdk.pendo.io.a0.s;
import sdk.pendo.io.a0.t;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.c;
import sdk.pendo.io.c0.f;
import sdk.pendo.io.h0.b;

/* JADX INFO: loaded from: classes4.dex */
public final class Gson {
    static final String y = null;
    private final ThreadLocal<Map<sdk.pendo.io.g0.a<?>, FutureTypeAdapter<?>>> a;
    private final Map<sdk.pendo.io.g0.a<?>, TypeAdapter<?>> b;
    private final c c;
    private final JsonAdapterAnnotationTypeAdapterFactory d;
    final List<u> e;
    final Excluder f;
    final d g;
    final Map<Type, e<?>> h;
    final boolean i;
    final boolean j;
    final boolean k;
    final boolean l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final r t;
    final List<u> u;
    final List<u> v;
    final t w;
    final t x;
    static final d z = sdk.pendo.io.a0.c.IDENTITY;
    static final t A = s.DOUBLE;
    static final t B = s.LAZILY_PARSED_NUMBER;
    private static final sdk.pendo.io.g0.a<?> C = sdk.pendo.io.g0.a.a(Object.class);

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> a;

        FutureTypeAdapter() {
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public T a(sdk.pendo.io.h0.a aVar) {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter != null) {
                return typeAdapter.a(aVar);
            }
            throw new IllegalStateException();
        }

        public void a(TypeAdapter<T> typeAdapter) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = typeAdapter;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.h0.c cVar, T t) {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.a(cVar, t);
        }
    }

    public Gson() {
        this(Excluder.g, z, Collections.emptyMap(), false, false, false, true, false, false, false, true, r.DEFAULT, y, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), A, B);
    }

    private static void a(Object obj, sdk.pendo.io.h0.a aVar) {
        if (obj != null) {
            try {
                if (aVar.t() == b.END_DOCUMENT) {
                } else {
                    throw new j("JSON document was not fully consumed.");
                }
            } catch (sdk.pendo.io.h0.d e) {
                throw new q(e);
            } catch (IOException e2) {
                throw new j(e2);
            }
        }
    }

    private static TypeAdapter<AtomicLongArray> b(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: external.sdk.pendo.io.gson.Gson.5
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray a(sdk.pendo.io.h0.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.i()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.a(aVar)).longValue()));
                }
                aVar.f();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.c();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    typeAdapter.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.e();
            }
        }.a();
    }

    public String toString() {
        return "{serializeNulls:" + this.i + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    Gson(Excluder excluder, d dVar, Map<Type, e<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, r rVar, String str, int i, int i2, List<u> list, List<u> list2, List<u> list3, t tVar, t tVar2) {
        this.a = new ThreadLocal<>();
        this.b = new ConcurrentHashMap();
        this.f = excluder;
        this.g = dVar;
        this.h = map;
        c cVar = new c(map, z9);
        this.c = cVar;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = z5;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.p = z9;
        this.t = rVar;
        this.q = str;
        this.r = i;
        this.s = i2;
        this.u = list;
        this.v = list2;
        this.w = tVar;
        this.x = tVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.W);
        arrayList.add(ObjectTypeAdapter.a(tVar));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.C);
        arrayList.add(TypeAdapters.m);
        arrayList.add(TypeAdapters.g);
        arrayList.add(TypeAdapters.i);
        arrayList.add(TypeAdapters.k);
        TypeAdapter<Number> typeAdapterA = a(rVar);
        arrayList.add(TypeAdapters.a(Long.TYPE, Long.class, typeAdapterA));
        arrayList.add(TypeAdapters.a(Double.TYPE, Double.class, a(z8)));
        arrayList.add(TypeAdapters.a(Float.TYPE, Float.class, b(z8)));
        arrayList.add(NumberTypeAdapter.a(tVar2));
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(TypeAdapters.a(AtomicLong.class, a(typeAdapterA)));
        arrayList.add(TypeAdapters.a(AtomicLongArray.class, b(typeAdapterA)));
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.E);
        arrayList.add(TypeAdapters.G);
        arrayList.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.z));
        arrayList.add(TypeAdapters.a(BigInteger.class, TypeAdapters.A));
        arrayList.add(TypeAdapters.a(f.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.I);
        arrayList.add(TypeAdapters.K);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.Q);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TypeAdapters.d);
        arrayList.add(DateTypeAdapter.b);
        arrayList.add(TypeAdapters.S);
        if (external.sdk.pendo.io.gson.internal.sql.a.a) {
            arrayList.add(external.sdk.pendo.io.gson.internal.sql.a.e);
            arrayList.add(external.sdk.pendo.io.gson.internal.sql.a.d);
            arrayList.add(external.sdk.pendo.io.gson.internal.sql.a.f);
        }
        arrayList.add(ArrayTypeAdapter.c);
        arrayList.add(TypeAdapters.b);
        arrayList.add(new CollectionTypeAdapterFactory(cVar));
        arrayList.add(new MapTypeAdapterFactory(cVar, z3));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(cVar);
        this.d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.X);
        arrayList.add(new ReflectiveTypeAdapterFactory(cVar, dVar, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.e = Collections.unmodifiableList(arrayList);
    }

    private static TypeAdapter<AtomicLong> a(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: external.sdk.pendo.io.gson.Gson.4
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicLong a(sdk.pendo.io.h0.a aVar) {
                return new AtomicLong(((Number) typeAdapter.a(aVar)).longValue());
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, AtomicLong atomicLong) {
                typeAdapter.a(cVar, Long.valueOf(atomicLong.get()));
            }
        }.a();
    }

    private TypeAdapter<Number> b(boolean z2) {
        return z2 ? TypeAdapters.u : new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.Gson.2
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Float a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return Float.valueOf((float) aVar.m());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.k();
                } else {
                    Gson.a(number.floatValue());
                    cVar.a(number);
                }
            }
        };
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> a(boolean z2) {
        return z2 ? TypeAdapters.v : new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.Gson.1
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Double a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return Double.valueOf(aVar.m());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.k();
                } else {
                    Gson.a(number.doubleValue());
                    cVar.a(number);
                }
            }
        };
    }

    public <T> T a(Reader reader, Class<T> cls) {
        sdk.pendo.io.h0.a aVarA = a(reader);
        Object objA = a(aVarA, (Type) cls);
        a(objA, aVarA);
        return (T) sdk.pendo.io.c0.j.a((Class) cls).cast(objA);
    }

    public <T> T a(Reader reader, Type type) {
        sdk.pendo.io.h0.a aVarA = a(reader);
        T t = (T) a(aVarA, type);
        a(t, aVarA);
        return t;
    }

    public <T> T a(String str, Class<T> cls) {
        return (T) sdk.pendo.io.c0.j.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(i iVar, Type type) {
        if (iVar == null) {
            return null;
        }
        return (T) a((sdk.pendo.io.h0.a) new external.sdk.pendo.io.gson.internal.bind.a(iVar), type);
    }

    public <T> T a(sdk.pendo.io.h0.a aVar, Type type) {
        boolean zJ = aVar.j();
        boolean z2 = true;
        aVar.c(true);
        try {
            try {
                try {
                    aVar.t();
                    z2 = false;
                    T tA = a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(type)).a(aVar);
                    aVar.c(zJ);
                    return tA;
                } catch (EOFException e) {
                    if (!z2) {
                        throw new q(e);
                    }
                    aVar.c(zJ);
                    return null;
                } catch (IllegalStateException e2) {
                    throw new q(e2);
                }
            } catch (IOException e3) {
                throw new q(e3);
            } catch (AssertionError e4) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.0): " + e4.getMessage());
                assertionError.initCause(e4);
                throw assertionError;
            }
        } catch (Throwable th) {
            aVar.c(zJ);
            throw th;
        }
    }

    public <T> TypeAdapter<T> a(Class<T> cls) {
        return a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a((Class) cls));
    }

    public <T> TypeAdapter<T> a(sdk.pendo.io.g0.a<T> aVar) {
        boolean z2;
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.b.get(aVar == null ? C : aVar);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<sdk.pendo.io.g0.a<?>, FutureTypeAdapter<?>> map = this.a.get();
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z2 = true;
        } else {
            z2 = false;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(aVar);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(aVar, futureTypeAdapter2);
            Iterator<u> it = this.e.iterator();
            while (it.hasNext()) {
                TypeAdapter<T> typeAdapterA = it.next().a(this, aVar);
                if (typeAdapterA != null) {
                    futureTypeAdapter2.a((TypeAdapter<?>) typeAdapterA);
                    this.b.put(aVar, typeAdapterA);
                    map.remove(aVar);
                    if (z2) {
                        this.a.remove();
                    }
                    return typeAdapterA;
                }
            }
            throw new IllegalArgumentException("GSON (2.9.0) cannot handle " + aVar);
        } catch (Throwable th) {
            map.remove(aVar);
            if (z2) {
                this.a.remove();
            }
            throw th;
        }
    }

    public <T> TypeAdapter<T> a(u uVar, sdk.pendo.io.g0.a<T> aVar) {
        if (!this.e.contains(uVar)) {
            uVar = this.d;
        }
        boolean z2 = false;
        for (u uVar2 : this.e) {
            if (z2) {
                TypeAdapter<T> typeAdapterA = uVar2.a(this, aVar);
                if (typeAdapterA != null) {
                    return typeAdapterA;
                }
            } else if (uVar2 == uVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    private static TypeAdapter<Number> a(r rVar) {
        return rVar == r.DEFAULT ? TypeAdapters.t : new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.Gson.3
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return Long.valueOf(aVar.o());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.k();
                } else {
                    cVar.d(number.toString());
                }
            }
        };
    }

    public sdk.pendo.io.h0.a a(Reader reader) {
        sdk.pendo.io.h0.a aVar = new sdk.pendo.io.h0.a(reader);
        aVar.c(this.n);
        return aVar;
    }

    public sdk.pendo.io.h0.c a(Writer writer) {
        if (this.k) {
            writer.write(")]}'\n");
        }
        sdk.pendo.io.h0.c cVar = new sdk.pendo.io.h0.c(writer);
        if (this.m) {
            cVar.b("  ");
        }
        cVar.a(this.l);
        cVar.b(this.n);
        cVar.c(this.i);
        return cVar;
    }

    public String a(Object obj) {
        return obj == null ? a((i) k.a) : a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String a(i iVar) {
        StringWriter stringWriter = new StringWriter();
        a(iVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(sdk.pendo.io.c0.k.a(appendable)));
        } catch (IOException e) {
            throw new j(e);
        }
    }

    public void a(Object obj, Type type, sdk.pendo.io.h0.c cVar) {
        TypeAdapter typeAdapterA = a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(type));
        boolean zI = cVar.i();
        cVar.b(true);
        boolean zH = cVar.h();
        cVar.a(this.l);
        boolean zG = cVar.g();
        cVar.c(this.i);
        try {
            try {
                try {
                    typeAdapterA.a(cVar, obj);
                    cVar.b(zI);
                    cVar.a(zH);
                    cVar.c(zG);
                } catch (AssertionError e) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.0): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                }
            } catch (IOException e2) {
                throw new j(e2);
            }
        } catch (Throwable th) {
            cVar.b(zI);
            cVar.a(zH);
            cVar.c(zG);
            throw th;
        }
    }

    public void a(i iVar, Appendable appendable) {
        try {
            a(iVar, a(sdk.pendo.io.c0.k.a(appendable)));
        } catch (IOException e) {
            throw new j(e);
        }
    }

    public void a(i iVar, sdk.pendo.io.h0.c cVar) {
        boolean zI = cVar.i();
        cVar.b(true);
        boolean zH = cVar.h();
        cVar.a(this.l);
        boolean zG = cVar.g();
        cVar.c(this.i);
        try {
            try {
                sdk.pendo.io.c0.k.a(iVar, cVar);
                cVar.b(zI);
                cVar.a(zH);
                cVar.c(zG);
            } catch (IOException e) {
                throw new j(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.0): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            cVar.b(zI);
            cVar.a(zH);
            cVar.c(zG);
            throw th;
        }
    }
}
