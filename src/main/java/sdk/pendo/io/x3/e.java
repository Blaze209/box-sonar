package sdk.pendo.io.x3;

import sdk.pendo.io.k3.i;

/* JADX INFO: loaded from: classes6.dex */
public final class e<T, R> extends sdk.pendo.io.x3.a<T, R> {
    final sdk.pendo.io.q3.h<? super T, ? extends R> b;

    static final class a<T, R> implements sdk.pendo.io.k3.h<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.h<? super R> a;
        final sdk.pendo.io.q3.h<? super T, ? extends R> b;
        sdk.pendo.io.o3.b c;

        a(sdk.pendo.io.k3.h<? super R> hVar, sdk.pendo.io.q3.h<? super T, ? extends R> hVar2) {
            this.a = hVar;
            this.b = hVar2;
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
                this.a.onSuccess(sdk.pendo.io.s3.b.a(this.b.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public e(i<T> iVar, sdk.pendo.io.q3.h<? super T, ? extends R> hVar) {
        super(iVar);
        this.b = hVar;
    }

    @Override // sdk.pendo.io.k3.g
    protected void b(sdk.pendo.io.k3.h<? super R> hVar) {
        this.a.a(new a(hVar, this.b));
    }
}
