package com.box.android.domain.localrepo;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class HubsScreenPreferences_Factory implements Factory<HubsScreenPreferences> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private HubsScreenPreferences_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsScreenPreferences get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static HubsScreenPreferences_Factory create(Provider<IUserContextManager> provider) {
        return new HubsScreenPreferences_Factory(provider);
    }

    public static HubsScreenPreferences newInstance(IUserContextManager iUserContextManager) {
        return new HubsScreenPreferences(iUserContextManager);
    }
}
