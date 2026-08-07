package io.split.android.client.service.executor.parallel;

import io.split.android.client.utils.logger.Logger;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class SplitParallelTaskExecutorFactoryImpl implements SplitParallelTaskExecutorFactory {
    private final ExecutorService mScheduler;
    private final int mThreads;

    public SplitParallelTaskExecutorFactoryImpl() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.mThreads = iAvailableProcessors;
        this.mScheduler = Executors.newFixedThreadPool(iAvailableProcessors, new ThreadFactory() { // from class: io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactoryImpl.1
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            private final Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() { // from class: io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactoryImpl.1.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread t, Throwable e) {
                    Logger.e("Unexpected error " + e.getLocalizedMessage());
                }
            };

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("Split-ParallelTaskExecutor-" + this.threadNumber.getAndIncrement());
                thread.setUncaughtExceptionHandler(this.exceptionHandler);
                return thread;
            }
        });
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory
    public <T> SplitParallelTaskExecutor<List<T>> createForList(Class<T> type) {
        return new SplitParallelTaskExecutorImpl(this.mThreads, this.mScheduler);
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory
    public <T> SplitParallelTaskExecutor<T> create(Class<T> type) {
        return new SplitParallelTaskExecutorImpl(this.mThreads, this.mScheduler);
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory
    public <T> SplitParallelTaskExecutor<T> create(Class<T> type, int timeoutInSeconds) {
        return new SplitParallelTaskExecutorImpl(this.mThreads, this.mScheduler, timeoutInSeconds);
    }
}
