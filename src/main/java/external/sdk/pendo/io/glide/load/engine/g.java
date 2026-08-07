package external.sdk.pendo.io.glide.load.engine;

import android.os.Process;
import android.util.Log;
import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.GlideBuilder;
import external.sdk.pendo.io.glide.Registry;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
class g<R> implements external.sdk.pendo.io.glide.load.engine.e.a, Runnable, Comparable<g<?>>, sdk.pendo.io.z.a.f {
    public static final sdk.pendo.io.e.g<Supplier<Integer>> I = sdk.pendo.io.e.g.a("glide_thread_priority_override");
    private sdk.pendo.io.e.f A;
    private Object B;
    private sdk.pendo.io.e.a C;
    private external.sdk.pendo.io.glide.load.data.a<?> D;
    private volatile external.sdk.pendo.io.glide.load.engine.e E;
    private volatile boolean F;
    private volatile boolean G;
    private boolean H;
    private final e d;
    private final Pools.Pool<g<?>> e;
    private external.sdk.pendo.io.glide.b h;
    private sdk.pendo.io.e.f i;
    private sdk.pendo.io.c.b j;
    private k k;
    private int l;
    private int m;
    private sdk.pendo.io.h.a n;
    private Options o;
    private b<R> p;
    private int q;
    private h r;
    private EnumC0313g s;
    private long t;
    private boolean u;
    private Object v;
    private external.sdk.pendo.io.glide.c w;
    private Supplier<Integer> x;
    private Thread y;
    private sdk.pendo.io.e.f z;
    private final external.sdk.pendo.io.glide.load.engine.f<R> a = new external.sdk.pendo.io.glide.load.engine.f<>();
    private final List<Throwable> b = new ArrayList();
    private final sdk.pendo.io.z.c c = sdk.pendo.io.z.c.a();
    private final d<?> f = new d<>();
    private final f g = new f();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[sdk.pendo.io.e.c.values().length];
            c = iArr;
            try {
                iArr[sdk.pendo.io.e.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[sdk.pendo.io.e.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.values().length];
            b = iArr2;
            try {
                iArr2[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[EnumC0313g.values().length];
            a = iArr3;
            try {
                iArr3[EnumC0313g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumC0313g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumC0313g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    interface b<R> {
        void a(g<?> gVar);

        void onLoadFailed(n nVar);

        void onResourceReady(sdk.pendo.io.h.c<R> cVar, sdk.pendo.io.e.a aVar, boolean z);
    }

    private final class c<Z> implements external.sdk.pendo.io.glide.load.engine.h.a<Z> {
        private final sdk.pendo.io.e.a a;

        c(sdk.pendo.io.e.a aVar) {
            this.a = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.h.a
        public sdk.pendo.io.h.c<Z> a(sdk.pendo.io.h.c<Z> cVar) {
            return g.this.a(this.a, cVar);
        }
    }

    private static class d<Z> {
        private sdk.pendo.io.e.f a;
        private ResourceEncoder<Z> b;
        private q<Z> c;

        d() {
        }

        void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        boolean b() {
            return this.c != null;
        }

        void a(e eVar, Options options) {
            sdk.pendo.io.z.b.a("DecodeJob.encode");
            try {
                eVar.a().put(this.a, new external.sdk.pendo.io.glide.load.engine.d(this.b, this.c, options));
            } finally {
                this.c.c();
                sdk.pendo.io.z.b.a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(sdk.pendo.io.e.f fVar, ResourceEncoder<X> resourceEncoder, q<X> qVar) {
            this.a = fVar;
            this.b = resourceEncoder;
            this.c = qVar;
        }
    }

    interface e {
        external.sdk.pendo.io.glide.load.engine.cache.a a();
    }

    private static class f {
        private boolean a;
        private boolean b;
        private boolean c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }

        synchronized boolean b() {
            this.c = true;
            return a(false);
        }

        synchronized void c() {
            this.b = false;
            this.a = false;
            this.c = false;
        }

        synchronized boolean a() {
            this.b = true;
            return a(false);
        }

        synchronized boolean b(boolean z) {
            this.a = true;
            return a(z);
        }
    }

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.engine.g$g, reason: collision with other inner class name */
    private enum EnumC0313g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    g(e eVar, Pools.Pool<g<?>> pool) {
        this.d = eVar;
        this.e = pool;
    }

    private void d() {
        Supplier<Integer> supplier;
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.t, "data: " + this.B + ", cache key: " + this.z + ", fetcher: " + this.D);
        }
        sdk.pendo.io.h.c<R> cVarA = null;
        if (this.w.a(GlideBuilder.OverrideGlideThreadPriority.class) && (supplier = this.x) != null && supplier.get() != null) {
            try {
                Process.setThreadPriority(Process.myTid(), this.x.get().intValue());
            } catch (IllegalArgumentException | SecurityException e2) {
                this.x = null;
                if (Log.isLoggable("DecodeJob", 2)) {
                    Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e2);
                }
            }
        }
        try {
            cVarA = a(this.D, this.B, this.C);
        } catch (n e3) {
            e3.a(this.A, this.C);
            this.b.add(e3);
        }
        if (cVarA != null) {
            b(cVarA, this.C, this.H);
        } else {
            l();
        }
    }

    private external.sdk.pendo.io.glide.load.engine.e e() {
        int i = a.b[this.r.ordinal()];
        if (i == 1) {
            return new r(this.a, this);
        }
        if (i == 2) {
            return new external.sdk.pendo.io.glide.load.engine.b(this.a, this);
        }
        if (i == 3) {
            return new u(this.a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private int f() {
        return this.j.ordinal();
    }

    private void g() {
        if (this.w.a(GlideBuilder.OverrideGlideThreadPriority.class)) {
            k();
        }
        n();
        this.p.onLoadFailed(new n("Failed to load resource", new ArrayList(this.b)));
        i();
    }

    private void h() {
        if (this.g.a()) {
            j();
        }
    }

    private void i() {
        if (this.g.b()) {
            j();
        }
    }

    private void j() {
        this.g.c();
        this.f.a();
        this.a.a();
        this.F = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.E = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.t = 0L;
        this.G = false;
        this.v = null;
        this.b.clear();
        this.e.release(this);
    }

    private void k() {
        if (!this.w.a(GlideBuilder.OverrideGlideThreadPriority.class)) {
            throw new IllegalStateException("OverrideGlideThreadPriority experiment is not enabled.");
        }
        Supplier<Integer> supplier = this.x;
        if (supplier == null || supplier.get() == null) {
            return;
        }
        try {
            Process.setThreadPriority(Process.myTid(), 9);
        } catch (IllegalArgumentException | SecurityException e2) {
            this.x = null;
            if (Log.isLoggable("DecodeJob", 2)) {
                Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e2);
            }
        }
    }

    private void l() {
        this.y = Thread.currentThread();
        this.t = sdk.pendo.io.y.g.a();
        boolean zB = false;
        while (!this.G && this.E != null && !(zB = this.E.b())) {
            this.r = a(this.r);
            this.E = e();
            if (this.r == h.SOURCE) {
                a(EnumC0313g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.r == h.FINISHED || this.G) && !zB) {
            g();
        }
    }

    private void m() {
        int i = a.a[this.s.ordinal()];
        if (i == 1) {
            this.r = a(h.INITIALIZE);
            this.E = e();
            l();
        } else if (i == 2) {
            l();
        } else {
            if (i != 3) {
                throw new IllegalStateException("Unrecognized run reason: " + this.s);
            }
            d();
        }
    }

    private void n() {
        Throwable th;
        this.c.b();
        if (!this.F) {
            this.F = true;
            return;
        }
        if (this.b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g<?> gVar) {
        int iF = f() - gVar.f();
        return iF == 0 ? this.q - gVar.q : iF;
    }

    @Override // sdk.pendo.io.z.a.f
    public sdk.pendo.io.z.c b() {
        return this.c;
    }

    public void c() {
        this.G = true;
        external.sdk.pendo.io.glide.load.engine.e eVar = this.E;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    boolean o() {
        h hVarA = a(h.INITIALIZE);
        return hVarA == h.RESOURCE_CACHE || hVarA == h.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        sdk.pendo.io.z.b.a("DecodeJob#run(reason=%s, model=%s)", this.s, this.v);
        external.sdk.pendo.io.glide.load.data.a<?> aVar = this.D;
        try {
            try {
                try {
                    if (this.G) {
                        g();
                        if (aVar != null) {
                            aVar.cleanup();
                        }
                        sdk.pendo.io.z.b.a();
                        return;
                    }
                    m();
                    if (aVar != null) {
                        aVar.cleanup();
                    }
                    sdk.pendo.io.z.b.a();
                } catch (external.sdk.pendo.io.glide.load.engine.a e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.G + ", stage: " + this.r, th);
                }
                if (this.r != h.ENCODE) {
                    this.b.add(th);
                    g();
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.cleanup();
            }
            sdk.pendo.io.z.b.a();
            throw th2;
        }
    }

    private <Data> sdk.pendo.io.h.c<R> a(external.sdk.pendo.io.glide.load.data.a<?> aVar, Data data, sdk.pendo.io.e.a aVar2) {
        if (data == null) {
            aVar.cleanup();
            return null;
        }
        try {
            long jA = sdk.pendo.io.y.g.a();
            sdk.pendo.io.h.c<R> cVarA = a(data, aVar2);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + cVarA, jA);
            }
            return cVarA;
        } finally {
            aVar.cleanup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(sdk.pendo.io.h.c<R> cVar, sdk.pendo.io.e.a aVar, boolean z) {
        q qVar;
        sdk.pendo.io.z.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (cVar instanceof sdk.pendo.io.h.b) {
                ((sdk.pendo.io.h.b) cVar).initialize();
            }
            if (this.f.b()) {
                cVar = q.b(cVar);
                qVar = cVar;
            } else {
                qVar = 0;
            }
            a(cVar, aVar, z);
            this.r = h.ENCODE;
            try {
                if (this.f.b()) {
                    this.f.a(this.d, this.o);
                }
                if (qVar != 0) {
                    qVar.c();
                }
                h();
                sdk.pendo.io.z.b.a();
            } catch (Throwable th) {
                if (qVar != 0) {
                    qVar.c();
                }
                throw th;
            }
        } catch (Throwable th2) {
            sdk.pendo.io.z.b.a();
            throw th2;
        }
    }

    private <Data> sdk.pendo.io.h.c<R> a(Data data, sdk.pendo.io.e.a aVar) {
        return a(data, aVar, this.a.a((Class) data.getClass()));
    }

    private h a(h hVar) {
        h hVar2;
        int i = a.b[hVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.u ? h.FINISHED : h.SOURCE;
            }
            if (i == 3 || i == 4) {
                return h.FINISHED;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + hVar);
            }
            if (this.n.b()) {
                return h.RESOURCE_CACHE;
            }
            hVar2 = h.RESOURCE_CACHE;
        } else {
            if (this.n.a()) {
                return h.DATA_CACHE;
            }
            hVar2 = h.DATA_CACHE;
        }
        return a(hVar2);
    }

    private Options a(sdk.pendo.io.e.a aVar) {
        Options options = this.o;
        boolean z = aVar == sdk.pendo.io.e.a.RESOURCE_DISK_CACHE || this.a.o();
        sdk.pendo.io.e.g<Boolean> gVar = external.sdk.pendo.io.glide.load.resource.bitmap.b.j;
        Boolean bool = (Boolean) options.get(gVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options;
        }
        Options options2 = new Options();
        options2.putAll(this.o);
        options2.set(gVar, Boolean.valueOf(z));
        return options2;
    }

    g<R> a(external.sdk.pendo.io.glide.b bVar, Object obj, k kVar, sdk.pendo.io.e.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.c.b bVar2, sdk.pendo.io.h.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, b<R> bVar3, int i3) {
        this.a.a(bVar, obj, fVar, i, i2, aVar, cls, cls2, bVar2, options, map, z, z2, this.d);
        this.h = bVar;
        this.i = fVar;
        this.j = bVar2;
        this.k = kVar;
        this.l = i;
        this.m = i2;
        this.n = aVar;
        this.u = z3;
        this.o = options;
        this.p = bVar3;
        this.q = i3;
        this.s = EnumC0313g.INITIALIZE;
        this.v = obj;
        this.w = bVar.e();
        this.x = (Supplier) options.get(I);
        return this;
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        Log.v("DecodeJob", str + " in " + sdk.pendo.io.y.g.a(j) + ", load key: " + this.k + (str2 != null ? ", " + str2 : "") + ", thread: " + Thread.currentThread().getName());
    }

    private void a(sdk.pendo.io.h.c<R> cVar, sdk.pendo.io.e.a aVar, boolean z) {
        if (this.w.a(GlideBuilder.OverrideGlideThreadPriority.class)) {
            k();
        }
        n();
        this.p.onResourceReady(cVar, aVar, z);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.e.f fVar, Exception exc, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.e.a aVar2) {
        aVar.cleanup();
        n nVar = new n("Fetching data failed", exc);
        nVar.a(fVar, aVar2, aVar.getDataClass());
        this.b.add(nVar);
        if (Thread.currentThread() != this.y) {
            a(EnumC0313g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            l();
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.e.f fVar, Object obj, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.e.a aVar2, sdk.pendo.io.e.f fVar2) {
        this.z = fVar;
        this.B = obj;
        this.D = aVar;
        this.C = aVar2;
        this.A = fVar2;
        this.H = fVar != this.a.c().get(0);
        if (Thread.currentThread() != this.y) {
            a(EnumC0313g.DECODE_DATA);
            return;
        }
        sdk.pendo.io.z.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            d();
        } finally {
            sdk.pendo.io.z.b.a();
        }
    }

    <Z> sdk.pendo.io.h.c<Z> a(sdk.pendo.io.e.a aVar, sdk.pendo.io.h.c<Z> cVar) {
        sdk.pendo.io.h.c<Z> cVarTransform;
        Transformation<Z> transformation;
        sdk.pendo.io.e.c encodeStrategy;
        sdk.pendo.io.e.f cVar2;
        Class<?> cls = cVar.get().getClass();
        ResourceEncoder<Z> resourceEncoderA = null;
        if (aVar != sdk.pendo.io.e.a.RESOURCE_DISK_CACHE) {
            Transformation<Z> transformationB = this.a.b((Class) cls);
            transformation = transformationB;
            cVarTransform = transformationB.transform(this.h, cVar, this.l, this.m);
        } else {
            cVarTransform = cVar;
            transformation = null;
        }
        if (!cVar.equals(cVarTransform)) {
            cVar.recycle();
        }
        if (this.a.b((sdk.pendo.io.h.c<?>) cVarTransform)) {
            resourceEncoderA = this.a.a((sdk.pendo.io.h.c) cVarTransform);
            encodeStrategy = resourceEncoderA.getEncodeStrategy(this.o);
        } else {
            encodeStrategy = sdk.pendo.io.e.c.NONE;
        }
        ResourceEncoder resourceEncoder = resourceEncoderA;
        if (!this.n.a(!this.a.a(this.z), aVar, encodeStrategy)) {
            return cVarTransform;
        }
        if (resourceEncoder == null) {
            throw new Registry.NoResultEncoderAvailableException(cVarTransform.get().getClass());
        }
        int i = a.c[encodeStrategy.ordinal()];
        if (i == 1) {
            cVar2 = new external.sdk.pendo.io.glide.load.engine.c(this.z, this.i);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            cVar2 = new s(this.a.b(), this.z, this.i, this.l, this.m, transformation, cls, this.o);
        }
        q qVarB = q.b(cVarTransform);
        this.f.a(cVar2, resourceEncoder, qVarB);
        return qVarB;
    }

    void a(boolean z) {
        if (this.g.b(z)) {
            j();
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a() {
        a(EnumC0313g.SWITCH_TO_SOURCE_SERVICE);
    }

    private void a(EnumC0313g enumC0313g) {
        this.s = enumC0313g;
        this.p.a(this);
    }

    private <Data, ResourceType> sdk.pendo.io.h.c<R> a(Data data, sdk.pendo.io.e.a aVar, p<Data, ResourceType, R> pVar) {
        Options optionsA = a(aVar);
        external.sdk.pendo.io.glide.load.data.b<Data> bVarB = this.h.g().b(data);
        try {
            return pVar.a(bVarB, optionsA, this.l, this.m, new c(aVar));
        } finally {
            bVarB.cleanup();
        }
    }
}
