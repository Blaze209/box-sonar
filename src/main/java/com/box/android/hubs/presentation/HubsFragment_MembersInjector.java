package com.box.android.hubs.presentation;

import com.box.android.coreservices.services.IntentServices;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsFragment_MembersInjector implements MembersInjector<HubsFragment> {
    private final Provider<IntentServices> intentServicesProvider;

    private HubsFragment_MembersInjector(Provider<IntentServices> provider) {
        this.intentServicesProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HubsFragment hubsFragment) {
        injectIntentServices(hubsFragment, this.intentServicesProvider.get());
    }

    public static MembersInjector<HubsFragment> create(Provider<IntentServices> provider) {
        return new HubsFragment_MembersInjector(provider);
    }

    public static void injectIntentServices(HubsFragment hubsFragment, IntentServices intentServices) {
        hubsFragment.intentServices = intentServices;
    }
}
