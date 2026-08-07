package com.box.android.updates.force.analytics;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateAnalytics_Factory implements Factory<ForceUpdateAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateAnalytics get() {
        return newInstance();
    }

    public static ForceUpdateAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ForceUpdateAnalytics newInstance() {
        return new ForceUpdateAnalytics();
    }

    private static final class InstanceHolder {
        static final ForceUpdateAnalytics_Factory INSTANCE = new ForceUpdateAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
