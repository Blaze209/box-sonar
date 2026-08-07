package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.MoveCopyEvent;
import com.box.android.domain.models.observability.UserMetric;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/observability/MoveCopyEventEntityMapper;", "", "<init>", "()V", "toEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "event", "Lcom/box/android/domain/models/observability/MoveCopyEvent;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MoveCopyEventEntityMapper {
    public static final MoveCopyEventEntityMapper INSTANCE = new MoveCopyEventEntityMapper();

    /* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MoveCopyEvent.EventType.values().length];
            try {
                iArr[MoveCopyEvent.EventType.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MoveCopyEvent.EventType.Copy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MoveCopyEventEntityMapper() {
    }

    public final MetricsEntity toEntity(MoveCopyEvent event) {
        MetricsEventType metricsEventType;
        String userId;
        String username;
        String platform;
        String osVersion;
        String enterpriseId;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.getEventType().ordinal()];
        if (i == 1) {
            metricsEventType = MetricsEventType.MOVE;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            metricsEventType = MetricsEventType.COPY;
        }
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String logType = metricsEventType.getLogType();
        String boxId = event.getRemoteId().getBoxId();
        boolean failed = event.getFailed();
        String failReason = event.getFailReason();
        String value = event.getRemoteId().getType().getValue();
        DeviceMetric device = event.getDevice();
        String str = "";
        String str2 = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = event.getDevice();
        String str3 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = event.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        UserMetric user = event.getUser();
        String str4 = (user == null || (enterpriseId = user.getEnterpriseId()) == null) ? "" : enterpriseId;
        DeviceMetric device4 = event.getDevice();
        String str5 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = event.getDevice();
        String str6 = (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform;
        long timestamp = event.getTimestamp();
        UserMetric user2 = event.getUser();
        if (user2 == null || (userId = user2.getUserId()) == null) {
            userId = "";
        }
        UserMetric user3 = event.getUser();
        if (user3 != null && (username = user3.getUsername()) != null) {
            str = username;
        }
        return new MetricsEntity(metricsCategory, logType, userId, str, str4, null, null, boxId, null, null, null, timestamp, str2, str3, deviceModel, str5, str6, null, null, null, 0, value, null, null, Boolean.valueOf(failed), null, null, event.getJobManagerVersion().name(), null, null, null, failReason, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 1994262368, 1048575, null);
    }
}
