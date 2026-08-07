package com.box.android.services;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class FirebaseTokenRegistration_Factory implements Factory<FirebaseTokenRegistration> {
    private final Provider<BoxApiPrivate> apiPrivateProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IMoCoBoxGlobalSettings> globalSettingsProvider;
    private final Provider<RegisterPushDeviceUseCase> registerPushDeviceUseCaseProvider;
    private final Provider<UpdateDeviceRegistrationUseCase> updateDeviceRegistrationUseCaseProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FirebaseTokenRegistration_Factory(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<FeatureFlips> provider3, Provider<RegisterPushDeviceUseCase> provider4, Provider<UpdateDeviceRegistrationUseCase> provider5, Provider<IMoCoBoxGlobalSettings> provider6) {
        this.userContextManagerProvider = provider;
        this.apiPrivateProvider = provider2;
        this.featureFlipsProvider = provider3;
        this.registerPushDeviceUseCaseProvider = provider4;
        this.updateDeviceRegistrationUseCaseProvider = provider5;
        this.globalSettingsProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FirebaseTokenRegistration get() {
        return newInstance(this.userContextManagerProvider.get(), this.apiPrivateProvider.get(), this.featureFlipsProvider.get(), this.registerPushDeviceUseCaseProvider.get(), this.updateDeviceRegistrationUseCaseProvider.get(), this.globalSettingsProvider.get());
    }

    public static FirebaseTokenRegistration_Factory create(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<FeatureFlips> provider3, Provider<RegisterPushDeviceUseCase> provider4, Provider<UpdateDeviceRegistrationUseCase> provider5, Provider<IMoCoBoxGlobalSettings> provider6) {
        return new FirebaseTokenRegistration_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FirebaseTokenRegistration newInstance(IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, FeatureFlips featureFlips, RegisterPushDeviceUseCase registerPushDeviceUseCase, UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        return new FirebaseTokenRegistration(iUserContextManager, boxApiPrivate, featureFlips, registerPushDeviceUseCase, updateDeviceRegistrationUseCase, iMoCoBoxGlobalSettings);
    }
}
