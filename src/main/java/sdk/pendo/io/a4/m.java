package sdk.pendo.io.a4;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends p {
    static final h e;
    static final ScheduledExecutorService f;
    final ThreadFactory c;
    final AtomicReference<ScheduledExecutorService> d;

    static final class a extends p.c {
        final ScheduledExecutorService a;
        final sdk.pendo.io.o3.a b = new sdk.pendo.io.o3.a();
        volatile boolean c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.c) {
                return sdk.pendo.io.r3.c.INSTANCE;
            }
            k kVar = new k(sdk.pendo.io.g4.a.a(runnable), this.b);
            this.b.c(kVar);
            try {
                kVar.a(j <= 0 ? this.a.submit((Callable) kVar) : this.a.schedule((Callable) kVar, j, timeUnit));
                return kVar;
            } catch (RejectedExecutionException e) {
                dispose();
                sdk.pendo.io.g4.a.b(e);
                return sdk.pendo.io.r3.c.INSTANCE;
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        e = new h("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public m() {
        this(e);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return l.a(threadFactory);
    }

    public m(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.d = atomicReference;
        this.c = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }

    @Override // sdk.pendo.io.k3.p
    public p.c a() {
        return new a(this.d.get());
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        j jVar = new j(sdk.pendo.io.g4.a.a(runnable));
        try {
            jVar.a(j <= 0 ? this.d.get().submit(jVar) : this.d.get().schedule(jVar, j, timeUnit));
            return jVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.g4.a.b(e2);
            return sdk.pendo.io.r3.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable runnableA = sdk.pendo.io.g4.a.a(runnable);
        try {
            if (j2 > 0) {
                i iVar = new i(runnableA);
                iVar.a(this.d.get().scheduleAtFixedRate(iVar, j, j2, timeUnit));
                return iVar;
            }
            ScheduledExecutorService scheduledExecutorService = this.d.get();
            c cVar = new c(runnableA, scheduledExecutorService);
            cVar.a(j <= 0 ? scheduledExecutorService.submit(cVar) : scheduledExecutorService.schedule(cVar, j, timeUnit));
            return cVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.g4.a.b(e2);
            return sdk.pendo.io.r3.c.INSTANCE;
        }
    }
}
