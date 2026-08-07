package com.box.android.data.di;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesFirebaseRemoteConfigFactory implements Factory<FirebaseRemoteConfig> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvidesFirebaseRemoteConfigFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FirebaseRemoteConfig get() {
        return providesFirebaseRemoteConfig(this.module);
    }

    public static DataProvidesModule_ProvidesFirebaseRemoteConfigFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvidesFirebaseRemoteConfigFactory(module);
    }

    public static FirebaseRemoteConfig providesFirebaseRemoteConfig(DataProvidesModule instance) {
        return (FirebaseRemoteConfig) Preconditions.checkNotNullFromProvides(instance.providesFirebaseRemoteConfig());
    }
}
