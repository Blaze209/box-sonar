package io.split.android.client.events;

import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.scheduler.PausableThreadPoolExecutorImpl;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseEventsManager implements Runnable {
    private static final ThreadFactory EVENTS_THREAD_FACTORY = createThreadFactory();
    private static final int QUEUE_CAPACITY = 20;
    protected final ArrayBlockingQueue<SplitInternalEvent> mQueue = new ArrayBlockingQueue<>(20);
    protected final Set<SplitInternalEvent> mTriggered = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void notifyInternalEvent(SplitInternalEvent event);

    protected abstract void triggerEventsWhenAreAvailable();

    private static ThreadFactory createThreadFactory() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        return new ThreadFactory() { // from class: io.split.android.client.events.BaseEventsManager.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "Split-FactoryEventsManager-" + atomicInteger.getAndIncrement());
                thread.setDaemon(true);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.split.android.client.events.BaseEventsManager.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread t, Throwable e) {
                        Logger.e("Unexpected error " + e.getLocalizedMessage());
                    }
                });
                return thread;
            }
        };
    }

    public BaseEventsManager() {
        launch(EVENTS_THREAD_FACTORY);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            triggerEventsWhenAreAvailable();
        }
    }

    private void launch(ThreadFactory threadFactory) {
        PausableThreadPoolExecutorImpl pausableThreadPoolExecutorImplNewSingleThreadExecutor = PausableThreadPoolExecutorImpl.newSingleThreadExecutor(threadFactory);
        pausableThreadPoolExecutorImplNewSingleThreadExecutor.submit(this);
        pausableThreadPoolExecutorImplNewSingleThreadExecutor.resume();
    }
}
