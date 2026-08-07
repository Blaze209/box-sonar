package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.domain.models.observability.ApdexGen204Metric;
import com.box.android.domain.models.observability.AuthEvent;
import com.box.android.domain.models.observability.BoxAiEvent;
import com.box.android.domain.models.observability.BrowsePerformanceEvent;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.ForceUpdateEvent;
import com.box.android.domain.models.observability.Gen204ActionCompletionStatus;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.models.observability.HubAssetLoadingEvent;
import com.box.android.domain.models.observability.HubListLoadingEvent;
import com.box.android.domain.models.observability.LogEvent;
import com.box.android.domain.models.observability.MsalEvent;
import com.box.android.domain.models.observability.PerformanceEvent;
import com.box.android.domain.models.observability.UserMetric;
import com.box.android.domain.models.observability.XPlatformEvent;
import com.box.android.domain.models.preview.BoxAiActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\t*\u00020\f\u001a\n\u0010\b\u001a\u00020\t*\u00020\r\u001a\n\u0010\b\u001a\u00020\t*\u00020\u000e\u001a\n\u0010\b\u001a\u00020\t*\u00020\u000f\u001a\u001c\u0010\u0010\u001a\u00020\t*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0015\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0016\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0017¨\u0006\u0018"}, d2 = {"asMetricEventType", "Lcom/box/android/data/persistence/logging/MetricsEventType;", "Lcom/box/android/domain/models/observability/LogEvent$Priority;", "Lcom/box/android/domain/models/observability/PerformanceEvent$Type;", "toMetricsEventType", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "toFolderId", "", "toMetricsEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/domain/models/observability/BoxAiEvent;", "toEntity", "Lcom/box/android/domain/models/observability/ApdexGen204Metric;", "Lcom/box/android/domain/models/observability/MsalEvent;", "Lcom/box/android/domain/models/observability/HubListLoadingEvent;", "Lcom/box/android/domain/models/observability/HubAssetLoadingEvent;", "populateRequiredFields", "Lcom/box/android/domain/models/observability/Gen204Event;", "category", "Lcom/box/android/data/persistence/logging/MetricsCategory;", "eventType", "Lcom/box/android/domain/models/observability/AuthEvent;", "Lcom/box/android/domain/models/observability/XPlatformEvent;", "Lcom/box/android/domain/models/observability/ForceUpdateEvent;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MetricsModelEntityMapperKt {

    /* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[LogEvent.Priority.values().length];
            try {
                iArr[LogEvent.Priority.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogEvent.Priority.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogEvent.Priority.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PerformanceEvent.Type.values().length];
            try {
                iArr2[PerformanceEvent.Type.SEARCH_API.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[MsalEvent.EventType.values().length];
            try {
                iArr3[MsalEvent.EventType.Login.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[MsalEvent.EventType.Remediate.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[MsalEvent.EventType.PolicyBlocked.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[AuthEvent.EventType.values().length];
            try {
                iArr4[AuthEvent.EventType.Login.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr4[AuthEvent.EventType.Register.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ForceUpdateEvent.EventSubType.values().length];
            try {
                iArr5[ForceUpdateEvent.EventSubType.Triggered.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr5[ForceUpdateEvent.EventSubType.InAppUpdateStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr5[ForceUpdateEvent.EventSubType.InAppUpdateResumed.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr5[ForceUpdateEvent.EventSubType.FallbackUpdateNotAvailable.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr5[ForceUpdateEvent.EventSubType.FallbackUpdateCheckFailed.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[ForceUpdateEvent.EventSubType.GooglePlayWebFallback.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ForceUpdateReason.values().length];
            try {
                iArr6[ForceUpdateReason.MIN_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr6[ForceUpdateReason.BLOCKLIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[ForceUpdateReason.GQL_VALIDATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$5 = iArr6;
        }
    }

    public static final MetricsEventType asMetricEventType(LogEvent.Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[priority.ordinal()];
        if (i == 1 || i == 2) {
            return MetricsEventType.WARNING;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return MetricsEventType.ERROR;
    }

    public static final MetricsEventType asMetricEventType(PerformanceEvent.Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (WhenMappings.$EnumSwitchMapping$1[type.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return MetricsEventType.SEARCH_API;
    }

    public static final MetricsEventType toMetricsEventType(BrowsePerformanceEvent.Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (Intrinsics.areEqual(type, BrowsePerformanceEvent.Type.AllFilesTTI.INSTANCE)) {
            return MetricsEventType.ALL_FILES_LOAD_TTI;
        }
        if (type instanceof BrowsePerformanceEvent.Type.FolderTTI) {
            return MetricsEventType.FOLDER_LOAD_TTI;
        }
        if (type instanceof BrowsePerformanceEvent.Type.FolderTTIV2) {
            return MetricsEventType.FOLDER_LOAD_TTI_V2;
        }
        if (type instanceof BrowsePerformanceEvent.Type.FullFolderLoad) {
            return MetricsEventType.FOLDER_FULL_LOAD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String toFolderId(BrowsePerformanceEvent.Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (Intrinsics.areEqual(type, BrowsePerformanceEvent.Type.AllFilesTTI.INSTANCE)) {
            return null;
        }
        if (type instanceof BrowsePerformanceEvent.Type.FolderTTI) {
            return ((BrowsePerformanceEvent.Type.FolderTTI) type).getId();
        }
        if (type instanceof BrowsePerformanceEvent.Type.FolderTTIV2) {
            return ((BrowsePerformanceEvent.Type.FolderTTIV2) type).getId();
        }
        if (type instanceof BrowsePerformanceEvent.Type.FullFolderLoad) {
            return ((BrowsePerformanceEvent.Type.FullFolderLoad) type).getId();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final MetricsEntity toMetricsEntity(BoxAiEvent boxAiEvent) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String deviceModel;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(boxAiEvent, "<this>");
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String logType = MetricsEventType.BOX_AI.getLogType();
        Set<String> extensions = boxAiEvent.getExtensions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(extensions, 10));
        Iterator<T> it = extensions.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.sorted(CollectionsKt.toSet(arrayList)), ",", null, null, 0, null, null, 62, null);
        BoxAiActionEvent boxAiActionEvent = boxAiEvent.getBoxAiActionEvent();
        BoxAiActionEvent.AiSessionCreated aiSessionCreated = boxAiActionEvent instanceof BoxAiActionEvent.AiSessionCreated ? (BoxAiActionEvent.AiSessionCreated) boxAiActionEvent : null;
        String fileSizeType = aiSessionCreated != null ? aiSessionCreated.getFileSizeType() : null;
        BoxAiActionEvent boxAiActionEvent2 = boxAiEvent.getBoxAiActionEvent();
        BoxAiActionEvent.AnswerReceived answerReceived = boxAiActionEvent2 instanceof BoxAiActionEvent.AnswerReceived ? (BoxAiActionEvent.AnswerReceived) boxAiActionEvent2 : null;
        Long lValueOf = answerReceived != null ? Long.valueOf(answerReceived.getTimeToReceiveResponse()) : null;
        Integer numFiles = boxAiEvent.getNumFiles();
        boolean z = boxAiEvent.getBoxAiActionEvent().getFailReason() != null;
        DomainError failReason = boxAiEvent.getBoxAiActionEvent().getFailReason();
        String string = failReason != null ? failReason.toString() : null;
        Integer wordCount = boxAiEvent.getBoxAiActionEvent().getWordCount();
        String metricsName = boxAiEvent.getBoxAiActionEvent().getMetricsName();
        UserMetric user = boxAiEvent.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = boxAiEvent.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = boxAiEvent.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = boxAiEvent.getTimestamp();
        DeviceMetric device = boxAiEvent.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = boxAiEvent.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = boxAiEvent.getDevice();
        String str3 = (device3 == null || (deviceModel = device3.getDeviceModel()) == null) ? "" : deviceModel;
        DeviceMetric device4 = boxAiEvent.getDevice();
        String str4 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = boxAiEvent.getDevice();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, null, null, null, null, null, null, timestamp, str, str2, str3, str4, (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform, null, lValueOf, numFiles, 0, strJoinToString$default, null, metricsName, Boolean.valueOf(z), fileSizeType, null, null, null, null, null, string, null, null, null, null, null, null, null, null, null, null, wordCount, null, null, null, null, null, 0L, null, null, null, 2085750752, 1047551, null);
    }

    public static final MetricsEntity toEntity(ApdexGen204Metric apdexGen204Metric) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(apdexGen204Metric, "<this>");
        MetricsCategory metricsCategory = MetricsCategory.APDEX;
        long duration = apdexGen204Metric.getDuration();
        String eventType = apdexGen204Metric.getEventType();
        String milestone = apdexGen204Metric.getMilestone();
        UserMetric user = apdexGen204Metric.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = apdexGen204Metric.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = apdexGen204Metric.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = apdexGen204Metric.getTimestamp();
        DeviceMetric device = apdexGen204Metric.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = apdexGen204Metric.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = apdexGen204Metric.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = apdexGen204Metric.getDevice();
        String str3 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = apdexGen204Metric.getDevice();
        String str4 = (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform;
        boolean failed = apdexGen204Metric.getFailed();
        return new MetricsEntity(metricsCategory, eventType, userId, username, enterpriseId, null, null, null, null, null, null, timestamp, str, str2, deviceModel, str3, str4, null, Long.valueOf(duration), null, 0, null, milestone, null, Boolean.valueOf(failed), null, null, null, null, null, null, null, null, apdexGen204Metric.getMagnitude(), null, null, null, null, null, null, null, null, null, apdexGen204Metric.getSecondaryMeasurement(), apdexGen204Metric.getMagnitude(), apdexGen204Metric.getScore(), null, null, 0L, null, null, null, -21362720, 1034237, null);
    }

    public static final MetricsEntity toMetricsEntity(MsalEvent msalEvent) {
        MetricsEventType metricsEventType;
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String deviceModel;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(msalEvent, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$2[msalEvent.getEventType().ordinal()];
        if (i == 1) {
            metricsEventType = MetricsEventType.MSAL_LOGIN;
        } else if (i == 2) {
            metricsEventType = MetricsEventType.MSAL_REMEDIATE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            metricsEventType = MetricsEventType.MSAL_POLICY_BLOCKED;
        }
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String logType = metricsEventType.getLogType();
        Gen204ActionCompletionStatus completionStatus = msalEvent.getCompletionStatus();
        String string = completionStatus != null ? completionStatus.toString() : null;
        String failReason = msalEvent.getFailReason();
        Integer errorCode = msalEvent.getErrorCode();
        String subtype = msalEvent.getSubtype();
        UserMetric user = msalEvent.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = msalEvent.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = msalEvent.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = msalEvent.getTimestamp();
        DeviceMetric device = msalEvent.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = msalEvent.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = msalEvent.getDevice();
        String str3 = (device3 == null || (deviceModel = device3.getDeviceModel()) == null) ? "" : deviceModel;
        DeviceMetric device4 = msalEvent.getDevice();
        String str4 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = msalEvent.getDevice();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, null, null, null, null, null, null, timestamp, str, str2, str3, str4, (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform, null, null, null, 0, null, null, subtype, Boolean.valueOf(msalEvent.getFailed()), null, null, null, null, null, string, failReason, errorCode, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 1048446944, 1048574, null);
    }

    public static final MetricsEntity toMetricsEntity(HubListLoadingEvent hubListLoadingEvent) {
        Intrinsics.checkNotNullParameter(hubListLoadingEvent, "<this>");
        return MetricsEntity.copy$default(populateRequiredFields(hubListLoadingEvent, MetricsCategory.ACTIONS, MetricsEventType.HUBS), null, null, null, null, null, hubListLoadingEvent.getItemsScreenMode(), null, null, null, null, null, 0L, null, null, null, null, null, null, hubListLoadingEvent.getTtiMs(), null, 0, null, null, "list_loading", Boolean.valueOf(hubListLoadingEvent.getFailReason() != null), hubListLoadingEvent.getSortPreferences(), null, null, null, null, null, String.valueOf(hubListLoadingEvent.getFailReason()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 2088501215, 1048575, null);
    }

    public static final MetricsEntity toMetricsEntity(HubAssetLoadingEvent hubAssetLoadingEvent) {
        Intrinsics.checkNotNullParameter(hubAssetLoadingEvent, "<this>");
        return MetricsEntity.copy$default(populateRequiredFields(hubAssetLoadingEvent, MetricsCategory.ACTIONS, MetricsEventType.HUBS), null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, hubAssetLoadingEvent.getDuration(), null, 0, null, null, "asset_loading", Boolean.valueOf(hubAssetLoadingEvent.getFailReason() != null), hubAssetLoadingEvent.getAssetTypeLoaded(), null, null, null, null, null, String.valueOf(hubAssetLoadingEvent.getFailReason()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 2088501247, 1048575, null);
    }

    private static final MetricsEntity populateRequiredFields(Gen204Event gen204Event, MetricsCategory metricsCategory, MetricsEventType metricsEventType) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        String logType = metricsEventType.getLogType();
        UserMetric user = gen204Event.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = gen204Event.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = gen204Event.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = gen204Event.getTimestamp();
        DeviceMetric device = gen204Event.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = gen204Event.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = gen204Event.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = gen204Event.getDevice();
        String str3 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = gen204Event.getDevice();
        return new MetricsEntity(metricsCategory, logType, userId, username, enterpriseId, null, null, null, null, null, null, timestamp, str, str2, deviceModel, str3, (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, -129056, 1048575, null);
    }

    public static final MetricsEntity toMetricsEntity(AuthEvent authEvent) {
        MetricsEventType metricsEventType;
        Intrinsics.checkNotNullParameter(authEvent, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$3[authEvent.getEventType().ordinal()];
        if (i == 1) {
            metricsEventType = MetricsEventType.LOGIN;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            metricsEventType = MetricsEventType.REGISTER;
        }
        MetricsEntity metricsEntityPopulateRequiredFields = populateRequiredFields(authEvent, MetricsCategory.ACTIONS, metricsEventType);
        Gen204ActionCompletionStatus completionStatus = authEvent.getCompletionStatus();
        return MetricsEntity.copy$default(metricsEntityPopulateRequiredFields, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, 0, null, null, null, Boolean.valueOf(authEvent.getFailed()), null, null, null, null, null, completionStatus != null ? completionStatus.toString() : null, authEvent.getFailReason(), authEvent.getErrorCode(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 1056964607, 1048574, null);
    }

    public static final MetricsEntity toMetricsEntity(XPlatformEvent xPlatformEvent) {
        String userId;
        String username;
        String enterpriseId;
        String platform;
        String osVersion;
        String appId;
        String appVersion;
        Intrinsics.checkNotNullParameter(xPlatformEvent, "<this>");
        MetricsCategory metricsCategory = MetricsCategory.ACTIONS;
        String name = xPlatformEvent.getName();
        String status = xPlatformEvent.getStatus();
        String errorMessage = xPlatformEvent.getErrorMessage();
        String errorCode = xPlatformEvent.getErrorCode();
        String moduleId = xPlatformEvent.getModuleId();
        String appMode = xPlatformEvent.getAppMode();
        String source = xPlatformEvent.getSource();
        String data = xPlatformEvent.getData();
        String sessionId = xPlatformEvent.getSessionId();
        String agentId = xPlatformEvent.getAgentId();
        String turnId = xPlatformEvent.getTurnId();
        String traceId = xPlatformEvent.getTraceId();
        String agentReleaseState = xPlatformEvent.getAgentReleaseState();
        Long duration = xPlatformEvent.getDuration();
        UserMetric user = xPlatformEvent.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        UserMetric user2 = xPlatformEvent.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        UserMetric user3 = xPlatformEvent.getUser();
        if (user3 == null || (enterpriseId = user3.getEnterpriseId()) == null) {
            enterpriseId = "";
        }
        long timestamp = xPlatformEvent.getTimestamp();
        DeviceMetric device = xPlatformEvent.getDevice();
        String str = (device == null || (appVersion = device.getAppVersion()) == null) ? "" : appVersion;
        DeviceMetric device2 = xPlatformEvent.getDevice();
        String str2 = (device2 == null || (appId = device2.getAppId()) == null) ? "" : appId;
        DeviceMetric device3 = xPlatformEvent.getDevice();
        String deviceModel = device3 != null ? device3.getDeviceModel() : null;
        DeviceMetric device4 = xPlatformEvent.getDevice();
        String str3 = (device4 == null || (osVersion = device4.getOsVersion()) == null) ? "" : osVersion;
        DeviceMetric device5 = xPlatformEvent.getDevice();
        return new MetricsEntity(metricsCategory, name, userId, username, enterpriseId, errorMessage, null, turnId, null, null, null, timestamp, str, str2, deviceModel, str3, (device5 == null || (platform = device5.getPlatform()) == null) ? "" : platform, null, duration, null, 0, appMode, null, sessionId, null, data, null, agentId, null, null, status, errorCode, null, null, null, traceId, null, null, null, null, null, null, null, null, null, null, null, null, 0L, agentReleaseState, moduleId, source, 895092544, 131063, null);
    }

    public static final MetricsEntity toMetricsEntity(ForceUpdateEvent forceUpdateEvent) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(forceUpdateEvent, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$4[forceUpdateEvent.getEventSubType().ordinal()]) {
            case 1:
                str = "triggered";
                break;
            case 2:
                str = "in_app_update_started";
                break;
            case 3:
                str = "in_app_update_resumed";
                break;
            case 4:
                str = "fallback_update_not_available";
                break;
            case 5:
                str = "fallback_update_check_failed";
                break;
            case 6:
                str = "google_play_web_fallback";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String str3 = str;
        ForceUpdateReason forceUpdateReason = forceUpdateEvent.getForceUpdateReason();
        int i = forceUpdateReason == null ? -1 : WhenMappings.$EnumSwitchMapping$5[forceUpdateReason.ordinal()];
        if (i == -1) {
            str2 = null;
        } else if (i == 1) {
            str2 = "min_version";
        } else if (i == 2) {
            str2 = "blocklist";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = "gql_validation";
        }
        return MetricsEntity.copy$default(populateRequiredFields(forceUpdateEvent, MetricsCategory.ACTIONS, MetricsEventType.FORCE_UPDATE), null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, 0, null, null, str3, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, -41943041, 1048575, null);
    }
}
