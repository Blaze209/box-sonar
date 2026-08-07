package io.split.android.client.service.mysegments;

import io.split.android.client.service.executor.SplitTaskType;

/* JADX INFO: loaded from: classes4.dex */
public class LoadMySegmentsTaskConfig {
    private static final LoadMySegmentsTaskConfig LOAD_MY_SEGMENTS_TASK_CONFIG = new LoadMySegmentsTaskConfig(SplitTaskType.LOAD_LOCAL_MY_SEGMENTS);
    private final SplitTaskType mTaskType;

    private LoadMySegmentsTaskConfig(SplitTaskType taskType) {
        this.mTaskType = taskType;
    }

    public SplitTaskType getTaskType() {
        return this.mTaskType;
    }

    public static LoadMySegmentsTaskConfig get() {
        return LOAD_MY_SEGMENTS_TASK_CONFIG;
    }
}
