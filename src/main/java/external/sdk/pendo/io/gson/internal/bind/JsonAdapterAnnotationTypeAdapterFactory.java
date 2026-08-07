package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import sdk.pendo.io.a0.h;
import sdk.pendo.io.a0.p;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.b0.b;
import sdk.pendo.io.c0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements u {
    private final c a;

    public JsonAdapterAnnotationTypeAdapterFactory(c cVar) {
        this.a = cVar;
    }

    @Override // sdk.pendo.io.a0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
        b bVar = (b) aVar.a().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.a, gson, aVar, bVar);
    }

    TypeAdapter<?> a(c cVar, Gson gson, sdk.pendo.io.g0.a<?> aVar, b bVar) {
        TypeAdapter<?> treeTypeAdapter;
        Object objA = cVar.a(sdk.pendo.io.g0.a.a((Class) bVar.value())).a();
        if (objA instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objA;
        } else if (objA instanceof u) {
            treeTypeAdapter = ((u) objA).a(gson, aVar);
        } else {
            boolean z = objA instanceof p;
            if (!z && !(objA instanceof h)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter(z ? (p) objA : null, objA instanceof h ? (h) objA : null, gson, aVar, null);
        }
        return (treeTypeAdapter == null || !bVar.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.a();
    }
}
