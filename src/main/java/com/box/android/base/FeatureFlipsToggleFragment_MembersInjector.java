package com.box.android.base;

import com.box.android.domain.configuration.FeatureFlips;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FeatureFlipsToggleFragment_MembersInjector implements MembersInjector<FeatureFlipsToggleFragment> {
    private final Provider<FeatureFlips> featureFlipsProvider;

    private FeatureFlipsToggleFragment_MembersInjector(Provider<FeatureFlips> provider) {
        this.featureFlipsProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FeatureFlipsToggleFragment featureFlipsToggleFragment) {
        injectFeatureFlips(featureFlipsToggleFragment, this.featureFlipsProvider.get());
    }

    public static MembersInjector<FeatureFlipsToggleFragment> create(Provider<FeatureFlips> provider) {
        return new FeatureFlipsToggleFragment_MembersInjector(provider);
    }

    public static void injectFeatureFlips(FeatureFlipsToggleFragment featureFlipsToggleFragment, FeatureFlips featureFlips) {
        featureFlipsToggleFragment.featureFlips = featureFlips;
    }
}
