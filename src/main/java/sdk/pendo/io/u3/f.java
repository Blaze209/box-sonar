package sdk.pendo.io.u3;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends AtomicReference<sdk.pendo.io.o3.b> implements o<T>, sdk.pendo.io.o3.b {
    final sdk.pendo.io.q3.e<? super T> a;
    final sdk.pendo.io.q3.e<? super Throwable> b;
    final sdk.pendo.io.q3.a c;
    final sdk.pendo.io.q3.e<? super sdk.pendo.io.o3.b> d;

    public f(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar, sdk.pendo.io.q3.e<? super sdk.pendo.io.o3.b> eVar3) {
        this.a = eVar;
        this.b = eVar2;
        this.c = aVar;
        this.d = eVar3;
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return get() == sdk.pendo.io.r3.b.DISPOSED;
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(sdk.pendo.io.r3.b.DISPOSED);
        try {
            this.c.run();
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.g4.a.b(th);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        if (isDisposed()) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        lazySet(sdk.pendo.io.r3.b.DISPOSED);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            sdk.pendo.io.p3.b.b(th2);
            sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th, th2));
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        if (sdk.pendo.io.r3.b.c(this, bVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
