package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class SseDisconnectionTimer implements SplitTaskExecutionListener {
    private final int mInitialDelayInSeconds;
    private final SplitTaskExecutor mTaskExecutor;
    private String mTaskId;

    public SseDisconnectionTimer(SplitTaskExecutor taskExecutor, int initialDelayInSeconds) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mInitialDelayInSeconds = initialDelayInSeconds;
    }

    public void cancel() {
        String str = this.mTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
        }
    }

    public void schedule(SplitTask task) {
        Logger.v("Scheduling disconnection in " + this.mInitialDelayInSeconds + " seconds");
        cancel();
        this.mTaskId = this.mTaskExecutor.schedule(task, this.mInitialDelayInSeconds, this);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        this.mTaskId = null;
    }
}
