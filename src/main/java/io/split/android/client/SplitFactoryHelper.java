package io.split.android.client;

import android.content.Context;
import androidx.core.util.Pair;
import androidx.work.WorkManager;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.lifecycle.SplitLifecycleManager;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.SdkTargetPath;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.executor.SplitSingleThreadTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.http.mysegments.MySegmentsFetcherFactory;
import io.split.android.client.service.http.mysegments.MySegmentsFetcherFactoryImpl;
import io.split.android.client.service.impressions.strategy.ImpressionStrategyConfig;
import io.split.android.client.service.impressions.strategy.ImpressionStrategyProvider;
import io.split.android.client.service.mysegments.AllSegmentsResponseParser;
import io.split.android.client.service.sseclient.EventStreamParser;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.service.sseclient.SseJwtParser;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.notifications.InstantUpdateChangeNotification;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationProcessor;
import io.split.android.client.service.sseclient.notifications.mysegments.MembershipsNotificationProcessorFactoryImpl;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry;
import io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker;
import io.split.android.client.service.sseclient.sseclient.BackoffCounterTimer;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManager;
import io.split.android.client.service.sseclient.sseclient.SseAuthenticator;
import io.split.android.client.service.sseclient.sseclient.SseClient;
import io.split.android.client.service.sseclient.sseclient.SseClientImpl;
import io.split.android.client.service.sseclient.sseclient.SseHandler;
import io.split.android.client.service.sseclient.sseclient.SseRefreshTokenTimer;
import io.split.android.client.service.sseclient.sseclient.StreamingComponents;
import io.split.android.client.service.synchronizer.RolloutCacheManager;
import io.split.android.client.service.synchronizer.RolloutCacheManagerImpl;
import io.split.android.client.service.synchronizer.SyncGuardian;
import io.split.android.client.service.synchronizer.SyncGuardianImpl;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.service.synchronizer.SyncManagerImpl;
import io.split.android.client.service.synchronizer.Synchronizer;
import io.split.android.client.service.synchronizer.WorkManagerWrapper;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerFactoryImpl;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerFactoryImpl;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry;
import io.split.android.client.shared.ClientComponentsRegisterImpl;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.cipher.SplitCipherFactory;
import io.split.android.client.storage.cipher.SplitEncryptionLevel;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.telemetry.TelemetrySynchronizerImpl;
import io.split.android.client.telemetry.TelemetrySynchronizerStub;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
class SplitFactoryHelper {
    private static final int DB_MAGIC_CHARS_COUNT = 4;

    SplitFactoryHelper() {
    }

    String getDatabaseName(SplitClientConfig config, String apiToken, Context context) {
        String strBuildDatabaseName = buildDatabaseName(config, apiToken);
        File databasePath = context.getDatabasePath(strBuildDatabaseName);
        if (!databasePath.exists()) {
            File databasePath2 = context.getDatabasePath(buildLegacyDatabaseName(config, apiToken));
            if (databasePath2.exists()) {
                databasePath2.renameTo(databasePath);
            }
        }
        return strBuildDatabaseName;
    }

    private String buildDatabaseName(SplitClientConfig config, String apiToken) {
        if (apiToken == null) {
            throw new IllegalArgumentException("SDK key cannot be null");
        }
        int length = apiToken.length();
        String strPrefix = config.prefix() == null ? "" : config.prefix();
        if (length > 4) {
            return strPrefix + apiToken.substring(0, 4) + apiToken.substring(length - 4);
        }
        return strPrefix + config.defaultDataFolder();
    }

    private String buildLegacyDatabaseName(SplitClientConfig splitClientConfig, String apiToken) throws CloneNotSupportedException {
        String strConvertApiKeyToFolder = Utils.convertApiKeyToFolder(apiToken);
        return strConvertApiKeyToFolder == null ? splitClientConfig.defaultDataFolder() : strConvertApiKeyToFolder;
    }

    Map<String, String> buildHeaders(SplitClientConfig splitClientConfig, String apiToken) {
        SplitHttpHeadersBuilder splitHttpHeadersBuilder = new SplitHttpHeadersBuilder();
        splitHttpHeadersBuilder.addJsonTypeHeaders();
        splitHttpHeadersBuilder.setHostIp(splitClientConfig.ip());
        splitHttpHeadersBuilder.setHostname(splitClientConfig.hostname());
        splitHttpHeadersBuilder.setClientVersion(SplitClientConfig.splitSdkVersion);
        splitHttpHeadersBuilder.setApiToken(apiToken);
        return splitHttpHeadersBuilder.build();
    }

