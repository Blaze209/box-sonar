package sdk.pendo.io.a4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends p {
    static final C0342b e;
    static final h f;
    static final int g = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c h;
    final ThreadFactory c;
    final AtomicReference<C0342b> d;

    static final class a extends p.c {
        private final sdk.pendo.io.r3.d a;
        private final sdk.pendo.io.o3.a b;
        private final sdk.pendo.io.r3.d c;
        private final c d;
        volatile boolean e;

        a(c cVar) {
            this.d = cVar;
            sdk.pendo.io.r3.d dVar = new sdk.pendo.io.r3.d();
            this.a = dVar;
            sdk.pendo.io.o3.a aVar = new sdk.pendo.io.o3.a();
            this.b = aVar;
            sdk.pendo.io.r3.d dVar2 = new sdk.pendo.io.r3.d();
            this.c = dVar2;
            dVar2.c(dVar);
            dVar2.c(aVar);
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable) {
            return this.e ? sdk.pendo.io.r3.c.INSTANCE : this.d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.c.dispose();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.e;
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.e ? sdk.pendo.io.r3.c.INSTANCE : this.d.a(runnable, j, timeUnit, this.b);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.a4.b$b, reason: collision with other inner class name */
    static final class C0342b {
        final int a;
        final c[] b;
        long c;

        C0342b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return b.h;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }
    }

    static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new h("RxComputationShutdown"));
        h = cVar;
        cVar.dispose();
        h hVar = new h("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f = hVar;
        C0342b c0342b = new C0342b(0, hVar);
        e = c0342b;
        c0342b.b();
    }

    public b() {
        this(f);
    }

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    public void b() {
        C0342b c0342b = new C0342b(g, this.c);
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.d, e, c0342b)) {
            return;
        }
        c0342b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.c = threadFactory;
        this.d = new AtomicReference<>(e);
        b();
    }

    @Override // sdk.pendo.io.k3.p
    public p.c a() {
        return new a(this.d.get().a());
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.d.get().a().b(runnable, j, timeUnit);
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.d.get().a().b(runnable, j, j2, timeUnit);
    }
}
