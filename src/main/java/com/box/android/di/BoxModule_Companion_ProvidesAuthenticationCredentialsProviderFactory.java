package com.box.android.di;

import com.box.android.auth.AuthenticationCredentialsProvider;
import com.box.android.domain.configuration.ConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvidesAuthenticationCredentialsProviderFactory implements Factory<AuthenticationCredentialsProvider> {
    private final Provider<ConfigManager> configManagerProvider;

    private BoxModule_Companion_ProvidesAuthenticationCredentialsProviderFactory(Provider<ConfigManager> provider) {
        this.configManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationCredentialsProvider get() {
        return providesAuthenticationCredentialsProvider(this.configManagerProvider.get());
    }

    public static BoxModule_Companion_ProvidesAuthenticationCredentialsProviderFactory create(Provider<ConfigManager> provider) {
        return new BoxModule_Companion_ProvidesAuthenticationCredentialsProviderFactory(provider);
    }

    public static AuthenticationCredentialsProvider providesAuthenticationCredentialsProvider(ConfigManager configManager) {
        return (AuthenticationCredentialsProvider) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.providesAuthenticationCredentialsProvider(configManager));
    }
}
