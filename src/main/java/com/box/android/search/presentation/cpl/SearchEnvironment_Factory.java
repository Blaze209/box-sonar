package com.box.android.search.presentation.cpl;

import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.cpl.itemsList.ItemEnvironment;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.ISearchService;
import com.box.android.hubs.presentation.HubsEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SearchEnvironment_Factory implements Factory<SearchEnvironment> {
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<IBoxAiService> boxAiServiceProvider;
    private final Provider<IClientSettingsService> clientSettingsServiceProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<HubsEnvironment> hubsEnvironmentProvider;
    private final Provider<ItemEnvironment> itemEnvironmentProvider;
    private final Provider<MultiselectEnvironment> multiselectEnvironmentProvider;
    private final Provider<IOfflineService> offlineServiceProvider;
    private final Provider<ISearchService> searchServiceProvider;

    private SearchEnvironment_Factory(Provider<ISearchService> provider, Provider<HubsEnvironment> provider2, Provider<ItemEnvironment> provider3, Provider<MultiselectEnvironment> provider4, Provider<IClientSettingsService> provider5, Provider<IBoxAiService> provider6, Provider<IBoxAccountSettings> provider7, Provider<IOfflineService> provider8, Provider<FeatureFlips> provider9) {
        this.searchServiceProvider = provider;
        this.hubsEnvironmentProvider = provider2;
        this.itemEnvironmentProvider = provider3;
        this.multiselectEnvironmentProvider = provider4;
        this.clientSettingsServiceProvider = provider5;
        this.boxAiServiceProvider = provider6;
        this.boxAccountSettingsProvider = provider7;
        this.offlineServiceProvider = provider8;
        this.featureFlipsProvider = provider9;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchEnvironment get() {
        return newInstance(this.searchServiceProvider.get(), this.hubsEnvironmentProvider.get(), this.itemEnvironmentProvider.get(), this.multiselectEnvironmentProvider.get(), this.clientSettingsServiceProvider.get(), this.boxAiServiceProvider.get(), this.boxAccountSettingsProvider.get(), this.offlineServiceProvider.get(), this.featureFlipsProvider.get());
    }

    public static SearchEnvironment_Factory create(Provider<ISearchService> provider, Provider<HubsEnvironment> provider2, Provider<ItemEnvironment> provider3, Provider<MultiselectEnvironment> provider4, Provider<IClientSettingsService> provider5, Provider<IBoxAiService> provider6, Provider<IBoxAccountSettings> provider7, Provider<IOfflineService> provider8, Provider<FeatureFlips> provider9) {
        return new SearchEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SearchEnvironment newInstance(ISearchService iSearchService, HubsEnvironment hubsEnvironment, ItemEnvironment itemEnvironment, MultiselectEnvironment multiselectEnvironment, IClientSettingsService iClientSettingsService, IBoxAiService iBoxAiService, IBoxAccountSettings iBoxAccountSettings, IOfflineService iOfflineService, FeatureFlips featureFlips) {
        return new SearchEnvironment(iSearchService, hubsEnvironment, itemEnvironment, multiselectEnvironment, iClientSettingsService, iBoxAiService, iBoxAccountSettings, iOfflineService, featureFlips);
    }
}
