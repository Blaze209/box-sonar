package com.box.android.data.utilities;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LocalItemServiceItemsCreator_Factory implements Factory<LocalItemServiceItemsCreator> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private LocalItemServiceItemsCreator_Factory(Provider<IUserContextManager> userContextManagerProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalItemServiceItemsCreator get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static LocalItemServiceItemsCreator_Factory create(Provider<IUserContextManager> userContextManagerProvider) {
        return new LocalItemServiceItemsCreator_Factory(userContextManagerProvider);
    }

    public static LocalItemServiceItemsCreator newInstance(IUserContextManager userContextManager) {
        return new LocalItemServiceItemsCreator(userContextManager);
    }
}
