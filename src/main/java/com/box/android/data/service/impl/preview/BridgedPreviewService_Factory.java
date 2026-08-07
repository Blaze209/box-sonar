package com.box.android.data.service.impl.preview;

import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.preview.helpers.FileCanBePreviewedChecker;
import com.box.android.data.service.impl.preview.helpers.PreviewFileWithRepresentationsWrapper;
import com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper;
import com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper;
import com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class BridgedPreviewService_Factory implements Factory<BridgedPreviewService> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<PreviewDownloadOriginalWrapper> downloadOriginalWrapperProvider;
    private final Provider<PreviewDownloadRepresentationWrapper> downloadRepresentationWrapperProvider;
    private final Provider<FileCanBePreviewedChecker> fileCanBePreviewedCheckerProvider;
    private final Provider<PreviewFileWithRepresentationsWrapper> fileWithRepresentationsServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LocalItemService> itemServiceProvider;
    private final Provider<PreviewFromLegacyCacheFetcher> previewFromLegacyCacheFetcherProvider;
    private final Provider<PreviewLocalDataSource> previewLocalDataSourceProvider;
    private final Provider<PreviewObservability> previewObservabilityProvider;
    private final Provider<PreviewerMappingsService> previewerMappingsServiceProvider;
    private final Provider<IRepresentationsService> representationsServiceProvider;

    private BridgedPreviewService_Factory(Provider<LocalItemService> itemServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<PreviewerMappingsService> previewerMappingsServiceProvider, Provider<PreviewObservability> previewObservabilityProvider, Provider<PreviewLocalDataSource> previewLocalDataSourceProvider, Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewFileWithRepresentationsWrapper> fileWithRepresentationsServiceProvider, Provider<FileCanBePreviewedChecker> fileCanBePreviewedCheckerProvider, Provider<PreviewDownloadRepresentationWrapper> downloadRepresentationWrapperProvider, Provider<PreviewDownloadOriginalWrapper> downloadOriginalWrapperProvider, Provider<PreviewFromLegacyCacheFetcher> previewFromLegacyCacheFetcherProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        this.itemServiceProvider = itemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.previewerMappingsServiceProvider = previewerMappingsServiceProvider;
        this.previewObservabilityProvider = previewObservabilityProvider;
        this.previewLocalDataSourceProvider = previewLocalDataSourceProvider;
        this.representationsServiceProvider = representationsServiceProvider;
        this.fileWithRepresentationsServiceProvider = fileWithRepresentationsServiceProvider;
        this.fileCanBePreviewedCheckerProvider = fileCanBePreviewedCheckerProvider;
        this.downloadRepresentationWrapperProvider = downloadRepresentationWrapperProvider;
        this.downloadOriginalWrapperProvider = downloadOriginalWrapperProvider;
        this.previewFromLegacyCacheFetcherProvider = previewFromLegacyCacheFetcherProvider;
        this.dispatcherProvider = dispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BridgedPreviewService get() {
        return newInstance(this.itemServiceProvider.get(), this.idMappingServiceProvider.get(), this.previewerMappingsServiceProvider.get(), this.previewObservabilityProvider.get(), this.previewLocalDataSourceProvider.get(), this.representationsServiceProvider.get(), this.fileWithRepresentationsServiceProvider.get(), this.fileCanBePreviewedCheckerProvider.get(), this.downloadRepresentationWrapperProvider.get(), this.downloadOriginalWrapperProvider.get(), this.previewFromLegacyCacheFetcherProvider.get(), this.dispatcherProvider.get());
    }

    public static BridgedPreviewService_Factory create(Provider<LocalItemService> itemServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<PreviewerMappingsService> previewerMappingsServiceProvider, Provider<PreviewObservability> previewObservabilityProvider, Provider<PreviewLocalDataSource> previewLocalDataSourceProvider, Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewFileWithRepresentationsWrapper> fileWithRepresentationsServiceProvider, Provider<FileCanBePreviewedChecker> fileCanBePreviewedCheckerProvider, Provider<PreviewDownloadRepresentationWrapper> downloadRepresentationWrapperProvider, Provider<PreviewDownloadOriginalWrapper> downloadOriginalWrapperProvider, Provider<PreviewFromLegacyCacheFetcher> previewFromLegacyCacheFetcherProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        return new BridgedPreviewService_Factory(itemServiceProvider, idMappingServiceProvider, previewerMappingsServiceProvider, previewObservabilityProvider, previewLocalDataSourceProvider, representationsServiceProvider, fileWithRepresentationsServiceProvider, fileCanBePreviewedCheckerProvider, downloadRepresentationWrapperProvider, downloadOriginalWrapperProvider, previewFromLegacyCacheFetcherProvider, dispatcherProvider);
    }

    public static BridgedPreviewService newInstance(LocalItemService itemService, IdMappingService idMappingService, PreviewerMappingsService previewerMappingsService, PreviewObservability previewObservability, PreviewLocalDataSource previewLocalDataSource, IRepresentationsService representationsService, PreviewFileWithRepresentationsWrapper fileWithRepresentationsService, FileCanBePreviewedChecker fileCanBePreviewedChecker, PreviewDownloadRepresentationWrapper downloadRepresentationWrapper, PreviewDownloadOriginalWrapper downloadOriginalWrapper, PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher, CoroutineDispatcher dispatcher) {
        return new BridgedPreviewService(itemService, idMappingService, previewerMappingsService, previewObservability, previewLocalDataSource, representationsService, fileWithRepresentationsService, fileCanBePreviewedChecker, downloadRepresentationWrapper, downloadOriginalWrapper, previewFromLegacyCacheFetcher, dispatcher);
    }
}
