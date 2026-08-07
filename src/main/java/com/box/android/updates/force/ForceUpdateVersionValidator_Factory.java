package com.box.android.updates.force;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateVersionValidator_Factory implements Factory<ForceUpdateVersionValidator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateVersionValidator get() {
        return newInstance();
    }

    public static ForceUpdateVersionValidator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ForceUpdateVersionValidator newInstance() {
        return new ForceUpdateVersionValidator();
    }

    private static final class InstanceHolder {
        static final ForceUpdateVersionValidator_Factory INSTANCE = new ForceUpdateVersionValidator_Factory();

        private InstanceHolder() {
        }
    }
}
