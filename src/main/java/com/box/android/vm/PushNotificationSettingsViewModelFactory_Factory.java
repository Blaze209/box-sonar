package com.box.android.vm;

import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class PushNotificationSettingsViewModelFactory_Factory implements Factory<PushNotificationSettingsViewModelFactory> {
    private final Provider<NotificationCategoriesUseCase> notificationCategoriesUseCaseProvider;

    private PushNotificationSettingsViewModelFactory_Factory(Provider<NotificationCategoriesUseCase> provider) {
        this.notificationCategoriesUseCaseProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PushNotificationSettingsViewModelFactory get() {
        return newInstance(this.notificationCategoriesUseCaseProvider.get());
    }

    public static PushNotificationSettingsViewModelFactory_Factory create(Provider<NotificationCategoriesUseCase> provider) {
        return new PushNotificationSettingsViewModelFactory_Factory(provider);
    }

    public static PushNotificationSettingsViewModelFactory newInstance(NotificationCategoriesUseCase notificationCategoriesUseCase) {
        return new PushNotificationSettingsViewModelFactory(notificationCategoriesUseCase);
    }
}
