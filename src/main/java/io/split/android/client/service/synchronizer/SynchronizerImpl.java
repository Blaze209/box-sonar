package io.split.android.client.service.synchronizer;

import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.api.Key;
import io.split.android.client.dtos.Event;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.impressions.DecoratedImpression;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.StrategyImpressionManager;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizer;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistryImpl;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.streaming.SyncModeUpdateStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class SynchronizerImpl implements Synchronizer, SplitTaskExecutionListener, MySegmentsSynchronizerRegistry, AttributesSynchronizerRegistry {
    private final AttributesSynchronizerRegistryImpl mAttributesSynchronizerRegistry;
    private String mEventsRecorderTaskId;
    private final RetryBackoffCounterTimer mEventsRecorderUpdateRetryTimer;
    private final StoragePusher<Event> mEventsStorage;
    private RecorderSyncHelper<Event> mEventsSyncHelper;
    private final SplitTaskExecutionListener mEventsTaskExecutionListener;
    private final FeatureFlagsSynchronizer mFeatureFlagsSynchronizer;
    private final StrategyImpressionManager mImpressionManager;
    private final AtomicBoolean mIsSynchronizingEvents;
    private final MySegmentsSynchronizerRegistryImpl mMySegmentsSynchronizerRegistry;
    private final SplitTaskExecutor mSingleThreadTaskExecutor;
    private final SplitClientConfig mSplitClientConfig;
    private final SplitTaskFactory mSplitTaskFactory;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public SynchronizerImpl(SplitClientConfig splitClientConfig, SplitTaskExecutor taskExecutor, SplitTaskExecutor splitSingleThreadTaskExecutor, SplitTaskFactory splitTaskFactory, WorkManagerWrapper workManagerWrapper, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, AttributesSynchronizerRegistryImpl attributesSynchronizerRegistry, MySegmentsSynchronizerRegistryImpl mySegmentsSynchronizerRegistry, StrategyImpressionManager impressionManager, StoragePusher<Event> eventsStorage, ISplitEventsManager eventsManagerCoordinator, PushManagerEventBroadcaster pushManagerEventBroadcaster) {
        this(splitClientConfig, taskExecutor, splitSingleThreadTaskExecutor, splitTaskFactory, workManagerWrapper, retryBackoffCounterTimerFactory, telemetryRuntimeProducer, attributesSynchronizerRegistry, mySegmentsSynchronizerRegistry, impressionManager, new FeatureFlagsSynchronizerImpl(splitClientConfig, taskExecutor, splitSingleThreadTaskExecutor, splitTaskFactory, eventsManagerCoordinator, retryBackoffCounterTimerFactory, pushManagerEventBroadcaster), eventsStorage);
    }

    public SynchronizerImpl(SplitClientConfig splitClientConfig, SplitTaskExecutor taskExecutor, SplitTaskExecutor splitSingleThreadTaskExecutor, SplitTaskFactory splitTaskFactory, WorkManagerWrapper workManagerWrapper, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, AttributesSynchronizerRegistryImpl attributesSynchronizerRegistry, MySegmentsSynchronizerRegistryImpl mySegmentsSynchronizerRegistry, StrategyImpressionManager impressionManager, FeatureFlagsSynchronizer featureFlagsSynchronizer, StoragePusher<Event> eventsStorage) {
        this.mIsSynchronizingEvents = new AtomicBoolean(true);
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        SplitTaskExecutor splitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitSingleThreadTaskExecutor);
        this.mSingleThreadTaskExecutor = splitTaskExecutor;
        this.mEventsStorage = (StoragePusher) Utils.checkNotNull(eventsStorage);
        SplitClientConfig splitClientConfig2 = (SplitClientConfig) Utils.checkNotNull(splitClientConfig);
        this.mSplitClientConfig = splitClientConfig2;
        this.mSplitTaskFactory = (SplitTaskFactory) Utils.checkNotNull(splitTaskFactory);
        this.mFeatureFlagsSynchronizer = (FeatureFlagsSynchronizer) Utils.checkNotNull(featureFlagsSynchronizer);
        this.mAttributesSynchronizerRegistry = attributesSynchronizerRegistry;
        this.mEventsRecorderUpdateRetryTimer = retryBackoffCounterTimerFactory.createWithFixedInterval(splitTaskExecutor, 1, 3);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mMySegmentsSynchronizerRegistry = (MySegmentsSynchronizerRegistryImpl) Utils.checkNotNull(mySegmentsSynchronizerRegistry);
        this.mImpressionManager = (StrategyImpressionManager) Utils.checkNotNull(impressionManager);
        this.mEventsTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.synchronizer.SynchronizerImpl.1
            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                if (Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                    SynchronizerImpl.this.mIsSynchronizingEvents.compareAndSet(true, false);
                    SynchronizerImpl.this.stopEventsPeriodicRecording();
                }
            }
        };
        setupListeners();
        if (splitClientConfig2.synchronizeInBackground()) {
            workManagerWrapper.setFetcherExecutionListener(this);
            workManagerWrapper.scheduleWork();
        } else {
            workManagerWrapper.removeWork();
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadMySegmentsFromCache() {
        this.mMySegmentsSynchronizerRegistry.loadMySegmentsFromCache();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadAttributesFromCache() {
        this.mAttributesSynchronizerRegistry.loadAttributesFromCache();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadAndSynchronizeSplits() {
        this.mFeatureFlagsSynchronizer.loadAndSynchronize();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeSplits(long since) {
        this.mFeatureFlagsSynchronizer.synchronize(Long.valueOf(since), null);
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeRuleBasedSegments(long changeNumber) {
        this.mFeatureFlagsSynchronizer.synchronize(null, Long.valueOf(changeNumber));
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeSplits() {
        this.mFeatureFlagsSynchronizer.synchronize();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeMySegments() {
        this.mMySegmentsSynchronizerRegistry.synchronizeMySegments();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public synchronized void startPeriodicFetching() {
        this.mFeatureFlagsSynchronizer.startPeriodicFetching();
        scheduleMySegmentsFetcherTask();
        this.mTelemetryRuntimeProducer.recordStreamingEvents(new SyncModeUpdateStreamingEvent(SyncModeUpdateStreamingEvent.Mode.POLLING, System.currentTimeMillis()));
        Logger.i("Periodic fetcher tasks scheduled");
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public synchronized void stopPeriodicFetching() {
        this.mFeatureFlagsSynchronizer.stopPeriodicFetching();
        this.mMySegmentsSynchronizerRegistry.stopPeriodicFetching();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void startPeriodicRecording() {
        scheduleEventsRecorderTask();
        this.mImpressionManager.startPeriodicRecording();
        Logger.i("Periodic recording tasks scheduled");
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void stopPeriodicRecording() {
        stopEventsPeriodicRecording();
        this.mImpressionManager.stopPeriodicRecording();
        this.mEventsRecorderTaskId = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopEventsPeriodicRecording() {
        this.mTaskExecutor.stopTask(this.mEventsRecorderTaskId);
    }

    private void setupListeners() {
        RecorderSyncHelperImpl recorderSyncHelperImpl = new RecorderSyncHelperImpl(SplitTaskType.EVENTS_RECORDER, this.mEventsStorage, this.mSplitClientConfig.eventsQueueSize(), 5242880L, this.mTaskExecutor);
        this.mEventsSyncHelper = recorderSyncHelperImpl;
        recorderSyncHelperImpl.addListener(this.mEventsTaskExecutionListener);
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void pause() {
        stopPeriodicRecording();
        stopPeriodicFetching();
        this.mTaskExecutor.pause();
        this.mSingleThreadTaskExecutor.pause();
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void resume() {
        this.mTaskExecutor.resume();
        this.mSingleThreadTaskExecutor.resume();
        if (this.mSplitClientConfig.userConsent() == UserConsent.GRANTED) {
            startPeriodicRecording();
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void destroy() {
        this.mFeatureFlagsSynchronizer.stopSynchronization();
        this.mMySegmentsSynchronizerRegistry.destroy();
        flush();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void flush() {
        if (this.mSplitClientConfig.userConsent() == UserConsent.GRANTED) {
            this.mEventsRecorderUpdateRetryTimer.setTask(this.mSplitTaskFactory.createEventsRecorderTask());
            this.mEventsRecorderUpdateRetryTimer.start();
            this.mImpressionManager.flush();
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void pushEvent(Event event) {
        if (this.mEventsSyncHelper.pushAndCheckIfFlushNeeded(event) && this.mIsSynchronizingEvents.get()) {
            this.mTaskExecutor.submit(this.mSplitTaskFactory.createEventsRecorderTask(), this.mEventsSyncHelper);
        }
        this.mTelemetryRuntimeProducer.recordEventStats(EventsDataRecordsEnum.EVENTS_QUEUED, 1L);
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void pushImpression(DecoratedImpression impression) {
        this.mImpressionManager.pushImpression(impression);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public void registerMySegmentsSynchronizer(Key key, MySegmentsSynchronizer mySegmentsSynchronizer) {
        this.mMySegmentsSynchronizerRegistry.registerMySegmentsSynchronizer(key, mySegmentsSynchronizer);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public void unregisterMySegmentsSynchronizer(Key key) {
        this.mMySegmentsSynchronizerRegistry.unregisterMySegmentsSynchronizer(key);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void registerAttributesSynchronizer(String userKey, AttributesSynchronizer attributesSynchronizer) {
        this.mAttributesSynchronizerRegistry.registerAttributesSynchronizer(userKey, attributesSynchronizer);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void unregisterAttributesSynchronizer(String userKey) {
        this.mAttributesSynchronizerRegistry.unregisterAttributesSynchronizer(userKey);
    }

    private void scheduleMySegmentsFetcherTask() {
        this.mMySegmentsSynchronizerRegistry.scheduleSegmentsSyncTask();
    }

    private void scheduleEventsRecorderTask() {
        if (this.mIsSynchronizingEvents.get()) {
            if (this.mEventsRecorderTaskId != null) {
                stopEventsPeriodicRecording();
            }
            this.mEventsRecorderTaskId = this.mTaskExecutor.schedule(this.mSplitTaskFactory.createEventsRecorderTask(), 0L, this.mSplitClientConfig.eventFlushInterval(), this.mEventsSyncHelper);
        }
    }

    /* JADX INFO: renamed from: io.split.android.client.service.synchronizer.SynchronizerImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$executor$SplitTaskType;

        static {
            int[] iArr = new int[SplitTaskType.values().length];
            $SwitchMap$io$split$android$client$service$executor$SplitTaskType = iArr;
            try {
                iArr[SplitTaskType.SPLITS_SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$executor$SplitTaskType[SplitTaskType.MY_SEGMENTS_SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        int i = AnonymousClass2.$SwitchMap$io$split$android$client$service$executor$SplitTaskType[taskInfo.getTaskType().ordinal()];
        if (i == 1) {
            this.mFeatureFlagsSynchronizer.submitLoadingTask(null);
        } else {
            if (i != 2) {
                return;
            }
            Logger.d("Loading my segments updated in background");
            this.mMySegmentsSynchronizerRegistry.submitMySegmentsLoadingTask();
        }
    }
}
