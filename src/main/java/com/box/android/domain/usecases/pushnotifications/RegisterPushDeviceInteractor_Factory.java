package com.box.android.domain.usecases.pushnotifications;

import com.box.android.domain.services.IPushNotificationSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RegisterPushDeviceInteractor_Factory implements Factory<RegisterPushDeviceInteractor> {
    private final Provider<IPushNotificationSettingsService> serviceProvider;

    private RegisterPushDeviceInteractor_Factory(Provider<IPushNotificationSettingsService> provider) {
        this.serviceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RegisterPushDeviceInteractor get() {
        return newInstance(this.serviceProvider.get());
    }

    public static RegisterPushDeviceInteractor_Factory create(Provider<IPushNotificationSettingsService> provider) {
        return new RegisterPushDeviceInteractor_Factory(provider);
    }

    public static RegisterPushDeviceInteractor newInstance(IPushNotificationSettingsService iPushNotificationSettingsService) {
        return new RegisterPushDeviceInteractor(iPushNotificationSettingsService);
    }
}
