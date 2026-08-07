package com.box.android.vm;

import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class PushNotificationSettingsVM_Factory implements Factory<PushNotificationSettingsVM> {
    private final Provider<NotificationCategoriesUseCase> notificationCategoriesUseCaseProvider;

    private PushNotificationSettingsVM_Factory(Provider<NotificationCategoriesUseCase> provider) {
        this.notificationCategoriesUseCaseProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PushNotificationSettingsVM get() {
        return newInstance(this.notificationCategoriesUseCaseProvider.get());
    }

    public static PushNotificationSettingsVM_Factory create(Provider<NotificationCategoriesUseCase> provider) {
        return new PushNotificationSettingsVM_Factory(provider);
    }

    public static PushNotificationSettingsVM newInstance(NotificationCategoriesUseCase notificationCategoriesUseCase) {
        return new PushNotificationSettingsVM(notificationCategoriesUseCase);
    }
}
