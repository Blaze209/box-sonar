package com.box.android.activities.settings;

import com.box.android.domain.services.IPreviewSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FilesAndFoldersSettingsStoreFactory_Factory implements Factory<FilesAndFoldersSettingsStoreFactory> {
    private final Provider<IPreviewSettingsService> previewSettingsServiceProvider;

    private FilesAndFoldersSettingsStoreFactory_Factory(Provider<IPreviewSettingsService> provider) {
        this.previewSettingsServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesAndFoldersSettingsStoreFactory get() {
        return newInstance(this.previewSettingsServiceProvider.get());
    }

    public static FilesAndFoldersSettingsStoreFactory_Factory create(Provider<IPreviewSettingsService> provider) {
        return new FilesAndFoldersSettingsStoreFactory_Factory(provider);
    }

    public static FilesAndFoldersSettingsStoreFactory newInstance(IPreviewSettingsService iPreviewSettingsService) {
        return new FilesAndFoldersSettingsStoreFactory(iPreviewSettingsService);
    }
}
