package com.box.android.data.service.impl.boxai;

import com.box.android.data.datasource.boxai.BoxAiRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxAiService_Factory implements Factory<BoxAiService> {
    private final Provider<BoxAiRemoteDataSource> boxAiRemoteDataSourceProvider;
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private BoxAiService_Factory(Provider<BoxAiRemoteDataSource> boxAiRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider) {
        this.boxAiRemoteDataSourceProvider = boxAiRemoteDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.defaultDispatcherProvider = defaultDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiService get() {
        return newInstance(this.boxAiRemoteDataSourceProvider.get(), this.idMappingServiceProvider.get(), this.defaultDispatcherProvider.get());
    }

    public static BoxAiService_Factory create(Provider<BoxAiRemoteDataSource> boxAiRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider) {
        return new BoxAiService_Factory(boxAiRemoteDataSourceProvider, idMappingServiceProvider, defaultDispatcherProvider);
    }

    public static BoxAiService newInstance(BoxAiRemoteDataSource boxAiRemoteDataSource, IdMappingService idMappingService, CoroutineDispatcher defaultDispatcher) {
        return new BoxAiService(boxAiRemoteDataSource, idMappingService, defaultDispatcher);
    }
}
