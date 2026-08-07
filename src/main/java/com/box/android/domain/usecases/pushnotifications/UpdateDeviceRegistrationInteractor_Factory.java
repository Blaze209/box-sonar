package com.box.android.domain.usecases.pushnotifications;

import com.box.android.domain.services.IPushNotificationSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UpdateDeviceRegistrationInteractor_Factory implements Factory<UpdateDeviceRegistrationInteractor> {
    private final Provider<IPushNotificationSettingsService> serviceProvider;

    private UpdateDeviceRegistrationInteractor_Factory(Provider<IPushNotificationSettingsService> provider) {
        this.serviceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateDeviceRegistrationInteractor get() {
        return newInstance(this.serviceProvider.get());
    }

    public static UpdateDeviceRegistrationInteractor_Factory create(Provider<IPushNotificationSettingsService> provider) {
        return new UpdateDeviceRegistrationInteractor_Factory(provider);
    }

    public static UpdateDeviceRegistrationInteractor newInstance(IPushNotificationSettingsService iPushNotificationSettingsService) {
        return new UpdateDeviceRegistrationInteractor(iPushNotificationSettingsService);
    }
}
