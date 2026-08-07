package com.box.android.base.presentation;

import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IThumbnailService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class ThumbnailManager_Factory implements Factory<ThumbnailManager> {
    private final Provider<IBrowseController> mControllerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;
    private final Provider<IThumbnailService> thumbnailServiceProvider;

    private ThumbnailManager_Factory(Provider<IBrowseController> provider, Provider<IUserContextManager> provider2, Provider<IThumbnailService> provider3) {
        this.mControllerProvider = provider;
        this.mUserContextManagerProvider = provider2;
        this.thumbnailServiceProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThumbnailManager get() {
        return newInstance(this.mControllerProvider.get(), this.mUserContextManagerProvider.get(), this.thumbnailServiceProvider.get());
    }

    public static ThumbnailManager_Factory create(Provider<IBrowseController> provider, Provider<IUserContextManager> provider2, Provider<IThumbnailService> provider3) {
        return new ThumbnailManager_Factory(provider, provider2, provider3);
    }

    public static ThumbnailManager newInstance(IBrowseController iBrowseController, IUserContextManager iUserContextManager, IThumbnailService iThumbnailService) {
        return new ThumbnailManager(iBrowseController, iUserContextManager, iThumbnailService);
    }
}
