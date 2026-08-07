package io.split.android.client.service.mysegments;

import io.split.android.client.dtos.SegmentsChange;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsUpdateTask implements SplitTask {
    private final Long mChangeNumber;
    private final SplitEventsManager mEventsManager;
    private final boolean mIsAddOperation;
    private final MySegmentsStorage mMySegmentsStorage;
    private final Set<String> mSegmentNames;
    private final SplitTaskType mTaskType;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final UpdatesFromSSEEnum mTelemetrySSEKey;
    private final SplitInternalEvent mUpdateEvent;

    public MySegmentsUpdateTask(MySegmentsStorage mySegmentsStorage, boolean add, Set<String> segmentName, Long changeNumber, SplitEventsManager eventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer, MySegmentsUpdateTaskConfig config) {
        this.mMySegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(mySegmentsStorage);
        this.mSegmentNames = (Set) Utils.checkNotNull(segmentName);
        this.mChangeNumber = Long.valueOf(changeNumber == null ? -1L : changeNumber.longValue());
        this.mIsAddOperation = add;
        this.mEventsManager = (SplitEventsManager) Utils.checkNotNull(eventsManager);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mTaskType = config.getTaskType();
        this.mUpdateEvent = config.getUpdateEvent();
        this.mTelemetrySSEKey = config.getTelemetrySSEKey();
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        if (this.mIsAddOperation) {
            return add();
        }
        return remove();
    }

    private SplitTaskExecutionInfo add() {
        try {
            Set<String> all = this.mMySegmentsStorage.getAll();
            boolean z = false;
            for (String str : this.mSegmentNames) {
                if (!all.contains(str)) {
                    all.add(str);
                    z = true;
                }
            }
            if (z) {
                updateAndNotify(all);
            }
            this.mTelemetryRuntimeProducer.recordUpdatesFromSSE(this.mTelemetrySSEKey);
            Logger.d("My Segments have been updated. Added " + getSegmentNames());
            return SplitTaskExecutionInfo.success(this.mTaskType);
        } catch (Exception e) {
            logError("Unknown error while adding segment " + getSegmentNames() + ": " + e.getLocalizedMessage());
            return SplitTaskExecutionInfo.error(this.mTaskType);
        }
    }

    public SplitTaskExecutionInfo remove() {
        try {
            Set<String> all = this.mMySegmentsStorage.getAll();
            if (all.removeAll(this.mSegmentNames)) {
                updateAndNotify(all);
            }
            this.mTelemetryRuntimeProducer.recordUpdatesFromSSE(this.mTelemetrySSEKey);
            Logger.d("My Segments have been updated. Removed " + getSegmentNames());
            return SplitTaskExecutionInfo.success(this.mTaskType);
        } catch (Exception e) {
            logError("Unknown error while removing segment " + getSegmentNames() + ": " + e.getLocalizedMessage());
            return SplitTaskExecutionInfo.error(this.mTaskType);
        }
    }

    private void updateAndNotify(Set<String> segments) {
        this.mMySegmentsStorage.set(SegmentsChange.create(segments, this.mChangeNumber));
        this.mEventsManager.notifyInternalEvent(this.mUpdateEvent);
    }

    private void logError(String message) {
        Logger.e("Error while executing my segments removal task: " + message);
    }

    private String getSegmentNames() {
        return String.join(",", this.mSegmentNames);
    }
}
