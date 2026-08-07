package com.box.android.data.api.models.observability;

import com.amplitude.api.AmplitudeClient;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosticsMetricsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010-JÊ\u0001\u0010@\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\u0013HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-¨\u0006H"}, d2 = {"Lcom/box/android/data/api/models/observability/DiagnosticsMetricsDTO;", "Lcom/box/android/data/api/models/observability/MetricsDTO;", "eventType", "", OAuthActivity.USER_ID, "username", "enterpriseId", "timestamp", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, RemoteConfigConstants.RequestFieldKey.APP_ID, "deviceModel", "osVersion", "platform", "message", "formattedMessage", BoxCommonConstants.EXTRA_FILE_NAME, "methodName", "methodLine", "", "status", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getEventType", "()Ljava/lang/String;", "getUserId", "getUsername", "getEnterpriseId", "getTimestamp", "()J", "getAppVersion", "getAppId", "getDeviceModel", "getOsVersion", "getPlatform", "getMessage", "getFormattedMessage", "getFileName", "getMethodName", "getMethodLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/box/android/data/api/models/observability/DiagnosticsMetricsDTO;", "equals", "", "other", "", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DiagnosticsMetricsDTO extends MetricsDTO {
    private final String appId;
    private final String appVersion;
    private final String deviceModel;
    private final Long duration;
    private final String enterpriseId;
    private final String eventType;
    private final String fileName;
    private final String formattedMessage;
    private final String message;
    private final Integer methodLine;
    private final String methodName;
    private final String osVersion;
    private final String platform;
    private final String status;
    private final long timestamp;
    private final String userId;
    private final String username;

    public static /* synthetic */ DiagnosticsMetricsDTO copy$default(DiagnosticsMetricsDTO diagnosticsMetricsDTO, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Integer num, String str14, Long l, int i, Object obj) {
        Long l2;
        String str15;
        String str16 = (i & 1) != 0 ? diagnosticsMetricsDTO.eventType : str;
        String str17 = (i & 2) != 0 ? diagnosticsMetricsDTO.userId : str2;
        String str18 = (i & 4) != 0 ? diagnosticsMetricsDTO.username : str3;
        String str19 = (i & 8) != 0 ? diagnosticsMetricsDTO.enterpriseId : str4;
        long j2 = (i & 16) != 0 ? diagnosticsMetricsDTO.timestamp : j;
        String str20 = (i & 32) != 0 ? diagnosticsMetricsDTO.appVersion : str5;
        String str21 = (i & 64) != 0 ? diagnosticsMetricsDTO.appId : str6;
        String str22 = (i & 128) != 0 ? diagnosticsMetricsDTO.deviceModel : str7;
        String str23 = (i & 256) != 0 ? diagnosticsMetricsDTO.osVersion : str8;
        String str24 = (i & 512) != 0 ? diagnosticsMetricsDTO.platform : str9;
        String str25 = (i & 1024) != 0 ? diagnosticsMetricsDTO.message : str10;
        String str26 = (i & 2048) != 0 ? diagnosticsMetricsDTO.formattedMessage : str11;
        String str27 = (i & 4096) != 0 ? diagnosticsMetricsDTO.fileName : str12;
        String str28 = str16;
        String str29 = (i & 8192) != 0 ? diagnosticsMetricsDTO.methodName : str13;
        Integer num2 = (i & 16384) != 0 ? diagnosticsMetricsDTO.methodLine : num;
        String str30 = (i & 32768) != 0 ? diagnosticsMetricsDTO.status : str14;
        if ((i & 65536) != 0) {
            str15 = str30;
            l2 = diagnosticsMetricsDTO.duration;
        } else {
            l2 = l;
            str15 = str30;
        }
        return diagnosticsMetricsDTO.copy(str28, str17, str18, str19, j2, str20, str21, str22, str23, str24, str25, str26, str27, str29, num2, str15, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getFormattedMessage() {
        return this.formattedMessage;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getMethodLine() {
        return this.methodLine;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    public final DiagnosticsMetricsDTO copy(@Json(name = "event_type") String eventType, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "az_name") String username, @Json(name = "enterprise_id") String enterpriseId, @Json(name = "timestamp") long timestamp, @Json(name = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY) String appVersion, @Json(name = "api_key") String appId, @Json(name = "human_readable_device_model") String deviceModel, @Json(name = "os") String osVersion, @Json(name = "platform") String platform, @Json(name = "message") String message, @Json(name = "formattedmessage") String formattedMessage, @Json(name = "method_file") String fileName, @Json(name = "method_name") String methodName, @Json(name = "method_line") Integer methodLine, @Json(name = "status") String status, @Json(name = "duration") Long duration) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return new DiagnosticsMetricsDTO(eventType, userId, username, enterpriseId, timestamp, appVersion, appId, deviceModel, osVersion, platform, message, formattedMessage, fileName, methodName, methodLine, status, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiagnosticsMetricsDTO)) {
            return false;
        }
        DiagnosticsMetricsDTO diagnosticsMetricsDTO = (DiagnosticsMetricsDTO) other;
        return Intrinsics.areEqual(this.eventType, diagnosticsMetricsDTO.eventType) && Intrinsics.areEqual(this.userId, diagnosticsMetricsDTO.userId) && Intrinsics.areEqual(this.username, diagnosticsMetricsDTO.username) && Intrinsics.areEqual(this.enterpriseId, diagnosticsMetricsDTO.enterpriseId) && this.timestamp == diagnosticsMetricsDTO.timestamp && Intrinsics.areEqual(this.appVersion, diagnosticsMetricsDTO.appVersion) && Intrinsics.areEqual(this.appId, diagnosticsMetricsDTO.appId) && Intrinsics.areEqual(this.deviceModel, diagnosticsMetricsDTO.deviceModel) && Intrinsics.areEqual(this.osVersion, diagnosticsMetricsDTO.osVersion) && Intrinsics.areEqual(this.platform, diagnosticsMetricsDTO.platform) && Intrinsics.areEqual(this.message, diagnosticsMetricsDTO.message) && Intrinsics.areEqual(this.formattedMessage, diagnosticsMetricsDTO.formattedMessage) && Intrinsics.areEqual(this.fileName, diagnosticsMetricsDTO.fileName) && Intrinsics.areEqual(this.methodName, diagnosticsMetricsDTO.methodName) && Intrinsics.areEqual(this.methodLine, diagnosticsMetricsDTO.methodLine) && Intrinsics.areEqual(this.status, diagnosticsMetricsDTO.status) && Intrinsics.areEqual(this.duration, diagnosticsMetricsDTO.duration);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.eventType.hashCode() * 31) + this.userId.hashCode()) * 31) + this.username.hashCode()) * 31) + this.enterpriseId.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.appVersion.hashCode()) * 31) + this.appId.hashCode()) * 31;
        String str = this.deviceModel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.osVersion;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.platform.hashCode()) * 31;
        String str3 = this.message;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.formattedMessage;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fileName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.methodName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.methodLine;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.status;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l = this.duration;
        return iHashCode9 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "DiagnosticsMetricsDTO(eventType=" + this.eventType + ", userId=" + this.userId + ", username=" + this.username + ", enterpriseId=" + this.enterpriseId + ", timestamp=" + this.timestamp + ", appVersion=" + this.appVersion + ", appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", osVersion=" + this.osVersion + ", platform=" + this.platform + ", message=" + this.message + ", formattedMessage=" + this.formattedMessage + ", fileName=" + this.fileName + ", methodName=" + this.methodName + ", methodLine=" + this.methodLine + ", status=" + this.status + ", duration=" + this.duration + ")";
    }

    @Override // com.box.android.data.api.models.observability.MetricsDTO
    public String getEventType() {
        return this.eventType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getFormattedMessage() {
        return this.formattedMessage;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final Integer getMethodLine() {
        return this.methodLine;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Long getDuration() {
        return this.duration;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsMetricsDTO(@Json(name = "event_type") String eventType, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "az_name") String username, @Json(name = "enterprise_id") String enterpriseId, @Json(name = "timestamp") long j, @Json(name = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY) String appVersion, @Json(name = "api_key") String appId, @Json(name = "human_readable_device_model") String str, @Json(name = "os") String str2, @Json(name = "platform") String platform, @Json(name = "message") String str3, @Json(name = "formattedmessage") String str4, @Json(name = "method_file") String str5, @Json(name = "method_name") String str6, @Json(name = "method_line") Integer num, @Json(name = "status") String str7, @Json(name = "duration") Long l) {
        super(MetricsCategory.DIAGNOSTICS, eventType);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.eventType = eventType;
        this.userId = userId;
        this.username = username;
        this.enterpriseId = enterpriseId;
        this.timestamp = j;
        this.appVersion = appVersion;
        this.appId = appId;
        this.deviceModel = str;
        this.osVersion = str2;
        this.platform = platform;
        this.message = str3;
        this.formattedMessage = str4;
        this.fileName = str5;
        this.methodName = str6;
        this.methodLine = num;
        this.status = str7;
        this.duration = l;
    }
}
