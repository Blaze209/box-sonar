package com.box.android.base.presentation.activities;

import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.msal.MsalObservability;
import com.box.android.domain.services.IAuthenticationService;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxIntuneMAMAuthActivity_MembersInjector implements MembersInjector<BoxIntuneMAMAuthActivity> {
    private final Provider<IntentServices> appIntentServiceProvider;
    private final Provider<IAuthenticationService> authRequestServiceProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IntuneAuthManager> intuneAuthManagerProvider;
    private final Provider<MsalObservability> msalObservabilityProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxIntuneMAMAuthActivity_MembersInjector(Provider<IntuneAuthManager> provider, Provider<IntentServices> provider2, Provider<IAuthenticationService> provider3, Provider<IUserContextManager> provider4, Provider<MsalObservability> provider5, Provider<FeatureFlips> provider6) {
        this.intuneAuthManagerProvider = provider;
        this.appIntentServiceProvider = provider2;
        this.authRequestServiceProvider = provider3;
        this.userContextManagerProvider = provider4;
        this.msalObservabilityProvider = provider5;
        this.featureFlipsProvider = provider6;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity) {
        injectIntuneAuthManager(boxIntuneMAMAuthActivity, this.intuneAuthManagerProvider.get());
        injectAppIntentService(boxIntuneMAMAuthActivity, this.appIntentServiceProvider.get());
        injectAuthRequestService(boxIntuneMAMAuthActivity, this.authRequestServiceProvider.get());
        injectUserContextManager(boxIntuneMAMAuthActivity, this.userContextManagerProvider.get());
        injectMsalObservability(boxIntuneMAMAuthActivity, this.msalObservabilityProvider.get());
        injectFeatureFlips(boxIntuneMAMAuthActivity, this.featureFlipsProvider.get());
    }

    public static MembersInjector<BoxIntuneMAMAuthActivity> create(Provider<IntuneAuthManager> provider, Provider<IntentServices> provider2, Provider<IAuthenticationService> provider3, Provider<IUserContextManager> provider4, Provider<MsalObservability> provider5, Provider<FeatureFlips> provider6) {
        return new BoxIntuneMAMAuthActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectIntuneAuthManager(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, IntuneAuthManager intuneAuthManager) {
        boxIntuneMAMAuthActivity.intuneAuthManager = intuneAuthManager;
    }

    public static void injectAppIntentService(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, IntentServices intentServices) {
        boxIntuneMAMAuthActivity.appIntentService = intentServices;
    }

    public static void injectAuthRequestService(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, IAuthenticationService iAuthenticationService) {
        boxIntuneMAMAuthActivity.authRequestService = iAuthenticationService;
    }

    public static void injectUserContextManager(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, IUserContextManager iUserContextManager) {
        boxIntuneMAMAuthActivity.userContextManager = iUserContextManager;
    }

    public static void injectMsalObservability(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, MsalObservability msalObservability) {
        boxIntuneMAMAuthActivity.msalObservability = msalObservability;
    }

    public static void injectFeatureFlips(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, FeatureFlips featureFlips) {
        boxIntuneMAMAuthActivity.featureFlips = featureFlips;
    }
}
