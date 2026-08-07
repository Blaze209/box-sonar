package sdk.pendo.io.w3;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class j<T> extends sdk.pendo.io.w3.a<T, T> implements sdk.pendo.io.q3.e<T> {
    final sdk.pendo.io.q3.e<? super T> c;

    static final class a<T> extends AtomicLong implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super T> a;
        final sdk.pendo.io.q3.e<? super T> b;
        sdk.pendo.io.j3.c c;
        boolean d;

        a(sdk.pendo.io.j3.b<? super T> bVar, sdk.pendo.io.q3.e<? super T> eVar) {
            this.a = bVar;
            this.b = eVar;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.c, cVar)) {
                this.c = cVar;
                this.a.a(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.c.cancel();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.d) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.d = true;
                this.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (get() != 0) {
                this.a.onNext(t);
                sdk.pendo.io.d4.d.c(this, 1L);
                return;
            }
            try {
                this.b.accept(t);
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (sdk.pendo.io.c4.c.b(j)) {
                sdk.pendo.io.d4.d.a(this, j);
            }
        }
    }

    public j(sdk.pendo.io.k3.d<T> dVar) {
        super(dVar);
        this.c = this;
    }

    @Override // sdk.pendo.io.q3.e
    public void accept(T t) {
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        this.b.a((sdk.pendo.io.k3.e) new a(bVar, this.c));
    }
}
