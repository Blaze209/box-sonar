package com.box.android.cpl.mainphone;

import com.box.android.browse.cpl.browse.BrowseEnvironment;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class MainPhoneEnvironment_Factory implements Factory<MainPhoneEnvironment> {
    private final Provider<BrowseEnvironment> browseEnvironmentProvider;
    private final Provider<ConfigManager> mConfigManagerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private MainPhoneEnvironment_Factory(Provider<BrowseEnvironment> provider, Provider<ConfigManager> provider2, Provider<IUserContextManager> provider3) {
        this.browseEnvironmentProvider = provider;
        this.mConfigManagerProvider = provider2;
        this.mUserContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MainPhoneEnvironment get() {
        return newInstance(this.browseEnvironmentProvider.get(), this.mConfigManagerProvider.get(), this.mUserContextManagerProvider.get());
    }

    public static MainPhoneEnvironment_Factory create(Provider<BrowseEnvironment> provider, Provider<ConfigManager> provider2, Provider<IUserContextManager> provider3) {
        return new MainPhoneEnvironment_Factory(provider, provider2, provider3);
    }

    public static MainPhoneEnvironment newInstance(BrowseEnvironment browseEnvironment, ConfigManager configManager, IUserContextManager iUserContextManager) {
        return new MainPhoneEnvironment(browseEnvironment, configManager, iUserContextManager);
    }
}
