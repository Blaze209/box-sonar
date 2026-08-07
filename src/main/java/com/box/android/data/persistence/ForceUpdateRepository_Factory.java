package com.box.android.data.persistence;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ForceUpdateRepository_Factory implements Factory<ForceUpdateRepository> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private ForceUpdateRepository_Factory(Provider<SharedPreferences> sharedPreferencesProvider) {
        this.sharedPreferencesProvider = sharedPreferencesProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateRepository get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }

    public static ForceUpdateRepository_Factory create(Provider<SharedPreferences> sharedPreferencesProvider) {
        return new ForceUpdateRepository_Factory(sharedPreferencesProvider);
    }

    public static ForceUpdateRepository newInstance(SharedPreferences sharedPreferences) {
        return new ForceUpdateRepository(sharedPreferences);
    }
}
