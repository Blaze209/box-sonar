package io.split.android.client.service.mysegments;

import io.split.android.client.dtos.AllSegmentsChange;
import io.split.android.client.dtos.SegmentsChange;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.service.synchronizer.MySegmentsChangeChecker;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsSyncTask implements SplitTask {
    private static final String TILL_PARAM = "till";
    private final boolean mAvoidCache;
    private final BackoffCounter mBackoffCounter;
    private final SplitEventsManager mEventsManager;
    private final SplitInternalEvent mFetchedEvent;
    private final MySegmentsStorage mMyLargeSegmentsStorage;
    private final MySegmentsChangeChecker mMySegmentsChangeChecker;
    private final HttpFetcher<AllSegmentsChange> mMySegmentsFetcher;
    private final MySegmentsStorage mMySegmentsStorage;
    private final int mOnDemandFetchBackoffMaxRetries;
    private final Long mTargetLargeSegmentsChangeNumber;
    private final Long mTargetSegmentsChangeNumber;
    private final SplitTaskType mTaskType;
    private final OperationType mTelemetryOperationType;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final SplitInternalEvent mUpdateEvent;

    public MySegmentsSyncTask(HttpFetcher<AllSegmentsChange> mySegmentsFetcher, MySegmentsStorage mySegmentsStorage, MySegmentsStorage myLargeSegmentsStorage, boolean avoidCache, SplitEventsManager eventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer, MySegmentsSyncTaskConfig config, Long targetSegmentsChangeNumber, Long targetLargeSegmentsChangeNumber) {
        this(mySegmentsFetcher, mySegmentsStorage, myLargeSegmentsStorage, avoidCache, eventsManager, new MySegmentsChangeChecker(), telemetryRuntimeProducer, config, targetSegmentsChangeNumber, targetLargeSegmentsChangeNumber, new ReconnectBackoffCounter(1, 60), 10);
    }

    public MySegmentsSyncTask(HttpFetcher<AllSegmentsChange> mySegmentsFetcher, MySegmentsStorage mySegmentsStorage, MySegmentsStorage myLargeSegmentsStorage, boolean avoidCache, SplitEventsManager eventsManager, MySegmentsChangeChecker mySegmentsChangeChecker, TelemetryRuntimeProducer telemetryRuntimeProducer, MySegmentsSyncTaskConfig config, Long targetSegmentsChangeNumber, Long targetLargeSegmentsChangeNumber, BackoffCounter backoffCounter, int onDemandFetchBackoffMaxRetries) {
        this.mMySegmentsFetcher = (HttpFetcher) Utils.checkNotNull(mySegmentsFetcher);
        this.mMySegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(mySegmentsStorage);
        this.mMyLargeSegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(myLargeSegmentsStorage);
        this.mAvoidCache = avoidCache;
        this.mEventsManager = eventsManager;
        this.mMySegmentsChangeChecker = mySegmentsChangeChecker;
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mTaskType = config.getTaskType();
        this.mUpdateEvent = config.getUpdateEvent();
        this.mFetchedEvent = config.getFetchedEvent();
        this.mTelemetryOperationType = config.getTelemetryOperationType();
        this.mTargetSegmentsChangeNumber = targetSegmentsChangeNumber;
        this.mTargetLargeSegmentsChangeNumber = targetLargeSegmentsChangeNumber;
        this.mBackoffCounter = backoffCounter;
        this.mOnDemandFetchBackoffMaxRetries = onDemandFetchBackoffMaxRetries;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() throws Throwable {
        SplitTaskExecutionInfo splitTaskExecutionInfoError;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = 0;
        try {
            try {
                if (targetChangeNumberIsOutdated()) {
                    Logger.v("Target CN is outdated. Skipping membership fetch");
                    splitTaskExecutionInfoError = SplitTaskExecutionInfo.success(this.mTaskType);
                    this.mTelemetryRuntimeProducer.recordSyncLatency(this.mTelemetryOperationType, j);
                    return splitTaskExecutionInfoError;
                }
                fetch(this.mOnDemandFetchBackoffMaxRetries);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis2 - jCurrentTimeMillis;
                try {
                    this.mTelemetryRuntimeProducer.recordSuccessfulSync(this.mTelemetryOperationType, jCurrentTimeMillis2);
                    this.mTelemetryRuntimeProducer.recordSyncLatency(this.mTelemetryOperationType, j2);
                    Logger.d("My Segments have been updated");
                    return SplitTaskExecutionInfo.success(this.mTaskType);
                } catch (HttpFetcherException e) {
                    e = e;
                    j = j2;
                    logError("Network error while retrieving memberships: " + e.getLocalizedMessage());
                    this.mTelemetryRuntimeProducer.recordSyncError(this.mTelemetryOperationType, e.getHttpStatus());
                    if (HttpStatus.isNotRetryable(HttpStatus.fromCode(e.getHttpStatus()))) {
                        splitTaskExecutionInfoError = SplitTaskExecutionInfo.error(this.mTaskType, Collections.singletonMap(SplitTaskExecutionInfo.DO_NOT_RETRY, true));
                    } else {
                        splitTaskExecutionInfoError = SplitTaskExecutionInfo.error(this.mTaskType);
                    }
                    this.mTelemetryRuntimeProducer.recordSyncLatency(this.mTelemetryOperationType, j);
                    return splitTaskExecutionInfoError;
                } catch (Exception e2) {
                    e = e2;
                    j = j2;
                    logError("Unknown error while retrieving memberships: " + e.getLocalizedMessage());
                    splitTaskExecutionInfoError = SplitTaskExecutionInfo.error(this.mTaskType);
                    this.mTelemetryRuntimeProducer.recordSyncLatency(this.mTelemetryOperationType, j);
                    return splitTaskExecutionInfoError;
                } catch (Throwable th) {
                    th = th;
                    j = j2;
                    this.mTelemetryRuntimeProducer.recordSyncLatency(this.mTelemetryOperationType, j);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (HttpFetcherException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    private boolean targetChangeNumberIsOutdated() {
        Long l = this.mTargetSegmentsChangeNumber;
        if (l != null && this.mTargetLargeSegmentsChangeNumber != null) {
            return isTargetOutdated(l, this.mMySegmentsStorage.getChangeNumber()) && isTargetOutdated(this.mTargetLargeSegmentsChangeNumber, this.mMyLargeSegmentsStorage.getChangeNumber());
        }
        Long l2 = this.mTargetLargeSegmentsChangeNumber;
        if (l2 != null) {
            return isTargetOutdated(l2, this.mMyLargeSegmentsStorage.getChangeNumber());
        }
        if (l != null) {
            return isTargetOutdated(l, this.mMySegmentsStorage.getChangeNumber());
        }
        return false;
    }

    private boolean isTargetOutdated(Long targetChangeNumber, long storageChangeNumber) {
        return ((Long) Utils.getOrDefault(targetChangeNumber, -1L)).longValue() < storageChangeNumber;
    }

    private void fetch(int initialRetries) throws InterruptedException, HttpFetcherException {
        this.mBackoffCounter.resetCounter();
        while (initialRetries > 0) {
            AllSegmentsChange allSegmentsChangeExecute = this.mMySegmentsFetcher.execute(getParams(false), getHeaders());
            if (allSegmentsChangeExecute == null) {
                throw new HttpFetcherException("", "Response is null");
            }
            if (isStaleResponse(allSegmentsChangeExecute)) {
                Logger.d("Retrying memberships fetch due to change number mismatch");
                Thread.sleep(TimeUnit.SECONDS.toMillis(this.mBackoffCounter.getNextRetryTime()));
                initialRetries--;
            } else {
                updateStorage(allSegmentsChangeExecute);
                return;
            }
        }
        AllSegmentsChange allSegmentsChangeExecute2 = this.mMySegmentsFetcher.execute(getParams(true), getHeaders());
        if (allSegmentsChangeExecute2 == null) {
            throw new HttpFetcherException("", "Response is null");
        }
        updateStorage(allSegmentsChangeExecute2);
    }

    private Map<String, Object> getParams(boolean addTill) {
        HashMap map = new HashMap();
        if (addTill) {
            map.put("till", Long.valueOf(Math.max(((Long) Utils.getOrDefault(this.mTargetSegmentsChangeNumber, -1L)).longValue(), ((Long) Utils.getOrDefault(this.mTargetLargeSegmentsChangeNumber, -1L)).longValue())));
        }
        return map;
    }

    private boolean isStaleResponse(AllSegmentsChange response) {
        return (targetMatched(this.mTargetSegmentsChangeNumber, response.getSegmentsChange()) && targetMatched(this.mTargetLargeSegmentsChangeNumber, response.getLargeSegmentsChange())) ? false : true;
    }

    private boolean targetMatched(Long targetChangeNumber, SegmentsChange change) {
        Long l = (Long) Utils.getOrDefault(targetChangeNumber, -1L);
        if (l.longValue() == -1 || change == null || change.getChangeNumber() == null) {
            return true;
        }
        return change.getChangeNumber() != null && l.longValue() <= change.getChangeNumber().longValue();
    }

    private void updateStorage(AllSegmentsChange response) {
        fireMySegmentsUpdatedIfNeeded(updateSegments(response.getSegmentsChange(), this.mMySegmentsStorage), updateSegments(response.getLargeSegmentsChange(), this.mMyLargeSegmentsStorage));
    }

    private static UpdateSegmentsResult updateSegments(SegmentsChange segmentsChange, MySegmentsStorage storage) {
        ArrayList arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList<>();
        if (segmentsChange != null) {
            arrayList = new ArrayList(storage.getAll());
            arrayList2 = segmentsChange.getNames();
            storage.set(segmentsChange);
        }
        return new UpdateSegmentsResult(arrayList, arrayList2);
    }

    private void logError(String message) {
        Logger.e("Error while executing memberships sync task: " + message);
    }

    private Map<String, String> getHeaders() {
        if (this.mAvoidCache) {
            return SplitHttpHeadersBuilder.noCacheHeaders();
        }
        return null;
    }

    private void fireMySegmentsUpdatedIfNeeded(UpdateSegmentsResult segmentsResult, UpdateSegmentsResult largeSegmentsResult) {
        if (this.mEventsManager == null) {
            return;
        }
        boolean zMySegmentsHaveChanged = this.mMySegmentsChangeChecker.mySegmentsHaveChanged(segmentsResult.oldSegments, segmentsResult.newSegments);
        boolean zMySegmentsHaveChanged2 = this.mMySegmentsChangeChecker.mySegmentsHaveChanged(largeSegmentsResult.oldSegments, largeSegmentsResult.newSegments);
        if (zMySegmentsHaveChanged) {
            Logger.v("New segments: " + segmentsResult.newSegments);
        }
        if (zMySegmentsHaveChanged2) {
            Logger.v("New large segments: " + largeSegmentsResult.newSegments);
        }
        if (zMySegmentsHaveChanged) {
            this.mEventsManager.notifyInternalEvent(this.mUpdateEvent);
        } else if (zMySegmentsHaveChanged2) {
            this.mEventsManager.notifyInternalEvent(SplitInternalEvent.MY_LARGE_SEGMENTS_UPDATED);
        } else {
            this.mEventsManager.notifyInternalEvent(this.mFetchedEvent);
        }
    }

    private static class UpdateSegmentsResult {
        public final List<String> newSegments;
        public final List<String> oldSegments;

        private UpdateSegmentsResult(List<String> oldSegments, List<String> newSegments) {
            this.oldSegments = oldSegments;
            this.newSegments = newSegments;
        }
    }
}
