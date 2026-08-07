package com.box.android.data.service.impl.preview;

import com.box.android.data.service.impl.OfflineService;
import com.box.android.data.service.impl.RecentsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.utils.ItemSorter;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GalleryItemsService_Factory implements Factory<GalleryItemsService> {
    private final Provider<CaptureHistoryUseCase> captureHistoryUseCaseProvider;
    private final Provider<ItemSorter> itemSorterProvider;
    private final Provider<IRemoteItemService> itemsServiceProvider;
    private final Provider<OfflineService> offlineServiceProvider;
    private final Provider<RecentsService> recentsServiceProvider;

    private GalleryItemsService_Factory(Provider<IRemoteItemService> itemsServiceProvider, Provider<RecentsService> recentsServiceProvider, Provider<OfflineService> offlineServiceProvider, Provider<CaptureHistoryUseCase> captureHistoryUseCaseProvider, Provider<ItemSorter> itemSorterProvider) {
        this.itemsServiceProvider = itemsServiceProvider;
        this.recentsServiceProvider = recentsServiceProvider;
        this.offlineServiceProvider = offlineServiceProvider;
        this.captureHistoryUseCaseProvider = captureHistoryUseCaseProvider;
        this.itemSorterProvider = itemSorterProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GalleryItemsService get() {
        return newInstance(this.itemsServiceProvider.get(), this.recentsServiceProvider.get(), this.offlineServiceProvider.get(), this.captureHistoryUseCaseProvider.get(), this.itemSorterProvider.get());
    }

    public static GalleryItemsService_Factory create(Provider<IRemoteItemService> itemsServiceProvider, Provider<RecentsService> recentsServiceProvider, Provider<OfflineService> offlineServiceProvider, Provider<CaptureHistoryUseCase> captureHistoryUseCaseProvider, Provider<ItemSorter> itemSorterProvider) {
        return new GalleryItemsService_Factory(itemsServiceProvider, recentsServiceProvider, offlineServiceProvider, captureHistoryUseCaseProvider, itemSorterProvider);
    }

    public static GalleryItemsService newInstance(IRemoteItemService itemsService, RecentsService recentsService, OfflineService offlineService, CaptureHistoryUseCase captureHistoryUseCase, ItemSorter itemSorter) {
        return new GalleryItemsService(itemsService, recentsService, offlineService, captureHistoryUseCase, itemSorter);
    }
}
