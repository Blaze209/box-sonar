package com.box.android.search.presentation.cpl;

import com.box.android.search.analytics.SearchAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SearchReducer_Factory implements Factory<SearchReducer> {
    private final Provider<SearchAnalytics> analyticsProvider;
    private final Provider<SearchEnvironment> environmentProvider;

    private SearchReducer_Factory(Provider<SearchEnvironment> provider, Provider<SearchAnalytics> provider2) {
        this.environmentProvider = provider;
        this.analyticsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchReducer get() {
        return newInstance(this.environmentProvider.get(), this.analyticsProvider.get());
    }

    public static SearchReducer_Factory create(Provider<SearchEnvironment> provider, Provider<SearchAnalytics> provider2) {
        return new SearchReducer_Factory(provider, provider2);
    }

    public static SearchReducer newInstance(SearchEnvironment searchEnvironment, SearchAnalytics searchAnalytics) {
        return new SearchReducer(searchEnvironment, searchAnalytics);
    }
}
