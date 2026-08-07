package com.box.android.data.api.models.pushnotifications;

import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushDeviceDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015¨\u0006$"}, d2 = {"Lcom/box/android/data/api/models/pushnotifications/PushDeviceDTO;", "", "id", "", "type", "deviceToken", "platform", "language", "notificationVersion", "isRegistered", "", "isNotificationEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getType", "getDeviceToken", "getPlatform", "getLanguage", "getNotificationVersion", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PushDeviceDTO {
    private final String deviceToken;
    private final String id;
    private final boolean isNotificationEnabled;
    private final boolean isRegistered;
    private final String language;
    private final String notificationVersion;
    private final String platform;
    private final String type;

    public static /* synthetic */ PushDeviceDTO copy$default(PushDeviceDTO pushDeviceDTO, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushDeviceDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = pushDeviceDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = pushDeviceDTO.deviceToken;
        }
        if ((i & 8) != 0) {
            str4 = pushDeviceDTO.platform;
        }
        if ((i & 16) != 0) {
            str5 = pushDeviceDTO.language;
        }
        if ((i & 32) != 0) {
            str6 = pushDeviceDTO.notificationVersion;
        }
        if ((i & 64) != 0) {
            z = pushDeviceDTO.isRegistered;
        }
        if ((i & 128) != 0) {
            z2 = pushDeviceDTO.isNotificationEnabled;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str7 = str5;
        String str8 = str6;
        return pushDeviceDTO.copy(str, str2, str3, str4, str7, str8, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceToken() {
        return this.deviceToken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNotificationVersion() {
        return this.notificationVersion;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsRegistered() {
        return this.isRegistered;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsNotificationEnabled() {
        return this.isNotificationEnabled;
    }

    public final PushDeviceDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxConvertedPushNotificationDevice.DEVICE_TOKEN) String deviceToken, @Json(name = "platform") String platform, @Json(name = "language") String language, @Json(name = BoxPushNotificationV1.FIELD_NOTIFICATION_VERSION) String notificationVersion, @Json(name = "is_registered") boolean isRegistered, @Json(name = "is_notification_enabled") boolean isNotificationEnabled) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(notificationVersion, "notificationVersion");
        return new PushDeviceDTO(id, type, deviceToken, platform, language, notificationVersion, isRegistered, isNotificationEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushDeviceDTO)) {
            return false;
        }
        PushDeviceDTO pushDeviceDTO = (PushDeviceDTO) other;
        return Intrinsics.areEqual(this.id, pushDeviceDTO.id) && Intrinsics.areEqual(this.type, pushDeviceDTO.type) && Intrinsics.areEqual(this.deviceToken, pushDeviceDTO.deviceToken) && Intrinsics.areEqual(this.platform, pushDeviceDTO.platform) && Intrinsics.areEqual(this.language, pushDeviceDTO.language) && Intrinsics.areEqual(this.notificationVersion, pushDeviceDTO.notificationVersion) && this.isRegistered == pushDeviceDTO.isRegistered && this.isNotificationEnabled == pushDeviceDTO.isNotificationEnabled;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.deviceToken.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.language.hashCode()) * 31) + this.notificationVersion.hashCode()) * 31) + Boolean.hashCode(this.isRegistered)) * 31) + Boolean.hashCode(this.isNotificationEnabled);
    }

    public String toString() {
        return "PushDeviceDTO(id=" + this.id + ", type=" + this.type + ", deviceToken=" + this.deviceToken + ", platform=" + this.platform + ", language=" + this.language + ", notificationVersion=" + this.notificationVersion + ", isRegistered=" + this.isRegistered + ", isNotificationEnabled=" + this.isNotificationEnabled + ")";
    }

    public PushDeviceDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxConvertedPushNotificationDevice.DEVICE_TOKEN) String deviceToken, @Json(name = "platform") String platform, @Json(name = "language") String language, @Json(name = BoxPushNotificationV1.FIELD_NOTIFICATION_VERSION) String notificationVersion, @Json(name = "is_registered") boolean z, @Json(name = "is_notification_enabled") boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(notificationVersion, "notificationVersion");
        this.id = id;
        this.type = type;
        this.deviceToken = deviceToken;
        this.platform = platform;
        this.language = language;
        this.notificationVersion = notificationVersion;
        this.isRegistered = z;
        this.isNotificationEnabled = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDeviceToken() {
        return this.deviceToken;
    }

    public /* synthetic */ PushDeviceDTO(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "android" : str4, str5, str6, z, z2);
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getNotificationVersion() {
        return this.notificationVersion;
    }

    public final boolean isRegistered() {
        return this.isRegistered;
    }

    public final boolean isNotificationEnabled() {
        return this.isNotificationEnabled;
    }
}
