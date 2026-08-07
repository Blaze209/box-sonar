package com.box.android.preview.item.labels.offline;

import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.services.IOfflineService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewOfflineLabelEnvironment_Factory implements Factory<PreviewOfflineLabelEnvironment> {
    private final Provider<BoxModelOfflineManagerWrapper> boxModelOfflineManagerWrapperProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<IOfflineService> offlineServiceProvider;

    private PreviewOfflineLabelEnvironment_Factory(Provider<FileActionsManager> provider, Provider<IOfflineService> provider2, Provider<BoxModelOfflineManagerWrapper> provider3) {
        this.fileActionsManagerProvider = provider;
        this.offlineServiceProvider = provider2;
        this.boxModelOfflineManagerWrapperProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewOfflineLabelEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get(), this.offlineServiceProvider.get(), this.boxModelOfflineManagerWrapperProvider.get());
    }

    public static PreviewOfflineLabelEnvironment_Factory create(Provider<FileActionsManager> provider, Provider<IOfflineService> provider2, Provider<BoxModelOfflineManagerWrapper> provider3) {
        return new PreviewOfflineLabelEnvironment_Factory(provider, provider2, provider3);
    }

    public static PreviewOfflineLabelEnvironment newInstance(FileActionsManager fileActionsManager, IOfflineService iOfflineService, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        return new PreviewOfflineLabelEnvironment(fileActionsManager, iOfflineService, boxModelOfflineManagerWrapper);
    }
}
