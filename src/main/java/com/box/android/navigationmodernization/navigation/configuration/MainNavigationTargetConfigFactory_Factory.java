package com.box.android.navigationmodernization.navigation.configuration;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MainNavigationTargetConfigFactory_Factory implements Factory<MainNavigationTargetConfigFactory> {
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<GetFavoritesCollectionIdUseCase> getFavoritesCollectionIdUseCaseProvider;

    private MainNavigationTargetConfigFactory_Factory(Provider<GetFavoritesCollectionIdUseCase> provider, Provider<FeatureFlips> provider2, Provider<IBoxAccountSettings> provider3) {
        this.getFavoritesCollectionIdUseCaseProvider = provider;
        this.featureFlipsProvider = provider2;
        this.boxAccountSettingsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MainNavigationTargetConfigFactory get() {
        return newInstance(this.getFavoritesCollectionIdUseCaseProvider.get(), this.featureFlipsProvider.get(), this.boxAccountSettingsProvider.get());
    }

    public static MainNavigationTargetConfigFactory_Factory create(Provider<GetFavoritesCollectionIdUseCase> provider, Provider<FeatureFlips> provider2, Provider<IBoxAccountSettings> provider3) {
        return new MainNavigationTargetConfigFactory_Factory(provider, provider2, provider3);
    }

    public static MainNavigationTargetConfigFactory newInstance(GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase, FeatureFlips featureFlips, IBoxAccountSettings iBoxAccountSettings) {
        return new MainNavigationTargetConfigFactory(getFavoritesCollectionIdUseCase, featureFlips, iBoxAccountSettings);
    }
}
