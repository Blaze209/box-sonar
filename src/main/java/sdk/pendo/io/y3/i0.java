package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class i0<T> extends sdk.pendo.io.y3.a<T, T> {
    final long b;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        boolean b;
        sdk.pendo.io.o3.b c;
        long d;

        a(sdk.pendo.io.k3.o<? super T> oVar, long j) {
            this.a = oVar;
            this.d = j;
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
            if (this.b) {
                return;
            }
            this.b = true;
            this.c.dispose();
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.b) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.b = true;
            this.c.dispose();
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            long j = this.d;
            long j2 = j - 1;
            this.d = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.c, bVar)) {
                this.c = bVar;
                if (this.d != 0) {
                    this.a.onSubscribe(this);
                    return;
                }
                this.b = true;
                bVar.dispose();
                sdk.pendo.io.r3.c.a(this.a);
            }
        }
    }

    public i0(sdk.pendo.io.k3.m<T> mVar, long j) {
        super(mVar);
        this.b = j;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
