package com.box.android.domain.configuration;

import android.content.SharedPreferences;
import com.box.android.domain.services.IBVEManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SplitConfiguration_Factory implements Factory<SplitConfiguration> {
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<IBVEManager> bveManagerProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private SplitConfiguration_Factory(Provider<SharedPreferences> provider, Provider<IBoxAccountSettings> provider2, Provider<IBVEManager> provider3) {
        this.sharedPreferencesProvider = provider;
        this.boxAccountSettingsProvider = provider2;
        this.bveManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SplitConfiguration get() {
        return newInstance(this.sharedPreferencesProvider.get(), this.boxAccountSettingsProvider.get(), this.bveManagerProvider.get());
    }

    public static SplitConfiguration_Factory create(Provider<SharedPreferences> provider, Provider<IBoxAccountSettings> provider2, Provider<IBVEManager> provider3) {
        return new SplitConfiguration_Factory(provider, provider2, provider3);
    }

    public static SplitConfiguration newInstance(SharedPreferences sharedPreferences, IBoxAccountSettings iBoxAccountSettings, IBVEManager iBVEManager) {
        return new SplitConfiguration(sharedPreferences, iBoxAccountSettings, iBVEManager);
    }
}
