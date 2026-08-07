package io.split.android.client.service.executor.parallel;

import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class SplitParallelTaskExecutorImpl<T> implements SplitParallelTaskExecutor<T> {
    private static final int TIMEOUT_IN_SECONDS = 60;
    private final ExecutorService mScheduler;
    private final int mThreads;
    private final int mTimeoutInSeconds;

    SplitParallelTaskExecutorImpl(int threads, ExecutorService scheduler) {
        this(threads, scheduler, 60);
    }

    SplitParallelTaskExecutorImpl(int threads, ExecutorService scheduler, int timeoutInSeconds) {
        this.mThreads = threads;
        this.mScheduler = scheduler;
        this.mTimeoutInSeconds = timeoutInSeconds;
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutor
    public List<T> execute(Collection<SplitDeferredTaskItem<T>> splitDeferredTaskItems) {
        try {
            List<Future<T>> listInvokeAll = this.mScheduler.invokeAll(splitDeferredTaskItems, this.mTimeoutInSeconds, TimeUnit.SECONDS);
            ArrayList arrayList = new ArrayList();
            Iterator<Future<T>> it = listInvokeAll.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().get());
            }
            return arrayList;
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            Logger.e(e.getLocalizedMessage());
            return new ArrayList();
        }
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutor
    public int getAvailableThreads() {
        return this.mThreads;
    }
}
