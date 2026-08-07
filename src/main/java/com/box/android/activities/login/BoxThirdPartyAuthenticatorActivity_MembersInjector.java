package com.box.android.activities.login;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.services.IForceUpdateCoordinator;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxThirdPartyAuthenticatorActivity_MembersInjector implements MembersInjector<BoxThirdPartyAuthenticatorActivity> {
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;

    private BoxThirdPartyAuthenticatorActivity_MembersInjector(Provider<IMoCoBoxGlobalSettings> provider, Provider<IForceUpdateCoordinator> provider2) {
        this.mGlobalSettingsProvider = provider;
        this.forceUpdateCoordinatorProvider = provider2;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxThirdPartyAuthenticatorActivity boxThirdPartyAuthenticatorActivity) {
        injectMGlobalSettings(boxThirdPartyAuthenticatorActivity, this.mGlobalSettingsProvider.get());
        injectForceUpdateCoordinator(boxThirdPartyAuthenticatorActivity, this.forceUpdateCoordinatorProvider.get());
    }

    public static MembersInjector<BoxThirdPartyAuthenticatorActivity> create(Provider<IMoCoBoxGlobalSettings> provider, Provider<IForceUpdateCoordinator> provider2) {
        return new BoxThirdPartyAuthenticatorActivity_MembersInjector(provider, provider2);
    }

    public static void injectMGlobalSettings(BoxThirdPartyAuthenticatorActivity boxThirdPartyAuthenticatorActivity, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        boxThirdPartyAuthenticatorActivity.mGlobalSettings = iMoCoBoxGlobalSettings;
    }

    public static void injectForceUpdateCoordinator(BoxThirdPartyAuthenticatorActivity boxThirdPartyAuthenticatorActivity, IForceUpdateCoordinator iForceUpdateCoordinator) {
        boxThirdPartyAuthenticatorActivity.forceUpdateCoordinator = iForceUpdateCoordinator;
    }
}
