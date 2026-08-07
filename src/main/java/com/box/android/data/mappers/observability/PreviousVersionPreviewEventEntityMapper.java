package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.PreviousVersionPreviewPM23Event;
import com.box.android.domain.models.observability.UserMetric;
import com.box.android.domain.models.preview.PreviewerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/observability/PreviousVersionPreviewEventEntityMapper;", "", "<init>", "()V", "toMetricsEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionPreviewEventEntityMapper {
    public static final PreviousVersionPreviewEventEntityMapper INSTANCE = new PreviousVersionPreviewEventEntityMapper();

    private PreviousVersionPreviewEventEntityMapper() {
    }

    public final MetricsEntity toMetricsEntity(PreviousVersionPreviewPM23Event previousVersionPreviewPM23Event) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(previousVersionPreviewPM23Event, "<this>");
        String fileId = previousVersionPreviewPM23Event.getFileId();
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String logType = MetricsEventType.PREVIOUS_VERSION_PREVIEW_PM23.getLogType();
        UserMetric user = previousVersionPreviewPM23Event.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = previousVersionPreviewPM23Event.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = previousVersionPreviewPM23Event.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = previousVersionPreviewPM23Event.getTimestamp();
        DeviceMetric device = previousVersionPreviewPM23Event.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = previousVersionPreviewPM23Event.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = previousVersionPreviewPM23Event.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = previousVersionPreviewPM23Event.getDevice();
        String str3 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = previousVersionPreviewPM23Event.getDevice();
        String str4 = (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform;
        PreviewerType previewerType = previousVersionPreviewPM23Event.getPreviewerType();
        String strName = previewerType != null ? previewerType.name() : null;
        boolean failed = previousVersionPreviewPM23Event.getFailed();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, previousVersionPreviewPM23Event.getErrorMessage(), null, fileId, null, null, null, timestamp, str, str2, deviceModel, str3, str4, null, previousVersionPreviewPM23Event.getTtiMs(), null, 0, strName, null, null, Boolean.valueOf(failed), String.valueOf(previousVersionPreviewPM23Event.getVersionNumber()), null, null, null, null, null, previousVersionPreviewPM23Event.getFailReason(), previousVersionPreviewPM23Event.getErrorCode(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 2094663488, 1048574, null);
    }
}
