package com.box.android.data.di;

import com.box.android.data.api.requests.MetadataTemplatesRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideMetadataTemplatesRequestFactory implements Factory<MetadataTemplatesRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideMetadataTemplatesRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetadataTemplatesRequest get() {
        return provideMetadataTemplatesRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideMetadataTemplatesRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideMetadataTemplatesRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static MetadataTemplatesRequest provideMetadataTemplatesRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (MetadataTemplatesRequest) Preconditions.checkNotNullFromProvides(instance.provideMetadataTemplatesRequest(requestFactory, appRestrictionsManager));
    }
}