    Map<String, String> buildStreamingHeaders(String apiToken) {
        SplitHttpHeadersBuilder splitHttpHeadersBuilder = new SplitHttpHeadersBuilder();
        splitHttpHeadersBuilder.addStreamingTypeHeaders();
        splitHttpHeadersBuilder.setAblyApiToken(apiToken);
        splitHttpHeadersBuilder.setClientVersion(SplitClientConfig.splitSdkVersion);
        return splitHttpHeadersBuilder.build();
    }

    SplitStorageContainer buildStorageContainer(UserConsent userConsentStatus, SplitRoomDatabase splitRoomDatabase, boolean shouldRecordTelemetry, SplitCipher splitCipher, TelemetryStorage telemetryStorage, long observerCacheExpirationPeriod, ScheduledThreadPoolExecutor impressionsObserverExecutor, SplitsStorage splitsStorage) {
        boolean z = userConsentStatus == UserConsent.GRANTED;
        PersistentEventsStorage persistentEventsStorage = StorageFactory.getPersistentEventsStorage(splitRoomDatabase, splitCipher);
        PersistentImpressionsStorage persistentImpressionsStorage = StorageFactory.getPersistentImpressionsStorage(splitRoomDatabase, splitCipher);
        GeneralInfoStorage generalInfoStorage = StorageFactory.getGeneralInfoStorage(splitRoomDatabase);
        return new SplitStorageContainer(splitsStorage, StorageFactory.getMySegmentsStorage(splitRoomDatabase, splitCipher), StorageFactory.getMyLargeSegmentsStorage(splitRoomDatabase, splitCipher), StorageFactory.getPersistentSplitsStorage(splitRoomDatabase, splitCipher), StorageFactory.getEventsStorage(persistentEventsStorage, z), persistentEventsStorage, StorageFactory.getImpressionsStorage(persistentImpressionsStorage, z), persistentImpressionsStorage, StorageFactory.getPersistentImpressionsCountStorage(splitRoomDatabase, splitCipher), StorageFactory.getPersistentImpressionsUniqueStorage(splitRoomDatabase, splitCipher), StorageFactory.getAttributesStorage(), StorageFactory.getPersistentAttributesStorage(splitRoomDatabase, splitCipher), getTelemetryStorage(shouldRecordTelemetry, telemetryStorage), StorageFactory.getImpressionsObserverCachePersistentStorage(splitRoomDatabase, observerCacheExpirationPeriod, impressionsObserverExecutor), generalInfoStorage, StorageFactory.getPersistentRuleBasedSegmentStorage(splitRoomDatabase, splitCipher, generalInfoStorage));
    }

    SplitApiFacade buildApiFacade(SplitClientConfig splitClientConfig, HttpClient httpClient, String splitsFilterQueryString) throws URISyntaxException {
        return new SplitApiFacade(ServiceFactory.getSplitsFetcher(httpClient, splitClientConfig.endpoint(), splitsFilterQueryString), new MySegmentsFetcherFactoryImpl(httpClient, splitClientConfig.endpoint(), new AllSegmentsResponseParser(), new MySegmentsUriBuilder(splitClientConfig.endpoint())), ServiceFactory.getSseAuthenticationFetcher(httpClient, splitClientConfig.authServiceUrl()), ServiceFactory.getEventsRecorder(httpClient, splitClientConfig.eventsEndpoint()), ServiceFactory.getImpressionsRecorder(httpClient, splitClientConfig.eventsEndpoint()), ServiceFactory.getImpressionsCountRecorder(httpClient, splitClientConfig.eventsEndpoint()), ServiceFactory.getUniqueKeysRecorder(httpClient, splitClientConfig.telemetryEndpoint()), ServiceFactory.getTelemetryConfigRecorder(httpClient, splitClientConfig.telemetryEndpoint()), ServiceFactory.getTelemetryStatsRecorder(httpClient, splitClientConfig.telemetryEndpoint()));
    }

