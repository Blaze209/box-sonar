package sdk.pendo.io.a4;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends p {
    private static final n c = new n();

    static final class a implements Runnable {
        private final Runnable a;
        private final c b;
        private final long c;

        a(Runnable runnable, c cVar, long j) {
            this.a = runnable;
            this.b = cVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.d) {
                return;
            }
            long jA = this.b.a(TimeUnit.MILLISECONDS);
            long j = this.c;
            if (j > jA) {
                try {
                    Thread.sleep(j - jA);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    sdk.pendo.io.g4.a.b(e);
                    return;
                }
            }
            if (this.b.d) {
                return;
            }
            this.a.run();
        }
    }

    static final class b implements Comparable<b> {
        final Runnable a;
        final long b;
        final int c;
        volatile boolean d;

        b(Runnable runnable, Long l, int i) {
            this.a = runnable;
            this.b = l.longValue();
            this.c = i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iA = sdk.pendo.io.s3.b.a(this.b, bVar.b);
            return iA == 0 ? sdk.pendo.io.s3.b.a(this.c, bVar.c) : iA;
        }
    }

    static final class c extends p.c {
        final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();
        private final AtomicInteger b = new AtomicInteger();
        final AtomicInteger c = new AtomicInteger();
        volatile boolean d;

        final class a implements Runnable {
            final b a;

            a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.d = true;
                c.this.a.remove(this.a);
            }
        }

        c() {
        }

        sdk.pendo.io.o3.b a(Runnable runnable, long j) {
            if (this.d) {
                return sdk.pendo.io.r3.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.c.incrementAndGet());
            this.a.add(bVar);
            if (this.b.getAndIncrement() != 0) {
                return sdk.pendo.io.o3.c.a(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.d) {
                b bVarPoll = this.a.poll();
                if (bVarPoll == null) {
                    iAddAndGet = this.b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return sdk.pendo.io.r3.c.INSTANCE;
                    }
                } else if (!bVarPoll.d) {
                    bVarPoll.a.run();
                }
            }
            this.a.clear();
            return sdk.pendo.io.r3.c.INSTANCE;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.d = true;
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.d;
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, jA), jA);
        }
    }

    n() {
    }

    public static n b() {
        return c;
    }

    @Override // sdk.pendo.io.k3.p
    public p.c a() {
        return new c();
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable) {
        sdk.pendo.io.g4.a.a(runnable).run();
        return sdk.pendo.io.r3.c.INSTANCE;
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            sdk.pendo.io.g4.a.a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            sdk.pendo.io.g4.a.b(e);
        }
        return sdk.pendo.io.r3.c.INSTANCE;
    }
}
