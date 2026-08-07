package io.split.android.client.service.executor;

import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutorImpl;

/* JADX INFO: loaded from: classes4.dex */
public class SplitSingleThreadTaskExecutor extends SplitBaseTaskExecutor {
    private static final String THREAD_NAME_FORMAT = "split-singleThreadTaskExecutor-%d";

    @Override // io.split.android.client.service.executor.SplitBaseTaskExecutor
    protected PausableScheduledThreadPoolExecutor buildScheduler() {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setDaemon(true);
        threadFactoryBuilder.setNameFormat(THREAD_NAME_FORMAT);
        return PausableScheduledThreadPoolExecutorImpl.newSingleThreadScheduledExecutor(threadFactoryBuilder.build());
    }
}
