package com.box.android.data.di;

import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.api.requests.UpdateItemInfoRequest;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideUpdateItemInfoRequestFactory implements Factory<UpdateItemInfoRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideUpdateItemInfoRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateItemInfoRequest get() {
        return provideUpdateItemInfoRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideUpdateItemInfoRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideUpdateItemInfoRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static UpdateItemInfoRequest provideUpdateItemInfoRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (UpdateItemInfoRequest) Preconditions.checkNotNullFromProvides(instance.provideUpdateItemInfoRequest(requestFactory, appRestrictionsManager));
    }
}
