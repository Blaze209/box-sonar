package com.box.android.data.api.models.pushnotifications;

import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegisterPushDeviceDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JT\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0007\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011¨\u0006 "}, d2 = {"Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;", "", "deviceToken", "", "platform", "language", "notificationVersion", "isNotificationEnabled", "", "isRegistered", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDeviceToken", "()Ljava/lang/String;", "getPlatform", "getLanguage", "getNotificationVersion", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RegisterPushDeviceDTO {
    private final String deviceToken;
    private final Boolean isNotificationEnabled;
    private final Boolean isRegistered;
    private final String language;
    private final String notificationVersion;
    private final String platform;

    public static /* synthetic */ RegisterPushDeviceDTO copy$default(RegisterPushDeviceDTO registerPushDeviceDTO, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerPushDeviceDTO.deviceToken;
        }
        if ((i & 2) != 0) {
            str2 = registerPushDeviceDTO.platform;
        }
        if ((i & 4) != 0) {
            str3 = registerPushDeviceDTO.language;
        }
        if ((i & 8) != 0) {
            str4 = registerPushDeviceDTO.notificationVersion;
        }
        if ((i & 16) != 0) {
            bool = registerPushDeviceDTO.isNotificationEnabled;
        }
        if ((i & 32) != 0) {
            bool2 = registerPushDeviceDTO.isRegistered;
        }
        Boolean bool3 = bool;
        Boolean bool4 = bool2;
        return registerPushDeviceDTO.copy(str, str2, str3, str4, bool3, bool4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceToken() {
        return this.deviceToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNotificationVersion() {
        return this.notificationVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIsNotificationEnabled() {
        return this.isNotificationEnabled;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsRegistered() {
        return this.isRegistered;
    }

    public final RegisterPushDeviceDTO copy(@Json(name = BoxConvertedPushNotificationDevice.DEVICE_TOKEN) String deviceToken, @Json(name = "platform") String platform, @Json(name = "language") String language, @Json(name = BoxPushNotificationV1.FIELD_NOTIFICATION_VERSION) String notificationVersion, @Json(name = "is_notification_enabled") Boolean isNotificationEnabled, @Json(name = "is_registered") Boolean isRegistered) {
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        return new RegisterPushDeviceDTO(deviceToken, platform, language, notificationVersion, isNotificationEnabled, isRegistered);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterPushDeviceDTO)) {
            return false;
        }
        RegisterPushDeviceDTO registerPushDeviceDTO = (RegisterPushDeviceDTO) other;
        return Intrinsics.areEqual(this.deviceToken, registerPushDeviceDTO.deviceToken) && Intrinsics.areEqual(this.platform, registerPushDeviceDTO.platform) && Intrinsics.areEqual(this.language, registerPushDeviceDTO.language) && Intrinsics.areEqual(this.notificationVersion, registerPushDeviceDTO.notificationVersion) && Intrinsics.areEqual(this.isNotificationEnabled, registerPushDeviceDTO.isNotificationEnabled) && Intrinsics.areEqual(this.isRegistered, registerPushDeviceDTO.isRegistered);
    }

    public int hashCode() {
        int iHashCode = this.deviceToken.hashCode() * 31;
        String str = this.platform;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.language;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.notificationVersion;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isNotificationEnabled;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isRegistered;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "RegisterPushDeviceDTO(deviceToken=" + this.deviceToken + ", platform=" + this.platform + ", language=" + this.language + ", notificationVersion=" + this.notificationVersion + ", isNotificationEnabled=" + this.isNotificationEnabled + ", isRegistered=" + this.isRegistered + ")";
    }

    public RegisterPushDeviceDTO(@Json(name = BoxConvertedPushNotificationDevice.DEVICE_TOKEN) String deviceToken, @Json(name = "platform") String str, @Json(name = "language") String str2, @Json(name = BoxPushNotificationV1.FIELD_NOTIFICATION_VERSION) String str3, @Json(name = "is_notification_enabled") Boolean bool, @Json(name = "is_registered") Boolean bool2) {
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        this.deviceToken = deviceToken;
        this.platform = str;
        this.language = str2;
        this.notificationVersion = str3;
        this.isNotificationEnabled = bool;
        this.isRegistered = bool2;
    }

    public final String getDeviceToken() {
        return this.deviceToken;
    }

    public /* synthetic */ RegisterPushDeviceDTO(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "ANDROID" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "1" : str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2);
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

    public final Boolean isNotificationEnabled() {
        return this.isNotificationEnabled;
    }

    public final Boolean isRegistered() {
        return this.isRegistered;
    }
}
