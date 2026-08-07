package io.split.android.client.service.splits;

import io.split.android.client.dtos.Split;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class SplitInPlaceUpdateTask implements SplitTask {
    private final long mChangeNumber;
    private final ISplitEventsManager mEventsManager;
    private final Split mSplit;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public SplitInPlaceUpdateTask(SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, ISplitEventsManager eventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer, Split split, long changeNumber) {
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mSplitChangeProcessor = (SplitChangeProcessor) Utils.checkNotNull(splitChangeProcessor);
        this.mEventsManager = (ISplitEventsManager) Utils.checkNotNull(eventsManager);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mSplit = (Split) Utils.checkNotNull(split);
        this.mChangeNumber = changeNumber;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (this.mSplitsStorage.update(this.mSplitChangeProcessor.process(this.mSplit, this.mChangeNumber))) {
                this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_UPDATED);
            }
            this.mTelemetryRuntimeProducer.recordUpdatesFromSSE(UpdatesFromSSEEnum.SPLITS);
            Logger.v("Updated feature flag");
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
        } catch (Exception unused) {
            Logger.e("Could not update feature flag");
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
        }
    }
}
