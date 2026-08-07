package com.box.android.data.di;

import com.box.android.data.api.requests.RecentNotesRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideRecentNotesRequestFactory implements Factory<RecentNotesRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideRecentNotesRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentNotesRequest get() {
        return provideRecentNotesRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideRecentNotesRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideRecentNotesRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static RecentNotesRequest provideRecentNotesRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (RecentNotesRequest) Preconditions.checkNotNullFromProvides(instance.provideRecentNotesRequest(requestFactory, appRestrictionsManager));
    }
}
