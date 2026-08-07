package com.box.android.coreservices.utilities;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAccountManagerHelper_Factory implements Factory<BoxAccountManagerHelper> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxAccountManagerHelper_Factory(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2) {
        this.userContextManagerProvider = provider;
        this.featureFlipsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAccountManagerHelper get() {
        return newInstance(this.userContextManagerProvider.get(), this.featureFlipsProvider.get());
    }

    public static BoxAccountManagerHelper_Factory create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2) {
        return new BoxAccountManagerHelper_Factory(provider, provider2);
    }

    public static BoxAccountManagerHelper newInstance(IUserContextManager iUserContextManager, FeatureFlips featureFlips) {
        return new BoxAccountManagerHelper(iUserContextManager, featureFlips);
    }
}
