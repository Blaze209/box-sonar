package sdk.pendo.io.y3;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class f<T> extends sdk.pendo.io.y3.a<T, T> {
    final long b;
    final TimeUnit c;
    final sdk.pendo.io.k3.p d;
    final boolean e;

    static final class a<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final long b;
        final TimeUnit c;
        final sdk.pendo.io.k3.p.c d;
        final boolean e;
        sdk.pendo.io.o3.b f;

        /* JADX INFO: renamed from: sdk.pendo.io.y3.f$a$a, reason: collision with other inner class name */
        final class RunnableC0534a implements Runnable {
            RunnableC0534a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.d.dispose();
                }
            }
        }

        final class b implements Runnable {
            private final Throwable a;

            b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.d.dispose();
                }
            }
        }

        final class c implements Runnable {
            private final T a;

            c(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext(this.a);
            }
        }

        a(sdk.pendo.io.k3.o<? super T> oVar, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p.c cVar, boolean z) {
            this.a = oVar;
            this.b = j;
            this.c = timeUnit;
            this.d = cVar;
            this.e = z;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.f.dispose();
            this.d.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.d.a(new RunnableC0534a(), this.b, this.c);
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.d.a(new b(th), this.e ? this.b : 0L, this.c);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            this.d.a(new c(t), this.b, this.c);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.f, bVar)) {
                this.f = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public f(sdk.pendo.io.k3.m<T> mVar, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p pVar, boolean z) {
        super(mVar);
        this.b = j;
        this.c = timeUnit;
        this.d = pVar;
        this.e = z;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(this.e ? oVar : new sdk.pendo.io.f4.b(oVar), this.b, this.c, this.d.a(), this.e));
    }
}
