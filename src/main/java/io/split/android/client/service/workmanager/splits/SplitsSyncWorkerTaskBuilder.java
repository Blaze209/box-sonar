package io.split.android.client.service.workmanager.splits;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.rules.RuleBasedSegmentChangeProcessor;
import io.split.android.client.service.splits.SplitChangeProcessor;
import io.split.android.client.service.splits.SplitsSyncTask;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
class SplitsSyncWorkerTaskBuilder {
    private final FetcherProvider mFetcherProvider;
    private final String mFlagsSpec;
    private final RuleBasedSegmentChangeProcessor mRuleBasedSegmentChangeProcessor;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final SyncHelperProvider mSplitsSyncHelperProvider;
    private final StorageProvider mStorageProvider;

    SplitsSyncWorkerTaskBuilder(StorageProvider storageProvider, FetcherProvider fetcherProvider, SplitChangeProcessor splitChangeProcessor, RuleBasedSegmentChangeProcessor ruleBasedSegmentChangeProcessor, SyncHelperProvider splitsSyncHelperProvider, String flagsSpec) {
        this.mStorageProvider = storageProvider;
        this.mFetcherProvider = fetcherProvider;
        this.mSplitsSyncHelperProvider = splitsSyncHelperProvider;
        this.mSplitChangeProcessor = splitChangeProcessor;
        this.mRuleBasedSegmentChangeProcessor = ruleBasedSegmentChangeProcessor;
        this.mFlagsSpec = flagsSpec;
    }

    SplitTask getTask() {
        try {
            SplitsStorage splitsStorageProvideSplitsStorage = this.mStorageProvider.provideSplitsStorage();
            TelemetryStorage telemetryStorageProvideTelemetryStorage = this.mStorageProvider.provideTelemetryStorage();
            RuleBasedSegmentStorageProducer ruleBasedSegmentStorageProducerProvideRuleBasedSegmentStorage = this.mStorageProvider.provideRuleBasedSegmentStorage();
            GeneralInfoStorage generalInfoStorageProvideGeneralInfoStorage = this.mStorageProvider.provideGeneralInfoStorage();
            String splitsFilterQueryString = splitsStorageProvideSplitsStorage.getSplitsFilterQueryString();
            return SplitsSyncTask.buildForBackground(this.mSplitsSyncHelperProvider.provideSplitsSyncHelper(this.mFetcherProvider.provideFetcher(splitsFilterQueryString), splitsStorageProvideSplitsStorage, this.mSplitChangeProcessor, this.mRuleBasedSegmentChangeProcessor, ruleBasedSegmentStorageProducerProvideRuleBasedSegmentStorage, generalInfoStorageProvideGeneralInfoStorage, telemetryStorageProvideTelemetryStorage, this.mFlagsSpec), splitsStorageProvideSplitsStorage, ruleBasedSegmentStorageProducerProvideRuleBasedSegmentStorage, splitsFilterQueryString, telemetryStorageProvideTelemetryStorage);
        } catch (URISyntaxException e) {
            Logger.e("Error creating Split worker: " + e.getMessage());
            return null;
        }
    }
}
