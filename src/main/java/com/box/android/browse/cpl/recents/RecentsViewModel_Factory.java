package com.box.android.browse.cpl.recents;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentsViewModel_Factory implements Factory<RecentsViewModel> {
    private final Provider<RecentsEnvironment> recentsEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private RecentsViewModel_Factory(Provider<RecentsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.recentsEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentsViewModel get() {
        return newInstance(this.recentsEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static RecentsViewModel_Factory create(Provider<RecentsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new RecentsViewModel_Factory(provider, provider2);
    }

    public static RecentsViewModel newInstance(RecentsEnvironment recentsEnvironment, IStoreFactory iStoreFactory) {
        return new RecentsViewModel(recentsEnvironment, iStoreFactory);
    }
}
