package com.box.android.cpl.navigation;

import com.box.android.browse.cpl.browse.BrowseEnvironment;
import com.box.android.browse.cpl.offlined.OfflinedEnvironment;
import com.box.android.browse.cpl.recents.RecentsEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class NavigationEnvironment_Factory implements Factory<NavigationEnvironment> {
    private final Provider<BrowseEnvironment> browseEnvironmentProvider;
    private final Provider<OfflinedEnvironment> offlinedEnvironmentProvider;
    private final Provider<RecentsEnvironment> recentsEnvironmentProvider;

    private NavigationEnvironment_Factory(Provider<BrowseEnvironment> provider, Provider<RecentsEnvironment> provider2, Provider<OfflinedEnvironment> provider3) {
        this.browseEnvironmentProvider = provider;
        this.recentsEnvironmentProvider = provider2;
        this.offlinedEnvironmentProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NavigationEnvironment get() {
        return newInstance(this.browseEnvironmentProvider.get(), this.recentsEnvironmentProvider.get(), this.offlinedEnvironmentProvider.get());
    }

    public static NavigationEnvironment_Factory create(Provider<BrowseEnvironment> provider, Provider<RecentsEnvironment> provider2, Provider<OfflinedEnvironment> provider3) {
        return new NavigationEnvironment_Factory(provider, provider2, provider3);
    }

    public static NavigationEnvironment newInstance(BrowseEnvironment browseEnvironment, RecentsEnvironment recentsEnvironment, OfflinedEnvironment offlinedEnvironment) {
        return new NavigationEnvironment(browseEnvironment, recentsEnvironment, offlinedEnvironment);
    }
}
