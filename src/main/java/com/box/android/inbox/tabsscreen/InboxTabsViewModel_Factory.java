package com.box.android.inbox.tabsscreen;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxTabsViewModel_Factory implements Factory<InboxTabsViewModel> {
    private final Provider<InboxTabsEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private InboxTabsViewModel_Factory(Provider<InboxTabsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxTabsViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static InboxTabsViewModel_Factory create(Provider<InboxTabsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new InboxTabsViewModel_Factory(provider, provider2);
    }

    public static InboxTabsViewModel newInstance(InboxTabsEnvironment inboxTabsEnvironment, IStoreFactory iStoreFactory) {
        return new InboxTabsViewModel(inboxTabsEnvironment, iStoreFactory);
    }
}
