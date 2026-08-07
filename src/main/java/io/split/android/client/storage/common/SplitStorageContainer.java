package io.split.android.client.storage.common;

import io.split.android.client.service.impressions.observer.PersistentImpressionsObserverCacheStorage;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.AttributesStorageContainer;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.events.EventsStorage;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.storage.impressions.ImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.rbs.PersistentRuleBasedSegmentStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.splits.PersistentSplitsStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.Utils;
import io.split.android.engine.experiments.ParserCommons;

/* JADX INFO: loaded from: classes4.dex */
public class SplitStorageContainer {
    private final AttributesStorageContainer mAttributesStorageContainer;
    private final EventsStorage mEventsStorage;
    private final GeneralInfoStorage mGeneralInfoStorage;
    private final ImpressionsStorage mImpressionsStorage;
    private final MySegmentsStorageContainer mMyLargeSegmentsStorageContainer;
    private final MySegmentsStorageContainer mMySegmentsStorageContainer;
    final ParserCommons mParserCommons;
    private final PersistentAttributesStorage mPersistentAttributesStorage;
    private final PersistentEventsStorage mPersistentEventsStorage;
    private final PersistentImpressionsCountStorage mPersistentImpressionsCountStorage;
    private final PersistentImpressionsObserverCacheStorage mPersistentImpressionsObserverCacheStorage;
    private final PersistentImpressionsStorage mPersistentImpressionsStorage;
    private final PersistentImpressionsUniqueStorage mPersistentImpressionsUniqueStorage;
    private final PersistentSplitsStorage mPersistentSplitsStorage;
    final RuleBasedSegmentStorage mRuleBasedSegmentStorage;
    private final SplitsStorage mSplitStorage;
    private final TelemetryStorage mTelemetryStorage;

    public SplitStorageContainer(SplitsStorage splitStorage, MySegmentsStorageContainer mySegmentsStorageContainer, MySegmentsStorageContainer myLargeSegmentsStorageContainer, PersistentSplitsStorage persistentSplitsStorage, EventsStorage eventsStorage, PersistentEventsStorage persistentEventsStorage, ImpressionsStorage impressionsStorage, PersistentImpressionsStorage persistentImpressionsStorage, PersistentImpressionsCountStorage persistentImpressionsCountStorage, PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorage, AttributesStorageContainer attributesStorageContainer, PersistentAttributesStorage persistentAttributesStorage, TelemetryStorage telemetryStorage, PersistentImpressionsObserverCacheStorage persistentImpressionsObserverCacheStorage, GeneralInfoStorage generalInfoStorage, PersistentRuleBasedSegmentStorage persistentRuleBasedSegmentStorage) {
        this.mSplitStorage = (SplitsStorage) Utils.checkNotNull(splitStorage);
        this.mMySegmentsStorageContainer = (MySegmentsStorageContainer) Utils.checkNotNull(mySegmentsStorageContainer);
        this.mMyLargeSegmentsStorageContainer = (MySegmentsStorageContainer) Utils.checkNotNull(myLargeSegmentsStorageContainer);
        this.mPersistentSplitsStorage = (PersistentSplitsStorage) Utils.checkNotNull(persistentSplitsStorage);
        this.mEventsStorage = (EventsStorage) Utils.checkNotNull(eventsStorage);
        this.mPersistentEventsStorage = (PersistentEventsStorage) Utils.checkNotNull(persistentEventsStorage);
        this.mImpressionsStorage = (ImpressionsStorage) Utils.checkNotNull(impressionsStorage);
        this.mPersistentImpressionsStorage = (PersistentImpressionsStorage) Utils.checkNotNull(persistentImpressionsStorage);
        this.mPersistentImpressionsCountStorage = (PersistentImpressionsCountStorage) Utils.checkNotNull(persistentImpressionsCountStorage);
        this.mAttributesStorageContainer = (AttributesStorageContainer) Utils.checkNotNull(attributesStorageContainer);
        this.mPersistentAttributesStorage = (PersistentAttributesStorage) Utils.checkNotNull(persistentAttributesStorage);
        this.mTelemetryStorage = (TelemetryStorage) Utils.checkNotNull(telemetryStorage);
        this.mPersistentImpressionsUniqueStorage = (PersistentImpressionsUniqueStorage) Utils.checkNotNull(persistentImpressionsUniqueStorage);
        this.mPersistentImpressionsObserverCacheStorage = (PersistentImpressionsObserverCacheStorage) Utils.checkNotNull(persistentImpressionsObserverCacheStorage);
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
        RuleBasedSegmentStorageInitializer.Result resultInitialize = RuleBasedSegmentStorageInitializer.initialize(mySegmentsStorageContainer, myLargeSegmentsStorageContainer, persistentRuleBasedSegmentStorage);
        this.mParserCommons = resultInitialize.getParserCommons();
        this.mRuleBasedSegmentStorage = resultInitialize.getRuleBasedSegmentStorage();
    }

    public SplitsStorage getSplitsStorage() {
        return this.mSplitStorage;
    }

    public MySegmentsStorageContainer getMySegmentsStorageContainer() {
        return this.mMySegmentsStorageContainer;
    }

    public MySegmentsStorageContainer getMyLargeSegmentsStorageContainer() {
        return this.mMyLargeSegmentsStorageContainer;
    }

    public MySegmentsStorage getMySegmentsStorage(String matchingKey) {
        return this.mMySegmentsStorageContainer.getStorageForKey(matchingKey);
    }

    public MySegmentsStorage getMyLargeSegmentsStorage(String matchingKey) {
        return this.mMyLargeSegmentsStorageContainer.getStorageForKey(matchingKey);
    }

    public PersistentSplitsStorage getPersistentSplitsStorage() {
        return this.mPersistentSplitsStorage;
    }

    public EventsStorage getEventsStorage() {
        return this.mEventsStorage;
    }

    public PersistentEventsStorage getPersistentEventsStorage() {
        return this.mPersistentEventsStorage;
    }

    public ImpressionsStorage getImpressionsStorage() {
        return this.mImpressionsStorage;
    }

    public PersistentImpressionsStorage getPersistentImpressionsStorage() {
        return this.mPersistentImpressionsStorage;
    }

    public PersistentImpressionsCountStorage getImpressionsCountStorage() {
        return this.mPersistentImpressionsCountStorage;
    }

    public AttributesStorage getAttributesStorage(String matchingKey) {
        return this.mAttributesStorageContainer.getStorageForKey(matchingKey);
    }

    public AttributesStorageContainer getAttributesStorageContainer() {
        return this.mAttributesStorageContainer;
    }

    public PersistentAttributesStorage getPersistentAttributesStorage() {
        return this.mPersistentAttributesStorage;
    }

    public TelemetryStorage getTelemetryStorage() {
        return this.mTelemetryStorage;
    }

    public PersistentImpressionsUniqueStorage getPersistentImpressionsUniqueStorage() {
        return this.mPersistentImpressionsUniqueStorage;
    }

    public PersistentImpressionsObserverCacheStorage getImpressionsObserverCachePersistentStorage() {
        return this.mPersistentImpressionsObserverCacheStorage;
    }

    public GeneralInfoStorage getGeneralInfoStorage() {
        return this.mGeneralInfoStorage;
    }

    public ParserCommons getParserCommons() {
        return this.mParserCommons;
    }

    public RuleBasedSegmentStorage getRuleBasedSegmentStorage() {
        return this.mRuleBasedSegmentStorage;
    }
}
