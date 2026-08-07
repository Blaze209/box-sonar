package sdk.pendo.io.a4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends p {
    static final h e;
    static final h f;
    static final c i;
    static boolean j;
    static final a k;
    final ThreadFactory c;
    final AtomicReference<a> d;
    private static final TimeUnit h = TimeUnit.SECONDS;
    private static final long g = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static final class a implements Runnable {
        private final long a;
        private final ConcurrentLinkedQueue<c> b;
        final sdk.pendo.io.o3.a c;
        private final ScheduledExecutorService d;
        private final Future<?> e;
        private final ThreadFactory f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.a = nanos;
            this.b = new ConcurrentLinkedQueue<>();
            this.c = new sdk.pendo.io.o3.a();
            this.f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, d.f);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.d = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.e = scheduledFutureScheduleWithFixedDelay;
        }

        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.b) {
                if (cVar.b() > jC) {
                    return;
                }
                if (this.b.remove(cVar)) {
                    this.c.a(cVar);
                }
            }
        }

        c b() {
            if (this.c.isDisposed()) {
                return d.i;
            }
            while (!this.b.isEmpty()) {
                c cVarPoll = this.b.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f);
            this.c.c(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.c.dispose();
            Future<?> future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        void a(c cVar) {
            cVar.a(c() + this.a);
            this.b.offer(cVar);
        }
    }

    static final class b extends p.c implements Runnable {
        private final a b;
        private final c c;
        final AtomicBoolean d = new AtomicBoolean();
        private final sdk.pendo.io.o3.a a = new sdk.pendo.io.o3.a();

        b(a aVar) {
            this.b = aVar;
            this.c = aVar.b();
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.a.isDisposed() ? sdk.pendo.io.r3.c.INSTANCE : this.c.a(runnable, j, timeUnit, this.a);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.d.compareAndSet(false, true)) {
                this.a.dispose();
                if (d.j) {
                    this.c.a(this, 0L, TimeUnit.NANOSECONDS, (sdk.pendo.io.r3.a) null);
                } else {
                    this.b.a(this.c);
                }
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.d.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c);
        }
    }

    static final class c extends f {
        private long c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.c = 0L;
        }

        public void a(long j) {
            this.c = j;
        }

        public long b() {
            return this.c;
        }
    }

    static {
        c cVar = new c(new h("RxCachedThreadSchedulerShutdown"));
        i = cVar;
        cVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        h hVar = new h("RxCachedThreadScheduler", iMax);
        e = hVar;
        f = new h("RxCachedWorkerPoolEvictor", iMax);
        j = Boolean.getBoolean("rx2.io-scheduled-release");
        a aVar = new a(0L, null, hVar);
        k = aVar;
        aVar.d();
    }

    public d() {
        this(e);
    }

    @Override // sdk.pendo.io.k3.p
    public p.c a() {
        return new b(this.d.get());
    }

    public void b() {
        a aVar = new a(g, h, this.c);
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.d, k, aVar)) {
            return;
        }
        aVar.d();
    }

    public d(ThreadFactory threadFactory) {
        this.c = threadFactory;
        this.d = new AtomicReference<>(k);
        b();
    }
}
