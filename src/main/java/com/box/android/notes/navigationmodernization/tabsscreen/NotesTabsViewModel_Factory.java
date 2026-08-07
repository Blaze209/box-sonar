package com.box.android.notes.navigationmodernization.tabsscreen;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class NotesTabsViewModel_Factory implements Factory<NotesTabsViewModel> {
    private final Provider<NotesTabsEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private NotesTabsViewModel_Factory(Provider<NotesTabsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesTabsViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static NotesTabsViewModel_Factory create(Provider<NotesTabsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new NotesTabsViewModel_Factory(provider, provider2);
    }

    public static NotesTabsViewModel newInstance(NotesTabsEnvironment notesTabsEnvironment, IStoreFactory iStoreFactory) {
        return new NotesTabsViewModel(notesTabsEnvironment, iStoreFactory);
    }
}
