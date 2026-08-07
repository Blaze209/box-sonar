package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.controller.ICommentsController;
import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateCommentInteractor_Factory implements Factory<CreateCommentInteractor> {
    private final Provider<ICommentsController> commentControllerProvider;
    private final Provider<ICommentService> commentServiceProvider;
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;

    private CreateCommentInteractor_Factory(Provider<ICommentService> provider, Provider<IdMappingService> provider2, Provider<ICommentsController> provider3, Provider<IRemoteItemService> provider4, Provider<CoroutineDispatcher> provider5) {
        this.commentServiceProvider = provider;
        this.idMappingServiceProvider = provider2;
        this.commentControllerProvider = provider3;
        this.itemServiceProvider = provider4;
        this.coroutineDispatcherProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateCommentInteractor get() {
        return newInstance(this.commentServiceProvider.get(), this.idMappingServiceProvider.get(), this.commentControllerProvider.get(), this.itemServiceProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static CreateCommentInteractor_Factory create(Provider<ICommentService> provider, Provider<IdMappingService> provider2, Provider<ICommentsController> provider3, Provider<IRemoteItemService> provider4, Provider<CoroutineDispatcher> provider5) {
        return new CreateCommentInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CreateCommentInteractor newInstance(ICommentService iCommentService, IdMappingService idMappingService, ICommentsController iCommentsController, IRemoteItemService iRemoteItemService, CoroutineDispatcher coroutineDispatcher) {
        return new CreateCommentInteractor(iCommentService, idMappingService, iCommentsController, iRemoteItemService, coroutineDispatcher);
    }
}
