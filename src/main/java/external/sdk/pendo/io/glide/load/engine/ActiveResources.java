package external.sdk.pendo.io.glide.load.engine;

import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes4.dex */
final class ActiveResources {
    private final boolean a;
    private final Executor b;
    final Map<sdk.pendo.io.e.f, c> c;
    private final ReferenceQueue<m<?>> d;
    private m.a e;
    private volatile boolean f;
    private volatile DequeuedResourceCallback g;

    interface DequeuedResourceCallback {
        void a();
    }

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.engine.ActiveResources$a$a, reason: collision with other inner class name */
        class RunnableC0308a implements Runnable {
            final /* synthetic */ Runnable a;

            RunnableC0308a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0308a(runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActiveResources.this.a();
        }
    }

    static final class c extends WeakReference<m<?>> {
        final sdk.pendo.io.e.f a;
        final boolean b;
        sdk.pendo.io.h.c<?> c;

        c(sdk.pendo.io.e.f fVar, m<?> mVar, ReferenceQueue<? super m<?>> referenceQueue, boolean z) {
            super(mVar, referenceQueue);
            this.a = (sdk.pendo.io.e.f) sdk.pendo.io.y.k.a(fVar);
            this.c = (mVar.c() && z) ? (sdk.pendo.io.h.c) sdk.pendo.io.y.k.a(mVar.b()) : null;
            this.b = mVar.c();
        }

        void a() {
            this.c = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new a()));
    }

    synchronized void a(sdk.pendo.io.e.f fVar, m<?> mVar) {
        c cVarPut = this.c.put(fVar, new c(fVar, mVar, this.d, this.a));
        if (cVarPut != null) {
            cVarPut.a();
        }
    }

    synchronized m<?> b(sdk.pendo.io.e.f fVar) {
        c cVar = this.c.get(fVar);
        if (cVar == null) {
            return null;
        }
        m<?> mVar = cVar.get();
        if (mVar == null) {
            a(cVar);
        }
        return mVar;
    }

    ActiveResources(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue<>();
        this.a = z;
        this.b = executor;
        executor.execute(new b());
    }

    void a() {
        while (!this.f) {
            try {
                a((c) this.d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void b() {
        this.f = true;
        Executor executor = this.b;
        if (executor instanceof ExecutorService) {
            sdk.pendo.io.y.e.a((ExecutorService) executor);
        }
    }

    void a(c cVar) {
        sdk.pendo.io.h.c<?> cVar2;
        synchronized (this) {
            this.c.remove(cVar.a);
            if (cVar.b && (cVar2 = cVar.c) != null) {
                this.e.onResourceReleased(cVar.a, new m<>(cVar2, true, false, cVar.a, this.e));
            }
        }
    }

    synchronized void a(sdk.pendo.io.e.f fVar) {
        c cVarRemove = this.c.remove(fVar);
        if (cVarRemove != null) {
            cVarRemove.a();
        }
    }

    void a(m.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }
}
