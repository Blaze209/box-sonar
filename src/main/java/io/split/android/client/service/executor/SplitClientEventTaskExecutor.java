package io.split.android.client.service.executor;

import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutorImpl;

/* JADX INFO: loaded from: classes4.dex */
public class SplitClientEventTaskExecutor extends SplitBaseTaskExecutor {
    private static final String THREAD_NAME_FORMAT = "split-clientEventTaskExecutor-%d";

    @Override // io.split.android.client.service.executor.SplitBaseTaskExecutor
    protected PausableScheduledThreadPoolExecutor buildScheduler() {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setDaemon(true);
        threadFactoryBuilder.setNameFormat(THREAD_NAME_FORMAT);
        return new PausableScheduledThreadPoolExecutorImpl(4, threadFactoryBuilder.build());
    }
}
