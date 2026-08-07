package sdk.pendo.io.x3;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.i;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes6.dex */
public final class g<T> extends sdk.pendo.io.x3.a<T, T> {
    final p b;

    static final class a<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.h<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.r3.f a = new sdk.pendo.io.r3.f();
        final sdk.pendo.io.k3.h<? super T> b;

        a(sdk.pendo.io.k3.h<? super T> hVar) {
            this.b = hVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
            this.a.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return sdk.pendo.io.r3.b.a(get());
        }

        @Override // sdk.pendo.io.k3.h
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // sdk.pendo.io.k3.h
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // sdk.pendo.io.k3.h
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this, bVar);
        }

        @Override // sdk.pendo.io.k3.h
        public void onSuccess(T t) {
            this.b.onSuccess(t);
        }
    }

    static final class b<T> implements Runnable {
        final sdk.pendo.io.k3.h<? super T> a;
        final i<T> b;

        b(sdk.pendo.io.k3.h<? super T> hVar, i<T> iVar) {
            this.a = hVar;
            this.b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.a);
        }
    }

    public g(i<T> iVar, p pVar) {
        super(iVar);
        this.b = pVar;
    }

    @Override // sdk.pendo.io.k3.g
    protected void b(sdk.pendo.io.k3.h<? super T> hVar) {
        a aVar = new a(hVar);
        hVar.onSubscribe(aVar);
        aVar.a.a(this.b.a(new b(aVar, this.a)));
    }
}
