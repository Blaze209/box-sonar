package com.box.android.inbox.notifications;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxViewModel_Factory implements Factory<InboxViewModel> {
    private final Provider<InboxEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private InboxViewModel_Factory(Provider<InboxEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static InboxViewModel_Factory create(Provider<InboxEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new InboxViewModel_Factory(provider, provider2);
    }

    public static InboxViewModel newInstance(InboxEnvironment inboxEnvironment, IStoreFactory iStoreFactory) {
        return new InboxViewModel(inboxEnvironment, iStoreFactory);
    }
}
