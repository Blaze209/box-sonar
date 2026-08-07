package com.box.android.di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideGlobalSharedPreferencesFactory implements Factory<SharedPreferences> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedPreferences get() {
        return provideGlobalSharedPreferences();
    }

    public static BoxModule_Companion_ProvideGlobalSharedPreferencesFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SharedPreferences provideGlobalSharedPreferences() {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideGlobalSharedPreferences());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideGlobalSharedPreferencesFactory INSTANCE = new BoxModule_Companion_ProvideGlobalSharedPreferencesFactory();

        private InstanceHolder() {
        }
    }
}
