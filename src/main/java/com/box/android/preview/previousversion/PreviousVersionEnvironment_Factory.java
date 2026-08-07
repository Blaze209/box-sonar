package com.box.android.preview.previousversion;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability;
import com.box.android.domain.services.IFileVersionService;
import com.box.android.domain.services.IPreviousVersionPreviewService;
import com.box.android.preview.preview.PreviewAnalytics;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.image.ImagePreviewEnvironment;
import com.box.android.preview.previewtype.video.VideoPreviewEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviousVersionEnvironment_Factory implements Factory<PreviousVersionEnvironment> {
    private final Provider<PreviewAnalytics> analyticsProvider;
    private final Provider<DocumentPreviewEnvironment> documentPreviewEnvironmentProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<IFileVersionService> fileVersionServiceProvider;
    private final Provider<ImagePreviewEnvironment> imagePreviewEnvironmentProvider;
    private final Provider<PreviousVersionPreviewObservability> observabilityProvider;
    private final Provider<IPreviousVersionPreviewService> previousVersionPreviewServiceProvider;
    private final Provider<VideoPreviewEnvironment> videoPreviewEnvironmentProvider;

    private PreviousVersionEnvironment_Factory(Provider<IPreviousVersionPreviewService> provider, Provider<IFileVersionService> provider2, Provider<FileActionsManager> provider3, Provider<DocumentPreviewEnvironment> provider4, Provider<ImagePreviewEnvironment> provider5, Provider<VideoPreviewEnvironment> provider6, Provider<PreviewAnalytics> provider7, Provider<PreviousVersionPreviewObservability> provider8) {
        this.previousVersionPreviewServiceProvider = provider;
        this.fileVersionServiceProvider = provider2;
        this.fileActionsManagerProvider = provider3;
        this.documentPreviewEnvironmentProvider = provider4;
        this.imagePreviewEnvironmentProvider = provider5;
        this.videoPreviewEnvironmentProvider = provider6;
        this.analyticsProvider = provider7;
        this.observabilityProvider = provider8;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviousVersionEnvironment get() {
        return newInstance(this.previousVersionPreviewServiceProvider.get(), this.fileVersionServiceProvider.get(), this.fileActionsManagerProvider.get(), this.documentPreviewEnvironmentProvider.get(), this.imagePreviewEnvironmentProvider.get(), this.videoPreviewEnvironmentProvider.get(), this.analyticsProvider.get(), this.observabilityProvider.get());
    }

    public static PreviousVersionEnvironment_Factory create(Provider<IPreviousVersionPreviewService> provider, Provider<IFileVersionService> provider2, Provider<FileActionsManager> provider3, Provider<DocumentPreviewEnvironment> provider4, Provider<ImagePreviewEnvironment> provider5, Provider<VideoPreviewEnvironment> provider6, Provider<PreviewAnalytics> provider7, Provider<PreviousVersionPreviewObservability> provider8) {
        return new PreviousVersionEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static PreviousVersionEnvironment newInstance(IPreviousVersionPreviewService iPreviousVersionPreviewService, IFileVersionService iFileVersionService, FileActionsManager fileActionsManager, DocumentPreviewEnvironment documentPreviewEnvironment, ImagePreviewEnvironment imagePreviewEnvironment, VideoPreviewEnvironment videoPreviewEnvironment, PreviewAnalytics previewAnalytics, PreviousVersionPreviewObservability previousVersionPreviewObservability) {
        return new PreviousVersionEnvironment(iPreviousVersionPreviewService, iFileVersionService, fileActionsManager, documentPreviewEnvironment, imagePreviewEnvironment, videoPreviewEnvironment, previewAnalytics, previousVersionPreviewObservability);
    }
}
