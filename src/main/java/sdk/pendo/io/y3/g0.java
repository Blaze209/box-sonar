package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class g0<T> extends sdk.pendo.io.y3.a<T, T> {
    final long b;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        long b;
        sdk.pendo.io.o3.b c;

        a(sdk.pendo.io.k3.o<? super T> oVar, long j) {
            this.a = oVar;
            this.b = j;
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
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            long j = this.b;
            if (j != 0) {
                this.b = j - 1;
            } else {
                this.a.onNext(t);
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

    public g0(sdk.pendo.io.k3.m<T> mVar, long j) {
        super(mVar);
        this.b = j;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
