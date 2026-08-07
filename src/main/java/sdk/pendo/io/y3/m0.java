package sdk.pendo.io.y3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class m0 extends sdk.pendo.io.k3.j<Long> {
    final sdk.pendo.io.k3.p a;
    final long b;
    final TimeUnit c;

    static final class a extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.o3.b, Runnable {
        final sdk.pendo.io.k3.o<? super Long> a;

        a(sdk.pendo.io.k3.o<? super Long> oVar) {
            this.a = oVar;
        }

        public void a(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.d(this, bVar);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() == sdk.pendo.io.r3.b.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.a.onNext(0L);
            lazySet(sdk.pendo.io.r3.c.INSTANCE);
            this.a.onComplete();
        }
    }

    public m0(long j, TimeUnit timeUnit, sdk.pendo.io.k3.p pVar) {
        this.b = j;
        this.c = timeUnit;
        this.a = pVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super Long> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        aVar.a(this.a.a(aVar, this.b, this.c));
    }
}
