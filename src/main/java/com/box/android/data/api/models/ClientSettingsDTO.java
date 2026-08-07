package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.dao.IBoxAdminSettings;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bR\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003JÁ\u0002\u0010Z\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020_HÖ\u0001J\t\u0010`\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010)¨\u0006a"}, d2 = {"Lcom/box/android/data/api/models/ClientSettingsDTO;", "", "jwtAppSettings", "Lcom/box/android/data/api/models/JWTAppSettings;", "licenseKeys", "Lcom/box/android/data/api/models/LicenseKeys;", "observability", "Lcom/box/android/data/api/models/ObservabilityDTO;", "minimumVersion", "", "minimumVersionFailureMessage", "minimumVersionFailureAction", "restrictToEncryptedClientOnly", "mobilePasscodeLockInterval", "requireMobilePasscodeLock", "enableMobileSaveOnDevice", "enableMobilePrint", "enableMobileOpenIn", "enableMobileAutoPhotoUpload", "enableMobileCopyPaste", "enableMobilePreviewOnlyOfflining", "wopiServiceId", "enableViewingAnnotations", "enableCreatingAnnotations", "intuneMAMEnabled", "enableBoxAiPreview", "enableBoxAiStudio", "enableBoxAiNotes", "enableBoxAiMultidoc", "enableHubsGallery", "enableHubsAi", "axCenterInWeb", "<init>", "(Lcom/box/android/data/api/models/JWTAppSettings;Lcom/box/android/data/api/models/LicenseKeys;Lcom/box/android/data/api/models/ObservabilityDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJwtAppSettings", "()Lcom/box/android/data/api/models/JWTAppSettings;", "getLicenseKeys", "()Lcom/box/android/data/api/models/LicenseKeys;", "getObservability", "()Lcom/box/android/data/api/models/ObservabilityDTO;", "getMinimumVersion", "()Ljava/lang/String;", "getMinimumVersionFailureMessage", "getMinimumVersionFailureAction", "getRestrictToEncryptedClientOnly", "getMobilePasscodeLockInterval", "getRequireMobilePasscodeLock", "getEnableMobileSaveOnDevice", "getEnableMobilePrint", "getEnableMobileOpenIn", "getEnableMobileAutoPhotoUpload", "getEnableMobileCopyPaste", "getEnableMobilePreviewOnlyOfflining", "getWopiServiceId", "getEnableViewingAnnotations", "getEnableCreatingAnnotations", "getIntuneMAMEnabled", "getEnableBoxAiPreview", "getEnableBoxAiStudio", "getEnableBoxAiNotes", "getEnableBoxAiMultidoc", "getEnableHubsGallery", "getEnableHubsAi", "getAxCenterInWeb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ClientSettingsDTO {
    private final String axCenterInWeb;
    private final String enableBoxAiMultidoc;
    private final String enableBoxAiNotes;
    private final String enableBoxAiPreview;
    private final String enableBoxAiStudio;
    private final String enableCreatingAnnotations;
    private final String enableHubsAi;
    private final String enableHubsGallery;
    private final String enableMobileAutoPhotoUpload;
    private final String enableMobileCopyPaste;
    private final String enableMobileOpenIn;
    private final String enableMobilePreviewOnlyOfflining;
    private final String enableMobilePrint;
    private final String enableMobileSaveOnDevice;
    private final String enableViewingAnnotations;
    private final String intuneMAMEnabled;
    private final JWTAppSettings jwtAppSettings;
    private final LicenseKeys licenseKeys;
    private final String minimumVersion;
    private final String minimumVersionFailureAction;
    private final String minimumVersionFailureMessage;
    private final String mobilePasscodeLockInterval;
    private final ObservabilityDTO observability;
    private final String requireMobilePasscodeLock;
    private final String restrictToEncryptedClientOnly;
    private final String wopiServiceId;

    public static /* synthetic */ ClientSettingsDTO copy$default(ClientSettingsDTO clientSettingsDTO, JWTAppSettings jWTAppSettings, LicenseKeys licenseKeys, ObservabilityDTO observabilityDTO, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, Object obj) {
        String str24;
        String str25;
        JWTAppSettings jWTAppSettings2 = (i & 1) != 0 ? clientSettingsDTO.jwtAppSettings : jWTAppSettings;
        LicenseKeys licenseKeys2 = (i & 2) != 0 ? clientSettingsDTO.licenseKeys : licenseKeys;
        ObservabilityDTO observabilityDTO2 = (i & 4) != 0 ? clientSettingsDTO.observability : observabilityDTO;
        String str26 = (i & 8) != 0 ? clientSettingsDTO.minimumVersion : str;
        String str27 = (i & 16) != 0 ? clientSettingsDTO.minimumVersionFailureMessage : str2;
        String str28 = (i & 32) != 0 ? clientSettingsDTO.minimumVersionFailureAction : str3;
        String str29 = (i & 64) != 0 ? clientSettingsDTO.restrictToEncryptedClientOnly : str4;
        String str30 = (i & 128) != 0 ? clientSettingsDTO.mobilePasscodeLockInterval : str5;
        String str31 = (i & 256) != 0 ? clientSettingsDTO.requireMobilePasscodeLock : str6;
        String str32 = (i & 512) != 0 ? clientSettingsDTO.enableMobileSaveOnDevice : str7;
        String str33 = (i & 1024) != 0 ? clientSettingsDTO.enableMobilePrint : str8;
        String str34 = (i & 2048) != 0 ? clientSettingsDTO.enableMobileOpenIn : str9;
        String str35 = (i & 4096) != 0 ? clientSettingsDTO.enableMobileAutoPhotoUpload : str10;
        String str36 = (i & 8192) != 0 ? clientSettingsDTO.enableMobileCopyPaste : str11;
        JWTAppSettings jWTAppSettings3 = jWTAppSettings2;
        String str37 = (i & 16384) != 0 ? clientSettingsDTO.enableMobilePreviewOnlyOfflining : str12;
        String str38 = (i & 32768) != 0 ? clientSettingsDTO.wopiServiceId : str13;
        String str39 = (i & 65536) != 0 ? clientSettingsDTO.enableViewingAnnotations : str14;
        String str40 = (i & 131072) != 0 ? clientSettingsDTO.enableCreatingAnnotations : str15;
        String str41 = (i & 262144) != 0 ? clientSettingsDTO.intuneMAMEnabled : str16;
        String str42 = (i & 524288) != 0 ? clientSettingsDTO.enableBoxAiPreview : str17;
        String str43 = (i & 1048576) != 0 ? clientSettingsDTO.enableBoxAiStudio : str18;
        String str44 = (i & 2097152) != 0 ? clientSettingsDTO.enableBoxAiNotes : str19;
        String str45 = (i & 4194304) != 0 ? clientSettingsDTO.enableBoxAiMultidoc : str20;
        String str46 = (i & 8388608) != 0 ? clientSettingsDTO.enableHubsGallery : str21;
        String str47 = (i & 16777216) != 0 ? clientSettingsDTO.enableHubsAi : str22;
        if ((i & 33554432) != 0) {
            str25 = str47;
            str24 = clientSettingsDTO.axCenterInWeb;
        } else {
            str24 = str23;
            str25 = str47;
        }
        return clientSettingsDTO.copy(jWTAppSettings3, licenseKeys2, observabilityDTO2, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str25, str24);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JWTAppSettings getJwtAppSettings() {
        return this.jwtAppSettings;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getEnableMobileSaveOnDevice() {
        return this.enableMobileSaveOnDevice;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEnableMobilePrint() {
        return this.enableMobilePrint;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getEnableMobileOpenIn() {
        return this.enableMobileOpenIn;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getEnableMobileAutoPhotoUpload() {
        return this.enableMobileAutoPhotoUpload;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getEnableMobileCopyPaste() {
        return this.enableMobileCopyPaste;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getEnableMobilePreviewOnlyOfflining() {
        return this.enableMobilePreviewOnlyOfflining;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getWopiServiceId() {
        return this.wopiServiceId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getEnableViewingAnnotations() {
        return this.enableViewingAnnotations;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getEnableCreatingAnnotations() {
        return this.enableCreatingAnnotations;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getIntuneMAMEnabled() {
        return this.intuneMAMEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LicenseKeys getLicenseKeys() {
        return this.licenseKeys;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getEnableBoxAiPreview() {
        return this.enableBoxAiPreview;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getEnableBoxAiStudio() {
        return this.enableBoxAiStudio;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getEnableBoxAiNotes() {
        return this.enableBoxAiNotes;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getEnableBoxAiMultidoc() {
        return this.enableBoxAiMultidoc;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getEnableHubsGallery() {
        return this.enableHubsGallery;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getEnableHubsAi() {
        return this.enableHubsAi;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getAxCenterInWeb() {
        return this.axCenterInWeb;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ObservabilityDTO getObservability() {
        return this.observability;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMinimumVersion() {
        return this.minimumVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMinimumVersionFailureMessage() {
        return this.minimumVersionFailureMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMinimumVersionFailureAction() {
        return this.minimumVersionFailureAction;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRestrictToEncryptedClientOnly() {
        return this.restrictToEncryptedClientOnly;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMobilePasscodeLockInterval() {
        return this.mobilePasscodeLockInterval;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getRequireMobilePasscodeLock() {
        return this.requireMobilePasscodeLock;
    }

    public final ClientSettingsDTO copy(@Json(name = "jwt_app_settings") JWTAppSettings jwtAppSettings, @Json(name = "license-keys") LicenseKeys licenseKeys, ObservabilityDTO observability, @Json(name = IBoxAdminSettings.SETTING_MINIMUM_VERSION) String minimumVersion, @Json(name = IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_MESSAGE) String minimumVersionFailureMessage, @Json(name = IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_ACTION) String minimumVersionFailureAction, @Json(name = IBoxAdminSettings.SETTING_RESTRICT_TO_ENCRYPTED_CLIENT) String restrictToEncryptedClientOnly, @Json(name = IBoxAdminSettings.SETTING_MOBILE_PASSCODE_LOCK_INTERVAL) String mobilePasscodeLockInterval, @Json(name = IBoxAdminSettings.SETTING_REQUIRE_MOBILE_PASSCODE_LOCK) String requireMobilePasscodeLock, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE) String enableMobileSaveOnDevice, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_PRINT) String enableMobilePrint, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_OPEN_IN) String enableMobileOpenIn, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD) String enableMobileAutoPhotoUpload, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_COPY_PASTE) String enableMobileCopyPaste, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING) String enableMobilePreviewOnlyOfflining, @Json(name = IBoxAdminSettings.SETTING_WOPI_SERVICE_ID) String wopiServiceId, @Json(name = IBoxAdminSettings.SETTING_ENABLE_VIEWING_ANNOTATIONS) String enableViewingAnnotations, @Json(name = IBoxAdminSettings.SETTING_ENABLE_CREATING_ANNOTATIONS) String enableCreatingAnnotations, @Json(name = IBoxAdminSettings.SETTING_ENABLE_INTUNE_MAM) String intuneMAMEnabled, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_PREVIEW) String enableBoxAiPreview, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_STUDIO) String enableBoxAiStudio, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_NOTES) String enableBoxAiNotes, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_MULTIDOC) String enableBoxAiMultidoc, @Json(name = IBoxAdminSettings.SETTING_ENABLE_HUBS_GALLERY) String enableHubsGallery, @Json(name = IBoxAdminSettings.SETTING_ENABLE_HUBS_AI) String enableHubsAi, @Json(name = IBoxAdminSettings.SETTING_AX_CENTER_IN_WEB) String axCenterInWeb) {
        return new ClientSettingsDTO(jwtAppSettings, licenseKeys, observability, minimumVersion, minimumVersionFailureMessage, minimumVersionFailureAction, restrictToEncryptedClientOnly, mobilePasscodeLockInterval, requireMobilePasscodeLock, enableMobileSaveOnDevice, enableMobilePrint, enableMobileOpenIn, enableMobileAutoPhotoUpload, enableMobileCopyPaste, enableMobilePreviewOnlyOfflining, wopiServiceId, enableViewingAnnotations, enableCreatingAnnotations, intuneMAMEnabled, enableBoxAiPreview, enableBoxAiStudio, enableBoxAiNotes, enableBoxAiMultidoc, enableHubsGallery, enableHubsAi, axCenterInWeb);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientSettingsDTO)) {
            return false;
        }
        ClientSettingsDTO clientSettingsDTO = (ClientSettingsDTO) other;
        return Intrinsics.areEqual(this.jwtAppSettings, clientSettingsDTO.jwtAppSettings) && Intrinsics.areEqual(this.licenseKeys, clientSettingsDTO.licenseKeys) && Intrinsics.areEqual(this.observability, clientSettingsDTO.observability) && Intrinsics.areEqual(this.minimumVersion, clientSettingsDTO.minimumVersion) && Intrinsics.areEqual(this.minimumVersionFailureMessage, clientSettingsDTO.minimumVersionFailureMessage) && Intrinsics.areEqual(this.minimumVersionFailureAction, clientSettingsDTO.minimumVersionFailureAction) && Intrinsics.areEqual(this.restrictToEncryptedClientOnly, clientSettingsDTO.restrictToEncryptedClientOnly) && Intrinsics.areEqual(this.mobilePasscodeLockInterval, clientSettingsDTO.mobilePasscodeLockInterval) && Intrinsics.areEqual(this.requireMobilePasscodeLock, clientSettingsDTO.requireMobilePasscodeLock) && Intrinsics.areEqual(this.enableMobileSaveOnDevice, clientSettingsDTO.enableMobileSaveOnDevice) && Intrinsics.areEqual(this.enableMobilePrint, clientSettingsDTO.enableMobilePrint) && Intrinsics.areEqual(this.enableMobileOpenIn, clientSettingsDTO.enableMobileOpenIn) && Intrinsics.areEqual(this.enableMobileAutoPhotoUpload, clientSettingsDTO.enableMobileAutoPhotoUpload) && Intrinsics.areEqual(this.enableMobileCopyPaste, clientSettingsDTO.enableMobileCopyPaste) && Intrinsics.areEqual(this.enableMobilePreviewOnlyOfflining, clientSettingsDTO.enableMobilePreviewOnlyOfflining) && Intrinsics.areEqual(this.wopiServiceId, clientSettingsDTO.wopiServiceId) && Intrinsics.areEqual(this.enableViewingAnnotations, clientSettingsDTO.enableViewingAnnotations) && Intrinsics.areEqual(this.enableCreatingAnnotations, clientSettingsDTO.enableCreatingAnnotations) && Intrinsics.areEqual(this.intuneMAMEnabled, clientSettingsDTO.intuneMAMEnabled) && Intrinsics.areEqual(this.enableBoxAiPreview, clientSettingsDTO.enableBoxAiPreview) && Intrinsics.areEqual(this.enableBoxAiStudio, clientSettingsDTO.enableBoxAiStudio) && Intrinsics.areEqual(this.enableBoxAiNotes, clientSettingsDTO.enableBoxAiNotes) && Intrinsics.areEqual(this.enableBoxAiMultidoc, clientSettingsDTO.enableBoxAiMultidoc) && Intrinsics.areEqual(this.enableHubsGallery, clientSettingsDTO.enableHubsGallery) && Intrinsics.areEqual(this.enableHubsAi, clientSettingsDTO.enableHubsAi) && Intrinsics.areEqual(this.axCenterInWeb, clientSettingsDTO.axCenterInWeb);
    }

    public int hashCode() {
        JWTAppSettings jWTAppSettings = this.jwtAppSettings;
        int iHashCode = (jWTAppSettings == null ? 0 : jWTAppSettings.hashCode()) * 31;
        LicenseKeys licenseKeys = this.licenseKeys;
        int iHashCode2 = (iHashCode + (licenseKeys == null ? 0 : licenseKeys.hashCode())) * 31;
        ObservabilityDTO observabilityDTO = this.observability;
        int iHashCode3 = (iHashCode2 + (observabilityDTO == null ? 0 : observabilityDTO.hashCode())) * 31;
        String str = this.minimumVersion;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.minimumVersionFailureMessage;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.minimumVersionFailureAction;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.restrictToEncryptedClientOnly;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mobilePasscodeLockInterval;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.requireMobilePasscodeLock;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.enableMobileSaveOnDevice;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.enableMobilePrint;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.enableMobileOpenIn;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.enableMobileAutoPhotoUpload;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.enableMobileCopyPaste;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.enableMobilePreviewOnlyOfflining;
        int iHashCode15 = (iHashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.wopiServiceId;
        int iHashCode16 = (iHashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.enableViewingAnnotations;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.enableCreatingAnnotations;
        int iHashCode18 = (iHashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.intuneMAMEnabled;
        int iHashCode19 = (iHashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.enableBoxAiPreview;
        int iHashCode20 = (iHashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.enableBoxAiStudio;
        int iHashCode21 = (iHashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.enableBoxAiNotes;
        int iHashCode22 = (iHashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.enableBoxAiMultidoc;
        int iHashCode23 = (iHashCode22 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.enableHubsGallery;
        int iHashCode24 = (iHashCode23 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.enableHubsAi;
        int iHashCode25 = (iHashCode24 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.axCenterInWeb;
        return iHashCode25 + (str23 != null ? str23.hashCode() : 0);
    }

    public String toString() {
        return "ClientSettingsDTO(jwtAppSettings=" + this.jwtAppSettings + ", licenseKeys=" + this.licenseKeys + ", observability=" + this.observability + ", minimumVersion=" + this.minimumVersion + ", minimumVersionFailureMessage=" + this.minimumVersionFailureMessage + ", minimumVersionFailureAction=" + this.minimumVersionFailureAction + ", restrictToEncryptedClientOnly=" + this.restrictToEncryptedClientOnly + ", mobilePasscodeLockInterval=" + this.mobilePasscodeLockInterval + ", requireMobilePasscodeLock=" + this.requireMobilePasscodeLock + ", enableMobileSaveOnDevice=" + this.enableMobileSaveOnDevice + ", enableMobilePrint=" + this.enableMobilePrint + ", enableMobileOpenIn=" + this.enableMobileOpenIn + ", enableMobileAutoPhotoUpload=" + this.enableMobileAutoPhotoUpload + ", enableMobileCopyPaste=" + this.enableMobileCopyPaste + ", enableMobilePreviewOnlyOfflining=" + this.enableMobilePreviewOnlyOfflining + ", wopiServiceId=" + this.wopiServiceId + ", enableViewingAnnotations=" + this.enableViewingAnnotations + ", enableCreatingAnnotations=" + this.enableCreatingAnnotations + ", intuneMAMEnabled=" + this.intuneMAMEnabled + ", enableBoxAiPreview=" + this.enableBoxAiPreview + ", enableBoxAiStudio=" + this.enableBoxAiStudio + ", enableBoxAiNotes=" + this.enableBoxAiNotes + ", enableBoxAiMultidoc=" + this.enableBoxAiMultidoc + ", enableHubsGallery=" + this.enableHubsGallery + ", enableHubsAi=" + this.enableHubsAi + ", axCenterInWeb=" + this.axCenterInWeb + ")";
    }

    public ClientSettingsDTO(@Json(name = "jwt_app_settings") JWTAppSettings jWTAppSettings, @Json(name = "license-keys") LicenseKeys licenseKeys, ObservabilityDTO observabilityDTO, @Json(name = IBoxAdminSettings.SETTING_MINIMUM_VERSION) String str, @Json(name = IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_MESSAGE) String str2, @Json(name = IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_ACTION) String str3, @Json(name = IBoxAdminSettings.SETTING_RESTRICT_TO_ENCRYPTED_CLIENT) String str4, @Json(name = IBoxAdminSettings.SETTING_MOBILE_PASSCODE_LOCK_INTERVAL) String str5, @Json(name = IBoxAdminSettings.SETTING_REQUIRE_MOBILE_PASSCODE_LOCK) String str6, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE) String str7, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_PRINT) String str8, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_OPEN_IN) String str9, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD) String str10, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_COPY_PASTE) String str11, @Json(name = IBoxAdminSettings.SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING) String str12, @Json(name = IBoxAdminSettings.SETTING_WOPI_SERVICE_ID) String str13, @Json(name = IBoxAdminSettings.SETTING_ENABLE_VIEWING_ANNOTATIONS) String str14, @Json(name = IBoxAdminSettings.SETTING_ENABLE_CREATING_ANNOTATIONS) String str15, @Json(name = IBoxAdminSettings.SETTING_ENABLE_INTUNE_MAM) String str16, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_PREVIEW) String str17, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_STUDIO) String str18, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_NOTES) String str19, @Json(name = IBoxAdminSettings.SETTING_ENABLE_BOX_AI_MULTIDOC) String str20, @Json(name = IBoxAdminSettings.SETTING_ENABLE_HUBS_GALLERY) String str21, @Json(name = IBoxAdminSettings.SETTING_ENABLE_HUBS_AI) String str22, @Json(name = IBoxAdminSettings.SETTING_AX_CENTER_IN_WEB) String str23) {
        this.jwtAppSettings = jWTAppSettings;
        this.licenseKeys = licenseKeys;
        this.observability = observabilityDTO;
        this.minimumVersion = str;
        this.minimumVersionFailureMessage = str2;
        this.minimumVersionFailureAction = str3;
        this.restrictToEncryptedClientOnly = str4;
        this.mobilePasscodeLockInterval = str5;
        this.requireMobilePasscodeLock = str6;
        this.enableMobileSaveOnDevice = str7;
        this.enableMobilePrint = str8;
        this.enableMobileOpenIn = str9;
        this.enableMobileAutoPhotoUpload = str10;
        this.enableMobileCopyPaste = str11;
        this.enableMobilePreviewOnlyOfflining = str12;
        this.wopiServiceId = str13;
        this.enableViewingAnnotations = str14;
        this.enableCreatingAnnotations = str15;
        this.intuneMAMEnabled = str16;
        this.enableBoxAiPreview = str17;
        this.enableBoxAiStudio = str18;
        this.enableBoxAiNotes = str19;
        this.enableBoxAiMultidoc = str20;
        this.enableHubsGallery = str21;
        this.enableHubsAi = str22;
        this.axCenterInWeb = str23;
    }

    public /* synthetic */ ClientSettingsDTO(JWTAppSettings jWTAppSettings, LicenseKeys licenseKeys, ObservabilityDTO observabilityDTO, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jWTAppSettings, (i & 2) != 0 ? null : licenseKeys, (i & 4) != 0 ? null : observabilityDTO, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : str12, (i & 32768) != 0 ? null : str13, (i & 65536) != 0 ? null : str14, (i & 131072) != 0 ? null : str15, (i & 262144) != 0 ? null : str16, (i & 524288) != 0 ? null : str17, (i & 1048576) != 0 ? null : str18, (i & 2097152) != 0 ? null : str19, (i & 4194304) != 0 ? null : str20, (i & 8388608) != 0 ? null : str21, (i & 16777216) != 0 ? null : str22, (i & 33554432) != 0 ? null : str23);
    }

    public final JWTAppSettings getJwtAppSettings() {
        return this.jwtAppSettings;
    }

    public final LicenseKeys getLicenseKeys() {
        return this.licenseKeys;
    }

    public final ObservabilityDTO getObservability() {
        return this.observability;
    }

    public final String getMinimumVersion() {
        return this.minimumVersion;
    }

    public final String getMinimumVersionFailureMessage() {
        return this.minimumVersionFailureMessage;
    }

    public final String getMinimumVersionFailureAction() {
        return this.minimumVersionFailureAction;
    }

    public final String getRestrictToEncryptedClientOnly() {
        return this.restrictToEncryptedClientOnly;
    }

    public final String getMobilePasscodeLockInterval() {
        return this.mobilePasscodeLockInterval;
    }

    public final String getRequireMobilePasscodeLock() {
        return this.requireMobilePasscodeLock;
    }

    public final String getEnableMobileSaveOnDevice() {
        return this.enableMobileSaveOnDevice;
    }

    public final String getEnableMobilePrint() {
        return this.enableMobilePrint;
    }

    public final String getEnableMobileOpenIn() {
        return this.enableMobileOpenIn;
    }

    public final String getEnableMobileAutoPhotoUpload() {
        return this.enableMobileAutoPhotoUpload;
    }

    public final String getEnableMobileCopyPaste() {
        return this.enableMobileCopyPaste;
    }

    public final String getEnableMobilePreviewOnlyOfflining() {
        return this.enableMobilePreviewOnlyOfflining;
    }

    public final String getWopiServiceId() {
        return this.wopiServiceId;
    }

    public final String getEnableViewingAnnotations() {
        return this.enableViewingAnnotations;
    }

    public final String getEnableCreatingAnnotations() {
        return this.enableCreatingAnnotations;
    }

    public final String getIntuneMAMEnabled() {
        return this.intuneMAMEnabled;
    }

    public final String getEnableBoxAiPreview() {
        return this.enableBoxAiPreview;
    }

    public final String getEnableBoxAiStudio() {
        return this.enableBoxAiStudio;
    }

    public final String getEnableBoxAiNotes() {
        return this.enableBoxAiNotes;
    }

    public final String getEnableBoxAiMultidoc() {
        return this.enableBoxAiMultidoc;
    }

    public final String getEnableHubsGallery() {
        return this.enableHubsGallery;
    }

    public final String getEnableHubsAi() {
        return this.enableHubsAi;
    }

    public final String getAxCenterInWeb() {
        return this.axCenterInWeb;
    }
}
