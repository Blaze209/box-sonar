package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class BackoffCounterTimer implements SplitTaskExecutionListener {
    private final BackoffCounter mBackoffCounter;
    private SplitTask mTask;
    private final SplitTaskExecutor mTaskExecutor;
    String mTaskId;

    public BackoffCounterTimer(SplitTaskExecutor taskExecutor, BackoffCounter streamingBackoffCounter) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mBackoffCounter = (BackoffCounter) Utils.checkNotNull(streamingBackoffCounter);
    }

    public void setTask(SplitTask task) {
        this.mTask = (SplitTask) Utils.checkNotNull(task);
    }

    public void cancel() {
        if (this.mTask == null) {
            return;
        }
        this.mBackoffCounter.resetCounter();
        this.mTaskExecutor.stopTask(this.mTaskId);
        this.mTaskId = null;
    }

    public void schedule() {
        if (this.mTask == null || this.mTaskId != null) {
            return;
        }
        long nextRetryTime = this.mBackoffCounter.getNextRetryTime();
        Logger.d(String.format("Retrying reconnection in %d seconds", Long.valueOf(nextRetryTime)));
        this.mTaskId = this.mTaskExecutor.schedule(this.mTask, nextRetryTime, this);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        this.mTaskId = null;
    }
}
