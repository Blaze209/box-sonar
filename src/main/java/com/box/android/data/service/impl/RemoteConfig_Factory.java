package com.box.android.data.service.impl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RemoteConfig_Factory implements Factory<RemoteConfig> {
    private final Provider<FirebaseRemoteConfig> firebaseRemoteConfigProvider;
    private final Provider<ForceUpdateConfigSynchronizer> forceUpdateConfigSynchronizerProvider;

    private RemoteConfig_Factory(Provider<FirebaseRemoteConfig> firebaseRemoteConfigProvider, Provider<ForceUpdateConfigSynchronizer> forceUpdateConfigSynchronizerProvider) {
        this.firebaseRemoteConfigProvider = firebaseRemoteConfigProvider;
        this.forceUpdateConfigSynchronizerProvider = forceUpdateConfigSynchronizerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RemoteConfig get() {
        return newInstance(this.firebaseRemoteConfigProvider.get(), this.forceUpdateConfigSynchronizerProvider.get());
    }

    public static RemoteConfig_Factory create(Provider<FirebaseRemoteConfig> firebaseRemoteConfigProvider, Provider<ForceUpdateConfigSynchronizer> forceUpdateConfigSynchronizerProvider) {
        return new RemoteConfig_Factory(firebaseRemoteConfigProvider, forceUpdateConfigSynchronizerProvider);
    }

    public static RemoteConfig newInstance(FirebaseRemoteConfig firebaseRemoteConfig, ForceUpdateConfigSynchronizer forceUpdateConfigSynchronizer) {
        return new RemoteConfig(firebaseRemoteConfig, forceUpdateConfigSynchronizer);
    }
}
