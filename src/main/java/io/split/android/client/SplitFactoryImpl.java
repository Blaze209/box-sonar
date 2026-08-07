package io.split.android.client;

import android.content.Context;
import androidx.core.util.Pair;
import io.split.android.android_client.BuildConfig;
import io.split.android.client.api.Key;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.factory.FactoryMonitor;
import io.split.android.client.factory.FactoryMonitorImpl;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.impressions.SyncImpressionListener;
import io.split.android.client.lifecycle.SplitLifecycleManager;
import io.split.android.client.lifecycle.SplitLifecycleManagerImpl;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpClientImpl;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.executor.SplitSingleThreadTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutorImpl;
import io.split.android.client.service.executor.SplitTaskFactoryImpl;
import io.split.android.client.service.impressions.StrategyImpressionManager;
import io.split.android.client.service.impressions.strategy.ImpressionStrategyProvider;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.sseclient.StreamingComponents;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.service.synchronizer.Synchronizer;
import io.split.android.client.service.synchronizer.SynchronizerImpl;
import io.split.android.client.service.synchronizer.SynchronizerSpy;
import io.split.android.client.service.synchronizer.WorkManagerWrapper;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistryImpl;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl;
import io.split.android.client.shared.ClientComponentsRegisterImpl;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.shared.SplitClientContainerImpl;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.storage.events.EventsStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.ApiKeyValidatorImpl;
import io.split.android.client.validators.EventValidatorImpl;
import io.split.android.client.validators.KeyValidatorImpl;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.ValidationConfig;
import io.split.android.client.validators.ValidationErrorInfo;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.SplitParser;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class SplitFactoryImpl implements SplitFactory {
    private final String mApiKey;
    private final AtomicBoolean mCheckClients;
    private final SplitClientContainer mClientContainer;
    private final SplitClientConfig mConfig;
    private final Key mDefaultClientKey;
    private final Runnable mDestroyer;
    private final EventsTrackerProvider mEventsTrackerProvider;
    private final FactoryMonitor mFactoryMonitor;
    private final StrategyImpressionManager mImpressionManager;
    private final ReentrantLock mInitLock;
    private boolean mIsTerminated;
    private final SplitLifecycleManager mLifecycleManager;
    private final SplitManager mManager;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitStorageContainer mStorageContainer;
    private final SyncManager mSyncManager;
    private volatile UserConsentManager mUserConsentManager;

    public SplitFactoryImpl(String apiToken, Key key, SplitClientConfig config, Context context) throws URISyntaxException {
        this(apiToken, key, config, context, null, null, null, null, null, null);
    }

    private SplitFactoryImpl(String apiToken, Key key, SplitClientConfig config, Context context, HttpClient httpClient, SplitRoomDatabase testDatabase, SynchronizerSpy synchronizerSpy, TestingConfig testingConfig, SplitLifecycleManager testLifecycleManager, TelemetryStorage telemetryStorage) throws URISyntaxException {
        SplitRoomDatabase database;
        HttpClient httpClientBuild;
        ImpressionListener.FederatedImpressionListener federatedImpressionListener;
        this.mIsTerminated = false;
        this.mCheckClients = new AtomicBoolean(false);
        FactoryMonitor sharedInstance = FactoryMonitorImpl.getSharedInstance();
        this.mFactoryMonitor = sharedInstance;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mInitLock = reentrantLock;
        this.mDefaultClientKey = key;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        SplitFactoryHelper splitFactoryHelper = new SplitFactoryHelper();
        setupValidations(config);
        ApiKeyValidatorImpl apiKeyValidatorImpl = new ApiKeyValidatorImpl();
        KeyValidatorImpl keyValidatorImpl = new KeyValidatorImpl();
        ValidationMessageLoggerImpl validationMessageLoggerImpl = new ValidationMessageLoggerImpl();
        ValidationErrorInfo validationErrorInfoValidate = keyValidatorImpl.validate(key.matchingKey(), key.bucketingKey());
        if (validationErrorInfoValidate != null) {
            validationMessageLoggerImpl.log(validationErrorInfoValidate, "factory instantiation");
        }
        ValidationErrorInfo validationErrorInfoValidate2 = apiKeyValidatorImpl.validate(apiToken);
        if (validationErrorInfoValidate2 != null) {
            validationMessageLoggerImpl.log(validationErrorInfoValidate2, "factory instantiation");
        }
        int iCount = sharedInstance.count(apiToken);
        if (iCount > 0) {
            validationMessageLoggerImpl.w("You already have " + iCount + (iCount == 1 ? " factory" : " factories") + " with this SDK Key. We recommend keeping only one instance of the factory at all times (Singleton pattern) and reusing it throughout your application.", "factory instantiation");
        } else if (sharedInstance.count() > 0) {
            validationMessageLoggerImpl.w("You already have an instance of the Split factory. Make sure you definitely want this additional instance. We recommend keeping only one instance of the factory at all times (Singleton pattern) and reusing it throughout your application.", "factory instantiation");
        }
        sharedInstance.add(apiToken);
        this.mApiKey = apiToken;
        String databaseName = splitFactoryHelper.getDatabaseName(config, apiToken, context);
        if (testDatabase == null) {
            database = SplitRoomDatabase.getDatabase(context, databaseName);
        } else {
            Logger.d("Using test database");
            database = testDatabase;
        }
        this.mConfig = config;
        SplitCipher cipher = splitFactoryHelper.getCipher(apiToken, config.encryptionEnabled());
        SplitsStorage splitsStorage = getSplitsStorage(database, cipher);
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadPoolExecutor.CallerRunsPolicy());
        SplitRoomDatabase splitRoomDatabase = database;
        SplitStorageContainer splitStorageContainerBuildStorageContainer = splitFactoryHelper.buildStorageContainer(config.userConsent(), splitRoomDatabase, config.shouldRecordTelemetry(), cipher, telemetryStorage, config.observerCacheExpirationPeriod(), scheduledThreadPoolExecutor, splitsStorage);
        this.mStorageContainer = splitStorageContainerBuildStorageContainer;
        SplitTaskExecutorImpl splitTaskExecutorImpl = new SplitTaskExecutorImpl();
        this.mSplitTaskExecutor = splitTaskExecutorImpl;
        splitTaskExecutorImpl.pause();
        EventsManagerCoordinator eventsManagerCoordinator = new EventsManagerCoordinator();
        Pair<Map<SplitFilter.Type, SplitFilter>, String> filterConfiguration = splitFactoryHelper.getFilterConfiguration(config.syncConfig());
        Map<SplitFilter.Type, SplitFilter> map = filterConfiguration.first;
        String str = filterConfiguration.second;
        String flagsSpec = getFlagsSpec(testingConfig);
        if (httpClient == null) {
            HttpClientImpl.Builder proxyAuthenticator = new HttpClientImpl.Builder().setConnectionTimeout(config.connectionTimeout()).setReadTimeout(config.readTimeout()).setProxy(config.proxy()).setDevelopmentSslConfig(config.developmentSslConfig()).setContext(context).setProxyAuthenticator(config.authenticator());
            if (config.certificatePinningConfiguration() != null) {
                proxyAuthenticator.setCertificatePinningConfiguration(config.certificatePinningConfiguration());
            }
            httpClientBuild = proxyAuthenticator.build();
        } else {
            httpClientBuild = httpClient;
        }
        httpClientBuild.addHeaders(splitFactoryHelper.buildHeaders(config, apiToken));
        httpClientBuild.addStreamingHeaders(splitFactoryHelper.buildStreamingHeaders(apiToken));
        SplitApiFacade splitApiFacadeBuildApiFacade = splitFactoryHelper.buildApiFacade(config, httpClientBuild, str);
        FlagSetsFilter flagSetsFilter = splitFactoryHelper.getFlagSetsFilter(map);
        final HttpClient httpClient2 = httpClientBuild;
        SplitTaskFactoryImpl splitTaskFactoryImpl = new SplitTaskFactoryImpl(config, splitApiFacadeBuildApiFacade, splitStorageContainerBuildStorageContainer, str, getFlagsSpec(testingConfig), eventsManagerCoordinator, map, flagSetsFilter, testingConfig);
        WorkManagerWrapper workManagerWrapperBuildWorkManagerWrapper = splitFactoryHelper.buildWorkManagerWrapper(context, config, apiToken, databaseName, map);
        final SplitSingleThreadTaskExecutor splitSingleThreadTaskExecutor = new SplitSingleThreadTaskExecutor();
        splitSingleThreadTaskExecutor.pause();
        ImpressionStrategyProvider impressionStrategyProvider = splitFactoryHelper.getImpressionStrategyProvider(splitTaskExecutorImpl, splitTaskFactoryImpl, splitStorageContainerBuildStorageContainer, config);
        StrategyImpressionManager strategyImpressionManager = new StrategyImpressionManager(impressionStrategyProvider.getNoneComponents(), impressionStrategyProvider.getStrategy(config.impressionsMode()));
        this.mImpressionManager = strategyImpressionManager;
        RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory = new RetryBackoffCounterTimerFactory();
        StreamingComponents streamingComponentsBuildStreamingComponents = splitFactoryHelper.buildStreamingComponents(splitTaskExecutorImpl, splitTaskFactoryImpl, config, httpClient2, splitApiFacadeBuildApiFacade, splitStorageContainerBuildStorageContainer, flagsSpec);
        TelemetryStorage telemetryStorage2 = splitStorageContainerBuildStorageContainer.getTelemetryStorage();
        AttributesSynchronizerRegistryImpl attributesSynchronizerRegistryImpl = new AttributesSynchronizerRegistryImpl();
        MySegmentsSynchronizerRegistryImpl mySegmentsSynchronizerRegistryImpl = new MySegmentsSynchronizerRegistryImpl();
        EventsStorage eventsStorage = splitStorageContainerBuildStorageContainer.getEventsStorage();
        PushManagerEventBroadcaster pushManagerEventBroadcaster = streamingComponentsBuildStreamingComponents.getPushManagerEventBroadcaster();
        SynchronizerSpy synchronizerSpy2 = synchronizerSpy;
        Synchronizer synchronizerImpl = new SynchronizerImpl(config, splitTaskExecutorImpl, splitSingleThreadTaskExecutor, splitTaskFactoryImpl, workManagerWrapperBuildWorkManagerWrapper, retryBackoffCounterTimerFactory, telemetryStorage2, attributesSynchronizerRegistryImpl, mySegmentsSynchronizerRegistryImpl, strategyImpressionManager, eventsStorage, eventsManagerCoordinator, pushManagerEventBroadcaster);
        if (synchronizerSpy2 != null) {
            synchronizerSpy2.setSynchronizer(synchronizerImpl);
        } else {
            synchronizerSpy2 = synchronizerImpl;
        }
        CompressionUtilProvider compressionUtilProvider = new CompressionUtilProvider();
        final TelemetrySynchronizer telemetrySynchronizer = splitFactoryHelper.getTelemetrySynchronizer(splitTaskExecutorImpl, splitTaskFactoryImpl, config.telemetryRefreshRate(), config.shouldRecordTelemetry());
        SynchronizerSpy synchronizerSpy3 = synchronizerSpy2;
        SyncManager syncManagerBuildSyncManager = splitFactoryHelper.buildSyncManager(config, splitTaskExecutorImpl, synchronizerSpy3, telemetrySynchronizer, streamingComponentsBuildStreamingComponents.getPushNotificationManager(), streamingComponentsBuildStreamingComponents.getPushManagerEventBroadcaster(), splitFactoryHelper.getSplitUpdatesWorker(config, splitTaskExecutorImpl, splitTaskFactoryImpl, synchronizerSpy3, streamingComponentsBuildStreamingComponents.getSplitsUpdateNotificationQueue(), splitStorageContainerBuildStorageContainer.getSplitsStorage(), splitStorageContainerBuildStorageContainer.getRuleBasedSegmentStorage(), compressionUtilProvider), streamingComponentsBuildStreamingComponents.getSyncGuardian());
        this.mSyncManager = syncManagerBuildSyncManager;
        if (testLifecycleManager == null) {
            this.mLifecycleManager = new SplitLifecycleManagerImpl();
        } else {
            this.mLifecycleManager = testLifecycleManager;
        }
        final ExecutorService impressionsLoggingTaskExecutor = splitFactoryHelper.getImpressionsLoggingTaskExecutor();
        SyncImpressionListener syncImpressionListener = new SyncImpressionListener(syncManagerBuildSyncManager, impressionsLoggingTaskExecutor);
        ArrayList arrayList = new ArrayList();
        if (config.impressionListener() != null) {
            arrayList.add(config.impressionListener());
            federatedImpressionListener = new ImpressionListener.FederatedImpressionListener(syncImpressionListener, arrayList);
        } else {
            federatedImpressionListener = new ImpressionListener.FederatedImpressionListener(syncImpressionListener, arrayList);
        }
        final ImpressionListener.FederatedImpressionListener federatedImpressionListener2 = federatedImpressionListener;
        EventsTrackerProvider eventsTrackerProvider = new EventsTrackerProvider(splitStorageContainerBuildStorageContainer.getSplitsStorage(), splitStorageContainerBuildStorageContainer.getTelemetryStorage(), syncManagerBuildSyncManager);
        this.mEventsTrackerProvider = eventsTrackerProvider;
        ClientComponentsRegisterImpl clientComponentsRegister = splitFactoryHelper.getClientComponentsRegister(config, splitTaskExecutorImpl, eventsManagerCoordinator, synchronizerSpy3, streamingComponentsBuildStreamingComponents.getNotificationParser(), streamingComponentsBuildStreamingComponents.getNotificationProcessor(), streamingComponentsBuildStreamingComponents.getSseAuthenticator(), splitStorageContainerBuildStorageContainer, syncManagerBuildSyncManager, compressionUtilProvider);
        SplitParser splitParser = new SplitParser(splitStorageContainerBuildStorageContainer.getParserCommons());
        this.mClientContainer = new SplitClientContainerImpl(key.matchingKey(), this, config, syncManagerBuildSyncManager, telemetrySynchronizer, splitStorageContainerBuildStorageContainer, splitTaskExecutorImpl, splitApiFacadeBuildApiFacade, validationMessageLoggerImpl, keyValidatorImpl, federatedImpressionListener2, streamingComponentsBuildStreamingComponents.getPushNotificationManager(), clientComponentsRegister, workManagerWrapperBuildWorkManagerWrapper, eventsTrackerProvider, flagSetsFilter, splitParser);
        this.mDestroyer = new Runnable() { // from class: io.split.android.client.SplitFactoryImpl.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v5, types: [java.util.concurrent.locks.ReentrantLock] */
            @Override // java.lang.Runnable
            public void run() {
                SplitFactoryImpl.this.mInitLock.lock();
                try {
                    try {
                        if (SplitFactoryImpl.this.mCheckClients.get() && !SplitFactoryImpl.this.mClientContainer.getAll().isEmpty()) {
                            Logger.d("Avoiding shutdown due to active clients");
                        } else {
                            Logger.w("Shutdown called for split");
                            SplitFactoryImpl.this.mStorageContainer.getTelemetryStorage().recordSessionLength(System.currentTimeMillis() - jCurrentTimeMillis);
                            telemetrySynchronizer.flush();
                            telemetrySynchronizer.destroy();
                            Logger.d("Successful shutdown of telemetry");
                            impressionsLoggingTaskExecutor.shutdown();
                            scheduledThreadPoolExecutor.shutdown();
                            Logger.d("Successful shutdown of impressions logging executor");
                            SplitFactoryImpl.this.mSyncManager.stop();
                            Logger.d("Flushing impressions and events");
                            SplitFactoryImpl.this.mLifecycleManager.destroy();
                            SplitFactoryImpl.this.mClientContainer.destroy();
                            Logger.d("Successful shutdown of lifecycle manager");
                            SplitFactoryImpl.this.mFactoryMonitor.remove(SplitFactoryImpl.this.mApiKey);
                            Logger.d("Successful shutdown of segment fetchers");
                            federatedImpressionListener2.close();
                            Logger.d("Successful shutdown of ImpressionListener");
                            httpClient2.close();
                            Logger.d("Successful shutdown of httpclient");
                            SplitFactoryImpl.this.mManager.destroy();
                            Logger.d("Successful shutdown of manager");
                            SplitFactoryImpl.this.mSplitTaskExecutor.stop();
                            splitSingleThreadTaskExecutor.stop();
                            Logger.d("Successful shutdown of task executor");
                            SplitFactoryImpl.this.mStorageContainer.getAttributesStorageContainer().destroy();
                            Logger.d("Successful shutdown of attributes storage");
                            SplitFactoryImpl.this.mIsTerminated = true;
                            Logger.d("SplitFactory has been destroyed");
                        }
                    } catch (Exception e) {
                        Logger.e(e, "We could not shutdown split", new Object[0]);
                    }
                } finally {
                    SplitFactoryImpl.this.mCheckClients.set(false);
                    SplitFactoryImpl.this.mInitLock.unlock();
                }
            }
        };
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: io.split.android.client.SplitFactoryImpl.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SplitFactoryImpl.this.destroy();
            }
        });
        SplitFactoryHelper.Initializer initializer = new SplitFactoryHelper.Initializer(apiToken, config, splitTaskFactoryImpl, splitRoomDatabase, cipher, eventsManagerCoordinator, splitTaskExecutorImpl, splitSingleThreadTaskExecutor, splitStorageContainerBuildStorageContainer, syncManagerBuildSyncManager, this.mLifecycleManager, reentrantLock);
        if (config.shouldRecordTelemetry()) {
            int iCount2 = sharedInstance.count(apiToken);
            splitStorageContainerBuildStorageContainer.getTelemetryStorage().recordActiveFactories(iCount2);
            splitStorageContainerBuildStorageContainer.getTelemetryStorage().recordRedundantFactories(iCount2 - 1);
        }
        new Thread(initializer).start();
        splitTaskExecutorImpl.schedule(splitTaskFactoryImpl.createCleanUpDatabaseTask(System.currentTimeMillis() / 1000), 5L, null);
        client();
        this.mManager = new SplitManagerImpl(splitStorageContainerBuildStorageContainer.getSplitsStorage(), new SplitValidatorImpl(), splitParser);
    }

    private static SplitsStorage getSplitsStorage(SplitRoomDatabase splitDatabase, SplitCipher splitCipher) {
        return StorageFactory.getSplitsStorage(splitDatabase, splitCipher);
    }

    private static String getFlagsSpec(TestingConfig testingConfig) {
        if (testingConfig == null) {
            return BuildConfig.FLAGS_SPEC;
        }
        return testingConfig.getFlagsSpec();
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client() {
        return client(this.mDefaultClientKey);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(Key key) {
        return this.mClientContainer.getClient(key);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String matchingKey) {
        return this.mClientContainer.getClient(new Key(matchingKey));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String matchingKey, String bucketingKey) {
        return this.mClientContainer.getClient(new Key(matchingKey, bucketingKey));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitManager manager() {
        return this.mManager;
    }

    @Override // io.split.android.client.SplitFactory
    public void destroy() {
        synchronized (SplitFactoryImpl.class) {
            if (!this.mIsTerminated) {
                final ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(this.mDestroyer, 100L, TimeUnit.MILLISECONDS);
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(new Runnable() { // from class: io.split.android.client.SplitFactoryImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdown();
                        try {
                            if (scheduledExecutorServiceNewSingleThreadScheduledExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                                return;
                            }
                            scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
                        } catch (InterruptedException unused) {
                            scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
                            Thread.currentThread().interrupt();
                        }
                    }
                }, 500L, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // io.split.android.client.SplitFactory
    public void flush() {
        this.mSyncManager.flush();
    }

    @Override // io.split.android.client.SplitFactory
    public void setUserConsent(boolean enabled) {
        UserConsent userConsent = enabled ? UserConsent.GRANTED : UserConsent.DECLINED;
        if (getUserConsentManager() == null) {
            Logger.e("User consent manager not initialized. Unable to set mode " + userConsent.toString());
        } else {
            getUserConsentManager().setStatus(userConsent);
        }
    }

    private UserConsentManager getUserConsentManager() {
        if (this.mUserConsentManager == null) {
            synchronized (this.mConfig) {
                if (this.mUserConsentManager == null) {
                    this.mUserConsentManager = new UserConsentManagerImpl(this.mConfig, this.mStorageContainer.getImpressionsStorage(), this.mStorageContainer.getEventsStorage(), this.mSyncManager, this.mEventsTrackerProvider, this.mImpressionManager, this.mSplitTaskExecutor);
                }
            }
        }
        return this.mUserConsentManager;
    }

    @Override // io.split.android.client.SplitFactory
    public UserConsent getUserConsent() {
        return getUserConsentManager().getStatus();
    }

    void checkClients() {
        this.mCheckClients.set(true);
    }

    private void setupValidations(SplitClientConfig splitClientConfig) {
        ValidationConfig.getInstance().setMaximumKeyLength(splitClientConfig.maximumKeyLength());
        ValidationConfig.getInstance().setTrackEventNamePattern(splitClientConfig.trackEventNamePattern());
    }

    public static class EventsTrackerProvider {
        private volatile EventsTracker mEventsTracker;
        private final SplitsStorage mSplitsStorage;
        private final SyncManager mSyncManager;
        private final TelemetryStorage mTelemetryStorage;

        public EventsTrackerProvider(SplitsStorage splitsStorage, TelemetryStorage telemetryStorage, SyncManager syncManager) {
            this.mSplitsStorage = splitsStorage;
            this.mTelemetryStorage = telemetryStorage;
            this.mSyncManager = syncManager;
        }

        public EventsTracker getEventsTracker() {
            if (this.mEventsTracker == null) {
                synchronized (this) {
                    if (this.mEventsTracker == null) {
                        this.mEventsTracker = new EventsTrackerImpl(new EventValidatorImpl(new KeyValidatorImpl(), this.mSplitsStorage), new ValidationMessageLoggerImpl(), this.mTelemetryStorage, new PropertyValidatorImpl(), this.mSyncManager);
                    }
                }
            }
            return this.mEventsTracker;
        }
    }
}
