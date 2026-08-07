package com.box.android.data.service.impl.thumbnail;

import com.box.android.domain.services.IRepresentationsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetThumbnailRepresentationsService_Factory implements Factory<GetThumbnailRepresentationsService> {
    private final Provider<IRepresentationsService> representationServiceProvider;

    private GetThumbnailRepresentationsService_Factory(Provider<IRepresentationsService> representationServiceProvider) {
        this.representationServiceProvider = representationServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetThumbnailRepresentationsService get() {
        return newInstance(this.representationServiceProvider.get());
    }

    public static GetThumbnailRepresentationsService_Factory create(Provider<IRepresentationsService> representationServiceProvider) {
        return new GetThumbnailRepresentationsService_Factory(representationServiceProvider);
    }

    public static GetThumbnailRepresentationsService newInstance(IRepresentationsService representationService) {
        return new GetThumbnailRepresentationsService(representationService);
    }
}
