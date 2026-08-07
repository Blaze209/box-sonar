package com.box.android.data.persistence.offline;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class OfflineMigrationService_Factory implements Factory<OfflineMigrationService> {
    private final Provider<OfflineServiceLocalDataSource> dataSourceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private OfflineMigrationService_Factory(Provider<OfflineServiceLocalDataSource> dataSourceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.dataSourceProvider = dataSourceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflineMigrationService get() {
        return newInstance(this.dataSourceProvider.get(), this.userContextManagerProvider.get(), this.ioDispatcherProvider.get());
    }

    public static OfflineMigrationService_Factory create(Provider<OfflineServiceLocalDataSource> dataSourceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new OfflineMigrationService_Factory(dataSourceProvider, userContextManagerProvider, ioDispatcherProvider);
    }

    public static OfflineMigrationService newInstance(OfflineServiceLocalDataSource dataSource, IUserContextManager userContextManager, CoroutineDispatcher ioDispatcher) {
        return new OfflineMigrationService(dataSource, userContextManager, ioDispatcher);
    }
}
