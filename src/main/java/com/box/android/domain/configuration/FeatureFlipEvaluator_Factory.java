package com.box.android.domain.configuration;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FeatureFlipEvaluator_Factory implements Factory<FeatureFlipEvaluator> {
    private final Provider<ISplitConfiguration> splitConfigurationProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FeatureFlipEvaluator_Factory(Provider<ISplitConfiguration> provider, Provider<IUserContextManager> provider2) {
        this.splitConfigurationProvider = provider;
        this.userContextManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FeatureFlipEvaluator get() {
        return newInstance(this.splitConfigurationProvider.get(), this.userContextManagerProvider.get());
    }

    public static FeatureFlipEvaluator_Factory create(Provider<ISplitConfiguration> provider, Provider<IUserContextManager> provider2) {
        return new FeatureFlipEvaluator_Factory(provider, provider2);
    }

    public static FeatureFlipEvaluator newInstance(ISplitConfiguration iSplitConfiguration, IUserContextManager iUserContextManager) {
        return new FeatureFlipEvaluator(iSplitConfiguration, iUserContextManager);
    }
}
