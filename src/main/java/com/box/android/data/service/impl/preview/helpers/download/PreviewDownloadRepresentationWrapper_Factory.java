package com.box.android.data.service.impl.preview.helpers.download;

import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.services.IRepresentationsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewDownloadRepresentationWrapper_Factory implements Factory<PreviewDownloadRepresentationWrapper> {
    private final Provider<IPreviewController> legacyPreviewControllerProvider;
    private final Provider<PreviewObservability> observabilityProvider;
    private final Provider<IRepresentationsService> representationsServiceProvider;

    private PreviewDownloadRepresentationWrapper_Factory(Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewObservability> observabilityProvider, Provider<IPreviewController> legacyPreviewControllerProvider) {
        this.representationsServiceProvider = representationsServiceProvider;
        this.observabilityProvider = observabilityProvider;
        this.legacyPreviewControllerProvider = legacyPreviewControllerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewDownloadRepresentationWrapper get() {
        return newInstance(this.representationsServiceProvider.get(), this.observabilityProvider.get(), this.legacyPreviewControllerProvider.get());
    }

    public static PreviewDownloadRepresentationWrapper_Factory create(Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewObservability> observabilityProvider, Provider<IPreviewController> legacyPreviewControllerProvider) {
        return new PreviewDownloadRepresentationWrapper_Factory(representationsServiceProvider, observabilityProvider, legacyPreviewControllerProvider);
    }

    public static PreviewDownloadRepresentationWrapper newInstance(IRepresentationsService representationsService, PreviewObservability observability, IPreviewController legacyPreviewController) {
        return new PreviewDownloadRepresentationWrapper(representationsService, observability, legacyPreviewController);
    }
}
