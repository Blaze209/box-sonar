package com.box.android.browse.activities;

import com.box.android.domain.configuration.FeatureFlips;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FilterSearchResults_MembersInjector implements MembersInjector<FilterSearchResults> {
    private final Provider<FeatureFlips> mFeatureFlipsProvider;

    private FilterSearchResults_MembersInjector(Provider<FeatureFlips> provider) {
        this.mFeatureFlipsProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FilterSearchResults filterSearchResults) {
        injectMFeatureFlips(filterSearchResults, this.mFeatureFlipsProvider.get());
    }

    public static MembersInjector<FilterSearchResults> create(Provider<FeatureFlips> provider) {
        return new FilterSearchResults_MembersInjector(provider);
    }

    public static void injectMFeatureFlips(FilterSearchResults filterSearchResults, FeatureFlips featureFlips) {
        filterSearchResults.mFeatureFlips = featureFlips;
    }
}
