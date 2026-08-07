package io.opentelemetry.instrumentation.api.internal.cache.weaklockfree;

/* JADX INFO: loaded from: classes4.dex */
public final class WeakConcurrentMapCleaner {
    private static Thread thread;

    private WeakConcurrentMapCleaner() {
    }

    public static synchronized void start() {
        if (thread != null) {
            return;
        }
        Thread thread2 = new Thread(new Runnable() { // from class: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMapCleaner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractWeakConcurrentMap.runCleanup();
            }
        }, "weak-ref-cleaner");
        thread = thread2;
        thread2.setDaemon(true);
        thread.setContextClassLoader(null);
        thread.start();
    }

    public static synchronized void stop() {
        Thread thread2 = thread;
        if (thread2 == null) {
            return;
        }
        thread2.interrupt();
        thread = null;
    }
}
