package io.split.android.client.shared;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.api.Key;
import io.split.android.client.events.EventsManagerRegistry;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.attributes.AttributeTaskFactoryImpl;
import io.split.android.client.service.mysegments.MySegmentUpdateParams;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.memberships.MembershipsNotificationProcessor;
import io.split.android.client.service.sseclient.notifications.mysegments.MembershipsNotificationProcessorFactory;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorConfiguration;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorker;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry;
import io.split.android.client.service.sseclient.sseclient.SseAuthenticator;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerFactory;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerFactory;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.utils.Utils;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes4.dex */
public class ClientComponentsRegisterImpl implements ClientComponentsRegister {
    private final AttributesSynchronizerFactory mAttributesSynchronizerFactory;
    private final AttributesSynchronizerRegistry mAttributesSynchronizerRegistry;
    private final EventsManagerRegistry mEventsManagerRegistry;
    private final MembershipsNotificationProcessorFactory mMembershipsNotificationProcessorFactory;
    private final MySegmentsNotificationProcessorRegistry mMySegmentsNotificationProcessorRegistry;
    private final MySegmentsSynchronizerFactory mMySegmentsSynchronizerFactory;
    private final MySegmentsSynchronizerRegistry mMySegmentsSynchronizerRegistry;
    private final MySegmentsUpdateWorkerRegistry mMySegmentsUpdateWorkerRegistry;
    private final MySegmentsV2PayloadDecoder mMySegmentsV2PayloadDecoder;
    private final SplitClientConfig mSplitConfig;
    private final SseAuthenticator mSseAuthenticator;
    private final SplitStorageContainer mStorageContainer;

    public ClientComponentsRegisterImpl(SplitClientConfig splitConfig, MySegmentsSynchronizerFactory mySegmentsSynchronizerFactory, SplitStorageContainer storageContainer, AttributesSynchronizerFactory attributesSynchronizerFactory, AttributesSynchronizerRegistry attributesSynchronizerRegistry, MySegmentsSynchronizerRegistry mySegmentsSynchronizerRegistry, MySegmentsUpdateWorkerRegistry mySegmentsUpdateWorkerRegistry, EventsManagerRegistry eventsManagerRegistry, SseAuthenticator sseAuthenticator, MySegmentsNotificationProcessorRegistry mySegmentsNotificationProcessorRegistry, MembershipsNotificationProcessorFactory membershipsNotificationProcessorFactory, MySegmentsV2PayloadDecoder mySegmentsV2PayloadDecoder) {
        this.mSplitConfig = splitConfig;
        this.mMySegmentsSynchronizerFactory = (MySegmentsSynchronizerFactory) Utils.checkNotNull(mySegmentsSynchronizerFactory);
        this.mStorageContainer = (SplitStorageContainer) Utils.checkNotNull(storageContainer);
        this.mAttributesSynchronizerFactory = (AttributesSynchronizerFactory) Utils.checkNotNull(attributesSynchronizerFactory);
        this.mAttributesSynchronizerRegistry = (AttributesSynchronizerRegistry) Utils.checkNotNull(attributesSynchronizerRegistry);
        this.mEventsManagerRegistry = (EventsManagerRegistry) Utils.checkNotNull(eventsManagerRegistry);
        this.mMySegmentsSynchronizerRegistry = (MySegmentsSynchronizerRegistry) Utils.checkNotNull(mySegmentsSynchronizerRegistry);
        this.mMySegmentsNotificationProcessorRegistry = mySegmentsNotificationProcessorRegistry;
        this.mMySegmentsUpdateWorkerRegistry = mySegmentsUpdateWorkerRegistry;
        this.mSseAuthenticator = sseAuthenticator;
        this.mMembershipsNotificationProcessorFactory = membershipsNotificationProcessorFactory;
        this.mMySegmentsV2PayloadDecoder = mySegmentsV2PayloadDecoder;
    }

