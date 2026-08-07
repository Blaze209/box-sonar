package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class e0<T> extends sdk.pendo.io.k3.g<T> {
    final sdk.pendo.io.k3.m<T> a;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.h<? super T> a;
        sdk.pendo.io.o3.b b;
        T c;
        boolean d;

        a(sdk.pendo.io.k3.h<? super T> hVar) {
            this.a = hVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.b.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            T t = this.c;
            this.c = null;
            sdk.pendo.io.k3.h<? super T> hVar = this.a;
            if (t == null) {
                hVar.onComplete();
            } else {
                hVar.onSuccess(t);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.d) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.d = true;
                this.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.c == null) {
                this.c = t;
                return;
            }
            this.d = true;
            this.b.dispose();
            this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public e0(sdk.pendo.io.k3.m<T> mVar) {
        this.a = mVar;
    }

    @Override // sdk.pendo.io.k3.g
    public void b(sdk.pendo.io.k3.h<? super T> hVar) {
        this.a.a(new a(hVar));
    }
}
