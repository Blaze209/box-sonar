package com.box.android.domain.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ConfigManager_Factory implements Factory<ConfigManager> {
    private final Provider<Context> contextProvider;
    private final Provider<SharedPreferences> globalSharedPreferencesProvider;
    private final Provider<IProductFlavorConfig> productFlavorConfigProvider;

    private ConfigManager_Factory(Provider<Context> provider, Provider<SharedPreferences> provider2, Provider<IProductFlavorConfig> provider3) {
        this.contextProvider = provider;
        this.globalSharedPreferencesProvider = provider2;
        this.productFlavorConfigProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ConfigManager get() {
        return newInstance(this.contextProvider.get(), this.globalSharedPreferencesProvider.get(), this.productFlavorConfigProvider.get());
    }

    public static ConfigManager_Factory create(Provider<Context> provider, Provider<SharedPreferences> provider2, Provider<IProductFlavorConfig> provider3) {
        return new ConfigManager_Factory(provider, provider2, provider3);
    }

    public static ConfigManager newInstance(Context context, SharedPreferences sharedPreferences, IProductFlavorConfig iProductFlavorConfig) {
        return new ConfigManager(context, sharedPreferences, iProductFlavorConfig);
    }
}
