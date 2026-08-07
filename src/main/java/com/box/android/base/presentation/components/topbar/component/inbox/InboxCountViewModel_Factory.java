package com.box.android.base.presentation.components.topbar.component.inbox;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class InboxCountViewModel_Factory implements Factory<InboxCountViewModel> {
    private final Provider<InboxCountEnvironment> inboxCountEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private InboxCountViewModel_Factory(Provider<InboxCountEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.inboxCountEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxCountViewModel get() {
        return newInstance(this.inboxCountEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static InboxCountViewModel_Factory create(Provider<InboxCountEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new InboxCountViewModel_Factory(provider, provider2);
    }

    public static InboxCountViewModel newInstance(InboxCountEnvironment inboxCountEnvironment, IStoreFactory iStoreFactory) {
        return new InboxCountViewModel(inboxCountEnvironment, iStoreFactory);
    }
}
