package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class d0<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.b<T, T, T> b;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final sdk.pendo.io.q3.b<T, T, T> b;
        sdk.pendo.io.o3.b c;
        T d;
        boolean e;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.q3.b<T, T, T> bVar) {
            this.a = oVar;
            this.b = bVar;
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
            if (this.e) {
                return;
            }
            this.e = true;
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.e) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.e = true;
                this.a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.e) {
                return;
            }
            sdk.pendo.io.k3.o<? super T> oVar = this.a;
            T t2 = this.d;
            if (t2 == null) {
                this.d = t;
                oVar.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) sdk.pendo.io.s3.b.a((Object) this.b.a(t2, t), "The value returned by the accumulator is null");
                this.d = r4;
                oVar.onNext(r4);
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

    public d0(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.b<T, T, T> bVar) {
        super(mVar);
        this.b = bVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
