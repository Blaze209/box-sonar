package sdk.pendo.io.s4;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.l4.r;

/* JADX INFO: loaded from: classes5.dex */
final class e<T> extends j<d<T>> {
    private final j<r<T>> a;

    private static class a<R> implements o<r<R>> {
        private final o<? super d<R>> a;

        a(o<? super d<R>> oVar) {
            this.a = oVar;
        }

        @Override // sdk.pendo.io.k3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(r<R> rVar) {
            this.a.onNext(d.a(rVar));
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            try {
                this.a.onNext(d.a(th));
                this.a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.a.onError(th2);
                } catch (Throwable th3) {
                    sdk.pendo.io.p3.b.b(th3);
                    sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th2, th3));
                }
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            this.a.onSubscribe(bVar);
        }
    }

    e(j<r<T>> jVar) {
        this.a = jVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super d<T>> oVar) {
        this.a.a(new a(oVar));
    }
}
