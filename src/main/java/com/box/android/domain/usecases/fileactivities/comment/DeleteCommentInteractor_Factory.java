package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteCommentInteractor_Factory implements Factory<DeleteCommentInteractor> {
    private final Provider<ICommentService> commentServiceProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;

    private DeleteCommentInteractor_Factory(Provider<ICommentService> provider, Provider<IRemoteItemService> provider2) {
        this.commentServiceProvider = provider;
        this.itemServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteCommentInteractor get() {
        return newInstance(this.commentServiceProvider.get(), this.itemServiceProvider.get());
    }

    public static DeleteCommentInteractor_Factory create(Provider<ICommentService> provider, Provider<IRemoteItemService> provider2) {
        return new DeleteCommentInteractor_Factory(provider, provider2);
    }

    public static DeleteCommentInteractor newInstance(ICommentService iCommentService, IRemoteItemService iRemoteItemService) {
        return new DeleteCommentInteractor(iCommentService, iRemoteItemService);
    }
}
