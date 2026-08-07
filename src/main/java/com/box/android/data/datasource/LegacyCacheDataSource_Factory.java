package com.box.android.data.datasource;

import com.box.androidsdk.content.BoxCache;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LegacyCacheDataSource_Factory implements Factory<LegacyCacheDataSource> {
    private final Provider<BoxCache> boxCacheProvider;

    private LegacyCacheDataSource_Factory(Provider<BoxCache> boxCacheProvider) {
        this.boxCacheProvider = boxCacheProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LegacyCacheDataSource get() {
        return newInstance(this.boxCacheProvider.get());
    }

    public static LegacyCacheDataSource_Factory create(Provider<BoxCache> boxCacheProvider) {
        return new LegacyCacheDataSource_Factory(boxCacheProvider);
    }

    public static LegacyCacheDataSource newInstance(BoxCache boxCache) {
        return new LegacyCacheDataSource(boxCache);
    }
}
