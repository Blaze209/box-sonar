package com.box.android.data.service.impl;

import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BVEManager_Factory implements Factory<BVEManager> {
    private final Provider<IAppRestrictionsManager> appRestrictionsManagerProvider;
    private final Provider<ILocalSharedPreferences> localSharedPrefsProvider;

    private BVEManager_Factory(Provider<ILocalSharedPreferences> localSharedPrefsProvider, Provider<IAppRestrictionsManager> appRestrictionsManagerProvider) {
        this.localSharedPrefsProvider = localSharedPrefsProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BVEManager get() {
        return newInstance(this.localSharedPrefsProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static BVEManager_Factory create(Provider<ILocalSharedPreferences> localSharedPrefsProvider, Provider<IAppRestrictionsManager> appRestrictionsManagerProvider) {
        return new BVEManager_Factory(localSharedPrefsProvider, appRestrictionsManagerProvider);
    }

    public static BVEManager newInstance(ILocalSharedPreferences localSharedPrefs, IAppRestrictionsManager appRestrictionsManager) {
        return new BVEManager(localSharedPrefs, appRestrictionsManager);
    }
}
