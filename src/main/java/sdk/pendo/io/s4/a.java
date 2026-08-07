package sdk.pendo.io.s4;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.l4.h;
import sdk.pendo.io.l4.r;

/* JADX INFO: loaded from: classes5.dex */
final class a<T> extends j<T> {
    private final j<r<T>> a;

    /* JADX INFO: renamed from: sdk.pendo.io.s4.a$a, reason: collision with other inner class name */
    private static class C0477a<R> implements o<r<R>> {
        private final o<? super R> a;
        private boolean b;

        C0477a(o<? super R> oVar) {
            this.a = oVar;
        }

        @Override // sdk.pendo.io.k3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(r<R> rVar) {
            if (rVar.d()) {
                this.a.onNext(rVar.a());
                return;
            }
            this.b = true;
            h hVar = new h(rVar);
            try {
                this.a.onError(hVar);
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(hVar, th));
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.b) {
                return;
            }
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (!this.b) {
                this.a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            sdk.pendo.io.g4.a.b(assertionError);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            this.a.onSubscribe(bVar);
        }
    }

    a(j<r<T>> jVar) {
        this.a = jVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super T> oVar) {
        this.a.a(new C0477a(oVar));
    }
}
