package com.box.android.search.presentation.vm;

import com.box.android.cpl.IStoreFactory;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class NotesSearchViewModel_Factory implements Factory<NotesSearchViewModel> {
    private final Provider<SearchEnvironment> searchEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private NotesSearchViewModel_Factory(Provider<IStoreFactory> provider, Provider<SearchEnvironment> provider2) {
        this.storeFactoryProvider = provider;
        this.searchEnvironmentProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesSearchViewModel get() {
        return newInstance(this.storeFactoryProvider.get(), this.searchEnvironmentProvider.get());
    }

    public static NotesSearchViewModel_Factory create(Provider<IStoreFactory> provider, Provider<SearchEnvironment> provider2) {
        return new NotesSearchViewModel_Factory(provider, provider2);
    }

    public static NotesSearchViewModel newInstance(IStoreFactory iStoreFactory, SearchEnvironment searchEnvironment) {
        return new NotesSearchViewModel(iStoreFactory, searchEnvironment);
    }
}
