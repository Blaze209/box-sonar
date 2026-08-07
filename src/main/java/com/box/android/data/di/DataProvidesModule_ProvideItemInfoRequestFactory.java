package com.box.android.data.di;

import com.box.android.data.api.requests.ItemInfoRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideItemInfoRequestFactory implements Factory<ItemInfoRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideItemInfoRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemInfoRequest get() {
        return provideItemInfoRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideItemInfoRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideItemInfoRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static ItemInfoRequest provideItemInfoRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (ItemInfoRequest) Preconditions.checkNotNullFromProvides(instance.provideItemInfoRequest(requestFactory, appRestrictionsManager));
    }
}
