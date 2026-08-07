package com.box.android.updates.proposal;

import android.content.SharedPreferences;
import com.box.android.common.utilities.Clock;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdateProposalManager_Factory implements Factory<AppUpdateProposalManager> {
    private final Provider<IBoxAccountSettings> accountSettingsProvider;
    private final Provider<AppUpdateManager> appUpdateManagerProvider;
    private final Provider<AppUpdateProposalAnalytics> appUpdateProposalAnalyticsProvider;
    private final Provider<Clock> clockProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private AppUpdateProposalManager_Factory(Provider<AppUpdateManager> provider, Provider<SharedPreferences> provider2, Provider<FeatureFlips> provider3, Provider<Clock> provider4, Provider<AppUpdateProposalAnalytics> provider5, Provider<IBoxAccountSettings> provider6) {
        this.appUpdateManagerProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.featureFlipsProvider = provider3;
        this.clockProvider = provider4;
        this.appUpdateProposalAnalyticsProvider = provider5;
        this.accountSettingsProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppUpdateProposalManager get() {
        return newInstance(this.appUpdateManagerProvider.get(), this.sharedPreferencesProvider.get(), this.featureFlipsProvider.get(), this.clockProvider.get(), this.appUpdateProposalAnalyticsProvider.get(), this.accountSettingsProvider.get());
    }

    public static AppUpdateProposalManager_Factory create(Provider<AppUpdateManager> provider, Provider<SharedPreferences> provider2, Provider<FeatureFlips> provider3, Provider<Clock> provider4, Provider<AppUpdateProposalAnalytics> provider5, Provider<IBoxAccountSettings> provider6) {
        return new AppUpdateProposalManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AppUpdateProposalManager newInstance(AppUpdateManager appUpdateManager, SharedPreferences sharedPreferences, FeatureFlips featureFlips, Clock clock, AppUpdateProposalAnalytics appUpdateProposalAnalytics, IBoxAccountSettings iBoxAccountSettings) {
        return new AppUpdateProposalManager(appUpdateManager, sharedPreferences, featureFlips, clock, appUpdateProposalAnalytics, iBoxAccountSettings);
    }
}
