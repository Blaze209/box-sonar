package com.box.android.data.api.interceptors;

import com.box.android.domain.configuration.ConfigManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DevpodInterceptor_Factory implements Factory<DevpodInterceptor> {
    private final Provider<ConfigManager> configManagerProvider;

    private DevpodInterceptor_Factory(Provider<ConfigManager> configManagerProvider) {
        this.configManagerProvider = configManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DevpodInterceptor get() {
        return newInstance(this.configManagerProvider.get());
    }

    public static DevpodInterceptor_Factory create(Provider<ConfigManager> configManagerProvider) {
        return new DevpodInterceptor_Factory(configManagerProvider);
    }

    public static DevpodInterceptor newInstance(ConfigManager configManager) {
        return new DevpodInterceptor(configManager);
    }
}
