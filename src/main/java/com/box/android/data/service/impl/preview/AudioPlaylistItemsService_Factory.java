package com.box.android.data.service.impl.preview;

import com.box.android.data.datasource.representations.Mp3RepresentationUriProvider;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.IRecentsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.utils.ItemSorter;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AudioPlaylistItemsService_Factory implements Factory<AudioPlaylistItemsService> {
    private final Provider<CaptureHistoryUseCase> captureHistoryUseCaseProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LocalItemService> itemServiceProvider;
    private final Provider<ItemSorter> itemSorterProvider;
    private final Provider<Mp3RepresentationUriProvider> mp3RepresentationUriProvider;
    private final Provider<IOfflineService> offlineServiceProvider;
    private final Provider<PreviewFromLegacyCacheFetcher> previewFromLegacyCacheFetcherProvider;
    private final Provider<PreviewLocalDataSource> previewLocalDataSourceProvider;
    private final Provider<IRecentsService> recentsServiceProvider;

    private AudioPlaylistItemsService_Factory(Provider<LocalItemService> itemServiceProvider, Provider<PreviewLocalDataSource> previewLocalDataSourceProvider, Provider<PreviewFromLegacyCacheFetcher> previewFromLegacyCacheFetcherProvider, Provider<ItemSorter> itemSorterProvider, Provider<Mp3RepresentationUriProvider> mp3RepresentationUriProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IRecentsService> recentsServiceProvider, Provider<IOfflineService> offlineServiceProvider, Provider<CaptureHistoryUseCase> captureHistoryUseCaseProvider) {
        this.itemServiceProvider = itemServiceProvider;
        this.previewLocalDataSourceProvider = previewLocalDataSourceProvider;
        this.previewFromLegacyCacheFetcherProvider = previewFromLegacyCacheFetcherProvider;
        this.itemSorterProvider = itemSorterProvider;
        this.mp3RepresentationUriProvider = mp3RepresentationUriProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.recentsServiceProvider = recentsServiceProvider;
        this.offlineServiceProvider = offlineServiceProvider;
        this.captureHistoryUseCaseProvider = captureHistoryUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AudioPlaylistItemsService get() {
        return newInstance(this.itemServiceProvider.get(), this.previewLocalDataSourceProvider.get(), this.previewFromLegacyCacheFetcherProvider.get(), this.itemSorterProvider.get(), this.mp3RepresentationUriProvider.get(), this.idMappingServiceProvider.get(), this.recentsServiceProvider.get(), this.offlineServiceProvider.get(), this.captureHistoryUseCaseProvider.get());
    }

    public static AudioPlaylistItemsService_Factory create(Provider<LocalItemService> itemServiceProvider, Provider<PreviewLocalDataSource> previewLocalDataSourceProvider, Provider<PreviewFromLegacyCacheFetcher> previewFromLegacyCacheFetcherProvider, Provider<ItemSorter> itemSorterProvider, Provider<Mp3RepresentationUriProvider> mp3RepresentationUriProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IRecentsService> recentsServiceProvider, Provider<IOfflineService> offlineServiceProvider, Provider<CaptureHistoryUseCase> captureHistoryUseCaseProvider) {
        return new AudioPlaylistItemsService_Factory(itemServiceProvider, previewLocalDataSourceProvider, previewFromLegacyCacheFetcherProvider, itemSorterProvider, mp3RepresentationUriProvider, idMappingServiceProvider, recentsServiceProvider, offlineServiceProvider, captureHistoryUseCaseProvider);
    }

    public static AudioPlaylistItemsService newInstance(LocalItemService itemService, PreviewLocalDataSource previewLocalDataSource, PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher, ItemSorter itemSorter, Mp3RepresentationUriProvider mp3RepresentationUriProvider, IdMappingService idMappingService, IRecentsService recentsService, IOfflineService offlineService, CaptureHistoryUseCase captureHistoryUseCase) {
        return new AudioPlaylistItemsService(itemService, previewLocalDataSource, previewFromLegacyCacheFetcher, itemSorter, mp3RepresentationUriProvider, idMappingService, recentsService, offlineService, captureHistoryUseCase);
    }
}
