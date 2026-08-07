package com.box.android.data.di;

import com.box.android.data.api.requests.ChunkedFileUploadRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideChunkedUploadFileRequestFactory implements Factory<ChunkedFileUploadRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideChunkedUploadFileRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ChunkedFileUploadRequest get() {
        return provideChunkedUploadFileRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideChunkedUploadFileRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideChunkedUploadFileRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static ChunkedFileUploadRequest provideChunkedUploadFileRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (ChunkedFileUploadRequest) Preconditions.checkNotNullFromProvides(instance.provideChunkedUploadFileRequest(requestFactory, appRestrictionsManager));
    }
}
