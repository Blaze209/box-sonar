package com.box.android.coreservices.utilities.intune;

import android.content.Context;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.msal.MsalObservability;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class IntuneAuthManager_Factory implements Factory<IntuneAuthManager> {
    private final Provider<Context> contextProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IntuneComponentCreator> intuneComponentCreatorProvider;
    private final Provider<MsalObservability> msalObservabilityProvider;
    private final Provider<NotificationServices> notificationServicesProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private IntuneAuthManager_Factory(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<IntuneComponentCreator> provider3, Provider<NotificationServices> provider4, Provider<MsalObservability> provider5, Provider<IntentServices> provider6, Provider<FeatureFlips> provider7) {
        this.contextProvider = provider;
        this.userContextManagerProvider = provider2;
        this.intuneComponentCreatorProvider = provider3;
        this.notificationServicesProvider = provider4;
        this.msalObservabilityProvider = provider5;
        this.intentServicesProvider = provider6;
        this.featureFlipsProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IntuneAuthManager get() {
        return newInstance(this.contextProvider.get(), this.userContextManagerProvider.get(), this.intuneComponentCreatorProvider.get(), this.notificationServicesProvider.get(), this.msalObservabilityProvider.get(), this.intentServicesProvider.get(), this.featureFlipsProvider.get());
    }

    public static IntuneAuthManager_Factory create(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<IntuneComponentCreator> provider3, Provider<NotificationServices> provider4, Provider<MsalObservability> provider5, Provider<IntentServices> provider6, Provider<FeatureFlips> provider7) {
        return new IntuneAuthManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static IntuneAuthManager newInstance(Context context, IUserContextManager iUserContextManager, IntuneComponentCreator intuneComponentCreator, NotificationServices notificationServices, MsalObservability msalObservability, IntentServices intentServices, FeatureFlips featureFlips) {
        return new IntuneAuthManager(context, iUserContextManager, intuneComponentCreator, notificationServices, msalObservability, intentServices, featureFlips);
    }
}
