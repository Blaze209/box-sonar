package external.sdk.pendo.io.glide.load.model;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.Registry;
import external.sdk.pendo.io.glide.load.Options;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static final c e = new c();
    private static final external.sdk.pendo.io.glide.load.model.b<Object, Object> f = new a();
    private final List<b<?, ?>> a;
    private final c b;
    private final Set<b<?, ?>> c;
    private final Pools.Pool<List<Throwable>> d;

    private static class a implements external.sdk.pendo.io.glide.load.model.b<Object, Object> {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.model.b
        public external.sdk.pendo.io.glide.load.model.b.a<Object> buildLoadData(Object obj, int i, int i2, Options options) {
            return null;
        }

        @Override // external.sdk.pendo.io.glide.load.model.b
        public boolean handles(Object obj) {
            return false;
        }
    }

    private static class b<Model, Data> {
        private final Class<Model> a;
        final Class<Data> b;
        final sdk.pendo.io.l.d<? extends Model, ? extends Data> c;

        public b(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.l.d<? extends Model, ? extends Data> dVar) {
            this.a = cls;
            this.b = cls2;
            this.c = dVar;
        }

        public boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        public <Model, Data> d<Model, Data> a(List<external.sdk.pendo.io.glide.load.model.b<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
            return new d<>(list, pool);
        }
    }

    public e(Pools.Pool<List<Throwable>> pool) {
        this(pool, e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.l.d<? extends Model, ? extends Data> dVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, dVar);
        List<b<?, ?>> list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    e(Pools.Pool<List<Throwable>> pool, c cVar) {
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = pool;
        this.b = cVar;
    }

    synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.l.d<? extends Model, ? extends Data> dVar) {
        a(cls, cls2, dVar, true);
    }

    private <Model, Data> external.sdk.pendo.io.glide.load.model.b<Model, Data> a(b<?, ?> bVar) {
        return (external.sdk.pendo.io.glide.load.model.b) k.a(bVar.c.build(this));
    }

    public synchronized <Model, Data> external.sdk.pendo.io.glide.load.model.b<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (external.sdk.pendo.io.glide.load.model.b) arrayList.get(0);
            }
            if (!z) {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
            return a();
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    synchronized <Model> List<external.sdk.pendo.io.glide.load.model.b<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.c.contains(bVar) && bVar.a(cls)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    private static <Model, Data> external.sdk.pendo.io.glide.load.model.b<Model, Data> a() {
        return (external.sdk.pendo.io.glide.load.model.b<Model, Data>) f;
    }
}
