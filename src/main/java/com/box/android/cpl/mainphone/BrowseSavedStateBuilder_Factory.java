package com.box.android.cpl.mainphone;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class BrowseSavedStateBuilder_Factory implements Factory<BrowseSavedStateBuilder> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseSavedStateBuilder get() {
        return newInstance();
    }

    public static BrowseSavedStateBuilder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BrowseSavedStateBuilder newInstance() {
        return new BrowseSavedStateBuilder();
    }

    private static final class InstanceHolder {
        static final BrowseSavedStateBuilder_Factory INSTANCE = new BrowseSavedStateBuilder_Factory();

        private InstanceHolder() {
        }
    }
}
