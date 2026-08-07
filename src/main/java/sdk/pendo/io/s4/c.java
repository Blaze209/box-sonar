package sdk.pendo.io.s4;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.l4.h;
import sdk.pendo.io.l4.r;

/* JADX INFO: loaded from: classes5.dex */
final class c<T> extends j<r<T>> {
    private final sdk.pendo.io.l4.b<T> a;

    private static final class a implements sdk.pendo.io.o3.b {
        private final sdk.pendo.io.l4.b<?> a;

        a(sdk.pendo.io.l4.b<?> bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.a.cancel();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.a.isCanceled();
        }
    }

    c(sdk.pendo.io.l4.b<T> bVar) {
        this.a = bVar;
    }

    static <T> boolean a(o<? super r<T>> oVar, sdk.pendo.io.l4.b<T> bVar, r<T> rVar) {
        if (!bVar.isCanceled()) {
            if (rVar == null || !(rVar.d() || sdk.pendo.io.s7.a.a.a(rVar.b()))) {
                h hVar = new h(rVar);
                try {
                    oVar.onError(hVar);
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(hVar, th));
                }
                return true;
            }
            oVar.onNext(rVar);
            if (!bVar.isCanceled()) {
                oVar.onComplete();
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super r<T>> oVar) {
        sdk.pendo.io.l4.b<T> bVarClone = this.a.clone();
        oVar.onSubscribe(new a(bVarClone));
        try {
            a(oVar, bVarClone, bVarClone.execute());
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            if (bVarClone.isCanceled()) {
                return;
            }
            try {
                oVar.onError(th);
            } catch (Throwable th2) {
                sdk.pendo.io.p3.b.b(th2);
                sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th, th2));
            }
        }
    }
}
