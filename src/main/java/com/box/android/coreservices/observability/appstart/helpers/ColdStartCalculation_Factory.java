package com.box.android.coreservices.observability.appstart.helpers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class ColdStartCalculation_Factory implements Factory<ColdStartCalculation> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ColdStartCalculation get() {
        return newInstance();
    }

    public static ColdStartCalculation_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ColdStartCalculation newInstance() {
        return new ColdStartCalculation();
    }

    private static final class InstanceHolder {
        static final ColdStartCalculation_Factory INSTANCE = new ColdStartCalculation_Factory();

        private InstanceHolder() {
        }
    }
}
