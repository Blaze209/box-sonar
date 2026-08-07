package com.box.android.browse.search;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FilesSearchViewModel_Factory implements Factory<FilesSearchViewModel> {
    private final Provider<FilesSearchEnvironment> filesSearchEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private FilesSearchViewModel_Factory(Provider<IStoreFactory> provider, Provider<FilesSearchEnvironment> provider2) {
        this.storeFactoryProvider = provider;
        this.filesSearchEnvironmentProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesSearchViewModel get() {
        return newInstance(this.storeFactoryProvider.get(), this.filesSearchEnvironmentProvider.get());
    }

    public static FilesSearchViewModel_Factory create(Provider<IStoreFactory> provider, Provider<FilesSearchEnvironment> provider2) {
        return new FilesSearchViewModel_Factory(provider, provider2);
    }

    public static FilesSearchViewModel newInstance(IStoreFactory iStoreFactory, FilesSearchEnvironment filesSearchEnvironment) {
        return new FilesSearchViewModel(iStoreFactory, filesSearchEnvironment);
    }
}
