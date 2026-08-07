package io.split.android.client.service.impressions.strategy;

import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskSerialWrapper;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.unique.UniqueKeysTracker;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class NoneTracker implements PeriodicTracker {
    private final SplitTaskExecutionListener mCountTaskExecutionListener;
    private final RetryBackoffCounterTimer mImpressionsCountRetryTimer;
    private final ImpressionsCounter mImpressionsCounter;
    private final int mImpressionsCounterRefreshRate;
    private String mImpressionsRecorderCountTaskId;
    private final AtomicBoolean mIsSynchronizingCounts;
    private final AtomicBoolean mIsSynchronizingMtks;
    private final SplitTaskExecutionListener mMtkTaskExecutionListener;
    private final SplitTaskExecutor mTaskExecutor;
    private final ImpressionsTaskFactory mTaskFactory;
    private final AtomicBoolean mTrackingIsEnabled;
    private String mUniqueKeysRecorderTaskId;
    private final int mUniqueKeysRefreshRate;
    private final RetryBackoffCounterTimer mUniqueKeysRetryTimer;
    private final UniqueKeysTracker mUniqueKeysTracker;

    NoneTracker(SplitTaskExecutor taskExecutor, ImpressionsTaskFactory taskFactory, ImpressionsCounter impressionsCounter, UniqueKeysTracker uniqueKeysTracker, RetryBackoffCounterTimer impressionsCountRetryTimer, RetryBackoffCounterTimer uniqueKeysRetryTimer, int impressionsCounterRefreshRate, int uniqueKeysRefreshRate, boolean trackingIsEnabled) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.mIsSynchronizingMtks = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        this.mIsSynchronizingCounts = atomicBoolean2;
        this.mTaskExecutor = (SplitTaskExecutor) io.split.android.client.utils.Utils.checkNotNull(taskExecutor);
        this.mTaskFactory = (ImpressionsTaskFactory) io.split.android.client.utils.Utils.checkNotNull(taskFactory);
        this.mImpressionsCounter = (ImpressionsCounter) io.split.android.client.utils.Utils.checkNotNull(impressionsCounter);
        this.mUniqueKeysTracker = (UniqueKeysTracker) io.split.android.client.utils.Utils.checkNotNull(uniqueKeysTracker);
        this.mImpressionsCountRetryTimer = (RetryBackoffCounterTimer) io.split.android.client.utils.Utils.checkNotNull(impressionsCountRetryTimer);
        this.mUniqueKeysRetryTimer = (RetryBackoffCounterTimer) io.split.android.client.utils.Utils.checkNotNull(uniqueKeysRetryTimer);
        this.mImpressionsCounterRefreshRate = impressionsCounterRefreshRate;
        this.mUniqueKeysRefreshRate = uniqueKeysRefreshRate;
        this.mTrackingIsEnabled = new AtomicBoolean(trackingIsEnabled);
        this.mMtkTaskExecutionListener = new DoNotRetryListener(atomicBoolean);
        this.mCountTaskExecutionListener = new DoNotRetryListener(atomicBoolean2);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        flushImpressionsCount();
        flushUniqueKeys();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        if (this.mIsSynchronizingCounts.get()) {
            scheduleImpressionsCountRecorderTask();
        }
        if (this.mIsSynchronizingMtks.get()) {
            scheduleUniqueKeysRecorderTask();
        }
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        saveImpressionsCount();
        saveUniqueKeys();
        stopCountRecording();
        stopMtkRecording();
    }

    private void stopCountRecording() {
        this.mTaskExecutor.stopTask(this.mImpressionsRecorderCountTaskId);
    }

    private void stopMtkRecording() {
        this.mTaskExecutor.stopTask(this.mUniqueKeysRecorderTaskId);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean enable) {
        this.mTrackingIsEnabled.set(enable);
    }

    private void flushImpressionsCount() {
        this.mImpressionsCountRetryTimer.setTask(new SplitTaskSerialWrapper(this.mTaskFactory.createSaveImpressionsCountTask(this.mImpressionsCounter.popAll()), this.mTaskFactory.createImpressionsCountRecorderTask()));
        this.mImpressionsCountRetryTimer.start();
    }

    private void flushUniqueKeys() {
        this.mUniqueKeysRetryTimer.setTask(new SplitTaskSerialWrapper(this.mTaskFactory.createSaveUniqueImpressionsTask(this.mUniqueKeysTracker.popAll()), this.mTaskFactory.createUniqueImpressionsRecorderTask()));
        this.mUniqueKeysRetryTimer.start();
    }

    private void scheduleImpressionsCountRecorderTask() {
        String str = this.mImpressionsRecorderCountTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
        }
        this.mImpressionsRecorderCountTaskId = this.mTaskExecutor.schedule(this.mTaskFactory.createImpressionsCountRecorderTask(), 0L, this.mImpressionsCounterRefreshRate, this.mCountTaskExecutionListener);
    }

    private void scheduleUniqueKeysRecorderTask() {
        String str = this.mUniqueKeysRecorderTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
        }
        this.mUniqueKeysRecorderTaskId = this.mTaskExecutor.schedule(this.mTaskFactory.createUniqueImpressionsRecorderTask(), 0L, this.mUniqueKeysRefreshRate, this.mMtkTaskExecutionListener);
    }

    private void saveImpressionsCount() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.createSaveImpressionsCountTask(this.mImpressionsCounter.popAll()), null);
        }
    }

    private void saveUniqueKeys() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.createSaveUniqueImpressionsTask(this.mUniqueKeysTracker.popAll()), null);
        }
    }

    private static class DoNotRetryListener implements SplitTaskExecutionListener {
        private final AtomicBoolean mFlag;

        DoNotRetryListener(AtomicBoolean flag) {
            this.mFlag = flag;
        }

        @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
        public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
            if (Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                this.mFlag.compareAndSet(true, false);
            }
        }
    }
}
