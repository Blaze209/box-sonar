package com.box.android.coreservices.models;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAccountManager_Manager_Factory implements Factory<BoxAccountManager.Manager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAccountManager.Manager get() {
        return newInstance();
    }

    public static BoxAccountManager_Manager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxAccountManager.Manager newInstance() {
        return new BoxAccountManager.Manager();
    }

    private static final class InstanceHolder {
        static final BoxAccountManager_Manager_Factory INSTANCE = new BoxAccountManager_Manager_Factory();

        private InstanceHolder() {
        }
    }
}
