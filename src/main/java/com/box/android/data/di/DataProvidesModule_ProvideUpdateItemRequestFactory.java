package com.box.android.data.di;

import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.api.requests.UpdateItemRequest;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideUpdateItemRequestFactory implements Factory<UpdateItemRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideUpdateItemRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateItemRequest get() {
        return provideUpdateItemRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideUpdateItemRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideUpdateItemRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static UpdateItemRequest provideUpdateItemRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (UpdateItemRequest) Preconditions.checkNotNullFromProvides(instance.provideUpdateItemRequest(requestFactory, appRestrictionsManager));
    }
}
