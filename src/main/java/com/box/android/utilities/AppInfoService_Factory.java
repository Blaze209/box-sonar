package com.box.android.utilities;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AppInfoService_Factory implements Factory<AppInfoService> {
    private final Provider<Context> appContextProvider;

    private AppInfoService_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppInfoService get() {
        return newInstance(this.appContextProvider.get());
    }

    public static AppInfoService_Factory create(Provider<Context> provider) {
        return new AppInfoService_Factory(provider);
    }

    public static AppInfoService newInstance(Context context) {
        return new AppInfoService(context);
    }
}
