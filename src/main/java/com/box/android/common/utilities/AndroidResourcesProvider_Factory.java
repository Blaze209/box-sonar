package com.box.android.common.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class AndroidResourcesProvider_Factory implements Factory<AndroidResourcesProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidResourcesProvider get() {
        return newInstance();
    }

    public static AndroidResourcesProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AndroidResourcesProvider newInstance() {
        return new AndroidResourcesProvider();
    }

    private static final class InstanceHolder {
        static final AndroidResourcesProvider_Factory INSTANCE = new AndroidResourcesProvider_Factory();

        private InstanceHolder() {
        }
    }
}
