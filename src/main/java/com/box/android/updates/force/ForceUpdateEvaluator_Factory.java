package com.box.android.updates.force;

import com.box.android.domain.configuration.IForceUpdateRepository;
import com.box.android.domain.metrics.ForceUpdateObservability;
import com.box.android.domain.services.IAppInfoService;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateEvaluator_Factory implements Factory<ForceUpdateEvaluator> {
    private final Provider<ForceUpdateAnalytics> analyticsProvider;
    private final Provider<IAppInfoService> appInfoServiceProvider;
    private final Provider<ForceUpdateObservability> observabilityProvider;
    private final Provider<IForceUpdateRepository> repositoryProvider;
    private final Provider<ForceUpdateVersionValidator> versionValidatorProvider;

    private ForceUpdateEvaluator_Factory(Provider<IForceUpdateRepository> provider, Provider<ForceUpdateVersionValidator> provider2, Provider<ForceUpdateObservability> provider3, Provider<ForceUpdateAnalytics> provider4, Provider<IAppInfoService> provider5) {
        this.repositoryProvider = provider;
        this.versionValidatorProvider = provider2;
        this.observabilityProvider = provider3;
        this.analyticsProvider = provider4;
        this.appInfoServiceProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateEvaluator get() {
        return newInstance(this.repositoryProvider.get(), this.versionValidatorProvider.get(), this.observabilityProvider.get(), this.analyticsProvider.get(), this.appInfoServiceProvider.get());
    }

    public static ForceUpdateEvaluator_Factory create(Provider<IForceUpdateRepository> provider, Provider<ForceUpdateVersionValidator> provider2, Provider<ForceUpdateObservability> provider3, Provider<ForceUpdateAnalytics> provider4, Provider<IAppInfoService> provider5) {
        return new ForceUpdateEvaluator_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ForceUpdateEvaluator newInstance(IForceUpdateRepository iForceUpdateRepository, ForceUpdateVersionValidator forceUpdateVersionValidator, ForceUpdateObservability forceUpdateObservability, ForceUpdateAnalytics forceUpdateAnalytics, IAppInfoService iAppInfoService) {
        return new ForceUpdateEvaluator(iForceUpdateRepository, forceUpdateVersionValidator, forceUpdateObservability, forceUpdateAnalytics, iAppInfoService);
    }
}
