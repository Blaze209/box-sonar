package io.split.android.client.service.impressions.strategy;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.observer.ImpressionsObserver;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class OptimizedTracker implements PeriodicTracker {
    private final ImpressionsObserver mImpressionsObserver;
    private String mImpressionsRecorderTaskId;
    private final int mImpressionsRefreshRate;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final AtomicBoolean mIsSynchronizing = new AtomicBoolean(true);
    private final RetryBackoffCounterTimer mRetryTimer;
    private final SplitTaskExecutionListener mTaskExecutionListener;
    private final SplitTaskExecutor mTaskExecutor;
    private final AtomicBoolean mTrackingIsEnabled;

    OptimizedTracker(ImpressionsObserver impressionsObserver, RecorderSyncHelper<KeyImpression> impressionsSyncHelper, SplitTaskExecutor taskExecutor, ImpressionsTaskFactory taskFactory, RetryBackoffCounterTimer impressionsRetryTimer, int impressionsRefreshRate, boolean isTrackingEnabled) {
        SplitTaskExecutionListener splitTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.impressions.strategy.OptimizedTracker.1
            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR && Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                    OptimizedTracker.this.mIsSynchronizing.compareAndSet(true, false);
                    OptimizedTracker.this.stopPeriodicRecording();
                }
            }
        };
        this.mTaskExecutionListener = splitTaskExecutionListener;
        this.mImpressionsObserver = (ImpressionsObserver) io.split.android.client.utils.Utils.checkNotNull(impressionsObserver);
        RecorderSyncHelper<KeyImpression> recorderSyncHelper = (RecorderSyncHelper) io.split.android.client.utils.Utils.checkNotNull(impressionsSyncHelper);
        this.mImpressionsSyncHelper = recorderSyncHelper;
        recorderSyncHelper.addListener(splitTaskExecutionListener);
        this.mTaskExecutor = (SplitTaskExecutor) io.split.android.client.utils.Utils.checkNotNull(taskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) io.split.android.client.utils.Utils.checkNotNull(taskFactory);
        this.mRetryTimer = (RetryBackoffCounterTimer) io.split.android.client.utils.Utils.checkNotNull(impressionsRetryTimer);
        this.mImpressionsRefreshRate = impressionsRefreshRate;
        this.mTrackingIsEnabled = new AtomicBoolean(isTrackingEnabled);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        flushImpressions();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        if (this.mIsSynchronizing.get()) {
            scheduleImpressionsRecorderTask();
        }
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        this.mTaskExecutor.stopTask(this.mImpressionsRecorderTaskId);
        this.mImpressionsObserver.persist();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean enable) {
        this.mTrackingIsEnabled.set(enable);
    }

    private void flushImpressions() {
        this.mRetryTimer.setTask(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
        this.mRetryTimer.start();
    }

    private void scheduleImpressionsRecorderTask() {
        String str = this.mImpressionsRecorderTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
        }
        this.mImpressionsRecorderTaskId = this.mTaskExecutor.schedule(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), 0L, this.mImpressionsRefreshRate, this.mImpressionsSyncHelper);
    }
}
