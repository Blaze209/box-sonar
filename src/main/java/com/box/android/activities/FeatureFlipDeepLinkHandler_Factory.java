package com.box.android.activities;

import com.box.android.domain.configuration.FeatureFlips;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FeatureFlipDeepLinkHandler_Factory implements Factory<FeatureFlipDeepLinkHandler> {
    private final Provider<FeatureFlips> featureFlipsProvider;

    private FeatureFlipDeepLinkHandler_Factory(Provider<FeatureFlips> provider) {
        this.featureFlipsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FeatureFlipDeepLinkHandler get() {
        return newInstance(this.featureFlipsProvider.get());
    }

    public static FeatureFlipDeepLinkHandler_Factory create(Provider<FeatureFlips> provider) {
        return new FeatureFlipDeepLinkHandler_Factory(provider);
    }

    public static FeatureFlipDeepLinkHandler newInstance(FeatureFlips featureFlips) {
        return new FeatureFlipDeepLinkHandler(featureFlips);
    }
}
