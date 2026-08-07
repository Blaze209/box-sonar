package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class k0<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.j<? super T> b;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final sdk.pendo.io.q3.j<? super T> b;
        sdk.pendo.io.o3.b c;
        boolean d;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.q3.j<? super T> jVar) {
            this.a = oVar;
            this.b = jVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.c.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.d) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.d = true;
                this.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            try {
                if (this.b.test(t)) {
                    this.a.onNext(t);
                    return;
                }
                this.d = true;
                this.c.dispose();
                this.a.onComplete();
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.c.dispose();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public k0(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.j<? super T> jVar) {
        super(mVar);
        this.b = jVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
