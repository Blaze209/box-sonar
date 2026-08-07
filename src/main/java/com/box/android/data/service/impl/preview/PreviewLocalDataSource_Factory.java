package com.box.android.data.service.impl.preview;

import com.box.android.data.service.impl.OfflineService;
import com.box.android.domain.controller.IPreviewController;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewLocalDataSource_Factory implements Factory<PreviewLocalDataSource> {
    private final Provider<IPreviewController> legacyPreviewControllerProvider;
    private final Provider<OfflineService> offlineServiceProvider;

    private PreviewLocalDataSource_Factory(Provider<IPreviewController> legacyPreviewControllerProvider, Provider<OfflineService> offlineServiceProvider) {
        this.legacyPreviewControllerProvider = legacyPreviewControllerProvider;
        this.offlineServiceProvider = offlineServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewLocalDataSource get() {
        return newInstance(this.legacyPreviewControllerProvider.get(), this.offlineServiceProvider.get());
    }

    public static PreviewLocalDataSource_Factory create(Provider<IPreviewController> legacyPreviewControllerProvider, Provider<OfflineService> offlineServiceProvider) {
        return new PreviewLocalDataSource_Factory(legacyPreviewControllerProvider, offlineServiceProvider);
    }

    public static PreviewLocalDataSource newInstance(IPreviewController legacyPreviewController, OfflineService offlineService) {
        return new PreviewLocalDataSource(legacyPreviewController, offlineService);
    }
}
