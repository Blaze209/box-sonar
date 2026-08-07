package io.split.android.client.events.executors;

import io.split.android.client.SplitClient;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class SplitEventExecutorWithClient implements SplitEventExecutor {
    private final SplitTask mBackgroundSplitTask;
    private final SplitTask mMainThreadSplitTask;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public SplitEventExecutorWithClient(SplitTaskExecutor taskExecutor, SplitEventTask task, SplitClient client) {
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mBackgroundSplitTask = new ClientEventSplitTask(task, client, false);
        this.mMainThreadSplitTask = new ClientEventSplitTask(task, client, true);
    }

    @Override // io.split.android.client.events.executors.SplitEventExecutor
    public void execute() {
        this.mSplitTaskExecutor.submit(this.mBackgroundSplitTask, null);
        this.mSplitTaskExecutor.submitOnMainThread(this.mMainThreadSplitTask);
    }
}
