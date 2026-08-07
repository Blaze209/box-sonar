package com.box.android.data.service.impl;

import com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CaptureHistoryFilesService_Factory implements Factory<CaptureHistoryFilesService> {
    private final Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider;

    private CaptureHistoryFilesService_Factory(Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider) {
        this.captureHistoryCacheDataSourceProvider = captureHistoryCacheDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureHistoryFilesService get() {
        return newInstance(this.captureHistoryCacheDataSourceProvider.get());
    }

    public static CaptureHistoryFilesService_Factory create(Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider) {
        return new CaptureHistoryFilesService_Factory(captureHistoryCacheDataSourceProvider);
    }

    public static CaptureHistoryFilesService newInstance(CaptureHistoryCacheDataSource captureHistoryCacheDataSource) {
        return new CaptureHistoryFilesService(captureHistoryCacheDataSource);
    }
}
