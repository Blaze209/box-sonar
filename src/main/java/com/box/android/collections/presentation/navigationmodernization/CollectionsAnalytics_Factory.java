package com.box.android.collections.presentation.navigationmodernization;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionsAnalytics_Factory implements Factory<CollectionsAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsAnalytics get() {
        return newInstance();
    }

    public static CollectionsAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CollectionsAnalytics newInstance() {
        return new CollectionsAnalytics();
    }

    private static final class InstanceHolder {
        static final CollectionsAnalytics_Factory INSTANCE = new CollectionsAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
