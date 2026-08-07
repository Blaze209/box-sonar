package com.box.android.data.service.impl.preview.helpers.download;

import com.box.android.data.datasource.PreviewDownloadRemoteDataSource;
import com.box.android.domain.metrics.preview.PreviewObservability;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewDownloadOriginalWrapper_Factory implements Factory<PreviewDownloadOriginalWrapper> {
    private final Provider<PreviewObservability> observabilityProvider;
    private final Provider<PreviewDownloadRemoteDataSource> previewDownloadDataSourceProvider;

    private PreviewDownloadOriginalWrapper_Factory(Provider<PreviewObservability> observabilityProvider, Provider<PreviewDownloadRemoteDataSource> previewDownloadDataSourceProvider) {
        this.observabilityProvider = observabilityProvider;
        this.previewDownloadDataSourceProvider = previewDownloadDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewDownloadOriginalWrapper get() {
        return newInstance(this.observabilityProvider.get(), this.previewDownloadDataSourceProvider.get());
    }

    public static PreviewDownloadOriginalWrapper_Factory create(Provider<PreviewObservability> observabilityProvider, Provider<PreviewDownloadRemoteDataSource> previewDownloadDataSourceProvider) {
        return new PreviewDownloadOriginalWrapper_Factory(observabilityProvider, previewDownloadDataSourceProvider);
    }

    public static PreviewDownloadOriginalWrapper newInstance(PreviewObservability observability, PreviewDownloadRemoteDataSource previewDownloadDataSource) {
        return new PreviewDownloadOriginalWrapper(observability, previewDownloadDataSource);
    }
}
