package com.box.android.coreservices.models;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAccountSettings_Factory implements Factory<BoxAccountSettings> {
    private final Provider<IAppRestrictionsManager> restrictionManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxAccountSettings_Factory(Provider<IUserContextManager> provider, Provider<IAppRestrictionsManager> provider2) {
        this.userContextManagerProvider = provider;
        this.restrictionManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAccountSettings get() {
        return newInstance(this.userContextManagerProvider.get(), this.restrictionManagerProvider.get());
    }

    public static BoxAccountSettings_Factory create(Provider<IUserContextManager> provider, Provider<IAppRestrictionsManager> provider2) {
        return new BoxAccountSettings_Factory(provider, provider2);
    }

    public static BoxAccountSettings newInstance(IUserContextManager iUserContextManager, IAppRestrictionsManager iAppRestrictionsManager) {
        return new BoxAccountSettings(iUserContextManager, iAppRestrictionsManager);
    }
}
