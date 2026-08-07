package sdk.pendo.io.b4;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.e;

/* JADX INFO: loaded from: classes4.dex */
public final class c<T> extends AtomicReference<sdk.pendo.io.j3.c> implements e<T>, sdk.pendo.io.j3.c, sdk.pendo.io.o3.b {
    final sdk.pendo.io.q3.e<? super T> a;
    final sdk.pendo.io.q3.e<? super Throwable> b;
    final sdk.pendo.io.q3.a c;
    final sdk.pendo.io.q3.e<? super sdk.pendo.io.j3.c> d;

    public c(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar, sdk.pendo.io.q3.e<? super sdk.pendo.io.j3.c> eVar3) {
        this.a = eVar;
        this.b = eVar2;
        this.c = aVar;
        this.d = eVar3;
    }

    @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
    public void a(sdk.pendo.io.j3.c cVar) {
        if (sdk.pendo.io.c4.c.a((AtomicReference<sdk.pendo.io.j3.c>) this, cVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // sdk.pendo.io.j3.c
    public void cancel() {
        sdk.pendo.io.c4.c.a(this);
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        cancel();
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return get() == sdk.pendo.io.c4.c.CANCELLED;
    }

    @Override // sdk.pendo.io.j3.b
    public void onComplete() {
        sdk.pendo.io.j3.c cVar = get();
        sdk.pendo.io.c4.c cVar2 = sdk.pendo.io.c4.c.CANCELLED;
        if (cVar != cVar2) {
            lazySet(cVar2);
            try {
                this.c.run();
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                sdk.pendo.io.g4.a.b(th);
            }
        }
    }

    @Override // sdk.pendo.io.j3.b
    public void onError(Throwable th) {
        sdk.pendo.io.j3.c cVar = get();
        sdk.pendo.io.c4.c cVar2 = sdk.pendo.io.c4.c.CANCELLED;
        if (cVar == cVar2) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        lazySet(cVar2);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            sdk.pendo.io.p3.b.b(th2);
            sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.a(th, th2));
        }
    }

    @Override // sdk.pendo.io.j3.b
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // sdk.pendo.io.j3.c
    public void request(long j) {
        get().request(j);
    }
}
