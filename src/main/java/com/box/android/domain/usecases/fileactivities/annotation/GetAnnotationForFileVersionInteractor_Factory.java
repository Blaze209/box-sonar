package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetAnnotationForFileVersionInteractor_Factory implements Factory<GetAnnotationForFileVersionInteractor> {
    private final Provider<IAnnotationsService> annotationsServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private GetAnnotationForFileVersionInteractor_Factory(Provider<IAnnotationsService> provider, Provider<IdMappingService> provider2) {
        this.annotationsServiceProvider = provider;
        this.idMappingServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetAnnotationForFileVersionInteractor get() {
        return newInstance(this.annotationsServiceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static GetAnnotationForFileVersionInteractor_Factory create(Provider<IAnnotationsService> provider, Provider<IdMappingService> provider2) {
        return new GetAnnotationForFileVersionInteractor_Factory(provider, provider2);
    }

    public static GetAnnotationForFileVersionInteractor newInstance(IAnnotationsService iAnnotationsService, IdMappingService idMappingService) {
        return new GetAnnotationForFileVersionInteractor(iAnnotationsService, idMappingService);
    }
}
