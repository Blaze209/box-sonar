package sdk.pendo.io.w3;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> extends sdk.pendo.io.w3.a<T, T> {

    static final class a<T> extends AtomicLong implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super T> a;
        sdk.pendo.io.j3.c b;
        boolean c;

        a(sdk.pendo.io.j3.b<? super T> bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.b, cVar)) {
                this.b = cVar;
                this.a.a(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.b.cancel();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.c) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.c = true;
                this.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (this.c) {
                return;
            }
            if (get() != 0) {
                this.a.onNext(t);
                sdk.pendo.io.d4.d.c(this, 1L);
            } else {
                this.b.cancel();
                onError(new sdk.pendo.io.p3.c("could not emit value due to lack of requests"));
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (sdk.pendo.io.c4.c.b(j)) {
                sdk.pendo.io.d4.d.a(this, j);
            }
        }
    }

    public k(sdk.pendo.io.k3.d<T> dVar) {
        super(dVar);
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        this.b.a((sdk.pendo.io.k3.e) new a(bVar));
    }
}
