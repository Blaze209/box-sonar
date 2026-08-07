package com.box.android.models;

import com.box.android.controller.AndroidForWorkController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.usercontext.UserContext;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxSessionFactory_Factory implements Factory<BoxSessionFactory> {
    private final Provider<AndroidForWorkController> afWControllerProvider;
    private final Provider<DeviceId> deviceIdProvider;
    private final Provider<IMoCoBoxGlobalSettings> globalSettingsProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IAppRestrictionsManager> restrictionsManagerProvider;
    private final Provider<UserContext> userContextProvider;

    private BoxSessionFactory_Factory(Provider<IMoCoBoxGlobalSettings> provider, Provider<AndroidForWorkController> provider2, Provider<DeviceId> provider3, Provider<IntentServices> provider4, Provider<IAppRestrictionsManager> provider5, Provider<UserContext> provider6) {
        this.globalSettingsProvider = provider;
        this.afWControllerProvider = provider2;
        this.deviceIdProvider = provider3;
        this.intentServicesProvider = provider4;
        this.restrictionsManagerProvider = provider5;
        this.userContextProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxSessionFactory get() {
        return newInstance(this.globalSettingsProvider.get(), this.afWControllerProvider.get(), this.deviceIdProvider.get(), this.intentServicesProvider.get(), this.restrictionsManagerProvider.get(), this.userContextProvider.get());
    }

    public static BoxSessionFactory_Factory create(Provider<IMoCoBoxGlobalSettings> provider, Provider<AndroidForWorkController> provider2, Provider<DeviceId> provider3, Provider<IntentServices> provider4, Provider<IAppRestrictionsManager> provider5, Provider<UserContext> provider6) {
        return new BoxSessionFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BoxSessionFactory newInstance(IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, AndroidForWorkController androidForWorkController, DeviceId deviceId, IntentServices intentServices, IAppRestrictionsManager iAppRestrictionsManager, UserContext userContext) {
        return new BoxSessionFactory(iMoCoBoxGlobalSettings, androidForWorkController, deviceId, intentServices, iAppRestrictionsManager, userContext);
    }
}
