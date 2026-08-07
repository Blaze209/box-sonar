package com.box.android.activities.login;

import com.box.android.clientadmin.integrity.DeviceIntegrityVerifier;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IAuthenticationService;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class CustomOAuthActivity_MembersInjector implements MembersInjector<CustomOAuthActivity> {
    private final Provider<IntentServices> appIntentServiceProvider;
    private final Provider<IAuthenticationService> authRequestServiceProvider;
    private final Provider<IBVEManager> bveManagerProvider;
    private final Provider<DeviceIntegrityVerifier> deviceIntegrityVerifierProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<IMoCoAdminSettings> mAdminSettingsProvider;
    private final Provider<BoxApiPrivate> mApiPrivateProvider;
    private final Provider<ConfigManager> mConfigManagerProvider;
    private final Provider<DeviceId> mDeviceIdProvider;
    private final Provider<MetricsUseCase> mMetricsUseCaseProvider;
    private final Provider<ObservabilitySettingsManager> mObservabilityManagerProvider;
    private final Provider<IAppRestrictionsManager> mRestrictionsManagerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private CustomOAuthActivity_MembersInjector(Provider<IAppRestrictionsManager> provider, Provider<IntentServices> provider2, Provider<DeviceId> provider3, Provider<IUserContextManager> provider4, Provider<BoxApiPrivate> provider5, Provider<IMoCoAdminSettings> provider6, Provider<ConfigManager> provider7, Provider<MetricsUseCase> provider8, Provider<ObservabilitySettingsManager> provider9, Provider<DeviceIntegrityVerifier> provider10, Provider<IAuthenticationService> provider11, Provider<IUserContextManager> provider12, Provider<IBVEManager> provider13, Provider<IForceUpdateCoordinator> provider14, Provider<FeatureFlips> provider15) {
        this.mRestrictionsManagerProvider = provider;
        this.appIntentServiceProvider = provider2;
        this.mDeviceIdProvider = provider3;
        this.mUserContextManagerProvider = provider4;
        this.mApiPrivateProvider = provider5;
        this.mAdminSettingsProvider = provider6;
        this.mConfigManagerProvider = provider7;
        this.mMetricsUseCaseProvider = provider8;
        this.mObservabilityManagerProvider = provider9;
        this.deviceIntegrityVerifierProvider = provider10;
        this.authRequestServiceProvider = provider11;
        this.userContextManagerProvider = provider12;
        this.bveManagerProvider = provider13;
        this.forceUpdateCoordinatorProvider = provider14;
        this.featureFlipsProvider = provider15;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CustomOAuthActivity customOAuthActivity) {
        injectMRestrictionsManager(customOAuthActivity, this.mRestrictionsManagerProvider.get());
        injectAppIntentService(customOAuthActivity, this.appIntentServiceProvider.get());
        injectMDeviceId(customOAuthActivity, this.mDeviceIdProvider.get());
        injectMUserContextManager(customOAuthActivity, this.mUserContextManagerProvider.get());
        injectMApiPrivate(customOAuthActivity, this.mApiPrivateProvider.get());
        injectMAdminSettings(customOAuthActivity, this.mAdminSettingsProvider.get());
        injectMConfigManager(customOAuthActivity, this.mConfigManagerProvider.get());
        injectMMetricsUseCase(customOAuthActivity, this.mMetricsUseCaseProvider.get());
        injectMObservabilityManager(customOAuthActivity, this.mObservabilityManagerProvider.get());
        injectDeviceIntegrityVerifier(customOAuthActivity, this.deviceIntegrityVerifierProvider.get());
        injectAuthRequestService(customOAuthActivity, this.authRequestServiceProvider.get());
        injectUserContextManager(customOAuthActivity, this.userContextManagerProvider.get());
        injectBveManager(customOAuthActivity, this.bveManagerProvider.get());
        injectForceUpdateCoordinator(customOAuthActivity, this.forceUpdateCoordinatorProvider.get());
        injectFeatureFlips(customOAuthActivity, this.featureFlipsProvider.get());
    }

    public static MembersInjector<CustomOAuthActivity> create(Provider<IAppRestrictionsManager> provider, Provider<IntentServices> provider2, Provider<DeviceId> provider3, Provider<IUserContextManager> provider4, Provider<BoxApiPrivate> provider5, Provider<IMoCoAdminSettings> provider6, Provider<ConfigManager> provider7, Provider<MetricsUseCase> provider8, Provider<ObservabilitySettingsManager> provider9, Provider<DeviceIntegrityVerifier> provider10, Provider<IAuthenticationService> provider11, Provider<IUserContextManager> provider12, Provider<IBVEManager> provider13, Provider<IForceUpdateCoordinator> provider14, Provider<FeatureFlips> provider15) {
        return new CustomOAuthActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static void injectMRestrictionsManager(CustomOAuthActivity customOAuthActivity, IAppRestrictionsManager iAppRestrictionsManager) {
        customOAuthActivity.mRestrictionsManager = iAppRestrictionsManager;
    }

    public static void injectAppIntentService(CustomOAuthActivity customOAuthActivity, IntentServices intentServices) {
        customOAuthActivity.appIntentService = intentServices;
    }

    public static void injectMDeviceId(CustomOAuthActivity customOAuthActivity, DeviceId deviceId) {
        customOAuthActivity.mDeviceId = deviceId;
    }

    public static void injectMUserContextManager(CustomOAuthActivity customOAuthActivity, IUserContextManager iUserContextManager) {
        customOAuthActivity.mUserContextManager = iUserContextManager;
    }

    public static void injectMApiPrivate(CustomOAuthActivity customOAuthActivity, BoxApiPrivate boxApiPrivate) {
        customOAuthActivity.mApiPrivate = boxApiPrivate;
    }

    public static void injectMAdminSettings(CustomOAuthActivity customOAuthActivity, IMoCoAdminSettings iMoCoAdminSettings) {
        customOAuthActivity.mAdminSettings = iMoCoAdminSettings;
    }

    public static void injectMConfigManager(CustomOAuthActivity customOAuthActivity, ConfigManager configManager) {
        customOAuthActivity.mConfigManager = configManager;
    }

    public static void injectMMetricsUseCase(CustomOAuthActivity customOAuthActivity, MetricsUseCase metricsUseCase) {
        customOAuthActivity.mMetricsUseCase = metricsUseCase;
    }

    public static void injectMObservabilityManager(CustomOAuthActivity customOAuthActivity, ObservabilitySettingsManager observabilitySettingsManager) {
        customOAuthActivity.mObservabilityManager = observabilitySettingsManager;
    }

    public static void injectDeviceIntegrityVerifier(CustomOAuthActivity customOAuthActivity, DeviceIntegrityVerifier deviceIntegrityVerifier) {
        customOAuthActivity.deviceIntegrityVerifier = deviceIntegrityVerifier;
    }

    public static void injectAuthRequestService(CustomOAuthActivity customOAuthActivity, IAuthenticationService iAuthenticationService) {
        customOAuthActivity.authRequestService = iAuthenticationService;
    }

    public static void injectUserContextManager(CustomOAuthActivity customOAuthActivity, IUserContextManager iUserContextManager) {
        customOAuthActivity.userContextManager = iUserContextManager;
    }

    public static void injectBveManager(CustomOAuthActivity customOAuthActivity, IBVEManager iBVEManager) {
        customOAuthActivity.bveManager = iBVEManager;
    }

    public static void injectForceUpdateCoordinator(CustomOAuthActivity customOAuthActivity, IForceUpdateCoordinator iForceUpdateCoordinator) {
        customOAuthActivity.forceUpdateCoordinator = iForceUpdateCoordinator;
    }

    public static void injectFeatureFlips(CustomOAuthActivity customOAuthActivity, FeatureFlips featureFlips) {
        customOAuthActivity.featureFlips = featureFlips;
    }
}
