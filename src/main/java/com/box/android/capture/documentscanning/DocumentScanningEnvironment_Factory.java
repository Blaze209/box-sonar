package com.box.android.capture.documentscanning;

import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.documentscanning.logic.GeniusScanLicenseInitializer;
import com.box.android.capture.documentscanning.logic.IDocumentScanningHelper;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.IDocumentScanPageProcessor;
import com.box.android.domain.usecases.documentscanning.DocumentScanUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class DocumentScanningEnvironment_Factory implements Factory<DocumentScanningEnvironment> {
    private final Provider<ICapturePreferencesService> capturePreferencesServiceProvider;
    private final Provider<ICaptureThumbnailService> captureThumbnailServiceProvider;
    private final Provider<CaptureUploadFileManager> captureUploadFileManagerProvider;
    private final Provider<DocumentScanUseCase> documentScanUseCaseProvider;
    private final Provider<GeniusScanLicenseInitializer> geniusScanLicenseInitializerProvider;
    private final Provider<IPermissionsHandler> permissionsHandlerProvider;
    private final Provider<IDocumentScanPageProcessor> scanProcessorProvider;
    private final Provider<IDocumentScanningHelper> scanningHelperProvider;

    private DocumentScanningEnvironment_Factory(Provider<ICapturePreferencesService> provider, Provider<DocumentScanUseCase> provider2, Provider<GeniusScanLicenseInitializer> provider3, Provider<IPermissionsHandler> provider4, Provider<IDocumentScanPageProcessor> provider5, Provider<IDocumentScanningHelper> provider6, Provider<CaptureUploadFileManager> provider7, Provider<ICaptureThumbnailService> provider8) {
        this.capturePreferencesServiceProvider = provider;
        this.documentScanUseCaseProvider = provider2;
        this.geniusScanLicenseInitializerProvider = provider3;
        this.permissionsHandlerProvider = provider4;
        this.scanProcessorProvider = provider5;
        this.scanningHelperProvider = provider6;
        this.captureUploadFileManagerProvider = provider7;
        this.captureThumbnailServiceProvider = provider8;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentScanningEnvironment get() {
        return newInstance(this.capturePreferencesServiceProvider.get(), this.documentScanUseCaseProvider.get(), this.geniusScanLicenseInitializerProvider.get(), this.permissionsHandlerProvider.get(), this.scanProcessorProvider.get(), this.scanningHelperProvider.get(), this.captureUploadFileManagerProvider.get(), this.captureThumbnailServiceProvider.get());
    }

    public static DocumentScanningEnvironment_Factory create(Provider<ICapturePreferencesService> provider, Provider<DocumentScanUseCase> provider2, Provider<GeniusScanLicenseInitializer> provider3, Provider<IPermissionsHandler> provider4, Provider<IDocumentScanPageProcessor> provider5, Provider<IDocumentScanningHelper> provider6, Provider<CaptureUploadFileManager> provider7, Provider<ICaptureThumbnailService> provider8) {
        return new DocumentScanningEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DocumentScanningEnvironment newInstance(ICapturePreferencesService iCapturePreferencesService, DocumentScanUseCase documentScanUseCase, GeniusScanLicenseInitializer geniusScanLicenseInitializer, IPermissionsHandler iPermissionsHandler, IDocumentScanPageProcessor iDocumentScanPageProcessor, IDocumentScanningHelper iDocumentScanningHelper, CaptureUploadFileManager captureUploadFileManager, ICaptureThumbnailService iCaptureThumbnailService) {
        return new DocumentScanningEnvironment(iCapturePreferencesService, documentScanUseCase, geniusScanLicenseInitializer, iPermissionsHandler, iDocumentScanPageProcessor, iDocumentScanningHelper, captureUploadFileManager, iCaptureThumbnailService);
    }
}
