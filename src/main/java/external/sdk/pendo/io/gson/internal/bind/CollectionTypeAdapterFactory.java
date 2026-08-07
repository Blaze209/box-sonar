package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.b;
import sdk.pendo.io.c0.c;
import sdk.pendo.io.c0.h;

/* JADX INFO: loaded from: classes4.dex */
public final class CollectionTypeAdapterFactory implements u {
    private final c a;

    public CollectionTypeAdapterFactory(c cVar) {
        this.a = cVar;
    }

    @Override // sdk.pendo.io.a0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
        Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        if (!Collection.class.isAssignableFrom(clsA)) {
            return null;
        }
        Type typeA = b.a(typeB, (Class<?>) clsA);
        return new Adapter(gson, typeA, gson.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(typeA)), this.a.a(aVar));
    }

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> a;
        private final h<? extends Collection<E>> b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, h<? extends Collection<E>> hVar) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = hVar;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<E> a(sdk.pendo.io.h0.a aVar) throws IOException {
            if (aVar.t() == sdk.pendo.io.h0.b.NULL) {
                aVar.q();
                return null;
            }
            Collection<E> collectionA = this.b.a();
            aVar.a();
            while (aVar.i()) {
                collectionA.add(this.a.a(aVar));
            }
            aVar.f();
            return collectionA;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.h0.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.k();
                return;
            }
            cVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.a.a(cVar, it.next());
            }
            cVar.e();
        }
    }
}
