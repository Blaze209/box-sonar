package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import com.box.android.browse.utilities.BrowseAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseTabsEnvironment_Factory implements Factory<BrowseTabsEnvironment> {
    private final Provider<BrowseAnalytics> analyticsProvider;

    private BrowseTabsEnvironment_Factory(Provider<BrowseAnalytics> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseTabsEnvironment get() {
        return newInstance(this.analyticsProvider.get());
    }

    public static BrowseTabsEnvironment_Factory create(Provider<BrowseAnalytics> provider) {
        return new BrowseTabsEnvironment_Factory(provider);
    }

    public static BrowseTabsEnvironment newInstance(BrowseAnalytics browseAnalytics) {
        return new BrowseTabsEnvironment(browseAnalytics);
    }
}
