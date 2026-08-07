package com.box.android.preview.utils;

import com.box.android.domain.services.IPreviewService;
import com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewPrefetcher_Factory implements Factory<PreviewPrefetcher> {
    private final Provider<IPreviewService> previewServiceProvider;
    private final Provider<ThumbnailPreviewUseCase> thumbnailPreviewInteractorProvider;

    private PreviewPrefetcher_Factory(Provider<IPreviewService> provider, Provider<ThumbnailPreviewUseCase> provider2) {
        this.previewServiceProvider = provider;
        this.thumbnailPreviewInteractorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewPrefetcher get() {
        return newInstance(this.previewServiceProvider.get(), this.thumbnailPreviewInteractorProvider.get());
    }

    public static PreviewPrefetcher_Factory create(Provider<IPreviewService> provider, Provider<ThumbnailPreviewUseCase> provider2) {
        return new PreviewPrefetcher_Factory(provider, provider2);
    }

    public static PreviewPrefetcher newInstance(IPreviewService iPreviewService, ThumbnailPreviewUseCase thumbnailPreviewUseCase) {
        return new PreviewPrefetcher(iPreviewService, thumbnailPreviewUseCase);
    }
}
