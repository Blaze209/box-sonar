package com.box.android.capture.cpl;

import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.capture.CameraSession;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.ICaptureShutterSoundHelper;
import com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment;
import com.box.android.capture.documentscanning.DocumentScanningEnvironment;
import com.box.android.capture.imagecapture.logic.IImageCaptureHelper;
import com.box.android.capture.videorecording.VideoRecordingFileManager;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.capture.CaptureFolderUseCase;
import com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureEnvironment_Factory implements Factory<CaptureEnvironment> {
    private final Provider<AudioCaptureEnvironment> audioCaptureEnvironmentProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<CameraSession> cameraSessionProvider;
    private final Provider<CaptureFolderUseCase> captureFolderInteractorProvider;
    private final Provider<CaptureLocalItemsUseCase> captureLocalItemsUseCaseProvider;
    private final Provider<ICapturePreferencesService> capturePreferencesServiceProvider;
    private final Provider<CaptureSettingsEnvironment> captureSettingsEnvironmentProvider;
    private final Provider<ICaptureShutterSoundHelper> captureShutterSoundHelperProvider;
    private final Provider<DocumentScanningEnvironment> documentScanningEnvironmentProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IImageCaptureHelper> imageCaptureHelperProvider;
    private final Provider<IPermissionsHandler> permissionsHandlerProvider;
    private final Provider<CaptureUploadFileManager> uploadManagerProvider;
    private final Provider<VideoRecordingFileManager> videoRecordingFileManagerProvider;

    private CaptureEnvironment_Factory(Provider<ICapturePreferencesService> provider, Provider<CaptureLocalItemsUseCase> provider2, Provider<CameraSession> provider3, Provider<CaptureUploadFileManager> provider4, Provider<BoxExtendedApiFolder> provider5, Provider<IPermissionsHandler> provider6, Provider<VideoRecordingFileManager> provider7, Provider<DocumentScanningEnvironment> provider8, Provider<CaptureSettingsEnvironment> provider9, Provider<AudioCaptureEnvironment> provider10, Provider<CaptureFolderUseCase> provider11, Provider<IImageCaptureHelper> provider12, Provider<ICaptureShutterSoundHelper> provider13, Provider<IdMappingService> provider14) {
        this.capturePreferencesServiceProvider = provider;
        this.captureLocalItemsUseCaseProvider = provider2;
        this.cameraSessionProvider = provider3;
        this.uploadManagerProvider = provider4;
        this.boxExtendedApiFolderProvider = provider5;
        this.permissionsHandlerProvider = provider6;
        this.videoRecordingFileManagerProvider = provider7;
        this.documentScanningEnvironmentProvider = provider8;
        this.captureSettingsEnvironmentProvider = provider9;
        this.audioCaptureEnvironmentProvider = provider10;
        this.captureFolderInteractorProvider = provider11;
        this.imageCaptureHelperProvider = provider12;
        this.captureShutterSoundHelperProvider = provider13;
        this.idMappingServiceProvider = provider14;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureEnvironment get() {
        return newInstance(this.capturePreferencesServiceProvider.get(), this.captureLocalItemsUseCaseProvider.get(), this.cameraSessionProvider.get(), this.uploadManagerProvider.get(), this.boxExtendedApiFolderProvider.get(), this.permissionsHandlerProvider.get(), this.videoRecordingFileManagerProvider.get(), this.documentScanningEnvironmentProvider.get(), this.captureSettingsEnvironmentProvider.get(), this.audioCaptureEnvironmentProvider.get(), this.captureFolderInteractorProvider.get(), this.imageCaptureHelperProvider.get(), this.captureShutterSoundHelperProvider.get(), this.idMappingServiceProvider.get());
    }

    public static CaptureEnvironment_Factory create(Provider<ICapturePreferencesService> provider, Provider<CaptureLocalItemsUseCase> provider2, Provider<CameraSession> provider3, Provider<CaptureUploadFileManager> provider4, Provider<BoxExtendedApiFolder> provider5, Provider<IPermissionsHandler> provider6, Provider<VideoRecordingFileManager> provider7, Provider<DocumentScanningEnvironment> provider8, Provider<CaptureSettingsEnvironment> provider9, Provider<AudioCaptureEnvironment> provider10, Provider<CaptureFolderUseCase> provider11, Provider<IImageCaptureHelper> provider12, Provider<ICaptureShutterSoundHelper> provider13, Provider<IdMappingService> provider14) {
        return new CaptureEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static CaptureEnvironment newInstance(ICapturePreferencesService iCapturePreferencesService, CaptureLocalItemsUseCase captureLocalItemsUseCase, CameraSession cameraSession, CaptureUploadFileManager captureUploadFileManager, BoxExtendedApiFolder boxExtendedApiFolder, IPermissionsHandler iPermissionsHandler, VideoRecordingFileManager videoRecordingFileManager, DocumentScanningEnvironment documentScanningEnvironment, CaptureSettingsEnvironment captureSettingsEnvironment, AudioCaptureEnvironment audioCaptureEnvironment, CaptureFolderUseCase captureFolderUseCase, IImageCaptureHelper iImageCaptureHelper, ICaptureShutterSoundHelper iCaptureShutterSoundHelper, IdMappingService idMappingService) {
        return new CaptureEnvironment(iCapturePreferencesService, captureLocalItemsUseCase, cameraSession, captureUploadFileManager, boxExtendedApiFolder, iPermissionsHandler, videoRecordingFileManager, documentScanningEnvironment, captureSettingsEnvironment, audioCaptureEnvironment, captureFolderUseCase, iImageCaptureHelper, iCaptureShutterSoundHelper, idMappingService);
    }
}
