package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.PreviewPM23Event;
import com.box.android.domain.models.observability.UserMetric;
import com.box.android.domain.models.preview.PreviewSourceKt;
import com.box.android.domain.models.preview.PreviewerType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/observability/PreviewEventEntityMapper;", "", "<init>", "()V", "toMetricsEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/domain/models/observability/PreviewPM23Event;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewEventEntityMapper {
    public static final PreviewEventEntityMapper INSTANCE = new PreviewEventEntityMapper();

    private PreviewEventEntityMapper() {
    }

    public final MetricsEntity toMetricsEntity(PreviewPM23Event previewPM23Event) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(previewPM23Event, "<this>");
        String fileId = previewPM23Event.getFileId();
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String logType = MetricsEventType.PREVIEW_PM23.getLogType();
        UserMetric user = previewPM23Event.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = previewPM23Event.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = previewPM23Event.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = previewPM23Event.getTimestamp();
        DeviceMetric device = previewPM23Event.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = previewPM23Event.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = previewPM23Event.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = previewPM23Event.getDevice();
        String str3 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = previewPM23Event.getDevice();
        String str4 = (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform;
        PreviewerType previewerType = previewPM23Event.getPreviewerType();
        String strName = previewerType != null ? previewerType.name() : null;
        String extension = previewPM23Event.getExtension();
        boolean failed = previewPM23Event.getFailed();
        String metricsName = PreviewSourceKt.toMetricsName(previewPM23Event.getPreviewSource());
        String failReason = previewPM23Event.getFailReason();
        Integer errorCode = previewPM23Event.getErrorCode();
        String errorMessage = previewPM23Event.getErrorMessage();
        Double sizeKB = previewPM23Event.getSizeKB();
        String sizeBucket = previewPM23Event.getSizeBucket();
        Boolean loadedFromCache = previewPM23Event.getLoadedFromCache();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, errorMessage, null, fileId, null, null, null, timestamp, str, str2, deviceModel, str3, str4, loadedFromCache != null ? String.valueOf(loadedFromCache.booleanValue()) : null, previewPM23Event.getTtiMs(), null, 0, strName, null, extension, Boolean.valueOf(failed), metricsName, null, null, null, null, null, failReason, errorCode, sizeKB, sizeBucket, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, previewPM23Event.getItemState().isEmpty() ? null : CollectionsKt.joinToString$default(previewPM23Event.getItemState(), ",", null, null, 0, null, null, 62, null), null, null, 2086143808, 917496, null);
    }
}
