package com.box.android.updates.force;

import com.box.android.domain.metrics.ForceUpdateObservability;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateActionHandler_Factory implements Factory<ForceUpdateActionHandler> {
    private final Provider<ForceUpdateAnalytics> analyticsProvider;
    private final Provider<AppUpdateManager> appUpdateManagerProvider;
    private final Provider<ForceUpdateObservability> observabilityProvider;

    private ForceUpdateActionHandler_Factory(Provider<AppUpdateManager> provider, Provider<ForceUpdateObservability> provider2, Provider<ForceUpdateAnalytics> provider3) {
        this.appUpdateManagerProvider = provider;
        this.observabilityProvider = provider2;
        this.analyticsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateActionHandler get() {
        return newInstance(this.appUpdateManagerProvider.get(), this.observabilityProvider.get(), this.analyticsProvider.get());
    }

    public static ForceUpdateActionHandler_Factory create(Provider<AppUpdateManager> provider, Provider<ForceUpdateObservability> provider2, Provider<ForceUpdateAnalytics> provider3) {
        return new ForceUpdateActionHandler_Factory(provider, provider2, provider3);
    }

    public static ForceUpdateActionHandler newInstance(AppUpdateManager appUpdateManager, ForceUpdateObservability forceUpdateObservability, ForceUpdateAnalytics forceUpdateAnalytics) {
        return new ForceUpdateActionHandler(appUpdateManager, forceUpdateObservability, forceUpdateAnalytics);
    }
}
