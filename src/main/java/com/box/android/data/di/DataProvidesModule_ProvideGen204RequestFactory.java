package com.box.android.data.di;

import com.box.android.data.api.requests.MetricsLoggingRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import com.box.android.data.service.impl.BVEManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideGen204RequestFactory implements Factory<MetricsLoggingRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final Provider<BVEManager> bveManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideGen204RequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider, Provider<BVEManager> bveManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
        this.bveManagerProvider = bveManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsLoggingRequest get() {
        return provideGen204Request(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get(), this.bveManagerProvider.get());
    }

    public static DataProvidesModule_ProvideGen204RequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider, Provider<BVEManager> bveManagerProvider) {
        return new DataProvidesModule_ProvideGen204RequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider, bveManagerProvider);
    }

    public static MetricsLoggingRequest provideGen204Request(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager, BVEManager bveManager) {
        return (MetricsLoggingRequest) Preconditions.checkNotNullFromProvides(instance.provideGen204Request(requestFactory, appRestrictionsManager, bveManager));
    }
}
