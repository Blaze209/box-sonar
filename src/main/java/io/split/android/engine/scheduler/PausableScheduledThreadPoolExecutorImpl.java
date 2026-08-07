package io.split.android.engine.scheduler;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class PausableScheduledThreadPoolExecutorImpl extends ScheduledThreadPoolExecutor implements PausableScheduledThreadPoolExecutor {
    private static final int POOL_SIZE = 1;
    private boolean isPaused;
    private final ReentrantLock pauseLock;
    private final Condition unpaused;

    public static PausableScheduledThreadPoolExecutor newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new PausableScheduledThreadPoolExecutorImpl(1, threadFactory);
    }

    public PausableScheduledThreadPoolExecutorImpl(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        ReentrantLock reentrantLock = new ReentrantLock();
        this.pauseLock = reentrantLock;
        this.unpaused = reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable task) {
        super.beforeExecute(thread, task);
        this.pauseLock.lock();
        while (this.isPaused) {
            try {
                try {
                    this.unpaused.await();
                } catch (InterruptedException unused) {
                    thread.interrupt();
                }
            } catch (Throwable th) {
                this.pauseLock.unlock();
                throw th;
            }
        }
        this.pauseLock.unlock();
    }

    @Override // io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor
    public void pause() {
        this.pauseLock.lock();
        try {
            this.isPaused = true;
        } finally {
            this.pauseLock.unlock();
        }
    }

    @Override // io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor
    public void resume() {
        this.pauseLock.lock();
        try {
            this.isPaused = false;
            this.unpaused.signalAll();
        } finally {
            this.pauseLock.unlock();
        }
    }
}
