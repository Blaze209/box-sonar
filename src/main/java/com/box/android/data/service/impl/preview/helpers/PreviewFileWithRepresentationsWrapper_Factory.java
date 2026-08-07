package com.box.android.data.service.impl.preview.helpers;

import com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability;
import com.box.android.domain.services.IFileWithRepresentationsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewFileWithRepresentationsWrapper_Factory implements Factory<PreviewFileWithRepresentationsWrapper> {
    private final Provider<FileWithRepresentationsFetchObservability> observabilityProvider;
    private final Provider<IFileWithRepresentationsService> serviceProvider;

    private PreviewFileWithRepresentationsWrapper_Factory(Provider<FileWithRepresentationsFetchObservability> observabilityProvider, Provider<IFileWithRepresentationsService> serviceProvider) {
        this.observabilityProvider = observabilityProvider;
        this.serviceProvider = serviceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewFileWithRepresentationsWrapper get() {
        return newInstance(this.observabilityProvider.get(), this.serviceProvider.get());
    }

    public static PreviewFileWithRepresentationsWrapper_Factory create(Provider<FileWithRepresentationsFetchObservability> observabilityProvider, Provider<IFileWithRepresentationsService> serviceProvider) {
        return new PreviewFileWithRepresentationsWrapper_Factory(observabilityProvider, serviceProvider);
    }

    public static PreviewFileWithRepresentationsWrapper newInstance(FileWithRepresentationsFetchObservability observability, IFileWithRepresentationsService service) {
        return new PreviewFileWithRepresentationsWrapper(observability, service);
    }
}
