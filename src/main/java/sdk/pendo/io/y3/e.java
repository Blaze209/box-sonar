package sdk.pendo.io.y3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class e<T> extends sdk.pendo.io.y3.a<T, T> {
    final long b;
    final TimeUnit c;
    final sdk.pendo.io.k3.p d;

    static final class a<T> extends AtomicReference<sdk.pendo.io.o3.b> implements Runnable, sdk.pendo.io.o3.b {
        final T a;
        final long b;
        final b<T> c;
        final AtomicBoolean d = new AtomicBoolean();

        a(T t, long j, b<T> bVar) {
            this.a = t;
            this.b = j;
            this.c = bVar;
        }

        public void a(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this, bVar);
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
            if (this.d.compareAndSet(false, true)) {
                this.c.a(this.b, this.a, this);
            }
        }
    }

    static final class b<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final long b;
        final TimeUnit c;
        final sdk.pendo.io.k3.p.c d;
        sdk.pendo.io.o3.b e;
        sdk.pendo.io.o3.b f;
        volatile long g;
        boolean h;

        b(sdk.pendo.io.k3.o<? super T> oVar, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p.c cVar) {
            this.a = oVar;
            this.b = j;
            this.c = timeUnit;
            this.d = cVar;
        }

        void a(long j, T t, a<T> aVar) {
            if (j == this.g) {
                this.a.onNext(t);
                aVar.dispose();
            }
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
            if (this.h) {
                return;
            }
            this.h = true;
            sdk.pendo.io.o3.b bVar = this.f;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = (a) bVar;
            if (aVar != null) {
                aVar.run();
            }
            this.a.onComplete();
            this.d.dispose();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.h) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            sdk.pendo.io.o3.b bVar = this.f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.h = true;
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            long j = this.g + 1;
            this.g = j;
            sdk.pendo.io.o3.b bVar = this.f;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = new a(t, j, this);
            this.f = aVar;
            aVar.a(this.d.a(aVar, this.b, this.c));
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.e, bVar)) {
                this.e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public e(sdk.pendo.io.k3.m<T> mVar, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p pVar) {
        super(mVar);
        this.b = j;
        this.c = timeUnit;
        this.d = pVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new b(new sdk.pendo.io.f4.b(oVar), this.b, this.c, this.d.a()));
    }
}
