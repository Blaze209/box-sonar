package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/models/observability/DeviceMetric;", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "", RemoteConfigConstants.RequestFieldKey.APP_ID, "deviceModel", "osVersion", "platform", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getAppId", "getDeviceModel", "getOsVersion", "getPlatform", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeviceMetric {
    private final String appId;
    private final String appVersion;
    private final String deviceModel;
    private final String osVersion;
    private final String platform;

    public static /* synthetic */ DeviceMetric copy$default(DeviceMetric deviceMetric, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceMetric.appVersion;
        }
        if ((i & 2) != 0) {
            str2 = deviceMetric.appId;
        }
        if ((i & 4) != 0) {
            str3 = deviceMetric.deviceModel;
        }
        if ((i & 8) != 0) {
            str4 = deviceMetric.osVersion;
        }
        if ((i & 16) != 0) {
            str5 = deviceMetric.platform;
        }
        String str6 = str5;
        String str7 = str3;
        return deviceMetric.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    public final DeviceMetric copy(String appVersion, String appId, String deviceModel, String osVersion, String platform) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return new DeviceMetric(appVersion, appId, deviceModel, osVersion, platform);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceMetric)) {
            return false;
        }
        DeviceMetric deviceMetric = (DeviceMetric) other;
        return Intrinsics.areEqual(this.appVersion, deviceMetric.appVersion) && Intrinsics.areEqual(this.appId, deviceMetric.appId) && Intrinsics.areEqual(this.deviceModel, deviceMetric.deviceModel) && Intrinsics.areEqual(this.osVersion, deviceMetric.osVersion) && Intrinsics.areEqual(this.platform, deviceMetric.platform);
    }

    public int hashCode() {
        String str = this.appVersion;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.appId.hashCode()) * 31;
        String str2 = this.deviceModel;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.osVersion;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.platform.hashCode();
    }

    public String toString() {
        return "DeviceMetric(appVersion=" + this.appVersion + ", appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", osVersion=" + this.osVersion + ", platform=" + this.platform + ")";
    }

    public DeviceMetric(String str, String appId, String str2, String str3, String platform) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.appVersion = str;
        this.appId = appId;
        this.deviceModel = str2;
        this.osVersion = str3;
        this.platform = platform;
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
}
