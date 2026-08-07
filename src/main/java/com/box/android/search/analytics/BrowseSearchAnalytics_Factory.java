package com.box.android.search.analytics;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class BrowseSearchAnalytics_Factory implements Factory<BrowseSearchAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseSearchAnalytics get() {
        return newInstance();
    }

    public static BrowseSearchAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BrowseSearchAnalytics newInstance() {
        return new BrowseSearchAnalytics();
    }

    private static final class InstanceHolder {
        static final BrowseSearchAnalytics_Factory INSTANCE = new BrowseSearchAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
