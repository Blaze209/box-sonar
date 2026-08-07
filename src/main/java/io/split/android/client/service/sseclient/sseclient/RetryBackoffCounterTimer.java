package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class RetryBackoffCounterTimer implements SplitTaskExecutionListener {
    private static final int DEFAULT_MAX_ATTEMPTS = -1;
    private final BackoffCounter mBackoffCounter;
    private final AtomicInteger mCurrentAttempts;
    private Long mInitialDelayInSeconds;
    private SplitTaskExecutionListener mListener;
    private final int mRetryAttemptsLimit;
    private SplitTask mTask;
    private final SplitTaskExecutor mTaskExecutor;
    private volatile String mTaskId;

    public RetryBackoffCounterTimer(SplitTaskExecutor taskExecutor, BackoffCounter backoffCounter) {
        this(taskExecutor, backoffCounter, -1);
    }

    public RetryBackoffCounterTimer(SplitTaskExecutor taskExecutor, BackoffCounter backoffCounter, int retryAttemptsLimit) {
        this.mCurrentAttempts = new AtomicInteger(0);
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mBackoffCounter = (BackoffCounter) Utils.checkNotNull(backoffCounter);
        this.mRetryAttemptsLimit = retryAttemptsLimit;
    }

    public synchronized void setTask(SplitTask task, SplitTaskExecutionListener listener) {
        setTask(task, 0L, listener);
    }

    public synchronized void setTask(SplitTask task) {
        setTask(task, null);
    }

    public synchronized void setTask(SplitTask task, Long initialDelayInMillis, SplitTaskExecutionListener listener) {
        this.mTask = (SplitTask) Utils.checkNotNull(task);
        this.mListener = listener;
        if (initialDelayInMillis != null) {
            this.mInitialDelayInSeconds = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(initialDelayInMillis.longValue()));
        } else {
            this.mInitialDelayInSeconds = 0L;
        }
        this.mCurrentAttempts.set(0);
    }

    public synchronized void stop() {
        if (this.mTask == null) {
            return;
        }
        this.mTaskExecutor.stopTask(this.mTaskId);
        this.mTaskId = null;
    }

    public synchronized void start() {
        if (this.mTask != null && this.mTaskId == null) {
            this.mBackoffCounter.resetCounter();
            this.mCurrentAttempts.incrementAndGet();
            this.mTaskId = this.mTaskExecutor.schedule(this.mTask, this.mInitialDelayInSeconds.longValue(), this);
        }
    }

    private synchronized void schedule() {
        if (this.mTask == null) {
            return;
        }
        long nextRetryTime = this.mBackoffCounter.getNextRetryTime();
        Logger.d(String.format("Retrying %s task in %d seconds", this.mTask.getClass().getSimpleName(), Long.valueOf(nextRetryTime)));
        this.mCurrentAttempts.incrementAndGet();
        this.mTaskId = this.mTaskExecutor.schedule(this.mTask, nextRetryTime, this);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        SplitTaskExecutionListener splitTaskExecutionListener;
        this.mTaskId = null;
        if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR) {
            if (taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY) != null && !Boolean.FALSE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                if (Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY)) && (splitTaskExecutionListener = this.mListener) != null) {
                    splitTaskExecutionListener.taskExecuted(taskInfo);
                }
            } else {
                if (this.mRetryAttemptsLimit == -1 || this.mCurrentAttempts.get() < this.mRetryAttemptsLimit) {
                    schedule();
                    return;
                }
                return;
            }
        }
        this.mBackoffCounter.resetCounter();
        if (this.mListener != null) {
            if (taskInfo.getStatus() == SplitTaskExecutionStatus.SUCCESS) {
                this.mListener.taskExecuted(SplitTaskExecutionInfo.success(taskInfo.getTaskType()));
            } else if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR) {
                this.mListener.taskExecuted(SplitTaskExecutionInfo.error(taskInfo.getTaskType()));
            }
        }
    }
}
