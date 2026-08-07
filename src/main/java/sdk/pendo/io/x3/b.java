package sdk.pendo.io.x3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.h<T>, sdk.pendo.io.o3.b {
    final sdk.pendo.io.q3.e<? super T> a;
    final sdk.pendo.io.q3.e<? super Throwable> b;
    final sdk.pendo.io.q3.a c;

    public b(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar) {
        this.a = eVar;
        this.b = eVar2;
        this.c = aVar;
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return sdk.pendo.io.r3.b.a(get());
    }

    @Override // sdk.pendo.io.k3.h
    public void onComplete() {
        lazySet(sdk.pendo.io.r3.b.DISPOSED);
        try {
            this.c.run();
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.g4.a.b(th);
        }
    }

    @Override // sdk.pendo.io.k3.h
    public void onError(Throwable th) {
        lazySet(sdk.pendo.io.r3.b.DISPOSED);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            sdk.pendo.io.p3.b.b(th2);
            sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th, th2));
        }
    }

    @Override // sdk.pendo.io.k3.h
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        sdk.pendo.io.r3.b.c(this, bVar);
    }

    @Override // sdk.pendo.io.k3.h
    public void onSuccess(T t) {
        lazySet(sdk.pendo.io.r3.b.DISPOSED);
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.g4.a.b(th);
        }
    }
}
