package com.box.android.domain.usecases.pushnotifications;

import com.box.android.domain.services.IPushNotificationSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class NotificationCategoriesInteractor_Factory implements Factory<NotificationCategoriesInteractor> {
    private final Provider<IPushNotificationSettingsService> serviceProvider;

    private NotificationCategoriesInteractor_Factory(Provider<IPushNotificationSettingsService> provider) {
        this.serviceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationCategoriesInteractor get() {
        return newInstance(this.serviceProvider.get());
    }

    public static NotificationCategoriesInteractor_Factory create(Provider<IPushNotificationSettingsService> provider) {
        return new NotificationCategoriesInteractor_Factory(provider);
    }

    public static NotificationCategoriesInteractor newInstance(IPushNotificationSettingsService iPushNotificationSettingsService) {
        return new NotificationCategoriesInteractor(iPushNotificationSettingsService);
    }
}
