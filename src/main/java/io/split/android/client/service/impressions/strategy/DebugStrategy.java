package io.split.android.client.service.impressions.strategy;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.observer.ImpressionsObserver;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class DebugStrategy implements ProcessStrategy {
    private final ImpressionsObserver mImpressionsObserver;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final AtomicBoolean mIsSynchronizing = new AtomicBoolean(true);
    private final SplitTaskExecutionListener mTaskExecutionListener;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    DebugStrategy(ImpressionsObserver impressionsObserver, RecorderSyncHelper<KeyImpression> impressionsSyncHelper, SplitTaskExecutor taskExecutor, ImpressionsTaskFactory taskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        SplitTaskExecutionListener splitTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.impressions.strategy.DebugStrategy.1
            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR && Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                    DebugStrategy.this.mIsSynchronizing.compareAndSet(true, false);
                }
            }
        };
        this.mTaskExecutionListener = splitTaskExecutionListener;
        this.mImpressionsObserver = (ImpressionsObserver) io.split.android.client.utils.Utils.checkNotNull(impressionsObserver);
        RecorderSyncHelper<KeyImpression> recorderSyncHelper = (RecorderSyncHelper) io.split.android.client.utils.Utils.checkNotNull(impressionsSyncHelper);
        recorderSyncHelper.addListener(splitTaskExecutionListener);
        this.mImpressionsSyncHelper = recorderSyncHelper;
        this.mTaskExecutor = (SplitTaskExecutor) io.split.android.client.utils.Utils.checkNotNull(taskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) io.split.android.client.utils.Utils.checkNotNull(taskFactory);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) io.split.android.client.utils.Utils.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.impressions.strategy.ProcessStrategy
    public void apply(Impression impression) {
        if (this.mImpressionsSyncHelper.pushAndCheckIfFlushNeeded(KeyImpression.fromImpression(impression.withPreviousTime(Utils.hasProperties(impression) ? null : this.mImpressionsObserver.testAndSet(impression)))) && this.mIsSynchronizing.get()) {
            this.mTaskExecutor.submit(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
        }
        this.mTelemetryRuntimeProducer.recordImpressionStats(ImpressionsDataType.IMPRESSIONS_QUEUED, 1L);
    }
}
