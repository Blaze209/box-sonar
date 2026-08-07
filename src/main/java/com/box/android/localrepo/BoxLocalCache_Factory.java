package com.box.android.localrepo;

import android.content.Context;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.ILegacyBridgeService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxLocalCache_Factory implements Factory<BoxLocalCache> {
    private final Provider<IAppRestrictionsManager> appRestrictionsManagerProvider;
    private final Provider<ConfigManager> configManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<IMoCoBoxGlobalSettings> globalSettingsProvider;
    private final Provider<ILegacyBridgeService> legacyBridgeServiceProvider;
    private final Provider<LocalSortPreferences> sortPreferencesProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxLocalCache_Factory(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<LocalSortPreferences> provider3, Provider<ILegacyBridgeService> provider4, Provider<ConfigManager> provider5, Provider<IMoCoBoxGlobalSettings> provider6, Provider<IAppRestrictionsManager> provider7) {
        this.contextProvider = provider;
        this.userContextManagerProvider = provider2;
        this.sortPreferencesProvider = provider3;
        this.legacyBridgeServiceProvider = provider4;
        this.configManagerProvider = provider5;
        this.globalSettingsProvider = provider6;
        this.appRestrictionsManagerProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxLocalCache get() {
        return newInstance(this.contextProvider.get(), this.userContextManagerProvider.get(), this.sortPreferencesProvider.get(), this.legacyBridgeServiceProvider.get(), this.configManagerProvider.get(), this.globalSettingsProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static BoxLocalCache_Factory create(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<LocalSortPreferences> provider3, Provider<ILegacyBridgeService> provider4, Provider<ConfigManager> provider5, Provider<IMoCoBoxGlobalSettings> provider6, Provider<IAppRestrictionsManager> provider7) {
        return new BoxLocalCache_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static BoxLocalCache newInstance(Context context, IUserContextManager iUserContextManager, LocalSortPreferences localSortPreferences, ILegacyBridgeService iLegacyBridgeService, ConfigManager configManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, IAppRestrictionsManager iAppRestrictionsManager) {
        return new BoxLocalCache(context, iUserContextManager, localSortPreferences, iLegacyBridgeService, configManager, iMoCoBoxGlobalSettings, iAppRestrictionsManager);
    }
}
