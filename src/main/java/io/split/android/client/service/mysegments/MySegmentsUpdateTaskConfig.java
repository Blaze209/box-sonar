package io.split.android.client.service.mysegments;

import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsUpdateTaskConfig {
    private final SplitTaskType mTaskType;
    private final UpdatesFromSSEEnum mTelemetrySSEKey;
    private final SplitInternalEvent mUpdateEvent;
    private static final MySegmentsUpdateTaskConfig MY_SEGMENTS_UPDATE_TASK_CONFIG = new MySegmentsUpdateTaskConfig(SplitTaskType.MY_SEGMENTS_UPDATE, SplitInternalEvent.MY_SEGMENTS_UPDATED, UpdatesFromSSEEnum.MY_SEGMENTS);
    private static final MySegmentsUpdateTaskConfig MY_LARGE_SEGMENTS_UPDATE_TASK_CONFIG = new MySegmentsUpdateTaskConfig(SplitTaskType.MY_LARGE_SEGMENTS_UPDATE, SplitInternalEvent.MY_LARGE_SEGMENTS_UPDATED, UpdatesFromSSEEnum.MY_LARGE_SEGMENTS);

    private MySegmentsUpdateTaskConfig(SplitTaskType taskType, SplitInternalEvent updateEvent, UpdatesFromSSEEnum telemetrySSEKey) {
        this.mTaskType = taskType;
        this.mUpdateEvent = updateEvent;
        this.mTelemetrySSEKey = telemetrySSEKey;
    }

    public SplitTaskType getTaskType() {
        return this.mTaskType;
    }

    public SplitInternalEvent getUpdateEvent() {
        return this.mUpdateEvent;
    }

    public UpdatesFromSSEEnum getTelemetrySSEKey() {
        return this.mTelemetrySSEKey;
    }

    public static MySegmentsUpdateTaskConfig getForMySegments() {
        return MY_SEGMENTS_UPDATE_TASK_CONFIG;
    }

    public static MySegmentsUpdateTaskConfig getForMyLargeSegments() {
        return MY_LARGE_SEGMENTS_UPDATE_TASK_CONFIG;
    }
}
