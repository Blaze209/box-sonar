package com.box.android.data.service;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadFileProvider_Factory implements Factory<UploadFileProvider> {
    private final Provider<Context> contextProvider;

    private UploadFileProvider_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadFileProvider get() {
        return newInstance(this.contextProvider.get());
    }

    public static UploadFileProvider_Factory create(Provider<Context> contextProvider) {
        return new UploadFileProvider_Factory(contextProvider);
    }

    public static UploadFileProvider newInstance(Context context) {
        return new UploadFileProvider(context);
    }
}
