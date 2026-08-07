package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteAnnotationInteractor_Factory implements Factory<DeleteAnnotationInteractor> {
    private final Provider<IAnnotationsService> annotationsServiceProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;

    private DeleteAnnotationInteractor_Factory(Provider<IAnnotationsService> provider, Provider<IRemoteItemService> provider2) {
        this.annotationsServiceProvider = provider;
        this.itemServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteAnnotationInteractor get() {
        return newInstance(this.annotationsServiceProvider.get(), this.itemServiceProvider.get());
    }

    public static DeleteAnnotationInteractor_Factory create(Provider<IAnnotationsService> provider, Provider<IRemoteItemService> provider2) {
        return new DeleteAnnotationInteractor_Factory(provider, provider2);
    }

    public static DeleteAnnotationInteractor newInstance(IAnnotationsService iAnnotationsService, IRemoteItemService iRemoteItemService) {
        return new DeleteAnnotationInteractor(iAnnotationsService, iRemoteItemService);
    }
}
