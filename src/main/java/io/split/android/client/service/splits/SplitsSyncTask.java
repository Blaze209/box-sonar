package io.split.android.client.service.splits;

import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.synchronizer.SplitsChangeChecker;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsSyncTask implements SplitTask {
    private final SplitsChangeChecker mChangeChecker = new SplitsChangeChecker();
    private final ISplitEventsManager mEventsManager;
    private final int mOnDemandFetchBackoffMaxRetries;
    private final RuleBasedSegmentStorageProducer mRuleBasedSegmentStorage;
    private final String mSplitsFilterQueryStringFromConfig;
    private final SplitsStorage mSplitsStorage;
    private final SplitsSyncHelper mSplitsSyncHelper;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public static SplitsSyncTask build(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, RuleBasedSegmentStorageProducer ruleBasedSegmentStorage, String splitsFilterQueryString, ISplitEventsManager eventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        return new SplitsSyncTask(splitsSyncHelper, splitsStorage, ruleBasedSegmentStorage, splitsFilterQueryString, telemetryRuntimeProducer, eventsManager, 10);
    }

    public static SplitTask buildForBackground(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, RuleBasedSegmentStorageProducer ruleBasedSegmentStorage, String splitsFilterQueryString, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        return new SplitsSyncTask(splitsSyncHelper, splitsStorage, ruleBasedSegmentStorage, splitsFilterQueryString, telemetryRuntimeProducer, null, 1);
    }

    private SplitsSyncTask(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, RuleBasedSegmentStorageProducer ruleBasedSegmentStorage, String splitsFilterQueryString, TelemetryRuntimeProducer telemetryRuntimeProducer, ISplitEventsManager eventsManager, int onDemandFetchBackoffMaxRetries) {
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mSplitsSyncHelper = (SplitsSyncHelper) Utils.checkNotNull(splitsSyncHelper);
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorageProducer) Utils.checkNotNull(ruleBasedSegmentStorage);
        this.mSplitsFilterQueryStringFromConfig = splitsFilterQueryString;
        this.mEventsManager = eventsManager;
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mOnDemandFetchBackoffMaxRetries = onDemandFetchBackoffMaxRetries;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        long till = this.mSplitsStorage.getTill();
        long changeNumber = this.mRuleBasedSegmentStorage.getChangeNumber();
        boolean zSplitsFilterHasChanged = splitsFilterHasChanged(this.mSplitsStorage.getSplitsFilterQueryString());
        if (zSplitsFilterHasChanged) {
            this.mSplitsStorage.updateSplitsFilterQueryString(this.mSplitsFilterQueryStringFromConfig);
            till = -1;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SplitTaskExecutionInfo splitTaskExecutionInfoSync = this.mSplitsSyncHelper.sync(new SplitsSyncHelper.SinceChangeNumbers(till, Long.valueOf(changeNumber)), zSplitsFilterHasChanged, zSplitsFilterHasChanged, this.mOnDemandFetchBackoffMaxRetries);
        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.SPLITS, System.currentTimeMillis() - jCurrentTimeMillis);
        if (splitTaskExecutionInfoSync.getStatus() == SplitTaskExecutionStatus.SUCCESS) {
            this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.SPLITS, System.currentTimeMillis());
            notifyInternalEvent(till);
        }
        return splitTaskExecutionInfoSync;
    }

    private void notifyInternalEvent(long storedChangeNumber) {
        if (this.mEventsManager != null) {
            SplitInternalEvent splitInternalEvent = SplitInternalEvent.SPLITS_FETCHED;
            if (this.mChangeChecker.changeNumberIsNewer(storedChangeNumber, this.mSplitsStorage.getTill())) {
                splitInternalEvent = SplitInternalEvent.SPLITS_UPDATED;
            }
            this.mEventsManager.notifyInternalEvent(splitInternalEvent);
        }
    }

    private boolean splitsFilterHasChanged(String storedSplitsFilterQueryString) {
        return !sanitizeString(this.mSplitsFilterQueryStringFromConfig).equals(sanitizeString(storedSplitsFilterQueryString));
    }

    private String sanitizeString(String string) {
        return string != null ? string : "";
    }
}
