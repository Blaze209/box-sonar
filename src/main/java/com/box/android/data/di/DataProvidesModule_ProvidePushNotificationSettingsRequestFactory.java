package com.box.android.data.di;

import com.box.android.data.api.requests.PushNotificationSettingsRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidePushNotificationSettingsRequestFactory implements Factory<PushNotificationSettingsRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvidePushNotificationSettingsRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PushNotificationSettingsRequest get() {
        return providePushNotificationSettingsRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvidePushNotificationSettingsRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvidePushNotificationSettingsRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static PushNotificationSettingsRequest providePushNotificationSettingsRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (PushNotificationSettingsRequest) Preconditions.checkNotNullFromProvides(instance.providePushNotificationSettingsRequest(requestFactory, appRestrictionsManager));
    }
}
