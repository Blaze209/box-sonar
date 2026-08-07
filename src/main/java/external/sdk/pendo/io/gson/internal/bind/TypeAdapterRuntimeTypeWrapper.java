package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson a;
    private final TypeAdapter<T> b;
    private final Type c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.a = gson;
        this.b = typeAdapter;
        this.c = type;
    }

    private Type a(Type type, Object obj) {
        return (obj == null || !(type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) ? type : obj.getClass();
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public T a(sdk.pendo.io.h0.a aVar) {
        return this.b.a(aVar);
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, T t) {
        TypeAdapter<T> typeAdapterA = this.b;
        Type typeA = a(this.c, t);
        if (typeA != this.c) {
            typeAdapterA = this.a.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(typeA));
            if (typeAdapterA instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter = this.b;
                if (!(typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapterA = typeAdapter;
                }
            }
        }
        typeAdapterA.a(cVar, t);
    }
}
