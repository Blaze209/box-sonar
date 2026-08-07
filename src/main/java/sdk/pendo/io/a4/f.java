package sdk.pendo.io.a4;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public class f extends p.c {
    private final ScheduledExecutorService a;
    volatile boolean b;

    public f(ThreadFactory threadFactory) {
        this.a = l.a(threadFactory);
    }

    @Override // sdk.pendo.io.k3.p.c
    public sdk.pendo.io.o3.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public sdk.pendo.io.o3.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        j jVar = new j(sdk.pendo.io.g4.a.a(runnable));
        try {
            jVar.a(j <= 0 ? this.a.submit(jVar) : this.a.schedule(jVar, j, timeUnit));
            return jVar;
        } catch (RejectedExecutionException e) {
            sdk.pendo.io.g4.a.b(e);
            return sdk.pendo.io.r3.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.shutdownNow();
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this.b;
    }

    @Override // sdk.pendo.io.k3.p.c
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b ? sdk.pendo.io.r3.c.INSTANCE : a(runnable, j, timeUnit, (sdk.pendo.io.r3.a) null);
    }

    public sdk.pendo.io.o3.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable runnableA = sdk.pendo.io.g4.a.a(runnable);
        try {
            if (j2 <= 0) {
                c cVar = new c(runnableA, this.a);
                cVar.a(j <= 0 ? this.a.submit(cVar) : this.a.schedule(cVar, j, timeUnit));
                return cVar;
            }
            i iVar = new i(runnableA);
            iVar.a(this.a.scheduleAtFixedRate(iVar, j, j2, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e) {
            sdk.pendo.io.g4.a.b(e);
            return sdk.pendo.io.r3.c.INSTANCE;
        }
    }

    public k a(Runnable runnable, long j, TimeUnit timeUnit, sdk.pendo.io.r3.a aVar) {
        k kVar = new k(sdk.pendo.io.g4.a.a(runnable), aVar);
        if (aVar != null && !aVar.c(kVar)) {
            return kVar;
        }
        try {
            kVar.a(j <= 0 ? this.a.submit((Callable) kVar) : this.a.schedule((Callable) kVar, j, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e) {
            if (aVar != null) {
                aVar.a(kVar);
            }
            sdk.pendo.io.g4.a.b(e);
            return kVar;
        }
    }

    public void a() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.shutdown();
    }
}
