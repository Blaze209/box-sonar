package com.box.android.capture.cpl;

import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.capture.CameraSession;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.ICaptureShutterSoundHelper;
import com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment;
import com.box.android.capture.documentscanning.DocumentScanningEnvironment;
import com.box.android.capture.imagecapture.logic.IImageCaptureHelper;
import com.box.android.capture.videorecording.VideoRecordingFileManager;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.capture.CaptureFolderUseCase;
import com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\t\u0010A\u001a\u00020\rHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0015HÆ\u0003J\t\u0010F\u001a\u00020\u0017HÆ\u0003J\t\u0010G\u001a\u00020\u0019HÆ\u0003J\t\u0010H\u001a\u00020\u001bHÆ\u0003J\t\u0010I\u001a\u00020\u001dHÆ\u0003J\u0095\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001J\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\t\u0010P\u001a\u00020QHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006R"}, d2 = {"Lcom/box/android/capture/cpl/CaptureEnvironment;", "", "capturePreferencesService", "Lcom/box/android/domain/services/ICapturePreferencesService;", "captureLocalItemsUseCase", "Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;", "cameraSession", "Lcom/box/android/capture/CameraSession;", "uploadManager", "Lcom/box/android/capture/CaptureUploadFileManager;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "permissionsHandler", "Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "videoRecordingFileManager", "Lcom/box/android/capture/videorecording/VideoRecordingFileManager;", "documentScanningEnvironment", "Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "captureSettingsEnvironment", "Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;", "audioCaptureEnvironment", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "captureFolderInteractor", "Lcom/box/android/domain/usecases/capture/CaptureFolderUseCase;", "imageCaptureHelper", "Lcom/box/android/capture/imagecapture/logic/IImageCaptureHelper;", "captureShutterSoundHelper", "Lcom/box/android/capture/ICaptureShutterSoundHelper;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/ICapturePreferencesService;Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;Lcom/box/android/capture/CameraSession;Lcom/box/android/capture/CaptureUploadFileManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/android/base/presentation/utilities/IPermissionsHandler;Lcom/box/android/capture/videorecording/VideoRecordingFileManager;Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;Lcom/box/android/domain/usecases/capture/CaptureFolderUseCase;Lcom/box/android/capture/imagecapture/logic/IImageCaptureHelper;Lcom/box/android/capture/ICaptureShutterSoundHelper;Lcom/box/android/domain/services/IdMappingService;)V", "getCapturePreferencesService", "()Lcom/box/android/domain/services/ICapturePreferencesService;", "getCaptureLocalItemsUseCase", "()Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;", "getCameraSession", "()Lcom/box/android/capture/CameraSession;", "getUploadManager", "()Lcom/box/android/capture/CaptureUploadFileManager;", "getBoxExtendedApiFolder", "()Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "getPermissionsHandler", "()Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "getVideoRecordingFileManager", "()Lcom/box/android/capture/videorecording/VideoRecordingFileManager;", "getDocumentScanningEnvironment", "()Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "getCaptureSettingsEnvironment", "()Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;", "getAudioCaptureEnvironment", "()Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "getCaptureFolderInteractor", "()Lcom/box/android/domain/usecases/capture/CaptureFolderUseCase;", "getImageCaptureHelper", "()Lcom/box/android/capture/imagecapture/logic/IImageCaptureHelper;", "getCaptureShutterSoundHelper", "()Lcom/box/android/capture/ICaptureShutterSoundHelper;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CaptureEnvironment {
    public static final int $stable = 8;
    private final AudioCaptureEnvironment audioCaptureEnvironment;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final CameraSession cameraSession;
    private final CaptureFolderUseCase captureFolderInteractor;
    private final CaptureLocalItemsUseCase captureLocalItemsUseCase;
    private final ICapturePreferencesService capturePreferencesService;
    private final CaptureSettingsEnvironment captureSettingsEnvironment;
    private final ICaptureShutterSoundHelper captureShutterSoundHelper;
    private final DocumentScanningEnvironment documentScanningEnvironment;
    private final IdMappingService idMappingService;
    private final IImageCaptureHelper imageCaptureHelper;
    private final IPermissionsHandler permissionsHandler;
    private final CaptureUploadFileManager uploadManager;
    private final VideoRecordingFileManager videoRecordingFileManager;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final AudioCaptureEnvironment getAudioCaptureEnvironment() {
        return this.audioCaptureEnvironment;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final CaptureFolderUseCase getCaptureFolderInteractor() {
        return this.captureFolderInteractor;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final IImageCaptureHelper getImageCaptureHelper() {
        return this.imageCaptureHelper;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final ICaptureShutterSoundHelper getCaptureShutterSoundHelper() {
        return this.captureShutterSoundHelper;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CaptureLocalItemsUseCase getCaptureLocalItemsUseCase() {
        return this.captureLocalItemsUseCase;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CameraSession getCameraSession() {
        return this.cameraSession;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CaptureUploadFileManager getUploadManager() {
        return this.uploadManager;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final BoxExtendedApiFolder getBoxExtendedApiFolder() {
        return this.boxExtendedApiFolder;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final IPermissionsHandler getPermissionsHandler() {
        return this.permissionsHandler;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final VideoRecordingFileManager getVideoRecordingFileManager() {
        return this.videoRecordingFileManager;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DocumentScanningEnvironment getDocumentScanningEnvironment() {
        return this.documentScanningEnvironment;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CaptureSettingsEnvironment getCaptureSettingsEnvironment() {
        return this.captureSettingsEnvironment;
    }

    public final CaptureEnvironment copy(ICapturePreferencesService capturePreferencesService, CaptureLocalItemsUseCase captureLocalItemsUseCase, CameraSession cameraSession, CaptureUploadFileManager uploadManager, BoxExtendedApiFolder boxExtendedApiFolder, IPermissionsHandler permissionsHandler, VideoRecordingFileManager videoRecordingFileManager, DocumentScanningEnvironment documentScanningEnvironment, CaptureSettingsEnvironment captureSettingsEnvironment, AudioCaptureEnvironment audioCaptureEnvironment, CaptureFolderUseCase captureFolderInteractor, IImageCaptureHelper imageCaptureHelper, ICaptureShutterSoundHelper captureShutterSoundHelper, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        Intrinsics.checkNotNullParameter(captureLocalItemsUseCase, "captureLocalItemsUseCase");
        Intrinsics.checkNotNullParameter(cameraSession, "cameraSession");
        Intrinsics.checkNotNullParameter(uploadManager, "uploadManager");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        Intrinsics.checkNotNullParameter(videoRecordingFileManager, "videoRecordingFileManager");
        Intrinsics.checkNotNullParameter(documentScanningEnvironment, "documentScanningEnvironment");
        Intrinsics.checkNotNullParameter(captureSettingsEnvironment, "captureSettingsEnvironment");
        Intrinsics.checkNotNullParameter(audioCaptureEnvironment, "audioCaptureEnvironment");
        Intrinsics.checkNotNullParameter(captureFolderInteractor, "captureFolderInteractor");
        Intrinsics.checkNotNullParameter(imageCaptureHelper, "imageCaptureHelper");
        Intrinsics.checkNotNullParameter(captureShutterSoundHelper, "captureShutterSoundHelper");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        return new CaptureEnvironment(capturePreferencesService, captureLocalItemsUseCase, cameraSession, uploadManager, boxExtendedApiFolder, permissionsHandler, videoRecordingFileManager, documentScanningEnvironment, captureSettingsEnvironment, audioCaptureEnvironment, captureFolderInteractor, imageCaptureHelper, captureShutterSoundHelper, idMappingService);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureEnvironment)) {
            return false;
        }
        CaptureEnvironment captureEnvironment = (CaptureEnvironment) other;
        return Intrinsics.areEqual(this.capturePreferencesService, captureEnvironment.capturePreferencesService) && Intrinsics.areEqual(this.captureLocalItemsUseCase, captureEnvironment.captureLocalItemsUseCase) && Intrinsics.areEqual(this.cameraSession, captureEnvironment.cameraSession) && Intrinsics.areEqual(this.uploadManager, captureEnvironment.uploadManager) && Intrinsics.areEqual(this.boxExtendedApiFolder, captureEnvironment.boxExtendedApiFolder) && Intrinsics.areEqual(this.permissionsHandler, captureEnvironment.permissionsHandler) && Intrinsics.areEqual(this.videoRecordingFileManager, captureEnvironment.videoRecordingFileManager) && Intrinsics.areEqual(this.documentScanningEnvironment, captureEnvironment.documentScanningEnvironment) && Intrinsics.areEqual(this.captureSettingsEnvironment, captureEnvironment.captureSettingsEnvironment) && Intrinsics.areEqual(this.audioCaptureEnvironment, captureEnvironment.audioCaptureEnvironment) && Intrinsics.areEqual(this.captureFolderInteractor, captureEnvironment.captureFolderInteractor) && Intrinsics.areEqual(this.imageCaptureHelper, captureEnvironment.imageCaptureHelper) && Intrinsics.areEqual(this.captureShutterSoundHelper, captureEnvironment.captureShutterSoundHelper) && Intrinsics.areEqual(this.idMappingService, captureEnvironment.idMappingService);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.capturePreferencesService.hashCode() * 31) + this.captureLocalItemsUseCase.hashCode()) * 31) + this.cameraSession.hashCode()) * 31) + this.uploadManager.hashCode()) * 31) + this.boxExtendedApiFolder.hashCode()) * 31) + this.permissionsHandler.hashCode()) * 31) + this.videoRecordingFileManager.hashCode()) * 31) + this.documentScanningEnvironment.hashCode()) * 31) + this.captureSettingsEnvironment.hashCode()) * 31) + this.audioCaptureEnvironment.hashCode()) * 31) + this.captureFolderInteractor.hashCode()) * 31) + this.imageCaptureHelper.hashCode()) * 31) + this.captureShutterSoundHelper.hashCode()) * 31) + this.idMappingService.hashCode();
    }

    public String toString() {
        return "CaptureEnvironment(capturePreferencesService=" + this.capturePreferencesService + ", captureLocalItemsUseCase=" + this.captureLocalItemsUseCase + ", cameraSession=" + this.cameraSession + ", uploadManager=" + this.uploadManager + ", boxExtendedApiFolder=" + this.boxExtendedApiFolder + ", permissionsHandler=" + this.permissionsHandler + ", videoRecordingFileManager=" + this.videoRecordingFileManager + ", documentScanningEnvironment=" + this.documentScanningEnvironment + ", captureSettingsEnvironment=" + this.captureSettingsEnvironment + ", audioCaptureEnvironment=" + this.audioCaptureEnvironment + ", captureFolderInteractor=" + this.captureFolderInteractor + ", imageCaptureHelper=" + this.imageCaptureHelper + ", captureShutterSoundHelper=" + this.captureShutterSoundHelper + ", idMappingService=" + this.idMappingService + ")";
    }

    @Inject
    public CaptureEnvironment(ICapturePreferencesService capturePreferencesService, CaptureLocalItemsUseCase captureLocalItemsUseCase, CameraSession cameraSession, CaptureUploadFileManager uploadManager, BoxExtendedApiFolder boxExtendedApiFolder, IPermissionsHandler permissionsHandler, VideoRecordingFileManager videoRecordingFileManager, DocumentScanningEnvironment documentScanningEnvironment, CaptureSettingsEnvironment captureSettingsEnvironment, AudioCaptureEnvironment audioCaptureEnvironment, CaptureFolderUseCase captureFolderInteractor, IImageCaptureHelper imageCaptureHelper, ICaptureShutterSoundHelper captureShutterSoundHelper, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        Intrinsics.checkNotNullParameter(captureLocalItemsUseCase, "captureLocalItemsUseCase");
        Intrinsics.checkNotNullParameter(cameraSession, "cameraSession");
        Intrinsics.checkNotNullParameter(uploadManager, "uploadManager");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        Intrinsics.checkNotNullParameter(videoRecordingFileManager, "videoRecordingFileManager");
        Intrinsics.checkNotNullParameter(documentScanningEnvironment, "documentScanningEnvironment");
        Intrinsics.checkNotNullParameter(captureSettingsEnvironment, "captureSettingsEnvironment");
        Intrinsics.checkNotNullParameter(audioCaptureEnvironment, "audioCaptureEnvironment");
        Intrinsics.checkNotNullParameter(captureFolderInteractor, "captureFolderInteractor");
        Intrinsics.checkNotNullParameter(imageCaptureHelper, "imageCaptureHelper");
        Intrinsics.checkNotNullParameter(captureShutterSoundHelper, "captureShutterSoundHelper");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.capturePreferencesService = capturePreferencesService;
        this.captureLocalItemsUseCase = captureLocalItemsUseCase;
        this.cameraSession = cameraSession;
        this.uploadManager = uploadManager;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.permissionsHandler = permissionsHandler;
        this.videoRecordingFileManager = videoRecordingFileManager;
        this.documentScanningEnvironment = documentScanningEnvironment;
        this.captureSettingsEnvironment = captureSettingsEnvironment;
        this.audioCaptureEnvironment = audioCaptureEnvironment;
        this.captureFolderInteractor = captureFolderInteractor;
        this.imageCaptureHelper = imageCaptureHelper;
        this.captureShutterSoundHelper = captureShutterSoundHelper;
        this.idMappingService = idMappingService;
    }

    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }

    public final CaptureLocalItemsUseCase getCaptureLocalItemsUseCase() {
        return this.captureLocalItemsUseCase;
    }

    public final CameraSession getCameraSession() {
        return this.cameraSession;
    }

    public final CaptureUploadFileManager getUploadManager() {
        return this.uploadManager;
    }

    public final BoxExtendedApiFolder getBoxExtendedApiFolder() {
        return this.boxExtendedApiFolder;
    }

    public final IPermissionsHandler getPermissionsHandler() {
        return this.permissionsHandler;
    }

    public final VideoRecordingFileManager getVideoRecordingFileManager() {
        return this.videoRecordingFileManager;
    }

    public final DocumentScanningEnvironment getDocumentScanningEnvironment() {
        return this.documentScanningEnvironment;
    }

    public final CaptureSettingsEnvironment getCaptureSettingsEnvironment() {
        return this.captureSettingsEnvironment;
    }

    public final AudioCaptureEnvironment getAudioCaptureEnvironment() {
        return this.audioCaptureEnvironment;
    }

    public final CaptureFolderUseCase getCaptureFolderInteractor() {
        return this.captureFolderInteractor;
    }

    public final IImageCaptureHelper getImageCaptureHelper() {
        return this.imageCaptureHelper;
    }

    public final ICaptureShutterSoundHelper getCaptureShutterSoundHelper() {
        return this.captureShutterSoundHelper;
    }

    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }
}
