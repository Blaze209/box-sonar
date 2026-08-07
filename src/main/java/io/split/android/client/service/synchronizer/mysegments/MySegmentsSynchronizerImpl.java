package io.split.android.client.service.synchronizer.mysegments;

import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentUpdateParams;
import io.split.android.client.service.mysegments.MySegmentsSyncTask;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.LoadLocalDataListener;
import io.split.android.client.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsSynchronizerImpl implements MySegmentsSynchronizer {
    private final LoadLocalDataListener mLoadLocalMySegmentsListener;
    private String mMySegmentsFetcherTaskId;
    private final RetryBackoffCounterTimer mMySegmentsSyncRetryTimer;
    private final int mSegmentsRefreshRate;
    private final MySegmentsTaskFactory mSplitTaskFactory;
    private final SplitTaskExecutor mTaskExecutor;
    private final AtomicBoolean mIsSynchronizing = new AtomicBoolean(true);
    private final AtomicBoolean mIsDelayedFetchScheduled = new AtomicBoolean(false);
    private final SplitTaskExecutionListener mMySegmentsSyncListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerImpl.1
        @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
        public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
            MySegmentsSynchronizerImpl.this.mIsDelayedFetchScheduled.set(false);
            if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR && Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                MySegmentsSynchronizerImpl.this.mIsSynchronizing.compareAndSet(true, false);
                MySegmentsSynchronizerImpl.this.stopPeriodicFetching();
            }
        }
    };

    public MySegmentsSynchronizerImpl(RetryBackoffCounterTimer retryBackoffCounterTimer, SplitTaskExecutor taskExecutor, SplitEventsManager eventsManager, MySegmentsTaskFactory mySegmentsTaskFactory, int segmentsRefreshRate, SplitInternalEvent loadedFromStorageInternalEvent) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mMySegmentsSyncRetryTimer = (RetryBackoffCounterTimer) Utils.checkNotNull(retryBackoffCounterTimer);
        this.mSplitTaskFactory = (MySegmentsTaskFactory) Utils.checkNotNull(mySegmentsTaskFactory);
        this.mSegmentsRefreshRate = segmentsRefreshRate;
        this.mLoadLocalMySegmentsListener = new LoadLocalDataListener(eventsManager, loadedFromStorageInternalEvent);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void loadMySegmentsFromCache() {
        submitMySegmentsLoadingTask(this.mLoadLocalMySegmentsListener);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void synchronizeMySegments() {
        if (this.mIsSynchronizing.get()) {
            this.mMySegmentsSyncRetryTimer.stop();
            this.mMySegmentsSyncRetryTimer.setTask(this.mSplitTaskFactory.createMySegmentsSyncTask(false, null, null), this.mMySegmentsSyncListener);
            this.mMySegmentsSyncRetryTimer.start();
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void forceMySegmentsSync(MySegmentUpdateParams params) {
        if (this.mIsSynchronizing.get() && this.mIsDelayedFetchScheduled.compareAndSet(false, true)) {
            this.mMySegmentsSyncRetryTimer.stop();
            this.mMySegmentsSyncRetryTimer.setTask(getForcedSegmentsSyncTask(params.getTargetSegmentsCn(), params.getTargetLargeSegmentsCn()), params.getSyncDelay(), this.mMySegmentsSyncListener);
            this.mMySegmentsSyncRetryTimer.start();
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void destroy() {
        this.mMySegmentsSyncRetryTimer.stop();
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void scheduleSegmentsSyncTask() {
        if (this.mIsSynchronizing.get()) {
            String str = this.mMySegmentsFetcherTaskId;
            if (str != null) {
                this.mTaskExecutor.stopTask(str);
            }
            SplitTaskExecutor splitTaskExecutor = this.mTaskExecutor;
            MySegmentsSyncTask mySegmentsSyncTask = getMySegmentsSyncTask();
            int i = this.mSegmentsRefreshRate;
            this.mMySegmentsFetcherTaskId = splitTaskExecutor.schedule(mySegmentsSyncTask, i, i, this.mMySegmentsSyncListener);
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void stopPeriodicFetching() {
        this.mTaskExecutor.stopTask(this.mMySegmentsFetcherTaskId);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void submitMySegmentsLoadingTask() {
        submitMySegmentsLoadingTask(null);
    }

    private void submitMySegmentsLoadingTask(SplitTaskExecutionListener executionListener) {
        this.mTaskExecutor.submit(this.mSplitTaskFactory.createLoadMySegmentsTask(), executionListener);
    }

    private MySegmentsSyncTask getMySegmentsSyncTask() {
        return this.mSplitTaskFactory.createMySegmentsSyncTask(false, null, null);
    }

    private MySegmentsSyncTask getForcedSegmentsSyncTask(Long targetSegmentsCn, Long targetLargeSegmentsCn) {
        return this.mSplitTaskFactory.createMySegmentsSyncTask(true, targetSegmentsCn, targetLargeSegmentsCn);
    }
}
