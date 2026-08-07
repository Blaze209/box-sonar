package com.box.android.data.service.impl;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AppRestrictionsManager_Factory implements Factory<AppRestrictionsManager> {
    private final Provider<Context> contextProvider;

    private AppRestrictionsManager_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppRestrictionsManager get() {
        return newInstance(this.contextProvider.get());
    }

    public static AppRestrictionsManager_Factory create(Provider<Context> contextProvider) {
        return new AppRestrictionsManager_Factory(contextProvider);
    }

    public static AppRestrictionsManager newInstance(Context context) {
        return new AppRestrictionsManager(context);
    }
}
