package com.box.android.data.persistence;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class ObservabilityDatabaseCreator_Factory implements Factory<ObservabilityDatabaseCreator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObservabilityDatabaseCreator get() {
        return newInstance();
    }

    public static ObservabilityDatabaseCreator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ObservabilityDatabaseCreator newInstance() {
        return new ObservabilityDatabaseCreator();
    }

    private static final class InstanceHolder {
        static final ObservabilityDatabaseCreator_Factory INSTANCE = new ObservabilityDatabaseCreator_Factory();

        private InstanceHolder() {
        }
    }
}
