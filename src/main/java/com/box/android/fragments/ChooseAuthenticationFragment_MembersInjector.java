package com.box.android.fragments;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ChooseAuthenticationFragment_MembersInjector implements MembersInjector<ChooseAuthenticationFragment> {
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;

    private ChooseAuthenticationFragment_MembersInjector(Provider<IMoCoBoxGlobalSettings> provider) {
        this.mGlobalSettingsProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ChooseAuthenticationFragment chooseAuthenticationFragment) {
        injectMGlobalSettings(chooseAuthenticationFragment, this.mGlobalSettingsProvider.get());
    }

    public static MembersInjector<ChooseAuthenticationFragment> create(Provider<IMoCoBoxGlobalSettings> provider) {
        return new ChooseAuthenticationFragment_MembersInjector(provider);
    }

    public static void injectMGlobalSettings(ChooseAuthenticationFragment chooseAuthenticationFragment, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        chooseAuthenticationFragment.mGlobalSettings = iMoCoBoxGlobalSettings;
    }
}
