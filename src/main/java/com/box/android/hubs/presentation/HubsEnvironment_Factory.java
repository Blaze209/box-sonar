package com.box.android.hubs.presentation;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.domain.localrepo.HubsScreenPreferences;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.services.IHubsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsEnvironment_Factory implements Factory<HubsEnvironment> {
    private final Provider<HubsAnalytics> analyticsProvider;
    private final Provider<HubsObservability> hubsObservabilityProvider;
    private final Provider<HubsScreenPreferences> hubsScreenPreferencesProvider;
    private final Provider<IHubsService> hubsServiceProvider;
    private final Provider<MultiselectEnvironment> multiselectEnvironmentProvider;
    private final Provider<ItemThumbnailEnvironment> thumbnailEnvironmentProvider;

    private HubsEnvironment_Factory(Provider<IHubsService> provider, Provider<HubsScreenPreferences> provider2, Provider<HubsObservability> provider3, Provider<ItemThumbnailEnvironment> provider4, Provider<MultiselectEnvironment> provider5, Provider<HubsAnalytics> provider6) {
        this.hubsServiceProvider = provider;
        this.hubsScreenPreferencesProvider = provider2;
        this.hubsObservabilityProvider = provider3;
        this.thumbnailEnvironmentProvider = provider4;
        this.multiselectEnvironmentProvider = provider5;
        this.analyticsProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsEnvironment get() {
        return newInstance(this.hubsServiceProvider.get(), this.hubsScreenPreferencesProvider.get(), this.hubsObservabilityProvider.get(), this.thumbnailEnvironmentProvider.get(), this.multiselectEnvironmentProvider.get(), this.analyticsProvider.get());
    }

    public static HubsEnvironment_Factory create(Provider<IHubsService> provider, Provider<HubsScreenPreferences> provider2, Provider<HubsObservability> provider3, Provider<ItemThumbnailEnvironment> provider4, Provider<MultiselectEnvironment> provider5, Provider<HubsAnalytics> provider6) {
        return new HubsEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static HubsEnvironment newInstance(IHubsService iHubsService, HubsScreenPreferences hubsScreenPreferences, HubsObservability hubsObservability, ItemThumbnailEnvironment itemThumbnailEnvironment, MultiselectEnvironment multiselectEnvironment, HubsAnalytics hubsAnalytics) {
        return new HubsEnvironment(iHubsService, hubsScreenPreferences, hubsObservability, itemThumbnailEnvironment, multiselectEnvironment, hubsAnalytics);
    }
}
