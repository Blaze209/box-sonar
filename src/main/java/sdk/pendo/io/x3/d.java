package sdk.pendo.io.x3;

import sdk.pendo.io.k3.i;
import sdk.pendo.io.q3.j;

/* JADX INFO: loaded from: classes6.dex */
public final class d<T> extends sdk.pendo.io.x3.a<T, T> {
    final j<? super T> b;

    static final class a<T> implements sdk.pendo.io.k3.h<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.h<? super T> a;
        final j<? super T> b;
        sdk.pendo.io.o3.b c;

        a(sdk.pendo.io.k3.h<? super T> hVar, j<? super T> jVar) {
            this.a = hVar;
            this.b = jVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.o3.b bVar = this.c;
            this.c = sdk.pendo.io.r3.b.DISPOSED;
            bVar.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // sdk.pendo.io.k3.h
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.h
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.k3.h
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.k3.h
        public void onSuccess(T t) {
            try {
                boolean zTest = this.b.test(t);
                sdk.pendo.io.k3.h<? super T> hVar = this.a;
                if (zTest) {
                    hVar.onSuccess(t);
                } else {
                    hVar.onComplete();
                }
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public d(i<T> iVar, j<? super T> jVar) {
        super(iVar);
        this.b = jVar;
    }

    @Override // sdk.pendo.io.k3.g
    protected void b(sdk.pendo.io.k3.h<? super T> hVar) {
        this.a.a(new a(hVar, this.b));
    }
}
