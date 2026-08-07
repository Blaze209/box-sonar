package com.box.android.services;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class AppNotificationServices_Factory implements Factory<AppNotificationServices> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppNotificationServices get() {
        return newInstance();
    }

    public static AppNotificationServices_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppNotificationServices newInstance() {
        return new AppNotificationServices();
    }

    private static final class InstanceHolder {
        static final AppNotificationServices_Factory INSTANCE = new AppNotificationServices_Factory();

        private InstanceHolder() {
        }
    }
}
