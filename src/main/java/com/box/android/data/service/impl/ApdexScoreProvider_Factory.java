package com.box.android.data.service.impl;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ApdexScoreProvider_Factory implements Factory<ApdexScoreProvider> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<RemoteConfig> remoteConfigProvider;

    private ApdexScoreProvider_Factory(Provider<RemoteConfig> remoteConfigProvider, Provider<Moshi> moshiProvider) {
        this.remoteConfigProvider = remoteConfigProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ApdexScoreProvider get() {
        return newInstance(this.remoteConfigProvider.get(), this.moshiProvider.get());
    }

    public static ApdexScoreProvider_Factory create(Provider<RemoteConfig> remoteConfigProvider, Provider<Moshi> moshiProvider) {
        return new ApdexScoreProvider_Factory(remoteConfigProvider, moshiProvider);
    }

    public static ApdexScoreProvider newInstance(RemoteConfig remoteConfig, Moshi moshi) {
        return new ApdexScoreProvider(remoteConfig, moshi);
    }
}
