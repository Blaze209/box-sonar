package com.box.android.observability.appstart;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BrowseTabAppStartDestinationPage_Factory implements Factory<BrowseTabAppStartDestinationPage> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BrowseTabAppStartDestinationPage_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseTabAppStartDestinationPage get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static BrowseTabAppStartDestinationPage_Factory create(Provider<IUserContextManager> provider) {
        return new BrowseTabAppStartDestinationPage_Factory(provider);
    }

    public static BrowseTabAppStartDestinationPage newInstance(IUserContextManager iUserContextManager) {
        return new BrowseTabAppStartDestinationPage(iUserContextManager);
    }
}
