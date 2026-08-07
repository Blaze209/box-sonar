package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class g<T, U> extends sdk.pendo.io.k3.j<T> {
    final sdk.pendo.io.k3.m<? extends T> a;
    final sdk.pendo.io.k3.m<U> b;

    final class a implements sdk.pendo.io.k3.o<U> {
        final sdk.pendo.io.r3.f a;
        final sdk.pendo.io.k3.o<? super T> b;
        boolean c;

        /* JADX INFO: renamed from: sdk.pendo.io.y3.g$a$a, reason: collision with other inner class name */
        final class C0535a implements sdk.pendo.io.k3.o<T> {
            C0535a() {
            }

            @Override // sdk.pendo.io.k3.o
            public void onComplete() {
                a.this.b.onComplete();
            }

            @Override // sdk.pendo.io.k3.o
            public void onError(Throwable th) {
                a.this.b.onError(th);
            }

            @Override // sdk.pendo.io.k3.o
            public void onNext(T t) {
                a.this.b.onNext(t);
            }

            @Override // sdk.pendo.io.k3.o
            public void onSubscribe(sdk.pendo.io.o3.b bVar) {
                a.this.a.b(bVar);
            }
        }

        a(sdk.pendo.io.r3.f fVar, sdk.pendo.io.k3.o<? super T> oVar) {
            this.a = fVar;
            this.b = oVar;
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            g.this.a.a(new C0535a());
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.c) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.c = true;
                this.b.onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(U u) {
            onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            this.a.b(bVar);
        }
    }

    public g(sdk.pendo.io.k3.m<? extends T> mVar, sdk.pendo.io.k3.m<U> mVar2) {
        this.a = mVar;
        this.b = mVar2;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        sdk.pendo.io.r3.f fVar = new sdk.pendo.io.r3.f();
        oVar.onSubscribe(fVar);
        this.b.a(new a(fVar, oVar));
    }
}
