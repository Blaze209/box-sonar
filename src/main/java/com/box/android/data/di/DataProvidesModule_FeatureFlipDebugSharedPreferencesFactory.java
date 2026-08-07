package com.box.android.data.di;

import android.content.SharedPreferences;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_FeatureFlipDebugSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final DataProvidesModule module;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DataProvidesModule_FeatureFlipDebugSharedPreferencesFactory(DataProvidesModule module, Provider<IUserContextManager> userContextManagerProvider) {
        this.module = module;
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedPreferences get() {
        return featureFlipDebugSharedPreferences(this.module, this.userContextManagerProvider.get());
    }

    public static DataProvidesModule_FeatureFlipDebugSharedPreferencesFactory create(DataProvidesModule module, Provider<IUserContextManager> userContextManagerProvider) {
        return new DataProvidesModule_FeatureFlipDebugSharedPreferencesFactory(module, userContextManagerProvider);
    }

    public static SharedPreferences featureFlipDebugSharedPreferences(DataProvidesModule instance, IUserContextManager userContextManager) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(instance.featureFlipDebugSharedPreferences(userContextManager));
    }
}
