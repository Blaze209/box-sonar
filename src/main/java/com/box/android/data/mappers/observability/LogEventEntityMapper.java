package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.LogEvent;
import com.box.android.domain.models.observability.ThrowableMetric;
import com.box.android.domain.models.observability.UserMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/observability/LogEventEntityMapper;", "", "<init>", "()V", "toEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "event", "Lcom/box/android/domain/models/observability/LogEvent;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LogEventEntityMapper {
    public static final LogEventEntityMapper INSTANCE = new LogEventEntityMapper();

    private LogEventEntityMapper() {
    }

    public final MetricsEntity toEntity(LogEvent event) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String appVersion;
        String appId;
        String osVersion;
        Intrinsics.checkNotNullParameter(event, "event");
        MetricsCategory metricsCategory = MetricsCategory.DIAGNOSTICS;
        String logType = MetricsModelEntityMapperKt.asMetricEventType(event.getLogLevel()).getLogType();
        UserMetric user = event.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = event.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = event.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        String message = event.getMessage();
        String tag = event.getTag();
        String str = tag != null ? tag + event.getMessage() : null;
        ThrowableMetric throwable = event.getThrowable();
        String fileName = throwable != null ? throwable.getFileName() : null;
        ThrowableMetric throwable2 = event.getThrowable();
        String methodName = throwable2 != null ? throwable2.getMethodName() : null;
        ThrowableMetric throwable3 = event.getThrowable();
        Integer numValueOf = throwable3 != null ? Integer.valueOf(throwable3.getMethodLine()) : null;
        DeviceMetric device = event.getDevice();
        String str2 = (device == null || (osVersion = device.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device2 = event.getDevice();
        String str3 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = event.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = event.getDevice();
        String str4 = (device4 == null || (appVersion = device4.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device5 = event.getDevice();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, message, str, null, fileName, methodName, numValueOf, event.getTimestamp(), str4, str3, deviceModel, str2, (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, -130944, 1048575, null);
    }
}
