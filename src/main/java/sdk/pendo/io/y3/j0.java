package sdk.pendo.io.y3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class j0<T, U> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.k3.m<? extends U> b;

    static final class a<T, U> extends AtomicInteger implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final AtomicReference<sdk.pendo.io.o3.b> b = new AtomicReference<>();
        final a<T, U>.C0536a c = new C0536a();
        final sdk.pendo.io.d4.c d = new sdk.pendo.io.d4.c();

        /* JADX INFO: renamed from: sdk.pendo.io.y3.j0$a$a, reason: collision with other inner class name */
        final class C0536a extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.o<U> {
            C0536a() {
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
            public void onNext(U u) {
                sdk.pendo.io.r3.b.a(this);
                a.this.a();
            }

            @Override // sdk.pendo.io.k3.o
            public void onSubscribe(sdk.pendo.io.o3.b bVar) {
                sdk.pendo.io.r3.b.c(this, bVar);
            }
        }

        a(sdk.pendo.io.k3.o<? super T> oVar) {
            this.a = oVar;
        }

        void a() {
            sdk.pendo.io.r3.b.a(this.b);
            sdk.pendo.io.d4.h.a(this.a, this, this.d);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a(this.b);
            sdk.pendo.io.r3.b.a(this.c);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return sdk.pendo.io.r3.b.a(this.b.get());
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            sdk.pendo.io.r3.b.a(this.c);
            sdk.pendo.io.d4.h.a(this.a, this, this.d);
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            sdk.pendo.io.r3.b.a(this.c);
            sdk.pendo.io.d4.h.a((sdk.pendo.io.k3.o<?>) this.a, th, (AtomicInteger) this, this.d);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            sdk.pendo.io.d4.h.a(this.a, t, this, this.d);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this.b, bVar);
        }

        void a(Throwable th) {
            sdk.pendo.io.r3.b.a(this.b);
            sdk.pendo.io.d4.h.a((sdk.pendo.io.k3.o<?>) this.a, th, (AtomicInteger) this, this.d);
        }
    }

    public j0(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.k3.m<? extends U> mVar2) {
        super(mVar);
        this.b = mVar2;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        this.b.a(aVar.c);
        this.a.a(aVar);
    }
}
