package com.box.android.base.presentation.fragments;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BaseFTUX_FTUXFactory_Factory implements Factory<BaseFTUX.FTUXFactory> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BaseFTUX_FTUXFactory_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BaseFTUX.FTUXFactory get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static BaseFTUX_FTUXFactory_Factory create(Provider<IUserContextManager> provider) {
        return new BaseFTUX_FTUXFactory_Factory(provider);
    }

    public static BaseFTUX.FTUXFactory newInstance(IUserContextManager iUserContextManager) {
        return new BaseFTUX.FTUXFactory(iUserContextManager);
    }
}
