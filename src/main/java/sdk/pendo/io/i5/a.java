package sdk.pendo.io.i5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class a extends Thread {
    private static a c;
    private static ExecutorService d;
    private static final Logger a = Logger.getLogger(a.class.getName());
    private static final ThreadFactory b = new ThreadFactoryC0398a();
    private static int e = 0;

    /* JADX INFO: renamed from: sdk.pendo.io.i5.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0398a implements ThreadFactory {
        ThreadFactoryC0398a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a aVar = new a(runnable);
            a.c = aVar;
            aVar.setName("EventThread");
            a.c.setDaemon(Thread.currentThread().isDaemon());
            return a.c;
        }
    }

    class b implements Runnable {
        final /* synthetic */ Runnable a;

        b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
                synchronized (a.class) {
                    int i = a.e - 1;
                    a.e = i;
                    if (i == 0) {
                        a.d.shutdown();
                        a.d = null;
                        a.c = null;
                    }
                }
            } catch (Throwable th) {
                try {
                    a.a.log(Level.SEVERE, "Task threw exception", th);
                    throw th;
                } catch (Throwable th2) {
                    synchronized (a.class) {
                        int i2 = a.e - 1;
                        a.e = i2;
                        if (i2 == 0) {
                            a.d.shutdown();
                            a.d = null;
                            a.c = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private a(Runnable runnable) {
        super(runnable);
    }

    public static void a(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public static void b(Runnable runnable) {
        ExecutorService executorService;
        synchronized (a.class) {
            e++;
            if (d == null) {
                d = Executors.newSingleThreadExecutor(b);
            }
            executorService = d;
        }
        executorService.execute(new b(runnable));
    }

    public static boolean a() {
        return Thread.currentThread() == c;
    }
}
