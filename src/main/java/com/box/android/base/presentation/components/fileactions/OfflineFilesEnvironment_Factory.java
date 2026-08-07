package com.box.android.base.presentation.components.fileactions;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.services.IOfflineService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class OfflineFilesEnvironment_Factory implements Factory<OfflineFilesEnvironment> {
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<IOfflineService> offlineServiceProvider;

    private OfflineFilesEnvironment_Factory(Provider<FileActionsManager> provider, Provider<IOfflineService> provider2) {
        this.fileActionsManagerProvider = provider;
        this.offlineServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflineFilesEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get(), this.offlineServiceProvider.get());
    }

    public static OfflineFilesEnvironment_Factory create(Provider<FileActionsManager> provider, Provider<IOfflineService> provider2) {
        return new OfflineFilesEnvironment_Factory(provider, provider2);
    }

    public static OfflineFilesEnvironment newInstance(FileActionsManager fileActionsManager, IOfflineService iOfflineService) {
        return new OfflineFilesEnvironment(fileActionsManager, iOfflineService);
    }
}
