package com.box.android.base.presentation.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class PermissionsHandler_Factory implements Factory<PermissionsHandler> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PermissionsHandler get() {
        return newInstance();
    }

    public static PermissionsHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PermissionsHandler newInstance() {
        return new PermissionsHandler();
    }

    private static final class InstanceHolder {
        static final PermissionsHandler_Factory INSTANCE = new PermissionsHandler_Factory();

        private InstanceHolder() {
        }
    }
}
