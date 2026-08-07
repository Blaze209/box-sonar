package com.box.android.browse.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseFragmentFactory_Factory implements Factory<BrowseFragmentFactory> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseFragmentFactory get() {
        return newInstance();
    }

    public static BrowseFragmentFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BrowseFragmentFactory newInstance() {
        return new BrowseFragmentFactory();
    }

    private static final class InstanceHolder {
        static final BrowseFragmentFactory_Factory INSTANCE = new BrowseFragmentFactory_Factory();

        private InstanceHolder() {
        }
    }
}
