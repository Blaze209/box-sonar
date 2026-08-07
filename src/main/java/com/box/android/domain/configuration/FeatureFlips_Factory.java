package com.box.android.domain.configuration;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FeatureFlips_Factory implements Factory<FeatureFlips> {
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<SharedPreferences> debugSharedPreferencesProvider;
    private final Provider<FeatureFlipEvaluator> evaluatorProvider;

    private FeatureFlips_Factory(Provider<IBoxAccountSettings> provider, Provider<SharedPreferences> provider2, Provider<FeatureFlipEvaluator> provider3) {
        this.boxAccountSettingsProvider = provider;
        this.debugSharedPreferencesProvider = provider2;
        this.evaluatorProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FeatureFlips get() {
        return newInstance(this.boxAccountSettingsProvider.get(), this.debugSharedPreferencesProvider.get(), this.evaluatorProvider.get());
    }

    public static FeatureFlips_Factory create(Provider<IBoxAccountSettings> provider, Provider<SharedPreferences> provider2, Provider<FeatureFlipEvaluator> provider3) {
        return new FeatureFlips_Factory(provider, provider2, provider3);
    }

    public static FeatureFlips newInstance(IBoxAccountSettings iBoxAccountSettings, SharedPreferences sharedPreferences, FeatureFlipEvaluator featureFlipEvaluator) {
        return new FeatureFlips(iBoxAccountSettings, sharedPreferences, featureFlipEvaluator);
    }
}
