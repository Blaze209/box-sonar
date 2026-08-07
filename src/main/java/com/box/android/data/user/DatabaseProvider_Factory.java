package com.box.android.data.user;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class DatabaseProvider_Factory implements Factory<DatabaseProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DatabaseProvider get() {
        return newInstance();
    }

    public static DatabaseProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DatabaseProvider newInstance() {
        return new DatabaseProvider();
    }

    private static final class InstanceHolder {
        static final DatabaseProvider_Factory INSTANCE = new DatabaseProvider_Factory();

        private InstanceHolder() {
        }
    }
}
