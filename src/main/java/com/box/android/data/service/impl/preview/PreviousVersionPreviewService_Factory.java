package com.box.android.data.service.impl.preview;

import com.box.android.domain.preview.PreviewerTypeResolver;
import com.box.android.domain.services.IRepresentationsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviousVersionPreviewService_Factory implements Factory<PreviousVersionPreviewService> {
    private final Provider<PreviewerTypeResolver> previewerTypeResolverProvider;
    private final Provider<IRepresentationsService> representationsServiceProvider;

    private PreviousVersionPreviewService_Factory(Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewerTypeResolver> previewerTypeResolverProvider) {
        this.representationsServiceProvider = representationsServiceProvider;
        this.previewerTypeResolverProvider = previewerTypeResolverProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviousVersionPreviewService get() {
        return newInstance(this.representationsServiceProvider.get(), this.previewerTypeResolverProvider.get());
    }

    public static PreviousVersionPreviewService_Factory create(Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewerTypeResolver> previewerTypeResolverProvider) {
        return new PreviousVersionPreviewService_Factory(representationsServiceProvider, previewerTypeResolverProvider);
    }

    public static PreviousVersionPreviewService newInstance(IRepresentationsService representationsService, PreviewerTypeResolver previewerTypeResolver) {
        return new PreviousVersionPreviewService(representationsService, previewerTypeResolver);
    }
}
