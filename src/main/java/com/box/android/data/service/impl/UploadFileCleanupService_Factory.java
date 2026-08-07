package com.box.android.data.service.impl;

import com.box.android.data.datasource.jobs.JobsDataSource;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadFileCleanupService_Factory implements Factory<UploadFileCleanupService> {
    private final Provider<IBoxStorage> boxStorageProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<JobsDataSource> jobsDataSourceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<ILocalSharedPreferences> localSharedPreferencesProvider;

    private UploadFileCleanupService_Factory(Provider<JobsDataSource> jobsDataSourceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<ILocalSharedPreferences> localSharedPreferencesProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.jobsDataSourceProvider = jobsDataSourceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.boxStorageProvider = boxStorageProvider;
        this.localSharedPreferencesProvider = localSharedPreferencesProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadFileCleanupService get() {
        return newInstance(this.jobsDataSourceProvider.get(), DoubleCheck.lazy((Provider) this.localItemServiceProvider), this.boxStorageProvider.get(), this.localSharedPreferencesProvider.get(), this.ioDispatcherProvider.get());
    }

    public static UploadFileCleanupService_Factory create(Provider<JobsDataSource> jobsDataSourceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<ILocalSharedPreferences> localSharedPreferencesProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new UploadFileCleanupService_Factory(jobsDataSourceProvider, localItemServiceProvider, boxStorageProvider, localSharedPreferencesProvider, ioDispatcherProvider);
    }

    public static UploadFileCleanupService newInstance(JobsDataSource jobsDataSource, Lazy<LocalItemService> localItemService, IBoxStorage boxStorage, ILocalSharedPreferences localSharedPreferences, CoroutineDispatcher ioDispatcher) {
        return new UploadFileCleanupService(jobsDataSource, localItemService, boxStorage, localSharedPreferences, ioDispatcher);
    }
}
