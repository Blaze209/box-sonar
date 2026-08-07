package com.box.android.data.service;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ContentFileService_Factory implements Factory<ContentFileService> {
    private final Provider<Context> contextProvider;

    private ContentFileService_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ContentFileService get() {
        return newInstance(this.contextProvider.get());
    }

    public static ContentFileService_Factory create(Provider<Context> contextProvider) {
        return new ContentFileService_Factory(contextProvider);
    }

    public static ContentFileService newInstance(Context context) {
        return new ContentFileService(context);
    }
}
