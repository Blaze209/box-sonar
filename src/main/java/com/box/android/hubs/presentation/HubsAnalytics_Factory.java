package com.box.android.hubs.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsAnalytics_Factory implements Factory<HubsAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsAnalytics get() {
        return newInstance();
    }

    public static HubsAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HubsAnalytics newInstance() {
        return new HubsAnalytics();
    }

    private static final class InstanceHolder {
        static final HubsAnalytics_Factory INSTANCE = new HubsAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
