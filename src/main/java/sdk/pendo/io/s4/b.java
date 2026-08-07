package sdk.pendo.io.s4;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.l4.r;

/* JADX INFO: loaded from: classes5.dex */
final class b<T> extends j<r<T>> {
    private final sdk.pendo.io.l4.b<T> a;

    private static final class a<T> implements sdk.pendo.io.o3.b, sdk.pendo.io.l4.d<T> {
        private final sdk.pendo.io.l4.b<?> a;
        private final o<? super r<T>> b;
        boolean c = false;

        a(sdk.pendo.io.l4.b<?> bVar, o<? super r<T>> oVar) {
            this.a = bVar;
            this.b = oVar;
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> bVar, Throwable th) {
            if (bVar.isCanceled()) {
                return;
            }
            try {
                this.b.onError(th);
            } catch (Throwable th2) {
                sdk.pendo.io.p3.b.b(th2);
                sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th, th2));
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.a.cancel();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.a.isCanceled();
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> bVar, r<T> rVar) {
            if (bVar.isCanceled()) {
                return;
            }
            try {
                this.c = c.a(this.b, bVar, rVar);
            } catch (Throwable th) {
                if (this.c) {
                    sdk.pendo.io.g4.a.b(th);
                    return;
                }
                if (bVar.isCanceled()) {
                    return;
                }
                try {
                    this.b.onError(th);
                } catch (Throwable th2) {
                    sdk.pendo.io.p3.b.b(th2);
                    sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th, th2));
                }
            }
        }
    }

    b(sdk.pendo.io.l4.b<T> bVar) {
        this.a = bVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super r<T>> oVar) {
        sdk.pendo.io.l4.b<T> bVarClone = this.a.clone();
        a aVar = new a(bVarClone, oVar);
        oVar.onSubscribe(aVar);
        bVarClone.a(aVar);
    }
}
