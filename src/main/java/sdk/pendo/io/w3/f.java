package sdk.pendo.io.w3;

import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends sdk.pendo.io.k3.d<T> {
    private final sdk.pendo.io.k3.j<T> b;

    static final class a<T> implements o<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super T> a;
        sdk.pendo.io.o3.b b;

        a(sdk.pendo.io.j3.b<? super T> bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.b.dispose();
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
            this.a.onNext(t);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            this.b = bVar;
            this.a.a(this);
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
        }
    }

    public f(sdk.pendo.io.k3.j<T> jVar) {
        this.b = jVar;
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        this.b.a((o) new a(bVar));
    }
}
