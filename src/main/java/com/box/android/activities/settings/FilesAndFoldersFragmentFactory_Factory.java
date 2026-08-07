package com.box.android.activities.settings;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FilesAndFoldersFragmentFactory_Factory implements Factory<FilesAndFoldersFragmentFactory> {
    private final Provider<IFilesAndFoldersSettingsStoreFactory> storeFactoryProvider;

    private FilesAndFoldersFragmentFactory_Factory(Provider<IFilesAndFoldersSettingsStoreFactory> provider) {
        this.storeFactoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesAndFoldersFragmentFactory get() {
        return newInstance(this.storeFactoryProvider.get());
    }

    public static FilesAndFoldersFragmentFactory_Factory create(Provider<IFilesAndFoldersSettingsStoreFactory> provider) {
        return new FilesAndFoldersFragmentFactory_Factory(provider);
    }

    public static FilesAndFoldersFragmentFactory newInstance(IFilesAndFoldersSettingsStoreFactory iFilesAndFoldersSettingsStoreFactory) {
        return new FilesAndFoldersFragmentFactory(iFilesAndFoldersSettingsStoreFactory);
    }
}
