package sdk.pendo.io.b4;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.d4.h;
import sdk.pendo.io.k3.e;

/* JADX INFO: loaded from: classes4.dex */
public class d<T> extends AtomicInteger implements e<T>, sdk.pendo.io.j3.c {
    final sdk.pendo.io.j3.b<? super T> a;
    final sdk.pendo.io.d4.c b = new sdk.pendo.io.d4.c();
    final AtomicLong c = new AtomicLong();
    final AtomicReference<sdk.pendo.io.j3.c> d = new AtomicReference<>();
    final AtomicBoolean e = new AtomicBoolean();
    volatile boolean f;

    public d(sdk.pendo.io.j3.b<? super T> bVar) {
        this.a = bVar;
    }

    @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
    public void a(sdk.pendo.io.j3.c cVar) {
        if (this.e.compareAndSet(false, true)) {
            this.a.a(this);
            sdk.pendo.io.c4.c.a(this.d, this.c, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // sdk.pendo.io.j3.c
    public void cancel() {
        if (this.f) {
            return;
        }
        sdk.pendo.io.c4.c.a(this.d);
    }

    @Override // sdk.pendo.io.j3.b
    public void onComplete() {
        this.f = true;
        h.a(this.a, this, this.b);
    }

    @Override // sdk.pendo.io.j3.b
    public void onError(Throwable th) {
        this.f = true;
        h.a((sdk.pendo.io.j3.b<?>) this.a, th, (AtomicInteger) this, this.b);
    }

    @Override // sdk.pendo.io.j3.b
    public void onNext(T t) {
        h.a(this.a, t, this, this.b);
    }

    @Override // sdk.pendo.io.j3.c
    public void request(long j) {
        if (j > 0) {
            sdk.pendo.io.c4.c.a(this.d, this.c, j);
        } else {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
        }
    }
}
