package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class j<T> extends sdk.pendo.io.k3.g<T> {
    final sdk.pendo.io.k3.m<T> a;
    final long b;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.h<? super T> a;
        final long b;
        sdk.pendo.io.o3.b c;
        long d;
        boolean e;

        a(sdk.pendo.io.k3.h<? super T> hVar, long j) {
            this.a = hVar;
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

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.e) {
                return;
            }
            long j = this.d;
            if (j != this.b) {
                this.d = j + 1;
                return;
            }
            this.e = true;
            this.c.dispose();
            this.a.onSuccess(t);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public j(sdk.pendo.io.k3.m<T> mVar, long j) {
        this.a = mVar;
        this.b = j;
    }

    @Override // sdk.pendo.io.k3.g
    public void b(sdk.pendo.io.k3.h<? super T> hVar) {
        this.a.a(new a(hVar, this.b));
    }
}
