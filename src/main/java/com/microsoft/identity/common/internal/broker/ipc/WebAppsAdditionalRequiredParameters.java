package com.microsoft.identity.common.internal.broker.ipc;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.request.SdkType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebAppsAdditionalRequiredParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/WebAppsAdditionalRequiredParameters;", "", WebAppsAdditionalRequiredParameters.FIELD_CAN_SHOW_UI, "", WebAppsAdditionalRequiredParameters.FIELD_CALLING_PACKAGE_NAME, "", WebAppsAdditionalRequiredParameters.FIELD_CALLING_APPLICATION_NAME, WebAppsAdditionalRequiredParameters.FIELD_CALLING_APPLICATION_VERSION, WebAppsAdditionalRequiredParameters.FIELD_SDK_TYPE, "Lcom/microsoft/identity/common/java/request/SdkType;", "sdkVersion", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/common/java/request/SdkType;Ljava/lang/String;)V", "getCallingApplicationName", "()Ljava/lang/String;", "getCallingApplicationVersion", "getCallingPackageName", "getCanShowUi", "()Z", "getSdkType", "()Lcom/microsoft/identity/common/java/request/SdkType;", "getSdkVersion", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebAppsAdditionalRequiredParameters {
    public static final String FIELD_CALLING_APPLICATION_NAME = "callingApplicationName";
    public static final String FIELD_CALLING_APPLICATION_VERSION = "callingApplicationVersion";
    public static final String FIELD_CALLING_PACKAGE_NAME = "callingPackageName";
    public static final String FIELD_CAN_SHOW_UI = "canShowUi";
    public static final String FIELD_SDK_TYPE = "sdkType";
    public static final String FIELD_SDK_VERSION = "sdkVersion";

    @SerializedName(FIELD_CALLING_APPLICATION_NAME)
    private final String callingApplicationName;

    @SerializedName(FIELD_CALLING_APPLICATION_VERSION)
    private final String callingApplicationVersion;

    @SerializedName(FIELD_CALLING_PACKAGE_NAME)
    private final String callingPackageName;

    @SerializedName(FIELD_CAN_SHOW_UI)
    private final boolean canShowUi;

    @SerializedName(FIELD_SDK_TYPE)
    private final SdkType sdkType;

    @SerializedName("sdkVersion")
    private final String sdkVersion;

    public static /* synthetic */ WebAppsAdditionalRequiredParameters copy$default(WebAppsAdditionalRequiredParameters webAppsAdditionalRequiredParameters, boolean z, String str, String str2, String str3, SdkType sdkType, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webAppsAdditionalRequiredParameters.canShowUi;
        }
        if ((i & 2) != 0) {
            str = webAppsAdditionalRequiredParameters.callingPackageName;
        }
        if ((i & 4) != 0) {
            str2 = webAppsAdditionalRequiredParameters.callingApplicationName;
        }
        if ((i & 8) != 0) {
            str3 = webAppsAdditionalRequiredParameters.callingApplicationVersion;
        }
        if ((i & 16) != 0) {
            sdkType = webAppsAdditionalRequiredParameters.sdkType;
        }
        if ((i & 32) != 0) {
            str4 = webAppsAdditionalRequiredParameters.sdkVersion;
        }
        SdkType sdkType2 = sdkType;
        String str5 = str4;
        return webAppsAdditionalRequiredParameters.copy(z, str, str2, str3, sdkType2, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanShowUi() {
        return this.canShowUi;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCallingPackageName() {
        return this.callingPackageName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCallingApplicationName() {
        return this.callingApplicationName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCallingApplicationVersion() {
        return this.callingApplicationVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SdkType getSdkType() {
        return this.sdkType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final WebAppsAdditionalRequiredParameters copy(boolean canShowUi, String callingPackageName, String callingApplicationName, String callingApplicationVersion, SdkType sdkType, String sdkVersion) {
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        Intrinsics.checkNotNullParameter(callingApplicationName, "callingApplicationName");
        Intrinsics.checkNotNullParameter(callingApplicationVersion, "callingApplicationVersion");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        return new WebAppsAdditionalRequiredParameters(canShowUi, callingPackageName, callingApplicationName, callingApplicationVersion, sdkType, sdkVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebAppsAdditionalRequiredParameters)) {
            return false;
        }
        WebAppsAdditionalRequiredParameters webAppsAdditionalRequiredParameters = (WebAppsAdditionalRequiredParameters) other;
        return this.canShowUi == webAppsAdditionalRequiredParameters.canShowUi && Intrinsics.areEqual(this.callingPackageName, webAppsAdditionalRequiredParameters.callingPackageName) && Intrinsics.areEqual(this.callingApplicationName, webAppsAdditionalRequiredParameters.callingApplicationName) && Intrinsics.areEqual(this.callingApplicationVersion, webAppsAdditionalRequiredParameters.callingApplicationVersion) && this.sdkType == webAppsAdditionalRequiredParameters.sdkType && Intrinsics.areEqual(this.sdkVersion, webAppsAdditionalRequiredParameters.sdkVersion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.canShowUi;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.callingPackageName.hashCode()) * 31) + this.callingApplicationName.hashCode()) * 31) + this.callingApplicationVersion.hashCode()) * 31) + this.sdkType.hashCode()) * 31) + this.sdkVersion.hashCode();
    }

    public String toString() {
        return "WebAppsAdditionalRequiredParameters(canShowUi=" + this.canShowUi + ", callingPackageName=" + this.callingPackageName + ", callingApplicationName=" + this.callingApplicationName + ", callingApplicationVersion=" + this.callingApplicationVersion + ", sdkType=" + this.sdkType + ", sdkVersion=" + this.sdkVersion + ')';
    }

    public WebAppsAdditionalRequiredParameters(boolean z, String callingPackageName, String callingApplicationName, String callingApplicationVersion, SdkType sdkType, String sdkVersion) {
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        Intrinsics.checkNotNullParameter(callingApplicationName, "callingApplicationName");
        Intrinsics.checkNotNullParameter(callingApplicationVersion, "callingApplicationVersion");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.canShowUi = z;
        this.callingPackageName = callingPackageName;
        this.callingApplicationName = callingApplicationName;
        this.callingApplicationVersion = callingApplicationVersion;
        this.sdkType = sdkType;
        this.sdkVersion = sdkVersion;
    }

    public /* synthetic */ WebAppsAdditionalRequiredParameters(boolean z, String str, String str2, String str3, SdkType sdkType, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, str, str2, str3, sdkType, str4);
    }

    public final boolean getCanShowUi() {
        return this.canShowUi;
    }

    public final String getCallingPackageName() {
        return this.callingPackageName;
    }

    public final String getCallingApplicationName() {
        return this.callingApplicationName;
    }

    public final String getCallingApplicationVersion() {
        return this.callingApplicationVersion;
    }

    public final SdkType getSdkType() {
        return this.sdkType;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }
}
