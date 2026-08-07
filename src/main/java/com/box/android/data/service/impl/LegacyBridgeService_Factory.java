package com.box.android.data.service.impl;

import com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource;
import com.box.android.data.utilities.GQLCacheHelper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LegacyBridgeService_Factory implements Factory<LegacyBridgeService> {
    private final Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider;
    private final Provider<GQLCacheHelper> gqlCacheHelperProvider;

    private LegacyBridgeService_Factory(Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider) {
        this.captureHistoryCacheDataSourceProvider = captureHistoryCacheDataSourceProvider;
        this.gqlCacheHelperProvider = gqlCacheHelperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LegacyBridgeService get() {
        return newInstance(this.captureHistoryCacheDataSourceProvider.get(), this.gqlCacheHelperProvider.get());
    }

    public static LegacyBridgeService_Factory create(Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider) {
        return new LegacyBridgeService_Factory(captureHistoryCacheDataSourceProvider, gqlCacheHelperProvider);
    }

    public static LegacyBridgeService newInstance(CaptureHistoryCacheDataSource captureHistoryCacheDataSource, GQLCacheHelper gqlCacheHelper) {
        return new LegacyBridgeService(captureHistoryCacheDataSource, gqlCacheHelper);
    }
}
