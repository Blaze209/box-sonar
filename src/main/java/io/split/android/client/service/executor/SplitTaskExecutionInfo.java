package io.split.android.client.service.executor;

import io.split.android.client.utils.Utils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitTaskExecutionInfo {
    public static final String DO_NOT_RETRY = "DO_NOT_RETRY";
    public static final String NON_SENT_BYTES = "NON_SENT_BYTES";
    public static final String NON_SENT_RECORDS = "NON_SENT_RECORDS";
    private final Map<String, Object> data;
    private final SplitTaskExecutionStatus status;
    private final SplitTaskType taskType;

    public static SplitTaskExecutionInfo success(SplitTaskType taskType) {
        return new SplitTaskExecutionInfo(taskType, SplitTaskExecutionStatus.SUCCESS, new HashMap());
    }

    public static SplitTaskExecutionInfo success(SplitTaskType taskType, Map<String, Object> data) {
        return new SplitTaskExecutionInfo(taskType, SplitTaskExecutionStatus.SUCCESS, data);
    }

    public static SplitTaskExecutionInfo error(SplitTaskType taskType) {
        return new SplitTaskExecutionInfo(taskType, SplitTaskExecutionStatus.ERROR, new HashMap());
    }

    public static SplitTaskExecutionInfo error(SplitTaskType taskType, Map<String, Object> data) {
        return new SplitTaskExecutionInfo(taskType, SplitTaskExecutionStatus.ERROR, data);
    }

    private SplitTaskExecutionInfo(SplitTaskType taskType, SplitTaskExecutionStatus status, Map<String, Object> data) {
        this.taskType = (SplitTaskType) Utils.checkNotNull(taskType);
        this.status = (SplitTaskExecutionStatus) Utils.checkNotNull(status);
        this.data = (Map) Utils.checkNotNull(data);
    }

    public SplitTaskExecutionStatus getStatus() {
        return this.status;
    }

    public SplitTaskType getTaskType() {
        return this.taskType;
    }

    public Integer getIntegerValue(String paramName) {
        Object obj = this.data.get(paramName);
        if (obj != null) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        return null;
    }

    public Long getLongValue(String paramName) {
        Object obj = this.data.get(paramName);
        if (obj != null) {
            return Long.valueOf(Long.parseLong(obj.toString()));
        }
        return null;
    }

    public String getStringValue(String paramName) {
        Object obj = this.data.get(paramName);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public Boolean getBoolValue(String paramName) {
        Object obj = this.data.get(paramName);
        if (obj != null) {
            return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
        }
        return null;
    }

    public Object getObjectValue(String paramName) {
        return this.data.get(paramName);
    }
}
