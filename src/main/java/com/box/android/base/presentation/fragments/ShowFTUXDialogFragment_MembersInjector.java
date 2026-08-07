package com.box.android.base.presentation.fragments;

import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class ShowFTUXDialogFragment_MembersInjector implements MembersInjector<ShowFTUXDialogFragment> {
    private final Provider<BaseFTUX.FTUXFactory> ftuxFactoryProvider;
    private final Provider<IntentServices> mIntentServicesProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private ShowFTUXDialogFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<IntentServices> provider2, Provider<BaseFTUX.FTUXFactory> provider3) {
        this.mUserContextManagerProvider = provider;
        this.mIntentServicesProvider = provider2;
        this.ftuxFactoryProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ShowFTUXDialogFragment showFTUXDialogFragment) {
        injectMUserContextManager(showFTUXDialogFragment, this.mUserContextManagerProvider.get());
        injectMIntentServices(showFTUXDialogFragment, this.mIntentServicesProvider.get());
        injectFtuxFactory(showFTUXDialogFragment, this.ftuxFactoryProvider.get());
    }

    public static MembersInjector<ShowFTUXDialogFragment> create(Provider<IUserContextManager> provider, Provider<IntentServices> provider2, Provider<BaseFTUX.FTUXFactory> provider3) {
        return new ShowFTUXDialogFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMUserContextManager(ShowFTUXDialogFragment showFTUXDialogFragment, IUserContextManager iUserContextManager) {
        showFTUXDialogFragment.mUserContextManager = iUserContextManager;
    }

    public static void injectMIntentServices(ShowFTUXDialogFragment showFTUXDialogFragment, IntentServices intentServices) {
        showFTUXDialogFragment.mIntentServices = intentServices;
    }

    public static void injectFtuxFactory(ShowFTUXDialogFragment showFTUXDialogFragment, BaseFTUX.FTUXFactory fTUXFactory) {
        showFTUXDialogFragment.ftuxFactory = fTUXFactory;
    }
}
