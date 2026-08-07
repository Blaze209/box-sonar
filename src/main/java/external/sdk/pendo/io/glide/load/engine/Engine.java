package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.engine.cache.DiskCacheAdapter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class Engine implements j, external.sdk.pendo.io.glide.load.engine.cache.c.a, m.a {
    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE = Log.isLoggable(TAG, 2);
    private final ActiveResources activeResources;
    private final external.sdk.pendo.io.glide.load.engine.cache.c cache;
    private final a decodeJobFactory;
    private final c diskCacheProvider;
    private final b engineJobFactory;
    private final o jobs;
    private final l keyFactory;
    private final t resourceRecycler;

    static class a {
        final g.e a;
        final Pools.Pool<g<?>> b = sdk.pendo.io.z.a.a(150, new C0309a());
        private int c;

        /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.engine.Engine$a$a, reason: collision with other inner class name */
        class C0309a implements sdk.pendo.io.z.a.d<g<?>> {
            C0309a() {
            }

            @Override // sdk.pendo.io.z.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g<?> a() {
                a aVar = a.this;
                return new g<>(aVar.a, aVar.b);
            }
        }

        a(g.e eVar) {
            this.a = eVar;
        }

        <R> g<R> a(external.sdk.pendo.io.glide.b bVar, Object obj, k kVar, sdk.pendo.io.e.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.c.b bVar2, sdk.pendo.io.h.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, g.b<R> bVar3) {
            g gVar = (g) sdk.pendo.io.y.k.a(this.b.acquire());
            int i3 = this.c;
            this.c = i3 + 1;
            return gVar.a(bVar, obj, kVar, fVar, i, i2, cls, cls2, bVar2, aVar, map, z, z2, z3, options, bVar3, i3);
        }
    }

    static class b {
        final sdk.pendo.io.k.a a;
        final sdk.pendo.io.k.a b;
        final sdk.pendo.io.k.a c;
        final sdk.pendo.io.k.a d;
        final j e;
        final m.a f;
        final Pools.Pool<i<?>> g = sdk.pendo.io.z.a.a(150, new a());

        class a implements sdk.pendo.io.z.a.d<i<?>> {
            a() {
            }

            @Override // sdk.pendo.io.z.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i<?> a() {
                b bVar = b.this;
                return new i<>(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        b(sdk.pendo.io.k.a aVar, sdk.pendo.io.k.a aVar2, sdk.pendo.io.k.a aVar3, sdk.pendo.io.k.a aVar4, j jVar, m.a aVar5) {
            this.a = aVar;
            this.b = aVar2;
            this.c = aVar3;
            this.d = aVar4;
            this.e = jVar;
            this.f = aVar5;
        }

        <R> i<R> a(sdk.pendo.io.e.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((i) sdk.pendo.io.y.k.a(this.g.acquire())).a(fVar, z, z2, z3, z4);
        }

        void a() {
            sdk.pendo.io.y.e.a(this.a);
            sdk.pendo.io.y.e.a(this.b);
            sdk.pendo.io.y.e.a(this.c);
            sdk.pendo.io.y.e.a(this.d);
        }
    }

    private static class c implements g.e {
        private final external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a a;
        private volatile external.sdk.pendo.io.glide.load.engine.cache.a b;

        c(external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a interfaceC0311a) {
            this.a = interfaceC0311a;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.g.e
        public external.sdk.pendo.io.glide.load.engine.cache.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new DiskCacheAdapter();
                    }
                }
            }
            return this.b;
        }

        synchronized void b() {
            if (this.b == null) {
                return;
            }
            this.b.clear();
        }
    }

    public class d {
        private final i<?> a;
        private final sdk.pendo.io.u.c b;

        d(sdk.pendo.io.u.c cVar, i<?> iVar) {
            this.b = cVar;
            this.a = iVar;
        }

        public void a() {
            synchronized (Engine.this) {
                this.a.c(this.b);
            }
        }
    }

    Engine(external.sdk.pendo.io.glide.load.engine.cache.c cVar, external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a interfaceC0311a, sdk.pendo.io.k.a aVar, sdk.pendo.io.k.a aVar2, sdk.pendo.io.k.a aVar3, sdk.pendo.io.k.a aVar4, o oVar, l lVar, ActiveResources activeResources, b bVar, a aVar5, t tVar, boolean z) {
        this.cache = cVar;
        c cVar2 = new c(interfaceC0311a);
        this.diskCacheProvider = cVar2;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.activeResources = activeResources2;
        activeResources2.a(this);
        this.keyFactory = lVar == null ? new l() : lVar;
        this.jobs = oVar == null ? new o() : oVar;
        this.engineJobFactory = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.decodeJobFactory = aVar5 == null ? new a(cVar2) : aVar5;
        this.resourceRecycler = tVar == null ? new t() : tVar;
        cVar.setResourceRemovedListener(this);
    }

    private m<?> getEngineResourceFromCache(sdk.pendo.io.e.f fVar) {
        sdk.pendo.io.h.c<?> cVarRemove = this.cache.remove(fVar);
        if (cVarRemove == null) {
            return null;
        }
        return cVarRemove instanceof m ? (m) cVarRemove : new m<>(cVarRemove, true, true, fVar, this);
    }

    private m<?> loadFromActiveResources(sdk.pendo.io.e.f fVar) {
        m<?> mVarB = this.activeResources.b(fVar);
        if (mVarB != null) {
            mVarB.a();
        }
        return mVarB;
    }

    private m<?> loadFromCache(sdk.pendo.io.e.f fVar) {
        m<?> engineResourceFromCache = getEngineResourceFromCache(fVar);
        if (engineResourceFromCache != null) {
            engineResourceFromCache.a();
            this.activeResources.a(fVar, engineResourceFromCache);
        }
        return engineResourceFromCache;
    }

    private m<?> loadFromMemory(k kVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        m<?> mVarLoadFromActiveResources = loadFromActiveResources(kVar);
        if (mVarLoadFromActiveResources != null) {
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Loaded resource from active resources", j, kVar);
            }
            return mVarLoadFromActiveResources;
        }
        m<?> mVarLoadFromCache = loadFromCache(kVar);
        if (mVarLoadFromCache == null) {
            return null;
        }
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Loaded resource from cache", j, kVar);
        }
        return mVarLoadFromCache;
    }

    private static void logWithTimeAndKey(String str, long j, sdk.pendo.io.e.f fVar) {
        Log.v(TAG, str + " in " + sdk.pendo.io.y.g.a(j) + "ms, key: " + fVar);
    }

    private <R> d waitForExistingOrStartNewJob(external.sdk.pendo.io.glide.b bVar, Object obj, sdk.pendo.io.e.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.c.b bVar2, sdk.pendo.io.h.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, sdk.pendo.io.u.c cVar, Executor executor, k kVar, long j) {
        i<?> iVarA = this.jobs.a(kVar, z6);
        if (iVarA != null) {
            iVarA.a(cVar, executor);
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Added to existing load", j, kVar);
            }
            return new d(cVar, iVarA);
        }
        i<R> iVarA2 = this.engineJobFactory.a(kVar, z3, z4, z5, z6);
        g<R> gVarA = this.decodeJobFactory.a(bVar, obj, kVar, fVar, i, i2, cls, cls2, bVar2, aVar, map, z, z2, z6, options, iVarA2);
        this.jobs.a((sdk.pendo.io.e.f) kVar, (i<?>) iVarA2);
        iVarA2.a(cVar, executor);
        iVarA2.b(gVarA);
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Started new load", j, kVar);
        }
        return new d(cVar, iVarA2);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.a().clear();
    }

    public <R> d load(external.sdk.pendo.io.glide.b bVar, Object obj, sdk.pendo.io.e.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.c.b bVar2, sdk.pendo.io.h.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, sdk.pendo.io.u.c cVar, Executor executor) {
        long jA = VERBOSE_IS_LOGGABLE ? sdk.pendo.io.y.g.a() : 0L;
        k kVarA = this.keyFactory.a(obj, fVar, i, i2, map, cls, cls2, options);
        synchronized (this) {
            m<?> mVarLoadFromMemory = loadFromMemory(kVarA, z3, jA);
            if (mVarLoadFromMemory == null) {
                return waitForExistingOrStartNewJob(bVar, obj, fVar, i, i2, cls, cls2, bVar2, aVar, map, z, z2, options, z3, z4, z5, z6, cVar, executor, kVarA, jA);
            }
            cVar.onResourceReady(mVarLoadFromMemory, sdk.pendo.io.e.a.MEMORY_CACHE, false);
            return null;
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.j
    public synchronized void onEngineJobCancelled(i<?> iVar, sdk.pendo.io.e.f fVar) {
        this.jobs.b(fVar, iVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.j
    public synchronized void onEngineJobComplete(i<?> iVar, sdk.pendo.io.e.f fVar, m<?> mVar) {
        if (mVar != null) {
            if (mVar.c()) {
                this.activeResources.a(fVar, mVar);
            }
        }
        this.jobs.b(fVar, iVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.m.a
    public void onResourceReleased(sdk.pendo.io.e.f fVar, m<?> mVar) {
        this.activeResources.a(fVar);
        if (mVar.c()) {
            this.cache.put(fVar, mVar);
        } else {
            this.resourceRecycler.a(mVar, false);
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c.a
    public void onResourceRemoved(sdk.pendo.io.h.c<?> cVar) {
        this.resourceRecycler.a(cVar, true);
    }

    public void release(sdk.pendo.io.h.c<?> cVar) {
        if (!(cVar instanceof m)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((m) cVar).d();
    }

    public void shutdown() {
        this.engineJobFactory.a();
        this.diskCacheProvider.b();
        this.activeResources.b();
    }

    public Engine(external.sdk.pendo.io.glide.load.engine.cache.c cVar, external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a interfaceC0311a, sdk.pendo.io.k.a aVar, sdk.pendo.io.k.a aVar2, sdk.pendo.io.k.a aVar3, sdk.pendo.io.k.a aVar4, boolean z) {
        this(cVar, interfaceC0311a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }
}
