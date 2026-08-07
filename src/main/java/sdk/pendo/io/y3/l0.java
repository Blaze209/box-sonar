package sdk.pendo.io.y3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class l0<T> extends sdk.pendo.io.y3.a<T, T> {
    final long b;
    final TimeUnit c;
    final sdk.pendo.io.k3.p d;

    static final class a<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b, Runnable {
        final sdk.pendo.io.k3.o<? super T> a;
        final long b;
        final TimeUnit c;
        final sdk.pendo.io.k3.p.c d;
        sdk.pendo.io.o3.b e;
        volatile boolean f;
        boolean g;

        a(sdk.pendo.io.k3.o<? super T> oVar, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p.c cVar) {
            this.a = oVar;
            this.b = j;
            this.c = timeUnit;
            this.d = cVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.e.dispose();
            this.d.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.a.onComplete();
            this.d.dispose();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.g) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.g = true;
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.f || this.g) {
                return;
            }
            this.f = true;
            this.a.onNext(t);
            sdk.pendo.io.o3.b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this, this.d.a(this, this.b, this.c));
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.e, bVar)) {
                this.e = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f = false;
        }
    }

    public l0(sdk.pendo.io.k3.m<T> mVar, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p pVar) {
        super(mVar);
        this.b = j;
        this.c = timeUnit;
        this.d = pVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(new sdk.pendo.io.f4.b(oVar), this.b, this.c, this.d.a()));
    }
}
