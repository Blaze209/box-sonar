package com.box.android.data.service.impl;

import com.box.android.common.utilities.Clock;
import com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultNoteFolderService_Factory implements Factory<DefaultNoteFolderService> {
    private final Provider<Clock> clockProvider;
    private final Provider<DefaultNoteFolderRemoteDataSource> remoteDataSourceProvider;

    private DefaultNoteFolderService_Factory(Provider<DefaultNoteFolderRemoteDataSource> remoteDataSourceProvider, Provider<Clock> clockProvider) {
        this.remoteDataSourceProvider = remoteDataSourceProvider;
        this.clockProvider = clockProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DefaultNoteFolderService get() {
        return newInstance(this.remoteDataSourceProvider.get(), this.clockProvider.get());
    }

    public static DefaultNoteFolderService_Factory create(Provider<DefaultNoteFolderRemoteDataSource> remoteDataSourceProvider, Provider<Clock> clockProvider) {
        return new DefaultNoteFolderService_Factory(remoteDataSourceProvider, clockProvider);
    }

    public static DefaultNoteFolderService newInstance(DefaultNoteFolderRemoteDataSource remoteDataSource, Clock clock) {
        return new DefaultNoteFolderService(remoteDataSource, clock);
    }
}
