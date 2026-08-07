package com.box.android.services;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class AppIntentServices_Factory implements Factory<AppIntentServices> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppIntentServices get() {
        return newInstance();
    }

    public static AppIntentServices_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppIntentServices newInstance() {
        return new AppIntentServices();
    }

    private static final class InstanceHolder {
        static final AppIntentServices_Factory INSTANCE = new AppIntentServices_Factory();

        private InstanceHolder() {
        }
    }
}
