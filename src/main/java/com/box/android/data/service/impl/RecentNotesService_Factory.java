package com.box.android.data.service.impl;

import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource;
import com.box.android.data.datasource.recentnotes.RecentNotesRemoteDataSource;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RecentNotesService_Factory implements Factory<RecentNotesService> {
    private final Provider<GQLCacheHelper> gqlCacheHelperProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;
    private final Provider<RecentNotesLocalDataSource> recentNotesLocalDataSourceProvider;
    private final Provider<RecentNotesRemoteDataSource> recentNotesRemoteDataSourceProvider;
    private final Provider<IRemoteItemService> remoteItemServiceProvider;

    private RecentNotesService_Factory(Provider<RecentNotesRemoteDataSource> recentNotesRemoteDataSourceProvider, Provider<RecentNotesLocalDataSource> recentNotesLocalDataSourceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.recentNotesRemoteDataSourceProvider = recentNotesRemoteDataSourceProvider;
        this.recentNotesLocalDataSourceProvider = recentNotesLocalDataSourceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.gqlCacheHelperProvider = gqlCacheHelperProvider;
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentNotesService get() {
        return newInstance(this.recentNotesRemoteDataSourceProvider.get(), this.recentNotesLocalDataSourceProvider.get(), this.remoteItemServiceProvider.get(), this.gqlCacheHelperProvider.get(), this.legacyCacheDataSourceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static RecentNotesService_Factory create(Provider<RecentNotesRemoteDataSource> recentNotesRemoteDataSourceProvider, Provider<RecentNotesLocalDataSource> recentNotesLocalDataSourceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new RecentNotesService_Factory(recentNotesRemoteDataSourceProvider, recentNotesLocalDataSourceProvider, remoteItemServiceProvider, gqlCacheHelperProvider, legacyCacheDataSourceProvider, idMappingServiceProvider);
    }

    public static RecentNotesService newInstance(RecentNotesRemoteDataSource recentNotesRemoteDataSource, RecentNotesLocalDataSource recentNotesLocalDataSource, IRemoteItemService remoteItemService, GQLCacheHelper gqlCacheHelper, LegacyCacheDataSource legacyCacheDataSource, IdMappingService idMappingService) {
        return new RecentNotesService(recentNotesRemoteDataSource, recentNotesLocalDataSource, remoteItemService, gqlCacheHelper, legacyCacheDataSource, idMappingService);
    }
}
