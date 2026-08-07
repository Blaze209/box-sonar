package io.split.android.client.service.mysegments;

import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.telemetry.model.OperationType;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsSyncTaskConfig {
    private static final MySegmentsSyncTaskConfig MY_SEGMENTS_TASK_CONFIG = new MySegmentsSyncTaskConfig(SplitTaskType.MY_SEGMENTS_SYNC, SplitInternalEvent.MY_SEGMENTS_UPDATED, SplitInternalEvent.MY_SEGMENTS_FETCHED, OperationType.MY_SEGMENT);
    private final SplitInternalEvent mFetchedEvent;
    private final SplitTaskType mTaskType;
    private final OperationType mTelemetryOperationType;
    private final SplitInternalEvent mUpdateEvent;

    private MySegmentsSyncTaskConfig(SplitTaskType taskType, SplitInternalEvent updateEvent, SplitInternalEvent fetchedEvent, OperationType telemetryOperationType) {
        this.mTaskType = taskType;
        this.mUpdateEvent = updateEvent;
        this.mFetchedEvent = fetchedEvent;
        this.mTelemetryOperationType = telemetryOperationType;
    }

    SplitTaskType getTaskType() {
        return this.mTaskType;
    }

    SplitInternalEvent getUpdateEvent() {
        return this.mUpdateEvent;
    }

    SplitInternalEvent getFetchedEvent() {
        return this.mFetchedEvent;
    }

    OperationType getTelemetryOperationType() {
        return this.mTelemetryOperationType;
    }

    public static MySegmentsSyncTaskConfig get() {
        return MY_SEGMENTS_TASK_CONFIG;
    }
}
