package com.box.android.usercontext;

import android.content.Context;
import com.box.android.controller.AndroidForWorkController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase;
import com.box.android.models.BoxSessionFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class UserContextManager_Factory implements Factory<UserContextManager> {
    private final Provider<AndroidForWorkController> afWControllerProvider;
    private final Provider<Context> appContextProvider;
    private final Provider<IAppRestrictionsManager> appRestrictionsManagerProvider;
    private final Provider<BoxSessionFactory> boxSessionFactoryProvider;
    private final Provider<IBVEManager> bveManagerProvider;
    private final Provider<DeviceId> deviceIdProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IMoCoBoxGlobalSettings> globalSettingsProvider;
    private final Provider<IntuneAuthManager> intuneAuthManagerProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;
    private final Provider<RegisterPushDeviceUseCase> registerPushDeviceUseCaseProvider;
    private final Provider<UpdateDeviceRegistrationUseCase> updateDeviceRegistrationUseCaseProvider;

    private UserContextManager_Factory(Provider<Context> provider, Provider<AndroidForWorkController> provider2, Provider<IMoCoBoxGlobalSettings> provider3, Provider<DeviceId> provider4, Provider<BoxSessionFactory> provider5, Provider<RegisterPushDeviceUseCase> provider6, Provider<UpdateDeviceRegistrationUseCase> provider7, Provider<MetricsUseCase> provider8, Provider<IAppRestrictionsManager> provider9, Provider<IBVEManager> provider10, Provider<FeatureFlips> provider11, Provider<IntuneAuthManager> provider12) {
        this.appContextProvider = provider;
        this.afWControllerProvider = provider2;
        this.globalSettingsProvider = provider3;
        this.deviceIdProvider = provider4;
        this.boxSessionFactoryProvider = provider5;
        this.registerPushDeviceUseCaseProvider = provider6;
        this.updateDeviceRegistrationUseCaseProvider = provider7;
        this.metricsUseCaseProvider = provider8;
        this.appRestrictionsManagerProvider = provider9;
        this.bveManagerProvider = provider10;
        this.featureFlipsProvider = provider11;
        this.intuneAuthManagerProvider = provider12;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserContextManager get() {
        return newInstance(this.appContextProvider.get(), this.afWControllerProvider.get(), this.globalSettingsProvider.get(), this.deviceIdProvider.get(), this.boxSessionFactoryProvider.get(), DoubleCheck.lazy((Provider) this.registerPushDeviceUseCaseProvider), DoubleCheck.lazy((Provider) this.updateDeviceRegistrationUseCaseProvider), DoubleCheck.lazy((Provider) this.metricsUseCaseProvider), this.appRestrictionsManagerProvider.get(), this.bveManagerProvider.get(), DoubleCheck.lazy((Provider) this.featureFlipsProvider), DoubleCheck.lazy((Provider) this.intuneAuthManagerProvider));
    }

    public static UserContextManager_Factory create(Provider<Context> provider, Provider<AndroidForWorkController> provider2, Provider<IMoCoBoxGlobalSettings> provider3, Provider<DeviceId> provider4, Provider<BoxSessionFactory> provider5, Provider<RegisterPushDeviceUseCase> provider6, Provider<UpdateDeviceRegistrationUseCase> provider7, Provider<MetricsUseCase> provider8, Provider<IAppRestrictionsManager> provider9, Provider<IBVEManager> provider10, Provider<FeatureFlips> provider11, Provider<IntuneAuthManager> provider12) {
        return new UserContextManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static UserContextManager newInstance(Context context, AndroidForWorkController androidForWorkController, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, DeviceId deviceId, BoxSessionFactory boxSessionFactory, Lazy<RegisterPushDeviceUseCase> lazy, Lazy<UpdateDeviceRegistrationUseCase> lazy2, Lazy<MetricsUseCase> lazy3, IAppRestrictionsManager iAppRestrictionsManager, IBVEManager iBVEManager, Lazy<FeatureFlips> lazy4, Lazy<IntuneAuthManager> lazy5) {
        return new UserContextManager(context, androidForWorkController, iMoCoBoxGlobalSettings, deviceId, boxSessionFactory, lazy, lazy2, lazy3, iAppRestrictionsManager, iBVEManager, lazy4, lazy5);
    }
}
