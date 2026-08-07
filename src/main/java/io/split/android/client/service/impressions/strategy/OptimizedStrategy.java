package io.split.android.client.service.impressions.strategy;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionUtils;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.observer.ImpressionsObserver;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class OptimizedStrategy implements ProcessStrategy {
    private final ImpressionsCounter mImpressionsCounter;
    private final long mImpressionsDedupeTimeInterval;
    private final ImpressionsObserver mImpressionsObserver;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final AtomicBoolean mIsSynchronizing = new AtomicBoolean(true);
    private final SplitTaskExecutionListener mTaskExecutionListener;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    OptimizedStrategy(ImpressionsObserver impressionsObserver, ImpressionsCounter impressionsCounter, RecorderSyncHelper<KeyImpression> impressionsSyncHelper, SplitTaskExecutor taskExecutor, ImpressionsTaskFactory taskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, long impressionsDedupeTimeInterval) {
        SplitTaskExecutionListener splitTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.impressions.strategy.OptimizedStrategy.1
            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR && Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                    OptimizedStrategy.this.mIsSynchronizing.compareAndSet(true, false);
                }
            }
        };
        this.mTaskExecutionListener = splitTaskExecutionListener;
        this.mImpressionsObserver = (ImpressionsObserver) io.split.android.client.utils.Utils.checkNotNull(impressionsObserver);
        this.mImpressionsCounter = (ImpressionsCounter) io.split.android.client.utils.Utils.checkNotNull(impressionsCounter);
        RecorderSyncHelper<KeyImpression> recorderSyncHelper = (RecorderSyncHelper) io.split.android.client.utils.Utils.checkNotNull(impressionsSyncHelper);
        recorderSyncHelper.addListener(splitTaskExecutionListener);
        this.mImpressionsSyncHelper = recorderSyncHelper;
        this.mTaskExecutor = (SplitTaskExecutor) io.split.android.client.utils.Utils.checkNotNull(taskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) io.split.android.client.utils.Utils.checkNotNull(taskFactory);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) io.split.android.client.utils.Utils.checkNotNull(telemetryRuntimeProducer);
        this.mImpressionsDedupeTimeInterval = impressionsDedupeTimeInterval;
    }

    @Override // io.split.android.client.service.impressions.strategy.ProcessStrategy
    public void apply(Impression impression) {
        Long lTestAndSet = Utils.hasProperties(impression) ? null : this.mImpressionsObserver.testAndSet(impression);
        Impression impressionWithPreviousTime = impression.withPreviousTime(lTestAndSet);
        if (previousTimeIsValid(lTestAndSet)) {
            this.mImpressionsCounter.inc(impressionWithPreviousTime.split(), impressionWithPreviousTime.time(), 1);
        }
        KeyImpression keyImpressionFromImpression = KeyImpression.fromImpression(impressionWithPreviousTime);
        if (shouldPushImpression(keyImpressionFromImpression)) {
            if (this.mImpressionsSyncHelper.pushAndCheckIfFlushNeeded(keyImpressionFromImpression) && this.mIsSynchronizing.get()) {
                this.mTaskExecutor.submit(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
            }
            this.mTelemetryRuntimeProducer.recordImpressionStats(ImpressionsDataType.IMPRESSIONS_QUEUED, 1L);
            return;
        }
        this.mTelemetryRuntimeProducer.recordImpressionStats(ImpressionsDataType.IMPRESSIONS_DEDUPED, 1L);
    }

    private boolean shouldPushImpression(KeyImpression impression) {
        return impression.previousTime == null || ImpressionUtils.truncateTimeframe(impression.previousTime.longValue(), this.mImpressionsDedupeTimeInterval) != ImpressionUtils.truncateTimeframe(impression.time, this.mImpressionsDedupeTimeInterval);
    }

    private static boolean previousTimeIsValid(Long previousTime) {
        return (previousTime == null || previousTime.longValue() == 0) ? false : true;
    }
}
