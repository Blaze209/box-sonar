package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.JobUploadEvent;
import com.box.android.domain.models.observability.UserMetric;
import com.box.android.domain.utils.MetricUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/observability/JobUploadEventEntityMapper;", "", "<init>", "()V", "toEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "event", "Lcom/box/android/domain/models/observability/JobUploadEvent;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobUploadEventEntityMapper {
    public static final JobUploadEventEntityMapper INSTANCE = new JobUploadEventEntityMapper();

    private JobUploadEventEntityMapper() {
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    public final MetricsEntity toEntity(JobUploadEvent event) {
        Long lValueOf;
        MetricsEventType metricsEventType;
        String logType;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        String enterpriseId;
        String username;
        String userId;
        Long runningDuration;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getRunningDuration() == null || (((runningDuration = event.getRunningDuration()) != null && runningDuration.longValue() == 0) || event.getSizeKB() == null)) {
            lValueOf = null;
        } else {
            MetricUtils metricUtils = MetricUtils.INSTANCE;
            Double sizeKB = event.getSizeKB();
            Intrinsics.checkNotNull(sizeKB);
            long jConvertKBytesToBytes = metricUtils.convertKBytesToBytes((long) sizeKB.doubleValue());
            Long runningDuration2 = event.getRunningDuration();
            Intrinsics.checkNotNull(runningDuration2);
            lValueOf = Long.valueOf(jConvertKBytesToBytes / runningDuration2.longValue());
        }
        String jobType = event.getJobType();
        int iHashCode = jobType.hashCode();
        if (iHashCode != -1688547876) {
            if (iHashCode != 174752590) {
                if (iHashCode == 943403245 && jobType.equals(JobType.AUTO_UPLOAD)) {
                    metricsEventType = MetricsEventType.AUTO_UPLOAD;
                } else {
                    metricsEventType = null;
                }
            } else if (jobType.equals(JobType.UPLOAD_FOLDER_V2)) {
                metricsEventType = MetricsEventType.FOLDER_UPLOAD;
            } else {
                metricsEventType = null;
            }
        } else if (jobType.equals(JobType.UPLOAD_FILE_V2)) {
            metricsEventType = MetricsEventType.FILE_UPLOAD;
        } else {
            metricsEventType = null;
        }
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        if (metricsEventType == null || (logType = metricsEventType.getLogType()) == null) {
            logType = "unknown upload";
        }
        String str = logType;
        String strValueOf = String.valueOf(event.getItemId());
        String folderId = event.getFolderId();
        UserMetric user = event.getUser();
        String str2 = (user == null || (userId = user.getUserId()) == null) ? "" : userId;
        UserMetric user2 = event.getUser();
        String str3 = (user2 == null || (username = user2.getUsername()) == null) ? "" : username;
        UserMetric user3 = event.getUser();
        String str4 = (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) ? "" : enterpriseId;
        long timestamp = event.getTimestamp();
        DeviceMetric device = event.getDevice();
        String str5 = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = event.getDevice();
        String str6 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = event.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = event.getDevice();
        String str7 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = event.getDevice();
        String str8 = (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform;
        boolean failed = event.getFailed();
        return new MetricsEntity(metricsCategory, str, str2, str3, str4, null, null, strValueOf, null, null, null, timestamp, str5, str6, deviceModel, str7, str8, null, event.getRunningDuration(), null, 0, null, null, null, Boolean.valueOf(failed), null, event.isRecoverable(), event.getJobManagerVersion().name(), Integer.valueOf(event.getNumberOfAutomaticRetries()), Integer.valueOf(event.getNumberOfManualRetries()), null, event.getFailReason(), null, event.getSizeKB(), event.getSizeBucket(), folderId, null, null, event.getInitiatedAt(), lValueOf, event.getTotalTime(), event.getBytesProcessed(), null, null, null, null, Boolean.valueOf(event.isNewVersionUpload()), Boolean.valueOf(event.isUserTriggeredJob()), 0L, null, null, null, 1123682144, 998449, null);
    }
}
