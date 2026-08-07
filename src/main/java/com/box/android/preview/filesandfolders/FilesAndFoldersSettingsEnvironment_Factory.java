package com.box.android.preview.filesandfolders;

import com.box.android.domain.services.IPreviewSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class FilesAndFoldersSettingsEnvironment_Factory implements Factory<FilesAndFoldersSettingsEnvironment> {
    private final Provider<IPreviewSettingsService> previewSettingsServiceProvider;

    private FilesAndFoldersSettingsEnvironment_Factory(Provider<IPreviewSettingsService> provider) {
        this.previewSettingsServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesAndFoldersSettingsEnvironment get() {
        return newInstance(this.previewSettingsServiceProvider.get());
    }

    public static FilesAndFoldersSettingsEnvironment_Factory create(Provider<IPreviewSettingsService> provider) {
        return new FilesAndFoldersSettingsEnvironment_Factory(provider);
    }

    public static FilesAndFoldersSettingsEnvironment newInstance(IPreviewSettingsService iPreviewSettingsService) {
        return new FilesAndFoldersSettingsEnvironment(iPreviewSettingsService);
    }
}
