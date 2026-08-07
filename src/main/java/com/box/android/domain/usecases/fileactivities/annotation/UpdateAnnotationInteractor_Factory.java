package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UpdateAnnotationInteractor_Factory implements Factory<UpdateAnnotationInteractor> {
    private final Provider<IAnnotationsService> annotationsServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private UpdateAnnotationInteractor_Factory(Provider<IAnnotationsService> provider, Provider<IdMappingService> provider2) {
        this.annotationsServiceProvider = provider;
        this.idMappingServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateAnnotationInteractor get() {
        return newInstance(this.annotationsServiceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static UpdateAnnotationInteractor_Factory create(Provider<IAnnotationsService> provider, Provider<IdMappingService> provider2) {
        return new UpdateAnnotationInteractor_Factory(provider, provider2);
    }

    public static UpdateAnnotationInteractor newInstance(IAnnotationsService iAnnotationsService, IdMappingService idMappingService) {
        return new UpdateAnnotationInteractor(iAnnotationsService, idMappingService);
    }
}
