package com.box.android.localrepo;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class LocalSharedPreferences_Factory implements Factory<LocalSharedPreferences> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalSharedPreferences get() {
        return newInstance();
    }

    public static LocalSharedPreferences_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocalSharedPreferences newInstance() {
        return new LocalSharedPreferences();
    }

    private static final class InstanceHolder {
        static final LocalSharedPreferences_Factory INSTANCE = new LocalSharedPreferences_Factory();

        private InstanceHolder() {
        }
    }
}
