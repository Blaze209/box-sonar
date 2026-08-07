package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final u c = new u() { // from class: external.sdk.pendo.io.gson.internal.bind.ArrayTypeAdapter.1
        @Override // sdk.pendo.io.a0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
            Type typeB = aVar.b();
            if (!(typeB instanceof GenericArrayType) && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
                return null;
            }
            Type typeD = b.d(typeB);
            return new ArrayTypeAdapter(gson, gson.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(typeD)), b.e(typeD));
        }
    };
    private final Class<E> a;
    private final TypeAdapter<E> b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.a = cls;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public Object a(sdk.pendo.io.h0.a aVar) throws IOException {
        if (aVar.t() == sdk.pendo.io.h0.b.NULL) {
            aVar.q();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.i()) {
            arrayList.add(this.b.a(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.k();
            return;
        }
        cVar.c();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.a(cVar, (E) Array.get(obj, i));
        }
        cVar.e();
    }
}
