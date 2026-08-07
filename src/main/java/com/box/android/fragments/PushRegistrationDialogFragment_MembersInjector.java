package com.box.android.fragments;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PushRegistrationDialogFragment_MembersInjector implements MembersInjector<PushRegistrationDialogFragment> {
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;

    private PushRegistrationDialogFragment_MembersInjector(Provider<IMoCoBoxGlobalSettings> provider) {
        this.mGlobalSettingsProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PushRegistrationDialogFragment pushRegistrationDialogFragment) {
        injectMGlobalSettings(pushRegistrationDialogFragment, this.mGlobalSettingsProvider.get());
    }

    public static MembersInjector<PushRegistrationDialogFragment> create(Provider<IMoCoBoxGlobalSettings> provider) {
        return new PushRegistrationDialogFragment_MembersInjector(provider);
    }

    public static void injectMGlobalSettings(PushRegistrationDialogFragment pushRegistrationDialogFragment, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        pushRegistrationDialogFragment.mGlobalSettings = iMoCoBoxGlobalSettings;
    }
}
