package io.split.android.client.shared;

import io.split.android.client.FlagSetsFilter;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitClientFactory;
import io.split.android.client.SplitClientFactoryImpl;
import io.split.android.client.SplitFactoryImpl;
import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.executor.SplitClientEventTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.mysegments.MySegmentsTaskFactoryConfiguration;
import io.split.android.client.service.mysegments.MySegmentsTaskFactoryProvider;
import io.split.android.client.service.mysegments.MySegmentsTaskFactoryProviderImpl;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManager;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManagerDeferredStartTask;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsBackgroundSyncScheduleTask;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.utils.Utils;
import io.split.android.client.validators.KeyValidator;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.engine.experiments.SplitParser;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class SplitClientContainerImpl extends BaseSplitClientContainer {
    private String mBackgroundSyncTaskId;
    private final ClientComponentsRegister mClientComponentsRegister;
    private final SplitClientConfig mConfig;
    private final AtomicBoolean mConnecting;
    private final String mDefaultMatchingKey;
    private final MySegmentsTaskFactoryProvider mMySegmentsTaskFactoryProvider;
    private final PushNotificationManager mPushNotificationManager;
    private final AtomicBoolean mSchedulingBackgroundSync;
    private final SplitTaskExecutionListener mSchedulingBackgroundSyncExecutionListener;
    private final SplitApiFacade mSplitApiFacade;
    private final SplitTaskExecutor mSplitClientEventTaskExecutor;
    private final SplitClientFactory mSplitClientFactory;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitStorageContainer mStorageContainer;
    private SplitTaskExecutionListener mStreamingConnectionExecutionListener;
    private final boolean mStreamingEnabled;
    private String mStreamingTaskId;
    private final MySegmentsWorkManagerWrapper mWorkManagerWrapper;

    public SplitClientContainerImpl(String defaultMatchingKey, SplitFactoryImpl splitFactory, SplitClientConfig config, SyncManager syncManager, TelemetrySynchronizer telemetrySynchronizer, SplitStorageContainer storageContainer, SplitTaskExecutor splitTaskExecutor, SplitApiFacade splitApiFacade, ValidationMessageLogger validationLogger, KeyValidator keyValidator, ImpressionListener.FederatedImpressionListener customerImpressionListener, PushNotificationManager pushNotificationManager, ClientComponentsRegister clientComponentsRegister, MySegmentsWorkManagerWrapper workManagerWrapper, SplitFactoryImpl.EventsTrackerProvider eventsTrackerProvider, FlagSetsFilter flagSetsFilter, SplitParser splitParser) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mConnecting = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.mSchedulingBackgroundSync = atomicBoolean2;
        this.mStreamingTaskId = null;
        this.mBackgroundSyncTaskId = null;
        this.mDefaultMatchingKey = (String) Utils.checkNotNull(defaultMatchingKey);
        this.mPushNotificationManager = pushNotificationManager;
        this.mStreamingEnabled = config.streamingEnabled();
        this.mMySegmentsTaskFactoryProvider = new MySegmentsTaskFactoryProviderImpl(storageContainer.getTelemetryStorage());
        this.mSplitApiFacade = (SplitApiFacade) Utils.checkNotNull(splitApiFacade);
        this.mStorageContainer = (SplitStorageContainer) Utils.checkNotNull(storageContainer);
        this.mConfig = (SplitClientConfig) Utils.checkNotNull(config);
        this.mSplitClientFactory = new SplitClientFactoryImpl(splitFactory, this, config, syncManager, telemetrySynchronizer, storageContainer, splitTaskExecutor, validationLogger, keyValidator, eventsTrackerProvider, customerImpressionListener, flagSetsFilter, splitParser);
        this.mClientComponentsRegister = (ClientComponentsRegister) Utils.checkNotNull(clientComponentsRegister);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mSchedulingBackgroundSyncExecutionListener = new WorkManagerSchedulingListener(atomicBoolean2);
        this.mWorkManagerWrapper = (MySegmentsWorkManagerWrapper) Utils.checkNotNull(workManagerWrapper);
        this.mSplitClientEventTaskExecutor = new SplitClientEventTaskExecutor();
        if (config.syncEnabled()) {
            this.mStreamingConnectionExecutionListener = new StreamingConnectionExecutionListener(atomicBoolean);
        }
    }

    public SplitClientContainerImpl(String defaultMatchingKey, PushNotificationManager pushNotificationManager, boolean streamingEnabled, MySegmentsTaskFactoryProvider mySegmentsTaskFactoryProvider, SplitApiFacade splitApiFacade, SplitStorageContainer storageContainer, SplitTaskExecutor splitTaskExecutor, SplitClientConfig config, SplitClientFactory splitClientFactory, ClientComponentsRegister clientComponentsRegister, MySegmentsWorkManagerWrapper workManagerWrapper) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mConnecting = atomicBoolean;
        this.mSchedulingBackgroundSync = new AtomicBoolean(false);
        this.mStreamingTaskId = null;
        this.mBackgroundSyncTaskId = null;
        this.mDefaultMatchingKey = (String) Utils.checkNotNull(defaultMatchingKey);
        this.mPushNotificationManager = pushNotificationManager;
        this.mStreamingEnabled = streamingEnabled;
        this.mMySegmentsTaskFactoryProvider = (MySegmentsTaskFactoryProvider) Utils.checkNotNull(mySegmentsTaskFactoryProvider);
        this.mSplitApiFacade = (SplitApiFacade) Utils.checkNotNull(splitApiFacade);
        this.mStorageContainer = (SplitStorageContainer) Utils.checkNotNull(storageContainer);
        this.mConfig = (SplitClientConfig) Utils.checkNotNull(config);
        this.mSplitClientFactory = (SplitClientFactory) Utils.checkNotNull(splitClientFactory);
        this.mClientComponentsRegister = (ClientComponentsRegister) Utils.checkNotNull(clientComponentsRegister);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mStreamingConnectionExecutionListener = new StreamingConnectionExecutionListener(atomicBoolean);
        this.mSchedulingBackgroundSyncExecutionListener = new WorkManagerSchedulingListener(atomicBoolean);
        this.mWorkManagerWrapper = (MySegmentsWorkManagerWrapper) Utils.checkNotNull(workManagerWrapper);
        this.mSplitClientEventTaskExecutor = new SplitClientEventTaskExecutor();
    }

    @Override // io.split.android.client.shared.BaseSplitClientContainer, io.split.android.client.shared.SplitClientContainer
    public void remove(Key key) {
        super.remove(key);
        this.mClientComponentsRegister.unregisterComponentsForKey(key);
    }

    @Override // io.split.android.client.shared.BaseSplitClientContainer
    public void createNewClient(Key key) {
        SplitEventsManager splitEventsManager = new SplitEventsManager(this.mConfig, this.mSplitClientEventTaskExecutor);
        MySegmentsTaskFactory mySegmentsTaskFactory = getMySegmentsTaskFactory(key, splitEventsManager);
        trackNewClient(key, this.mSplitClientFactory.getClient(key, mySegmentsTaskFactory, splitEventsManager, this.mDefaultMatchingKey.equals(key.matchingKey())));
        this.mClientComponentsRegister.registerComponents(key, splitEventsManager, mySegmentsTaskFactory);
        if (this.mConfig.syncEnabled() && this.mStreamingEnabled) {
            connectToStreaming();
        }
        if (this.mConfig.synchronizeInBackground()) {
            scheduleMySegmentsWork();
        } else {
            this.mWorkManagerWrapper.removeWork();
        }
    }

    @Override // io.split.android.client.shared.SplitClientContainer
    public void destroy() {
        String str = this.mStreamingTaskId;
        if (str != null) {
            this.mSplitTaskExecutor.stopTask(str);
        }
        String str2 = this.mBackgroundSyncTaskId;
        if (str2 != null) {
            this.mSplitTaskExecutor.stopTask(str2);
        }
    }

    private MySegmentsTaskFactory getMySegmentsTaskFactory(Key key, SplitEventsManager eventsManager) {
        return this.mMySegmentsTaskFactoryProvider.getFactory(MySegmentsTaskFactoryConfiguration.get(this.mSplitApiFacade.getMySegmentsFetcher(key.matchingKey()), this.mStorageContainer.getMySegmentsStorage(key.matchingKey()), this.mStorageContainer.getMyLargeSegmentsStorage(key.matchingKey()), eventsManager));
    }

    private void connectToStreaming() {
        if (this.mConfig.syncEnabled() && !this.mConnecting.getAndSet(true)) {
            this.mStreamingTaskId = this.mSplitTaskExecutor.schedule(new PushNotificationManagerDeferredStartTask(this.mPushNotificationManager), 5L, this.mStreamingConnectionExecutionListener);
        }
    }

    private void scheduleMySegmentsWork() {
        if (this.mConfig.syncEnabled() && !this.mSchedulingBackgroundSync.getAndSet(true)) {
            this.mBackgroundSyncTaskId = this.mSplitTaskExecutor.schedule(new MySegmentsBackgroundSyncScheduleTask(this.mWorkManagerWrapper, getKeySet()), 5L, this.mSchedulingBackgroundSyncExecutionListener);
        }
    }

    static class StreamingConnectionExecutionListener implements SplitTaskExecutionListener {
        private final AtomicBoolean mConnecting;

        StreamingConnectionExecutionListener(AtomicBoolean connecting) {
            this.mConnecting = connecting;
        }

        @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
        public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
            this.mConnecting.set(false);
        }
    }

    static class WorkManagerSchedulingListener implements SplitTaskExecutionListener {
        private final AtomicBoolean mScheduling;

        WorkManagerSchedulingListener(AtomicBoolean connecting) {
            this.mScheduling = connecting;
        }

        @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
        public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
            this.mScheduling.set(false);
        }
    }
}