    WorkManagerWrapper buildWorkManagerWrapper(Context context, SplitClientConfig splitClientConfig, String apiKey, String databaseName, Map<SplitFilter.Type, SplitFilter> filters) {
        SplitFilter splitFilter;
        if (filters.get(SplitFilter.Type.BY_SET) != null) {
            splitFilter = filters.get(SplitFilter.Type.BY_SET);
        } else {
            splitFilter = filters.get(SplitFilter.Type.BY_NAME);
        }
        return new WorkManagerWrapper(WorkManager.getInstance(context), splitClientConfig, apiKey, databaseName, splitFilter);
    }

    SyncManager buildSyncManager(SplitClientConfig config, SplitTaskExecutor splitTaskExecutor, Synchronizer synchronizer, TelemetrySynchronizer telemetrySynchronizer, PushNotificationManager pushNotificationManager, PushManagerEventBroadcaster pushManagerEventBroadcaster, SplitUpdatesWorker splitUpdatesWorker, SyncGuardian syncGuardian) {
        return new SyncManagerImpl(config, synchronizer, pushNotificationManager, splitUpdatesWorker, pushManagerEventBroadcaster, config.syncEnabled() ? new BackoffCounterTimer(splitTaskExecutor, new ReconnectBackoffCounter(1)) : null, syncGuardian, telemetrySynchronizer);
    }

    PushNotificationManager getPushNotificationManager(SplitTaskExecutor splitTaskExecutor, SseAuthenticator sseAuthenticator, PushManagerEventBroadcaster pushManagerEventBroadcaster, SseClient sseClient, TelemetryRuntimeProducer telemetryRuntimeProducer, long defaultSseConnectionDelayInSecs, int sseDisconnectionDelayInSecs) {
        return new PushNotificationManager(pushManagerEventBroadcaster, sseAuthenticator, sseClient, new SseRefreshTokenTimer(splitTaskExecutor, pushManagerEventBroadcaster), telemetryRuntimeProducer, defaultSseConnectionDelayInSecs, sseDisconnectionDelayInSecs, (ScheduledExecutorService) null);
    }

    public SseClient getSseClient(String streamingServiceUrlString, NotificationParser notificationParser, NotificationProcessor notificationProcessor, TelemetryRuntimeProducer telemetryRuntimeProducer, PushManagerEventBroadcaster pushManagerEventBroadcaster, HttpClient httpClient) {
        return new SseClientImpl(URI.create(streamingServiceUrlString), httpClient, new EventStreamParser(), new SseHandler(notificationParser, notificationProcessor, telemetryRuntimeProducer, pushManagerEventBroadcaster));
    }

    TelemetrySynchronizer getTelemetrySynchronizer(SplitTaskExecutor _splitTaskExecutor, SplitTaskFactory splitTaskFactory, long telemetryRefreshRate, boolean shouldRecordTelemetry) {
        if (shouldRecordTelemetry) {
            return new TelemetrySynchronizerImpl(_splitTaskExecutor, splitTaskFactory, telemetryRefreshRate);
        }
        return new TelemetrySynchronizerStub();
    }

    public ClientComponentsRegisterImpl getClientComponentsRegister(SplitClientConfig config, SplitTaskExecutor taskExecutor, EventsManagerCoordinator eventsManagerCoordinator, Synchronizer synchronizer, NotificationParser notificationParser, NotificationProcessor notificationProcessor, SseAuthenticator sseAuthenticator, SplitStorageContainer storageContainer, SyncManager syncManager, CompressionUtilProvider compressionProvider) {
        MySegmentsV2PayloadDecoder mySegmentsV2PayloadDecoder = new MySegmentsV2PayloadDecoder();
        PersistentAttributesStorage persistentAttributesStorage = config.persistentAttributesEnabled() ? storageContainer.getPersistentAttributesStorage() : null;
        return new ClientComponentsRegisterImpl(config, new MySegmentsSynchronizerFactoryImpl(new RetryBackoffCounterTimerFactory(), taskExecutor), storageContainer, new AttributesSynchronizerFactoryImpl(taskExecutor, persistentAttributesStorage), (AttributesSynchronizerRegistry) synchronizer, (MySegmentsSynchronizerRegistry) synchronizer, (MySegmentsUpdateWorkerRegistry) syncManager, eventsManagerCoordinator, sseAuthenticator, notificationProcessor, config.syncEnabled() ? new MembershipsNotificationProcessorFactoryImpl(notificationParser, taskExecutor, mySegmentsV2PayloadDecoder, compressionProvider) : null, mySegmentsV2PayloadDecoder);
    }

