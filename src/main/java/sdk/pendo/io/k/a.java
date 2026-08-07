package sdk.pendo.io.k;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements ExecutorService {
    private static final long b = TimeUnit.SECONDS.toMillis(10);
    private static volatile int c;
    private final ExecutorService a;

    public static final class b {
        private final boolean a;
        private int b;
        private int c;
        private ThreadFactory d = new c();
        private e e = e.d;
        private String f;
        private long g;

        b(boolean z) {
            this.a = z;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.d, this.f, this.e, this.a));
            if (this.g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new a(threadPoolExecutor);
        }

        public b a(String str) {
            this.f = str;
            return this;
        }

        public b a(int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    private static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: sdk.pendo.io.k.a$c$a, reason: collision with other inner class name */
        class C0405a extends Thread {
            C0405a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        private c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0405a(runnable);
        }
    }

    private static final class d implements ThreadFactory {
        private final ThreadFactory a;
        private final String b;
        final e c;
        final boolean d;
        private final AtomicInteger e = new AtomicInteger();

        /* JADX INFO: renamed from: sdk.pendo.io.k.a$d$a, reason: collision with other inner class name */
        class RunnableC0406a implements Runnable {
            final /* synthetic */ Runnable a;

            RunnableC0406a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.a.run();
                } catch (Throwable th) {
                    d.this.c.a(th);
                }
            }
        }

        d(ThreadFactory threadFactory, String str, e eVar, boolean z) {
            this.a = threadFactory;
            this.b = str;
            this.c = eVar;
            this.d = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.a.newThread(new RunnableC0406a(runnable));
            threadNewThread.setName("glide-" + this.b + "-thread-" + this.e.getAndIncrement());
            return threadNewThread;
        }
    }

    public interface e {
        public static final e a = new C0407a();
        public static final e b;
        public static final e c;
        public static final e d;

        /* JADX INFO: renamed from: sdk.pendo.io.k.a$e$a, reason: collision with other inner class name */
        class C0407a implements e {
            C0407a() {
            }

            @Override // sdk.pendo.io.k.a.e
            public void a(Throwable th) {
            }
        }

        class b implements e {
            b() {
            }

            @Override // sdk.pendo.io.k.a.e
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        class c implements e {
            c() {
            }

            @Override // sdk.pendo.io.k.a.e
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            b = bVar;
            c = new c();
            d = bVar;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.a = executorService;
    }

    static int a() {
        return b() >= 4 ? 2 : 1;
    }

    public static int b() {
        if (c == 0) {
            c = Math.min(4, sdk.pendo.io.k.b.a());
        }
        return c;
    }

    public static b c() {
        return new b(true).a(a()).a("animation");
    }

    public static a d() {
        return c().a();
    }

    public static b e() {
        return new b(true).a(1).a("disk-cache");
    }

    public static a f() {
        return e().a();
    }

    public static b g() {
        return new b(false).a(b()).a("source");
    }

    public static a h() {
        return g().a();
    }

    public static a i() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(callable);
    }
}
