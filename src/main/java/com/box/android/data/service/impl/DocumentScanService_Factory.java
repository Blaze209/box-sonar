package com.box.android.data.service.impl;

import com.box.android.data.datasource.DocumentScanCacheDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DocumentScanService_Factory implements Factory<DocumentScanService> {
    private final Provider<DocumentScanCacheDataSource> dataSourceProvider;

    private DocumentScanService_Factory(Provider<DocumentScanCacheDataSource> dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentScanService get() {
        return newInstance(this.dataSourceProvider.get());
    }

    public static DocumentScanService_Factory create(Provider<DocumentScanCacheDataSource> dataSourceProvider) {
        return new DocumentScanService_Factory(dataSourceProvider);
    }

    public static DocumentScanService newInstance(DocumentScanCacheDataSource dataSource) {
        return new DocumentScanService(dataSource);
    }
}
