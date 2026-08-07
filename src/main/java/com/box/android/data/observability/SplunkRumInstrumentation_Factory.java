package com.box.android.data.observability;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class SplunkRumInstrumentation_Factory implements Factory<SplunkRumInstrumentation> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SplunkRumInstrumentation get() {
        return newInstance();
    }

    public static SplunkRumInstrumentation_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SplunkRumInstrumentation newInstance() {
        return new SplunkRumInstrumentation();
    }

    private static final class InstanceHolder {
        static final SplunkRumInstrumentation_Factory INSTANCE = new SplunkRumInstrumentation_Factory();

        private InstanceHolder() {
        }
    }
}
