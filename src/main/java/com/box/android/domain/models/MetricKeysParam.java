package com.box.android.domain.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: MetricsInfoProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/models/MetricKeysParam;", "", "<init>", "()V", "METRIC_FILE_ID", "", "METRIC_FOLDER_ID", "METRIC_IS_USER_TRIGGERED_JOB", "METRIC_TIME_STARTED", "METRIC_TIME_ENQUEUED", "METRIC_FILE_SIZE", "METRIC_ITEM_STATE", "METRIC_BYTES_PROCESSED", "METRIC_OVERWRITE_FILE_ID", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricKeysParam {
    public static final MetricKeysParam INSTANCE = new MetricKeysParam();
    public static final String METRIC_BYTES_PROCESSED = "metricBytesProcessed";
    public static final String METRIC_FILE_ID = "metricFileId";
    public static final String METRIC_FILE_SIZE = "metricFileSize";
    public static final String METRIC_FOLDER_ID = "metricFolderId";
    public static final String METRIC_IS_USER_TRIGGERED_JOB = "metricIsUserTriggeredJob";
    public static final String METRIC_ITEM_STATE = "metricItemState";
    public static final String METRIC_OVERWRITE_FILE_ID = "metricFileIdToOverwrite";
    public static final String METRIC_TIME_ENQUEUED = "metricTimeEnqueued";
    public static final String METRIC_TIME_STARTED = "metricTimeStarted";

    private MetricKeysParam() {
    }
}
