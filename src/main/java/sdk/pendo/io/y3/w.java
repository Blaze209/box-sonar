package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class w<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.h<? super Throwable, ? extends T> b;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final sdk.pendo.io.q3.h<? super Throwable, ? extends T> b;
        sdk.pendo.io.o3.b c;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.q3.h<? super Throwable, ? extends T> hVar) {
            this.a = oVar;
            this.b = hVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.c.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            try {
                T tApply = this.b.apply(th);
                if (tApply != null) {
                    this.a.onNext(tApply);
                    this.a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.a.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                sdk.pendo.io.p3.b.b(th2);
                this.a.onError(new sdk.pendo.io.p3.a(th, th2));
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public w(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.h<? super Throwable, ? extends T> hVar) {
        super(mVar);
        this.b = hVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
