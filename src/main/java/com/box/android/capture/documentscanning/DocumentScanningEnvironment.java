package com.box.android.capture.documentscanning;

import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.documentscanning.logic.GeniusScanLicenseInitializer;
import com.box.android.capture.documentscanning.logic.IDocumentScanningHelper;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.IDocumentScanPageProcessor;
import com.box.android.domain.usecases.documentscanning.DocumentScanUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "", "capturePreferencesService", "Lcom/box/android/domain/services/ICapturePreferencesService;", "documentScanUseCase", "Lcom/box/android/domain/usecases/documentscanning/DocumentScanUseCase;", "geniusScanLicenseInitializer", "Lcom/box/android/capture/documentscanning/logic/GeniusScanLicenseInitializer;", "permissionsHandler", "Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "scanProcessor", "Lcom/box/android/domain/services/IDocumentScanPageProcessor;", "scanningHelper", "Lcom/box/android/capture/documentscanning/logic/IDocumentScanningHelper;", "captureUploadFileManager", "Lcom/box/android/capture/CaptureUploadFileManager;", "captureThumbnailService", "Lcom/box/android/domain/services/ICaptureThumbnailService;", "<init>", "(Lcom/box/android/domain/services/ICapturePreferencesService;Lcom/box/android/domain/usecases/documentscanning/DocumentScanUseCase;Lcom/box/android/capture/documentscanning/logic/GeniusScanLicenseInitializer;Lcom/box/android/base/presentation/utilities/IPermissionsHandler;Lcom/box/android/domain/services/IDocumentScanPageProcessor;Lcom/box/android/capture/documentscanning/logic/IDocumentScanningHelper;Lcom/box/android/capture/CaptureUploadFileManager;Lcom/box/android/domain/services/ICaptureThumbnailService;)V", "getCapturePreferencesService", "()Lcom/box/android/domain/services/ICapturePreferencesService;", "getDocumentScanUseCase", "()Lcom/box/android/domain/usecases/documentscanning/DocumentScanUseCase;", "getGeniusScanLicenseInitializer", "()Lcom/box/android/capture/documentscanning/logic/GeniusScanLicenseInitializer;", "getPermissionsHandler", "()Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "getScanProcessor", "()Lcom/box/android/domain/services/IDocumentScanPageProcessor;", "getScanningHelper", "()Lcom/box/android/capture/documentscanning/logic/IDocumentScanningHelper;", "getCaptureUploadFileManager", "()Lcom/box/android/capture/CaptureUploadFileManager;", "getCaptureThumbnailService", "()Lcom/box/android/domain/services/ICaptureThumbnailService;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DocumentScanningEnvironment {
    public static final int $stable = 8;
    private final ICapturePreferencesService capturePreferencesService;
    private final ICaptureThumbnailService captureThumbnailService;
    private final CaptureUploadFileManager captureUploadFileManager;
    private final DocumentScanUseCase documentScanUseCase;
    private final GeniusScanLicenseInitializer geniusScanLicenseInitializer;
    private final IPermissionsHandler permissionsHandler;
    private final IDocumentScanPageProcessor scanProcessor;
    private final IDocumentScanningHelper scanningHelper;

    public static /* synthetic */ DocumentScanningEnvironment copy$default(DocumentScanningEnvironment documentScanningEnvironment, ICapturePreferencesService iCapturePreferencesService, DocumentScanUseCase documentScanUseCase, GeniusScanLicenseInitializer geniusScanLicenseInitializer, IPermissionsHandler iPermissionsHandler, IDocumentScanPageProcessor iDocumentScanPageProcessor, IDocumentScanningHelper iDocumentScanningHelper, CaptureUploadFileManager captureUploadFileManager, ICaptureThumbnailService iCaptureThumbnailService, int i, Object obj) {
        if ((i & 1) != 0) {
            iCapturePreferencesService = documentScanningEnvironment.capturePreferencesService;
        }
        if ((i & 2) != 0) {
            documentScanUseCase = documentScanningEnvironment.documentScanUseCase;
        }
        if ((i & 4) != 0) {
            geniusScanLicenseInitializer = documentScanningEnvironment.geniusScanLicenseInitializer;
        }
        if ((i & 8) != 0) {
            iPermissionsHandler = documentScanningEnvironment.permissionsHandler;
        }
        if ((i & 16) != 0) {
            iDocumentScanPageProcessor = documentScanningEnvironment.scanProcessor;
        }
        if ((i & 32) != 0) {
            iDocumentScanningHelper = documentScanningEnvironment.scanningHelper;
        }
        if ((i & 64) != 0) {
            captureUploadFileManager = documentScanningEnvironment.captureUploadFileManager;
        }
        if ((i & 128) != 0) {
            iCaptureThumbnailService = documentScanningEnvironment.captureThumbnailService;
        }
        CaptureUploadFileManager captureUploadFileManager2 = captureUploadFileManager;
        ICaptureThumbnailService iCaptureThumbnailService2 = iCaptureThumbnailService;
        IDocumentScanPageProcessor iDocumentScanPageProcessor2 = iDocumentScanPageProcessor;
        IDocumentScanningHelper iDocumentScanningHelper2 = iDocumentScanningHelper;
        return documentScanningEnvironment.copy(iCapturePreferencesService, documentScanUseCase, geniusScanLicenseInitializer, iPermissionsHandler, iDocumentScanPageProcessor2, iDocumentScanningHelper2, captureUploadFileManager2, iCaptureThumbnailService2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentScanUseCase getDocumentScanUseCase() {
        return this.documentScanUseCase;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GeniusScanLicenseInitializer getGeniusScanLicenseInitializer() {
        return this.geniusScanLicenseInitializer;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final IPermissionsHandler getPermissionsHandler() {
        return this.permissionsHandler;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final IDocumentScanPageProcessor getScanProcessor() {
        return this.scanProcessor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final IDocumentScanningHelper getScanningHelper() {
        return this.scanningHelper;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CaptureUploadFileManager getCaptureUploadFileManager() {
        return this.captureUploadFileManager;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ICaptureThumbnailService getCaptureThumbnailService() {
        return this.captureThumbnailService;
    }

    public final DocumentScanningEnvironment copy(ICapturePreferencesService capturePreferencesService, DocumentScanUseCase documentScanUseCase, GeniusScanLicenseInitializer geniusScanLicenseInitializer, IPermissionsHandler permissionsHandler, IDocumentScanPageProcessor scanProcessor, IDocumentScanningHelper scanningHelper, CaptureUploadFileManager captureUploadFileManager, ICaptureThumbnailService captureThumbnailService) {
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        Intrinsics.checkNotNullParameter(documentScanUseCase, "documentScanUseCase");
        Intrinsics.checkNotNullParameter(geniusScanLicenseInitializer, "geniusScanLicenseInitializer");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        Intrinsics.checkNotNullParameter(scanProcessor, "scanProcessor");
        Intrinsics.checkNotNullParameter(scanningHelper, "scanningHelper");
        Intrinsics.checkNotNullParameter(captureUploadFileManager, "captureUploadFileManager");
        Intrinsics.checkNotNullParameter(captureThumbnailService, "captureThumbnailService");
        return new DocumentScanningEnvironment(capturePreferencesService, documentScanUseCase, geniusScanLicenseInitializer, permissionsHandler, scanProcessor, scanningHelper, captureUploadFileManager, captureThumbnailService);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentScanningEnvironment)) {
            return false;
        }
        DocumentScanningEnvironment documentScanningEnvironment = (DocumentScanningEnvironment) other;
        return Intrinsics.areEqual(this.capturePreferencesService, documentScanningEnvironment.capturePreferencesService) && Intrinsics.areEqual(this.documentScanUseCase, documentScanningEnvironment.documentScanUseCase) && Intrinsics.areEqual(this.geniusScanLicenseInitializer, documentScanningEnvironment.geniusScanLicenseInitializer) && Intrinsics.areEqual(this.permissionsHandler, documentScanningEnvironment.permissionsHandler) && Intrinsics.areEqual(this.scanProcessor, documentScanningEnvironment.scanProcessor) && Intrinsics.areEqual(this.scanningHelper, documentScanningEnvironment.scanningHelper) && Intrinsics.areEqual(this.captureUploadFileManager, documentScanningEnvironment.captureUploadFileManager) && Intrinsics.areEqual(this.captureThumbnailService, documentScanningEnvironment.captureThumbnailService);
    }

    public int hashCode() {
        return (((((((((((((this.capturePreferencesService.hashCode() * 31) + this.documentScanUseCase.hashCode()) * 31) + this.geniusScanLicenseInitializer.hashCode()) * 31) + this.permissionsHandler.hashCode()) * 31) + this.scanProcessor.hashCode()) * 31) + this.scanningHelper.hashCode()) * 31) + this.captureUploadFileManager.hashCode()) * 31) + this.captureThumbnailService.hashCode();
    }

    public String toString() {
        return "DocumentScanningEnvironment(capturePreferencesService=" + this.capturePreferencesService + ", documentScanUseCase=" + this.documentScanUseCase + ", geniusScanLicenseInitializer=" + this.geniusScanLicenseInitializer + ", permissionsHandler=" + this.permissionsHandler + ", scanProcessor=" + this.scanProcessor + ", scanningHelper=" + this.scanningHelper + ", captureUploadFileManager=" + this.captureUploadFileManager + ", captureThumbnailService=" + this.captureThumbnailService + ")";
    }

    @Inject
    public DocumentScanningEnvironment(ICapturePreferencesService capturePreferencesService, DocumentScanUseCase documentScanUseCase, GeniusScanLicenseInitializer geniusScanLicenseInitializer, IPermissionsHandler permissionsHandler, IDocumentScanPageProcessor scanProcessor, IDocumentScanningHelper scanningHelper, CaptureUploadFileManager captureUploadFileManager, ICaptureThumbnailService captureThumbnailService) {
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        Intrinsics.checkNotNullParameter(documentScanUseCase, "documentScanUseCase");
        Intrinsics.checkNotNullParameter(geniusScanLicenseInitializer, "geniusScanLicenseInitializer");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        Intrinsics.checkNotNullParameter(scanProcessor, "scanProcessor");
        Intrinsics.checkNotNullParameter(scanningHelper, "scanningHelper");
        Intrinsics.checkNotNullParameter(captureUploadFileManager, "captureUploadFileManager");
        Intrinsics.checkNotNullParameter(captureThumbnailService, "captureThumbnailService");
        this.capturePreferencesService = capturePreferencesService;
        this.documentScanUseCase = documentScanUseCase;
        this.geniusScanLicenseInitializer = geniusScanLicenseInitializer;
        this.permissionsHandler = permissionsHandler;
        this.scanProcessor = scanProcessor;
        this.scanningHelper = scanningHelper;
        this.captureUploadFileManager = captureUploadFileManager;
        this.captureThumbnailService = captureThumbnailService;
    }

    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }

    public final DocumentScanUseCase getDocumentScanUseCase() {
        return this.documentScanUseCase;
    }

    public final GeniusScanLicenseInitializer getGeniusScanLicenseInitializer() {
        return this.geniusScanLicenseInitializer;
    }

    public final IPermissionsHandler getPermissionsHandler() {
        return this.permissionsHandler;
    }

    public final IDocumentScanPageProcessor getScanProcessor() {
        return this.scanProcessor;
    }

    public final IDocumentScanningHelper getScanningHelper() {
        return this.scanningHelper;
    }

    public final CaptureUploadFileManager getCaptureUploadFileManager() {
        return this.captureUploadFileManager;
    }

    public final ICaptureThumbnailService getCaptureThumbnailService() {
        return this.captureThumbnailService;
    }
}
