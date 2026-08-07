package sdk.pendo.io.k3;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p {
    static boolean a = Boolean.getBoolean("rx2.scheduler.use-nanotime");
    static final long b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class a implements sdk.pendo.io.o3.b, Runnable {
        final Runnable a;
        final c b;
        Thread c;

        a(Runnable runnable, c cVar) {
            this.a = runnable;
            this.b = cVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                c cVar = this.b;
                if (cVar instanceof sdk.pendo.io.a4.f) {
                    ((sdk.pendo.io.a4.f) cVar).a();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.c = null;
            }
        }
    }

    static final class b implements sdk.pendo.io.o3.b, Runnable {
        final Runnable a;
        final c b;
        volatile boolean c;

        b(Runnable runnable, c cVar) {
            this.a = runnable;
            this.b = cVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            try {
                this.a.run();
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.b.dispose();
                throw sdk.pendo.io.d4.g.a(th);
            }
        }
    }

    public static abstract class c implements sdk.pendo.io.o3.b {

        final class a implements Runnable {
            final Runnable a;
            final sdk.pendo.io.r3.f b;
            final long c;
            long d;
            long e;
            long f;

            a(long j, Runnable runnable, long j2, sdk.pendo.io.r3.f fVar, long j3) {
                this.a = runnable;
                this.b = fVar;
                this.c = j3;
                this.e = j2;
                this.f = j;
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0034  */
            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.a.run();
                if (this.b.isDisposed()) {
                    return;
                }
                c cVar = c.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jA = cVar.a(timeUnit);
                long j2 = p.b;
                long j3 = jA + j2;
                long j4 = this.e;
                if (j3 >= j4) {
                    long j5 = this.c;
                    if (jA >= j4 + j5 + j2) {
                        long j6 = this.c;
                        long j7 = jA + j6;
                        long j8 = this.d + 1;
                        this.d = j8;
                        this.f = j7 - (j6 * j8);
                        j = j7;
                    } else {
                        long j9 = this.f;
                        long j10 = this.d + 1;
                        this.d = j10;
                        j = j9 + (j10 * j5);
                    }
                } else {
                    long j11 = this.c;
                    long j12 = jA + j11;
                    long j13 = this.d + 1;
                    this.d = j13;
                    this.f = j12 - (j11 * j13);
                    j = j12;
                }
                this.e = jA;
                this.b.a(c.this.a(this, j - jA, timeUnit));
            }
        }

        public long a(TimeUnit timeUnit) {
            return p.a(timeUnit);
        }

        public abstract sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public sdk.pendo.io.o3.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public sdk.pendo.io.o3.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            sdk.pendo.io.r3.f fVar = new sdk.pendo.io.r3.f();
            sdk.pendo.io.r3.f fVar2 = new sdk.pendo.io.r3.f(fVar);
            Runnable runnableA = sdk.pendo.io.g4.a.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long jA = a(TimeUnit.NANOSECONDS);
            sdk.pendo.io.o3.b bVarA = a(new a(jA + timeUnit.toNanos(j), runnableA, jA, fVar2, nanos), j, timeUnit);
            if (bVarA == sdk.pendo.io.r3.c.INSTANCE) {
                return bVarA;
            }
            fVar.a(bVarA);
            return fVar2;
        }
    }

    static long a(TimeUnit timeUnit) {
        long jNanoTime;
        TimeUnit timeUnit2;
        if (a) {
            jNanoTime = System.nanoTime();
            timeUnit2 = TimeUnit.NANOSECONDS;
        } else {
            jNanoTime = System.currentTimeMillis();
            timeUnit2 = TimeUnit.MILLISECONDS;
        }
        return timeUnit.convert(jNanoTime, timeUnit2);
    }

    public abstract c a();

    public sdk.pendo.io.o3.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        c cVarA = a();
        a aVar = new a(sdk.pendo.io.g4.a.a(runnable), cVarA);
        cVarA.a(aVar, j, timeUnit);
        return aVar;
    }

    public sdk.pendo.io.o3.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c cVarA = a();
        b bVar = new b(sdk.pendo.io.g4.a.a(runnable), cVarA);
        sdk.pendo.io.o3.b bVarA = cVarA.a(bVar, j, j2, timeUnit);
        return bVarA == sdk.pendo.io.r3.c.INSTANCE ? bVarA : bVar;
    }
}
