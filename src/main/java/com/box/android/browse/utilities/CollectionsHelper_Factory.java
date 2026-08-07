package com.box.android.browse.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionsHelper_Factory implements Factory<CollectionsHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsHelper get() {
        return newInstance();
    }

    public static CollectionsHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CollectionsHelper newInstance() {
        return new CollectionsHelper();
    }

    private static final class InstanceHolder {
        static final CollectionsHelper_Factory INSTANCE = new CollectionsHelper_Factory();

        private InstanceHolder() {
        }
    }
}
