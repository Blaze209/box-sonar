package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateAnnotationInteractor_Factory implements Factory<CreateAnnotationInteractor> {
    private final Provider<IAnnotationsService> annotationServiceProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;

    private CreateAnnotationInteractor_Factory(Provider<IAnnotationsService> provider, Provider<IRemoteItemService> provider2) {
        this.annotationServiceProvider = provider;
        this.itemServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateAnnotationInteractor get() {
        return newInstance(this.annotationServiceProvider.get(), this.itemServiceProvider.get());
    }

    public static CreateAnnotationInteractor_Factory create(Provider<IAnnotationsService> provider, Provider<IRemoteItemService> provider2) {
        return new CreateAnnotationInteractor_Factory(provider, provider2);
    }

    public static CreateAnnotationInteractor newInstance(IAnnotationsService iAnnotationsService, IRemoteItemService iRemoteItemService) {
        return new CreateAnnotationInteractor(iAnnotationsService, iRemoteItemService);
    }
}
