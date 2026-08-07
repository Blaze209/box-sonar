package com.box.android.collections.presentation.fragments;

import com.box.android.coreservices.services.IntentServices;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class MyCollectionsFragment_MembersInjector implements MembersInjector<MyCollectionsFragment> {
    private final Provider<IntentServices> intentServicesProvider;

    private MyCollectionsFragment_MembersInjector(Provider<IntentServices> provider) {
        this.intentServicesProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyCollectionsFragment myCollectionsFragment) {
        injectIntentServices(myCollectionsFragment, this.intentServicesProvider.get());
    }

    public static MembersInjector<MyCollectionsFragment> create(Provider<IntentServices> provider) {
        return new MyCollectionsFragment_MembersInjector(provider);
    }

    public static void injectIntentServices(MyCollectionsFragment myCollectionsFragment, IntentServices intentServices) {
        myCollectionsFragment.intentServices = intentServices;
    }
}
