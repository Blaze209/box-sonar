package com.box.android.data.datasource;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class VersionsPreviewCache_Factory implements Factory<VersionsPreviewCache> {
    private final Provider<Context> contextProvider;

    private VersionsPreviewCache_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VersionsPreviewCache get() {
        return newInstance(this.contextProvider.get());
    }

    public static VersionsPreviewCache_Factory create(Provider<Context> contextProvider) {
        return new VersionsPreviewCache_Factory(contextProvider);
    }

    public static VersionsPreviewCache newInstance(Context context) {
        return new VersionsPreviewCache(context);
    }
}
