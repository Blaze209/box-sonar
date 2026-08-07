package com.box.android.data.service.impl.thumbnail;

import com.box.android.domain.controller.IBrowseController;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class ThumbnailService_Factory implements Factory<ThumbnailService> {
    private final Provider<IBrowseController> controllerProvider;
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<FileToBitmapDecoder> fileToBitmapDecoderProvider;
    private final Provider<GetThumbnailRepresentationsService> getThumbnailRepresentationsServiceProvider;

    private ThumbnailService_Factory(Provider<IBrowseController> controllerProvider, Provider<GetThumbnailRepresentationsService> getThumbnailRepresentationsServiceProvider, Provider<FileToBitmapDecoder> fileToBitmapDecoderProvider, Provider<CoroutineDispatcher> coroutineDispatcherProvider) {
        this.controllerProvider = controllerProvider;
        this.getThumbnailRepresentationsServiceProvider = getThumbnailRepresentationsServiceProvider;
        this.fileToBitmapDecoderProvider = fileToBitmapDecoderProvider;
        this.coroutineDispatcherProvider = coroutineDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThumbnailService get() {
        return newInstance(this.controllerProvider.get(), this.getThumbnailRepresentationsServiceProvider.get(), this.fileToBitmapDecoderProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static ThumbnailService_Factory create(Provider<IBrowseController> controllerProvider, Provider<GetThumbnailRepresentationsService> getThumbnailRepresentationsServiceProvider, Provider<FileToBitmapDecoder> fileToBitmapDecoderProvider, Provider<CoroutineDispatcher> coroutineDispatcherProvider) {
        return new ThumbnailService_Factory(controllerProvider, getThumbnailRepresentationsServiceProvider, fileToBitmapDecoderProvider, coroutineDispatcherProvider);
    }

    public static ThumbnailService newInstance(IBrowseController controller, GetThumbnailRepresentationsService getThumbnailRepresentationsService, FileToBitmapDecoder fileToBitmapDecoder, CoroutineDispatcher coroutineDispatcher) {
        return new ThumbnailService(controller, getThumbnailRepresentationsService, fileToBitmapDecoder, coroutineDispatcher);
    }
}
