package com.box.android.data.service.impl;

import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.androidsdk.content.BoxCache;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommonServiceUtils_Factory implements Factory<CommonServiceUtils> {
    private final Provider<BoxCache> boxCacheProvider;
    private final Provider<LegacyBridgeService> legacyBridgeServiceProvider;
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<RemoteItemService> remoteItemServiceProvider;

    private CommonServiceUtils_Factory(Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<Moshi> moshiProvider, Provider<LegacyBridgeService> legacyBridgeServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<BoxCache> boxCacheProvider) {
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.moshiProvider = moshiProvider;
        this.legacyBridgeServiceProvider = legacyBridgeServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.boxCacheProvider = boxCacheProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommonServiceUtils get() {
        return newInstance(this.legacyCacheDataSourceProvider.get(), this.moshiProvider.get(), this.legacyBridgeServiceProvider.get(), this.remoteItemServiceProvider.get(), this.boxCacheProvider.get());
    }

    public static CommonServiceUtils_Factory create(Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<Moshi> moshiProvider, Provider<LegacyBridgeService> legacyBridgeServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<BoxCache> boxCacheProvider) {
        return new CommonServiceUtils_Factory(legacyCacheDataSourceProvider, moshiProvider, legacyBridgeServiceProvider, remoteItemServiceProvider, boxCacheProvider);
    }

    public static CommonServiceUtils newInstance(LegacyCacheDataSource legacyCacheDataSource, Moshi moshi, LegacyBridgeService legacyBridgeService, RemoteItemService remoteItemService, BoxCache boxCache) {
        return new CommonServiceUtils(legacyCacheDataSource, moshi, legacyBridgeService, remoteItemService, boxCache);
    }
}
