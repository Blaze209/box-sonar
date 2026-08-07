package com.box.android.di;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.observability.appstart.BrowseTabAppStartDestinationPage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvidesBrowseTabAppStartDestinationPageFactory implements Factory<BrowseTabAppStartDestinationPage> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModule_Companion_ProvidesBrowseTabAppStartDestinationPageFactory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseTabAppStartDestinationPage get() {
        return providesBrowseTabAppStartDestinationPage(this.userContextManagerProvider.get());
    }

    public static BoxModule_Companion_ProvidesBrowseTabAppStartDestinationPageFactory create(Provider<IUserContextManager> provider) {
        return new BoxModule_Companion_ProvidesBrowseTabAppStartDestinationPageFactory(provider);
    }

    public static BrowseTabAppStartDestinationPage providesBrowseTabAppStartDestinationPage(IUserContextManager iUserContextManager) {
        return (BrowseTabAppStartDestinationPage) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.providesBrowseTabAppStartDestinationPage(iUserContextManager));
    }
}
