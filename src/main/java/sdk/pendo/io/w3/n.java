package sdk.pendo.io.w3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T> extends sdk.pendo.io.w3.a<T, T> {
    final long c;
    final TimeUnit d;
    final p e;
    final sdk.pendo.io.j3.a<? extends T> f;

    static final class a<T> implements sdk.pendo.io.k3.e<T> {
        final sdk.pendo.io.j3.b<? super T> a;
        final sdk.pendo.io.c4.b b;

        a(sdk.pendo.io.j3.b<? super T> bVar, sdk.pendo.io.c4.b bVar2) {
            this.a = bVar;
            this.b = bVar2;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            this.b.b(cVar);
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            this.a.onNext(t);
        }
    }

    static final class b<T> extends sdk.pendo.io.c4.b implements sdk.pendo.io.k3.e<T>, d {
        final sdk.pendo.io.j3.b<? super T> i;
        final long j;
        final TimeUnit k;
        final p.c l;
        final sdk.pendo.io.r3.f m;
        final AtomicReference<sdk.pendo.io.j3.c> n;
        final AtomicLong o;
        long p;
        sdk.pendo.io.j3.a<? extends T> q;

        b(sdk.pendo.io.j3.b<? super T> bVar, long j, TimeUnit timeUnit, p.c cVar, sdk.pendo.io.j3.a<? extends T> aVar) {
            super(true);
            this.i = bVar;
            this.j = j;
            this.k = timeUnit;
            this.l = cVar;
            this.q = aVar;
            this.m = new sdk.pendo.io.r3.f();
            this.n = new AtomicReference<>();
            this.o = new AtomicLong();
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.n, cVar)) {
                b(cVar);
            }
        }

        void c(long j) {
            this.m.a(this.l.a(new e(j, this), this.j, this.k));
        }

        @Override // sdk.pendo.io.c4.b, sdk.pendo.io.j3.c
        public void cancel() {
            super.cancel();
            this.l.dispose();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (this.o.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.m.dispose();
                this.i.onComplete();
                this.l.dispose();
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.o.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.m.dispose();
            this.i.onError(th);
            this.l.dispose();
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            long j = this.o.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.o.compareAndSet(j, j2)) {
                    this.m.get().dispose();
                    this.p++;
                    this.i.onNext(t);
                    c(j2);
                }
            }
        }

        @Override // sdk.pendo.io.w3.n.d
        public void a(long j) {
            if (this.o.compareAndSet(j, Long.MAX_VALUE)) {
                sdk.pendo.io.c4.c.a(this.n);
                long j2 = this.p;
                if (j2 != 0) {
                    b(j2);
                }
                sdk.pendo.io.j3.a<? extends T> aVar = this.q;
                this.q = null;
                aVar.a(new a(this.i, this));
                this.l.dispose();
            }
        }
    }

    static final class c<T> extends AtomicLong implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c, d {
        final sdk.pendo.io.j3.b<? super T> a;
        final long b;
        final TimeUnit c;
        final p.c d;
        final sdk.pendo.io.r3.f e = new sdk.pendo.io.r3.f();
        final AtomicReference<sdk.pendo.io.j3.c> f = new AtomicReference<>();
        final AtomicLong g = new AtomicLong();

        c(sdk.pendo.io.j3.b<? super T> bVar, long j, TimeUnit timeUnit, p.c cVar) {
            this.a = bVar;
            this.b = j;
            this.c = timeUnit;
            this.d = cVar;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            sdk.pendo.io.c4.c.a(this.f, this.g, cVar);
        }

        void b(long j) {
            this.e.a(this.d.a(new e(j, this), this.b, this.c));
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            sdk.pendo.io.c4.c.a(this.f);
            this.d.dispose();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.e.dispose();
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.a.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            sdk.pendo.io.c4.c.a(this.f, this.g, j);
        }

        @Override // sdk.pendo.io.w3.n.d
        public void a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                sdk.pendo.io.c4.c.a(this.f);
                this.a.onError(new TimeoutException(sdk.pendo.io.d4.g.a(this.b, this.c)));
                this.d.dispose();
            }
        }
    }

    interface d {
        void a(long j);
    }

    static final class e implements Runnable {
        final d a;
        final long b;

        e(long j, d dVar) {
            this.b = j;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    public n(sdk.pendo.io.k3.d<T> dVar, long j, TimeUnit timeUnit, p pVar, sdk.pendo.io.j3.a<? extends T> aVar) {
        super(dVar);
        this.c = j;
        this.d = timeUnit;
        this.e = pVar;
        this.f = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        sdk.pendo.io.k3.e<? super T> eVar;
        if (this.f == null) {
            c cVar = new c(bVar, this.c, this.d, this.e.a());
            bVar.a(cVar);
            cVar.b(0L);
            eVar = cVar;
        } else {
            b bVar2 = new b(bVar, this.c, this.d, this.e.a(), this.f);
            bVar.a(bVar2);
            bVar2.c(0L);
            eVar = bVar2;
        }
        this.b.a((sdk.pendo.io.k3.e) eVar);
    }
}
