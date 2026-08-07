package sdk.pendo.io.w3;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends sdk.pendo.io.k3.g<T> {
    final sdk.pendo.io.k3.d<T> a;
    final long b;

    static final class a<T> implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.h<? super T> a;
        final long b;
        sdk.pendo.io.j3.c c;
        long d;
        boolean e;

        a(sdk.pendo.io.k3.h<? super T> hVar, long j) {
            this.a = hVar;
            this.b = j;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.c, cVar)) {
                this.c = cVar;
                this.a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.c.cancel();
            this.c = sdk.pendo.io.c4.c.CANCELLED;
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c == sdk.pendo.io.c4.c.CANCELLED;
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            this.c = sdk.pendo.io.c4.c.CANCELLED;
            if (this.e) {
                return;
            }
            this.e = true;
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.e) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.e = true;
            this.c = sdk.pendo.io.c4.c.CANCELLED;
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.j3.b
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
            this.c.cancel();
            this.c = sdk.pendo.io.c4.c.CANCELLED;
            this.a.onSuccess(t);
        }
    }

    public d(sdk.pendo.io.k3.d<T> dVar, long j) {
        this.a = dVar;
        this.b = j;
    }

    @Override // sdk.pendo.io.k3.g
    protected void b(sdk.pendo.io.k3.h<? super T> hVar) {
        this.a.a((sdk.pendo.io.k3.e) new a(hVar, this.b));
    }
}
