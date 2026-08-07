package external.sdk.pendo.io.glide.load.engine;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
class i<R> implements g.b<R>, sdk.pendo.io.z.a.f {
    private static final c z = new c();
    final e a;
    private final sdk.pendo.io.z.c b;
    private final m.a c;
    private final Pools.Pool<i<?>> d;
    private final c e;
    private final j f;
    private final sdk.pendo.io.k.a g;
    private final sdk.pendo.io.k.a h;
    private final sdk.pendo.io.k.a i;
    private final sdk.pendo.io.k.a j;
    private final AtomicInteger k;
    private sdk.pendo.io.e.f l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private sdk.pendo.io.h.c<?> q;
    sdk.pendo.io.e.a r;
    private boolean s;
    n t;
    private boolean u;
    m<?> v;
    private g<R> w;
    private volatile boolean x;
    private boolean y;

    private class a implements Runnable {
        private final sdk.pendo.io.u.c a;

        a(sdk.pendo.io.u.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.getLock()) {
                synchronized (i.this) {
                    if (i.this.a.a(this.a)) {
                        i.this.a(this.a);
                    }
                    i.this.c();
                }
            }
        }
    }

    private class b implements Runnable {
        private final sdk.pendo.io.u.c a;

        b(sdk.pendo.io.u.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.getLock()) {
                synchronized (i.this) {
                    if (i.this.a.a(this.a)) {
                        i.this.v.a();
                        i.this.b(this.a);
                        i.this.c(this.a);
                    }
                    i.this.c();
                }
            }
        }
    }

    static class c {
        c() {
        }

        public <R> m<R> a(sdk.pendo.io.h.c<R> cVar, boolean z, sdk.pendo.io.e.f fVar, m.a aVar) {
            return new m<>(cVar, z, true, fVar, aVar);
        }
    }

    static final class d {
        final sdk.pendo.io.u.c a;
        final Executor b;

        d(sdk.pendo.io.u.c cVar, Executor executor) {
            this.a = cVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    static final class e implements Iterable<d> {
        private final List<d> a;

        e() {
            this(new ArrayList(2));
        }

        private static d b(sdk.pendo.io.u.c cVar) {
            return new d(cVar, sdk.pendo.io.y.e.a());
        }

        void a(sdk.pendo.io.u.c cVar, Executor executor) {
            this.a.add(new d(cVar, executor));
        }

        void c(sdk.pendo.io.u.c cVar) {
            this.a.remove(b(cVar));
        }

        void clear() {
            this.a.clear();
        }

        boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.a.iterator();
        }

        int size() {
            return this.a.size();
        }

        e(List<d> list) {
            this.a = list;
        }

        boolean a(sdk.pendo.io.u.c cVar) {
            return this.a.contains(b(cVar));
        }

        e a() {
            return new e(new ArrayList(this.a));
        }
    }

    i(sdk.pendo.io.k.a aVar, sdk.pendo.io.k.a aVar2, sdk.pendo.io.k.a aVar3, sdk.pendo.io.k.a aVar4, j jVar, m.a aVar5, Pools.Pool<i<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, jVar, aVar5, pool, z);
    }

    private sdk.pendo.io.k.a d() {
        if (this.n) {
            return this.i;
        }
        return this.o ? this.j : this.h;
    }

    private boolean e() {
        return this.u || this.s || this.x;
    }

    private synchronized void i() {
        if (this.l == null) {
            throw new IllegalArgumentException();
        }
        this.a.clear();
        this.l = null;
        this.v = null;
        this.q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.y = false;
        this.w.a(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.d.release(this);
    }

    synchronized void a(sdk.pendo.io.u.c cVar, Executor executor) {
        Runnable aVar;
        this.b.b();
        this.a.a(cVar, executor);
        if (this.s) {
            a(1);
            aVar = new b(cVar);
        } else if (this.u) {
            a(1);
            aVar = new a(cVar);
        } else {
            sdk.pendo.io.y.k.a(!this.x, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(aVar);
    }

    void b(sdk.pendo.io.u.c cVar) {
        try {
            cVar.onResourceReady(this.v, this.r, this.y);
        } catch (Throwable th) {
            throw new external.sdk.pendo.io.glide.load.engine.a(th);
        }
    }

    void c() {
        m<?> mVar;
        synchronized (this) {
            this.b.b();
            sdk.pendo.io.y.k.a(e(), "Not yet complete!");
            int iDecrementAndGet = this.k.decrementAndGet();
            sdk.pendo.io.y.k.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                mVar = this.v;
                i();
            } else {
                mVar = null;
            }
        }
        if (mVar != null) {
            mVar.d();
        }
    }

    void f() {
        synchronized (this) {
            this.b.b();
            if (this.x) {
                i();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.u) {
                throw new IllegalStateException("Already failed once");
            }
            this.u = true;
            sdk.pendo.io.e.f fVar = this.l;
            e eVarA = this.a.a();
            a(eVarA.size() + 1);
            this.f.onEngineJobComplete(this, fVar, null);
            for (d dVar : eVarA) {
                dVar.b.execute(new a(dVar.a));
            }
            c();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void g() {
        synchronized (this) {
            this.b.b();
            if (this.x) {
                this.q.recycle();
                i();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.s) {
                throw new IllegalStateException("Already have resource");
            }
            this.v = this.e.a(this.q, this.m, this.l, this.c);
            this.s = true;
            e eVarA = this.a.a();
            a(eVarA.size() + 1);
            this.f.onEngineJobComplete(this, this.l, this.v);
            for (d dVar : eVarA) {
                dVar.b.execute(new b(dVar.a));
            }
            c();
        }
    }

    boolean h() {
        return this.p;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.g.b
    public void onLoadFailed(n nVar) {
        synchronized (this) {
            this.t = nVar;
        }
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // external.sdk.pendo.io.glide.load.engine.g.b
    public void onResourceReady(sdk.pendo.io.h.c<R> cVar, sdk.pendo.io.e.a aVar, boolean z2) {
        synchronized (this) {
            this.q = cVar;
            this.r = aVar;
            this.y = z2;
        }
        g();
    }

    i(sdk.pendo.io.k.a aVar, sdk.pendo.io.k.a aVar2, sdk.pendo.io.k.a aVar3, sdk.pendo.io.k.a aVar4, j jVar, m.a aVar5, Pools.Pool<i<?>> pool, c cVar) {
        this.a = new e();
        this.b = sdk.pendo.io.z.c.a();
        this.k = new AtomicInteger();
        this.g = aVar;
        this.h = aVar2;
        this.i = aVar3;
        this.j = aVar4;
        this.f = jVar;
        this.c = aVar5;
        this.d = pool;
        this.e = cVar;
    }

    void a(sdk.pendo.io.u.c cVar) {
        try {
            cVar.onLoadFailed(this.t);
        } catch (Throwable th) {
            throw new external.sdk.pendo.io.glide.load.engine.a(th);
        }
    }

    @Override // sdk.pendo.io.z.a.f
    public sdk.pendo.io.z.c b() {
        return this.b;
    }

    synchronized void c(sdk.pendo.io.u.c cVar) {
        this.b.b();
        this.a.c(cVar);
        if (this.a.isEmpty()) {
            a();
            if ((this.s || this.u) && this.k.get() == 0) {
                i();
            }
        }
    }

    void a() {
        if (e()) {
            return;
        }
        this.x = true;
        this.w.c();
        this.f.onEngineJobCancelled(this, this.l);
    }

    public synchronized void b(g<R> gVar) {
        this.w = gVar;
        (gVar.o() ? this.g : d()).execute(gVar);
    }

    synchronized void a(int i) {
        m<?> mVar;
        sdk.pendo.io.y.k.a(e(), "Not yet complete!");
        if (this.k.getAndAdd(i) == 0 && (mVar = this.v) != null) {
            mVar.a();
        }
    }

    synchronized i<R> a(sdk.pendo.io.e.f fVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.l = fVar;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        return this;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.g.b
    public void a(g<?> gVar) {
        d().execute(gVar);
    }
}
