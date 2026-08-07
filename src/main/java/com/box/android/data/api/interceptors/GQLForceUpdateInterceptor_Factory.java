package com.box.android.data.api.interceptors;

import com.box.android.domain.services.IForceUpdateCoordinator;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLForceUpdateInterceptor_Factory implements Factory<GQLForceUpdateInterceptor> {
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<Moshi> moshiProvider;

    private GQLForceUpdateInterceptor_Factory(Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider, Provider<Moshi> moshiProvider) {
        this.forceUpdateCoordinatorProvider = forceUpdateCoordinatorProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLForceUpdateInterceptor get() {
        return newInstance(this.forceUpdateCoordinatorProvider.get(), this.moshiProvider.get());
    }

    public static GQLForceUpdateInterceptor_Factory create(Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider, Provider<Moshi> moshiProvider) {
        return new GQLForceUpdateInterceptor_Factory(forceUpdateCoordinatorProvider, moshiProvider);
    }

    public static GQLForceUpdateInterceptor newInstance(IForceUpdateCoordinator forceUpdateCoordinator, Moshi moshi) {
        return new GQLForceUpdateInterceptor(forceUpdateCoordinator, moshi);
    }
}
