package com.box.android.preview.wopi;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WopiConfiguration.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/box/android/preview/wopi/WopiConfiguration;", "", "appType", "Lcom/box/android/preview/wopi/OfficeAppType;", "targetUrl", "", "isEditable", "", "fileExtension", "serviceId", "<init>", "(Lcom/box/android/preview/wopi/OfficeAppType;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAppType", "()Lcom/box/android/preview/wopi/OfficeAppType;", "getTargetUrl", "()Ljava/lang/String;", "()Z", "getFileExtension", "getServiceId", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WopiConfiguration {
    public static final int $stable = 0;
    private final OfficeAppType appType;
    private final String fileExtension;
    private final boolean isEditable;
    private final String serviceId;
    private final String targetUrl;

    public static /* synthetic */ WopiConfiguration copy$default(WopiConfiguration wopiConfiguration, OfficeAppType officeAppType, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            officeAppType = wopiConfiguration.appType;
        }
        if ((i & 2) != 0) {
            str = wopiConfiguration.targetUrl;
        }
        if ((i & 4) != 0) {
            z = wopiConfiguration.isEditable;
        }
        if ((i & 8) != 0) {
            str2 = wopiConfiguration.fileExtension;
        }
        if ((i & 16) != 0) {
            str3 = wopiConfiguration.serviceId;
        }
        String str4 = str3;
        boolean z2 = z;
        return wopiConfiguration.copy(officeAppType, str, z2, str2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OfficeAppType getAppType() {
        return this.appType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTargetUrl() {
        return this.targetUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsEditable() {
        return this.isEditable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFileExtension() {
        return this.fileExtension;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    public final WopiConfiguration copy(OfficeAppType appType, String targetUrl, boolean isEditable, String fileExtension, String serviceId) {
        Intrinsics.checkNotNullParameter(appType, "appType");
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        return new WopiConfiguration(appType, targetUrl, isEditable, fileExtension, serviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WopiConfiguration)) {
            return false;
        }
        WopiConfiguration wopiConfiguration = (WopiConfiguration) other;
        return this.appType == wopiConfiguration.appType && Intrinsics.areEqual(this.targetUrl, wopiConfiguration.targetUrl) && this.isEditable == wopiConfiguration.isEditable && Intrinsics.areEqual(this.fileExtension, wopiConfiguration.fileExtension) && Intrinsics.areEqual(this.serviceId, wopiConfiguration.serviceId);
    }

    public int hashCode() {
        return (((((((this.appType.hashCode() * 31) + this.targetUrl.hashCode()) * 31) + Boolean.hashCode(this.isEditable)) * 31) + this.fileExtension.hashCode()) * 31) + this.serviceId.hashCode();
    }

    public String toString() {
        return "WopiConfiguration(appType=" + this.appType + ", targetUrl=" + this.targetUrl + ", isEditable=" + this.isEditable + ", fileExtension=" + this.fileExtension + ", serviceId=" + this.serviceId + ")";
    }

    public WopiConfiguration(OfficeAppType appType, String targetUrl, boolean z, String fileExtension, String serviceId) {
        Intrinsics.checkNotNullParameter(appType, "appType");
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        this.appType = appType;
        this.targetUrl = targetUrl;
        this.isEditable = z;
        this.fileExtension = fileExtension;
        this.serviceId = serviceId;
    }

    public final OfficeAppType getAppType() {
        return this.appType;
    }

    public final String getTargetUrl() {
        return this.targetUrl;
    }

    public final boolean isEditable() {
        return this.isEditable;
    }

    public final String getFileExtension() {
        return this.fileExtension;
    }

    public final String getServiceId() {
        return this.serviceId;
    }
}
