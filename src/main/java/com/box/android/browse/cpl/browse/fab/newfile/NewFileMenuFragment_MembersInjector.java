package com.box.android.browse.cpl.browse.fab.newfile;

import com.box.android.base.presentation.fragments.BottomSheetMenuFragment_MembersInjector;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class NewFileMenuFragment_MembersInjector implements MembersInjector<NewFileMenuFragment> {
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IntentServices> mIntentServicesProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private NewFileMenuFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<IntentServices> provider3) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
        this.mIntentServicesProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NewFileMenuFragment newFileMenuFragment) {
        BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(newFileMenuFragment, this.mUserContextManagerProvider.get());
        BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(newFileMenuFragment, this.mFeatureFlipsProvider.get());
        injectMIntentServices(newFileMenuFragment, this.mIntentServicesProvider.get());
    }

    public static MembersInjector<NewFileMenuFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<IntentServices> provider3) {
        return new NewFileMenuFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMIntentServices(NewFileMenuFragment newFileMenuFragment, IntentServices intentServices) {
        newFileMenuFragment.mIntentServices = intentServices;
    }
}
