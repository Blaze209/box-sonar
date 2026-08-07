package sdk.pendo.io.y3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class b0<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.h<? super sdk.pendo.io.k3.j<Throwable>, ? extends sdk.pendo.io.k3.m<?>> b;

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final sdk.pendo.io.j4.d<Throwable> d;
        final sdk.pendo.io.k3.m<T> g;
        volatile boolean h;
        final AtomicInteger b = new AtomicInteger();
        final sdk.pendo.io.d4.c c = new sdk.pendo.io.d4.c();
        final a<T>.C0533a e = new C0533a();
        final AtomicReference<sdk.pendo.io.o3.b> f = new AtomicReference<>();

        /* JADX INFO: renamed from: sdk.pendo.io.y3.b0$a$a, reason: collision with other inner class name */
        final class C0533a extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.o<Object> {
            C0533a() {
            }

            @Override // sdk.pendo.io.k3.o
            public void onComplete() {
                a.this.a();
            }

            @Override // sdk.pendo.io.k3.o
            public void onError(Throwable th) {
                a.this.a(th);
            }

            @Override // sdk.pendo.io.k3.o
            public void onNext(Object obj) {
                a.this.b();
            }

            @Override // sdk.pendo.io.k3.o
            public void onSubscribe(sdk.pendo.io.o3.b bVar) {
                sdk.pendo.io.r3.b.c(this, bVar);
            }
        }

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.j4.d<Throwable> dVar, sdk.pendo.io.k3.m<T> mVar) {
            this.a = oVar;
            this.d = dVar;
            this.g = mVar;
        }

        void a() {
            sdk.pendo.io.r3.b.a(this.f);
            sdk.pendo.io.d4.h.a(this.a, this, this.c);
        }

        void b() {
            c();
        }

        void c() {
            if (this.b.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.h) {
                        this.h = true;
                        this.g.a(this);
                    }
                    if (this.b.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a(this.f);
            sdk.pendo.io.r3.b.a(this.e);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return sdk.pendo.io.r3.b.a(this.f.get());
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            sdk.pendo.io.r3.b.a(this.e);
            sdk.pendo.io.d4.h.a(this.a, this, this.c);
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            sdk.pendo.io.r3.b.a(this.f, (sdk.pendo.io.o3.b) null);
            this.h = false;
            this.d.onNext(th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            sdk.pendo.io.d4.h.a(this.a, t, this, this.c);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.a(this.f, bVar);
        }

        void a(Throwable th) {
            sdk.pendo.io.r3.b.a(this.f);
            sdk.pendo.io.d4.h.a((sdk.pendo.io.k3.o<?>) this.a, th, (AtomicInteger) this, this.c);
        }
    }

    public b0(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.h<? super sdk.pendo.io.k3.j<Throwable>, ? extends sdk.pendo.io.k3.m<?>> hVar) {
        super(mVar);
        this.b = hVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        sdk.pendo.io.j4.d<T> dVarL = sdk.pendo.io.j4.b.m().l();
        try {
            sdk.pendo.io.k3.m mVar = (sdk.pendo.io.k3.m) sdk.pendo.io.s3.b.a(this.b.apply(dVarL), "The handler returned a null ObservableSource");
            a aVar = new a(oVar, dVarL, this.a);
            oVar.onSubscribe(aVar);
            mVar.a(aVar.e);
            aVar.c();
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.r3.c.a(th, oVar);
        }
    }
}
