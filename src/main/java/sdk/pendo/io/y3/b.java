package sdk.pendo.io.y3;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T, U extends Collection<? super T>, B> extends sdk.pendo.io.y3.a<T, U> {
    final sdk.pendo.io.k3.m<B> b;
    final Callable<U> c;

    static final class a<T, U extends Collection<? super T>, B> extends sdk.pendo.io.f4.a<B> {
        final C0532b<T, U, B> b;

        a(C0532b<T, U, B> c0532b) {
            this.b = c0532b;
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(B b) {
            this.b.e();
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.y3.b$b, reason: collision with other inner class name */
    static final class C0532b<T, U extends Collection<? super T>, B> extends sdk.pendo.io.u3.g<T, U, U> implements sdk.pendo.io.o3.b {
        final Callable<U> g;
        final sdk.pendo.io.k3.m<B> h;
        sdk.pendo.io.o3.b i;
        sdk.pendo.io.o3.b j;
        U k;

        C0532b(sdk.pendo.io.k3.o<? super U> oVar, Callable<U> callable, sdk.pendo.io.k3.m<B> mVar) {
            super(oVar, new sdk.pendo.io.z3.a());
            this.g = callable;
            this.h = mVar;
        }

        @Override // sdk.pendo.io.u3.g, sdk.pendo.io.d4.j
        public /* bridge */ /* synthetic */ void a(sdk.pendo.io.k3.o oVar, Object obj) {
            a((sdk.pendo.io.k3.o<? super Collection>) oVar, (Collection) obj);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.j.dispose();
            this.i.dispose();
            if (d()) {
                this.c.clear();
            }
        }

        void e() {
            try {
                U u = (U) sdk.pendo.io.s3.b.a(this.g.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.k;
                    if (u2 == null) {
                        return;
                    }
                    this.k = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                dispose();
                this.b.onError(th);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.d;
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                this.k = null;
                this.c.offer(u);
                this.e = true;
                if (d()) {
                    sdk.pendo.io.d4.m.a((sdk.pendo.io.t3.f) this.c, (sdk.pendo.io.k3.o) this.b, false, (sdk.pendo.io.o3.b) this, (sdk.pendo.io.d4.j) this);
                }
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            dispose();
            this.b.onError(th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            synchronized (this) {
                U u = this.k;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.i, bVar)) {
                this.i = bVar;
                try {
                    this.k = (U) sdk.pendo.io.s3.b.a(this.g.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.j = aVar;
                    this.b.onSubscribe(this);
                    if (this.d) {
                        return;
                    }
                    this.h.a(aVar);
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    this.d = true;
                    bVar.dispose();
                    sdk.pendo.io.r3.c.a(th, this.b);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(sdk.pendo.io.k3.o<? super U> oVar, U u) {
            this.b.onNext((Object) u);
        }
    }

    public b(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.k3.m<B> mVar2, Callable<U> callable) {
        super(mVar);
        this.b = mVar2;
        this.c = callable;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super U> oVar) {
        this.a.a(new C0532b(new sdk.pendo.io.f4.b(oVar), this.c, this.b));
    }
}
