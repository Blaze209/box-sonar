package com.box.android.data.api.interceptors;

import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.IAppInfoService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLClientRequestInterceptor_Factory implements Factory<GQLClientRequestInterceptor> {
    private final Provider<IAppInfoService> appInfoServiceProvider;
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;

    private GQLClientRequestInterceptor_Factory(Provider<IBoxAccountSettings> boxAccountSettingsProvider, Provider<IAppInfoService> appInfoServiceProvider) {
        this.boxAccountSettingsProvider = boxAccountSettingsProvider;
        this.appInfoServiceProvider = appInfoServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLClientRequestInterceptor get() {
        return newInstance(this.boxAccountSettingsProvider.get(), this.appInfoServiceProvider.get());
    }

    public static GQLClientRequestInterceptor_Factory create(Provider<IBoxAccountSettings> boxAccountSettingsProvider, Provider<IAppInfoService> appInfoServiceProvider) {
        return new GQLClientRequestInterceptor_Factory(boxAccountSettingsProvider, appInfoServiceProvider);
    }

    public static GQLClientRequestInterceptor newInstance(IBoxAccountSettings boxAccountSettings, IAppInfoService appInfoService) {
        return new GQLClientRequestInterceptor(boxAccountSettings, appInfoService);
    }
}
