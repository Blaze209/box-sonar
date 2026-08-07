package com.box.android.search.presentation.vm;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import com.box.android.search.analytics.BrowseSearchAnalytics;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.search.presentation.vm.SearchViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C1718SearchViewModel_Factory {
    private final Provider<BrowseSearchAnalytics> browseSearchAnalyticsProvider;
    private final Provider<SearchEnvironment> searchEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1718SearchViewModel_Factory(Provider<IStoreFactory> provider, Provider<SearchEnvironment> provider2, Provider<BrowseSearchAnalytics> provider3) {
        this.storeFactoryProvider = provider;
        this.searchEnvironmentProvider = provider2;
        this.browseSearchAnalyticsProvider = provider3;
    }

    public SearchViewModel get(Bundle bundle) {
        return newInstance(this.storeFactoryProvider.get(), this.searchEnvironmentProvider.get(), this.browseSearchAnalyticsProvider.get(), bundle);
    }

    public static C1718SearchViewModel_Factory create(Provider<IStoreFactory> provider, Provider<SearchEnvironment> provider2, Provider<BrowseSearchAnalytics> provider3) {
        return new C1718SearchViewModel_Factory(provider, provider2, provider3);
    }

    public static SearchViewModel newInstance(IStoreFactory iStoreFactory, SearchEnvironment searchEnvironment, BrowseSearchAnalytics browseSearchAnalytics, Bundle bundle) {
        return new SearchViewModel(iStoreFactory, searchEnvironment, browseSearchAnalytics, bundle);
    }
}
