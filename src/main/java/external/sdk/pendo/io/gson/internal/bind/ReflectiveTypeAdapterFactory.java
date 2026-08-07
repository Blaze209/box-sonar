package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import external.sdk.pendo.io.gson.internal.Excluder;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.a0.d;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.c;
import sdk.pendo.io.c0.h;
import sdk.pendo.io.c0.j;

/* JADX INFO: loaded from: classes4.dex */
public final class ReflectiveTypeAdapterFactory implements u {
    private final c a;
    private final d b;
    private final Excluder c;
    private final JsonAdapterAnnotationTypeAdapterFactory d;

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final h<T> a;
        private final Map<String, b> b;

        Adapter(h<T> hVar, Map<String, b> map) {
            this.a = hVar;
            this.b = map;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public T a(sdk.pendo.io.h0.a aVar) throws IOException {
            if (aVar.t() == sdk.pendo.io.h0.b.NULL) {
                aVar.q();
                return null;
            }
            T tA = this.a.a();
            try {
                aVar.b();
                while (aVar.i()) {
                    b bVar = this.b.get(aVar.p());
                    if (bVar == null || !bVar.c) {
                        aVar.z();
                    } else {
                        bVar.a(aVar, tA);
                    }
                }
                aVar.g();
                return tA;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new q(e2);
            }
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.h0.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.k();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.a);
                        bVar.a(cVar, t);
                    }
                }
                cVar.f();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    class a extends b {
        final /* synthetic */ Field d;
        final /* synthetic */ boolean e;
        final /* synthetic */ TypeAdapter f;
        final /* synthetic */ Gson g;
        final /* synthetic */ sdk.pendo.io.g0.a h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, sdk.pendo.io.g0.a aVar, boolean z4) {
            super(str, z, z2);
            this.d = field;
            this.e = z3;
            this.f = typeAdapter;
            this.g = gson;
            this.h = aVar;
            this.i = z4;
        }

        @Override // external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(sdk.pendo.io.h0.a aVar, Object obj) throws IllegalAccessException {
            Object objA = this.f.a(aVar);
            if (objA == null && this.i) {
                return;
            }
            this.d.set(obj, objA);
        }

        @Override // external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(sdk.pendo.io.h0.c cVar, Object obj) throws IllegalAccessException {
            (this.e ? this.f : new TypeAdapterRuntimeTypeWrapper(this.g, this.f, this.h.b())).a(cVar, this.d.get(obj));
        }

        @Override // external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public boolean a(Object obj) {
            return this.b && this.d.get(obj) != obj;
        }
    }

    static abstract class b {
        final String a;
        final boolean b;
        final boolean c;

        protected b(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        abstract void a(sdk.pendo.io.h0.a aVar, Object obj);

        abstract void a(sdk.pendo.io.h0.c cVar, Object obj);

        abstract boolean a(Object obj);
    }

    public ReflectiveTypeAdapterFactory(c cVar, d dVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.a = cVar;
        this.b = dVar;
        this.c = excluder;
        this.d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    @Override // sdk.pendo.io.a0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        if (Object.class.isAssignableFrom(clsA)) {
            return new Adapter(this.a.a(aVar), a(gson, (sdk.pendo.io.g0.a<?>) aVar, (Class<?>) clsA));
        }
        return null;
    }

    private b a(Gson gson, Field field, String str, sdk.pendo.io.g0.a<?> aVar, boolean z, boolean z2) {
        boolean zA = j.a((Type) aVar.a());
        sdk.pendo.io.b0.b bVar = (sdk.pendo.io.b0.b) field.getAnnotation(sdk.pendo.io.b0.b.class);
        TypeAdapter<?> typeAdapterA = bVar != null ? this.d.a(this.a, gson, aVar, bVar) : null;
        boolean z3 = typeAdapterA != null;
        if (typeAdapterA == null) {
            typeAdapterA = gson.a((sdk.pendo.io.g0.a) aVar);
        }
        return new a(str, z, z2, field, z3, typeAdapterA, gson, aVar, zA);
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.c);
    }

    static boolean a(Field field, boolean z, Excluder excluder) {
        return (excluder.a(field.getType(), z) || excluder.a(field, z)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    private Map<String, b> a(Gson gson, sdk.pendo.io.g0.a<?> aVar, Class<?> cls) {
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory;
        sdk.pendo.io.g0.a<?> aVar2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls.isInterface()) {
            Type typeB = aVar.b();
            sdk.pendo.io.g0.a<?> aVarA = aVar;
            Class<?> clsA = cls;
            while (clsA != Object.class) {
                Field[] declaredFields = clsA.getDeclaredFields();
                int length = declaredFields.length;
                boolean z = false;
                int i = 0;
                while (i < length) {
                    Field field = declaredFields[i];
                    boolean zA = reflectiveTypeAdapterFactory.a(field, true);
                    boolean zA2 = reflectiveTypeAdapterFactory.a(field, z);
                    if (zA || zA2) {
                        this = this;
                        sdk.pendo.io.f0.a.a(field);
                        Type typeA = sdk.pendo.io.c0.b.a(aVarA.b(), clsA, field.getGenericType());
                        List<String> listA = reflectiveTypeAdapterFactory.a(field);
                        int size = listA.size();
                        b bVar = null;
                        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory2 = reflectiveTypeAdapterFactory;
                        for (?? r13 = z; r13 < size; r13++) {
                            String str = listA.get(r13);
                            if (r13 != 0) {
                                zA = false;
                            }
                            int i2 = size;
                            List<String> list = listA;
                            sdk.pendo.io.g0.a<?> aVar3 = aVarA;
                            b bVar2 = bVar;
                            boolean z2 = zA;
                            b bVar3 = (b) linkedHashMap.put(str, reflectiveTypeAdapterFactory2.a(gson, field, str, sdk.pendo.io.g0.a.a(typeA), z2, zA2));
                            if (bVar2 != null) {
                                bVar3 = bVar2;
                            }
                            aVarA = aVar3;
                            zA = z2;
                            listA = list;
                            size = i2;
                            bVar = bVar3;
                            reflectiveTypeAdapterFactory2 = this;
                        }
                        aVar2 = aVarA;
                        b bVar4 = bVar;
                        if (bVar4 != null) {
                            throw new IllegalArgumentException(typeB + " declares multiple JSON fields named " + bVar4.a);
                        }
                    } else {
                        aVar2 = aVarA;
                    }
                    i++;
                    z = false;
                    reflectiveTypeAdapterFactory = this;
                    aVarA = aVar2;
                }
                this = this;
                aVarA = sdk.pendo.io.g0.a.a(sdk.pendo.io.c0.b.a(aVarA.b(), clsA, clsA.getGenericSuperclass()));
                clsA = aVarA.a();
            }
        }
        return linkedHashMap;
    }

    private List<String> a(Field field) {
        sdk.pendo.io.b0.c cVar = (sdk.pendo.io.b0.c) field.getAnnotation(sdk.pendo.io.b0.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.b.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
