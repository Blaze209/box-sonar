package com.box.android.vm;

import com.box.android.repo.NotificationRegistrationCategoriesRepo;
import com.box.android.utilities.ISystemInfo;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class PushRegistrationDialogVM_Factory implements Factory<PushRegistrationDialogVM> {
    private final Provider<NotificationRegistrationCategoriesRepo> notificationCategoriesRepoProvider;
    private final Provider<ISystemInfo> systemInfoProvider;

    private PushRegistrationDialogVM_Factory(Provider<NotificationRegistrationCategoriesRepo> provider, Provider<ISystemInfo> provider2) {
        this.notificationCategoriesRepoProvider = provider;
        this.systemInfoProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PushRegistrationDialogVM get() {
        return newInstance(this.notificationCategoriesRepoProvider.get(), this.systemInfoProvider.get());
    }

    public static PushRegistrationDialogVM_Factory create(Provider<NotificationRegistrationCategoriesRepo> provider, Provider<ISystemInfo> provider2) {
        return new PushRegistrationDialogVM_Factory(provider, provider2);
    }

    public static PushRegistrationDialogVM newInstance(NotificationRegistrationCategoriesRepo notificationRegistrationCategoriesRepo, ISystemInfo iSystemInfo) {
        return new PushRegistrationDialogVM(notificationRegistrationCategoriesRepo, iSystemInfo);
    }
}