    public StreamingComponents buildStreamingComponents(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, SplitClientConfig config, HttpClient defaultHttpClient, SplitApiFacade splitApiFacade, SplitStorageContainer storageContainer, String flagsSpec) {
        if (!config.syncEnabled()) {
            return new StreamingComponents();
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        NotificationParser notificationParser = new NotificationParser();
        NotificationProcessor notificationProcessor = new NotificationProcessor(splitTaskExecutor, splitTaskFactory, notificationParser, linkedBlockingDeque);
        PushManagerEventBroadcaster pushManagerEventBroadcaster = new PushManagerEventBroadcaster();
        SseClient sseClient = getSseClient(config.streamingServiceUrl(), notificationParser, notificationProcessor, storageContainer.getTelemetryStorage(), pushManagerEventBroadcaster, defaultHttpClient);
        SseAuthenticator sseAuthenticator = new SseAuthenticator(splitApiFacade.getSseAuthenticationFetcher(), new SseJwtParser(), flagsSpec);
        return new StreamingComponents(getPushNotificationManager(splitTaskExecutor, sseAuthenticator, pushManagerEventBroadcaster, sseClient, storageContainer.getTelemetryStorage(), config.defaultSSEConnectionDelay(), config.sseDisconnectionDelay()), linkedBlockingDeque, notificationParser, notificationProcessor, sseAuthenticator, pushManagerEventBroadcaster, new SyncGuardianImpl(config));
    }

    public ImpressionStrategyProvider getImpressionStrategyProvider(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, SplitStorageContainer splitStorageContainer, SplitClientConfig config) {
        return new ImpressionStrategyProvider(splitTaskExecutor, splitStorageContainer, splitTaskFactory, splitStorageContainer.getTelemetryStorage(), new ImpressionStrategyConfig(config.impressionsQueueSize(), config.impressionsChunkSize(), config.impressionsRefreshRate(), config.impressionsCounterRefreshRate(), config.mtkRefreshRate(), config.userConsent() == UserConsent.GRANTED, config.impressionsDedupeTimeInterval()));
    }

    SplitCipher getCipher(String apiKey, boolean encryptionEnabled) {
        SplitEncryptionLevel splitEncryptionLevel;
        if (encryptionEnabled) {
            splitEncryptionLevel = SplitEncryptionLevel.AES_128_CBC;
        } else {
            splitEncryptionLevel = SplitEncryptionLevel.NONE;
        }
        return SplitCipherFactory.create(apiKey, splitEncryptionLevel);
    }

    SplitUpdatesWorker getSplitUpdatesWorker(SplitClientConfig config, SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, Synchronizer mSynchronizer, BlockingQueue<InstantUpdateChangeNotification> splitsUpdateNotificationQueue, SplitsStorage splitsStorage, RuleBasedSegmentStorage ruleBasedSegmentStorage, CompressionUtilProvider compressionProvider) {
        if (config.syncEnabled()) {
            return new SplitUpdatesWorker(mSynchronizer, splitsUpdateNotificationQueue, splitsStorage, ruleBasedSegmentStorage, compressionProvider, splitTaskExecutor, splitTaskFactory);
        }
        return null;
    }

    Pair<Map<SplitFilter.Type, SplitFilter>, String> getFilterConfiguration(SyncConfig syncConfig) {
        String strBuildQueryString;
        Map<SplitFilter.Type, SplitFilter> map = new HashMap<>();
        if (syncConfig != null) {
            FilterBuilder filterBuilder = new FilterBuilder(syncConfig.getFilters());
            Map<SplitFilter.Type, SplitFilter> groupedFilter = filterBuilder.getGroupedFilter();
            strBuildQueryString = filterBuilder.buildQueryString();
            map = groupedFilter;
        } else {
            strBuildQueryString = null;
        }
        return new Pair<>(map, strBuildQueryString);
    }

    FlagSetsFilter getFlagSetsFilter(Map<SplitFilter.Type, SplitFilter> filters) {
        if (filters.get(SplitFilter.Type.BY_SET) != null) {
            return new FlagSetsFilterImpl(filters.get(SplitFilter.Type.BY_SET).getValues());
        }
        return null;
    }

    ExecutorService getImpressionsLoggingTaskExecutor() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(3000), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private TelemetryStorage getTelemetryStorage(boolean shouldRecordTelemetry, TelemetryStorage telemetryStorage) {
        return telemetryStorage != null ? telemetryStorage : StorageFactory.getTelemetryStorage(shouldRecordTelemetry);
    }

    static class MySegmentsUriBuilder implements MySegmentsFetcherFactory.UriBuilder {
        private final String mEndpoint;

        public MySegmentsUriBuilder(String endpoint) {
            this.mEndpoint = endpoint;
        }

        @Override // io.split.android.client.service.http.mysegments.MySegmentsFetcherFactory.UriBuilder
        public URI build(String matchingKey) throws URISyntaxException {
            return SdkTargetPath.mySegments(this.mEndpoint, matchingKey);
        }
    }

    static class Initializer implements Runnable {
        private final ReentrantLock mInitLock;
        private final SplitTaskExecutionListener mListener;
        private final RolloutCacheManager mRolloutCacheManager;

        Initializer(String apiToken, SplitClientConfig config, SplitTaskFactory splitTaskFactory, SplitRoomDatabase splitDatabase, SplitCipher splitCipher, EventsManagerCoordinator eventsManagerCoordinator, SplitTaskExecutor splitTaskExecutor, SplitSingleThreadTaskExecutor splitSingleThreadTaskExecutor, SplitStorageContainer storageContainer, SyncManager syncManager, SplitLifecycleManager lifecycleManager, ReentrantLock initLock) {
            this(new RolloutCacheManagerImpl(config, storageContainer, splitTaskFactory.createEncryptionMigrationTask(apiToken, splitDatabase, config.encryptionEnabled(), splitCipher)), new Listener(eventsManagerCoordinator, splitTaskExecutor, splitSingleThreadTaskExecutor, syncManager, lifecycleManager, initLock), initLock);
        }

        Initializer(RolloutCacheManager rolloutCacheManager, SplitTaskExecutionListener listener, ReentrantLock initLock) {
            this.mRolloutCacheManager = rolloutCacheManager;
            this.mListener = listener;
            this.mInitLock = initLock;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.v("Running SDK initializer");
            this.mInitLock.lock();
            this.mRolloutCacheManager.validateCache(this.mListener);
        }

        static class Listener implements SplitTaskExecutionListener {
            private final EventsManagerCoordinator mEventsManagerCoordinator;
            private final ReentrantLock mInitLock;
            private final SplitLifecycleManager mLifecycleManager;
            private final SplitSingleThreadTaskExecutor mSplitSingleThreadTaskExecutor;
            private final SplitTaskExecutor mSplitTaskExecutor;
            private final SyncManager mSyncManager;

            Listener(EventsManagerCoordinator eventsManagerCoordinator, SplitTaskExecutor splitTaskExecutor, SplitSingleThreadTaskExecutor splitSingleThreadTaskExecutor, SyncManager syncManager, SplitLifecycleManager lifecycleManager, ReentrantLock initLock) {
                this.mEventsManagerCoordinator = eventsManagerCoordinator;
                this.mSplitTaskExecutor = splitTaskExecutor;
                this.mSplitSingleThreadTaskExecutor = splitSingleThreadTaskExecutor;
                this.mSyncManager = syncManager;
                this.mLifecycleManager = lifecycleManager;
                this.mInitLock = initLock;
            }

            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                try {
                    try {
                        this.mSplitTaskExecutor.resume();
                        this.mSplitSingleThreadTaskExecutor.resume();
                        this.mEventsManagerCoordinator.notifyInternalEvent(SplitInternalEvent.ENCRYPTION_MIGRATION_DONE);
                        this.mSyncManager.start();
                        this.mLifecycleManager.register(this.mSyncManager);
                        Logger.i("Android SDK initialized!");
                    } catch (Exception e) {
                        Logger.e("Error initializing Android SDK", e);
                    }
                } finally {
                    this.mInitLock.unlock();
                }
            }
        }
    }
}
