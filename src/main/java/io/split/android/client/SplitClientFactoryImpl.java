package io.split.android.client;

import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManagerFactory;
import io.split.android.client.attributes.AttributesManagerFactoryImpl;
import io.split.android.client.attributes.AttributesMergerImpl;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.telemetry.storage.TelemetryInitProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.validators.AttributesValidatorImpl;
import io.split.android.client.validators.KeyValidator;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.TreatmentManagerFactory;
import io.split.android.client.validators.TreatmentManagerFactoryImpl;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.engine.experiments.SplitParser;

/* JADX INFO: loaded from: classes4.dex */
public class SplitClientFactoryImpl implements SplitClientFactory {
    private final AttributesManagerFactory mAttributesManagerFactory;
    private final SplitClientContainer mClientContainer;
    private final SplitClientConfig mConfig;
    private final ImpressionListener.FederatedImpressionListener mCustomerImpressionListener;
    private final SplitFactoryImpl.EventsTrackerProvider mEventsTrackerProvider;
    private final SplitFactory mSplitFactory;
    private final SplitParser mSplitParser;
    private final SplitValidatorImpl mSplitValidator;
    private final SplitStorageContainer mStorageContainer;
    private final TelemetrySynchronizer mTelemetrySynchronizer;
    private final TreatmentManagerFactory mTreatmentManagerFactory;

    public SplitClientFactoryImpl(SplitFactory splitFactory, SplitClientContainer clientContainer, SplitClientConfig config, SyncManager syncManager, TelemetrySynchronizer telemetrySynchronizer, SplitStorageContainer storageContainer, SplitTaskExecutor splitTaskExecutor, ValidationMessageLogger validationLogger, KeyValidator keyValidator, SplitFactoryImpl.EventsTrackerProvider eventsTrackerProvider, ImpressionListener.FederatedImpressionListener customerImpressionListener, FlagSetsFilter flagSetsFilter, SplitParser splitParser) {
        this.mSplitFactory = (SplitFactory) Utils.checkNotNull(splitFactory);
        this.mClientContainer = (SplitClientContainer) Utils.checkNotNull(clientContainer);
        this.mConfig = (SplitClientConfig) Utils.checkNotNull(config);
        SplitStorageContainer splitStorageContainer = (SplitStorageContainer) Utils.checkNotNull(storageContainer);
        this.mStorageContainer = splitStorageContainer;
        this.mTelemetrySynchronizer = (TelemetrySynchronizer) Utils.checkNotNull(telemetrySynchronizer);
        this.mCustomerImpressionListener = (ImpressionListener.FederatedImpressionListener) Utils.checkNotNull(customerImpressionListener);
        this.mEventsTrackerProvider = (SplitFactoryImpl.EventsTrackerProvider) Utils.checkNotNull(eventsTrackerProvider);
        this.mAttributesManagerFactory = getAttributesManagerFactory(config.persistentAttributesEnabled(), validationLogger, splitTaskExecutor, splitStorageContainer.getPersistentAttributesStorage());
        this.mSplitParser = splitParser;
        SplitValidatorImpl splitValidatorImpl = new SplitValidatorImpl();
        this.mSplitValidator = splitValidatorImpl;
        this.mTreatmentManagerFactory = new TreatmentManagerFactoryImpl(keyValidator, splitValidatorImpl, customerImpressionListener, config.labelsEnabled(), new AttributesMergerImpl(), splitStorageContainer.getTelemetryStorage(), splitParser, flagSetsFilter, splitStorageContainer.getSplitsStorage());
    }

    @Override // io.split.android.client.SplitClientFactory
    public SplitClient getClient(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager eventsManager, boolean isDefaultClient) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AttributesStorage attributesStorage = this.mStorageContainer.getAttributesStorage(key.matchingKey());
        SplitClientImpl splitClientImpl = new SplitClientImpl(this.mSplitFactory, this.mClientContainer, key, this.mSplitParser, this.mCustomerImpressionListener, this.mConfig, eventsManager, this.mEventsTrackerProvider.getEventsTracker(), this.mAttributesManagerFactory.getManager(key.matchingKey(), attributesStorage), this.mSplitValidator, this.mTreatmentManagerFactory.getTreatmentManager(key, eventsManager, this.mAttributesManagerFactory.getManager(key.matchingKey(), attributesStorage)));
        eventsManager.getExecutorResources().setSplitClient(splitClientImpl);
        if (isDefaultClient) {
            registerTelemetryTasksInEventManager(eventsManager, this.mTelemetrySynchronizer, this.mStorageContainer.getTelemetryStorage(), jCurrentTimeMillis, this.mConfig.shouldRecordTelemetry());
        }
        return splitClientImpl;
    }

    private AttributesManagerFactory getAttributesManagerFactory(boolean persistentAttributesEnabled, ValidationMessageLogger validationLogger, SplitTaskExecutor _splitTaskExecutor, PersistentAttributesStorage persistentAttributesStorage) {
        if (persistentAttributesEnabled) {
            return new AttributesManagerFactoryImpl(new AttributesValidatorImpl(), validationLogger, persistentAttributesStorage, _splitTaskExecutor);
        }
        return new AttributesManagerFactoryImpl(new AttributesValidatorImpl(), validationLogger);
    }

    private void registerTelemetryTasksInEventManager(SplitEventsManager eventsManager, final TelemetrySynchronizer telemetrySynchronizer, final TelemetryInitProducer telemetryInitProducer, final long initializationStartTime, boolean shouldRecordTelemetry) {
        if (shouldRecordTelemetry) {
            eventsManager.register(SplitEvent.SDK_READY_FROM_CACHE, new SplitEventTask() { // from class: io.split.android.client.SplitClientFactoryImpl.1
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient client) {
                    telemetryInitProducer.recordTimeUntilReadyFromCache(System.currentTimeMillis() - initializationStartTime);
                }
            });
            eventsManager.register(SplitEvent.SDK_READY, new SplitEventTask() { // from class: io.split.android.client.SplitClientFactoryImpl.2
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient client) {
                    telemetryInitProducer.recordTimeUntilReady(System.currentTimeMillis() - initializationStartTime);
                    telemetrySynchronizer.synchronizeConfig();
                }
            });
        }
    }
}
