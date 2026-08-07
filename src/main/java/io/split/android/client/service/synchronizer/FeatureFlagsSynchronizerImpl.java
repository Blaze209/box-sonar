package io.split.android.client.service.synchronizer;

import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskBatchItem;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class FeatureFlagsSynchronizerImpl implements FeatureFlagsSynchronizer {
    private final AtomicBoolean mIsSynchronizing = new AtomicBoolean(true);
    private final LoadLocalDataListener mLoadLocalSplitsListener;
    private final SplitClientConfig mSplitClientConfig;
    private final SplitTaskFactory mSplitTaskFactory;
    private String mSplitsFetcherTaskId;
    private final SplitTaskExecutionListener mSplitsSyncListener;
    private final RetryBackoffCounterTimer mSplitsSyncRetryTimer;
    private final SplitTaskExecutor mSplitsTaskExecutor;
    private final RetryBackoffCounterTimer mSplitsUpdateRetryTimer;
    private final SplitTaskExecutor mTaskExecutor;

    public FeatureFlagsSynchronizerImpl(SplitClientConfig splitClientConfig, SplitTaskExecutor taskExecutor, SplitTaskExecutor splitSingleThreadTaskExecutor, SplitTaskFactory splitTaskFactory, ISplitEventsManager splitEventsManager, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, final PushManagerEventBroadcaster pushManagerEventBroadcaster) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mSplitsTaskExecutor = splitSingleThreadTaskExecutor;
        this.mSplitClientConfig = (SplitClientConfig) Utils.checkNotNull(splitClientConfig);
        SplitTaskFactory splitTaskFactory2 = (SplitTaskFactory) Utils.checkNotNull(splitTaskFactory);
        this.mSplitTaskFactory = splitTaskFactory2;
        RetryBackoffCounterTimer retryBackoffCounterTimerCreate = retryBackoffCounterTimerFactory.create(splitSingleThreadTaskExecutor, 1);
        this.mSplitsSyncRetryTimer = retryBackoffCounterTimerCreate;
        this.mSplitsUpdateRetryTimer = retryBackoffCounterTimerFactory.create(splitSingleThreadTaskExecutor, 1);
        if (pushManagerEventBroadcaster != null) {
            this.mSplitsSyncListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.synchronizer.FeatureFlagsSynchronizerImpl.1
                @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
                public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                    if (taskInfo.getStatus() != SplitTaskExecutionStatus.SUCCESS) {
                        FeatureFlagsSynchronizerImpl.this.avoidRetries(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY));
                    } else {
                        pushManagerEventBroadcaster.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.SUCCESSFUL_SYNC));
                    }
                }
            };
        } else {
            this.mSplitsSyncListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.synchronizer.FeatureFlagsSynchronizerImpl.2
                @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
                public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                    if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR) {
                        FeatureFlagsSynchronizerImpl.this.avoidRetries(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY));
                    }
                }
            };
        }
        retryBackoffCounterTimerCreate.setTask(splitTaskFactory2.createSplitsSyncTask(true), this.mSplitsSyncListener);
        this.mLoadLocalSplitsListener = new LoadLocalDataListener(splitEventsManager, SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void loadAndSynchronize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SplitTaskBatchItem(this.mSplitTaskFactory.createFilterSplitsInCacheTask(), null));
        arrayList.add(new SplitTaskBatchItem(this.mSplitTaskFactory.createLoadRuleBasedSegmentsTask(), null));
        arrayList.add(new SplitTaskBatchItem(this.mSplitTaskFactory.createLoadSplitsTask(), this.mLoadLocalSplitsListener));
        arrayList.add(new SplitTaskBatchItem(new SplitTask() { // from class: io.split.android.client.service.synchronizer.FeatureFlagsSynchronizerImpl$$ExternalSyntheticLambda0
            @Override // io.split.android.client.service.executor.SplitTask
            public final SplitTaskExecutionInfo execute() {
                return this.f$0.m14774x94483de0();
            }
        }, null));
        this.mTaskExecutor.executeSerially(arrayList);
    }

    /* JADX INFO: renamed from: lambda$loadAndSynchronize$0$io-split-android-client-service-synchronizer-FeatureFlagsSynchronizerImpl, reason: not valid java name */
    /* synthetic */ SplitTaskExecutionInfo m14774x94483de0() {
        synchronize();
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void synchronize(Long since, Long rbsSince) {
        if (this.mIsSynchronizing.get()) {
            this.mSplitsUpdateRetryTimer.setTask(this.mSplitTaskFactory.createSplitsUpdateTask(since, rbsSince), this.mSplitsSyncListener);
            this.mSplitsUpdateRetryTimer.start();
        }
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void synchronize() {
        if (this.mIsSynchronizing.get()) {
            this.mSplitsSyncRetryTimer.start();
        }
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void startPeriodicFetching() {
        if (this.mIsSynchronizing.get()) {
            scheduleSplitsFetcherTask();
        }
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void stopPeriodicFetching() {
        this.mSplitsTaskExecutor.stopTask(this.mSplitsFetcherTaskId);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void stopSynchronization() {
        this.mSplitsSyncRetryTimer.stop();
        this.mSplitsUpdateRetryTimer.stop();
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void submitLoadingTask(SplitTaskExecutionListener listener) {
        this.mTaskExecutor.executeSerially(Arrays.asList(new SplitTaskBatchItem(this.mSplitTaskFactory.createLoadRuleBasedSegmentsTask(), null), new SplitTaskBatchItem(this.mSplitTaskFactory.createLoadSplitsTask(), listener)));
    }

    private void scheduleSplitsFetcherTask() {
        String str = this.mSplitsFetcherTaskId;
        if (str != null) {
            this.mSplitsTaskExecutor.stopTask(str);
        }
        this.mSplitsFetcherTaskId = this.mSplitsTaskExecutor.schedule(this.mSplitTaskFactory.createSplitsSyncTask(false), this.mSplitClientConfig.featuresRefreshRate(), this.mSplitClientConfig.featuresRefreshRate(), this.mSplitsSyncListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avoidRetries(Boolean doNotRetry) {
        if (Boolean.TRUE.equals(doNotRetry)) {
            this.mIsSynchronizing.compareAndSet(true, false);
            stopPeriodicFetching();
        }
    }
}
