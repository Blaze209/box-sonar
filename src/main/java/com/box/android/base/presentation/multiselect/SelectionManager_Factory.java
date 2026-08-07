package com.box.android.base.presentation.multiselect;

import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class SelectionManager_Factory implements Factory<SelectionManager> {
    private final Provider<BoxModelOfflineManager.Manager> offlineManagerProvider;
    private final Provider<BoxAccountManager.Manager> permissionsManagerProvider;

    private SelectionManager_Factory(Provider<BoxModelOfflineManager.Manager> provider, Provider<BoxAccountManager.Manager> provider2) {
        this.offlineManagerProvider = provider;
        this.permissionsManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SelectionManager get() {
        return newInstance(this.offlineManagerProvider.get(), this.permissionsManagerProvider.get());
    }

    public static SelectionManager_Factory create(Provider<BoxModelOfflineManager.Manager> provider, Provider<BoxAccountManager.Manager> provider2) {
        return new SelectionManager_Factory(provider, provider2);
    }

    public static SelectionManager newInstance(BoxModelOfflineManager.Manager manager, BoxAccountManager.Manager manager2) {
        return new SelectionManager(manager, manager2);
    }
}