    @Override // io.split.android.client.shared.ClientComponentsRegister
    public void registerComponents(Key key, SplitEventsManager eventsManager, MySegmentsTaskFactory mySegmentsTaskFactory) {
        registerEventsManager(key, eventsManager);
        MySegmentsSynchronizer synchronizer = this.mMySegmentsSynchronizerFactory.getSynchronizer(mySegmentsTaskFactory, eventsManager, SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE, this.mSplitConfig.segmentsRefreshRate());
        registerMySegmentsSynchronizer(key, synchronizer);
        registerAttributesSynchronizer(key, eventsManager);
        if (isSyncEnabled()) {
            registerKeyInSeeAuthenticator(key);
            LinkedBlockingDeque<MySegmentUpdateParams> linkedBlockingDeque = new LinkedBlockingDeque<>();
            registerMembershipsNotificationProcessor(key, mySegmentsTaskFactory, linkedBlockingDeque);
            registerMySegmentsUpdateWorker(key, synchronizer, linkedBlockingDeque);
        }
    }

    @Override // io.split.android.client.shared.ClientComponentsRegister
    public void unregisterComponentsForKey(Key key) {
        this.mAttributesSynchronizerRegistry.unregisterAttributesSynchronizer(key.matchingKey());
        this.mMySegmentsSynchronizerRegistry.unregisterMySegmentsSynchronizer(key);
        this.mEventsManagerRegistry.unregisterEventsManager(key);
        if (isSyncEnabled()) {
            this.mSseAuthenticator.unregisterKey(key.matchingKey());
            this.mMySegmentsUpdateWorkerRegistry.unregisterMySegmentsUpdateWorker(key.matchingKey());
            this.mMySegmentsNotificationProcessorRegistry.unregisterMembershipsProcessor(key.matchingKey());
        }
    }

    private void registerAttributesSynchronizer(Key key, SplitEventsManager eventsManager) {
        this.mAttributesSynchronizerRegistry.registerAttributesSynchronizer(key.matchingKey(), this.mAttributesSynchronizerFactory.getSynchronizer(new AttributeTaskFactoryImpl(key.matchingKey(), this.mStorageContainer.getAttributesStorage(key.matchingKey())), eventsManager));
    }

    private void registerMySegmentsSynchronizer(Key key, MySegmentsSynchronizer mySegmentsSynchronizer) {
        this.mMySegmentsSynchronizerRegistry.registerMySegmentsSynchronizer(key, mySegmentsSynchronizer);
    }

    private void registerMySegmentsUpdateWorker(Key key, MySegmentsSynchronizer mySegmentsSynchronizer, LinkedBlockingDeque<MySegmentUpdateParams> notificationsQueue) {
        this.mMySegmentsUpdateWorkerRegistry.registerMySegmentsUpdateWorker(key.matchingKey(), new MySegmentsUpdateWorker(mySegmentsSynchronizer, notificationsQueue));
    }

    private void registerEventsManager(Key key, SplitEventsManager eventsManager) {
        this.mEventsManagerRegistry.registerEventsManager(key, eventsManager);
    }

    private void registerKeyInSeeAuthenticator(Key key) {
        this.mSseAuthenticator.registerKey(key.matchingKey());
    }

    private void registerMembershipsNotificationProcessor(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, LinkedBlockingDeque<MySegmentUpdateParams> notificationsQueue) {
        this.mMySegmentsNotificationProcessorRegistry.registerMembershipsNotificationProcessor(key.matchingKey(), getMembershipsNotificationProcessor(key, mySegmentsTaskFactory, notificationsQueue));
    }

    private MembershipsNotificationProcessor getMembershipsNotificationProcessor(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, LinkedBlockingDeque<MySegmentUpdateParams> mySegmentUpdateNotificationsQueue) {
        return this.mMembershipsNotificationProcessorFactory.getProcessor(new MySegmentsNotificationProcessorConfiguration(mySegmentsTaskFactory, mySegmentUpdateNotificationsQueue, key.matchingKey(), this.mMySegmentsV2PayloadDecoder.hashKey(key.matchingKey())));
    }

    private boolean isSyncEnabled() {
        return this.mSplitConfig.syncEnabled();
    }
}
