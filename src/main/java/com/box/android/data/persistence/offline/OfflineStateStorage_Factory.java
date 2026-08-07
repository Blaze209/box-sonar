package com.box.android.data.persistence.offline;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class OfflineStateStorage_Factory implements Factory<OfflineStateStorage> {
    private final Provider<OfflineServiceLocalDataSource> dataSourceProvider;

    private OfflineStateStorage_Factory(Provider<OfflineServiceLocalDataSource> dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflineStateStorage get() {
        return newInstance(this.dataSourceProvider.get());
    }

    public static OfflineStateStorage_Factory create(Provider<OfflineServiceLocalDataSource> dataSourceProvider) {
        return new OfflineStateStorage_Factory(dataSourceProvider);
    }

    public static OfflineStateStorage newInstance(OfflineServiceLocalDataSource dataSource) {
        return new OfflineStateStorage(dataSource);
    }
}
