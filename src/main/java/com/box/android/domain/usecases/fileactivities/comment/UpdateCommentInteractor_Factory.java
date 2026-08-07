package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UpdateCommentInteractor_Factory implements Factory<UpdateCommentInteractor> {
    private final Provider<ICommentService> commentServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private UpdateCommentInteractor_Factory(Provider<ICommentService> provider, Provider<IdMappingService> provider2) {
        this.commentServiceProvider = provider;
        this.idMappingServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateCommentInteractor get() {
        return newInstance(this.commentServiceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static UpdateCommentInteractor_Factory create(Provider<ICommentService> provider, Provider<IdMappingService> provider2) {
        return new UpdateCommentInteractor_Factory(provider, provider2);
    }

    public static UpdateCommentInteractor newInstance(ICommentService iCommentService, IdMappingService idMappingService) {
        return new UpdateCommentInteractor(iCommentService, idMappingService);
    }
}
