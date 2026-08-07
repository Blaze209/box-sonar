package external.sdk.pendo.io.glide.load.model;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private final e a;
    private final a b;

    private static class a {
        private final Map<Class<?>, C0315a<?>> a = new HashMap();

        /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.model.c$a$a, reason: collision with other inner class name */
        private static class C0315a<Model> {
            final List<b<Model, ?>> a;

            public C0315a(List<b<Model, ?>> list) {
                this.a = list;
            }
        }

        a() {
        }

        public void a() {
            this.a.clear();
        }

        public <Model> List<b<Model, ?>> a(Class<Model> cls) {
            C0315a<?> c0315a = this.a.get(cls);
            if (c0315a == null) {
                return null;
            }
            return (List<b<Model, ?>>) c0315a.a;
        }

        public <Model> void a(Class<Model> cls, List<b<Model, ?>> list) {
            if (this.a.put(cls, new C0315a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public c(Pools.Pool<List<Throwable>> pool) {
        this(new e(pool));
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.l.d<? extends Model, ? extends Data> dVar) {
        this.a.a(cls, cls2, dVar);
        this.b.a();
    }

    public <A> List<b<A, ?>> b(A a2) {
        List<b<A, ?>> listB = b((Class) a(a2));
        if (listB.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2);
        }
        int size = listB.size();
        List<b<A, ?>> listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            b<A, ?> bVar = listB.get(i);
            if (bVar.handles(a2)) {
                if (z) {
                    listEmptyList = new ArrayList<>(size - i);
                    z = false;
                }
                listEmptyList.add(bVar);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2, listB);
        }
        return listEmptyList;
    }

    private c(e eVar) {
        this.b = new a();
        this.a = eVar;
    }

    private static <A> Class<A> a(A a2) {
        return (Class<A>) a2.getClass();
    }

    private synchronized <A> List<b<A, ?>> b(Class<A> cls) {
        List<b<A, ?>> listA;
        listA = this.b.a(cls);
        if (listA == null) {
            listA = Collections.unmodifiableList(this.a.a(cls));
            this.b.a(cls, listA);
        }
        return listA;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.a.b(cls);
    }
}
