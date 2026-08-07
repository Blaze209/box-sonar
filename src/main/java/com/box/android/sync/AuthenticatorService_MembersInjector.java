package com.box.android.sync;

import com.box.android.coreservices.services.IntentServices;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AuthenticatorService_MembersInjector implements MembersInjector<AuthenticatorService> {
    private final Provider<IntentServices> mIntentServicesProvider;

    private AuthenticatorService_MembersInjector(Provider<IntentServices> provider) {
        this.mIntentServicesProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AuthenticatorService authenticatorService) {
        injectMIntentServices(authenticatorService, this.mIntentServicesProvider.get());
    }

    public static MembersInjector<AuthenticatorService> create(Provider<IntentServices> provider) {
        return new AuthenticatorService_MembersInjector(provider);
    }

    public static void injectMIntentServices(AuthenticatorService authenticatorService, IntentServices intentServices) {
        authenticatorService.mIntentServices = intentServices;
    }
}
