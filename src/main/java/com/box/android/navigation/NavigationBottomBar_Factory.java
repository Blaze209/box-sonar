package com.box.android.navigation;

import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class NavigationBottomBar_Factory implements Factory<NavigationBottomBar> {
    private final Provider<BoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private NavigationBottomBar_Factory(Provider<FeatureFlips> provider, Provider<BoxAccountSettings> provider2, Provider<IUserContextManager> provider3) {
        this.featureFlipsProvider = provider;
        this.boxAccountSettingsProvider = provider2;
        this.userContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NavigationBottomBar get() {
        return newInstance(this.featureFlipsProvider.get(), this.boxAccountSettingsProvider.get(), this.userContextManagerProvider.get());
    }

    public static NavigationBottomBar_Factory create(Provider<FeatureFlips> provider, Provider<BoxAccountSettings> provider2, Provider<IUserContextManager> provider3) {
        return new NavigationBottomBar_Factory(provider, provider2, provider3);
    }

    public static NavigationBottomBar newInstance(FeatureFlips featureFlips, BoxAccountSettings boxAccountSettings, IUserContextManager iUserContextManager) {
        return new NavigationBottomBar(featureFlips, boxAccountSettings, iUserContextManager);
    }
}
