package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.FileActivityEvent;
import com.box.android.domain.models.observability.UserMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/observability/FileActivityEventEntityMapper;", "", "<init>", "()V", "toEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/domain/models/observability/FileActivityEvent;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityEventEntityMapper {
    public static final FileActivityEventEntityMapper INSTANCE = new FileActivityEventEntityMapper();

    private FileActivityEventEntityMapper() {
    }

    public final MetricsEntity toEntity(FileActivityEvent fileActivityEvent) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(fileActivityEvent, "<this>");
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String logType = MetricsEventType.FILE_ACTIVITY.getLogType();
        String fileActivityAction = fileActivityEvent.getFileActivityAction();
        UserMetric user = fileActivityEvent.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = fileActivityEvent.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = fileActivityEvent.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = fileActivityEvent.getTimestamp();
        DeviceMetric device = fileActivityEvent.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = fileActivityEvent.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = fileActivityEvent.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = fileActivityEvent.getDevice();
        String str3 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = fileActivityEvent.getDevice();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, null, null, null, null, null, null, timestamp, str, str2, deviceModel, str3, (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform, null, null, null, 0, fileActivityAction, null, null, Boolean.valueOf(fileActivityEvent.getFailReason() != null), null, null, null, null, null, null, fileActivityEvent.getFailReason(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 2128480224, 1048575, null);
    }
}
