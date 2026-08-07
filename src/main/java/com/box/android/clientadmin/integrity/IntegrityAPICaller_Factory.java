package com.box.android.clientadmin.integrity;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class IntegrityAPICaller_Factory implements Factory<IntegrityAPICaller> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IntegrityAPICaller get() {
        return newInstance();
    }

    public static IntegrityAPICaller_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IntegrityAPICaller newInstance() {
        return new IntegrityAPICaller();
    }

    private static final class InstanceHolder {
        static final IntegrityAPICaller_Factory INSTANCE = new IntegrityAPICaller_Factory();

        private InstanceHolder() {
        }
    }
}
