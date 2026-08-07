package com.box.android.data.di;

import com.box.android.data.api.requests.DefaultNoteFolderRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideDefaultNoteFolderRequestFactory implements Factory<DefaultNoteFolderRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideDefaultNoteFolderRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DefaultNoteFolderRequest get() {
        return provideDefaultNoteFolderRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideDefaultNoteFolderRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideDefaultNoteFolderRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static DefaultNoteFolderRequest provideDefaultNoteFolderRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (DefaultNoteFolderRequest) Preconditions.checkNotNullFromProvides(instance.provideDefaultNoteFolderRequest(requestFactory, appRestrictionsManager));
    }
}
