package com.box.android.domain.usecases.thumbnail;

import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IThumbnailService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class ThumbnailPreviewInteractor_Factory implements Factory<ThumbnailPreviewInteractor> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<ILocalItemService> itemServiceProvider;
    private final Provider<IThumbnailService> thumbnailServiceProvider;

    private ThumbnailPreviewInteractor_Factory(Provider<IThumbnailService> provider, Provider<ILocalItemService> provider2, Provider<CoroutineDispatcher> provider3) {
        this.thumbnailServiceProvider = provider;
        this.itemServiceProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThumbnailPreviewInteractor get() {
        return newInstance(this.thumbnailServiceProvider.get(), this.itemServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static ThumbnailPreviewInteractor_Factory create(Provider<IThumbnailService> provider, Provider<ILocalItemService> provider2, Provider<CoroutineDispatcher> provider3) {
        return new ThumbnailPreviewInteractor_Factory(provider, provider2, provider3);
    }

    public static ThumbnailPreviewInteractor newInstance(IThumbnailService iThumbnailService, ILocalItemService iLocalItemService, CoroutineDispatcher coroutineDispatcher) {
        return new ThumbnailPreviewInteractor(iThumbnailService, iLocalItemService, coroutineDispatcher);
    }
}
