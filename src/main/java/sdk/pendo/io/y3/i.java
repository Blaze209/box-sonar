package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class i<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.e<? super T> b;
    final sdk.pendo.io.q3.e<? super Throwable> c;
    final sdk.pendo.io.q3.a d;
    final sdk.pendo.io.q3.a e;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final sdk.pendo.io.q3.e<? super T> b;
        final sdk.pendo.io.q3.e<? super Throwable> c;
        final sdk.pendo.io.q3.a d;
        final sdk.pendo.io.q3.a e;
        sdk.pendo.io.o3.b f;
        boolean g;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar, sdk.pendo.io.q3.a aVar2) {
            this.a = oVar;
            this.b = eVar;
            this.c = eVar2;
            this.d = aVar;
            this.e = aVar2;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.f.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.g) {
                return;
            }
            try {
                this.d.run();
                this.g = true;
                this.a.onComplete();
                try {
                    this.e.run();
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    sdk.pendo.io.g4.a.b(th);
                }
            } catch (Throwable th2) {
                sdk.pendo.io.p3.b.b(th2);
                onError(th2);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.g) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.g = true;
            try {
                this.c.accept(th);
            } catch (Throwable th2) {
                sdk.pendo.io.p3.b.b(th2);
                th = new sdk.pendo.io.p3.a(th, th2);
            }
            this.a.onError(th);
            try {
                this.e.run();
            } catch (Throwable th3) {
                sdk.pendo.io.p3.b.b(th3);
                sdk.pendo.io.g4.a.b(th3);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                this.b.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.f.dispose();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.f, bVar)) {
                this.f = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar, sdk.pendo.io.q3.a aVar2) {
        super(mVar);
        this.b = eVar;
        this.c = eVar2;
        this.d = aVar;
        this.e = aVar2;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b, this.c, this.d, this.e));
    }
}
