package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b@\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b \u0010!J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010G\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÄ\u0002\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\r2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u000bHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\f\u0010-R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u000e\u0010-R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u000f\u0010-R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0010\u0010-R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0011\u0010-R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0012\u0010-R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0013\u0010-R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0014\u0010-R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0015\u0010-R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0016\u0010-R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0017\u0010-R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0018\u0010-R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0019\u0010-R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u001a\u0010-R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u001b\u0010-R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u001c\u0010-R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u001d\u0010-R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u001e\u0010-R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#¨\u0006Q"}, d2 = {"Lcom/box/android/domain/models/ClientSettingsModel;", "Lcom/box/android/domain/models/DomainModel;", "geniusScanLicense", "", "rumProxyUrl", "rumSamplingRatio", "", "minimumVersion", "minimumVersionFailureMessage", "minimumVersionFailureAction", "passcodeLockInterval", "", "isPasscodeLockRequired", "", "isSaveOnDeviceAllowed", "isEncryptedDeviceRequired", "isCopyPasteAllowed", "isPrintAllowed", "isOpenInAllowed", "isAutoPhotoUploadAllowed", "isPreviewOnlyOffliningEnabled", "isViewingAnnotationsAllowed", "isCreatingAnnotationsAllowed", "isIntuneMAMEnabled", "isBoxAiPreviewEnabled", "isBoxAiStudioEnabled", "isBoxAiNotesEnabled", "isBoxAiMultidocEnabled", "isHubsGalleryEnabled", "isHubsAIEnabled", "isAxCenterInWebEnabled", "wopiServiceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getGeniusScanLicense", "()Ljava/lang/String;", "getRumProxyUrl", "getRumSamplingRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMinimumVersion", "getMinimumVersionFailureMessage", "getMinimumVersionFailureAction", "getPasscodeLockInterval", "()I", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWopiServiceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/box/android/domain/models/ClientSettingsModel;", "equals", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ClientSettingsModel implements DomainModel {
    private final String geniusScanLicense;
    private final Boolean isAutoPhotoUploadAllowed;
    private final Boolean isAxCenterInWebEnabled;
    private final Boolean isBoxAiMultidocEnabled;
    private final Boolean isBoxAiNotesEnabled;
    private final Boolean isBoxAiPreviewEnabled;
    private final Boolean isBoxAiStudioEnabled;
    private final Boolean isCopyPasteAllowed;
    private final Boolean isCreatingAnnotationsAllowed;
    private final Boolean isEncryptedDeviceRequired;
    private final Boolean isHubsAIEnabled;
    private final Boolean isHubsGalleryEnabled;
    private final Boolean isIntuneMAMEnabled;
    private final Boolean isOpenInAllowed;
    private final Boolean isPasscodeLockRequired;
    private final Boolean isPreviewOnlyOffliningEnabled;
    private final Boolean isPrintAllowed;
    private final Boolean isSaveOnDeviceAllowed;
    private final Boolean isViewingAnnotationsAllowed;
    private final String minimumVersion;
    private final String minimumVersionFailureAction;
    private final String minimumVersionFailureMessage;
    private final int passcodeLockInterval;
    private final String rumProxyUrl;
    private final Double rumSamplingRatio;
    private final String wopiServiceId;

    public static /* synthetic */ ClientSettingsModel copy$default(ClientSettingsModel clientSettingsModel, String str, String str2, Double d, String str3, String str4, String str5, int i, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, String str6, int i2, Object obj) {
        String str7;
        Boolean bool19;
        String str8 = (i2 & 1) != 0 ? clientSettingsModel.geniusScanLicense : str;
        String str9 = (i2 & 2) != 0 ? clientSettingsModel.rumProxyUrl : str2;
        Double d2 = (i2 & 4) != 0 ? clientSettingsModel.rumSamplingRatio : d;
        String str10 = (i2 & 8) != 0 ? clientSettingsModel.minimumVersion : str3;
        String str11 = (i2 & 16) != 0 ? clientSettingsModel.minimumVersionFailureMessage : str4;
        String str12 = (i2 & 32) != 0 ? clientSettingsModel.minimumVersionFailureAction : str5;
        int i3 = (i2 & 64) != 0 ? clientSettingsModel.passcodeLockInterval : i;
        Boolean bool20 = (i2 & 128) != 0 ? clientSettingsModel.isPasscodeLockRequired : bool;
        Boolean bool21 = (i2 & 256) != 0 ? clientSettingsModel.isSaveOnDeviceAllowed : bool2;
        Boolean bool22 = (i2 & 512) != 0 ? clientSettingsModel.isEncryptedDeviceRequired : bool3;
        Boolean bool23 = (i2 & 1024) != 0 ? clientSettingsModel.isCopyPasteAllowed : bool4;
        Boolean bool24 = (i2 & 2048) != 0 ? clientSettingsModel.isPrintAllowed : bool5;
        Boolean bool25 = (i2 & 4096) != 0 ? clientSettingsModel.isOpenInAllowed : bool6;
        Boolean bool26 = (i2 & 8192) != 0 ? clientSettingsModel.isAutoPhotoUploadAllowed : bool7;
        String str13 = str8;
        Boolean bool27 = (i2 & 16384) != 0 ? clientSettingsModel.isPreviewOnlyOffliningEnabled : bool8;
        Boolean bool28 = (i2 & 32768) != 0 ? clientSettingsModel.isViewingAnnotationsAllowed : bool9;
        Boolean bool29 = (i2 & 65536) != 0 ? clientSettingsModel.isCreatingAnnotationsAllowed : bool10;
        Boolean bool30 = (i2 & 131072) != 0 ? clientSettingsModel.isIntuneMAMEnabled : bool11;
        Boolean bool31 = (i2 & 262144) != 0 ? clientSettingsModel.isBoxAiPreviewEnabled : bool12;
        Boolean bool32 = (i2 & 524288) != 0 ? clientSettingsModel.isBoxAiStudioEnabled : bool13;
        Boolean bool33 = (i2 & 1048576) != 0 ? clientSettingsModel.isBoxAiNotesEnabled : bool14;
        Boolean bool34 = (i2 & 2097152) != 0 ? clientSettingsModel.isBoxAiMultidocEnabled : bool15;
        Boolean bool35 = (i2 & 4194304) != 0 ? clientSettingsModel.isHubsGalleryEnabled : bool16;
        Boolean bool36 = (i2 & 8388608) != 0 ? clientSettingsModel.isHubsAIEnabled : bool17;
        Boolean bool37 = (i2 & 16777216) != 0 ? clientSettingsModel.isAxCenterInWebEnabled : bool18;
        if ((i2 & 33554432) != 0) {
            bool19 = bool37;
            str7 = clientSettingsModel.wopiServiceId;
        } else {
            str7 = str6;
            bool19 = bool37;
        }
        return clientSettingsModel.copy(str13, str9, d2, str10, str11, str12, i3, bool20, bool21, bool22, bool23, bool24, bool25, bool26, bool27, bool28, bool29, bool30, bool31, bool32, bool33, bool34, bool35, bool36, bool19, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGeniusScanLicense() {
        return this.geniusScanLicense;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getIsEncryptedDeviceRequired() {
        return this.isEncryptedDeviceRequired;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getIsCopyPasteAllowed() {
        return this.isCopyPasteAllowed;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getIsPrintAllowed() {
        return this.isPrintAllowed;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getIsOpenInAllowed() {
        return this.isOpenInAllowed;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getIsAutoPhotoUploadAllowed() {
        return this.isAutoPhotoUploadAllowed;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Boolean getIsPreviewOnlyOffliningEnabled() {
        return this.isPreviewOnlyOffliningEnabled;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Boolean getIsViewingAnnotationsAllowed() {
        return this.isViewingAnnotationsAllowed;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getIsCreatingAnnotationsAllowed() {
        return this.isCreatingAnnotationsAllowed;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getIsIntuneMAMEnabled() {
        return this.isIntuneMAMEnabled;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Boolean getIsBoxAiPreviewEnabled() {
        return this.isBoxAiPreviewEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRumProxyUrl() {
        return this.rumProxyUrl;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Boolean getIsBoxAiStudioEnabled() {
        return this.isBoxAiStudioEnabled;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Boolean getIsBoxAiNotesEnabled() {
        return this.isBoxAiNotesEnabled;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Boolean getIsBoxAiMultidocEnabled() {
        return this.isBoxAiMultidocEnabled;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Boolean getIsHubsGalleryEnabled() {
        return this.isHubsGalleryEnabled;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Boolean getIsHubsAIEnabled() {
        return this.isHubsAIEnabled;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Boolean getIsAxCenterInWebEnabled() {
        return this.isAxCenterInWebEnabled;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getWopiServiceId() {
        return this.wopiServiceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getRumSamplingRatio() {
        return this.rumSamplingRatio;
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
    public final int getPasscodeLockInterval() {
        return this.passcodeLockInterval;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsPasscodeLockRequired() {
        return this.isPasscodeLockRequired;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getIsSaveOnDeviceAllowed() {
        return this.isSaveOnDeviceAllowed;
    }

    public final ClientSettingsModel copy(String geniusScanLicense, String rumProxyUrl, Double rumSamplingRatio, String minimumVersion, String minimumVersionFailureMessage, String minimumVersionFailureAction, int passcodeLockInterval, Boolean isPasscodeLockRequired, Boolean isSaveOnDeviceAllowed, Boolean isEncryptedDeviceRequired, Boolean isCopyPasteAllowed, Boolean isPrintAllowed, Boolean isOpenInAllowed, Boolean isAutoPhotoUploadAllowed, Boolean isPreviewOnlyOffliningEnabled, Boolean isViewingAnnotationsAllowed, Boolean isCreatingAnnotationsAllowed, Boolean isIntuneMAMEnabled, Boolean isBoxAiPreviewEnabled, Boolean isBoxAiStudioEnabled, Boolean isBoxAiNotesEnabled, Boolean isBoxAiMultidocEnabled, Boolean isHubsGalleryEnabled, Boolean isHubsAIEnabled, Boolean isAxCenterInWebEnabled, String wopiServiceId) {
        return new ClientSettingsModel(geniusScanLicense, rumProxyUrl, rumSamplingRatio, minimumVersion, minimumVersionFailureMessage, minimumVersionFailureAction, passcodeLockInterval, isPasscodeLockRequired, isSaveOnDeviceAllowed, isEncryptedDeviceRequired, isCopyPasteAllowed, isPrintAllowed, isOpenInAllowed, isAutoPhotoUploadAllowed, isPreviewOnlyOffliningEnabled, isViewingAnnotationsAllowed, isCreatingAnnotationsAllowed, isIntuneMAMEnabled, isBoxAiPreviewEnabled, isBoxAiStudioEnabled, isBoxAiNotesEnabled, isBoxAiMultidocEnabled, isHubsGalleryEnabled, isHubsAIEnabled, isAxCenterInWebEnabled, wopiServiceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientSettingsModel)) {
            return false;
        }
        ClientSettingsModel clientSettingsModel = (ClientSettingsModel) other;
        return Intrinsics.areEqual(this.geniusScanLicense, clientSettingsModel.geniusScanLicense) && Intrinsics.areEqual(this.rumProxyUrl, clientSettingsModel.rumProxyUrl) && Intrinsics.areEqual((Object) this.rumSamplingRatio, (Object) clientSettingsModel.rumSamplingRatio) && Intrinsics.areEqual(this.minimumVersion, clientSettingsModel.minimumVersion) && Intrinsics.areEqual(this.minimumVersionFailureMessage, clientSettingsModel.minimumVersionFailureMessage) && Intrinsics.areEqual(this.minimumVersionFailureAction, clientSettingsModel.minimumVersionFailureAction) && this.passcodeLockInterval == clientSettingsModel.passcodeLockInterval && Intrinsics.areEqual(this.isPasscodeLockRequired, clientSettingsModel.isPasscodeLockRequired) && Intrinsics.areEqual(this.isSaveOnDeviceAllowed, clientSettingsModel.isSaveOnDeviceAllowed) && Intrinsics.areEqual(this.isEncryptedDeviceRequired, clientSettingsModel.isEncryptedDeviceRequired) && Intrinsics.areEqual(this.isCopyPasteAllowed, clientSettingsModel.isCopyPasteAllowed) && Intrinsics.areEqual(this.isPrintAllowed, clientSettingsModel.isPrintAllowed) && Intrinsics.areEqual(this.isOpenInAllowed, clientSettingsModel.isOpenInAllowed) && Intrinsics.areEqual(this.isAutoPhotoUploadAllowed, clientSettingsModel.isAutoPhotoUploadAllowed) && Intrinsics.areEqual(this.isPreviewOnlyOffliningEnabled, clientSettingsModel.isPreviewOnlyOffliningEnabled) && Intrinsics.areEqual(this.isViewingAnnotationsAllowed, clientSettingsModel.isViewingAnnotationsAllowed) && Intrinsics.areEqual(this.isCreatingAnnotationsAllowed, clientSettingsModel.isCreatingAnnotationsAllowed) && Intrinsics.areEqual(this.isIntuneMAMEnabled, clientSettingsModel.isIntuneMAMEnabled) && Intrinsics.areEqual(this.isBoxAiPreviewEnabled, clientSettingsModel.isBoxAiPreviewEnabled) && Intrinsics.areEqual(this.isBoxAiStudioEnabled, clientSettingsModel.isBoxAiStudioEnabled) && Intrinsics.areEqual(this.isBoxAiNotesEnabled, clientSettingsModel.isBoxAiNotesEnabled) && Intrinsics.areEqual(this.isBoxAiMultidocEnabled, clientSettingsModel.isBoxAiMultidocEnabled) && Intrinsics.areEqual(this.isHubsGalleryEnabled, clientSettingsModel.isHubsGalleryEnabled) && Intrinsics.areEqual(this.isHubsAIEnabled, clientSettingsModel.isHubsAIEnabled) && Intrinsics.areEqual(this.isAxCenterInWebEnabled, clientSettingsModel.isAxCenterInWebEnabled) && Intrinsics.areEqual(this.wopiServiceId, clientSettingsModel.wopiServiceId);
    }

    public int hashCode() {
        String str = this.geniusScanLicense;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rumProxyUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.rumSamplingRatio;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        String str3 = this.minimumVersion;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.minimumVersionFailureMessage;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.minimumVersionFailureAction;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.passcodeLockInterval)) * 31;
        Boolean bool = this.isPasscodeLockRequired;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isSaveOnDeviceAllowed;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isEncryptedDeviceRequired;
        int iHashCode9 = (iHashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isCopyPasteAllowed;
        int iHashCode10 = (iHashCode9 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isPrintAllowed;
        int iHashCode11 = (iHashCode10 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isOpenInAllowed;
        int iHashCode12 = (iHashCode11 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.isAutoPhotoUploadAllowed;
        int iHashCode13 = (iHashCode12 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.isPreviewOnlyOffliningEnabled;
        int iHashCode14 = (iHashCode13 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.isViewingAnnotationsAllowed;
        int iHashCode15 = (iHashCode14 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.isCreatingAnnotationsAllowed;
        int iHashCode16 = (iHashCode15 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Boolean bool11 = this.isIntuneMAMEnabled;
        int iHashCode17 = (iHashCode16 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Boolean bool12 = this.isBoxAiPreviewEnabled;
        int iHashCode18 = (iHashCode17 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        Boolean bool13 = this.isBoxAiStudioEnabled;
        int iHashCode19 = (iHashCode18 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
        Boolean bool14 = this.isBoxAiNotesEnabled;
        int iHashCode20 = (iHashCode19 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
        Boolean bool15 = this.isBoxAiMultidocEnabled;
        int iHashCode21 = (iHashCode20 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
        Boolean bool16 = this.isHubsGalleryEnabled;
        int iHashCode22 = (iHashCode21 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
        Boolean bool17 = this.isHubsAIEnabled;
        int iHashCode23 = (iHashCode22 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
        Boolean bool18 = this.isAxCenterInWebEnabled;
        int iHashCode24 = (iHashCode23 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
        String str6 = this.wopiServiceId;
        return iHashCode24 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "ClientSettingsModel(geniusScanLicense=" + this.geniusScanLicense + ", rumProxyUrl=" + this.rumProxyUrl + ", rumSamplingRatio=" + this.rumSamplingRatio + ", minimumVersion=" + this.minimumVersion + ", minimumVersionFailureMessage=" + this.minimumVersionFailureMessage + ", minimumVersionFailureAction=" + this.minimumVersionFailureAction + ", passcodeLockInterval=" + this.passcodeLockInterval + ", isPasscodeLockRequired=" + this.isPasscodeLockRequired + ", isSaveOnDeviceAllowed=" + this.isSaveOnDeviceAllowed + ", isEncryptedDeviceRequired=" + this.isEncryptedDeviceRequired + ", isCopyPasteAllowed=" + this.isCopyPasteAllowed + ", isPrintAllowed=" + this.isPrintAllowed + ", isOpenInAllowed=" + this.isOpenInAllowed + ", isAutoPhotoUploadAllowed=" + this.isAutoPhotoUploadAllowed + ", isPreviewOnlyOffliningEnabled=" + this.isPreviewOnlyOffliningEnabled + ", isViewingAnnotationsAllowed=" + this.isViewingAnnotationsAllowed + ", isCreatingAnnotationsAllowed=" + this.isCreatingAnnotationsAllowed + ", isIntuneMAMEnabled=" + this.isIntuneMAMEnabled + ", isBoxAiPreviewEnabled=" + this.isBoxAiPreviewEnabled + ", isBoxAiStudioEnabled=" + this.isBoxAiStudioEnabled + ", isBoxAiNotesEnabled=" + this.isBoxAiNotesEnabled + ", isBoxAiMultidocEnabled=" + this.isBoxAiMultidocEnabled + ", isHubsGalleryEnabled=" + this.isHubsGalleryEnabled + ", isHubsAIEnabled=" + this.isHubsAIEnabled + ", isAxCenterInWebEnabled=" + this.isAxCenterInWebEnabled + ", wopiServiceId=" + this.wopiServiceId + ")";
    }

    public ClientSettingsModel(String str, String str2, Double d, String str3, String str4, String str5, int i, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, String str6) {
        this.geniusScanLicense = str;
        this.rumProxyUrl = str2;
        this.rumSamplingRatio = d;
        this.minimumVersion = str3;
        this.minimumVersionFailureMessage = str4;
        this.minimumVersionFailureAction = str5;
        this.passcodeLockInterval = i;
        this.isPasscodeLockRequired = bool;
        this.isSaveOnDeviceAllowed = bool2;
        this.isEncryptedDeviceRequired = bool3;
        this.isCopyPasteAllowed = bool4;
        this.isPrintAllowed = bool5;
        this.isOpenInAllowed = bool6;
        this.isAutoPhotoUploadAllowed = bool7;
        this.isPreviewOnlyOffliningEnabled = bool8;
        this.isViewingAnnotationsAllowed = bool9;
        this.isCreatingAnnotationsAllowed = bool10;
        this.isIntuneMAMEnabled = bool11;
        this.isBoxAiPreviewEnabled = bool12;
        this.isBoxAiStudioEnabled = bool13;
        this.isBoxAiNotesEnabled = bool14;
        this.isBoxAiMultidocEnabled = bool15;
        this.isHubsGalleryEnabled = bool16;
        this.isHubsAIEnabled = bool17;
        this.isAxCenterInWebEnabled = bool18;
        this.wopiServiceId = str6;
    }

    public final String getGeniusScanLicense() {
        return this.geniusScanLicense;
    }

    public final String getRumProxyUrl() {
        return this.rumProxyUrl;
    }

    public final Double getRumSamplingRatio() {
        return this.rumSamplingRatio;
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

    public final int getPasscodeLockInterval() {
        return this.passcodeLockInterval;
    }

    public final Boolean isPasscodeLockRequired() {
        return this.isPasscodeLockRequired;
    }

    public final Boolean isSaveOnDeviceAllowed() {
        return this.isSaveOnDeviceAllowed;
    }

    public final Boolean isEncryptedDeviceRequired() {
        return this.isEncryptedDeviceRequired;
    }

    public final Boolean isCopyPasteAllowed() {
        return this.isCopyPasteAllowed;
    }

    public final Boolean isPrintAllowed() {
        return this.isPrintAllowed;
    }

    public final Boolean isOpenInAllowed() {
        return this.isOpenInAllowed;
    }

    public final Boolean isAutoPhotoUploadAllowed() {
        return this.isAutoPhotoUploadAllowed;
    }

    public final Boolean isPreviewOnlyOffliningEnabled() {
        return this.isPreviewOnlyOffliningEnabled;
    }

    public final Boolean isViewingAnnotationsAllowed() {
        return this.isViewingAnnotationsAllowed;
    }

    public final Boolean isCreatingAnnotationsAllowed() {
        return this.isCreatingAnnotationsAllowed;
    }

    public final Boolean isIntuneMAMEnabled() {
        return this.isIntuneMAMEnabled;
    }

    public final Boolean isBoxAiPreviewEnabled() {
        return this.isBoxAiPreviewEnabled;
    }

    public final Boolean isBoxAiStudioEnabled() {
        return this.isBoxAiStudioEnabled;
    }

    public final Boolean isBoxAiNotesEnabled() {
        return this.isBoxAiNotesEnabled;
    }

    public final Boolean isBoxAiMultidocEnabled() {
        return this.isBoxAiMultidocEnabled;
    }

    public final Boolean isHubsGalleryEnabled() {
        return this.isHubsGalleryEnabled;
    }

    public final Boolean isHubsAIEnabled() {
        return this.isHubsAIEnabled;
    }

    public final Boolean isAxCenterInWebEnabled() {
        return this.isAxCenterInWebEnabled;
    }

    public final String getWopiServiceId() {
        return this.wopiServiceId;
    }
}
