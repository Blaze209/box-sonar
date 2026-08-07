package io.split.android.client.service.executor;

import io.split.android.client.FlagSetsFilter;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFilter;
import io.split.android.client.TestingConfig;
import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.dtos.Split;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.service.CleanUpDatabaseTask;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.events.EventsRecorderTask;
import io.split.android.client.service.events.EventsRecorderTaskConfig;
import io.split.android.client.service.impressions.ImpressionsCountPerFeature;
import io.split.android.client.service.impressions.ImpressionsCountRecorderTask;
import io.split.android.client.service.impressions.ImpressionsRecorderTask;
import io.split.android.client.service.impressions.ImpressionsRecorderTaskConfig;
import io.split.android.client.service.impressions.SaveImpressionsCountTask;
import io.split.android.client.service.impressions.unique.SaveUniqueImpressionsTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTaskConfig;
import io.split.android.client.service.rules.LoadRuleBasedSegmentsTask;
import io.split.android.client.service.rules.RuleBasedSegmentChangeProcessor;
import io.split.android.client.service.rules.RuleBasedSegmentInPlaceUpdateTask;
import io.split.android.client.service.splits.FilterSplitsInCacheTask;
import io.split.android.client.service.splits.LoadSplitsTask;
import io.split.android.client.service.splits.SplitChangeProcessor;
import io.split.android.client.service.splits.SplitInPlaceUpdateTask;
import io.split.android.client.service.splits.SplitKillTask;
import io.split.android.client.service.splits.SplitsSyncHelper;
import io.split.android.client.service.splits.SplitsSyncTask;
import io.split.android.client.service.splits.SplitsUpdateTask;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.service.telemetry.TelemetryConfigRecorderTask;
import io.split.android.client.service.telemetry.TelemetryStatsRecorderTask;
import io.split.android.client.service.telemetry.TelemetryTaskFactory;
import io.split.android.client.service.telemetry.TelemetryTaskFactoryImpl;
import io.split.android.client.storage.cipher.EncryptionMigrationTask;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SplitTaskFactoryImpl implements SplitTaskFactory {
    private final ISplitEventsManager mEventsManager;
    private final List<SplitFilter> mFilters;
    private final String mFlagsSpecFromConfig;
    private final RuleBasedSegmentChangeProcessor mRuleBasedSegmentChangeProcessor;
    private final SplitApiFacade mSplitApiFacade;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final SplitClientConfig mSplitClientConfig;
    private final String mSplitsFilterQueryStringFromConfig;
    private final SplitStorageContainer mSplitsStorageContainer;
    private final SplitsSyncHelper mSplitsSyncHelper;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final TelemetryTaskFactory mTelemetryTaskFactory;

    public SplitTaskFactoryImpl(SplitClientConfig splitClientConfig, SplitApiFacade splitApiFacade, SplitStorageContainer splitStorageContainer, String splitsFilterQueryString, String flagsSpecFromConfig, ISplitEventsManager eventsManager, Map<SplitFilter.Type, SplitFilter> filters, FlagSetsFilter flagSetsFilter, TestingConfig testingConfig) {
        this.mSplitClientConfig = (SplitClientConfig) Utils.checkNotNull(splitClientConfig);
        SplitApiFacade splitApiFacade2 = (SplitApiFacade) Utils.checkNotNull(splitApiFacade);
        this.mSplitApiFacade = splitApiFacade2;
        SplitStorageContainer splitStorageContainer2 = (SplitStorageContainer) Utils.checkNotNull(splitStorageContainer);
        this.mSplitsStorageContainer = splitStorageContainer2;
        this.mSplitsFilterQueryStringFromConfig = splitsFilterQueryString;
        this.mFlagsSpecFromConfig = flagsSpecFromConfig;
        this.mEventsManager = eventsManager;
        SplitChangeProcessor splitChangeProcessor = new SplitChangeProcessor(filters, flagSetsFilter);
        this.mSplitChangeProcessor = splitChangeProcessor;
        RuleBasedSegmentChangeProcessor ruleBasedSegmentChangeProcessor = new RuleBasedSegmentChangeProcessor();
        this.mRuleBasedSegmentChangeProcessor = ruleBasedSegmentChangeProcessor;
        RuleBasedSegmentStorage ruleBasedSegmentStorage = splitStorageContainer2.getRuleBasedSegmentStorage();
        TelemetryStorage telemetryStorage = splitStorageContainer2.getTelemetryStorage();
        this.mTelemetryRuntimeProducer = telemetryStorage;
        if (testingConfig != null) {
            this.mSplitsSyncHelper = new SplitsSyncHelper(splitApiFacade2.getSplitFetcher(), splitStorageContainer2.getSplitsStorage(), splitChangeProcessor, ruleBasedSegmentChangeProcessor, ruleBasedSegmentStorage, splitStorageContainer2.getGeneralInfoStorage(), telemetryStorage, new ReconnectBackoffCounter(1, testingConfig.getCdnBackoffTime()), flagsSpecFromConfig);
        } else {
            this.mSplitsSyncHelper = new SplitsSyncHelper(splitApiFacade2.getSplitFetcher(), splitStorageContainer2.getSplitsStorage(), splitChangeProcessor, ruleBasedSegmentChangeProcessor, (RuleBasedSegmentStorageProducer) ruleBasedSegmentStorage, splitStorageContainer2.getGeneralInfoStorage(), (TelemetryRuntimeProducer) telemetryStorage, flagsSpecFromConfig, false);
        }
        this.mFilters = filters == null ? new ArrayList() : new ArrayList(filters.values());
        this.mTelemetryTaskFactory = initializeTelemetryTaskFactory(splitClientConfig, filters, telemetryStorage);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public EventsRecorderTask createEventsRecorderTask() {
        return new EventsRecorderTask(this.mSplitApiFacade.getEventsRecorder(), this.mSplitsStorageContainer.getPersistentEventsStorage(), new EventsRecorderTaskConfig(this.mSplitClientConfig.eventsPerPush()), this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public ImpressionsRecorderTask createImpressionsRecorderTask() {
        return new ImpressionsRecorderTask(this.mSplitApiFacade.getImpressionsRecorder(), this.mSplitsStorageContainer.getPersistentImpressionsStorage(), new ImpressionsRecorderTaskConfig(this.mSplitClientConfig.impressionsPerPush(), 150L, this.mSplitClientConfig.shouldRecordTelemetry()), this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitsSyncTask createSplitsSyncTask(boolean checkCacheExpiration) {
        return SplitsSyncTask.build(this.mSplitsSyncHelper, this.mSplitsStorageContainer.getSplitsStorage(), this.mSplitsStorageContainer.getRuleBasedSegmentStorage(), this.mSplitsFilterQueryStringFromConfig, this.mEventsManager, this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public LoadSplitsTask createLoadSplitsTask() {
        return new LoadSplitsTask(this.mSplitsStorageContainer.getSplitsStorage(), this.mSplitsFilterQueryStringFromConfig, this.mFlagsSpecFromConfig);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public LoadRuleBasedSegmentsTask createLoadRuleBasedSegmentsTask() {
        return new LoadRuleBasedSegmentsTask(this.mSplitsStorageContainer.getRuleBasedSegmentStorage());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitKillTask createSplitKillTask(Split split) {
        return new SplitKillTask(this.mSplitsStorageContainer.getSplitsStorage(), split, this.mEventsManager);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitsUpdateTask createSplitsUpdateTask(Long since, Long rbsSince) {
        return new SplitsUpdateTask(this.mSplitsSyncHelper, this.mSplitsStorageContainer.getSplitsStorage(), this.mSplitsStorageContainer.getRuleBasedSegmentStorage(), since, rbsSince, this.mEventsManager);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public FilterSplitsInCacheTask createFilterSplitsInCacheTask() {
        return new FilterSplitsInCacheTask(this.mSplitsStorageContainer.getPersistentSplitsStorage(), this.mFilters, this.mSplitsFilterQueryStringFromConfig);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public CleanUpDatabaseTask createCleanUpDatabaseTask(long maxTimestamp) {
        return new CleanUpDatabaseTask(this.mSplitsStorageContainer.getPersistentEventsStorage(), this.mSplitsStorageContainer.getPersistentImpressionsStorage(), this.mSplitsStorageContainer.getImpressionsCountStorage(), this.mSplitsStorageContainer.getPersistentImpressionsUniqueStorage(), this.mSplitsStorageContainer.getImpressionsObserverCachePersistentStorage(), maxTimestamp);
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public SaveImpressionsCountTask createSaveImpressionsCountTask(List<ImpressionsCountPerFeature> counts) {
        return new SaveImpressionsCountTask(this.mSplitsStorageContainer.getImpressionsCountStorage(), counts);
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public ImpressionsCountRecorderTask createImpressionsCountRecorderTask() {
        return new ImpressionsCountRecorderTask(this.mSplitApiFacade.getImpressionsCountRecorder(), this.mSplitsStorageContainer.getImpressionsCountStorage(), this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public SaveUniqueImpressionsTask createSaveUniqueImpressionsTask(Map<String, Set<String>> uniqueImpressions) {
        return new SaveUniqueImpressionsTask(this.mSplitsStorageContainer.getPersistentImpressionsUniqueStorage(), uniqueImpressions);
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public UniqueKeysRecorderTask createUniqueImpressionsRecorderTask() {
        return new UniqueKeysRecorderTask(this.mSplitApiFacade.getUniqueKeysRecorder(), this.mSplitsStorageContainer.getPersistentImpressionsUniqueStorage(), new UniqueKeysRecorderTaskConfig(this.mSplitClientConfig.mtkPerPush(), 150L));
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryConfigRecorderTask getTelemetryConfigRecorderTask() {
        return this.mTelemetryTaskFactory.getTelemetryConfigRecorderTask();
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryStatsRecorderTask getTelemetryStatsRecorderTask() {
        return this.mTelemetryTaskFactory.getTelemetryStatsRecorderTask();
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitInPlaceUpdateTask createSplitsUpdateTask(Split featureFlag, long since) {
        return new SplitInPlaceUpdateTask(this.mSplitsStorageContainer.getSplitsStorage(), this.mSplitChangeProcessor, this.mEventsManager, this.mTelemetryRuntimeProducer, featureFlag, since);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public EncryptionMigrationTask createEncryptionMigrationTask(String sdkKey, SplitRoomDatabase splitRoomDatabase, boolean encryptionEnabled, SplitCipher splitCipher) {
        return new EncryptionMigrationTask(sdkKey, splitRoomDatabase, encryptionEnabled, splitCipher);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public RuleBasedSegmentInPlaceUpdateTask createRuleBasedSegmentUpdateTask(RuleBasedSegment ruleBasedSegment, long changeNumber) {
        return new RuleBasedSegmentInPlaceUpdateTask(this.mSplitsStorageContainer.getRuleBasedSegmentStorage(), this.mRuleBasedSegmentChangeProcessor, this.mEventsManager, ruleBasedSegment, changeNumber);
    }

    private TelemetryTaskFactory initializeTelemetryTaskFactory(SplitClientConfig splitClientConfig, Map<SplitFilter.Type, SplitFilter> filters, TelemetryStorage telemetryStorage) {
        int totalValueCount;
        int invalidValueCount;
        if (filters == null || filters.isEmpty() || filters.get(SplitFilter.Type.BY_SET) == null || splitClientConfig.syncConfig() == null) {
            totalValueCount = 0;
            invalidValueCount = 0;
        } else {
            invalidValueCount = splitClientConfig.syncConfig().getInvalidValueCount();
            totalValueCount = splitClientConfig.syncConfig().getTotalValueCount();
        }
        return new TelemetryTaskFactoryImpl(this.mSplitApiFacade.getTelemetryConfigRecorder(), this.mSplitApiFacade.getTelemetryStatsRecorder(), telemetryStorage, splitClientConfig, this.mSplitsStorageContainer.getSplitsStorage(), this.mSplitsStorageContainer.getMySegmentsStorageContainer(), this.mSplitsStorageContainer.getMyLargeSegmentsStorageContainer(), totalValueCount, invalidValueCount);
    }
}
