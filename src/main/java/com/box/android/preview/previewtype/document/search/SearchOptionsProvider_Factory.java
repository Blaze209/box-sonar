package com.box.android.preview.previewtype.document.search;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class SearchOptionsProvider_Factory implements Factory<SearchOptionsProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchOptionsProvider get() {
        return newInstance();
    }

    public static SearchOptionsProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SearchOptionsProvider newInstance() {
        return new SearchOptionsProvider();
    }

    private static final class InstanceHolder {
        static final SearchOptionsProvider_Factory INSTANCE = new SearchOptionsProvider_Factory();

        private InstanceHolder() {
        }
    }
}
