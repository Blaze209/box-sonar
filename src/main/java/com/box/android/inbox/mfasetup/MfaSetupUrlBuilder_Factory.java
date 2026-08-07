package com.box.android.inbox.mfasetup;

import com.box.android.domain.configuration.ConfigManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MfaSetupUrlBuilder_Factory implements Factory<MfaSetupUrlBuilder> {
    private final Provider<ConfigManager> configManagerProvider;

    private MfaSetupUrlBuilder_Factory(Provider<ConfigManager> provider) {
        this.configManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MfaSetupUrlBuilder get() {
        return newInstance(this.configManagerProvider.get());
    }

    public static MfaSetupUrlBuilder_Factory create(Provider<ConfigManager> provider) {
        return new MfaSetupUrlBuilder_Factory(provider);
    }

    public static MfaSetupUrlBuilder newInstance(ConfigManager configManager) {
        return new MfaSetupUrlBuilder(configManager);
    }
}
