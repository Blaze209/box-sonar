package io.split.android.client.service.splits;

import io.split.android.client.dtos.RuleBasedSegmentChange;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.dtos.TargetingRulesChange;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.service.rules.ProcessedRuleBasedSegmentChange;
import io.split.android.client.service.rules.RuleBasedSegmentChangeProcessor;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsSyncHelper {
    private static final long DEFAULT_PROXY_CHECK_INTERVAL_MILLIS = TimeUnit.HOURS.toMillis(1);
    private static final int ON_DEMAND_FETCH_BACKOFF_MAX_WAIT = 60;
    private static final String RBS_SINCE_PARAM = "rbSince";
    private static final String SINCE_PARAM = "since";
    private static final String TILL_PARAM = "till";
    private final BackoffCounter mBackoffCounter;
    private final OutdatedSplitProxyHandler mOutdatedSplitProxyHandler;
    private final RuleBasedSegmentChangeProcessor mRuleBasedSegmentChangeProcessor;
    private final RuleBasedSegmentStorageProducer mRuleBasedSegmentStorage;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final HttpFetcher<TargetingRulesChange> mSplitFetcher;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    private enum CdnByPassType {
        NONE,
        FLAGS,
        RBS
    }

    public SplitsSyncHelper(HttpFetcher<TargetingRulesChange> splitFetcher, SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, RuleBasedSegmentChangeProcessor ruleBasedSegmentChangeProcessor, RuleBasedSegmentStorageProducer ruleBasedSegmentStorage, GeneralInfoStorage generalInfoStorage, TelemetryRuntimeProducer telemetryRuntimeProducer, String flagsSpec, boolean forBackgroundSync) {
        this(splitFetcher, splitsStorage, splitChangeProcessor, ruleBasedSegmentChangeProcessor, ruleBasedSegmentStorage, generalInfoStorage, telemetryRuntimeProducer, new ReconnectBackoffCounter(1, 60), flagsSpec, forBackgroundSync, DEFAULT_PROXY_CHECK_INTERVAL_MILLIS);
    }

    public SplitsSyncHelper(HttpFetcher<TargetingRulesChange> splitFetcher, SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, RuleBasedSegmentChangeProcessor ruleBasedSegmentChangeProcessor, RuleBasedSegmentStorageProducer ruleBasedSegmentStorage, GeneralInfoStorage generalInfoStorage, TelemetryRuntimeProducer telemetryRuntimeProducer, BackoffCounter backoffCounter, String flagsSpec) {
        this(splitFetcher, splitsStorage, splitChangeProcessor, ruleBasedSegmentChangeProcessor, ruleBasedSegmentStorage, generalInfoStorage, telemetryRuntimeProducer, backoffCounter, flagsSpec, false, DEFAULT_PROXY_CHECK_INTERVAL_MILLIS);
    }

    public SplitsSyncHelper(HttpFetcher<TargetingRulesChange> splitFetcher, SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, RuleBasedSegmentChangeProcessor ruleBasedSegmentChangeProcessor, RuleBasedSegmentStorageProducer ruleBasedSegmentStorage, GeneralInfoStorage generalInfoStorage, TelemetryRuntimeProducer telemetryRuntimeProducer, BackoffCounter backoffCounter, String flagsSpec, boolean forBackgroundSync, long proxyCheckIntervalMillis) {
        this.mSplitFetcher = (HttpFetcher) Utils.checkNotNull(splitFetcher);
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mSplitChangeProcessor = (SplitChangeProcessor) Utils.checkNotNull(splitChangeProcessor);
        this.mRuleBasedSegmentChangeProcessor = (RuleBasedSegmentChangeProcessor) Utils.checkNotNull(ruleBasedSegmentChangeProcessor);
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorageProducer) Utils.checkNotNull(ruleBasedSegmentStorage);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mBackoffCounter = (BackoffCounter) Utils.checkNotNull(backoffCounter);
        this.mOutdatedSplitProxyHandler = new OutdatedSplitProxyHandler(flagsSpec, forBackgroundSync, generalInfoStorage, proxyCheckIntervalMillis);
    }

    public SplitTaskExecutionInfo sync(SinceChangeNumbers till, int onDemandFetchBackoffMaxRetries) {
        return sync(till, false, true, false, onDemandFetchBackoffMaxRetries);
    }

    public SplitTaskExecutionInfo sync(SinceChangeNumbers till, boolean clearBeforeUpdate, boolean resetChangeNumber, int onDemandFetchBackoffMaxRetries) {
        return sync(till, clearBeforeUpdate, false, resetChangeNumber, onDemandFetchBackoffMaxRetries);
    }

    private SplitTaskExecutionInfo sync(SinceChangeNumbers till, boolean clearBeforeUpdate, boolean avoidCache, boolean resetChangeNumber, int onDemandFetchBackoffMaxRetries) {
        SplitsSyncHelper splitsSyncHelper;
        boolean z;
        boolean z2;
        try {
            this.mOutdatedSplitProxyHandler.performProxyCheck();
            if (this.mOutdatedSplitProxyHandler.isRecoveryMode()) {
                z = true;
                z2 = true;
            } else {
                z = clearBeforeUpdate;
                z2 = resetChangeNumber;
            }
            splitsSyncHelper = this;
            try {
                CdnByPassType cdnByPassTypeAttemptSplitSync = splitsSyncHelper.attemptSplitSync(till, z, avoidCache, CdnByPassType.NONE, z2, onDemandFetchBackoffMaxRetries);
                if (cdnByPassTypeAttemptSplitSync != CdnByPassType.NONE) {
                    splitsSyncHelper.attemptSplitSync(till, z, avoidCache, cdnByPassTypeAttemptSplitSync, z2, onDemandFetchBackoffMaxRetries);
                }
                Logger.d("Feature flags have been updated");
                if (splitsSyncHelper.mOutdatedSplitProxyHandler.isRecoveryMode()) {
                    Logger.i("Resetting proxy check timestamp due to successful recovery");
                    splitsSyncHelper.mOutdatedSplitProxyHandler.resetProxyCheckTimestamp();
                }
                return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
            } catch (HttpFetcherException e) {
                e = e;
                HttpFetcherException httpFetcherException = e;
                splitsSyncHelper.logError("Network error while fetching feature flags - " + httpFetcherException.getLocalizedMessage());
                splitsSyncHelper.mTelemetryRuntimeProducer.recordSyncError(OperationType.SPLITS, httpFetcherException.getHttpStatus());
                HttpStatus httpStatusFromCode = HttpStatus.fromCode(httpFetcherException.getHttpStatus());
                if (httpStatusFromCode == HttpStatus.URI_TOO_LONG) {
                    Logger.e("SDK initialization: the amount of flag sets provided is big, causing URI length error");
                }
                if (HttpStatus.isNotRetryable(httpStatusFromCode)) {
                    return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC, Collections.singletonMap(SplitTaskExecutionInfo.DO_NOT_RETRY, true));
                }
                if (HttpStatus.isProxyOutdated(httpStatusFromCode)) {
                    try {
                        splitsSyncHelper.mOutdatedSplitProxyHandler.trackProxyError();
                    } catch (Exception e2) {
                        splitsSyncHelper.logError("Unexpected while handling outdated proxy " + e2.getLocalizedMessage());
                    }
                }
                return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
            } catch (Exception e3) {
                e = e3;
                splitsSyncHelper.logError("Unexpected while fetching feature flags" + e.getLocalizedMessage());
                return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
            }
        } catch (HttpFetcherException e4) {
            e = e4;
            splitsSyncHelper = this;
        } catch (Exception e5) {
            e = e5;
            splitsSyncHelper = this;
        }
    }

    private SplitTaskExecutionInfo handleOutdatedProxy(SinceChangeNumbers till, boolean ignoredAvoidCache, boolean resetChangeNumber, int onDemandFetchBackoffMaxRetries) throws Exception {
        return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
    }

    private CdnByPassType attemptSplitSync(SinceChangeNumbers targetChangeNumber, boolean clearBeforeUpdate, boolean avoidCache, CdnByPassType withCdnBypass, boolean resetChangeNumber, int onDemandFetchBackoffMaxRetries) throws Exception {
        this.mBackoffCounter.resetCounter();
        while (true) {
            onDemandFetchBackoffMaxRetries--;
            SinceChangeNumbers sinceChangeNumbersFetchUntil = fetchUntil(targetChangeNumber, clearBeforeUpdate, avoidCache, withCdnBypass, resetChangeNumber);
            if (targetChangeNumber.getFlagsSince() <= sinceChangeNumbersFetchUntil.getFlagsSince() && targetChangeNumber.getRbsSince() != null && sinceChangeNumbersFetchUntil.getRbsSince() != null && targetChangeNumber.getRbsSince().longValue() <= sinceChangeNumbersFetchUntil.getRbsSince().longValue()) {
                return CdnByPassType.NONE;
            }
            if (onDemandFetchBackoffMaxRetries <= 0) {
                if (targetChangeNumber.getFlagsSince() <= sinceChangeNumbersFetchUntil.getFlagsSince()) {
                    return CdnByPassType.RBS;
                }
                return CdnByPassType.FLAGS;
            }
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(this.mBackoffCounter.getNextRetryTime()));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                Logger.e("Interrupted while waiting for next retry");
            }
            resetChangeNumber = false;
        }
    }

    private SinceChangeNumbers fetchUntil(SinceChangeNumbers till, boolean clearBeforeUpdate, boolean avoidCache, CdnByPassType withCdnByPass, boolean resetChangeNumber) throws Exception {
        long till2;
        long changeNumber;
        while (true) {
            till2 = resetChangeNumber ? -1L : this.mSplitsStorage.getTill();
            changeNumber = resetChangeNumber ? -1L : this.mRuleBasedSegmentStorage.getChangeNumber();
            if (till.getFlagsSince() < till2 && (till.getRbsSince() == null || till.getRbsSince().longValue() < changeNumber)) {
                break;
            }
            TargetingRulesChange targetingRulesChangeFetchSplits = fetchSplits(new SinceChangeNumbers(till2, Long.valueOf(changeNumber)), avoidCache, withCdnByPass);
            SplitChange featureFlagsChange = targetingRulesChangeFetchSplits.getFeatureFlagsChange();
            RuleBasedSegmentChange ruleBasedSegmentsChange = targetingRulesChangeFetchSplits.getRuleBasedSegmentsChange();
            updateStorage(clearBeforeUpdate, featureFlagsChange, ruleBasedSegmentsChange);
            SinceChangeNumbers sinceChangeNumbers = new SinceChangeNumbers(featureFlagsChange.till, Long.valueOf(ruleBasedSegmentsChange.getTill()));
            if (featureFlagsChange.till == featureFlagsChange.since && ruleBasedSegmentsChange.getTill() == ruleBasedSegmentsChange.getSince()) {
                return new SinceChangeNumbers(featureFlagsChange.till, Long.valueOf(ruleBasedSegmentsChange.getTill()));
            }
            resetChangeNumber = false;
            till = sinceChangeNumbers;
            clearBeforeUpdate = false;
        }
        return new SinceChangeNumbers(till2, Long.valueOf(changeNumber));
    }

    private TargetingRulesChange fetchSplits(SinceChangeNumbers till, boolean avoidCache, CdnByPassType cdnByPassType) throws HttpFetcherException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String currentSpec = this.mOutdatedSplitProxyHandler.getCurrentSpec();
        if (currentSpec != null && !currentSpec.trim().isEmpty()) {
            linkedHashMap.put("s", currentSpec);
        }
        linkedHashMap.put(SINCE_PARAM, Long.valueOf(till.getFlagsSince()));
        if (!this.mOutdatedSplitProxyHandler.isFallbackMode() && till.getRbsSince() != null) {
            linkedHashMap.put(RBS_SINCE_PARAM, till.getRbsSince());
        }
        if (cdnByPassType == CdnByPassType.RBS) {
            linkedHashMap.put("till", till.getRbsSince());
        } else if (cdnByPassType == CdnByPassType.FLAGS) {
            linkedHashMap.put("till", Long.valueOf(till.getFlagsSince()));
        }
        return this.mSplitFetcher.execute(linkedHashMap, getHeaders(avoidCache));
    }

    private void updateStorage(boolean clearBeforeUpdate, SplitChange splitChange, RuleBasedSegmentChange ruleBasedSegmentChange) {
        if (clearBeforeUpdate) {
            this.mSplitsStorage.clear();
            this.mRuleBasedSegmentStorage.clear();
        }
        this.mSplitsStorage.update(this.mSplitChangeProcessor.process(splitChange));
        updateRbsStorage(ruleBasedSegmentChange);
    }

    private void updateRbsStorage(RuleBasedSegmentChange ruleBasedSegmentChange) {
        ProcessedRuleBasedSegmentChange processedRuleBasedSegmentChangeProcess = this.mRuleBasedSegmentChangeProcessor.process(ruleBasedSegmentChange.getSegments(), ruleBasedSegmentChange.getTill());
        this.mRuleBasedSegmentStorage.update(processedRuleBasedSegmentChangeProcess.getActive(), processedRuleBasedSegmentChangeProcess.getArchived(), processedRuleBasedSegmentChangeProcess.getChangeNumber());
    }

    private void logError(String message) {
        Logger.e("Error while executing splits sync/update task: " + message);
    }

    private Map<String, String> getHeaders(boolean avoidCache) {
        if (avoidCache) {
            return SplitHttpHeadersBuilder.noCacheHeaders();
        }
        return null;
    }

    public static class SinceChangeNumbers {
        private final long mFlagsSince;
        private final Long mRbsSince;

        public SinceChangeNumbers(long flagsSince, Long rbsSince) {
            this.mFlagsSince = flagsSince;
            this.mRbsSince = rbsSince;
        }

        public long getFlagsSince() {
            return this.mFlagsSince;
        }

        public Long getRbsSince() {
            return this.mRbsSince;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SinceChangeNumbers)) {
                return false;
            }
            SinceChangeNumbers sinceChangeNumbers = (SinceChangeNumbers) obj;
            return this.mFlagsSince == sinceChangeNumbers.mFlagsSince && this.mRbsSince == null && sinceChangeNumbers.mRbsSince == null;
        }

        public String toString() {
            return "{ff=" + this.mFlagsSince + ", rbs=" + this.mRbsSince + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
