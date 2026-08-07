package sdk.pendo.io.y3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class h0<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.k3.p b;

    static final class a<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final AtomicReference<sdk.pendo.io.o3.b> b = new AtomicReference<>();

        a(sdk.pendo.io.k3.o<? super T> oVar) {
            this.a = oVar;
        }

        void a(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this, bVar);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a(this.b);
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return sdk.pendo.io.r3.b.a(get());
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this.b, bVar);
        }
    }

    final class b implements Runnable {
        private final a<T> a;

        b(a<T> aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.this.a.a(this.a);
        }
    }

    public h0(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.k3.p pVar) {
        super(mVar);
        this.b = pVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        aVar.a(this.b.a(new b(aVar)));
    }
}
