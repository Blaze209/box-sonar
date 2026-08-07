package sdk.pendo.io.w3;

import java.util.concurrent.TimeUnit;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> extends sdk.pendo.io.w3.a<T, T> {
    final long c;
    final TimeUnit d;
    final p e;
    final boolean f;

    static final class a<T> implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super T> a;
        final long b;
        final TimeUnit c;
        final p.c d;
        final boolean e;
        sdk.pendo.io.j3.c f;

        /* JADX INFO: renamed from: sdk.pendo.io.w3.c$a$a, reason: collision with other inner class name */
        final class RunnableC0507a implements Runnable {
            RunnableC0507a() {
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

        /* JADX INFO: renamed from: sdk.pendo.io.w3.c$a$c, reason: collision with other inner class name */
        final class RunnableC0508c implements Runnable {
            private final T a;

            RunnableC0508c(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext(this.a);
            }
        }

        a(sdk.pendo.io.j3.b<? super T> bVar, long j, TimeUnit timeUnit, p.c cVar, boolean z) {
            this.a = bVar;
            this.b = j;
            this.c = timeUnit;
            this.d = cVar;
            this.e = z;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.f, cVar)) {
                this.f = cVar;
                this.a.a(this);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.f.cancel();
            this.d.dispose();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            this.d.a(new RunnableC0507a(), this.b, this.c);
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            this.d.a(new b(th), this.e ? this.b : 0L, this.c);
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            this.d.a(new RunnableC0508c(t), this.b, this.c);
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            this.f.request(j);
        }
    }

    public c(sdk.pendo.io.k3.d<T> dVar, long j, TimeUnit timeUnit, p pVar, boolean z) {
        super(dVar);
        this.c = j;
        this.d = timeUnit;
        this.e = pVar;
        this.f = z;
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        this.b.a((sdk.pendo.io.k3.e) new a(this.f ? bVar : new sdk.pendo.io.k4.a(bVar), this.c, this.d, this.e.a(), this.f));
    }
}
