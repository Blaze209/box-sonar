package com.box.android.data.api.models.observability;

import com.amplitude.api.AmplitudeClient;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexMetricsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0090\u0001\u00100\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014¨\u00068"}, d2 = {"Lcom/box/android/data/api/models/observability/ApdexMetricsDTO;", "Lcom/box/android/data/api/models/observability/MetricsDTO;", "eventType", "", "milestone", "duration", "magnitude", "", TelemetryEventStrings.Value.FAILED, "", "secondaryMeasurement", FirebaseAnalytics.Param.SCORE, "os", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "osVersion", OAuthActivity.USER_ID, "enterpriseId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventType", "()Ljava/lang/String;", "getMilestone", "getDuration", "getMagnitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFailed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSecondaryMeasurement", "getScore", "getOs", "getAppVersion", "getOsVersion", "getUserId", "getEnterpriseId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/data/api/models/observability/ApdexMetricsDTO;", "equals", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ApdexMetricsDTO extends MetricsDTO {
    private final String appVersion;
    private final String duration;
    private final String enterpriseId;
    private final String eventType;
    private final Boolean failed;
    private final Double magnitude;
    private final String milestone;
    private final String os;
    private final String osVersion;
    private final Double score;
    private final Double secondaryMeasurement;
    private final String userId;

    public static /* synthetic */ ApdexMetricsDTO copy$default(ApdexMetricsDTO apdexMetricsDTO, String str, String str2, String str3, Double d, Boolean bool, Double d2, Double d3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apdexMetricsDTO.eventType;
        }
        if ((i & 2) != 0) {
            str2 = apdexMetricsDTO.milestone;
        }
        if ((i & 4) != 0) {
            str3 = apdexMetricsDTO.duration;
        }
        if ((i & 8) != 0) {
            d = apdexMetricsDTO.magnitude;
        }
        if ((i & 16) != 0) {
            bool = apdexMetricsDTO.failed;
        }
        if ((i & 32) != 0) {
            d2 = apdexMetricsDTO.secondaryMeasurement;
        }
        if ((i & 64) != 0) {
            d3 = apdexMetricsDTO.score;
        }
        if ((i & 128) != 0) {
            str4 = apdexMetricsDTO.os;
        }
        if ((i & 256) != 0) {
            str5 = apdexMetricsDTO.appVersion;
        }
        if ((i & 512) != 0) {
            str6 = apdexMetricsDTO.osVersion;
        }
        if ((i & 1024) != 0) {
            str7 = apdexMetricsDTO.userId;
        }
        if ((i & 2048) != 0) {
            str8 = apdexMetricsDTO.enterpriseId;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        Double d4 = d3;
        String str13 = str4;
        Boolean bool2 = bool;
        Double d5 = d2;
        return apdexMetricsDTO.copy(str, str2, str3, d, bool2, d5, d4, str13, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMilestone() {
        return this.milestone;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getMagnitude() {
        return this.magnitude;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getSecondaryMeasurement() {
        return this.secondaryMeasurement;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    public final ApdexMetricsDTO copy(@Json(name = "event_type") String eventType, @Json(name = "milestone") String milestone, @Json(name = "duration") String duration, @Json(name = "magnitude") Double magnitude, @Json(name = TelemetryEventStrings.Value.FAILED) Boolean failed, @Json(name = "secondary_measurement") Double secondaryMeasurement, @Json(name = FirebaseAnalytics.Param.SCORE) Double score, @Json(name = "os") String os, @Json(name = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY) String appVersion, @Json(name = "os_version") String osVersion, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "enterprise_id") String enterpriseId) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        return new ApdexMetricsDTO(eventType, milestone, duration, magnitude, failed, secondaryMeasurement, score, os, appVersion, osVersion, userId, enterpriseId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApdexMetricsDTO)) {
            return false;
        }
        ApdexMetricsDTO apdexMetricsDTO = (ApdexMetricsDTO) other;
        return Intrinsics.areEqual(this.eventType, apdexMetricsDTO.eventType) && Intrinsics.areEqual(this.milestone, apdexMetricsDTO.milestone) && Intrinsics.areEqual(this.duration, apdexMetricsDTO.duration) && Intrinsics.areEqual((Object) this.magnitude, (Object) apdexMetricsDTO.magnitude) && Intrinsics.areEqual(this.failed, apdexMetricsDTO.failed) && Intrinsics.areEqual((Object) this.secondaryMeasurement, (Object) apdexMetricsDTO.secondaryMeasurement) && Intrinsics.areEqual((Object) this.score, (Object) apdexMetricsDTO.score) && Intrinsics.areEqual(this.os, apdexMetricsDTO.os) && Intrinsics.areEqual(this.appVersion, apdexMetricsDTO.appVersion) && Intrinsics.areEqual(this.osVersion, apdexMetricsDTO.osVersion) && Intrinsics.areEqual(this.userId, apdexMetricsDTO.userId) && Intrinsics.areEqual(this.enterpriseId, apdexMetricsDTO.enterpriseId);
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        String str = this.milestone;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.duration.hashCode()) * 31;
        Double d = this.magnitude;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Boolean bool = this.failed;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d2 = this.secondaryMeasurement;
        int iHashCode5 = (iHashCode4 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.score;
        return ((((((((((iHashCode5 + (d3 != null ? d3.hashCode() : 0)) * 31) + this.os.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.enterpriseId.hashCode();
    }

    public String toString() {
        return "ApdexMetricsDTO(eventType=" + this.eventType + ", milestone=" + this.milestone + ", duration=" + this.duration + ", magnitude=" + this.magnitude + ", failed=" + this.failed + ", secondaryMeasurement=" + this.secondaryMeasurement + ", score=" + this.score + ", os=" + this.os + ", appVersion=" + this.appVersion + ", osVersion=" + this.osVersion + ", userId=" + this.userId + ", enterpriseId=" + this.enterpriseId + ")";
    }

    public /* synthetic */ ApdexMetricsDTO(String str, String str2, String str3, Double d, Boolean bool, Double d2, Double d3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : d2, d3, str4, str5, str6, str7, str8);
    }

    @Override // com.box.android.data.api.models.observability.MetricsDTO
    public String getEventType() {
        return this.eventType;
    }

    public final String getMilestone() {
        return this.milestone;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final Double getMagnitude() {
        return this.magnitude;
    }

    public final Boolean getFailed() {
        return this.failed;
    }

    public final Double getSecondaryMeasurement() {
        return this.secondaryMeasurement;
    }

    public final Double getScore() {
        return this.score;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApdexMetricsDTO(@Json(name = "event_type") String eventType, @Json(name = "milestone") String str, @Json(name = "duration") String duration, @Json(name = "magnitude") Double d, @Json(name = TelemetryEventStrings.Value.FAILED) Boolean bool, @Json(name = "secondary_measurement") Double d2, @Json(name = FirebaseAnalytics.Param.SCORE) Double d3, @Json(name = "os") String os, @Json(name = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY) String appVersion, @Json(name = "os_version") String osVersion, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "enterprise_id") String enterpriseId) {
        super(MetricsCategory.APDEX, eventType);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        this.eventType = eventType;
        this.milestone = str;
        this.duration = duration;
        this.magnitude = d;
        this.failed = bool;
        this.secondaryMeasurement = d2;
        this.score = d3;
        this.os = os;
        this.appVersion = appVersion;
        this.osVersion = osVersion;
        this.userId = userId;
        this.enterpriseId = enterpriseId;
    }
}
