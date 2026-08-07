package sdk.pendo.io.z;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    private static final g<Object> a = new C0540a();

    /* JADX INFO: renamed from: sdk.pendo.io.z.a$a, reason: collision with other inner class name */
    class C0540a implements g<Object> {
        C0540a() {
        }

        @Override // sdk.pendo.io.z.a.g
        public void a(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // sdk.pendo.io.z.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // sdk.pendo.io.z.a.g
        public void a(List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T a();
    }

    private static final class e<T> implements Pools.Pool<T> {
        private final d<T> a;
        private final g<T> b;
        private final Pools.Pool<T> c;

        e(Pools.Pool<T> pool, d<T> dVar, g<T> gVar) {
            this.c = pool;
            this.a = dVar;
            this.b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.c.acquire();
            if (tAcquire == null) {
                tAcquire = this.a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof f) {
                ((f) tAcquire).b().a(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t) {
            if (t instanceof f) {
                ((f) t).b().a(true);
            }
            this.b.a(t);
            return this.c.release(t);
        }
    }

    public interface f {
        sdk.pendo.io.z.c b();
    }

    public interface g<T> {
        void a(T t);
    }

    private static <T extends f> Pools.Pool<T> a(Pools.Pool<T> pool, d<T> dVar) {
        return a(pool, dVar, a());
    }

    public static <T> Pools.Pool<List<T>> b() {
        return a(20);
    }

    private static <T> Pools.Pool<T> a(Pools.Pool<T> pool, d<T> dVar, g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    private static <T> g<T> a() {
        return (g<T>) a;
    }

    public static <T extends f> Pools.Pool<T> a(int i, d<T> dVar) {
        return a(new Pools.SynchronizedPool(i), dVar);
    }

    public static <T> Pools.Pool<List<T>> a(int i) {
        return a(new Pools.SynchronizedPool(i), new b(), new c());
    }
}
